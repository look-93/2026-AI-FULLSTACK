package com.the703.basic009;

public class StringEquals {

	public static void main(String[] args) {
		String id = "abc";  // 기본값 x
		String id2 = "abc"; // 참조값 o
		String id3 = new String("abc"); //id, id2, id3 참조값(주소값)
		
		System.out.println("1) " + (id==id2)); // true
		System.out.println("2) " + (id==id3)); // false
		
		System.out.println( System.identityHashCode(id) );  //1746572565
		System.out.println( System.identityHashCode(id2) ); //1746572565
		System.out.println( System.identityHashCode(id3) ); //989110044
		
		System.out.println("3) " + (id.equals(id3)) ); // true
		// 문자열 비교 equals 이용
		
	}

}


/*	heap			|	stack
 						<- id	[1746572565]	id = "abc"
 1746572565["abc"]		<- id2	[1746572565]	id2 = "abc"
 989110044["abc"]		<- id3	[989110044]		new 메모리를 빌리고
   
 
 */