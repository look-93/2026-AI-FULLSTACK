<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-5"> <!-- my-5 위아래 마진 -->
		<h3 class="card-header">REQUEST - 요청</h3>
		<p class="alert alert-warning">
			https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=apple <br /> 
			1. 처리컨테이너 (action): https://search.naver.com/search.naver <br /> 
			2. 처리방식    (method): get 
			3. 보관용기    (name  ): query
		</p>
		<form action="https://search.naver.com/search.naver" method="get" onsubmit="return check()">
			<div class="my-2">
				<label for="query">검색어</label> <!-- label for=""/input id="" -> 같게 짝꿍임-->
				<input type="text" class="form-control" placeholder="네이버에게 물어봐!" 
				 id="query" name="query" />
				<button type="submit" class="btn btn-info my-3 d-block">검색</button>
			</div>
		</form>
		
		<script>
			function check(){
				//1. id 값 이용해서 query 대상찾아오기
				//2. 칸이 빈칸이라면 - 검색어를 입력하세요, 커서가게
				//3. 전송여부				
				let query = document.querySelector("#query")
				
				if(query.value.trim() == ""){ // query.value 문자열 찾아와서 trim() 앞뒤 공백빼고
					alert("검색어를 입력하세요.");
					query.focus();
					return false;
				}				
				return true;
			}
		</script>

	</div>	
</body>
</html>