package com.company.basic004_ex;

public class CastingEx004 {

	public static void main(String[] args) {
		short sh1 = 1;
		short sh2 = 2;
		short result = (short)(sh1 + sh2);
		
		//int 보다 작은 자료형 : byte - short / char
		//작은 정수형끼리 연산시 내부적으로 자동으로  int로 변환해서 계산
	}

}

//연습문제4)
//패키지명 : com.the703.basic004_ex
//클래스명 : CastingEx004
//  short sh1 = 1;
//  short sh2 = 2;
//  short result = sh1 +sh2;

//int 보다 작은 자료형인 byte - short / char 는 메모리상에서 넣었다가 꺼낼 때 기본단위인 int로 인식