package com.the703.v5;

import java.util.Scanner;

public class BankProjectArrayList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;

		Bank bank = new Bank();

		while (num != 9) {

			bank.showMenu();
			num = sc.nextInt();

			if (num == 9) {
				System.out.println("종료기능입니다.");
			} else if (num == 1) {
				bank.addBankInfo();
			}
			else {
				BankInfo bankInfo = bank.ahthUser();
				if (bankInfo == null) {
					System.out.println("유저정보를 확인");
					continue;
				}
				switch (num) {
				case 2:
					bank.showBankInfo(bankInfo);
					break;
				case 3:
					bank.deposit(bankInfo);
					break;
				case 4:
					bank.Withdrawal(bankInfo);
					break;
				case 5:
					bank.removeBankInfo(bankInfo);
					break;
				}

			}

		}
	}
}
