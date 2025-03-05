<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input, select{
		margin-bottom: 20px;
	}
	input[type=button], input[type=reset]{
		margin-top: 20px;
	}
</style>
</head>
<body>
	<form>
		이름: <input type="text" name = "name"><br>
		나이: <input type="text" name = "age"><br>
		전화번호: <input type="tel" name = "tel"><br>
		성별: 남<input type="radio" name="gender" value="남"> 여<input type="radio" name="gender" value="여"><br>
		취미: <input type="checkbox" name="hobbies">영화 <input type="checkbox" name="hobbies" value="게임">게임 <input type="checkbox" name="hobbies" value="독서">독서 <input type="checkbox" name="hobbies" value="여행">여행 <input type="checkbox" name="hobbies" value="기타">기타<br>
		주소: <select name="addr">
		<option value="서울">서울</option>
		<option value="경기">경기</option>
		<option value="전라">전라</option>
		<option value="충청">충청</option>
		<option value="경상">경상</option>
		</select><br>
		좋아하는 음식: <select name="foods" multiple="multiple" size="4">
		<option value="한식">한식</option>
		<option value="중식">중식</option>
		<option value="일식">일식</option>
		<option value="양식">양식</option>
		</select><br>
		<input type="hidden" name="nickname">
		<input type="button" value="전송" onclick="send(this.form);">
		<input type="reset" value="초기화">
	</form>
</body>
<script type="text/javascript">
	function send(f){
		f.action = 'Ex04_02_receive.jsp';
		f.submit();
	}
</script>
</html>