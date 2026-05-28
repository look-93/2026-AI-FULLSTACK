<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp" %>

	<div class="container card my-5">
		<h3 class="card-header my-3">로그인</h3>
		
		<form action="login_action.jsp" method="post" onsubmit="return check()">		
			<div class="my-3">
				<label for="email">이메일</label>
				<input type="email" class="form-control" id="email" name="email"/>
			</div>
			
			<div class="my-3">
				<label for="bpass">비밀번호</label>
				<input type="password" class="form-control" id="bpass" name="bpass"/>
			</div>		
			<div class="my-3">

			<%
			if (request.getAttribute("findEmail") != null) {
			%>
			
			<div class='alert alert-success'>
				회원님의 이메일 아이디는 <strong> <%= request.getAttribute("findEmail")%>
				</strong>
			</div>
			
			<%
			}
			%>

		</div>
			
			<div class="my-3 text-end">			
				<button type="reset" class="btn btn-outline-primary p-2 rounded " title="취소">취소</button>	
				<a href="findId.jsp" class="btn btn-outline-primary p-2 rounded" title="아이디찾기">아이디찾기</a>
				<a href="signup.jsp" class="btn btn-outline-primary p-2 rounded" title="회원가입">회원가입</a>
				<button type="submit" class="btn btn-primary p-2 rounded text-white" title="로그인">로그인</button>
			</div>
		</form>
		
	</div>

<script>
	function check(){
		let email = document.querySelector("#email");
		let password = document.querySelector("#password");
		
		if(email.value.trim() == ""){
			alert("이메일을 입력하세요.");
			email.focus();
			return false;
		}else if(password.value.trim() == ""){
			alert("비밀번호를 입력하세요.");
			password.focus();
			return false;
		}		
		return true;		
	}
</script>
<%@ include file="./inc/footer.jsp" %>