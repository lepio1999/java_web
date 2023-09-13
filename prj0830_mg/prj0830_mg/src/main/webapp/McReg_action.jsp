<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page import="java.sql.*"%>

<%
    //jsp 내장객체
    //request, response ,out
    
    
    
    //0. 넘오은 값들에 대해서 인코딩 
    
    request.setCharacterEncoding("UTF-8");
    
    //1. 넘어온 값 꺼내기
    
   String menu_code = request.getParameter("menu_code");
   String menu_set = request.getParameter("menu_set");
   String menu_price = request.getParameter("menu_price");
   
   System.out.println(menu_code);
   System.out.println(menu_set);
   System.out.println(menu_price);
  
  
    //2. 데이터베이스 테이블에 insert
    
   
	Connection con=null;
	PreparedStatement st =null;

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
		String sql ="insert into mc_menu values(?,?,?)";
		
		st = con.prepareStatement(sql);
		st.setString(1, menu_code);
		st.setString(2, menu_set);
		st.setString(3, menu_price);
		
		 //4. 필요한 sql 작성
		 
		 //5. 최종적으로 실행
		st.executeUpdate();
		 
		 //6. 가져온 쿼리 결과를 화면에 출력하기
	

	}catch(Exception e){
		e.printStackTrace();
	}
	finally{ //자원의 반납
		if( st != null) st.close();
		if( con != null) con.close();
	}
%>



<%  
   //3. 특정페이지로 재요청 할수 있도록함
 //   response.sendRedirect("index.jsp");
    
    
    
response.sendRedirect("index.jsp");
%>