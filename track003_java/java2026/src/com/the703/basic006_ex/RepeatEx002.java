package com.the703.basic006_ex;

public class RepeatEx002 {

	public static void main(String[] args) {
		
		//3의 배수의 합
		//for
		int sum1=0, sum2=0, sum3=0;		
		for(int i1=1;i1<=10;i1++) {
			if(i1%3==0) {
				sum1 = sum1+i1;
			}			
		}
		System.out.println("for : " + sum1);
		
		//while
		int i2=1;
		while(i2<=10) {
			if(i2%3==0) {
				sum2 = sum2+i2;
			}
			i2++;
		}
		System.out.println("while : " + sum2);
		
		//do while
		int i3=1;
		do {
			if(i3%3==0) {
				sum3 = sum3+i3;
			}
			i3++;
		}while(i3<=10);
		System.out.println("do while : " + sum3);

	}

}

//연습문제2)  for/while/do while
//패키지명 : com.the703.basic006_ex;
//클래스명 :  RepeatEx002
//for , while , do while 3가지 버젼으로 
//1~10까지 3의 배수의 합 : 18
//
//
//
//힌트)
//ver-1)
//1이  3의 배수라면  합을더해주변수에누적
//2가  3의 배수라면  합을더해주변수에누적
//3이  3의 배수라면  합을더해주변수에누적
//
//ver-2)
//if( 1이  3의 배수라면 ){ 합을더해주변수에누적 }
//if( 2가  3의 배수라면 ){ 합을더해주변수에누적 }
//if( 3이  3의 배수라면 ){ 합을더해주변수에누적 }