<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		파일 업로드/다운로드
		
		1. cos.jar
		2. webContent > 폴더 생성 > 해당 위치를 업로드 위치로 사용
			=> 현 프로젝트에서 upload 폴더 생성
		3. <form method="post" enctype="multipart/form-data">
		4. 일반 request 대신 MultipartRequest 클래스 사용
	 -->
	 <div>
	 	<form action="upload.jsp" method="post" enctype="multipart/form-data">	<!-- file 업로드시 무조건 post -->
	 		<p>업로더 <input type="text" name="uploader"> </p>
	 		<p>첨부파일 <input type="file" name="filename"> </p>
	 		<input type="submit" value="업로드">
	 	</form>
	 </div>
</body>
</html>