<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");

String email = request.getParameter("email");
String bpass = request.getParameter("bpass");

String url = "jdbc:mysql://localhost:3306/mbasic";
String user = "root", password = "1234";
PreparedStatement pstmt = null;
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url, user, password);
	pstmt = conn.prepareStatement("select * from users where email= ? and bpass = ?");

	pstmt.setString(1, email);
	pstmt.setString(2, bpass);
	
	ResultSet rset = pstmt.executeQuery();
	if(rset.next()){
		session.setAttribute("email", email);
		out.println("<script> alert('로그인 성공!'); location.href = 'mypage.jsp'; </script>");
	}else {
		out.println("<script> alert('아이디/비밀번호를 확인하세요.'); history.go(-1);  </script>");
	}

	if(rset  != null){rset.close();}
	if(pstmt != null){pstmt.close();}
	if(conn  != null){conn.close();}
	
	
}catch(Exception e){
	e.printStackTrace();
}



%>