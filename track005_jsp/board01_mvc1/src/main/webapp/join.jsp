<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp"%>
<div class="container card  my-5">
	<h3 class="card-header my-3">회원가입</h3>
	
	  <!--<form action="join_action.jsp" method="post" onsubmit="return check()">	-->
	<form action="JoinAction" method="post" onsubmit="return check()">
		<div class="my-3">
			<label for="nickname">닉네임</label>
			<input type="text" class="form-control" id="nickname" name="nickname"/>
		</div>
		
		<div class="my-3">
			<label for="bpass">비밀번호</label>
			<input type="password" class="form-control" id="bpass" name="bpass"/>
		</div>
		
		<div class="my-3">
			<label for="email">이메일</label>
			<input type="email" class="form-control" id="email" name="email"/>
		</div>
			
		<div class="my-3">
			<label for="mobile">휴대폰</label>
			<input type="text" class="form-control" id="mobile" name="mobile"/>
		</div>
		
		<div class="my-3 text-end">
			<button type="reset" class="btn btn-outline-primary p-2 rounded" title="취소">취소</button>
			<a href="login.jsp" class="btn btn-outline-primary p-2 rounded" title="로그인">로그인</a>
			<button type="submit" class="btn btn-primary p-2 rounded text-white" title="가입하기">가입하기</button>			
		</div>
		
	</form>
</div>
<script>
	function check(){
		let nickname = document.querySelector("#nickname");
		let bpass = document.querySelector("#bpass");
		let email = document.querySelector("#email");
		let mobile = document.querySelector("#mobile");
		
		if(nickname.value.trim() == ""){
			alert("닉네임을 입력하세요.");
			nickname.focus();
			return false;
		}else if(bpass.value.trim() == ""){
			alert("비밀번호를 입력하세요.");
			bpass.focus();
			return false;
		}else if(email.value.trim() == ""){
			alert("이메일을 입력하세요.");
			email.focus();
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

<!-- ............  유저를 서블릿버젼으로 만들려고 해요!
1.  Join
> 회원가입폼   - Get
> 회원가입처리 - Post
1) 처리서블릿   : JoinAction
2) 데이터 노출  : x
3) 보관데이터   : nickname , bpass , email , mobile
4) 처리경로     : 처리후 로그인 폼으로 (LoginAction - Get)

2. Login
> 로그인폼    -  Get
> 로그인처리 - Post
1) 처리서블릿   : LoginAction
2) 데이터 노출  : x
3) 보관데이터   : bpass , email  
4) 처리경로     : 처리후 마이페이지로   (MyAction - Get)


3. Mypage
> 마이페이지 - Get 
1) 처리서블릿   : MyAction
2) 로그인한정보로 서버에서 해당이메일의 정보가져오기
3) 처리후  mypage.jsp로 사용자 정보 넘겨주기


4. Logout
> 로그아웃 - Get

5. Users
>  사용자목록 확인
1) 처리서블릿  : Users
2) 사용자들의 목록을 확인  - users.jsp 로 전체사용자의 정보확인 -->