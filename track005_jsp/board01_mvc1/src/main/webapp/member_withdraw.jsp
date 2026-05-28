<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

String email = request.getParameter("email");

%>
<%@ include file="./inc/header.jsp"%>
<div class="container card  my-5">
	<h3 class="card-header my-3">마이페이지</h3>

	<form action="member_withdraw_action.jsp?email=<%=email%>" method="post" onsubmit="return check()">
		<div class="my-3">
			<label for="email">이메일</label> 
			<input type="email" class="form-control" id="email" name="email" value="<%=email%>" disabled />
		</div>
		<div class="my-3">
			<label for="bpass">비밀번호</label> <input type="password"
				class="form-control" id="bpass" name="bpass" />
		</div>

		<div class="my-3 text-end">
			<button type="reset" class="btn btn-outline-primary p-2 rounded"
				title="글취소">취소</button>
			<button type="submit" class="btn btn-danger p-2 rounded text-white"
				title="가입하기">탈퇴하기</button>
		</div>

	</form>
</div>
<script>
	function check() {
		let bpass = document.querySelector("#bpass");

		if (bpass.value.trim() == "") {
			alert("비밀번호를 입력하세요.");
			bpass.focus();
			return false;
		}

		return true;
	}
</script>

<%@ include file="./inc/footer.jsp"%>