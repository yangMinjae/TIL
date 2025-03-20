package org.joonzis.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joonzis.vo.PersonVo;

public class PersonAction {
	public String process(HttpServletRequest request) {
		
		// 파라미터들 가져오기
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String self = request.getParameter("self");
		
		// 1. request 객체에 저장
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("phone", phone);
		request.setAttribute("addr", addr);
		request.setAttribute("self", self);
		
		// 2. session 객체에 저장
		// session은 jsp 내장 객체라서 바로 사용할 수 없다.
		// java에서는 request를 통해 session을 가져온다.
		// session에 데이터를 담을 때 결과 확인을 위해 "session's"를 붙이자
		
		HttpSession session= request.getSession();
		session.setAttribute("name", "session's "+name);
		session.setAttribute("age", "session's "+age);
		session.setAttribute("phone", "session's "+phone);
		session.setAttribute("addr", "session's "+addr);
		session.setAttribute("self", "session's "+self);
		
		// 3. vo에 저장 후 request 객체에 저장
		
		PersonVo vo = new PersonVo(name, age, phone, addr, self);
		session.setAttribute("vo", vo);
		// 4. Map에 저장 후 session 객체에 저장
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("age", age);
		map.put("phone", phone);
		map.put("addr", addr);
		map.put("self", self);
		session.setAttribute("map", map);
		return "view/output.jsp";
	}
}
