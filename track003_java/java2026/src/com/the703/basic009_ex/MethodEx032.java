package com.the703.basic009_ex;

public class MethodEx032 {
	
	public static void hello(int num) {
		if (num<1) {return;}
		System.out.println(num + "\t");  
		
		hello(--num);
	}
	
	public static void main(String[] args) {
		hello(5);
	}

}

//재귀함수를 이용하여 다음 프로그램을 작성하시오.
//Hello 5번 출력하시오.
//public static void main(String[] args) {
//	hello(5);
//}