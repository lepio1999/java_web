<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="coffee.PageHandler"%>
<%@ page import="coffee.Coffee"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	PageHandler handler = (PageHandler) request.getAttribute("handler");
	ArrayList<Coffee> list = (ArrayList<Coffee>) request.getAttribute("list");
	%>

	<table>
		<tr>
			<td>코드</td>
			<td>이름</td>
			<td>가격</td>

		</tr>

		<%
		for (Coffee c : list) {
		%>

		<tr>
			<td><%=c.getCode()%></td>
			<td><%=c.getName()%></td>
			<td><%=c.getPrice()%></td>

		</tr>
		<%
		}
		%>
	</table>
	<%
	int index = handler.getGrpStartPage();
	if (handler.getCurrentGrp() > 1) {
	%>
	<a href="/pageCoffee/list4.page?p=<%=index - 1%>">[이전]</a>
	<%
	}
	while (index <= handler.getGrpEndPage()) {
	%>
	<a href="/pageCoffee/list4.page?p=<%=index%>"> [ <%=index%> ]
	</a>
	<%
	index++;
	}
	if (handler.getGrpEndPage() < handler.getTotalPage()) {
	%>
	<a href="/pageCoffee/list4.page?p=<%=handler.getGrpEndPage() + 1%>">다음</a>
	<%
	}
	%>



</body>
</html>