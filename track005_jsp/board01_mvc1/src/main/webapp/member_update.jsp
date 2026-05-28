<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//String email = request.getParameter("email");
String email = request.getParameter("email");

//out.println(email);
String url = "jdbc:mysql://localhost:3306/mbasic";
String user = "root", password = "1234";
PreparedStatement pstmt = null;
String nickname = "";
String mobile = "";
String bpass = "";


try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url, user, password);
	pstmt = conn.prepareStatement("select * from users where email=?");
	pstmt.setString(1, email);

	ResultSet rset = pstmt.executeQuery();

	while (rset.next()) {
		nickname = rset.getString("nickname");
		bpass = rset.getString("bpass");
		mobile = rset.getString("mobile");
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
<div class="container card  my-5">
	<h3 class="card-header my-3">마이페이지</h3>
	
	<form action="member_update_action.jsp?email=<%=email%>" method="post" onsubmit="return check()">	
		<div class="my-3">
			<label for="nickname">닉네임</label>
			<input type="text" class="form-control"  id="nickname" value="<%=nickname %>" name="nickname" />
		</div>
		
		<div class="my-3">
			<label for="bpass">비밀번호</label>
			<input type="password" class="form-control" id="bpass" name="bpass"/>
		</div>
		
		<div class="my-3">
			<label for="email">이메일</label>
			<input type="email" class="form-control" id="email" name="email" value="<%=email %>" disabled/>
		</div>
			
		<div class="my-3">
			<label for="mobile">휴대폰</label>
			<input type="text" class="form-control" id="mobile" value="<%=mobile %>" name="mobile"/>
		</div>
		
		<div class="my-3 text-end">			
			<button type="reset" class="btn btn-outline-primary p-2 rounded" title="글취소">취소</button>
			<button type="submit" class="btn btn-primary p-2 rounded text-white" title="가입하기">수정하기</button>
		</div>
		
	</form>
</div>
<script>
	function check(){
		let nickname = document.querySelector("#nickname");
		let bpass = document.querySelector("#bpass");
		let mobile = document.querySelector("#mobile");
		
		if(nickname.value.trim() == ""){
			alert("닉네임을 입력하세요.");
			nickname.focus();
			return false;
		}else if(bpass.value.trim() == ""){
			alert("비밀번호를 입력하세요.");
			bpass.focus();
			return false;		
		}else if(mobile.value.trim() == ""){
			alert("휴대폰번호를 입력하세요.");
			mobile.focus();
			return false;
		}
		
		return true;		
	}

</script>

<%@ include file="./inc/footer.jsp"%>