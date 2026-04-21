package com.the703.basic010_ex;

class Student001 {
	String name;
	int no, kor, eng, math;

	void info() {
		int total=0;
		double avg=0;
		total = kor+eng+math;
		avg = total/(double)3;
		
		System.out.printf("이름: %s\n총점: %d\n평균: %.2f",name,total,avg);
	};
}

public class ClassEx001 {

	public static void main(String[] args) {
		Student001 s1 = new Student001(); //객체생성 1)생성자-초기화 3)s1주소
		s1.name = "first";
		s1.no = 11;
		s1.kor = 100;
		s1.eng = 100;
		s1.math = 99;
		s1.info();
		
	}
}

/*[RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] Student001.class(■1.설계도:장난감) , ClassEx001.class #1(JVM접근)
------------------------------------
[HEAP:동적]						|		[STACK:지역]
			
1번지:Student001{name=null,no=0,kor=0,
	eng=0,math=0,info()} 				<- s1[1번지] 	 
										   main #2 (JVM 접근 -> 구동)
------------------------------------
객체(■1.인스턴스-장난감만들기)	 객체(■3.갖고놀기)
*/


//연습문제1)  class
//패키지명 : com.company.com.the703.basic010_ex
//클래스명 :  ClassEx001
//class Student001{
//  멤버변수 : String name;  int no, kor, eng, math;
//  멤버함수 : void info()
//}
//
//public class ClassEx001{
//   public static void main(String[] args) {
//      Student001   s1 = new Student001();
//     s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
//     s1.info();
//   }
//}
//출력내용 : 
//  이름: first
//  총점 : 299
//  평균 : 99.67