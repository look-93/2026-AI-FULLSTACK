package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//class BookDto {
//	private String title;
//	private String author;
//
//	public BookDto() {
//		super();
//	}
//
//	public BookDto(String title, String author) {
//		super();
//		this.title = title;
//		this.author = author;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//}
// BookDto 분리
public class MapEx002 {

	public static void main(String[] args) {
		Map<String, BookDto> maps = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String king = "";
		String isbn = "";
		maps.put("978-11111", new BookDto("자바의 완성", "가길동"));
		maps.put("978-22222", new BookDto("파이썬 기초", "홍길동"));
		maps.put("978-33333", new BookDto("자료구조와 알고리즘", "이순신"));

		System.out.print(
				"==============================\n" + "ISBN  \t TITLE \t AUTHOR\n" + "==============================\n");
		// keySet
		for (String key : maps.keySet()) {
//			String title = maps.get(key).getTitle();
//			String author = maps.get(key).getAuthor();
//			System.out.println(key + " | " + title + " | " + author);
			
			System.out.printf("%s   %s    %s\n", key , maps.get(key).getTitle(), maps.get(key).getAuthor());
		}
//		//entrySet
//		for (Entry<String, BookDto> e : maps.entrySet()) {
//			System.out.printf("%s   %s    %s\n", e.getKey() ,e.getValue().getTitle(), e.getValue().getAuthor());
//		}
//		//Iterator
//		Iterator<Entry<String, BookDto>> iter = maps.entrySet().iterator();
//		while(iter.hasNext()) {
//			Entry<String, BookDto> e = iter.next();
//			System.out.printf("%s   %s    %s\n", e.getKey() ,e.getValue().getTitle(), e.getValue().getAuthor());
//		}
				
		System.out.println("도서 정보를 제공중입니다.");

		System.out.print("ISBN을 입력하세요 > ");
		isbn = sc.next();
		
//		System.out.println(maps.containsKey(isbn)
//				? "📖 선택한 도서 정보: "  + maps.get(isbn).getTitle()+" / 저자: "  + maps.get(isbn).getAuthor()  : "ISBN 확인바람"); 
		
		if (!(maps.containsKey(isbn))) {
			System.out.println("도서 정보가 없습니다.");
			return;
		}

		System.out.println("📖 선택한 도서 정보 : " + maps.get(isbn).getTitle() + " / 저자 :" + maps.get(isbn).getAuthor());

	}
}

//연습문제2)  Collection  Framework
//패키지명 : com.the703.basic014_ex
//클래스명 : MapEx002
//1. MAP 만들기
//KEY         VALUE
//978-11111   new BookDto("자바의 완성" , "가길동")
//---------------------
//978-22222   new BookDto("파이썬 기초" , "홍길동")
//---------------------
//978-33333   new BookDto("자료구조와 알고리즘" , "이순신")
//
//Map<String, BookDTO> map = new HashMap<>();
//
//
//2 다음과 같이 문제풀기
//2-1. BookDto 만들기   {    private String title;  private String author;}
//2-2. 다음과 같이 출력
//2-3. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
//==============================
//ISBN        TITLE        AUTHOR
//==============================
//978-11111 | 자바의 완성 | 가길동
//------------------------------
//978-22222 | 파이썬 기초 | 홍길동 
//------------------------------
//978-33333 | 자료구조와 알고리즘 | 이순신 
//------------------------------
//도서 정보를 제공중입니다
//ISBN을 입력하세요> 978-22222
//
//📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동
