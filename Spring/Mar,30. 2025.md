# 2025-03-30 JSP 복습
# 1. jsp part
## 1)mapper xml의 파라미터는 대부분이 가능하고, 그중 Map 역시 가능하다.
```
<select id="select_dynamic" parameterType="Map" resultType="org.joonzis.vo.EmployeeVO">
```
* Map의 원소에 key 이름으로 접근이 가능하다
```
	<select id="select_dynamic" parameterType="Map" resultType="org.joonzis.vo.EmployeeVO">
		select* from employees where
		
		<choose>
			<when test="column == 1">
				 employee_id = #{val}
			</when>
			<when test="column == 2">
				 first_name = #{val}
			</when>
			<when test="column == 3">
				 last_name = #{val}
			</when>
			<when test="column == 4">
				 department_id = #{val}
			</when>
		</choose>
		
	</select>
```

* column과 val은 모두 key의 이름이다.
* mapper.xml파일에서 choose, when 태그가 이용 가능하다. 
* "column==1" 부분에서 1부분을 '작은따옴표'로 묶어주는것이 안전하다. 숫자의 경우에는 자동으로 형변환이 이루어지지만, 문자열의 경우에는 그렇지 않기 때문이다.

## 2) request.getQueryString(); 

* request.getQueryString(); 을 통해 쿼리 스트링 부분을 가져올 수 있다.

## 3) HttpServletRequest. getServletContext()
 - 서블릿 콘텍스트 객체를 리턴하고 이를 통해 컨텍스트 패스와 물리 경로 등을 얻을 수 있다.
 - request.getServletContext().getRealPath("/upload")  - > upload 폴더의 물리 경로를 반환
 - request.getServletContext().getContextPath() -> 컨텍스트 패스를 반환 ex) "/chapter17_bbs"

## 4) 파일업로드
```
<form method="post" enctype="multipart/form-data">
```

 - 파일업로드시 사용되는 폼.
 - 메서드는 무조건 post, enctype = "multipart/form-data"
 - 일반적인 request 객체로 파라미터를 받을 수 없다.
 - MultipartRequest 객체를 생성해 주어야 한다.
 	- 다음과 같은 방식으로 생성	
	```
		mr = new MultipartRequest(
				request,
				realPath,
				1024* 1024* 10,
				"utf-8",
				new DefaultFileRenamePolicy()
			);
	```
	- 이 중 realpath는 파일이 업로드될 경로이고, mr이 생성되는 순간 파일은 업로드 된다.
	- 1024x1024x10은 업로드 가능 최대 크기

## 5) forward 방식과 redirect 방식의 용도
- forward는 jsp, redirect는 서블릿으로 보낼때
- 쿼리 수행에 대해, 새로고침시 중복으로 쿼리가 일어나는것을 막기위해서는 redirect를 써야함 - ***중요***
- forward는 주소가 바뀌지 않고, redirect는 주소가 바뀜
- forward는 요청객체를 공유하고, redirect는 공유하지 않음

## 6)${bvo.filename eq null }
- EL에서는 ==대신 eq를 쓰자

## 7) 다음은 파일 업로드 수정 구문이다.
			File newFile = mr.getFile("filename");
			// 기존 첨부파일 이름
			String oldFile = mr.getParameter("oldfile");
			if(newFile!=null) {
				// 새 첨부 파일 o
				if(oldFile!=null) {
					File removeFile = new File(realPath+"/"+oldFile);
					if(removeFile.exists()) {
						removeFile.delete();
					}
				}
				bvo.setFilename(newFile.getName());
			}else {
				// 새 첨부 파일 x
				if(oldFile!=null) {
					// 기존 첨부파일 o
					bvo.setFilename(oldFile);
				}else {
					// 새 첨부파일, 기존 첨부파일x
					bvo.setFilename("");
				}
			}
## 8) js에서 쿼리스트링 가져오기
	const params = new URLSearchParams(location.search);
	const pageNum = params.get("pageNum");
	const amount  = params.get("amount");
- location.search는 쿼리스트링을 가져오고, URLSearchParms객체는 이를 key value형식으로 변형
- name=tom&age=20 같은 형식임. toString()을 해주면 앞의 내용과 같은 문자열 데이터가 됨

## 9) FormData도 key value 구조. 하지만 파일 저장 가능. 
- 다음과 같이 활용가능
```
	let formData = new FormData(f);
	let serializedData = new URLSearchParams(formData).toString();
```
## 10) 서블릿 비동기 처리 방식(쿼리 스트링)
```
JSONObject obj = new JSONObject();
PrintWriter out = response.getWriter();
String jsonString = null;
ObjectMapper objectMapper = new ObjectMapper();
~
~
~
jsonString = objectMapper.writeValueAsString(객체)		// 객체의 프로퍼티를 key-value값의 jsonString 형태로 변환 
														// 객체 list도 이용 가능
obj.put("속성이름", jsonString);	// 전달할 json데이터를 속성명에 저장, 속성명은 js에서 해당 결과 호출에 이용
out.print(obj);				// js로 다시 결과 반환
```
* js에서는 이렇게 받은 "속성이름"의 문자열값을 JSON.parse()를 통해 변환하여 사용(객체등이 넘어왔을경우에)
	
## 11) 서블릿 비동기 처리방식(json 형식 데이터를 받았을 때)
=> 
js에서 다음과 같이 데이터를 전송했을때
```
let formData = new FormData(f);
	
	// formdata to json
	let jsonData = JSON.stringify(
		Object.fromEntries(formData.entries())
	);

	// formData.entries 반복 가능한 형태로 꺼냄
	// Object.fromEntries 이터레이터를 일반 객체로 바꿔줌

	fetch(`MemberAsyncController`, {
			method : 'post',
			body : jsonData,
			headers : {
				'Content-type' : 'application/json; charset=utf-8'
			}
		})
```	
request의 파라미터로 데이터를 받아오지 못하므로,
서블릿에서는 아래와 같은 방법으로 데이터를 받아온다.
1) 필요 자원 준비
	```
		ObjectMapper objectMapper = null;
		String jsonString = null;
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		
		// json 데이터를 저장하기 위한 객체
		StringBuilder sb = new StringBuilder();

		// json 데이터가 들어오는 객체
		BufferedReader reader = request.getReader();

		String line;
	```
2) json 데이터를 Stringbuilder에 저장

		while((line = reader.readLine()) != null) {
			sb.append(line);
		}

3) json데이터를 자바 객체로 변환

		if(!sb.toString().isEmpty()) {
			try {
				obj = 
				(JSONObject)new JSONParser().parse(sb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

4) json형태의 데이터는 다음과 같이 받아온다.
	```
	변수 = (String)obj.get("cmd");
	변수 = (String)obj.get("mId");
	변수 = (String)obj.get("mPw");
	.
	.
	.
	```
