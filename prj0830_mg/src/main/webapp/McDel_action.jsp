<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import="java.sql.*" %>
    
    <%
    String menu_code =request.getParameter("menu_code");
    
    Connection con=null;
	Statement st = null;

	try{ 
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="scott";
		String password="tiger";
		
		 //1. 오라클드라이버 로딩
		Class.forName(driver);
		 
		 //2. 데이터베이스 연결
		con= DriverManager.getConnection(url, user, password);
		 
		 //3. statement 얻어오기
		st = con.createStatement();
	
		 //4. 필요한 sql 작성
		String sql ="delete mc_menu where menu_code='"+menu_code+"'";
		st.executeUpdate(sql);
		 //5. 최종적으로 실행
		 
		 //6. 가져온 쿼리 결과를 화면에 출력하기
	

	}catch(Exception e){
		e.printStackTrace();
	}
	finally{ //자원의 반납
		
		if( st != null) st.close();
		if( con != null) con.close();
	}
	response.sendRedirect("Mcdonalds_list.jsp");
    %>