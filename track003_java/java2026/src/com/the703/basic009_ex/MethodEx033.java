package com.the703.basic009_ex;

public class MethodEx033 {
	
	public static void test(int num) {
		if (num<1) {return;}
		System.out.print(num + "\t");  
		
		test(--num);
	}
	
	public static void main(String[] args) {
		test(10);
	}

}

//재귀함수를 이용하여 다음 프로그램을 작성하시오.
//10을 카운트하시오.
// test(10)