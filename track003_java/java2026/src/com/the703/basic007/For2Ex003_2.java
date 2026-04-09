package com.the703.basic007;

public class For2Ex003_2 {

	public static void main(String[] args) {
		//ver-1 작은단위로 눈에 보이는 그대로
		System.out.print("#"); System.out.println();
		System.out.print("#"); System.out.print("#"); System.out.println(); // 2번째부터
		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
		
		//ver-2 칸정리
		System.out.println();
		for(int i=1; i<=1;i++) {System.out.print("#");} System.out.println(); //#
		for(int i=1; i<=2;i++) {System.out.print("#");} System.out.println(); //##
		for(int i=1; i<=3;i++) {System.out.print("#");} System.out.println(); //###
		for(int i=1; i<=4;i++) {System.out.print("#");} System.out.println(); //####
	
		//ver-3 층정리
		System.out.println();
		for(int ch=1;ch<=4;ch++){
			for(int i=1;i<=ch;i++) {
				System.out.print("#");
				} 
			System.out.println();
		}
		
	
	}
}
