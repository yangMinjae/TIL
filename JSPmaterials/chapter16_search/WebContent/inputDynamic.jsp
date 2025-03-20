<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
   div{
      width: 800px;
      text-align: center;
      margin: auto;
   }
   table{
      width: 100%;
      border-collapse: collapse;
   }
   th, td{
      border: 1px solid gray;
   }
   th{
      padding: 5px;
      background-color: darkslateblue;
      color: white;
   }
</style>
<body>
	<div>
		<form action="">
			<h1>무엇을 검색 하시겠습니까?</h1>
			<table>
				<tr>
					<th>검색 옵션</th>
				</tr>
				<tr>
					<td>
					선택 검색 : 
					<select name="column">
					
						<option value="0">::속성::</option>
						<option value="1">아이디</option>
						<option value="2">성</option>
						<option value="3">이름</option>
						<option value="4">부서</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>
					입력 : <input type="text" name="val">
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="전송" onclick="send(this.form)">
					</td>
				</tr>
			</table>
			<input type="hidden" name="cmd" value="dynamicList">
		</form>
	</div>
</body>
<script type="text/javascript">
	function send(f) {
		
		if(f.column.value==0){
			alert("검색 대상 속성을 선택해주세요");
			f.column.focus();
			return;
		}
		
		if(!f.val.value){
			alert("값을 입력해 주세요");
			f.val.focus();
			return;
		}
		f.action="/chapter16_search/Controller"
		f.submit();
	}
</script>
</html>