package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn1_1 {

public static void main(String[] args) {
		
		//자료형 : 기본형/참조형(String)
		//기본형 : 정수 : byte(1) <short/char(2)<int*(4)<ling(8) / 실수 : float(4)<double(8) / boolean 빼고 타입형변환가능
		
		String no="", pass="", level="가", goodStd="", result="";
		int kor=-1, math=-1, eng=-1, total=-1;
		double avg = -1;
		Scanner sc = new Scanner(System.in);

		System.out.print("학번 입력 > ");
		no = sc.next();

//		for(;;){  //무한반복
//		if(국어점수의 범위가 아니라면){  //-1     (0~100 사이가 아니므로)
//			1. 국어점수 입력 > 100    입력받기
//	        2. 건너뛰기  (continue)
//	                 }
//	    if(영어점수의 범위가 아니라면){
//	        1. 영어점수 입력 > 100    입력받기
//	        2. 건너뛰기(continue)
//	       }
//	        
//	    if(수학점수의 범위가 아니라면){
//	        1. 수학점수 입력 > 100    입력받기
//	        2. 건너뛰기(continue)
//	      }
//	                 // break; 나오기  -  이위치까지 왔다면 잘입력한것!
//	    } 	
		
		for(;;) { //5) 다시 시작
			//점수가 0보다 작거나 100보다 크면 입력받음
			if(!(kor >= 0 && kor <= 100)) {
				System.out.print("국어점수 입력 > "); //3)
				kor = sc.nextInt();				
				continue; //4) 아래 코드 진행안함
			}			
			if(!(math >= 0 && math <= 100)) {
				System.out.print("수학점수 입력 > ");
				math = sc.nextInt();
				continue;
			}				
			if(!(eng >= 0 && eng <= 100)) {
				System.out.print("영어점수 입력 > ");
				eng = sc.nextInt();
				continue;
			}			
			// break; 나오기  -  이위치까지 왔다면 잘입력한것!
			break; // kor eng math 입력을 잘 한 경우
		}		

		total = kor + math + eng;
		avg = total/3f;
		
		pass = avg < 60 ? "불합격" : kor < 40 || math < 40 || eng < 40 ? "불합격" : "합격";
		
		goodStd = avg >= 95 ? "장학생" : "";
	
		level = avg >= 90 ? "수" : avg >= 80 ? "우" : avg >= 70 ? "미" : avg >= 60 ? "양" : "가";
		
//		if(avg >= 95) {goodStd = "장학생";}
//		switch((int) avg/10) {
//			case 10:  case 9 : level = "수";  break;
//			case 8:			   level = "우";  break;
//			case 7:			   level = "미";  break;
//			case 6:			   level = "양";  break;
//		}
		
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


//
//연습문제1)   
//패키지명 : com.company.java004_ex
//클래스명 :   ForIn001
//출력내용 :  성적처리 프로그램입니다.
//
//0. 국어,영어, 수학(0~100만입력받기)  
//1. 총점 구하기
//2. 평균 구하기
//3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
//4. 평균이 95점이상이면 장학생
//5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
//
//학번 입력 > std111
//국어점수 입력 > 100  
//수학점수 입력 > 100
//영어점수 입력 > 99
//=================================================================================== 
//학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
//=================================================================================== 
//std111   100   100   99   299   99.67   합격   수   장학생



//ver-1
//for(;;) {
//	System.out.println("국어점수 입력 > ");
//	kor = sc.nextInt();	
//	if(kor>=0 && kor <= 100) {
//		break;
//	}
//}
//for(;;) {
//	System.out.println("수학점수 입력 > ");
//	math = sc.nextInt();	
//	if(math>=0 && math <= 100) {
//		break;
//	}
//}
//for(;;) {
//	System.out.println("영어점수 입력 > ");
//	eng = sc.nextInt();	
//	if(eng>=0 && eng <= 100) {
//		break;
//	}
//}	