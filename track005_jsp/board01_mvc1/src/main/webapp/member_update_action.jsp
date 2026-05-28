<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String email = request.getParameter("email");
String nickname = request.getParameter("nickname");
String bpass = request.getParameter("bpass");
String mobile = request.getParameter("mobile");

String url = "jdbc:mysql://localhost:3306/mbasic";
String user = "root", password = "1234";
PreparedStatement pstmt = null;

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url, user, password);
	pstmt = conn.prepareStatement("update users set nickname=?, bpass=?, mobile=? where email = ?");
	pstmt.setString(1, nickname);
	pstmt.setString(2, bpass);
	pstmt.setString(3, mobile);
	pstmt.setString(4, email);
	
	int result = pstmt.executeUpdate();
	
	if(result > 0){
		out.println("<script> alert('수정 성공!'); location.href = 'mypage.jsp'; </script>");
	}else {
		out.println("<script> alert('관리자에게 문의하세요.'); history.go(-1);  </script>");
	}

	if (pstmt != null) {
		pstmt.close();
	}
	if (conn != null) {
		conn.close();
	}

} catch (Exception e) {
	e.printStackTrace();
}

%>