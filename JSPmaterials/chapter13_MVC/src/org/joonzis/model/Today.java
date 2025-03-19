package org.joonzis.model;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

public class Today {
	public String process(HttpServletRequest request) {
		Calendar cal = Calendar.getInstance();
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		int d = cal.get(Calendar.DATE);
		
		String today = y + "년 " + m + "월 " + d + "일";
		request.setAttribute("today", today);
		return "view/output.jsp";
	}
}
