package com.the703.basic013;

class Papa{int brain;}
class Mama{int brain;}
//class Son extends Papa, Mama{} 자바에서의 상속은 단일상속 해당코드 오류남

interface Animal2{
	String company = "(주) 메가스터디"; 
	// company에 마우스 - sf: static final   - Animal2.company(클래스변수) - method area, new x, this 각각x
	void eat();						
	// eat에 마우스 - a : abstract {}구현부가없음 - 구현클래스에서 상세내용 구혀
}

class Saram implements Animal2{
	@Override public void eat() {
		//company = "kakao"; // final 변경x
		System.out.println(Animal2.company + " 랍스타...냠냠 ");
	}
}

class Pig implements Animal2{
	@Override
	public void eat() {
		System.out.println(Animal2.company + " 꾸꾸리...냠냠 ");
	}
	
}

public class Interface001 {

	public static void main(String[] args) {
		//Animal2 ani = new Animal(); // x 설계도임 상수, 추상메서드
		Animal2 [] anis = {new Saram(), new Saram(), new Pig(), new Pig()};
		for(Animal2 a : anis) {
			a.eat();
		}
/* 속이빈점선
		Animal2{company = "(주)메가스터디"/eat}
		△		△
  Saram{@eat()} Pig{@eat()}
*/
	}

}

/*
1. interface
- 개발코드 변경없이 객체를 바꿔낄 수 있는 역할

2. abstract (Is A : 고양이는 동물이다) vs interface (can do this)
- 추상화 정도가 interface 가 더 높다
1) abstract  - 인스턴스변수, 일반에서드, 추상메서드 가질 수 있으나
2) interface - 상수(public static final) + 추상메서드(public abstract)

3. 프로젝트 진행시 interface 사용하면
다른구성원들이 각각의 부분을 완성할때까지 기다리지 않고
규약만 정해놓고 본인부분만 작성

4.형식
interface 인터페이스명{
	상수; 		//public static final
	추상메서드;		//public abstract - {} x , this x
}

class 클래스명 implements 인터페이스명{}

class 클래스명 extends 클래스명 implements 인터페스명1, 인터페이스명2{}
	구현력이 없어서 다중상속이 가능
*/