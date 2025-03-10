<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 정보</title>
</head>
<body>
    <h2>로그인 성공!</h2>

    <%
        String id = (String) session.getAttribute("id");
        String pw = (String) session.getAttribute("pw");

        if (id == null || pw == null) {
            response.sendRedirect("/chapter03_servlet/login/loginPage.jsp");
            return;
        }
    %>

    <p>아이디: <%= id %></p>
    <p>비밀번호: <%= pw %></p>

</body>
</html>
