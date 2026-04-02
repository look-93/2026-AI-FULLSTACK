package com.study.bank;

import java.util.Scanner;

public class Bank {
	
	public static void initMessage() {
		System.out.println("======BANK======");
		System.out.println("* 1.추가");
		System.out.println("* 2.조회");
		System.out.println("* 3.입금");
		System.out.println("* 4.출금");
		System.out.println("* 5.삭제");
		System.out.println("* 9.종료");		
		System.out.print("입력>>> ");
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String id, password;
		int num, age, amount;
		System.out.println("WELCOME! (주)CODEJOHNS BANK");
		initMessage();
		
		num = scanner.nextInt();
		
		while(true) {
			if(num == 9) {
				System.out.println("종료되었습니다");
				break;
			}else if(num == 1) {
				System.out.print("아이디 입력: ");
				id = scanner.next();
				System.out.print("비밀번호 입력: ");
				password = scanner.next();
				System.out.print("나이 입력: ");
				age = scanner.nextInt();
				System.out.print("잔액 입력: ");
				amount = scanner.nextInt();
				
				initMessage();				
			}
		}
		
		
		

	}
}
