<%@page import="java.sql.*"%>
<%@page import="java.net.InetAddress"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<%
//utf-8 설정
	request.setCharacterEncoding("UTF-8");

int ono = Integer.parseInt(request.getParameter("updateOno"));
int onum = Integer.parseInt(request.getParameter("updateOnum"));
String oname = request.getParameter("updateOname");
String ip = InetAddress.getLocalHost().getHostAddress();

// out.println(onum + "/" + "oname");

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = 
		DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
	PreparedStatement pstmt = conn.prepareStatement("update milk_order set onum = ?, oname = ? where ono = ?");
	
	pstmt.setInt(1,onum);
	pstmt.setString(2,oname);
	pstmt.setInt(3,ono);
	
	int result = pstmt.executeUpdate();
	
	if(result > 0 ){
		out.println("<script> alert('수정성공!'); location.href = 'jsp012_milk.jsp';</script>");
	}else {
		out.println("<script> alert('관리자에게 문의하세요.'); location.href = 'jsp012_milk.jsp'; </script>");
	}
	
	if(pstmt != null){pstmt.close();}
	if(conn  != null){conn.close();}
	
}catch(Exception e){
	e.printStackTrace();
} 

%>
