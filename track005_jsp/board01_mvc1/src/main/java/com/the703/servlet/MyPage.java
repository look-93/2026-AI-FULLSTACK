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

/**
 * Servlet implementation class MyPage
 */
@WebServlet("/MyAction")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 로그인한 정보확인		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); 
		
		String email = (String) session.getAttribute("email");
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String user = "root", password = "1234";
		PreparedStatement pstmt = null;
		User userInfo = null;
		out.println(email);
		//2. sql - 내정보가져오기
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(
			"select *, date_format(udate, '%Y-%m-%d %H:%i-%s') as formatDate from users where email=?");
			pstmt.setString(1, email);

			ResultSet rset = pstmt.executeQuery();
				
			
			if(rset.next()) {
				userInfo = new User();
				
				userInfo.setEmail(rset.getString("email"));
				userInfo.setNickname(rset.getString("nickname") );
				userInfo.setMobile(rset.getString("mobile") );
				userInfo.setUdate(rset.getString("udate") );
				userInfo.setBip(rset.getString("bip") );
			}
			
			request.setAttribute("userInfo", userInfo);			
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
			
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
				
		
		//3. 해당 폼으로
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
