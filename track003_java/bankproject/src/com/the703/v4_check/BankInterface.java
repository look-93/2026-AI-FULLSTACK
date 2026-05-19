package com.the703.v4_check;

public interface BankInterface {
	public void showMenu();
	public void addBankInfo();
	public BankInfo ahthUser();
	public void showBankInfo(BankInfo bankInfo);
	public void deposit(BankInfo bankInfo);
	public void Withdrawal(BankInfo bankInfo);
	public void removeBankInfo(BankInfo bankInfo);
	
}
