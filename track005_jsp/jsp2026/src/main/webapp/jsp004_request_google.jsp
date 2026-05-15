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
	<!-- 실습) 구글에게 물어봐~ -->
	<div class="container card my-5">
		<h3 class="card-header">REQUEST-요청</h3>
		<p class="alert alert-primary my-3">
			https://www.google.com/search?q=APPLE<br /> 
			1.처리컨테이너 	(action	: 해결사)	: https://www.google.com/search <br /> 
			2.처리방식    	(method	: get)	: get <br /> 
			3.보관용기 	(name	: query): query <br />
		</p>
		<form action="https://www.google.com/search" method="get" onsubmit="return check()">
			<div class="my-2">
				<label for="query">검색어</label> 
				<input type="text" class="form-control" placeholder="구글에게 물어봐!" id="query" name="q"/>
				<button type="submit" class="btn btn-success mt-3 d-block">검색</button>
			</div>
		</form>
		<script>
     		function check(){
     			let query = document.querySelector("#query");
     			if(query.value.trim() == ""){
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