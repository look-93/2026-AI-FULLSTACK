package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num;
		
		System.out.print("파이값을 입력하시오 > ");
		num = sc.nextDouble();
		System.out.print("파이값은 " + num + "입니다.\n");
		System.out.println("파이값은 " + num + "입니다.");
		System.out.printf("파이값은 %f 입니다.\n", num);
		System.out.printf("파이값은 %.0f 입니다.\n", num);
		System.out.printf("파이값은 %.1f 입니다.\n", num);
		System.out.printf("파이값은 %.2f 입니다.\n", num);
		System.out.printf("파이값은 %.6f 입니다.\n", num);
		
		System.out.println(10/3); 	// 정수 / 정수
		System.out.println(10/3f);	// 정수 / 실수
		System.out.println(10f/3);  // 실수 / 정수
	}

}


//패키지명 : com.the703.basic003_ex
//클래스명 : DataTypeEx004
//출력내용 :  Scanner이용해서 파이값을 입력받고 출력하시오. 
//     파이값을 입력하시오 > _입력받기    3.141592    ( 자료형선택 )
//     파이값은 **입니다.
  