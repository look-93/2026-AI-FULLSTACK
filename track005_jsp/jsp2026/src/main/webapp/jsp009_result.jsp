<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
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
      <h3 class="card-header">성적 처리 정보</h3>
      <% 
      	String kor = request.getParameter("kor");
        String eng = request.getParameter("eng");
        String math = request.getParameter("math");
        String total = String.valueOf(Integer.parseInt(kor) + 
				        			  Integer.parseInt(eng) + 
				        			  Integer.parseInt(math));        
        String avg = String.format("%.2f",Double.parseDouble(total)/3);
      %>
	    <table class="table table-striped table-bordered">
	        <thead>
	          <tr>
	            <th scope="col">KOR</th>
	            <th scope="col">ENG</th>
	            <th scope="col">MATH</th>
	            <th scope="col">TOTAL</th>
	            <th scope="col">AVG</th>
	          </tr>
	        </thead>
	        <tbody>
	        	<tr>
					<td><%=kor%></td>
					<td><%=eng%></td>
					<td><%=math%></td>
					<td><%=total%></td>
					<td><%=avg%></td>
				</tr>
	        </tbody>
		</table>
   </div>
</body>
</html>