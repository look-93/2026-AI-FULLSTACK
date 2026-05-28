package com.the703.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/life") //생명주기
public class Servlet002 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int initCnt  = 1;	//init 맨처음 뜸
	int doGetCnt = 1;	//Thread get/post 시 뜸
	int destroyCnt = 1; //맨마지막에 한번 뜸
    public Servlet002() {
        super();
    }
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("...... #1. init() 첫요청에만 호출 >" + initCnt++);
	}

	public void destroy() {
		System.out.println("파일 조금 수정하기 ctrl + s 저장"); // 뭔가 파일이 수정되면 / 갱신될때
		System.out.println("...... #3. init() destroy() 맨 마지막에 호출 >" + destroyCnt++);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("...... #2. Get() 요청처리를 할때마다 호출 >" + doGetCnt++);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
