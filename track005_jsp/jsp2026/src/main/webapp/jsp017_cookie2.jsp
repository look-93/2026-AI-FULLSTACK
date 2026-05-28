<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
//1. 쿠키객체 선언, 값 저장
Cookie cookie1 = new Cookie("userId","sally"); // 이름, 값
Cookie cookie2 = new Cookie("close","on");     // 이름, 값 ex)하루 이 창 안열기

//2. 쿠키 유효기간 설정
cookie1.setMaxAge(2*60);     // 1분
cookie2.setMaxAge(60*60*24); // 1일 -> ex)하루 이 창 안열기

//3. response 설정 : 이거 안하면 쿠키 설정 안됨
response.addCookie(cookie1);
response.addCookie(cookie2);

response.sendRedirect("jsp017_1_cookie.jsp");

%>