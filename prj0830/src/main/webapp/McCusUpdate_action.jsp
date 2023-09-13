<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  page import="java.sql.*" %>
<!DOCTYPE html>
<%

//1.
request.setCharacterEncoding("UTF-8");

//2.
   String cust_code = request.getParameter("cust_code");
   String cust_name = request.getParameter("cust_name");
   String cust_adress = request.getParameter("cust_adress");
   

//데이터베이스 연결 , sql , update sql 실행


	Connection con =null;
	PreparedStatement st = null;
	
	try{ 
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		 //1. 오라클드라이버 로딩
		Class.forName(driver);
		 
		 //2. 데이터베이스 연결
		con= DriverManager.getConnection(url, user, password);
		 
		
		 //4. 필요한 sql 작성
		String sql= " update mc_customer "
				+	" set cust_adress = ?  ,"
				+	" cust_name = ? "			
				+	" where cust_code = ? ";
		 //3. prepareStatement 얻어오기
		st = con.prepareStatement(sql);

		st.setString(1, cust_adress );
		st.setString(2, cust_name );
		st.setString(3,cust_code);
		
		st.executeUpdate();
		
		 //5. 최종적으로 실행
		 
		 //6. 가져온 쿼리 결과를 화면에 출력하기
		
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{ //자원의 반납
	
		if( st != null) st.close();
		if( con != null) con.close();
	}


//
	response.sendRedirect("index.jsp");
    %>

