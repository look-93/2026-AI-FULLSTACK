<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

int bno = Integer.parseInt(request.getParameter("bno"));

//out.println(bno); 
String bname = "";
String btitle = "";
String bcontent = "";
int bhit = 0;
String bpass = "";
try {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	String sql1 = "update mvcboard1 set bhit= bhit+1 where bno=?";
	String sql2 = "select * from mvcboard1 where bno=?";

	String url = "jdbc:mysql://localhost:3306/mbasic";
	String user = "root", pass = "1234";

	Class.forName("com.mysql.cj.jdbc.Driver");

	conn = DriverManager.getConnection(url, user, pass);

	pstmt = conn.prepareStatement(sql1);
	pstmt.setInt(1, bno);

	if (pstmt.executeUpdate() > 0) {
		pstmt.close();
	}

	pstmt = conn.prepareStatement(sql2);
	pstmt.setInt(1, bno);
	rset = pstmt.executeQuery();

	if (rset.next()) {
		bname = rset.getString("bname");
		btitle = rset.getString("btitle");
		bcontent = rset.getString("bcontent");
		bhit = rset.getInt("bhit");
		bpass = rset.getString("bpass");
	}

	if (rset != null) {
		rset.close();
	}
	if (conn != null) {
		conn.close();
	}
	if (pstmt != null) {
		pstmt.close();
	}

} catch (Exception e) {
	e.printStackTrace();
}
%>

<%@include file="./inc/header.jsp" %>

<div class="container card my-5">
		<h3 class="card-header my-3">Q N A 상 세 보 기</h3>

		 <!--  <form action="#" method="post" onsubmit="return check()">-->
			<div class="my-3">
				<label for="count">조회수</label>
				<P><%=bhit %></P>
			</div>
		
			<div class="my-3">
				<label for="bname">이름</label> <input type="text"
					class="form-control" id="bname" value="<%= bname %>" name="bname"  disabled/>
			</div>

			<div class="my-3">
				<label for=btitle></label>제목<input type="text"
					class="form-control" id="btitle" value="<%= btitle %>" name="btitle" disabled/>
			</div>

			<div class="my-3">
				<label for="bcontent">내용</label>
				<textarea class="form-control" rows="5" id="bcontent" name="bcontent" disabled><%= bcontent %></textarea>
			</div>
			<div class="my-3 text-end"> <!-- 비밀번호 맞으면 수정 삭제 가능하게  -->
				<a href="edit.jsp?bno=<%=bno%>" class="btn btn-light p-2 rounded text-dark" title="글수정">수정</a>
				<a href="delete.jsp?bno=<%=bno%>" class="btn btn-light p-2 rounded text-dark" title="글삭제">삭제</a>
				<a href="list.jsp" class="btn btn-light p-2 rounded text-dark"  title="목록보러가기">목록보기</a>
			</div>
		<!--</form>-->

	</div>
	
<%@include file="./inc/footer.jsp" %> 