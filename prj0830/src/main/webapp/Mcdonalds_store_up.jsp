<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*"%>
<%
String store_code = request.getParameter("store_code");


String store_loc = "";
String store_m = "";

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
	String sql = "select * from mc_store_loc where store_code = '" + store_code + "'";

	//5. 최종적으로 실행
	rs = st.executeQuery(sql);

	//6. 가져온 쿼리 결과를 화면에 출력하기
	while (rs.next()) {
		//out.print(rs.getString(1)); // out은 브라우저에 출력을 의미함
		//out.print(rs.getString(2));
		//out.print(rs.getString(3)+"<br>");
		store_loc = rs.getString(2);
		store_m = rs.getString(3);

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


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/Mcdonalds.css" rel="stylesheet" />
<link href="./css/index.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>

<header><img src="https://arteepedicab.com/wp-content/uploads/2021/01/McDonalds-Logo.png" ></header>
<nav>
<a href="./Mcdonalds_store_reg.jsp">고객 정보 등록 /</a>
<a href="./Mcdonalds_store.jsp">고객 정보 조회&변경 /</a>
<a href="./index.jsp">홈으로</a>
</nav>


	<form name="frm" action="McStoreUpdate_action.jsp" method="post">
		<table>

			<tr>
				<td>코드</td>
				<td><input type="text" readonly="readonly" name="store_code"></td>
			</tr>

			<tr>
				<td>지점명 변경</td>
				<td><input type="text"  name="store_loc"></td>
			</tr>

			<tr>
				<td>지점장 변경</td>
				<td><input type="text" name="store_m"></td>
			</tr>
			<tr>

				<td><input type="submit" value="변경"></td>
			</tr>

		</table>
	</form>
	<script>
		let frm = document.frm;
		frm.store_code.value="<%=store_code%>";
		frm.store_loc.value="<%=store_loc%>";
		frm.store_m.value="<%=store_m%>";
	</script>
</body>
</html>

