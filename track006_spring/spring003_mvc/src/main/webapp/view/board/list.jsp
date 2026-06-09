<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->

<script>
window.addEventListener("load" , function(){
   let  result = '${result}';   // el
   console.log(result);
   
   if( result == "비밀번호 확인!"){  alert(result);  history.go(-1);  }  // 알림창, 뒤로 가기
   else if(result.length != 0){  alert(result);                   }  
}); 
</script>

    <!--  content -->
    <section class="container  my-5">
        <h3> MultiBoard </h3>
        <pre>
        페이징: ${paging }
        전체리스트:${list }
        </pre>
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
            	<c:forEach var="item" items="${list}" varStatus="status">
            		<tr>
            		<!-- 1. 256(전체갯수)-1 
            			 2. 전체개수-0 224~215 / 전체갯수-20 214~205 /  전체갯수-30 204~195        			 
            		-->
  						<td>${paging.listtotal - paging.pstartno - status.index }</td>
            			<%-- <td>${list.size()-(list.size()-status.index-1) + paging.pstartno}</td> --%>
            			<td><a href="${pageContext.request.contextPath }/board/detail.do?bno=${item.bno}">${item.btitle}</a> </td>
            			<td>${item.bcontent}</td>
            			<td>${item.bdate}</td>
            			<td>${item.bhit}</td>
            			
            		</tr>
            	</c:forEach>
            </tbody>
            	<tfoot>
            	<tr><td colspan="5">
            	<ul class="pagination  justify-content-center"> 
            		<!-- 이전 -->
            		<c:if test="${paging.start > paging.bottomlist}" > 
	            		<li class="page-item">
	            			<a class="page-link" href="?pstartno= ${paging.start-1}"> < </a>
	            		</li>
            		</c:if>            		
<!--             		<li class="page-item " onclick="goPrevious()">
            			<a class="page-link" href="#"> < </a>
            		</li> -->
            		
            		<!-- 1,2,3,4,5,6 -->            		
            		<c:forEach var="i" begin="${paging.start}" end="${paging.end}">
            			<li class="page-item <c:if test="${i==paging.current}"> active </c:if>">
            				<a href="?pstartno=${i}" class="page-link">${i}</a>
            			</li>
            		</c:forEach>
            		
            		<!-- 다음 -->
            		<c:if test="${paging.pagetotal > paging.end}" > 
	            		<li class="page-item">
	            			<a class="page-link" href="?pstartno= ${paging.end+1}"> > </a>
	            		</li>
            		</c:if>
            		<!--             		<li class="page-item" onclick="goNext()">
            			<a class="page-link" href="#"> > </a>
            		</li> -->
            	</ul>
            	</td></tr>
            	</tfoot>          	

        </table>

        <div  class="text-end">
           <a href="${pageContext.request.contextPath }/board/write.do"  title="글쓰기 폼"  class="btn btn-primary" >글쓰기</a>
        </div>

    </section>
    <script>
    	function goPrevious(){
    		const current = ${paging.current}
    		console.log(current)
    		if(current > 1 ){
    			//alert("ddd")
    			location.href="?pstartno=" + (current -1)
    		}
    		
    	}
    	
    	function goNext(){
    		const current = ${paging.current} 
    		const pagetotal = ${paging.pagetotal} 
    		if(current < pagetotal){
    			location.href="?pstartno=" + (current + 1)
    		}    		
    	}
    
    </script>

 
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