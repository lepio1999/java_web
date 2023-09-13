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


	<table><caption><h2>조회</h2></caption>
		<tr>
			<td>메뉴이름</td>
			<td>메뉴가격</td>
			<td>고객이름</td>
			<td>고객주소</td>
			<td>주문수량</td>
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
			String sql = "select m.MENU_SET ,"
					+ " TO_CHAR(m.MENU_PRICE, '999,999')||'원' AS 메뉴가격, "
					+ " c.CUST_NAME as 고객이름, "
					+ " c.CUST_ADRESS AS 고객주소, "
					+ " o.ORDER_SALE_CNT AS 주문수량 "
					+ " from mc_order o "
					+ " join MC_CUSTOMER c on o.ORDER_C_CODE = c.CUST_CODE "
					+ " join MC_MENU m on o.ORDER_M_CODE=m.MENU_CODE "
					+ " JOIN MC_STORE_LOC s on o.ORDER_S_CODE= s.STORE_CODE ";

			//5. 최종적으로 실행
			rs = st.executeQuery(sql);

			//6. 가져온 쿼리 결과를 화면에 출력하기
			while (rs.next()) {
		%>

		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
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

</body>
</html>