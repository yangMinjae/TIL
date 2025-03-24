package org.joonzis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.service.CService;
import org.joonzis.service.CServiceImpl;
import org.joonzis.vo.CVO;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String cmd = null;
		cmd = request.getParameter("cmd");
		
		// -----비동기를 처리하기 위해 선언하는 내용들
		// JSON과 java 객체들을 변환할 떄 사용
		ObjectMapper objectMapper = null;
		
		// JSON으로 직렬화 된 데이터를 담는용도
		String jsonString = null;
		
		// 응답 객체
		PrintWriter out = response.getWriter();
		
		// 응답 객체에 보내줄 객체
		JSONObject obj = new JSONObject();
		
		// DB 데이터 다루기 위한 객체
		CVO cvo = null;
		CService cservice = new CServiceImpl();
		int result;
		switch (cmd) {
		case "insertComment":
			cvo = new CVO();
			cvo.setWriter(request.getParameter("writer"));
			cvo.setPw(request.getParameter("pw"));
			cvo.setContent(request.getParameter("content"));
			cvo.setIp(Inet4Address.getLocalHost().getHostAddress());
			cvo.setB_idx(Integer.parseInt(request.getParameter("b_idx")));
			
			result = cservice.insertComment(cvo);
			System.out.println("result : "+result);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
