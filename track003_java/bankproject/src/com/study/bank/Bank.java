package com.study.bank;

import java.util.Scanner;

public class Bank {

	public static void info() {
		System.out.println("WELCOME! (주)CODEJOHNS BANK");
		System.out.println("======BANK======");
		System.out.println("* 1.추가");
		System.out.println("* 2.조회");
		System.out.println("* 3.입금");
		System.out.println("* 4.출금");
		System.out.println("* 5.삭제");
		System.out.println("* 9.종료");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String id, age;
		int num, pass, amount;
		
		info();
		System.out.print("입력>>> ");
		num = scanner.nextInt();
		
		if(num == 1) {
			System.out.print("아이디 입력 : ");
			id = scanner.next();
			System.out.print("비밀번호 입력 : ");
			pass = scanner.nextInt();
			System.out.print("나이 입력 : ");
			age = scanner.next();
			System.out.print("잔액 입력 : ");
			amount = scanner.nextInt();
			
			
		}
		
		

	}
}
