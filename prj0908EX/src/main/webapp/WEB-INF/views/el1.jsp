<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Date"%>
<%@ page import="java.time.LocalDate"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>1 : 1~10까지 출력</h2>

	<c:forEach var="i" begin="1" end="10">
             ${i}
	</c:forEach>

	<h2>2 : 안녕하세요 5번 출력하기</h2>
	<c:set var="hi" value="안녕하세요">
	</c:set>
	<c:forEach var="i" begin="1" end="5">
		${i}
	</c:forEach>

	<h2>3 : 성적에 따라 A,B,V,F(70미만) 출력하기</h2>
	<c:set var="kor" value="90"></c:set>

	<c:choose>
		<c:when test="${kor>=90 }">A</c:when>
		<c:when test="${kor>=80 }">B</c:when>
		<c:when test="${kor>=70 }">C</c:when>
		<c:otherwise>F</c:otherwise>
	</c:choose>

	<h2>4 : 좋아하는것 배열 만들고 배열 요소 출력하기</h2>
	<c:forEach var="food" items="${food}">
			${food }
		</c:forEach>

	<h2>5 : 책이름배열 출력하기</h2>
	<c:forEach var="book" items="${book}">
		${book}
		</c:forEach>

	<h2>6 : 3단 출력하기</h2>
	<c:forEach var="i" begin="1" end="9">
		${i*3 }
	</c:forEach>
	<h2>7 : 전체 구구단 출력하기</h2>
	<c:forEach var="i" begin="2" end="9">
		<c:forEach var="j" begin="1" end="9">
	${i*j }
	</c:forEach>
	</c:forEach>

	<h2>8 : ArrayList에 커피정보 (Coffee 클래스 사용 ) 여러개를 저장하고 출력하기</h2>
	<c:forEach var="coffe" items="${coffes}">
		<p>${coffe.code}</p>
		<p>${coffe.name}</p>
		<p>${coffe.price }</p>
	</c:forEach>

	<h2>9: 로그인후 세션에 id값 저장하기 main화면의 상태가 로그인 여부에 따라 로그인, 로그아웃으로 나타나기</h2>
	<c:if test="${empty id }">로그아웃상태</c:if>
	<c:if test="${not empty id }">로그인상태</c:if>

	
</body>
</html>