<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/* jsp015_session4 */
session.invalidate(); //로그아웃할때 - 모든 세션정보 삭제
response.sendRedirect("jsp015_1_session.jsp");
%>