<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/Mcdonalds.css" rel="stylesheet" />
<title>Insert title here</title>

</head>

<body>
<div class="main">
<header><img src="https://arteepedicab.com/wp-content/uploads/2021/01/McDonalds-Logo.png" ></header>
<nav>
<a href="./Mcdonalds_reg.jsp">세트 메뉴 등록 /</a>
<a href="./Mcdonalds_list.jsp">세트 메뉴 조회&변경 /</a>
<a href="./index.jsp">홈으로</a>
</nav>

	<table>
		<caption>
			<h2>판매 세트 메뉴</h2>
		</caption>
		<tr>
			<td class="top">메뉴 코드</td>
			<td class="top">메뉴 이름</td>
			<td class="top">메뉴 가격</td>
			<td class="top" colspan='2' >정보 수정</td>
		</tr>


		<%
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String password = "tiger";

			//1. 오라클드라이버 로딩
			Class.forName(driver);

			//2. 데이터베이스 연결
			con = DriverManager.getConnection(url, user, password);

			//3. statement 얻어오기
			st = con.createStatement();

			//4. 필요한 sql 작성
			String sql = " select menu_code , " + "  menu_set ," + " TO_CHAR(MENU_PRICE, '999,999')||'원' AS 메뉴가격 "
			+ " from mc_menu ";

			//5. 최종적으로 실행
			rs = st.executeQuery(sql);

			//6. 가져온 쿼리 결과를 화면에 출력하기
			while (rs.next()) {
		%>

		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><a href="Mcdonalds_up.jsp?menu_code=<%=rs.getString(1)%>" class="id">수정</a></td>
			<td><a href="Mcdonalds_del.jsp?menu_code=<%=rs.getString(1)%>" class="id">삭제</a></td>
		</tr>

		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		} finally { //자원의 반납
		if (rs != null)
		rs.close();
		if (st != null)
		st.close();
		if (con != null)
		con.close();
		}
		%>
		
	</table>
<footer></footer>
</div>
</body>
</html>