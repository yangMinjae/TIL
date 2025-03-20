package org.joonzis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.service.EmployeeService;
import org.joonzis.service.EmployeeServiceImpl;
import org.joonzis.vo.EmployeeVO;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String cmd = request.getParameter("cmd");
		
		// 공용 자원
		// 이동 경로로
		String path = "";
		// service 객체 생생성
		EmployeeService service = new EmployeeServiceImpl();
		// 리턴 객체
		List<EmployeeVO> list = null;
		
		EmployeeVO vo =null;
		
		switch (cmd) {
		case "allList":
			list = service.getAll();
			request.setAttribute("list", list);
			path = "allList.jsp";
			break;

		case "inputDept":
			path = "inputDept.jsp";
			break;
			
		case "inputDynamic":
			path = "inputDynamic.jsp";
			break;
		case "deptList":
			path = "deptList.jsp";
			int department_id = Integer.parseInt(request.getParameter("department_id")); 
			vo = new EmployeeVO();
			vo.setDepartment_id(department_id);
			list = service.getDeptList(vo);
			request.setAttribute("list", list);
			break;
			
		case "dynamicList":
			path = "dynamicList.jsp";
			Map<String, String> map = new HashMap<>();
			String column = request.getParameter("column");
			String val = request.getParameter("val");
			map.put("column", column);
			map.put("val", val);
			list = service.getDynamicList(map);
			request.setAttribute("list", list);
			break;
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
