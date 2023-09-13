<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>에이콘 학생리스트</h2>






	<%
	ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");
	%>


	<%
	for (String name : list) {
		out.println(name);
	}
	%>


</body>
</html>