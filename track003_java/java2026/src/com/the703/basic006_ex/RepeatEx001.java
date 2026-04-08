package com.the703.basic006_ex;

public class RepeatEx001 {

	public static void main(String[] args) {
		//1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5		
		for(int i1=1;i1<=5;i1++) {
			System.out.print(i1);
		}
		System.out.println();
		
		int i2=1;
		while(i2<=5) {
			System.out.print(i2);
			i2++;
		}
		System.out.println();
		
		int i3 = 1;
		do {
			System.out.print(i3);
			i3++;
		}while(i3<=5);
		System.out.println();
		
		//2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
		for(int i4=5;i4>=1;i4--) {
			System.out.print(i4);
		}		
		System.out.println();
		
		int i5=5;
		while(i5>=1) {
			System.out.print(i5);
			i5--;
		}		
		System.out.println();
		
		int i6=5;
		do {
			System.out.print(i6);
			i6--;
		}while(i6>=1);
		System.out.println();
		
		//3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3		
		for(int i7=1;i7<=3;i7++) {
			System.out.print("JAVA"+i7);
		}		
		System.out.println();
		
		int i8=1;
		while(i8<=3) {		
			System.out.print("JAVA"+i8);
			i8++;
		}		
		System.out.println();
		
		int i9=1;
		do {
			System.out.print("JAVA"+i9);
			i9++;
		}while(i9<=3);
		
	}

}


