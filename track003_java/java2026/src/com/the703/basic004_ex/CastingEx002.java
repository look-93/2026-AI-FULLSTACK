package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor, eng, math, total, level;
		double avg;
		
		System.out.print("국어점수 입력 > ");
		kor = sc.nextInt();
		System.out.print("영어점수 입력 > ");
		eng = sc.nextInt();
		System.out.print("수학점수 입력 > ");
		math = sc.nextInt();
		
		total = kor+eng+math;
		avg = total/3f;
//		avg = total/3.0;
//		avg = (double) total/3;
//		avg = (float) total/3;
		
		//99.67 -> 99.67/10 -> (int) 9.967 -> 9
		level = (int) (avg/10);
		
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":: GOOD  IT SCORE ::");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("국어\t영어\t수학\t총점\t평균\t레벨");
		System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%d",kor,eng,math,total,avg,level);
	
	}

}


//연습문제2)
//패키지명 : com.company.java003_ex
//클래스명 : CastingEx002
//출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
// 1.  국어, 영어, 수학, 총점☆자료형을 int 
// 2.  레벨 - 평균이 90점대이면 레벨 9, 80점대면 8, 70점대면 7, 60점대면 6,,,,
//
//국어점수 입력 > 100
//영어점수 입력 > 100
//수학점수 입력 > 99
//
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//:: GOOD  IT SCORE ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//국어   영어   수학   총점   평균   레벨
//100   100   99   299   99.67   9
//
//
//주어진조건 : 
//      //변수
//      int kor, eng, mat,total,level;
//      double avg;
//      Scanner scanner = new Scanner(System.in);