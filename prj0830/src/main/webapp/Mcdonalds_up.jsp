<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*"%>
<%
String menu_code = request.getParameter("menu_code");
out.println(menu_code);

String menu_set = "";
String menu_price = "";

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
	String sql = "select * from mc_menu where menu_code = '" + menu_code + "'";

	//5. 최종적으로 실행
	rs = st.executeQuery(sql);

	//6. 가져온 쿼리 결과를 화면에 출력하기
	while (rs.next()) {
		//out.print(rs.getString(1)); // out은 브라우저에 출력을 의미함
		//out.print(rs.getString(2));
		//out.print(rs.getString(3)+"<br>");
		menu_set = rs.getString(2);
		menu_price = rs.getString(3);

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
<a href="./Mcdonalds_reg.html">세트 메뉴 등록 /</a>
<a href="./Mcdonalds_list.jsp">세트 메뉴 조회&변경 /</a>
<a href="./index.jsp">홈으로</a>
</nav>


	<form name="frm" action="McUpdate_action.jsp" method="post">
		<table>

			<tr>
				<td>메뉴코드</td>
				<td><input type="text" readonly="readonly" name="menu_code"></td>
			</tr>

			<tr>
				<td>세트메뉴이름</td>
				<td><input type="text"  readonly="readonly" name="menu_set"></td>
			</tr>

			<tr>
				<td>가격변경</td>
				<td><input type="text" name="menu_price"></td>
			</tr>
			<tr>

				<td colspan="2"><input type="submit" value="변경"></td>
			</tr>

		</table>
	</form>
	<script>
		let frm = document.frm;
		frm.menu_code.value="<%=menu_code%>";
		frm.menu_set.value="<%=menu_set%>";
		frm.menu_price.value="<%=menu_price%>";
	</script>
</body>
</html>

