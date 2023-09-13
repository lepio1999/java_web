<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String id = (String) session.getAttribute("id");
	if (id != null) {
	%>

	로그아웃
	<%
	} else {
	%>
	로그인
	<%
	}
	%>

	<h2>empty : 값이 공백 , null 일때 true 반환</h2>
<c:if test="${empty id }">로그인 </c:if>
<c:if test="${not empty id }">로그아웃</c:if>

<h2> eq,ne 같다 , 같지않다</h2>
<c:set var="message" value="비로그인"/>
<c:if test="${message eq '비로그인' }">
<h3>로그인</h3>
</c:if>

<c:if test="${message ne '비로그인'}"></c:if>
<h3>로그아웃</h3>
<c:if test="${empty message }">
message없음
</c:if>
<c:if test="${empty message2 }">
message2없음
</c:if>


<c:set var="loginOut" value="${empty id ? 'login': 'logout' }"/>
${loginOut }

<c:set var="test2" value="acorn2"/>
<c:set var="result" value="${empty test2 ? 'test2없음' : '테스트2 가있다' }"/>

${result}
</body>
</html>