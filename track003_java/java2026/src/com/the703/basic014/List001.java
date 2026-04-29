package com.the703.basic014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List; // i : interface
import java.util.Vector;

public class List001 {
	public static void main(String[] args) {
		//Step1. Array
		String [] arr = new String[3]; //갯수
		arr[0] = "헐크"; //arr[1] = 1; 같은자료형
		System.out.println(Arrays.toString(arr));
		
		//Step2. 동적배열 - List 사용법
		//부모 = 자식
		List list = null; // ctrl+shift+o = import
			 list = new ArrayList();//자식
			 list = new LinkedList();//자식
			 list = new Vector();//자식
			 
	    //Step3. <>  add, get, size, romove, contains
	    //여러 타입이 들어감 지양 
	    List list2 = new ArrayList();
	    list2.add("one"); //Object obj = "one"
	    list2.add(1); //Object obj = 1
	    list2.add(3.14);
	    System.out.println(list2);
	    
	    List<String>list3 = new ArrayList<String>();
	    list3.add("one"); //Object obj = "one"
	    //list3.add(1); //Object obj = 1
	    //list3.add(3.14);
	    System.out.println(list3);
	    
	    //Step4. add(추가), get(가져오기), size(갯수), romove(지우기), contains(포함여부)
	    List<String> list4 = new ArrayList<>();
	    list4.add("apple");
	    list4.add("banana");
	    list4.add("coconut");
	    list4.add("mango");
	    
	    System.out.println(list4);
	    System.out.println(list4.get(0));
	    System.out.println(list4.size());
	    System.out.println(list4.remove(0)); //apple
	    System.out.println(list4.contains("mango"));
	    System.out.println(list4);
	}
}

/*
Collection Framework
1. 저장단위
- 변수 < 배열 < 클래스 < 콜렉션프레임워크 < 파일 < DB

2. 콜렉션프레임워크
- [배열]의 단점을 개선한 클래스, 객체(클래스) 만 저장가능
- 동적배열

※ 배열) 같은타입만 묶어서 저장가능, 배열생성시 크기를 지정해서 사용, 추후에 변경 불가능
String [] arr = new String[3]

3. 핵심 인터페이스
1) List - 기차 (순서o, 중복허용o)
		 add, get, size, romove, contains
2) Set  - 주머니 (순서x, 중복허용x)  
		 add, get(x) 향상된for/iterator, size, romove, contains
3) Map	- 사전 - key, value 쌍
		 add(x) put, get(key), size, romove, contains
*/