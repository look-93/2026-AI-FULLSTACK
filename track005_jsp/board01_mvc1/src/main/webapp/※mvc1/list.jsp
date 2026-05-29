<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%int i=40/0;  %> 에러발생 테스트--%>
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
					<th scope="col">ORDERBY</th>
					<th scope="col">CNT</th>
					<th scope="col">NO</th>
					<th scope="col">TITLE</th>
					<th scope="col">WRITER</th>
					<th scope="col">DATE</th>
					<th scope="col">HIT</th>

				</tr>
			</thead>
			<tbody>
				<%
				try { 
							Connection conn = null;
							PreparedStatement pstmt = null;
							ResultSet rset = null;
							String sql = "select bno, btitle, bname, bdate, bhit, row_number() over(order by bno) as 'orderNum', (select count(*) from mvcboard1) as 'cnt'" 
									   + "from mvcboard1 order by bno desc";
							
							String url = "jdbc:mysql://localhost:3306/mbasic";
							String user = "root", pass = "1234";

							Class.forName("com.mysql.cj.jdbc.Driver");

							conn = DriverManager.getConnection(url, user, pass);
							
							//sql 구문처리
							//pstmt = conn.prepareStatement(sql);
							
							pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// 다시 처음으로 표부터 처리

							rset = pstmt.executeQuery(); // 표

		 					//1) 먼저 전체클 갯수 출력
							int cnt = -1;
							// 줄
							if(rset.next()){
								 cnt = rset.getInt("cnt"); // 칸
								 rset.beforeFirst(); // 다시 처음표부터 처리
							}
							 
							while (rset.next()) {
								out.println("<tr >"
										+ "<td>" + rset.getString("orderNum") +"</td>" 
										+ "<td>" + cnt-- + "</td>" 
										+ "<td>" + rset.getString("bno") + "</td>" + "<td>" + "<a href='detail.jsp?bno="
										+ rset.getInt("bno") + "'>" + rset.getString("btitle") + "</a></td>" + "<td>"
										+ rset.getString("bname") + "</td>" + "<td>" + rset.getDate("bdate") + "</td>" + "<td>"
										+ rset.getInt("bhit") + "</td>" + "</tr>");
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

