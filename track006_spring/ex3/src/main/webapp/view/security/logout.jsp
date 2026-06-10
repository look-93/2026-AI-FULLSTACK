<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/security/logout"
		method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="로그아웃"
			class="btn btn-danger" />
	</form>

</body>
</html>