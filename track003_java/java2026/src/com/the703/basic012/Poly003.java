package com.the703.basic012;

/*
1. 클래스는 부품객체이다
2. 상속은 재활용
	Object		
	  ↑			  
	TestA3 (int a, toString)
 	  ↑		
 	TestB3 (int b, toString)
*/

class TestA3 extends Object {
	int a=10;
	@Override public String toString() { return "TestA3 [a=" + a + "]"; }	
}//end class

class TestB3 extends TestA3 {
	int b=20;
	@Override public String toString() { return "TestB3 [b=" + b + "]"; }	
}//end class

public class Poly003 {
	public static void main(String[] args) {
		System.out.println((int)1.1); //소수점이 짤림
		
		TestB3 tb = (TestB3) new TestA3(); // TestA3 cannot be cast to class
		//1) TestB3 tb {b=20, toString} - {a=10, toString}
		//2) new TestA3() 1번지 : {a=10, toString}
		//3) 보장범위 : tb {b=20, toString} - {a=10, toString}
		//													= {a=10, toString} // new TestA3()를 호출했기떄문에 TestB3{b=20, toString} 사용x
	}
}

/*
1. 다형성
- 많은 형상을 띄는 성품
- 여러 타입의 객체를 하나의 타입으로 관리

2. 부모는 자식을 담을 수 있다. (업캐스팅)
--------------------------------------
<<class>> Animal	[이름, 나이 / 먹기, 자기, 배변]
		   ↑
<<class>> Cat		[동물등록증 / 꾹꾹이 하기]
--------------------------------------
Animal ani = new Cat()
1) Animal ani 			{ 이름, 나이 / 먹기, 자기, 배변 }
2) 				Cat() → Animal()					→ Object()
{동물등록증 / 꾹꾹이 하기}		{ 이름, 나이 / 먹기, 자기, 배변 }

3. 자식을 부모를 담을 수 있다. (다운캐스팅)
--------------------------------------
<<class>> Animal	[이름, 나이 / 먹기, 자기, 배변]
		   ↓
<<class>> Cat		[동물등록증 / 꾹꾹이 하기]
--------------------------------------
Cat cat = new Animal()
1) Cat cat;
{동물등록증 / 꾹꾹이 하기} + { 이름, 나이 / 먹기, 자기, 배변 }	

2) new Animal()
{ 이름, 나이 / 먹기, 자기, 배변 }

3) 만족 못 시키는 범위가 생김
{동물등록증 / 꾹꾹이 하기}

4. 쓰는 이유는?
- 부모 타입으로 자식객체들을 관리가능(관리하려고 씀)

//하나의타입으로 여러 타입을 관리
Animal[] anis = {new Cat(), new Cat(), new Person(), new Person()}


*/