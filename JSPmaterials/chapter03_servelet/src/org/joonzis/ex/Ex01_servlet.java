package org.joonzis.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 서블릿 실행
 * 호스트이름:포트번호/프로젝트이름/서블릿
 * 호스트이름:포트번호/ContextPath/URLMapping
 * URLMapping의 기본값은 서블릿이다.
 * 서블릿 이름 = 본명, URLMapping = 별명
 * ex) localhost:9090/chapter03_servlet/Ex01_servlet
 */
@WebServlet("/Ex01_servlet")
// 어노테이션이 있어야함
public class Ex01_servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Ex01_servlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
