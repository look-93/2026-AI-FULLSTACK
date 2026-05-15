package com.the703.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1. Dto 데이터전송목적
class BankDto{
	private String id;
	private String pass;
	private double balance;
	
	public BankDto(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	} 
	
}

class Bank{
	List<BankDto>  users;   // 객체를 생성하는게 아니라 정보만 받을 목적
	
	public Bank() { super(); }
	public Bank(List<BankDto> users) { super(); this.users = users; }
	
	Scanner sc = new Scanner(System.in);
	
	// 메뉴 - 안에 내용작성
	public void menu() {
		System.out.println("WELCOME TO BANK SYSTEM");
		System.out.println("======BANK======");
		System.out.println("[1] ➕계좌추가");
		System.out.println("[2] 🔍계좌조회");
		System.out.println("[3] 💵계좌입금");
		System.out.println("[4] 💸계좌출금");
		System.out.println("[5] 🗑️계좌삭제");
		System.out.println("[9] ⛔종료");
		System.out.print("👉 번호를 선택하세요 : ");		
	}   
	// 유저추가  (add)
	void add() {
		String inputId, inputPass; 
		double inputBalance;
		
		System.out.print("아이디를 입력하세요 > ");
		inputId = sc.next();
		System.out.print("비밀번호를 입력하세요 > ");
		inputPass = sc.next();
		System.out.print("금액을 입력 입력하세요 > ");
		inputBalance = sc.nextDouble();

		//처리 
		users.add( new BankDto(inputId , inputPass , inputBalance) );
		//출력
		System.out.println("계좌추가 완료되었습니다.");
	}
	// 유저로그인 			- 유저정보  BankDto login(){ }
	BankDto login(){ return null; }
	
	// 입금   (get) 		- 
	void deposit(BankDto user){}
	
	// 출금   (get)		- 
	void withdraw(BankDto user){}
	
	// 유저삭제(remove)	- 
	void delete(BankDto user){}
	
	// 종료   			- 
	void exit(){} 
}
public class BankCollect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = -1;
		
		List<BankDto>  users = new ArrayList<>();
		Bank      controller = new Bank(users);
//		System.out.println(controller);
		
		while(menu != 9) {			
			controller.menu();
			System.out.print("메뉴를 입력하세요 > ");
			menu = sc.nextInt();
			
			if(menu == 1) {
				controller.add();
			}
			
		}
		
		
		
		//테스트용
		//		controller.add();
		//		System.out.println(controller.users);
	}
}




