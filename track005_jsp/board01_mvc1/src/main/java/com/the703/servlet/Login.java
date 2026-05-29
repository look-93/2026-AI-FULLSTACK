package com.the703.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginAction")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//1. 데이터넘겨받기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); 
		
		String email = request.getParameter("email");
		String bpass = request.getParameter("bpass");
		
		//2. sql(드커프리) 처리
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String user = "root", password = "1234";
		PreparedStatement pstmt = null;
		int find = -1;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement("select count(*) as `cnt` from users where email= ? and bpass = ?");

			pstmt.setString(1, email);
			pstmt.setString(2, bpass);
			
			ResultSet rset = pstmt.executeQuery();			
			
			if(rset.next()) {find = rset.getInt("cnt");} // 아이디와 비번이 같은 유저 1명
			
			//3. 해당 폼으로
			if(find == 1){
				session.setAttribute("email", email);
				out.println("<script> alert('로그인 성공!'); location.href = 'MyAction'; </script>");
			}else {
				out.println("<script> alert('아이디/비밀번호를 확인하세요.'); history.go(-1);  </script>");
			}

			if(rset  != null){rset.close();}
			if(pstmt != null){pstmt.close();}
			if(conn  != null){conn.close();}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}

		
		
		//request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}

}
