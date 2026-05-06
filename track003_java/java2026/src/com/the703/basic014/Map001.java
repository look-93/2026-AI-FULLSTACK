package com.the703.basic014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//List(기차) 	- 순서o,중복o
//Set(주머니) - 순서x,중복x
//Map(사전)	- key:value	put, get(key), size, remove, contains

public class Map001 {

	public static void main(String[] args) {
		Map<String, Integer> maps = new HashMap<>();
		maps.put("one"  , 1); //키, 값
		maps.put("two"  , 2); //엔트리
		maps.put("three", 3);
		
		System.out.println("1 : " + maps);
		
		System.out.println("2 : " + maps.get("two"));
		
		System.out.println("3 : " + maps.size());
		
		System.out.println("4-1 : " + maps.remove("two"));
		System.out.println("4-2 : " + maps);
		System.out.println("5-1 : " + maps.containsKey("three"));
		System.out.println("5-2 : " + maps.containsValue(2)); //없는값 = false
		
		System.out.println("6-1 : " + maps.entrySet()); // key:value 한쌍의 묶음
		System.out.println("6-2: " + maps.keySet());	// key 객체들로만 이뤄진 묶음
		
		//Map 향상된 for
		//Entry<String, Integer> 
		for(Entry<String, Integer> m : maps.entrySet()) {
			System.out.println(m.getKey() + "-" + m.getValue());
		}
		
		//maps.keySet()
		for(String key : maps.keySet()) {
			System.out.println(key + "-" + maps.get(key));
		}// get(key) 키를 주면 값을줄게
		
		Iterator<Entry<String, Integer>> iter = maps.entrySet().iterator();
		//#1. 반복자 - 알아서 처리 -> maps.entrySet() 키와 value의 한쌍으로 .iterator() 줄을서시오.
		//iter -> [one=1, three=3]

		while(iter.hasNext()) { //#2. hasNext() 처리대상확인 iter -> [one=1, three=3]
			//#3. next() 한개씩꺼내오기
			Entry<String, Integer> m = iter.next();
			System.out.println(m.getKey() + "-" + m.getValue());
		}
		
		Iterator<String> kiter = maps.keySet().iterator();
		//#1. maps.keySet() 키들을 모아서 [one, three] .iterator() 줄을서시오.
		//#2. kiter -> [one, three]
		while(kiter.hasNext()) { //#2. hasNext() 처리대상확인 kiter -> [one, three]
			//#3. next() 한개씩꺼내오기
			String key = kiter.next();
			System.out.println(key + "-" + maps.get(key));
		}
	}
}
