package com.the703.basic007;

public class For2Ex008 {

	public static void main(String[] args) {
		int count = 1;
		
		for(int i=1;i<=5;i++) {
			for(int i1=5;i1>=i;i1--) {
				if(count+i1==6) {
					System.out.println(count+"+"+i1+"="+(i1+count));
					count++;
				}
			}
			System.out.println();
		}
		

	}
}
//두개의 주새위를 던졌을 때 눈의 합이 b가 되는
//모든 경우의 수를 출력하는 프로그램을 작성하시오.
//이중  for, 이중 while, do while 세가지버전으로 작성하시오.

//1+5=b
//2+4=b
//3+3=b
//4+2=b
//5+1=b