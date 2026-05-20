<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%	// jsp012_insert.jsp
	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");

	//2. request.getParameter() 이용해서 데이터 받기
	String oname = request.getParameter("oname");
	int onum     = Integer.parseInt(request.getParameter("onum"));
	String ip = InetAddress.getLocalHost().getHostAddress();
	
	/*out.print(oname +"/" + onum);  */
	//3. insert 구문처리
	try{
	//3-1. Class.forName
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//3-2 jdbc연동 DriverManager.getConnection
	Connection conn =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
	
	PreparedStatement pstmt = conn.prepareStatement("insert into milk_order(oname,onum,oip) values (?,?,?)");
	
	pstmt.setString(1, oname);
	pstmt.setInt(2, onum);
	pstmt.setString(3, ip);
	
	//3-3 insert executeUpdate
	int result = pstmt.executeUpdate();
	
	// 4. jsp012_milk.jsp 돌아가기
	if(result>0){
		out.println("<script> alert('저장성공!'); location.href = 'jsp012_milk.jsp';</script>");
	}else{
		out.println("<script> alert('관리자에게 문의하세요!'); location.href = 'jsp012_milk.jsp';</script>");
	}
	
	// jdbc 연동끊기 close
	if(pstmt != null){pstmt.close();}
	if(conn != null){conn.close();}
    
    
	}catch(Exception e){
	 e.printStackTrace();
	}	 
%>
