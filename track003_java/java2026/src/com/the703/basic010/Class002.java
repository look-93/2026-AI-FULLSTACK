package com.the703.basic010;

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수,속성)와 행위(멤버함수,기능)를 갖는다
class FishBB{
	//멤버변수
	String bread;
	int ppat;
	//멤버함수
	void show() {System.out.println(bread + " 팥 " + ppat + "스푼");}
}
public class Class002 {

	public static void main(String[] args) {
		FishBB my1 = new FishBB();
		//1. new (1번지, 객체생성) 2. FishBB() 초기화 3. my1주소 = 1번지
		my1.bread = "도토리가루";
		my1.ppat  = 2; 
		my1.show();
	}

}
/*[RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] FishBB.class(■1.설계도:장난감) , Class002.class #1
------------------------------------
[HEAP:동적]						|		[STACK:지역]
			도토리가루		2
1번지:FishBB{bread=null,ppat=0.show()} <- my1[1번지]
						 				 main #2 (JVM구동)
------------------------------------
객체(■1.인스턴스-장난감만들기)	 객체(■3.갖고놀기)
*/
