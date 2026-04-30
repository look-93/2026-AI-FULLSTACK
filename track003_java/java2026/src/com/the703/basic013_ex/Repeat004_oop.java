package com.the703.basic013_ex;

abstract class Fruit {
	@Override public String toString() { return "Fruit "; }
	public abstract void myfruit();
}

class Apple extends Fruit{
	@Override
	public void myfruit() {
		System.out.println("사과는 빨갛다");		
	}
}
class Banana extends Fruit{
	@Override
	public void myfruit() {
		System.out.println("바나나는 노랗다.");		
	}	
}
class Coconut extends Fruit{
	@Override
	public void myfruit() {
		System.out.println("코코넛은 코코하다.");		
	}	
}
public class Repeat004_oop {
	public static void main(String[] args) {
	 	Fruit [] fruits = {new Apple() , new Banana() , new Coconut()};
	 	// 부모			= 자식들
	 	// 다형성 : 한개의 자료형(부모)으로 여러개의 객체들(자식들)을 관리
	 	Fruit fruit1 = new Apple();
	 	Fruit fruit2 = fruits[0];
	 	for(Fruit f: fruits) {   f.myfruit(); } 
	}
}
/* 
     Fruit
↑       ↑       ↑
Apple  Banana  Coconut

*/
 

/*
📝 문제: OOP 개념(4) — 추상화 / 인터페이스
Q1. abstract란 무엇인가?
- (is A) : 고양이는 동물이다.
  공통기능을 일반화하여 자식클래스가 구체적으로 구현하도록 강제(무조건해야함)
  extends 로 확장

Q2. interface란 무엇인가?  
- (can do this) : ~ 할 수 있어요
- 구현객체를 통해서 특정 기능을 수행할 수 있다고 약속을 정의

Q3. abstract와 interface의 공통점과 차이점을 설명하시오.
- 공통점 : 자식클래스를 통해서 설계부분을 구현
- 차이점 : 추상화정도가 인터페스가 더 높다.
  abstract (추상클래스)  : 일반클래스 + 설계, 멤버변수/멤버함수 포함
  interface           : 설계, 상수(public static final)/ 추상메서드(public abstract)

Q4. 다음과 같이 출력되게 코드를 작성하시오.
1) 출력 화면: 
사과는 빨갛다.
바나나는 노랗다.
코코넛은 코코하다.

2) 상속도:

코드
		Fruit (myfruit)
	↑	    ↑	      ↑
  Apple   Banana   Coconut 
{@myfruit}  {@myfruit} {@myfruit}

3) 주어진코드
abstract class Fruit {
    @Override public String toString() { return "Fruit"; }
    public abstract void myfruit();
}
public class Abstract005 {
    public static void main(String[] args) {
        Fruit[] fruits = { new Apple(), new Banana(), new Coconut() };
        for (Fruit f : fruits) {
            f.myfruit();
        }
    }
}

 
*/