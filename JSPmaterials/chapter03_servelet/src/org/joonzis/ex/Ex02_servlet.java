package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02_servlet")

public class Ex02_servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Ex02_servlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 제일먼저
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 웹 브라우저에 출력하기 위한 out 객체 생성
		PrintWriter out = response.getWriter();
		//---------------------------------------------
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		int d = cal.get(Calendar.DATE);
		String now = y +"년"+m+"월"+d+"일";
		out.print(now+"<br>");
		
		//---------------------------------------------
		// request 가 가지고 있는 기본 정보
		String url = request.getRemoteAddr();
		String host = request.getRemoteHost();
		String user = request.getRemoteUser();
		int port = request.getRemotePort();
		
		out.print("요청 주소 : "+url+"<br>");
		out.print("요청 호스트 : "+host+"<br>");
		out.print("요청 사용자 : "+user+"<br>");
		out.print("요청 포트 : "+port+"<br>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
