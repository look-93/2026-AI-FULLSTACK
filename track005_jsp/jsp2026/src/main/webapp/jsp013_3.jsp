<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
// -> jsp013_3가 주소표시창줄에 보여지고 
//    경로를 jsp012_milk.jsp 페이지로 넘겼지만 
//    주소표시창줄에는 숨겨짐 
request.getRequestDispatcher("jsp012_milk.jsp").forward(request, response);
%>