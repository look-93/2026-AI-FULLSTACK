<%@page import="com.the703.servlet.User"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
User userInfo = (User) request.getAttribute("userInfo");
%>

<%@ include file="./inc/header.jsp"%>

<div class="container card my-5">
	<div class="card-header my-3 d-flex justify-content-between">
		<h3>마이페이지</h3>
		<div>
			<a href="member_update.jsp"
				class="card-link text-decoration-none text-black">수정</a> <a
				href="member_withdraw.jsp?email=${userInfo.email }"
				class="card-link text-decoration-none text-danger">탈퇴</a>
		</div>
	</div>
	<table class="table table-bordered">
		<tbody>
			<tr>
				<th>닉네임</th>
				<td>${userInfo.nickname}</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${userInfo.email}</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>${userInfo.mobile}</td>
			</tr>
			<tr>
				<th>가입일</th>
				<td>${userInfo.udate }</td>
			</tr>
			<tr>
				<th>가입IP</th>
				<td>${userInfo.bip }</td>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="./inc/footer.jsp"%>