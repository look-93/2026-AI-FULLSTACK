package com.the703.servlet;

public class User {	
	private String email;
	private String nickname;
	private String mobile;
	private String udate;
	private String bip;
	private String bpass;
	
	public String getBpass() {
		return bpass;
	}
	public void setBpass(String bpass) {
		this.bpass = bpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public String getBip() {
		return bip;
	}
	public void setBip(String bip) {
		this.bip = bip;
	}

}
