<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
    
<%

request.setCharacterEncoding("UTF-8");
int bno = Integer.parseInt(request.getParameter("bno"));

//out.println(bno);
String bpass = request.getParameter("bpass");
String btitle = request.getParameter("btitle");
String bcontent = request.getParameter("bcontent"); 

try{
	Connection conn = null;
	PreparedStatement pstmt = null;

	String url = "jdbc:mysql://localhost:3306/mbasic";
	String user = "root", pass = "1234";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, pass);
	
	pstmt = conn.prepareStatement("update mvcboard1 set btitle=?,bcontent=? where bno=? and bpass=?");
	pstmt.setString(1, btitle);
	pstmt.setString(2, bcontent);
	pstmt.setInt(3, bno);
	pstmt.setString(4, bpass);
	
	int result = pstmt.executeUpdate();

	if(result > 0){
		out.println("<script> alert('수정성공!'); location.href='detail.jsp?bno="+ bno +"';</script>");
		//request.getRequestDispatcher("detail.jsp?bno=" + bno).forward(request, response);
	}else {
		out.println("<script> alert('비민번호 확인하세요.'); history.go(-1);  </script>");
	}
	
	if(pstmt != null){pstmt.close();}
	if(conn != null){conn.close();}

}catch(Exception e){
	e.printStackTrace();
} 

%>