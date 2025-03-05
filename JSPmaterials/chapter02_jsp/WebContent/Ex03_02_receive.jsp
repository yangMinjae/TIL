
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	// name, age, pet, info
	// 단수 데이터 받을 때 : request.getParameter()
	// 복수 데이터 받을 때 : request.getParameterValues()
	// * 데이터는 문자열로 반환
	
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String[] pet = request.getParameterValues("pet");
	String info = request.getParameter("info");
	String pets = "";
	if(pet!=null){
		for(int i =0;i<pet.length;i++){
			if(i!=pet.length-1){
			pets+=pet[i]+", ";				
			}else{
				pets+=pet[i];
			}
		}
	}else{
		pets="없음";
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>이름 : <%=name %></li>
		<li>나이 : <%=age %></li>
		<li>자기소개 : <%=info %></li>
		<!-- 선택된 동물들 출력, 하나도 선택되지 않으면 "없음" 출력 -->
		<li>반려동물 : <%if(pet == null){ %>
						없음
					<%}else{
						for(int i =0;i<pet.length;i++){%>
						<%=pet[i] %>
					<% }}%>
		</li>
	</ul>
</body>
</html>