<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./jsp014_header.jsp" %>
	<!--header-->
	<!-- jsp014_header.jsp -->
	
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
	<!-- jsp014_footer.jsp -->
<%@include file="./jsp014_footer.jsp" %>	
