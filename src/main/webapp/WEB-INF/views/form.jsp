<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/dvd/form" method="post">
		<input name="username" value="admin">
		<input name="password" value="1234">
		<button>전송</button>
	</form>
	
	<form action="dvd/form" method="post">
		<input type="checkbox" name="chk" value="chk1">
		<input type="checkbox" name="chk" value="chk2">
		<input type="radio" name="rdo" value="rdo1">
		<input type="radio" name="rdo" value="rdo2">
		<button type="button">전송</button>
	</form>
	
	<button onclick="handleSubmitAllClick()">전체전송</button>
	
	
</body>
	<script src="/dvd/static/form.js"></script>
</html>