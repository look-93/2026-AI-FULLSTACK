<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");

String bpass = request.getParameter("bpass");

String url = "jdbc:mysql://localhost:3306/mbasic";
String user = "root", password = "1234";
PreparedStatement pstmt = null;

try{
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn = DriverManager.getConnection(url, user, password);
	
	pstmt = conn.prepareStatement("delete from users where bpass=?");
	
	pstmt.setString(1, bpass);
	
	int result = pstmt.executeUpdate();
	if(result>0){
		session.invalidate();
		out.println("<script>alert('탈퇴성공!'); location.href='login.jsp';</script>");
		
	}else{
		out.println("<script>alert('비밀번호확인하세요'); history.go(-1);</script>");
	}
	
	if(conn  != null) {conn.close();}
	if(pstmt != null) {pstmt.close();}
	
}catch(Exception e){
	e.printStackTrace();
}

%>