package com.the703.v4_check;

import java.util.Objects;

public class BankInfo {
	private String id;
	private String pass;
	private double balance;

	public BankInfo() {
		super();
	}

	public BankInfo(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	}
	
	public BankInfo(String id) {
		this.id = id;
	}	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// HashCode/ equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankInfo other = (BankInfo) obj;
		return Objects.equals(id, other.id);
	}
	
}
