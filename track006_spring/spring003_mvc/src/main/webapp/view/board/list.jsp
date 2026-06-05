<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->

<script>
window.addEventListener("load", function(){
	let result = '${result}' //el문법
	//console.log(result);
	
	if(result == "글쓰기 실패"){
		// 알림창 띄우고 뒤로가기
		alert(result); 
		history.go(-1); 
	}else if(result.length != 0){
		alert(result)
	}
	
});
</script>

    <!--  content -->
    <section class="container  my-5">
        <h3> MultiBoard </h3>
        <table  class="table  table-striped  table-bordered table-hover">
            <caption> BOARD 목록 </caption>
            <thead>
                <tr>
                    <th scope="col">NO</th>
                    <th scope="col">TITLE</th>
                    <th scope="col">WRITER</th>
                    <th scope="col">DATE</th>
                    <th scope="col">HIT</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="i" items="${list}" varStatus="status">
            		<tr><!-- 전체갯수 - 갯수 -->
            			<td>${list.size() - status.index}</td>
            			<td><a href="${pageContext.request.contextPath }/board/detail.do?bno=${i.bno}">${i.btitle}</a> </td>
            			<td>${i.bcontent}</td>
            			<td>${i.bdate}</td>
            			<td>${i.bhit}</td>
            		</tr>
            	</c:forEach>

            </tbody>
        </table>

        <div  class="text-end">
           <a href="${pageContext.request.contextPath }/board/write.do"  title="글쓰기 폼"  class="btn btn-primary" >글쓰기</a>
        </div>

    </section>

 
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>


<!--                 
	<tr>
                 <td>1</td>
                 <td>첫번째 글쓰기</td>
                 <td>FIRST</td>
                 <td>2026.05</td>
                 <td><span class="badge rounded-pill bg-dark">1</span></td>
             </tr> 
         -->