<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%
String email = request.getParameter("email");



%>
	
<%@ include file="./inc/header.jsp"%>
<div class="container card my-25">
	<h3 class="card-header my-3">마이페이지</h3>
	<table class="table table-bordered">
		<tbody>
			<tr>
				<th>닉네임</th>
				<!-- 세로 헤더 -->
				<td>홍길동</td>
			</tr>
			<tr>
				<th>이메일</th>
				<!-- 세로 헤더 -->
				<td>dd@1234</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<!-- 세로 헤더 -->
				<td>010-1111-1111</td>
			</tr>
			<tr>
				<th>가입일</th>
				<!-- 세로 헤더 -->
				<td>2026-05-26</td>
			</tr>
			<tr>
				<th>가입IP</th>
				<!-- 세로 헤더 -->
				<td>test</td>
			</tr>			
		</tbody>
	</table>
</div>
<%@ include file="./inc/footer.jsp"%>