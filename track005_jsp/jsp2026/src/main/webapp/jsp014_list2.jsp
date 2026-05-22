<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
<link href="./css/board.css" rel="stylesheet">
</head>

<body>
	<!--header-->
	<header>
		<div class="p-5 bg-secondary text-white text-center myvisual">
			<h1>THEJOA703</h1>
			<p>MVC1 JSP PROJECT</p>
		</div>
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<h2 class="myhidden">주메뉴</h2>
			<div class="container-fluid">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#mynavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="mynavbar">
					<a class="navbar-brand" href="javascript:void(0)">Logo</a>
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link active" href="#">Active</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!--/header-->
	
	
	<!--content-->
	<!--영역잡고, 제목, 내용-->
	<!--table, caption, thead/tbody-->
	<section class="container my-5">
		<h3 class="text-center">MultiBoard</h3>
		<form action="write.jsp" method="post">
			<table
				class="table table-striped table-bordered table-hover table-light">
				<caption>BOARD목록</caption>
				<thead>
					<tr>
						<!--scope 읽히는 방향설정(보이진않지만 스크린리더기?에서 읽힐때사용)-->
						<th scope="col">NO</th>
						<th scope="col">TITLE</th>
						<th scope="col">WRITER</th>
						<th scope="col">DATE</th>
						<th scope="col">HIT</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>첫번쨰글쓰기</td>
						<td>홍길동</td>
						<td>2026-04-16</td>
						<td><span class="badge rounded-pill bg-secondary">1</span></td>
					</tr>
					<tr>
						<td>2</td>
						<td>두번쨰글쓰기</td>
						<td>김길동</td>
						<td>2026-04-16</td>
						<td><span class="badge rounded-pill bg-secondary">2</span></td>
					</tr>
					<tr>
						<td>3</td>
						<td>세번째글쓰기</td>
						<td>박길동</td>
						<td>2026-04-17</td>
						<td><span class="badge rounded-pill bg-secondary">3</span></td>
					</tr>
				</tbody>
			</table>
			<div class="text-end">
				<button type="submit" class="btn btn-light p-2 rounded text-dark">글쓰기</button>
			</div>
		</form>
	</section>

	
	<!--footer-->
	<!--footer-->
	<!--footer-->
	<!--footer-->
	<!-- jsp014_footer.jsp -->
	
	<!--배경색상 글자색상 글자중앙정렬 안쪽여백-->
	<footer class="bg-light text-dark text-center p-5"> ©
		copyrights bora 2026 all. rights reserved </footer>
	<!--/footer-->
		
</body>
</html>
