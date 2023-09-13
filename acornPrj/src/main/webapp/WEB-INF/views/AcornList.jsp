<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="acornPrj.Acorn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table>
		<tr>
			<td>아이디</td>
			<td>비번</td>
			<td>이름</td>
			<td></td>
		</tr>

		<%
		ArrayList<Acorn> list = (ArrayList<Acorn>) request.getAttribute("list");
		for (Acorn s : list) {
		%>
		<tr>
			<td><%=s.getId()%></td>
			<td><%=s.getPw()%></td>
			<td><%=s.getName()%></td>

		</tr>
		<%
		}
		%>

	</table>

</body>
</html>