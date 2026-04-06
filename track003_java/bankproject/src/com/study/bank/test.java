package com.study.bank;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		   int a = -1;
		   Scanner sc = new Scanner(System.in);
		   for(;;){
		   System.out.println("빠져나오실래요? 0이면 종료");
		   a = sc.nextInt();
		   if(a==0) { break; }
		   }

	}

}
