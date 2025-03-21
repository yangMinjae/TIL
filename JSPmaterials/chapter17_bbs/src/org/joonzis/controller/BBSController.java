package org.joonzis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.service.BService;
import org.joonzis.service.BServiceImpl;
import org.joonzis.vo.BVO;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/BBSController")
public class BBSController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BBSController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// 파일 업로드
		String realPath = request.getServletContext().getRealPath("/upload");
		
		// 파일 업로드 시 MultipartRequest 객체로 전달 받음
		MultipartRequest mr = null;
		// 분기 판단
		String cmd = request.getParameter("cmd");
		System.out.println("cmd : "+cmd);
		if(cmd==null) {
			cmd="allList";
		}
		
		// 화면 이동 / 서블릿 요청
		// 화면으로 즉 jsp파일로 이동하는 경우 forward로,
		// 서블릿을 태우고 싶은 경우에는 redirect 사용
		boolean isForward = true;
		// 이동 경로 path
		String path = "";
		// service 객체
		BService bservice = new BServiceImpl();
		// 리턴 객체
		int result = 0;
		List<BVO> list = null;
		switch (cmd) {
		case "allList":
			path = "bbs/allList.jsp";
			list = bservice.getList();
			request.setAttribute("list", list);
			break;
		case "insertBBSPage":
			path = "bbs/insert_page.jsp";
			break;
		case "insertSubmit":
			System.out.println(path);
			break;
		}
		
		if(isForward) {
			request.getRequestDispatcher(path).forward(request, response);
		}else {
			response.sendRedirect(path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
