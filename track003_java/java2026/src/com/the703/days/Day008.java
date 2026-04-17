package com.the703.days;

import java.util.Scanner;

public class Day008 {

	public static void main(String[] args) {
//		4.  eclipse 열어서 작성해주세요! [20분]
//		   패키지명 : com.the703.days
//		   클래스명 :  Day008
//		   출력내용 :  성적처리 프로그램입니다.
//		   1. 총점 구하기
//		   2. 평균 구하기
//		   3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
//		   4. 평균이 95점이상이면 장학생
//		   5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
//
//		   학번 입력 > std111
//		   국어점수 입력 > 100
//		   수학점수 입력 > 100
//		   영어점수 입력 > 99
//		   ======================================================== 
//		   학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
//		   ======================================================== 
//		   std111   100   100   99   299   99.67   합격   수   장학생
		
		String no="", pass="", level="가", goodStd="", result="";
		int kor=0, math=0, eng=0, total=0;
		double avg = 0;
		Scanner sc = new Scanner(System.in);
		
		      		
		System.out.print("학번 입력 > ");
		no = sc.next();
		System.out.print("국어점수 입력 > ");
		kor = sc.nextInt();
		System.out.print("수학점수 입력 > ");
		math = sc.nextInt();
		System.out.print("영어점수 입력 > ");
		eng = sc.nextInt();
		

		total = kor + math + eng;
		avg = total/3f;
		
		pass = avg < 60 ? "불합격" : kor < 40 || math < 40 || eng < 40 ? "불합격" : "합격";
		
		goodStd = avg >= 95 ? "장학생" : "";
		
		level = avg >= 90 ? "수" : avg >= 80 ? "우" : avg >= 70 ? "미" : avg >= 60 ? "양" : "가";
		
		result = no		+"\t"	+kor 	+ "\t"
				+eng 	+"\t" 	+math 	+ "\t"
				+total 	+"\t" 	+String.format("%.2f", avg) + "\t"
				+pass 	+"\t" 	+level 	+ "\t"	+goodStd;
				
		System.out.println(
				  "=====================================================================\n"
				+ "학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생\n"
				+ "====================================================================="
				);
	
		System.out.println(result);		
		
	}

}

//3. 필수조건
//q1-1 int형 변수 x가 60이상일때 조건식  
// x >= 60

//q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식   
// ch == 'a' || ch == 'A'  

//q1-3 char형 변수 ch가 숫자('0'~'9')일때   조건식    
// ch >= '0' && ch <= '9'

//q1-4 char형 변수 ch가 영문자(대문자) 일때    조건식 
// ch >= 'A' && ch <= 'Z'

