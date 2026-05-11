//package com.the703.v1;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Scanner;
//
//class BankInfo {
//	private String id;
//	private String pass;
//	private double balance;
//
//	public BankInfo() {
//		super();
//	}
//
//	public BankInfo(String id, String pass, double balance) {
//		super();
//		this.id = id;
//		this.pass = pass;
//		this.balance = balance;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getPass() {
//		return pass;
//	}
//
//	public void setPass(String pass) {
//		this.pass = pass;
//	}
//
//	public double getBalance() {
//		return balance;
//	}
//
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
//
//}
//
//class Bank {
//	List<BankInfo> list = new ArrayList<>();
//	Scanner sc = new Scanner(System.in);
//
//	public void showMenu() {
//		System.out.println();
//		System.out.println("WELCOME TO BANK SYSTEM");
//		System.out.println("======BANK======");
//		System.out.println("[1] ➕계좌추가");
//		System.out.println("[2] 🔍계좌조회");
//		System.out.println("[3] 💵계좌입금");
//		System.out.println("[4] 💸계좌출금");
//		System.out.println("[5] 🗑️계좌삭제");
//		System.out.println("[9] ⛔종료");
//		System.out.print("👉 번호를 선택하세요 : ");
//	}
//
//	public void addBankInfo() {
//		System.out.print("ID 입력: ");
//		String inputId = sc.next();
//		System.out.print("PASS 입력: ");
//		String inputPass = sc.next();
//		System.out.print("Balance 입력: ");
//		double inputBalance = sc.nextDouble();		
//		list.add(new BankInfo(inputId, inputPass, inputBalance));
//	}
//
//	public BankInfo authUser() {
//		System.out.print("ID 입력: ");
//		String inputId = sc.next();
//		System.out.print("PASS 입력: ");
//		String inputPass = sc.next();
//		for (BankInfo bankInfo : list) {
//			if (bankInfo.getId().equals(inputId) && bankInfo.getPass().equals(inputPass)) {
//				return bankInfo;
//			}
//		}
//		System.out.println("계좌를 찾을 수 없습니다.");
//		return null;
//	}
//
//	public void Withdrawal() {
//		BankInfo bankInfo = this.authUser();
//		if (bankInfo != null) {
//			System.out.print("입금 금액 > ");
//			double inputBalance = sc.nextDouble();
//			double balance = bankInfo.getBalance() + inputBalance;
//			bankInfo.setBalance(balance);
//		}
//	}
//
//	public void deposit() {
//		BankInfo bankInfo = this.authUser();
//		if (bankInfo != null) {
//			System.out.print("입금 금액 > ");
//			double inputBalance = sc.nextDouble();
//			double balance = bankInfo.getBalance() - inputBalance;
//			bankInfo.setBalance(balance);
//		}
//	}
//
//	public void showBalance() {
//		BankInfo bankInfo = this.authUser();
//		if (bankInfo != null) {
//			System.out.print(bankInfo.getBalance());
//		}
//	}
//
//	public void removeBankInfo() {
//		BankInfo bankInfo = this.authUser();
//
//		if (bankInfo != null) {
////			int idx = list.indexOf(bankInfo);
////			list.remove(idx);
//			list.remove(bankInfo);
//		}
//	}
//
//}
//
//public class BankProjectArrayList002 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int num = 0;
//
//		Bank bank = new Bank();
//
//		while (num != 9) {
//			bank.showMenu();
//			num = sc.nextInt();
//			if (num == 9) {
//				System.out.println("종료기능입니다.");
//			} else if (num == 1) {
//				bank.addBankInfo();
//			} else if (num == 2) {
//				bank.showBalance();
//			} else if (num == 3) {
//				bank.Withdrawal();
//			} else if (num == 4) {
//				bank.deposit();
//			} else if (num == 5) {
//				bank.removeBankInfo();
//			}
//		}
//	}
//}
//
///*
// * ver-1 - 조건문 : if, switch - 반복문 : for(시작,종료,변화), while(조건), do while(한번은 무조건실행
// * 맨끝에 추 무한반복(종료9){ 0. 메뉴판입력 [1] ➕계좌추가 ...
// * 
// * 1. [9] 종료 2. [1] ➕계좌추가 3. [2~5] 2-1. 사용자가 맞는지 여부 2.2. 조회면 조회기능, 입금이면 사용자에게
// * 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n입력받아서 계좌삭제 }
// * 
// * while(menu!=9){ 0. 메뉴판입력 [1] ➕계좌추가 ...
// * 
// * if(menu==9){ [9] 종료 } else if(menu==1){2. [1] ➕계좌추가} else { [2~5] 2-1. 사용자가
// * 맞는지 여부 임시 아이디입력받기 > 임시 비밀번호입력받기 > 저장되어 있는 아이디와 비밀번호가 임시 아이디와 비밀번호가 같으면 아래
// * 내용처리 2.2. 조회면 조회기능, 입금이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n입력받아서
// * 계좌삭제 switch(manu){ case 2: 조회처리 break; case 3: 입금받기 / 잔액에 입금받은돈 추가 case 4:
// * 출금받기 / 잔액에 출금받은돈 빼기(마이너스 통장x, 잔액없으면 출금안되게) break; case 5: 계좌삭제여부 , Y, y를
// * 입력받으면 계좌삭제 break; } } }
// * 
// */
