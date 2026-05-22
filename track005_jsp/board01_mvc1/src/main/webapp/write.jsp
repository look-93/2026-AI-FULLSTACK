<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./inc/header.jsp" %>

	<div class="container card my-25">
		<h3 class="card-header my-3">Q N A 등 록</h3>
		
		<form action="write_action.jsp" method="post" onsubmit="return check()">
			
			<div class="my-3">
				<label for="bname">이름</label> <input type="text"
					class="form-control" id="bname" name="bname" />
			</div>

			<div class="my-3">
				<label for="bpass">비밀번호</label> <input type="password"
					class="form-control" id="bpass" name="bpass" />
			</div>

			<div class="my-3">
				<label for="btitle">제목</label> <input type="text"
					class="form-control" id="btitle" name="btitle" />
			</div>

			<div class="my-3">
				<label for="bcontent">내용</label>
				<textarea class="form-control" rows="5" id="bcontent" name="bcontent"></textarea>
			</div>
			
			<div class="my-3 text-end">
				<button type="submit" class="btn btn-light p-2 rounded text-dark" title="글등록" >입력</button>
				<button type="reset" class="btn btn-light p-2 rounded text-dark" title="글취소" >취소</button>
				<a href="list.jsp" class="btn btn-light p-2 rounded text-dark"  title="목록보러가기">목록보기</a>
			</div>
		</form>		
	</div>
	
	<script>
		function check(){
			let bname    = document.querySelector("#bname");
			let bpass    = document.querySelector("#bpass");
			let btitle   = document.querySelector("#btitle");
			let bcontent = document.querySelector("#bcontent");
			
			if(bname.value.trim() == ""){
				alert("이름을 입력하세요.");
				bname.focus();
				return false;
			}else if(bpass.value.trim() == ""){
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