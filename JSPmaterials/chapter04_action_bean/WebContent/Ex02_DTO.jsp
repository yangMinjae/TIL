<%@page import="org.joonzis.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 클래스 파일(bean)을 이용하여 데이터 저장, 사용
	MemberDTO m = new MemberDTO();

	m.setId("admin");
	m.setPw("1234");
	m.setName("김씨");
	m.setAge(50);
	m.setAddr("서울");
	m.setGender("남자");
	String[] h = {"게임", "수면"};
	m.setHobbies(h);
	String[] l = {"삼겹살", "라면", "치킨"};
	m.setLikeFoods(l);
	String[] dl = {"김치", "오이"};
	m.setDislikeFoods(dl);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>아이디 : <%=m.getId() %> </li>
		<li>비밀번호 : <%=m.getPw() %> </li>
		<li>이름 : <%=m.getName() %> </li>
		<li>나이 : <%=m.getAge() %> </li>
		<li>주소 : <%=m.getAddr() %> </li>
		<li>성별 : <%=m.getGender() %> </li>
		<li>
			취미 : 
			<%
				for(String hobby : m.getHobbies()){
					out.print(hobby + " ");
				}
			%>
		</li>
		<li>
			좋아하는 음식 : 
			<%
				for(String like : m.getLikeFoods()){
					out.print(like + " ");
				}
			%>
		</li>
		<li>
			싫어하는 음식 : 
			<%
				for(String dislike : m.getDislikeFoods()){
					out.print(dislike + " ");
				}
			%>
		</li>
	</ul>
</body>
</html>






