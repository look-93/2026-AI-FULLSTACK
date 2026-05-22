<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<%

// out.println("ddd");
int userage = Integer.parseInt(request.getParameter("userage"));

// 쿼리스트링 주소?name1=value1&name2 = value2

if(userage < 19){
	response.sendRedirect("jsp013_child.jsp?userage=" + userage);
}
else{
	request.getRequestDispatcher("jsp013_adult.jsp").forward(request, response);
} 

%>