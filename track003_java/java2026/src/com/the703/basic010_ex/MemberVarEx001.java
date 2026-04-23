package com.the703.basic010_ex;

/*
1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
인스턴스변수 : pay
클래스변수 : su, basicpay, basicpay2
지역변수 : pay

2. 인스턴스메서드, 클래스메서드 구분하시오.
인스턴스메서드 : showAll001()
클래스메서드 : showSu(), showPay(), showAll002()

3. 오류나는 이유는?
1. pay는 인스턴스변수 showAll001() 는 인스턴스함수 여서 
   메모리상 new 보다 먼저 올라가는 클래스함수, 클래스변수에서 사용할수 없음.
   메모리상 올라가는 순서가 달름.
	main에서 객체 생성 후 사용가능
*/

//////////////////////////////////////////////////////
/// runtime data area 위치영역 그림그리기
/* [RUNTIME DATA AREA]
---------------------------------------------------------------------------------------------------
[METHOD:정보]  Sawon3.class   MemberVarEx001#1)
Sawon3.su=10;    Sawon3.basicpay2;     Sawon3.basicpay;  Sawon3.showSu()    Sawon3.showAll002()
---------------------------------------------------------------------------------------------------
[HEAP:동적]            |  [STACK:지역]

1번지:{pay=10000,
showAll001()}   ←  sola[1번지]       -  1) new 2) 생성자  3) 번지  - new해서 객체생성 후 사용가능
main #2)
------------------------------------
*/
//////////////////////////////////////////////////////

class Sawon3{ 
    int pay      =10000;    			//1)인스턴스변수 - new - heap area - 생성자관련 - this
    static int su=10;     				//2)클래스변수 - static - method area - 공용 - 클래스명.변수명
    static int basicpay; /*= pay;*/  	//3)클래스변수 = 인스턴스변수 - static은 인스턴스변수 (this)불가
    static int basicpay2;    			//4)클래스변수 - static - method area - 공용 - 클래스명.변수명
    
    public static void showSu() {   System.out.println(su);  }         //5)클래스메서드 
    //public static void showPay() {   System.out.println(this.pay);  }  //6)클래스메서드
    //static은 인스턴스변수 (this)불가
    
    public  void  showAll001() {   //7)인스턴스 메서드(static x)
       System.out.println(su);  
       System.out.println(this.pay);   // new 객체를 만들어서 사용
    } 
    public static  void  showAll002() { //8) 클래스메서드(static o)
       //showAll001();    				//   인스턴스 메서드 - this 사용불가
       //System.out.println(this.pay);
    } 
} 


public class MemberVarEx001 {

	public static void main(String[] args) {		
		   Sawon3   sola = new Sawon3();  
		   sola.showAll001();	
	}

}

//패키지명 : com.company.java010_ex
//클래스명 :  MemberVarEx001
//-- class Sawon3작성해주세요 
//1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
//2. 인스턴스메서드, 클래스메서드 구분하시오.
//3. 오류나는 이유는?
//class Sawon3{ 
//    int pay      =10000;    
//    static int su=10;     
//    static int basicpay=pay;    
//    static int basicpay2;    
//    
//    public static void showSu() {   System.out.println(su);  }          
//    public static void showPay() {   System.out.println(this.pay);  }    
//  
//    public  void  showAll001() {   
//       System.out.println(su);  
//       System.out.println(this.pay);  
//    } 
//    public static  void  showAll002() {   
//        showAll001();    
//       System.out.println(this.pay);
//    } 
//} 
//public class MemberVarEx001{
//  public static void main(String[] args) {
//   Sawon3   sola = new Sawon3();  
//   sola.showAll001();
//  }
//}

