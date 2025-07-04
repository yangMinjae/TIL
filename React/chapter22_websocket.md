# 웹소켓 정리
## 1) 프론트엔드
🧠 WebSocket 클라이언트 설명 (React + react-use-websocket 기준)
=========================================================

1. WebSocket URL 형식: ws:// 또는 wss://
---------------------------------------------------------
- `ws://` : 일반 WebSocket 연결 (HTTP)
- `wss://` : 보안 WebSocket 연결 (HTTPS)

※ 브라우저 보안 정책 상, 웹사이트가 https://인 경우 wss://를 사용해야 함.
예시:
- 개발 환경(localhost): ws://localhost:9090/ws/interview
- 배포 환경(SSL 적용 시): wss://yourdomain.com/ws/interview

---------------------------------------------------------

2. useWebSocket Hook 설명 (react-use-websocket)
---------------------------------------------------------
const {
  sendMessage,
  lastMessage,
  readyState,
} = useWebSocket(SOCKET_URL, options);

각 항목의 역할:

① sendMessage (function)
----------------------------
- 서버로 문자열 메시지를 전송하는 함수.
- 사용 예: sendMessage("안녕 GPT!");

② lastMessage (object)
----------------------------
- 서버로부터 마지막으로 수신된 메시지를 담고 있는 WebSocketMessage 객체.
- message.data로 실제 문자열 내용 접근 가능.
- 상태값이 아님: 새 메시지가 들어오면 자동으로 업데이트됨.

③ readyState (number)
----------------------------
- 현재 WebSocket 연결의 상태를 나타내는 값.
- 숫자 값이며, 다음과 같은 상태를 가짐:

  0: CONNECTING (연결 중)
  1: OPEN       (연결됨)
  2: CLOSING    (종료 중)
  3: CLOSED     (닫힘)

- 이 값을 통해 연결 여부를 조건 분기할 수 있음.
ex) readyState.OPEN

---------------------------------------------------------

3. Hook 옵션 설명
---------------------------------------------------------
공통 설정:
---------------------------------
- share: true
  → 여러 컴포넌트 간에 동일 WebSocket 인스턴스를 공유함

- shouldReconnect: () => true
  → 연결이 끊어졌을 때 자동으로 재연결 시도 여부

- reconnectAttempts: 5
  → 최대 5번까지 재연결 시도

콜백 함수:
---------------------------------
- onOpen: () => {...}
  → WebSocket 연결 성공 시 실행

- onError: (event) => {...}
  → WebSocket 에러 발생 시 실행

기타 제공되는 항목 (여기엔 포함 안 됐지만 사용 가능):
---------------------------------
- getWebSocket: 현재 WebSocket 인스턴스 직접 접근
- sendJsonMessage: JSON 객체를 서버로 전송 (내부적으로 stringify 처리)
- readyState 값에 대응되는 문자열 제공: ReadyState[readyState] 등

<br/>
<br/>
<br/>

## 2) 백엔드
## 2-1)CustomSpringConfigurator(설정 class)
```
package org.jobis.config;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import javax.websocket.server.ServerEndpointConfig;
public class CustomSpringConfigurator extends ServerEndpointConfig.Configurator{
	@Override
	public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
		try {
			T instance = endpointClass.getDeclaredConstructor().newInstance();
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(instance);
			return instance;
		} catch (Exception e) {
			throw new InstantiationException("WebSocket endpoint instance creation failed: " + e.getMessage());
		}
	}
}
```
----------------------------------------------------------
🧠 목적 (Why is it needed?)
----------------------------------------------------------
Spring 기반 애플리케이션에서 WebSocket의 @ServerEndpoint 클래스는
기본적으로 Spring의 관리 대상(Bean)이 아니기 때문에,
@Autowired, @Value 등의 의존성 주입(Dependency Injection)이 작동하지 않음.

이를 해결하기 위해 Spring의 ApplicationContext 기반 수동 주입을 수행하는 것이 목적.

