<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
String email = request.getParameter("email");
String bpass = request.getParameter("bpass");
String url = "jdbc:mysql://localhost:3306/mbasic"; 
String user = "root", password = "1234";
PreparedStatement pstmt = null;
ResultSet rset = null;
String nickname = "";

//out.println(email + " " + bpass);

try{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url, user, password);
	pstmt = conn.prepareStatement("select * from users where email=? and bpass=?");
	pstmt.setString(1, email);
	pstmt.setString(2, bpass);
	
	rset = pstmt.executeQuery();

	
	if(rset.next()){		
		session.setAttribute("email", email);
		//session.setAttribute("bpass", bpass);
		nickname = rset.getString("nickname");
		//request.getRequestDispatcher("jsp016_login.jsp").forward(request, response);
		out.println("<script>alert('환영합니다 고객님'); location.href = 'jsp016_login.jsp'; </script>");
		//response.sendRedirect("jsp016_login.jsp");
	}else{
		out.println("<script>alert('아이디/비밀번호를 확인하세요.'; history.go(-1); </script>");
	}
	
	if(pstmt != null){pstmt.close();}
	if(conn  != null){conn.close();}
	
}catch(Exception e){
	e.printStackTrace();	
}


%>
