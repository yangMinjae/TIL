<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 쿠키 값 변경은 덮어쓰기이다. 먼저 쿠키가 존재하는지 확인
		// 1. 이름이 name인 쿠키의 값을 "마이클 조던"으로 변경
		// 2. 유효 시간을 15일로 변경
		// 3. 쿠키 저장소에 저장
		// 4. "쿠키 값을 변경하였습니다." 출력
	
		Cookie[] cookieBox = request.getCookies();
	
		if(cookieBox != null && cookieBox.length > 0){
			for(int i=0; i<cookieBox.length; i++){
				if(cookieBox[i].getName().equals("name")){
					
					Cookie bisket = new Cookie(
					"name", URLEncoder.encode("마이클 조던", "utf-8"));
					bisket.setMaxAge(60 * 60 * 24 * 15);
					response.addCookie(bisket);
					out.print("쿠키 값을 변경하였습니다.<br>");
					out.print("쿠키 이름 : " + cookieBox[i].getName());
					out.print("<br>");
					out.print("쿠키 값 : " + 
					URLDecoder.decode(cookieBox[i].getValue(), "utf-8"));
					out.print("<br>");
				}
			}
		}else{
			out.print("쿠키가 존재하지 않습니다.");
		}
	%>
</body>
</html>