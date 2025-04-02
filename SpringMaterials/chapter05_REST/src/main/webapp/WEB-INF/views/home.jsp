
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
 <button id="btn">검증</button>
</body>
<script type="text/javascript">
	let btn = document.querySelector("#btn");
	btn.addEventListener('click', e=>{
		console.log('clicked');
	});
	
	fetch('test/ticket.json',{
		method : 'post',
		body : JSON.stringify({
			tno : 1,
			owner : 'kim',
			grade : 'gold'
		}),
		headers : {
			'Content-type' : 'application/json; charset=UTF-8'
		}
	})
	.then(response =>response.json())
	.then(result =>{
		console.log(result);
	})
	.catch(err =>console.log(err));
</script>
</html>
