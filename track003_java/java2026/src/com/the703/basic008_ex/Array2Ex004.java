package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Ex004 {

	public static void main(String[] args) {    
		int[][] datas = {  
				{  10, 10, 10 ,10},             
				{  20, 20, 20 ,20},     
				{  30, 30, 30 ,30},   
				};  // 3층 4칸

		String st="";
		
		int[][] result = new int[datas.length+1][datas[0].length+1];   
		
//		for(int ch=0;ch<result.length;ch++) {
//						int sum=0;
//			for(int kan=0;kan<result[ch].length;kan++) {
//				if(ch <=2) {
//					if (kan <= 3 ) {
//						int value = datas[ch][kan];
//						result[ch][kan] = value;
//						sum = sum+value;
////						System.out.println(ch+","+kan+","+value);
//					}
//					if(kan == 4) {
//						result[ch][kan] = sum;
//					}	
//				}else {
////					00,10,20
////					01,11,21
////					02,12,22
////					03,13,23
//					result[ch][kan] = result[0][kan] + result[1][kan] + result[2][kan];
//				}
//				
//			}	
//			
////			System.out.println(Arrays.toString(result[ch]));
//		
//		}
//		
		
//		10,10,10,10,40
//		20,20,20,20,80
//		30,30,30,30,120
//		60,60,60,60,240
		
//		0,0,0,0,0
//		0,0,0,0,0
//		0,0,0,0,0
//		0,0,0,0,0

		for(int ch=0;ch<datas.length;ch++) {
//			int[][] result = new int[datas.length+1][datas[0].length+1];
//			
			int sum = 0;
			for(int kan=0;kan<datas[ch].length;kan++) {
				
				result[ch][kan] = datas[ch][kan];
				sum  += datas[ch][kan];
//				System.out.print(result.length-1);
//				System.out.print(",");
//				System.out.print(ch);
//				System.out.print("=");
//				System.out.print(datas[ch][kan]);
				result[result.length-1][kan] += datas[ch][kan];
			}
//			System.out.print(result[result.length-1][ch]);
			result[ch][datas.length+1] = sum;
			result[result.length-1][result[0].length-1] += sum;
		}

		for(int ch=0;ch<result.length;ch++) {
			System.out.println(Arrays.toString(result[ch]));
		}

	}

}

//연습문제4)  array
//패키지명 : ccom.the703.basic008_ex
//클래스명 :  Array2Ex004
//배열을 이용하여 다음의 프로그램을 작성하시오.   
//1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.
//  
//int[][] datas = {  {  10, 10, 10 ,10},             
//                  {  20, 20, 20 ,20},     
//                  {  30, 30, 30 ,30},     
//};  // 3층 4칸                                  
//                               
//int[][] result = new int[datas.length+1][datas[0].length+1];    
//
//#1. result 에 datas데이터 복사하기
//#2. 가로방향누적데이터
//#3. 세로방향데이터누적
//#4. 총합
//
//출력내용:
//10   10   10   10   40   
//20   20   20   20   80   
//30   30   30   30   120   
//60   60   60   60   240   