package com.the703.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BankProjectV1_3 {

	//아이디 입력받고 비밀번호 입력받고
	//입력받은 아이디 비밀번호 저장 되어있는 아이디,비밀번호 비교 결과 리턴
	public static boolean checkIdPassword(Scanner sc, int id, int pass) {
		System.out.print("ID 입력: ");
		int tid = sc.nextInt();
		System.out.print("PASS 입력: ");
		int tpass = sc.nextInt();			
		return id == tid && pass == tpass;		
	}	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int id  = -1, pass = -1, balance=-1;
		
//		char yn;
		String st="";
		boolean check = false;
		
		// menu  2~5번까지 코드가 반복되는 부분 줄이기~! 도전!
		for (;;) {
			System.out.println("WELCOME TO BANK SYSTEM");
			System.out.println("======BANK======");
			System.out.println("[1] ➕계좌추가");
			System.out.println("[2] 🔍계좌조회");
			System.out.println("[3] 💵계좌입금");
			System.out.println("[4] 💸계좌출금");
			System.out.println("[5] 🗑️계좌삭제");
			System.out.println("[9] ⛔종료");
			System.out.print("👉 번호를 선택하세요 : ");

			num = sc.nextInt();
			
			if (num == 9) {
				System.out.println("종료기능입니다.");
				break;
			} else if (num == 1) { 
				System.out.print("ID 입력: ");
				id = sc.nextInt();
				System.out.print("PASS 입력: ");
				pass = sc.nextInt();
				System.out.print("금액 입력: ");
				balance = sc.nextInt();				
			} else if (num == 2) {
				///////////////////////////////

				if(checkIdPassword(sc, id, pass)) {
				///////////////////////////////
				System.out.println("ID : " + id);
				System.out.println("PASS :" + pass);
				System.out.println("금액 : " + balance);
					
				}else {
					System.out.println("비밀번호를 확인해주세요.");
				}

			} else if (num == 3) { 

				///////////////////////////////
				if(checkIdPassword(sc, id, pass)) {
					///////////////////////////////
					System.out.print("입금잔액 : ");
					
					balance += sc.nextInt();
					
					System.out.println("=======");
					System.out.println("입금완료 : " + balance);
					System.out.println("=======");
				}else {
					System.out.println("비밀번호를 확인해주세요.");
				}		
				
			} else if (num == 4) {
				///////////////////////////////

				if(checkIdPassword(sc, id, pass)) {
					///////////////////////////////
					System.out.print("출금잔액 : ");
					
					balance -= sc.nextInt();
					
					System.out.println("=======");
					System.out.println("출금완료 : " + balance);
					System.out.println("=======");
				}else {
					System.out.println("비밀번호를 확인해주세요.");
				}				
				
			} else if (num == 5) {
				///////////////////////////////				
				if(checkIdPassword(sc, id, pass)) {
					///////////////////////////////

					System.out.println("계좌를 삭제하시겠습니까? (Y/N)");					
//					yn = sc.next().charAt(0);
					st = sc.next();
					if((st.equalsIgnoreCase("y") || st.equalsIgnoreCase("n"))) {
						 id = -1;  
						 pass = -1;
						 balance=-1;
						System.out.println("삭제되었습니다.");
					}
					
				}else {
					System.out.println("비밀번호를 확인해주세요.");
				}	
				
			}

		}

	}

}

//Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시
//1을 입력하면 추가기능입니다. 출력구문까지만
//2를 입력하면 조회기능입니다. 출력구문까지만
//3을 입력하면 입금기능입니다. 출력구문까지만
//4를 입력하면 출금기능입니다. 출력구문까지만
//5를 입력하면 삭제기능입니다. 출력구문까지만
//9를 입력하면 종료합니다.    출력구문까지만
//
//Q2. 무한반복으로 메뉴나오게, 9 나오면 종료
//■ 힌트
//for(;;) { 
//System.out.println("숫자1을 입력하세요.");
//int a = scanner.nextInt();
//if(a == 1) { break;}
//}