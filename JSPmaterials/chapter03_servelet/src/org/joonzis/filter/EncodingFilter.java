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
		chain.doFilter(request, response);
	}
	
}












