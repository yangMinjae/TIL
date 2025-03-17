package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pagemove")
// 이름을 파일 이름과 다르게 한다면 url 경로가 localhost:9090/파일이름/pagemove와 같이 표시된다
public class Ex06_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex06_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		
		request.getRequestDispatcher("Ex06_output.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
