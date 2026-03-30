package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("좋아하는 수(정수) 입력하시오 > ");
		num = sc.nextInt();
		System.out.print("좋아하는 숫자는 " + num + "입니다.\n");
		System.out.println("좋아하는 숫자는 " + num + "입니다.");
		System.out.printf("좋아하는 숫자는 %d입니다." , num);

	}

}


//패키지명 : com.the703.basic003_ex
//클래스명 : DataTypeEx002
//출력내용 :  Scanner이용해서 나이 입력받고 출력하시오.
//    좋아하는 수(정수)   입력하시오 > _입력받기
//    좋아하는 숫자는 ** 입니다.
