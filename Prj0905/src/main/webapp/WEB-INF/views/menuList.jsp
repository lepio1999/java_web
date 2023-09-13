<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import ="java.util.*" %>
      <%@page import ="burger.Burger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table>
<tr>
<td>code</td>
<td>메뉴이름</td>
<td>메뉴가격</td>
<td></td>
</tr>

<%
ArrayList<Burger> list =(ArrayList<Burger>)request.getAttribute("list");
for(Burger  s : list){
%>
<tr>
<td><%=s.getMenuCode() %></td>
<td><%=s.getMenuName() %></td>
<td><%=s.getMenuPrice() %></td>

</tr>
<%} %>

</table>

</body>
</html>