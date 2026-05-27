<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
/* jsp015_session3 */
session.removeAttribute("userage");

response.sendRedirect("jsp015_1_session.jsp"); // 화면이동 alert 처리x

//out.println("<script> location.href('jsp015_1_session.jsp'); </script>"); // 화면이동 alert 처리o

%>