package com.the703.basic014;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//1. 클래스는 부품객체
//2. 상태(멤버함수:클래스변수, 인스턴스변수)와 행위(멤버함수)
class UserDto{
	//멤버변수
	private static int cnt=0; // 클래스변수(static) - mathod area - 각각 x - 공용
	private final int no;  // final 수정x 
	private String email;    // 인스턴스변수 - heap area - new o - 생성자 o - this 각각 
	
	//멤버함수						기본값 - 명시적초기화 - 초기화블록 - 생성자
	//(생성자, toString, getters/setters)
	public UserDto() { this.no = ++cnt; } //유저번호 = 값; 값 1개증가 넣고		
	public UserDto(int no, String email) { super(); this.no = no; this.email = email; }
	public UserDto(String email) {
		this();
		this.email = email;
	}
	@Override public String toString() { return "UserDto [no=" + no + ", email=" + email + "]"; }	
	
	public static int getCnt() { return cnt; }
	public static void setCnt(int cnt) { UserDto.cnt = cnt; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public int getNo() { return no; }
	
	//1. 클래스가 맞는지 확인(UserDto, email/no)
	@Override
	public int hashCode() {
		return Objects.hash(email); // 객체들의 값
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email); 
	}	
	
}

public class List002 {
	public static void main(String[] args) {
		//add, get, size, remove, contains
		List<UserDto> users = new ArrayList<>();
		
		users.add(new UserDto("aaa@gmail.com"));
		users.add(new UserDto("bbb@gmail.com"));
		
		System.out.println(users);		
		System.out.println("1. get > " + users.get(0));
		System.out.println("2. size > " + users.size());
//		System.out.println("3. remove > " + users.remove(1));
		
		System.out.println("4. contains > " + users.contains(new UserDto("aaa@gmail.com"))); // hashCode alt + shift + s 
		System.out.println("4. contains > " + users.contains(new UserDto("bbb@gmail.com"))); // hashCode
		
//		UserDto dto = users.get(0);
//		System.out.println("INFO" + (0+1) + dto.getNo() + "/" + dto.getEmail());
		
		int cnt = 0;
		for(UserDto u : users) {
			System.out.println("INFO" + (cnt++ +1) + u.getNo() + "/" + u.getEmail());
		}
		
		
		
//		for(int i=0;i<users.size();i++) {
////			System.out.println(users.get(i));
//			UserDto d = users.get(i); //[no=1, email=aaa@gmail.com]
//			System.out.println(d.getEmail());
//		}
		
	}
}
