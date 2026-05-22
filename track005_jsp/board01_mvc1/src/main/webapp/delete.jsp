<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./inc/header.jsp" %>
	<div class="container card my-5">
		<h3 class="card-header my-3">Q N A 삭 제</h3>
		<form action="#" method="post" onsubmit="return check()">
			<div class="my-3">
				<label for="bpass">비밀번호</label> <input type="password"
					class="form-control" id="bpass" name="bpass" />
				<p>수정,삭제시 필수입니다.</p>
			</div>
			<div class="my-3">
				<button type="submit" class="btn btn-light p-2 rounded text-dark" title="확인">확인</button>
				<button type="reset" class="btn btn-light p-2 rounded text-dark" title="취소">취소</button>
			</div>
		</form>
	</div>
	<script>
		function check(){
			let bpass    = document.querySelector("#bpass");
			
			if(bpass.value.trim() == ""){
				alert("비밀번호를 입력하세요.");
				bpass.focus();
				return false;
			}
			return true;
		}
	</script>
<%@include file="./inc/footer.jsp" %>