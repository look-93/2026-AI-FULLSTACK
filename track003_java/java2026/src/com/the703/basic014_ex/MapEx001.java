package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = "";
		
		//1
		Map<String, String> maps = new HashMap<>();
		maps.put("피구왕", "통키");
		maps.put("제빵왕", "김탁구");
		maps.put("요리왕", "비룡");
		
		for(Entry<String, String> e :maps.entrySet()) {
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(key + " " + value);
			System.out.println("---------------------");
		}
		
		System.out.println();
		System.out.println();
		
		//2
		System.out.print("==============================\n"
						+ "KING\tNAME\n"
						+ "==============================\n");
		for(Entry<String, String> e :maps.entrySet()) {
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(key + "\t" + value);
			System.out.println("---------------------");
		}
		
		System.out.print("KING > ");
		name = sc.next();
		
//		System.out.println( maps.containsKey(name) ? 
//				"ㅁ" + name+":"+ maps.get(name) : "찾으시는 왕이 없어요~!");
		
		if(!(maps.containsKey(name))) {
			System.out.println("피구왕, 제빵왕, 요리왕 중 입력해주세요"); return;
		}
		
		System.out.print("★" + name + "★" + " : " + maps.get(name));
	}
}

//연습문제1)  Collection  Framework
//패키지명 : com.the703.basic014_ex
//클래스명 : MapEx001
//1. MAP 만들기
//KEY   VALUE
//피구왕   통키
//---------------------
//제빵왕   김탁구
//---------------------
//요리왕   비룡
//
//Map<String, String> map = new HashMap<>();
//
//2 다음과 같이 문제풀기
//2-1. 다음과 같이 출력
//2-2. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
//==============================
//KING   NAME
//==============================
//피구왕   통키
//---------------------
//제빵왕   김탁구
//---------------------
//요리왕   비룡
//---------------------
//KING의 정보를 제공중입니다
//이름을 입력하세요> 제빵왕
//
//ㅁ제빵왕 : 김탁구