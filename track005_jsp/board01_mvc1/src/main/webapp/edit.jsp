<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt(request.getParameter("bno"));
	String bname ="";
	String btitle = "";
	String bcontent = "";
	try{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String user = "root", pass = "1234";
		Class.forName("com.mysql.cj.jdbc.Driver");

		conn = DriverManager.getConnection(url, user, pass);
		
		String sql = "select * from mvcboard1 where bno=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()){
			bname = rset.getString("bname");
			btitle = rset.getString("btitle");
			bcontent = rset.getString("bcontent");
		}
		
		if(rset != null){rset.close();}
		if(pstmt != null){pstmt.close();}
		if(conn != null){conn.close();}
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<%@include file="./inc/header.jsp" %>
	<div class="container my-25">
		<h3 class="card-header my-3">Q N A 수 정 하 기</h3>
		<form action="edit_action.jsp?bno=<%=bno%>" method="post" onsubmit="return check()">
			<div class="my-3">
				<label for="bname">이름</label> <input type="text"
					class="form-control" id="bname" value="<%=bname %>" name="bname" disabled/>
			</div>

			<div class="my-3">
				<label for="bpass">비밀번호</label> <input type="password"
					class="form-control" id="bpass" name="bpass" />
			</div>

			<div class="my-3">
				<label for="btitle">제목</label> <input type="text"
					class="form-control" id="btitle" name="btitle" value="<%=btitle%>"/>
			</div>

			<div class="my-3">
				<label for="bcontent">내용</label>
				<textarea class="form-control" rows="5" id="bcontent" name="bcontent"><%=bcontent%></textarea>
			</div>
			
			<div class="my-3 text-end">
				<button type="submit" class="btn btn-light p-2 rounded text-dark" title="글수정">수정</button>
				<button type="reset" class="btn btn-light p-2 rounded text-dark" title="글취소">취소</button>
				<a href="list.jsp" class="btn btn-light p-2 rounded text-dark"  title="목록보러가기">목록보기</a>
			</div>
		</form>
	</div>
	<script>
		function check(){
			let bpass    = document.querySelector("#bpass");
			let btitle   = document.querySelector("#btitle");
			let bcontent = document.querySelector("#bcontent");
			
			if(bpass.value.trim() == ""){
				alert("비밀번호를 입력하세요.");
				bpass.focus();
				return false;
			}else if(btitle.value.trim() == ""){
				alert("제목을 입력하세요.");
				btitle.focus();
				return false;
			}else if(bcontent.value.trim() == ""){
				alert("내용을 입력하세요.");
				bcontent.focus();
				return false;
			}
			return true;
		}
	</script>
<%@include file="./inc/footer.jsp" %>