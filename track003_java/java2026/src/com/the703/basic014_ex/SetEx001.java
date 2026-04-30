package com.the703.basic014_ex;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class UserInfo2 {
	private int no; 
	private  int age;
	private  String name;
	public UserInfo2() { super(); }
	public UserInfo2(int no, int age, String name) { super(); this.no = no; this.age = age; this.name = name; }
	public UserInfo2(String my) {
		
		this.name = my;
	}
	@Override public String toString() { return "UserInfo2 [no=" + no + ", age=" + age + ", name=" + name + "]"; }
	@Override public int hashCode() { return Objects.hash(name); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo2 other = (UserInfo2) obj;
		return Objects.equals(name, other.name);
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}

public class SetEx001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<UserInfo2> users = new HashSet<>();
		String name=""; double avg=0;
		
		users.add(new UserInfo2(1, 50, "아이언맨"));
		users.add(new UserInfo2(2, 40, "헐크"));
		users.add(new UserInfo2(3, 120, "캡틴"));
		users.add(new UserInfo2(3, 120, "캡틴"));
		for(UserInfo2 u : users) {
			System.out.println(u.getNo()+"-"+u.getName()+"-"+u.getAge());
			avg += u.getAge(); //유저나이누적
		}	
		
		System.out.print("> 찾을 유저이름 : ");
		name = sc.next();

		for(UserInfo2 u : users) {
			if(u.getName().equals(name)) {
				System.out.println(u.toString());
				break;
			}			
		}
		
//		double a = 0;
//		a = avg/users.size();
//		System.out.println(a);
		
		System.out.println("나이평균 > " + avg/users.size());
//		System.out.println(users.contains(new UserInfo2(name)));
		
//		System.out.println(new UserInfo2(name));

	}

}


//연습문제1)  Collection  Framework  
//패키지명 : com.company.java014_ex
//클래스명 : SetEx001
//1. UserInfo2    Dto 클래스만들기  - 속성 : private int no; private  String name; private  int age;
//2. users   HashSet만들기
//3. 다음의 데이터 넣기
//   new UserInfo2(1, "아이언맨" , 50) , 
//   new UserInfo2(2, "헐크" , 40) , 
//   new UserInfo2(3, "캡틴" , 120), 
//   new UserInfo2(3, "캡틴" , 120)
//4. 향상된 for 이용해서 데이터 출력 (3명만 출력되게- 같은자료 중복안되게)
//5. 사용자들의 이름 입력받기 - 이름을 입력받으면 해당하는  유저의 자료출력
//6. 사용자들의 나이 평균처리
//
//출력된 화면 : 
//2 - 헐크 - 40
//3 - 캡틴 - 120
//1 - 아이언맨 - 50
//> 찾을 유저이름 : 
//캡틴
//UserInfo2 [no=3, name=캡틴, age=120]
//나이평균 > 70.0