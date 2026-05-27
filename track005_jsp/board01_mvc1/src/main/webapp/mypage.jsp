<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String email = request.getParameter("email");
String url = "jdbc:mysql://localhost:3306/mbasic";
String user = "root", password = "1234";
PreparedStatement pstmt = null;
String nickname = "";
String mobile = "";
String udate = "";
String bip = "";
String formatDate = "";

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url, user, password);
	pstmt = conn.prepareStatement(
	"select *, date_format(udate, '%Y-%m-%d %H:%i-%s') as formatDate from users where email=?");
	pstmt.setString(1, email);

	ResultSet rset = pstmt.executeQuery();

	while (rset.next()) {
		nickname = rset.getString("nickname");
		mobile = rset.getString("mobile");
		udate = rset.getString("udate");
		formatDate = rset.getString("formatDate");
		bip = rset.getString("bip");
		/* 				out.println("<tr>" 
						   + "<th>닉네임</th>"				
						   + "<td>" + nickname + "</td>"
						   + "</tr>"
						   + "<tr>" 
						   + "<th>이메일</th>"				
						   + "<td>" + email + "</td>"
						   + "</tr>"
						   + "<tr>" 
						   + "<th>휴대폰</th>"				
						   + "<td>" + mobile + "</td>"
						   + "</tr>"			   
						   + "<tr>" 
						   + "<th>가입일</th>"				
						   + "<td>" + formatDate + "</td>"
						   + "</tr>"				   
						   + "<tr>" 
						   + "<th>가입IP</th>"				
						   + "<td>" + bip + "</td>"
						   + "</tr>" 
						);	*/
	}

	if (rset != null) {
		rset.close();
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


<%@ include file="./inc/header.jsp"%>
<div class="container card my-5">
	<h3 class="card-header my-3">마이페이지</h3>
	<table class="table table-bordered">
		<tbody>
			<tr>
				<th>닉네임</th>
				<td><%=nickname%></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%=email%></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td><%=mobile%></td>
			</tr>
			<tr>
				<th>가입일</th>
				<td><%=formatDate%></td>
			</tr>
			<tr>
				<th>가입IP</th>
				<td><%=bip%></td>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="./inc/footer.jsp"%>