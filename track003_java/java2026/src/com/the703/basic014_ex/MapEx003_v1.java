package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx003_v1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String j = "";
		String isbn = "";
		Map<String, Map<String, BookDto>> library = new HashMap<>();
		Map<String, BookDto> sInnerMap = new HashMap<>();
		Map<String, BookDto> bInnerMap = new HashMap<>();
		sInnerMap.put("978-11111", new BookDto("자바의 정석", "남궁성"));
		sInnerMap.put("978-22222", new BookDto("파이썬 기초", "홍길동"));
		bInnerMap.put("978-33333", new BookDto("자료구조와 알고리즘", "이순신"));
		bInnerMap.put("978-44444", new BookDto("파이썬 심화", "홍길동"));
		library.put("서울점", sInnerMap);
		library.put("부산점", bInnerMap);
		
		System.out.println("=== 도서관 전체 목록 ===");
		for(String key : library.keySet()) {
			System.out.println(key);
			for(String key2 :  library.get(key).keySet()) {
				System.out.println(key2 + " | " + library.get(key).get(key2).getTitle() + " | " + library.get(key).get(key2).getAuthor());
			}
		}
		
		System.out.print("지점 이름 입력 > ");
		j = sc.next();
		System.out.print("ISBN 입력 > ");
		isbn = sc.next();
		
		if(!(library.containsKey(j) && library.get(j).containsKey(isbn))) {
			System.out.println("도서 정보가 없습니다.");
			return;
		}
		
		System.out.println("📖 선택한 도서 정보 : " +  library.get(j).get(isbn).getTitle() + "/" + library.get(j).get(isbn).getAuthor());
		
	}
}

//## 📘 연습문제3) Collection Framework + 중첩 HashMap
//패키지명 : com.company.basic014_ex
//클래스명 : MapEx003
//
//### 요구사항
//1. 중첩 Map 구조 만들기  
// - Map<String, Map<String, BookDTO>> library = new HashMap<>();  
// - 첫 번째 Key : 도서관 지점 이름 (예: "서울점", "부산점")  
// - 두 번째 Key : ISBN  
// - Value : BookDTO 객체  
//
//2. DTO 클래스  
// java
// class BookDTO {
//     private String title;
//     private String author;
//     // 생성자, getter/setter, toString()
// }
// 
//
//3. 출력하기  
// - 각 지점별 도서 목록 출력  
//
//4. 사용자 입력받기  
// - 지점 이름과 ISBN을 입력받아 해당 도서 정보 출력  
//
//### 📌 실행 예시 
//=== 도서관 전체 목록 ===
//📚 서울점
//978-11111 | 자바의 정석 | 남궁성
//978-22222 | 파이썬 기초 | 홍길동
//---------------------
//📚 부산점
//978-33333 | 자료구조와 알고리즘 | 이순신
//978-44444 | 파이썬 심화 | 홍길동
//---------------------
//지점 이름 입력> 서울점
//ISBN 입력> 978-22222
//
//📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동