package com.the703.basic010_ex;
//1. 클래스는 부품객체
//2. 상태(멤버변수) 행위(멤버함수)
//3. 생성자 - 초기화
class Coffee{
	String name;  int  price, num;
	void show(){
		System.out.printf("=====커피\n커피명 : %s\n커피잔수 : %d\n커피가격 : %d",name,num,price);
	}   //커피정보출력
	
	public Coffee() {
		this.name="아메리카노";
		this.num = 1;
		this.price = 2000;
	};
	public Coffee(String name, int num, int price) {
//		System.out.printf("=====커피\n커피명 : %s\n커피잔수 : %d\n커피가격 : %d",name,num,price);
		this.name = name;
		this.num = num;
		this.price = price*2;		
	}
}

public class ClassEx003 {

	public static void main(String[] args) {
	   Coffee a1 = new Coffee("까페라떼" ,2 , 4000);  
	   a1.show();
	   System.out.println();
	   Coffee a2 = new Coffee();                     
	   a2.show();

	}

}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] Coffee.class ClassEx003.class#1
------------------------------------
[HEAP:동적]            |  		[STACK:지역]
1번지:
{name, num, price, show()}
								 main#2
------------------------------------
*/
//////////////////////////////////////////////////////
/// 
//연습문제1)  class
//패키지명 : com.the703.basic010_ex
//클래스명 :  ClassEx003
//-- 생성자 작성하시오.
//class Coffee{
//  멤버변수 : String name;  int  price, num;
//  멤버함수 : void show(){}   //커피정보출력
//}
//public class Class003 {
//   public static void main(String[] args) {
//   Coffee a1 = new Coffee("까페라떼" ,2 , 4000);  a1.show();
//   Coffeea2 = new Coffee();                     a2.show();
//  }
//}
//출력내용 :
//=====커피
//커피명 : 까페라떼
//커피잔수 : 2 
//커피가격 : 8000
//=====커피
//커피명 : 아메리카노
//커피잔수 : 1
//커피가격 : 2000
