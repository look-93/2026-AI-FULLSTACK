package com.the703.basic009;

public class Method002 {
	
	//1. 리턴값 메서드명(파라미터:재료 ★)	
	public static void hello(String name) { //String name = "sally"
		System.out.println("Hello~" + name);
	}
	
	public static void icecream(int num) {
		System.out.println("아이스크림" + num + "개");
	}
	
	public static void info(String name, int score) {
		System.out.println(name +" 최종 " + score + "점");
	}
	
	public static void main(String[] args) {
		hello("sally");
		hello("alpha");
		
		icecream(1);
		icecream(2);
		icecream(3);
		
		info("sally" , 10);
		info("alpha" , 9);
	}
}
