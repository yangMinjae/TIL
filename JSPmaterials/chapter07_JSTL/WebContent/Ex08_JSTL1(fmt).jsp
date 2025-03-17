<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="n" value="123456789.123456789"/>
	
	<h3>formatNumber의 groupingUsed</h3>
	천 단위 구분 기호 + 소수 3자리 :
	<fmt:formatNumber value="${n }"/> <br>
	천 단위 구분 기호없이 소수 3자리 :
	<fmt:formatNumber value="${n }" groupingUsed="No"/> <br>
	
	<hr>
	<h3>formatNumber의 pattern</h3>
	천 단위 구분 기호 + 소수 2자리 :
	<fmt:formatNumber value="${n }" pattern="#,##0.00"/> <br>
	천 단위 구분 기호 + 정수 :
	<fmt:formatNumber value="${n }" pattern="#,000" />
	
	<h3>formatNumber의 type</h3>
	퍼센트 : <fmt:formatNumber value="0.1" type="percent"/> <br>
	원화 표기 : <fmt:formatNumber value="${n }" type="currency" /> <br>
	달러 표기 : <fmt:formatNumber value="${n }" type="currency" currencySymbol="$"/> <br>
	
	<h3>parseNumber</h3>
	<c:set var="a" value="13"/>
	<fmt:parseNumber var="num1" value="${a }" integerOnly="true"/>
	
</body>
</html>