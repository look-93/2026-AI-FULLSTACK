package com.the703.basic010;

//1. 클래스는 부품객체
//2. 클래스 상태(멤버변수)와 행위(멤버함수)를 갖는다.
class Farm{

	//상태(멤버변수)
	String name; //인스턴스변수 - heap area = new 연관 o - 생성자를 호출해 값 초기화
	int age;	
	static String FarmName="(주)동물농장"; //클래스변수 - 클래스명.변수명 명시적초기화
	static int FarmNum;	// 클래스변수 - method area - new 연관x - 생성자x (바로 메모리에 올라감)
	static String FormBoss;
	static {FarmNum = 2; FormBoss="신동엽";} //초기화블록
	
	//행위(멤버함수)
	// ststic(클래스메서드)에서는 인스턴스변수 사용x
	static void numPlus() { FarmNum++; /*this.age++*/ } //클래스메서드 - 클래스명.메서드명 - method area - static(메모리상 new 보다 먼저 올라감)
	
	void show() { //인스턴스 메서드 - heap area - new 연관 o - 생성자와 관련o
		System.out.println("\n\n:::::::::::"); 
		System.out.println("::이름 : " + this.name);
		System.out.println("::나이 : " + this.age);
		System.out.println("::동물농장 인원 : " + Farm.FarmNum); // 인스턴스메서드에서는 static(클래스변수) 사용가능
	}
	
} 
public class Class005 {
	public static void main(String[] args) {
		System.out.println("\n\n 동물농장");
		System.out.println("::회사이름 >" + Farm.FarmName);
		System.out.println("::회사사장 >" + Farm.FormBoss);
		System.out.println("::회사인원 >" + Farm.FarmNum);
		
		System.out.println("\n\\n 동물식구 - this - 각각");
		Farm cat = new Farm(); // 1)new 객체만들기 2) Farm()초기화 3) cat번지
		cat.name = "kitty"; cat.age = 2; Farm.numPlus(); cat.show(); 
		
		Farm dog = new Farm(); // 1)new 객체만들기 2) Farm()초기화 3) dog번지
		dog.name = "뽀삐"; dog.age = 3;   /*dog.numPlus()*/ Farm.numPlus(); 
		dog.show();
		
	}

}
//////////////////////////////////////////////////////
/*
초기화
	순서			기본값	명시적초기화	초기화블록		생성자
	
	FarmName  	null	(주)동물농장	(주)동물농장	x
	FarmNum 	0		0			2			x
	FormBoss	null	null		신동엽		x
-------------------------------------------------------
 	cat		name=null →			→			→
 			age=0	
 	dog		name=null →			→			→
 			age=0	

*/

//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA] 
------------------------------------------------------
[METHOD:정보, static, final] Farm.class Class005.class 
Farm.FarmName="(주)동물농장";  Farm.FormBoss="신동엽"; Farm.FarmNum = 2; Farm.numPlus()
------------------------------------------------------
[HEAP:동적]            					|  [STACK:지역]
2번지{name="뽀삐"   , age=3} 				<-		dog(2번지)	
1번지{name="kitty" , age=2} 				<-		cat(1번지)											
------------------------------------------------------
(인스턴스)
*/

/*
1. 초기화순서
기본값         명시적초기화      초기화블록      생성자

 4-1)   [ 기본값     ]   : String ,객체 - null /  int - 0 으로 초기화
 4-2)   [ 명시적초기화 ]   :  int a=10;    중요콘텐츠 명시적으로 알림!    
 4-3)   [ 초기화블록  ]   :  { a=10; b=20; }   여러개초기화시
 4-4)   [ 생성자     ]   : 최종은 생성자에서 사용함.  인스턴스변수 초기화


2. runtime data area
[ mtehod area   ]  : 정보저장 , static, final
[ heap area     ]  : 동적저장 - new ,  gc( garbage collecetor)가 처리소멸
[ stack   ]  : 임시값저장

3. static
- jvm 소스로딩시 메모리 할당받음
- new연산자보다 먼저 실행되어 메모리(method 영역:runtime)에    (   1    )    회 생성
- 클래스명.변수명  / 클래스명.메서드명   - 클래스변수/클래스메서드 Calc.name
- 객체생성과 관련이 (  x  )
- 인스턴스로 접근시 권장사항이 아니므로 경고발생
*/
