<%@page import="java.sql.*"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
// insert into mvcboard1(bname, bpass, btitle, bcontent, bip) values(?,?,?,?)
request.setCharacterEncoding("UTF-8");

String bname    = request.getParameter("bname");
String bpass    = request.getParameter("bpass");
String btitle   = request.getParameter("btitle");
String bcontent = request.getParameter("bcontent");
String bip      = InetAddress.getLocalHost().getHostAddress();

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = 
		DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
	
	PreparedStatement pstmt = 
	    conn.prepareStatement("insert into mvcboard1(bname, bpass, btitle, bcontent, bip) values (?,?,?,?,?)");
	    
	pstmt.setString(1, bname);
	pstmt.setString(2, bpass);
	pstmt.setString(3, btitle);
	pstmt.setString(4, bcontent);
	pstmt.setString(5, bip);
	
	//executeUpdate
	int result = pstmt.executeUpdate();
	
	if(result > 0){
		out.println("<script> alert('저장성공!'); location.href = 'list.jsp';</script>");
	}else{
		out.println("<script> alert('저장실패! 관리자에게 문의하세요!'); location.href = 'write.jsp';</script>");
	}
	
	
	if(conn  != null){conn.close();}
	if(pstmt != null){pstmt.close();}	
	
}catch(Exception e){
	e.printStackTrace();
}

%>