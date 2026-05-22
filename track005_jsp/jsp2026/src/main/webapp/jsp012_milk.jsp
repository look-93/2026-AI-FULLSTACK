<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<!-- header  -->
	<header>
		<div class="p-5 bg-warning text-white">
			<h1 class="text-white">MILK ORDER Project</h1>
			<p>MVC1 - PreparedStatment Ex</p>
		</div>
	</header>

	<!-- 메뉴판테이블  -->
	<section class="mt-5">
		<div class="container card my-3">
			<h2 class="card-header bg-warning mb-5 text-white">Milk Menu</h2>
			<table class="table table-striped table-hover">
				<caption>우유메뉴</caption>
				<thead class="table-dark">
					<tr>
						<th scope="col">NO</th>
						<th scope="col">NAME</th>
						<th scope="col">PRICE</th>
					</tr>
				</thead>
				<tbody>
					<%
					try {
						//1. 드라이버연동
						Class.forName("com.mysql.cj.jdbc.Driver");

						//2. JDBC 연동
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");

						//3. PreparedStatment pstmt 이용해서 milk 테이블의 데이터 가져오기			    
						//   가격이 낮은 순으로
						PreparedStatement pstmt = conn.prepareStatement("select * from milk");
						ResultSet rset = null;
						rset = pstmt.executeQuery();

						while (rset.next()) {
							out.println("<tr>" 
						+ "<td>" + rset.getInt("mno") + "</td>" 
						+ "<td>" + rset.getString("mname") + "</td>" 
						+ "<td>" + rset.getString("mprice") + "</td>" 
						+ "</tr>");
						}

						//4. JDBC 끊기
						if (rset != null) {
							rset.close();
						}
						if (pstmt != null) {
							pstmt.close();
						}
						if (conn != null) {
							conn.close();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					%>
				</tbody>
			</table>
		</div>
	</section>

	<!-- 주문현황표  -->
	<section class="mt-5">
		<div class="container card my-3 bg-black">
			<h2 class="card-header text-white">MILK ORDER</h2>
			<table class="table table-striped table-hover">
				<thead class="table-white">
					<tr>
						<th scope="col">NO</th>
						<th scope="col">NAME</th>
						<th scope="col">NUM</th>
						<th scope="col">주문날짜</th>
					</tr>
				</thead>
				<tbody>
					<%
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
						PreparedStatement pstmt = conn.prepareStatement("select * from milk_order");

						ResultSet rset = pstmt.executeQuery();

						while (rset.next()) {
							out.println("<tr>" 
									    + "<td>" + rset.getInt("ono") 		+ "</td>" 
										+ "<td>" + rset.getString("oname") 	+ "</td>" 
									    + "<td>" + rset.getInt("onum") 		+ "</td>" 
										+ "<td>" + rset.getDate("odate")    + "</td>" 
									    + "</tr>");
							}

						//4. JDBC 끊기
						if (rset != null) {
							rset.close();
						}
						if (pstmt != null) {
							pstmt.close();
						}
						if (conn != null) {
							conn.close();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					%>
				</tbody>

			</table>
		</div>
	</section>

	<!-- 주문삽입, 수정, 삭제  -->
	<section class="mt-5">
		<div class="container card my-3 bg-black">
			<h2 class="card-header text-white mb-3">MILK 주문하러가기</h2>
			<div id="accordion">

				<!-- 주문하기 -->
				<div class="card mb-3">
					<div class="card-header bg-warning">
						<a class="btn" data-bs-toggle="collapse" href="#collapseOne">
							주문하기 </a>
					</div>

					<div id="collapseOne" class="collapse show"
						data-bs-parent="#accordion">
						<div class="card-body">

							<!-- form -->
							<form action="jsp012_insert.jsp" method=post
								onsubmit="return orderCheck()">
								<div class="my-3">
									<label for="oname" class="form-label">주문할 우유이름</label> <input
										type="text" class="form-control"
										placeholder="주문할 우유이름을 적어주세요!" id="oname" name="oname" />
								</div>

								<div class="my-3">
									<label for="onum" class="form-label">주문할 우유갯수</label> <input
										type="text" class="form-control" placeholder="우유갯수를 적어주세요!"
										id="onum" name="onum" />
								</div>

								<div class="my-3">
									<button type="submit" title="주문하기" class="btn btn-warning"
										id="orderBtn" name="orderBtn">주문하기</button>
								</div>
							</form>


						</div>
					</div>

				</div>

				<!-- 주문수정 -->
				<div class="card mb-3">
					<div class="card-header">
						<a class="collapsed btn" data-bs-toggle="collapse"
							href="#collapseTwo"> 주문수정 </a>
					</div>

					<div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
						<div class="card-body">

							<!-- form -->
							<form action="jsp012_update.jsp" method="post"
								onsubmit="return updateCheck()">

								<div class="my-3">
									<label for="updateOno" class="form-label">수정할 우유번호</label> <input
										type="text" class="form-control"
										placeholder="수정할 우유번호을 적어주세요!" id="updateOno" name="updateOno" />
								</div>

								<div class="my-3">
									<label for="updateOname" class="form-label">수정할 우유이름</label> <input
										type="text" class="form-control"
										placeholder="수정할 우유이름을 적어주세요!" id="updateOname"
										name="updateOname" />
								</div>

								<div class="my-3">
									<label for="updateOnum" class="form-label">수정할 우유갯수</label> <input
										type="text" class="form-control"
										placeholder="수정할 우유갯수를 적어주세요!" id="updateOnum"
										name="updateOnum" />
								</div>

								<div class="my-3">
									<button type="submit" title="수정하기" class="btn btn-warning"
										id="updateBtn" name="updateBtn">수정하기</button>
								</div>

							</form>

						</div>
					</div>

				</div>

				<!-- 주문삭제 -->
				<div class="card mb-3">
					<div class="card-header">
						<a class="collapsed btn" data-bs-toggle="collapse"
							href="#collapseThree"> 주문삭제 </a>
					</div>
					<div id="collapseThree" class="collapse"
						data-bs-parent="#accordion">
						<div class="card-body">
							<!-- form  -->

							<form action="jsp012_delete.jsp" method="post"
								onsubmit="return deleteCheck()">
								<div class="my-3">
									<label for="deleteOno" class="form-label">삭제할 번호</label> <input
										type="text" class="form-control"
										placeholder="삭제 번호를 적어주세요!" id="deleteOno" name="deleteOno" />
								</div>

								<div class="my-3">
									<button type="submit" title="삭제하기" class="btn btn-warning"
										id="deleteBtn" name="deleteBtn">삭제하기</button>
								</div>
							</form>

						</div>
					</div>
				</div>

			</div>
		</div>
	</section>

	<script>
		function updateCheck() {
			let ono = document.querySelector("#updateOno");
			let oname = document.querySelector("#updateOname");
			let onum = document.querySelector("#updateOnum");

			// 빈칸검사
			if (ono.value.trim() == "") {
				alert("수정할 우유번호을 적어주세요!");
				oname.focus();
				return false;
			} else if (oname.value.trim() == "") {
				alert("수정할 우유이름를 적어주세요!");
				onum.focus();
				return false;
			} else if (onum.value.trim() == "") {
				alert("수정할 우유갯수를 적어주세요!");
				onum.focus();
				return false;
			}
			return true;
		}
		function orderCheck() {
			let oname = document.querySelector("#oname");
			let onum = document.querySelector("#onum");

			if (orderName.value.trim() == "") {
				alert("주문할 우유이름을 입력하세요.");
				orderName.focus();
				return false;
			} else if (orderNum.value.trim() == "") {
				alert("주문할 우유갯수를 입력하세요.");
				orderNum.focus();
				return false;
			}
			return true;
		}
		function deleteCheck() {
			let ono = document.querySelector("#deleteOno");

			if (ono.value.trim() == "") {
				alert("삭제 번호를 입력하세요");
				ono.focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>