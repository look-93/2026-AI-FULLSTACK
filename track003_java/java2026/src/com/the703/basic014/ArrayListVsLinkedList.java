package com.the703.basic014;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {

	public static void main(String[] args) {
		//면접문제 2026-05-13 day032
		
		//Q ArrayList와 LinkedList 차이점을 설명 (이론상/실제성능은 jvm최적화에 따라 달라짐)
		// - ArrayList  : 배열기반으로 동작(순번o), 검색속도 빠름, 삽입/삭제 느림
		// - LinkedList : 노드기반 연결구조(주소(값)-주소(값)), 검색속도 느림, 삽입/삭제 빠름
		
		int size = 10000;
		//1. ArrayList 테스트
		List<Integer> arrayList = new ArrayList<>();
		long start = System.currentTimeMillis();
		for(int i=0;i<size;i++) { arrayList.add(i); }
		long end = System.currentTimeMillis();
		System.out.println("1. ArrayList 삽입시간 : " + (end-start) + "ms");
		
		//2. LinkedList 테스트
		List<Integer> linkedList = new LinkedList<>();		
		start = System.currentTimeMillis();
		for(int i=0;i<size;i++) { linkedList.add(i); }
		end = System.currentTimeMillis();
		System.out.println("2. LinkedList 삽입시간 : " + (end-start) + "ms");
		
		//3. 중간삽입 테스트
		start = System.currentTimeMillis();
		for(int i=0;i<size;i++) { arrayList.add(size/2,i); } // 삽입되는 위치, 값
		end = System.currentTimeMillis();
		System.out.println("3. ArrayList 중간삽입 : " + (end-start) + "ms");		
		
		start = System.currentTimeMillis();
		for(int i=0;i<size;i++) { linkedList.add(size/2,i); }
		end = System.currentTimeMillis();
		System.out.println("4. LinkedList 중간삽입 : " + (end-start) + "ms");
	}
}
