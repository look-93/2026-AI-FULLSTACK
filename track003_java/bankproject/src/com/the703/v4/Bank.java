package com.the703.v4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
	Scanner sc = new Scanner(System.in);
	List<BankInfo> list = new ArrayList<>();

	public void showMenu() {
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

	public void addBankInfo() {
		System.out.print("ID 입력: ");
		String id = sc.next();
		System.out.print("PASS 입력: ");
		String pass = sc.next();
		System.out.print("금액 입력: ");
		double balance = sc.nextDouble();
		list.add(new BankInfo(id, pass, balance));
	}

	public BankInfo ahthUser() {
		System.out.print("ID 입력: ");
		String inputId = sc.next();
		System.out.print("PASS 입력: ");
		String inputPass = sc.next();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(inputId) && list.get(i).getPass().equals(inputPass)) {
				return (BankInfo) list.get(i);
			}
		}
		
//		if(list.contains(new BankInfo(inputId,inputPass, 0))) {}
		System.out.println("계좌를 찾을 수 없습니다.");
		return null;
	}

	public void showBankInfo(BankInfo bankInfo) {
		System.out.println("BALANCE : " + bankInfo.getBalance());
	}

	public void deposit(BankInfo bankInfo) {
		double inputBalance = 0;
		System.out.print("금액 입력 : ");
		inputBalance = sc.nextDouble();
		bankInfo.setBalance(bankInfo.getBalance() + inputBalance);
		System.out.println("잔액 : " + bankInfo.getBalance());

	}

	public void Withdrawal(BankInfo bankInfo) {
		double inputBalance = 0;

		System.out.print("금액 입력 : ");
		inputBalance = sc.nextDouble();
		bankInfo.setBalance(bankInfo.getBalance() - inputBalance);
		System.out.println("잔액 : " + bankInfo.getBalance());

	}

	public void removeBankInfo(BankInfo bankInfo) {

		list.remove(bankInfo);
		System.out.println("계좌가 삭제되었습니다.");

	}
}

