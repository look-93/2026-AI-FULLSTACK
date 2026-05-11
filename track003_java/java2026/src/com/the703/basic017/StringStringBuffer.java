package com.the703.basic017;

public class StringStringBuffer {
	public static void main(String[] args) {
		//#1. String : 새로운 주소에 새로운 값 누적 / 1000줄이면 메모리 과부화
		//1. str 주소 > ABC 681842940
		String str = "ABC";
		System.out.println("1. str 주소 > " + str + " " + System.identityHashCode(str));
		
		//2. str 주소 > ABCD 135721597
		str += "D";
		System.out.println("2. str 주소 > " + str + " " + System.identityHashCode(str));
		
		//#2. StringBuffer : 주소값 변함 없이 데이터 누적
		StringBuffer sb = new StringBuffer();
		
		//3. sb 주소 > ABC 142257191
		sb.append("ABC");
		System.out.println("3. sb 주소 > " + sb + " " + System.identityHashCode(sb));
		
		//4. sb 주소 > ABCD 142257191
		sb.append("D");
		System.out.println("4. sb 주소 > " + sb + " " + System.identityHashCode(sb));		
	}
}
//HashCode -> 주소값