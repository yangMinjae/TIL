package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03_servlet")

public class Ex03_servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Ex03_servlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String query = request.getParameter("query");
		System.out.println("전달된 값은 "+query+"입니다.");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println("전달된 이름은 "+name+"이고.");
		System.out.println("나이는 "+age+"살 입니다.");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
