<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp"%>


<div class="container card my-5">
	<h3 class="card-header my-3">아이디찾기</h3>
	<form action="findId_action.jsp" method="post"
		onsubmit="return check()">
		<div class="my-3">
			<label for="email">이메일</label> <input type="email"
				class="form-control" id="email" placeholder="이메일을 입력하세요."
				name="email" />
		</div>

		<div class="my-3">
			<label for="nickname">닉네임</label> <input type="text"
				class="form-control" id="nickname" placeholder="닉네임을 입력하세요."
				name="nickname" />
		</div>
		<div class="my-3">


			<%
			if (request.getParameter("foundId") != null) {
			%>
			<p class='alert alert-success'>
				회원님의 아이디는 <strong> <%= request.getParameter("foundId")%>
				</strong>
			</p>
			<%
			}
			%>

		</div>

		<div class="my-3 text-end">
			<button type="reset" class="btn btn-outline-primary p-2 rounded "
				title="글취소">취소</button>
			<button type="submit" class="btn btn-outline-primary p-2 rounded"
				title="다음">다음</button>
		</div>
	</form>
</div>

<script>
	function check() {
		let email = document.querySelector("#email");
		let nickname = document.querySelector("#nickname");

		if (email.value.trim() == "") {
			alert("이메일을 입력하세요.");
			email.focus();
			return false;
		} else if (nickname.value.trim() == "") {
			alert("이메일을 입력하세요.");
			nickname.focus();
			return false;
		}
		return true;
	}
</script>

<%@ include file="./inc/footer.jsp"%>
