<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/header.jsp"%>

<!--content-->
<!--영역잡고, 제목, 내용-->
<!--table, caption, thead/tbody-->
<div class="container my-5">
	<h3 class="text-center">MultiBoard</h3>
	<form action="write.jsp" method="post">
		<table
			class="table table-striped table-bordered table-hover table-light">
			<caption>BOARD목록</caption>
			<thead>
				<tr>
					<!--scope 읽히는 방향설정(보이진않지만 스크린리더기?에서 읽힐때사용)-->
					<th scope="col">NO</th>
					<th scope="col">TITLE</th>
					<th scope="col">WRITER</th>
					<th scope="col">DATE</th>
					<th scope="col">HIT</th>

				</tr>
			</thead>
			<tbody>
			<%
			try{
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rset = null;
					String sql = "select * from   mvcboard1 order by bno desc";
					String url = "jdbc:mysql://localhost:3306/mbasic";
					String user = "root", pass = "1234";

					Class.forName("com.mysql.cj.jdbc.Driver");

					conn = DriverManager.getConnection(url, user, pass);

					pstmt = conn.prepareStatement(sql);

					rset = pstmt.executeQuery(); // 표

					while (rset.next()) {
						out.println("<tr onclick='location.href=\"detail.jsp?bno=" + rset.getString("bno") + "\"'>"
								   + "<td>" + rset.getString("bno")    + "</td>" 
								   + "<td>" + rset.getString("btitle") + "</td>" 
								   + "<td>" + rset.getString("bname")  + "</td>" 
								   + "<td>" + rset.getDate("bdate")    + "</td>" 
								   + "<td>" + rset.getInt("bhit")      + "</td>" 
								   + "</tr>");
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
			</tbody>
		</table>
		<div class="text-end">
			<button type="submit" class="btn btn-light p-2 rounded text-dark">글쓰기</button>
		</div>
	</form>
</div>

<!--footer-->
<!--배경색상 글자색상 글자중앙정렬 안쪽여백-->
<%@include file="./inc/footer.jsp"%>

