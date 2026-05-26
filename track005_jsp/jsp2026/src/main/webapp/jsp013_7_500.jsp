<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 고객들이 에러페이지 못보게 -->
<%@ page isErrorPage="true" %> <!-- 에러페이지입니다.  -->
<% response.setStatus(200); %> <!-- 정상응답하는 페이지에요.  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">ERROR 500</h3>      
   </div>
   <%=exception.getMessage()%>
</body>
</html>

<!-- 경로:jsp013_implicit error참조 -->