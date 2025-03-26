package org.joonzis.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joonzis.service.MemberService;
import org.joonzis.service.MemberServiceImpl;
import org.joonzis.vo.MemberVO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/MemberAsyncController")
public class MemberAsyncController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberAsyncController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 쿼리 스트링으로 넘어오는 데이터는 파라미터로 받을 수 있지만,
		// json 데이터는 그렇지 못하기 때문에
		// 두 방식에 따라서 처리하는 방식이 바뀌게 된다.
		
		// 쿼리 스트링으로 들어오는 cmd를 저장하는 방식
		String cmd = request.getParameter("cmd");
		
		// 비동기를 처리하기 위한 내용들
		ObjectMapper objectMapper = null;
		String jsonString = null;
		PrintWriter out = response.getWriter();
		JSONObject obj = new JSONObject();
		
		// json 데이터를 저장하기 위한 객체
		StringBuilder sb = new StringBuilder();
		// json 데이터가 들어오는 객체
		BufferedReader reader = request.getReader();
		String line;
		
		// 1. json 데이터를 StringBuilder에 저장
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		// 데이터는 sb에 담겨진 상태이기 때문에 
		// 검증은 sb.toString()으로 문자열 출력하면 된다.
		
		// 2. json 데이터 자바 객체로 저장
		if(!sb.toString().isEmpty()) {
			try {
				obj = 
				(JSONObject)new JSONParser().parse(sb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(cmd == null) {
			// json으로 들어오는 cmd를 저장하는 방식
			cmd = (String)obj.get("cmd");
		}
		System.out.println("cmd : " + cmd);
		
		// 세션 객체 생성
		HttpSession session = request.getSession();
		MemberService mservice = new MemberServiceImpl();
		MemberVO mvo = null;
		
		switch(cmd) {
		case "validateId":
			String mId = request.getParameter("mId");
			obj.put("result", mservice.validateId(mId));
			break;
			
		case "join":
			mvo = new MemberVO();
			mvo.setmId((String)obj.get("mId"));
			mvo.setmPw((String)obj.get("mPw"));
			mvo.setmName((String)obj.get("mName"));
			mvo.setmEmail((String)obj.get("mEmail"));
			
			obj.put("result", mservice.insertMember(mvo));
			
			break;
		case "login":
			mvo = new MemberVO();
			mvo.setmId((String)obj.get("mId"));
			mvo.setmPw((String)obj.get("mPw"));
			obj.put("result", mservice.login(mvo));
		}
		out.print(obj);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
