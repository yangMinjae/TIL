# 2025-03-12 복습

2025-03-12 복습

*pageContext.setAttribute("속성명", 값)을 통해 EL을 사용할 수 있다.
ex)
pageContext.setAttribute("name", a);
~
~
~
<body>
${name}		-> a값 출력
</body>

*EL에서 사용하는 4개 객체의 우선 순위
- pageContext, request, session, application 순서

ex)
	<%
		pageContext.setAttribute("car", "s-class");
		request.setAttribute("car", "e-class");
		session.setAttribute("car", "c-class");
		application.setAttribute("car", "a-class");
	%>
	
	<ul>
		<li> 그냥 호출 : ${car } </li>
		<li> pageContext : ${pageScope.car } </li>
		<li> request : ${requestScope.car } </li>
		<li> session : ${sessionScope.car } </li>
		<li> application: ${applicationScope.car } </li>
	</ul>

이와 같은 코드에서 ${car}를 호출 하면, pageContext, request, session, application 순서로 car라는 이름의 속성이 있는지 찾고 호출한다.

*get방식에서 queryString의 값을 가져와서 EL을 통해 출력하는 방법:
- parameter의 이름이 id 인 경우
-> ${param.id}
- parameter로 배열의 값을 받는경우 (ex) checkbox), name 값 fav
-> ${paramValues.fav[0]}
	${paramValues.fav[1]}
	${paramValues.fav[2]}
.
.
.
이때 전달된 fav파라미터 값들이 EL에 표시된 인덱스 값보다 작아도 nullpointer exception이나 arrayindexoutof bound 같은 오류가 발생하지않음.

*EL을 통해 cookie 값 출력
-> ${cookie."쿠키이름".value}

*request.setAttribute("속성명", 값)의 방식을 이용해서 배열도 전달할 수 있다.
-request.setAttribute("속성명", 배열)