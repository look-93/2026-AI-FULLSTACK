<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
String email = request.getParameter("email");
String nickname = request.getParameter("nickname");

String url = "jdbc:mysql://localhost:3306/mbasic";
String user = "root", password = "1234";
PreparedStatement pstmt = null;

// out.println(email + " " + nickname);

try{
	String findEmail = "";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url, user, password);
	pstmt = conn.prepareStatement("select * from users where email=? and nickname=?");
	
	pstmt.setString(1, email);
	pstmt.setString(2, nickname);
	
	ResultSet rset = pstmt.executeQuery();
	if(rset.next()){
		findEmail = rset.getString("email");
		request.setAttribute("findEmail", findEmail);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		//response.sendRedirect("findId.jsp?findEmail="+findEmail);
	}else {
		out.println("<script> alert('아이디/닉네임을 확인하세요.'); history.go(-1); </script>");
	}
	
	if(rset  != null){rset.close();}
	if(pstmt != null){pstmt.close();}
	if(conn  != null){conn.close();}
	
}catch(Exception e){
	e.printStackTrace();
}


%>