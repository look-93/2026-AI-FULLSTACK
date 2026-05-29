package com.the703.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinAction")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Join() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입폼으로
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입기능
		
		//1. 데이터넘겨받기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 추가됨 java.io.PrintWriter
		PrintWriter out = response.getWriter();
		
		String nickname  = request.getParameter("nickname");
		String bpass   = request.getParameter("bpass");
		String email   = request.getParameter("email");
		String mobile  = request.getParameter("mobile");
		String bip = InetAddress.getLocalHost().getHostAddress();
		//out.println(email);
		
		//2. sql(드커프리)처리
		
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String user = "root", password = "1234";
		PreparedStatement pstmt = null;
		String sql = "insert into users (nickname, bpass, email, mobile, bip) value(?,?,?,?,?)";
		String checkSql = "select * from users where email=?";
		
		//2. sql(드커프리)처리
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement(checkSql);
			pstmt.setString(1, email);
			
			ResultSet rset = pstmt.executeQuery();
			
			if(rset.next()){
				out.println("<script> alert('이미 가입된 email입니다.'); history.go(-1); </script>");
				if(pstmt != null){pstmt.close();}
				if(rset != null){rset.close();}
				
			}else{			
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, nickname);
				pstmt.setString(2, bpass);
				pstmt.setString(3, email);
				pstmt.setString(4, mobile);
				pstmt.setString(5, bip);
				
				int result = pstmt.executeUpdate();
				
				//3. 해당 폼으로
				if(result > 0 ){
					out.println("<script> alert('회원가입성공!'); location.href ='LoginAction'; </script>");
				}else {
					out.println("<script> alert('실패!'); history.go(-1); </script>");
				}

				if(pstmt != null){pstmt.close();}
				if(conn != null){conn.close();}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

}
