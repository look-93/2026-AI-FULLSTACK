package com.study.bank;

import java.util.Scanner;

public class Bank {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String id, passworld;
		int num, age, amount;
		
		System.out.println("WELCOME! (주)CODEJOHNS BANK");
		System.out.println("======BANK======");
		System.out.println("* 1.추가");
		System.out.println("* 2.조회");
		System.out.println("* 3.입금");
		System.out.println("* 4.출금");
		System.out.println("* 5.삭제");
		System.out.println("* 9.종료");
		
		System.out.print("입력>>> ");
		
		num = scanner.nextInt();
		
		while(true) {
			if(num == 9) {
				System.out.println("종료되었습니다");
				break;
			}
		}
		
		
		

	}
}
