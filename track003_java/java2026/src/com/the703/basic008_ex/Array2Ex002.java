package com.the703.basic008_ex;

public class Array2Ex002 {

	public static void main(String[] args) {
		int [][] arr = new int[2][3];
		
		int data = 101;
		for(int ch=0;ch<arr.length;ch++) {
			for(int kan=0;kan<arr[ch].length;kan++) {
				arr[ch][kan] = data++;
				
				System.out.print(arr[ch][kan] + "\t");
			}
			System.out.println();
		}

	}

}

//연습문제2)  array
//패키지명 : ccom.the703.basic008_ex
//클래스명 :  Array2Ex002
//배열을 이용하여 다음의 프로그램을 작성하시오.   
//1. new 연산자 이용하여 다차원배열만들기
//2. for + length 이용해서 대입   
//3. for + length 이용해서 출력 
//   101   102   103
//   104    105    106