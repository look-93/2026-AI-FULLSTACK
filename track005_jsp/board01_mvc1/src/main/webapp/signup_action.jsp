<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%

request.setCharacterEncoding("UTF-8");

String nickname =  request.getParameter("nickname");
String bpass 	=  request.getParameter("bpass");
String email 	=  request.getParameter("email");
String mobile 	=  request.getParameter("mobile");
String bip = InetAddress.getLocalHost().getHostAddress();

String url = "jdbc:mysql://localhost:3306/mbasic";
String user = "root", password = "1234";
PreparedStatement pstmt = null;
String sql = "insert into users (nickname, bpass, email, mobile, bip) value(?,?,?,?,?)";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url, user, password);
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, nickname);
	pstmt.setString(2, bpass);
	pstmt.setString(3, email);
	pstmt.setString(4, mobile);
	pstmt.setString(5, bip);
	
	int result = pstmt.executeUpdate();
	if(result > 0 ){
		out.println("<script> alert('회원가입성공!'); location.href ='login.jsp'; </script>");
	}else {
		out.println("<script> alert('실패!'); history.go(-1); </script>");
	}
	
}catch(Exception e){
	e.printStackTrace();
}





%>