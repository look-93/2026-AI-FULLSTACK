package com.the703.v1;

import java.util.Scanner;

public class BankProjectV1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int id  = -1, pass = -1, balance=-1, tbalance=-1;;
		int tid = -1, tpass = -1; // 임시변수

		String st="";
		
		while(num!=9) {
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
			
		 	if(num==9){
		 			System.out.println("종료기능입니다."); 
		 			break; 
		 			}
		 	else if(num==1) {
				System.out.print("ID 입력: ");
				id = sc.nextInt();
				System.out.print("PASS 입력: ");
				pass = sc.nextInt();
				System.out.print("금액 입력: ");
				balance = sc.nextInt();		 		
		 	}
		 	else { 
				System.out.print("ID 입력: ");
				tid = sc.nextInt();
				System.out.print("PASS 입력: ");
				tpass = sc.nextInt();
				if(id == tid && pass == tpass) {
					switch(num) {
					case 2:
						System.out.println("ID : " + id);
						System.out.println("PASS :" + pass);
						System.out.println("금액 : " + balance); 
						break;
					case 3:
						System.out.print("입금잔액 : ");
						
						balance += sc.nextInt();
						tbalance = balance;
						System.out.println("=======");
						System.out.println("입금완료 : " + balance);
						System.out.println("=======");
						break;
					case 4:
						System.out.print("출금잔액 : ");
						
						balance -= sc.nextInt();		
						
						if(balance<0) {
							System.out.println("출금할 잔액이 없습니다.");
							balance = tbalance;
							break;
						}
						
						System.out.println("=======");
						System.out.println("출금완료 : " + balance);
						System.out.println("=======");
						break;
					case 5:
						System.out.println("계좌를 삭제하시겠습니까? (Y/N)");
						st = sc.next();
						if(st.equalsIgnoreCase("y")) {
							 id = -1;  
							 pass = -1;
							 balance=-1;
							 tbalance=-1;
							 tid = -1;
							 tpass = -1;
							System.out.println("삭제되었습니다.");
						}
						break;					 
					}
					
				}else {
					System.out.println("비밀번호를 확인해주세요.");
				}
		 			
		 	}
			
		}
		
	}

}

/*
 * ver-1
 - 조건문 : if, switch 
 - 반복문 : for(시작,종료,변화), while(조건), do while(한번은 무조건실행 맨끝에 추
 무한반복(종료9){
 	0. 메뉴판입력
 	[1] ➕계좌추가 ...
 	
 	1. [9] 종료
 	2. [1] ➕계좌추가
 	3. [2~5]
 		2-1. 사용자가 맞는지 여부
 		2.2. 조회면 조회기능, 입금이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n입력받아서 계좌삭제	
 } 
 
 while(menu!=9){
 	0. 메뉴판입력
 	[1] ➕계좌추가 ...
 	
 	if(menu==9){ [9] 종료 }
 	else if(menu==1){2. [1] ➕계좌추가}
 	else { [2~5]
		 	2-1. 사용자가 맞는지 여부
		 	임시 아이디입력받기 > 
		 	임시 비밀번호입력받기 > 
		 	저장되어 있는 아이디와 비밀번호가 임시 아이디와 비밀번호가 같으면 아래 내용처리
		 	2.2. 조회면 조회기능, 입금이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n입력받아서 계좌삭제	
		 	switch(manu){
		 		case 2: 조회처리 break;
		 		case 3: 입금받기 / 잔액에 입금받은돈 추가
		 		case 4: 출금받기 / 잔액에 출금받은돈 빼기(마이너스 통장x, 잔액없으면 출금안되게) break;
		 		case 5: 계좌삭제여부 , Y, y를 입력받으면 계좌삭제 break;
		 	}
 		}
 }
 
 */
