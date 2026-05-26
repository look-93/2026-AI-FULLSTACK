<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
request.setCharacterEncoding("UTF-8");
int bno = Integer.parseInt(request.getParameter("bno"));
String bpass = request.getParameter("bpass");
PreparedStatement pstmt = null;
String url = "jdbc:mysql://localhost:3306/mbasic";
String user = "root", pass = "1234";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");

	Connection conn = DriverManager.getConnection(url, user, pass);
	
	pstmt = conn.prepareStatement("delete from mvcboard1 where bno=? and bpass=?");
	
	pstmt.setInt(1, bno);
	pstmt.setString(2, bpass);
	
	int result = pstmt.executeUpdate();
	if(result>0){
		out.println("<script>alert('삭제성공!'); location.href='list.jsp';</script>");
		
	}else{
		out.println("<script>alert('비밀번호확인하세요'); history.go(-1);</script>");
	}
	
	if(conn  != null) {conn.close();}
	if(pstmt != null) {pstmt.close();}
	
}catch(Exception e){
	e.printStackTrace();
}

%>