package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04_servlet")

public class Ex04_servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Ex04_servlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		out.print("id : "+id+"<br>");
		out.print("pw : "+pw+"<br>");
		out.print("이름 : "+name+"<br>");
		out.print("이메일 : "+email+"<br>");
		out.print("성별 : "+gender+"<br>");
		out.print("취미 : ");
		if(hobbies!=null) {
			for (int i = 0; i < hobbies.length; i++) {
				if(i!=hobbies.length-1) {				
					out.print(hobbies[i]+", ");
				}else {
					out.print(hobbies[i]);
				}
			}
		}else {
			out.print("없음");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
