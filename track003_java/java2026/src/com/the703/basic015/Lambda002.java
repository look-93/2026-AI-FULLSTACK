package com.the703.basic015;

////////////////////////////////////////////////////////////
interface InterA2{  void   hi(); }
interface InterB2{  void   hi(String name); }
interface InterC2{  String hi(); }
interface InterD2{  String   hi(int num , String name); }   
////////////////////////////////////////////////////////////
public class Lambda002 {
	public static void main(String[] args) {
		//※interface InterA2{  void   hi(); }
		System.out.println("\n\n[STEP1] 매개변수x, 리턴값x");
		//1-1. 익명객체
		InterA2 a1 = new InterA2() {
			@Override
			public void hi() {
				System.out.println("Hi");				
			}	
		};
		a1.hi();
		
		//1-2. 람다식 ()->{}
		InterA2 a2 = () -> {System.out.println("Hi Hi");}; a2.hi();
		InterA2 a3 = () -> System.out.println("Hi Hi Hi"); a3.hi(); //처리할 일이 한줄이면 {} 생략
		
		//※interface InterB2{  void   hi(String name); }
		System.out.println("\n\n[STEP1] 매개변수o, 리턴값x");

		//2-1. 익명객체 hi bora
		InterB2 b1 = new InterB2() {			
			@Override
			public void hi(String name) {
				System.out.println("Hi" + name);
			}
		};
		
		System.out.println("이름을 입력하세요");
		b1.hi("bora");
		
		//2-2. 람다식 ()->{}
		InterB2 b2 = (String name) -> {System.out.println("Hi" + name);};  	b2.hi("bora");		
		InterB2 b3 = (name) -> {System.out.println("Hi" + name);};  		b3.hi("buja");		
		InterB2 b4 = (name) -> System.out.println("Hi" + name);  			b4.hi("뽀삐");	
		
		//※interface InterC2{  String hi(); }
		System.out.println("\n\n[STEP1] 매개변수x, 리턴값o");
		//3-1 익명객체
		//System.out.println(c1.hi(); 출력결과:Good : Day);
		InterC2 c1 = new InterC2() {
			@Override
			public String hi() {
				return "Good : Day";
			}			
		};
		System.out.println(c1.hi());
		
		//3-2 람다식 ()->{}
		InterC2 c2 = () -> {return "Good : Day";}; 	System.out.println(c2.hi());
		InterC2 c3 = () -> "Good : Day"; 			System.out.println(c3.hi());
		
		//※interface InterD2{  String   hi(int num , String name); }
		System.out.println("\n\n[STEP1] 매개변수o, 리턴값o");
	    //4-1. 익명객체      hi sally ★ 
	    //      System.out.println(d1.hi( 1, "sally" ));  //hi sally ★ 
	    //      System.out.println(d1.hi( 2, "sally" ));  //hi sally ★★
		InterD2 d1 = new InterD2() {
			@Override
			public String hi(int num, String name) {
				String star = "";
				for(int i=0;i<num;i++) {
					star = star + "★";
				}
				return "hi " + name + " " + star;
			}
		};		
		System.out.println(d1.hi(1,"bora"));
		System.out.println(d1.hi(2,"bora"));
		
	    //4-2. 람다식  ()->{}
		InterD2 d2 = (int num, String name) -> {
			String star = "";
			for(int i=0;i<num;i++) {
				star = star + "★";
			}
			return "hi " + name + " " + star;
		};
		System.out.println(d2.hi(3,"bora"));
		
		InterD2 d3 = (num, name) -> {			
			String star = "";
			for(int i=0;i<num;i++) {
				star = star + "★";
			}
			return "hi " + name + " " + star;
		};
		System.out.println(d3.hi(4,"bora"));
		System.out.println(d3.hi(5,"bora"));
		
		InterD2 d4 = (num,name) -> "Hi " + name + " " + "▲".repeat(num);						
		System.out.println(d4.hi(6,"bora"));
	}
}
