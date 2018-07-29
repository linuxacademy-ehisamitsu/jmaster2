<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("data1","This is sample0");
	request.setAttribute("data1","This is sample1");
	session.setAttribute("data1","This is sample2");
	application.setAttribute("data1", "This is sample3");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Sample1</title>
</head>
<body>
<h3>data1は${requestScope.data1}です</h3>
<h3>data2は${applicationScope.data1}です</h3>
</body>
</html>