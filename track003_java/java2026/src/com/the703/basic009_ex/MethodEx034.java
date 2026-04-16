package com.the703.basic009_ex;

public class MethodEx034 {
	
	public static int plus(int n) {
		if (n==1) {return 1;}

		return n+plus(--n); // 5 4 3 2 1
	}
	
	public static void main(String[] args) {
		int n=5;
		System.out.println("1부터" + n + "까지의 합계 : " + plus(n));
	}

}

//재귀함수를 이용하여 다음 프로그램을 작성하시오.
//1~5까지의 합계를 누적하시오.
// int n=5;
// sysout("1부터"+n+"까지의 합계 : " + plus(n));
// 1+2+3+4+5 = 15