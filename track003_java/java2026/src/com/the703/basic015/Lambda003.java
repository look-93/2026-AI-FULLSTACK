package com.the703.basic015;

class RefClass {
	void method(String str) {
		System.out.println(str);
	}
}

interface InterUsing {
	void inter(RefClass c, String str);
}

public class Lambda003 {
	public static void main(String[] args) {
		//#1. 익명클래스
		InterUsing a1 = new InterUsing(){
			@Override
			public void inter(RefClass c, String str) {
				c.method(str);
			}			
		};		
		a1.inter(new RefClass(), "Hello"); //부품객체(RefClass의 기능박스(method)를 사용)
		
		//#2. 람다 ()->{} [RefClass]의 [method]를 사용 - 클래스가 가진 기능 사용
//		InterUsing a2 = (RefClass c, String str) -> {c.method(str);};			
		InterUsing a2 = (c, str) -> c.method(str);
		a2.inter(new RefClass(), "Hello :)");
		

		//#3. :: 표현식(참조)
		
		//구조를 알고있다는 가정하에 사용
//		class 	    RefClass { void method(String str) { System.out.println(str); } } 
//		interface InterUsing { void inter(RefClass c, String str); } 
		InterUsing a3 = RefClass::method; // 자동연결 1)RefClass 2)method
		a3.inter(new RefClass(), "Hello :) :)");
		
		////////////////////////////////////////////////////////////////////////

		//interface  InterBasic{  int method(int a, int b);         }  
		InterBasic basic1 = (int a,int b) -> {
			return Math.max(a,b);
		}; //max -> static(바로사용가능)
		System.out.println(basic1.method(10, 3));
		
		InterBasic basic2 = (a,b) -> Math.max(a,b);
		System.out.println(basic2.method(10, 3)); //Math부품, max사용 -> static(바로사용가능)
		
		InterBasic basic3 = Math::max;
		System.out.println(basic3.method(10, 3)); //Math부품, max사용 -> static(바로사용가능)
		
		InterBasic basic4 = (a,b) -> Math.min(a,b);
		System.out.println(basic4.method(10, 3)); //Math부품, max사용 -> static(바로사용가능)		
		
		InterBasic basic5 = Math::min;
		System.out.println(basic5.method(10, 3)); //Math부품, min사용 -> static(바로사용가능)
				
		//String.compareTo
		InterString basic6 = (a,b) -> a.compareTo(b);
		System.out.println(basic6.compare("apple", "bansns")); //-1
		//문자열이 같으면 0, (음수)a<b a가 b보다 앞에와요~, (양수)a>b a가 b보다 뒤에와요~
		
		//String.compareTo //int java.lang.String.compareTo( String anotherString )
		//String 부품객체, compareTo 가능
		InterString basic7 = String::compareTo; 
		System.out.println(basic7.compare("apple", "bansns"));
		
		//interface  InterParse{  int parse(String s);              } 
		InterParse basic8 = s -> Integer.parseInt(s);	//Integer부품의 parseInt기능사용
		System.out.println(basic8.parse("10") + 3);		//13 문자열을 숫자로
		//-> 참조형
		InterParse basic9 = Integer::parseInt;
		System.out.println(basic9.parse("10") + 3);	
		
		//Math::abs
		//interface  InterAbs  {  int apply(int a);                 }  
		InterAbs basic10 = a -> Math.abs(a);	// Math 부품의 abs사용
		System.out.println(basic10.apply(-10));	// abs: 절대값으로 변경하는 기능박스
		//->참조형
		InterAbs basic11 = Math::abs;
		System.out.println(basic11.apply(-10));		
		
		//System.out::println
		//interface  InterPrint{  void print(String s);             }
		InterPrint basic12 = s -> System.out.println(s); //System.out 부품의 println 기능사용
		basic12.print("Hello Lambda");
		//->참조형
		InterPrint basic13 = System.out::println;
		basic13.print("Hello Lambda");		
		
		//interface  Ex1{  int getLength(String s);  }   
		Ex1 ex1 = s -> s.length();
		System.out.println(ex1.getLength("hello")); // 결과5
		//->참조형
		Ex1 ex2 = String::length;
		System.out.println(ex2.getLength("hello")); // 결과5
		
		//interface  Ex2{  void print(String s);     }  
		Ex2 ex3 = s -> System.out.println(s);
		ex3.print("lambda:)"); //결과 lambda:)
		//-> 참조형
		Ex2 ex4 = System.out::println;
		ex4.print("lambda:)"); //결과 lambda:)
	}
}

interface  InterBasic{  int method(int a, int b);         }  
interface  InterString{ int compare(String a, String b);  }

interface  InterParse{  int parse(String s);              }  
interface  InterAbs  {  int apply(int a);                 }  
interface  InterPrint{  void print(String s);             }  

interface  Ex1{  int getLength(String s);  }   
interface  Ex2{  void print(String s);     }  
