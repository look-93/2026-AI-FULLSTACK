package com.the703.basic010_ex;

//연습문제2)
//패키지명 : com.company.java010_ex
//클래스명 : MemberVarEx002
//
//-- class Student 작성해주세요
//
//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 ) 
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오. 
		//-> 메모리상 올라가는 순서가 다름
		//-> 인스턴스 변수는 new해서 객체생성 후 사용가능
//- 문제 4. runtime data area 위치영역 그림그리기

/* [RUNTIME DATA AREA] 
------------------------------------------------------
[METHOD:정보, static, final] 
Student.class 			 		MemberVarEx002.class #1
Student.studentCount=0;  		Student.total=0; 		Student.maxScore = 100; 
Student.showStudentCount();		Student.showName();		Student.showStudentCount();
------------------------------------------------------
[HEAP:동적]            												|  [STACK:지역]
2번지{name ="홍길동" ,kor=90, eng=85, getTotalScore(),showInfo()} 		<-		s2(2번지)	
1번지{name ="홍길동" ,kor=90, eng=85, getTotalScore(),showInfo()} 		<-		s1(1번지)		
																			main #2
------------------------------------------------------
(인스턴스)
*/



class Student {
	String name = "홍길동"; 	//문제 1. 인스턴스변수 heap area 지역변수
	int kor = 90;			//문제 1. 인스턴스변수 heap area 지역변수
	int eng = 85;			//문제 1. 인스턴스변수 heap area 지역변수
	static int studentCount = 0;		//문제 1. 클래스변수 method area
	static int total; /*= kor + eng;*/	//문제 1. 클래스변수 method area  문제3)static은 인스턴스변수 (this)불가
	static int maxScore = 100;			//문제 1. 클래스변수 method area
	
	
	public Student() { studentCount++; }				//기본생성자
	public int getTotalScore() { return kor + eng; }	//문제 2. 인스턴스메서드 heap area

	public static void showStudentCount() {
		System.out.println("전체 학생 수: " + studentCount);
	}//문제 2. 클래스변수 method area

	public static void showName() {
		//System.out.println(name);	//문제3)static은 인스턴스변수 (this)불가
	}//문제 2. 클래스변수 method area

	public void showInfo() {
		System.out.println("이름: " + name);
		System.out.println("총점: " + getTotalScore());
	}//문제 2. 클래스변수 method area
}

public class MemberVarEx002 {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();

		s1.showInfo();
		Student.showStudentCount();
	}
}