즉, 이 Configurator는 WebSocket 클래스도 Spring처럼 의존성 주입을 받을 수 있게 해줌.

----------------------------------------------------------
🔧 주요 메서드: getEndpointInstance()
----------------------------------------------------------
@Override
public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException

- WebSocket 엔드포인트 클래스 인스턴스를 생성하고,
- SpringBeanAutowiringSupport를 이용해 의존성 주입을 수행함.

----------------------------------------------------------
✅ 사용 전제
----------------------------------------------------------
@ServerEndpoint(value="/ws", configurator=CustomSpringConfigurator.class)
이렇게 WebSocket 클래스에 Configurator로 지정해줘야 작동함

----------------------------------------------------------
🧠 한 줄 요약
----------------------------------------------------------
Spring 관리 대상이 아닌 WebSocket 클래스에 @Autowired 주입을 가능하게 해주는
"Spring-연동용 Configurator 클래스"

<br/>
<br/>
<br/>

## 2-2) 실제 핸들링 클래스
```
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.jobis.config.CustomSpringConfigurator;
import org.jobis.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/ws/interview", configurator = CustomSpringConfigurator.class)
@Component
public class InterviewSocket {
	
	private Session session;
	
	@Autowired
	private AiService aiService;
	
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		System.out.println("WebSocket 연결됨 : " + session.getId());
	}
	
	@OnMessage
	public void onMessage(String message) throws IOException{
		System.out.println("수신 메시지 : " + message);
		aiService.streamResultAsync(
				message,
				chunk ->{
					try {
						session.getBasicRemote().sendText(chunk);
					} catch (Exception e) {
						e.printStackTrace();
					}
				},
				() -> {
					try {
						session.getBasicRemote().sendText("[DONE]");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				);
		
	}
	
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		System.out.println("WebSocket 종료 : "+session.getId()+", 사유 : "+reason);
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		System.err.println("Websocket 오류 : "+throwable.getMessage());
	}
}
```

🧩 역할 요약
------------------------------------------
- WebSocket 통신을 처리하는 서버 측 클래스
- "/ws/interview" 경로로 클라이언트가 접속하면 실시간 양방향 메시지 송수신을 지원함
- 클라이언트 메시지를 받아 AI 서비스와 연동하고, 그 결과를 스트리밍 방식으로 클라이언트에 전달함

------------------------------------------
🔧 어노테이션 설명
------------------------------------------
- @ServerEndpoint("/ws/interview")
  → WebSocket 서버의 접속 경로 정의 (Spring Bean 아님)
  → configurator로 CustomSpringConfigurator.class를 지정해 Spring DI 가능하게 함

- @Component
  → Spring의 Bean으로 등록

- @Autowired
  → Spring의 AiService를 주입받아 사용

------------------------------------------
🧪 주요 콜백 메서드 설명
------------------------------------------
① @OnOpen
   public void onOpen(Session session)
   - 클라이언트가 WebSocket 연결을 열면 호출됨
   - 해당 session 객체를 멤버 변수에 저장 (후속 메시지 전송에 사용)

② @OnMessage
   public void onMessage(String message)
   - 클라이언트가 메시지를 보내면 호출됨
   - aiService.streamResultAsync(message, onChunk, onComplete) 호출
     - chunk마다 session.getBasicRemote().sendText(chunk)
     - 완료 시 "[DONE]" 메시지 전송

③ @OnClose
   public void onClose(Session session, CloseReason reason)
   - 클라이언트가 WebSocket 연결을 닫을 때 호출됨
   - 종료 로그 출력

④ @OnError
   public void onError(Session session, Throwable throwable)
   - 에러 발생 시 호출됨
   - 예외 메시지 출력

------------------------------------------
🎯 핵심 흐름 요약
------------------------------------------
1. 클라이언트가 /ws/interview로 연결
2. 연결이 열리면 onOpen 실행
3. 메시지를 보내면 onMessage 실행 → AI 서비스 호출 → 응답 스트리밍 전송
4. 연결 종료 시 onClose, 오류 시 onError 실행