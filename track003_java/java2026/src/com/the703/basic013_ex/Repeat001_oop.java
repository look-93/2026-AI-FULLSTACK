package com.the703.basic013_ex;

public class Repeat001_oop {

	public static void main(String[] args) {
		

	}

}


/*
## 📝 문제: OOP 개념(1)

다음 코드를 보고 질문에 답하시오.
Q1. OOP란 무엇인가? 
- Object Operated Programming
-  틀		기반		프로그래밍
- 부품객체(클래스) 조립(구성)해서 프로그램밍을 구성하는 방법
- 클래스는 부품객체
- 객체 지향 프로그래밍
- 객체 상태(멤버변수)와 행위(멤버메서드)
- 부품객체를 조립해서 완성된 프로그램을 만드는 기법

Q2. OOP의 핵심 개념은 무엇인가?
캡슐화 : 외부접근제한 / 
       외부에서 직접 접근하지 못하게 보호
다형성 : 하나의 타입으로 여러 타입을 관리, 확장성
상속  : 클래스의 재사용
추상화 : 핵심기술을 추출해서 만든 모델링 / 
	   핵심적인 기능을 단순화해서 하는 설계(abstract vs interface)

Q3. 상속도를 그리시오.
Object
   ↑
Parent
   ↑
Child  
   
Q4. 각 객체에서 사용할 수 있는 멤버변수와 메서드를 적으시오.

object
   ↑
Parent {x=100, method() -> Parent method}
   ↑
Child  {x=200, @method() -> Child method}

Q5. Parent p = new Child(); 실행 시 객체 생성, 초기화, 참조값을 설명하시오.
1. new 객체생성, 주소/ child() 초기화 / p(주소값)

----
mtehod area (정보, static, final) - Parent.class, Child.class, 
								   Repeat001_oop.class #1

	heap										stack
	
#4) Child() -호출> parent() -호출> object()
Object() {								}
Parent() {x=100, mathod()->Parent method}
Child()  {x=200, @method()->Child method}
#3) new  1번지)Parent{x,method()}			 	 <-p[1번지] #5
	
												[main] #2
----
※설명 
new 실행되면서 #3 객체생성 (틀) method 값 정의안됨
Child() 호출되면서 Parent Object 호출되면서 쓸수있게해주면서 값 초기화

타입은 Parent타입 부모 = 객체
----

Q6. Parent 클래스의 멤버변수/메서드의 종류와 메모리 구조를 설명하시오.
- 멤버변수:  int x=100 - 인스턴스변수 - heap area - new o - 생성자 - this o 각각
- 메서드 : void method() - 인스턴스메서드 - heap area - new o - 생성자 - this o

Q7. 출력 결과를 쓰시오.
- p.x의 값은?  100
- p.method() 실행 시 어떤 메서드가 호출되는가?   Child method
- c.x의 값은?  200 
- c.method() 실행 시 어떤 메서드가 호출되는가? 	Child method

Q8. @Override 키워드의 의미와 코드에서 오버라이딩된 부분을 설명하시오.
- 상속 시 부모 클래스의 메서드를 자식클래스에서 재정의한 것
- Parent method()가 Child에서 오버라이팅
- void method()

Q9. Child c = new Child(); 호출 시 생성자 호출 순서와 객체 생성 순서를 설명하시오.
//타입 사용할 수 있는 범위 Child{x=200, @mathod()} - {x=100, mathod()}
// 생성자 호출 순서 : Child() => Parent() -> Object()
// 객체생성 순서 :  Object -> Parent -> Child

	 생성자호출순서				  객체생성순서
Object	#3{						}#4
  ↑
Parent  #2{  x = 100, mathod	}#5
  ↑	
 Child  #1{  x=200, @mathod()	}#6
 
class Parent {
    int x = 100;
    void method() { System.out.println("Parent method"); }
}

class Child extends Parent {
    int x = 200;
    void method() { System.out.println("Child method"); }
}

public class Repeat001_oop {
    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();
		// 타입 Child{x=200, @mathod()} - {x=100, mathod()}
		//  [2번지]  {x=200, @mathod()} - {x=100, --------}
		
        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }
}


*/