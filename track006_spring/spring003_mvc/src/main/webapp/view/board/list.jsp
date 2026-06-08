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
           
            
            </tbody>
            	<tfoot><tr><td colspan="5">
            	<ul class="pagination  justify-content-center"> 
            		<!-- 이전 -->
            		<!-- 1,2,3,4,5,6 -->
            		<c:forEach var="i" begin="${paging.start}" end="${paging.end}">
            			<li class="page-item <c:if test="${i==paging.current}"> active </c:if>">
            				<a href="?pstartno=${i}" class="page-link">${i}</a>
            			</li>
            		</c:forEach>
            		<!-- 다음 -->
            	</ul></td></tr>
            	</tfoot>
            	

            
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