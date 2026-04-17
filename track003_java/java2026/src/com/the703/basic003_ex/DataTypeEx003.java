package com.the703.basic003_ex;

import java.time.LocalDate;
import java.util.Scanner;

public class DataTypeEx003 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LocalDate now = LocalDate.now();
		int getYear =  now.getYear();
		int year, age;
		
		System.out.print("태어난 년도를 입력하세요. > ");
		year = scanner.nextInt();
		age = (getYear-year);
		
		System.out.print("당신의 나이는 " + age + "살 입니다\n");
		System.out.println("당신의 나이는 " + age + "살 입니다");
		System.out.printf("당신의 나이는 %d살 입니다", age);

	}

}


//패키지명 : com.the703.basic003_ex
//클래스명 : DataTypeEx003
//출력내용 :  Scanner이용해서 태어난 년도를 입력받아 나이 계산하기
//태어난 년도를 입력하세요. >
//2000
//당신의 나이는 25살 입니다.