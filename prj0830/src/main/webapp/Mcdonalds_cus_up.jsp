<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*"%>
<%
String cust_code = request.getParameter("cust_code");


String cust_name = "";
String cust_adress = "";

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
	String sql = "select * from mc_customer where cust_code = '" + cust_code + "'";

	//5. 최종적으로 실행
	rs = st.executeQuery(sql);

	//6. 가져온 쿼리 결과를 화면에 출력하기
	while (rs.next()) {
		//out.print(rs.getString(1)); // out은 브라우저에 출력을 의미함
		//out.print(rs.getString(2));
		//out.print(rs.getString(3)+"<br>");
		cust_name = rs.getString(2);
		cust_adress = rs.getString(3);

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
<title>Insert title here</title>
</head>
<body>

<header><img src="https://arteepedicab.com/wp-content/uploads/2021/01/McDonalds-Logo.png" ></header>
<nav>
<a href="./Mcdonalds_cus_reg.jsp">고객 정보 등록 /</a>
<a href="./Mcdonalds_cus.jsp">고객 정보 조회&변경 /</a>
<a href="./index.jsp">홈으로</a>
</nav>


	<form name="frm" action="McCusUpdate_action.jsp" method="post">
		<table>

			<tr>
				<td>코드변경</td>
				<td><input type="text" readonly="readonly" name="cust_code"></td>
			</tr>

			<tr>
				<td>이름변경</td>
				<td><input type="text"  name="cust_name"></td>
			</tr>

			<tr>
				<td>주소변경</td>
				<td><input type="text" name="cust_adress"></td>
			</tr>
			<tr>

				<td><input type="submit" value="변경"></td>
			</tr>

		</table>
	</form>
	<script>
		let frm = document.frm;
		frm.cust_code.value="<%=cust_code%>";
		frm.cust_name.value="<%=cust_name%>";
		frm.cust_adress.value="<%=cust_adress%>";
	</script>
</body>
</html>

