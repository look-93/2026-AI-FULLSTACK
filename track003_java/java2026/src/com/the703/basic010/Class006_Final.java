package com.the703.basic010;

import java.awt.Color;

//1. final 변경하지마
//1) 클래스는 부품객체
//2) 클래스는(상속:x) 상태(멤버변수:상수) 행위(멤버함수)
// final class 재사용하지마-상속
class FinalEx extends Object{
	static final String child = "5-5"; //클래스변수 - method area - new x - this x
	String name; //인스턴스변수  - heap area - new o - 생성자() - this o
	/*final*/ void show() {System.out.println(child + "\t" + name);} // 인스턴스메서드
}

class FinalExSon extends FinalEx{
	@Override void show() {System.out.println("나한테맞게수정");} //class FinalEx(부모클래스)의 show()함수에 final이 붙으면 사용x 
	
}

//class Test extends Color{}

public class Class006_Final {

	public static void main(String[] args) {
		//FinalEx.child = "";
		//The final field FinalEx.child cannot be assigned
		
	}

}

/*
final (하지마)

1) 클래스 (상속 x / 재사용 x / extends 사용못함)
2) 멤버변수 (상수를의미 / 값변경 x)
3) 멤버함수 (부모기능 수정 x / @Override 못함)

*/
