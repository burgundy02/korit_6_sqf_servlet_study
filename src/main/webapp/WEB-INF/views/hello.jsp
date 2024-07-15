<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello jsp</h1>
	<% 
		// 스크립트릿: 자바 코드를 쓸 수 있음
		String name = request.getParameter("name");
		String age = request.getParameter("age");
	%>
	<h2><%=name %></h2>
	<h2><%=age %></h2>
</body>
</html>