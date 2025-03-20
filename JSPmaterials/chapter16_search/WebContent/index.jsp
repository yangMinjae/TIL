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
		<h1>원하는 검색 버튼 클릭</h1>
		<table>
			<tr>
				<th>검색 버튼을 클릭하세요.</th>
			</tr>
			<tr>
				<td>
					<button onclick="search1()">전체 직원 보기</button>
					<button onclick="search2()">부서별 검색</button>
					<button onclick="search3()">동적 검색</button>
				</td>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript">
	function search1() {
		location.href = '/chapter16_search/Controller?cmd=allList';
	}
	function search2() {
		location.href = '/chapter16_search/Controller?cmd=inputDept';
	}
	function search3() {
		location.href = '/chapter16_search/Controller?cmd=inputDynamic';		
	}
</script>
</html>