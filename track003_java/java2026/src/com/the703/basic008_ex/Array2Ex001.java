package com.the703.basic008_ex;

public class Array2Ex001 {

	public static void main(String[] args) {
		int[][] arr2={
				{100,200,300},
				{400,500,600}
			};
	
		for(int ch=0;ch<arr2.length;ch++) {			 			 	
			for(int kan=0;kan<arr2[ch].length;kan++) {										
				System.out.print(arr2[ch][kan]+"\t");
			}
			System.out.println();
		}
		

	}

}


//연습문제1)  array
//패키지명 : com.the703.basic008_ex
//클래스명 :  Array2Ex001
//배열을 이용하여 다음의 프로그램을 작성하시오.   
//  
//   int[][] arr2={{100,200,300},{400,500,600}};
//
//   이중for+ length 이용해서 출력하기  