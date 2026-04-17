package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor = 0, eng = 0, math = 0, sum = 0;
		double avg = 0;
		
		System.out.print("국어점수를 입력하시오. : ");
		kor = sc.nextInt();
		
		System.out.print("영어점수를 입력하시오. : ");
		eng = sc.nextInt();
		
		System.out.print("수학점수를 입력하시오. : ");
		math = sc.nextInt();
		
		sum = (kor+eng+math);
//		avg = sum / 3f; // 정수/정수 = 정수, //정수/실수 = 실수
		avg = sum / 3.0;
		
		System.out.println("총점 : " + sum + " \n평균 : " + avg);
		System.out.printf("총점 : %d \n평균 : %.2f \n", sum, avg);
		
		System.out.print("총점 : " + sum + "\n");
		System.out.println("총점 : " + sum);
		System.out.printf("총점 : %d\n" , sum );
		
		System.out.print("평균 : " + avg + "\n");
		System.out.println("평균 : " + avg);
		System.out.printf("평균 : %.2f" , avg );
	}

}


//패키지명 : com.the703.basic003_ex
//클래스명 : DataTypeEx005
//출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
//   국어점수를 입력하시오.  _입력받기    100 
//   영어점수를 입력하시오.  _입력받기    100 
//   수학점수를 입력하시오.  _입력받기    99
//
//   총점 :  299
//   평균 :  99.67 