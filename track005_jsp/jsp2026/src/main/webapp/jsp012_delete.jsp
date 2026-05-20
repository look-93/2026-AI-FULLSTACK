<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
// UTF-8
request.setCharacterEncoding("UTF-8");

int ono = Integer.parseInt(request.getParameter("deleteOno"));

try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = 
		DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
	
	PreparedStatement pstmt = conn.prepareStatement("delete from milk_order where ono = ?");
	
	pstmt.setInt(1, ono);
	
	int result = pstmt.executeUpdate();
	
	if(result > 0){
		out.println("<script>alert('삭제성공!'); location.href = 'jsp012_milk.jsp'; </script>");
	}else{
		out.println("<script>alert('관리자에게 문의하세요.'); location.href = 'jsp012_milk.jsp'; </script>");
	}
	
	if(pstmt != null){pstmt.close();}
	if(conn  != null){conn.close();}
	
}catch(Exception e){
	e.printStackTrace();
}

%>