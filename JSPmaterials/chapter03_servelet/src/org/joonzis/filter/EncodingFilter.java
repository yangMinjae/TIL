package org.joonzis.filter;

import java.io.IOException;

import javax.servlet.*;

public class EncodingFilter implements Filter{
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 필터가 실제 구동되는 영역
		System.out.println("-----EncodingFilter doFilter() 동작중...");
		
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(encoding);
		}
		/*
		 * request.setCharacterEncoding(encoding);  // UTF-8 설정
		 * response.setCharacterEncoding(encoding);
		 * response.setContentType("text/html; charset=" + encoding);
		 * 모든 경우에 대해 적용하기 위해서는 이렇게 해야함.
		 * */
		chain.doFilter(request, response);
	}
	
}












