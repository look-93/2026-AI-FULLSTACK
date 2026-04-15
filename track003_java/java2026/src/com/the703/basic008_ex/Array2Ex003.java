package com.the703.basic008_ex;

public class Array2Ex003 {

	public static void main(String[] args) {
		int total=0;  double avg=0.0;
		int cnt=0;
		int[][] arr = {		
			   { 1, 1, 1,},
			   { 2, 2, 2,},
			   { 3, 3, 3,},
			   { 4, 4, 4,},
			};
		
		for(int ch=0;ch<arr.length;ch++) {
			for(int kan=0;kan<arr[ch].length;kan++) {
				total = total + arr[ch][kan];
//				cnt = ++cnt;
			}	
		}
		avg = (double)total/(arr.length*arr[0].length);
//		avg = (double)total/cnt;
		
		System.out.printf("총점 : %d \n평균 : %.1f",total,avg );
		
	}

}

//연습문제3)  array
//패키지명 : ccom.the703.basic008_ex
//클래스명 :  Array2Ex003
//배열을 이용하여 다음의 프로그램을 작성하시오.   
//1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.
//
// int[][] arr = {
//   { 1, 1, 1,},
//   { 2, 2, 2,},
//   { 3, 3, 3,},
//   { 4, 4, 4,},
// };
// int total=0;  double avg=0.0;
//
//출력내용:
//총점 : 30
//평균 : 2.5