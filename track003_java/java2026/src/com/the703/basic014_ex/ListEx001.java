package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx001 {

	public static void main(String[] args) {
		List<String> color = new ArrayList<>();
		color.add("red");
		color.add("green");
		color.add("blue");
		
		System.out.println(color.get(0));
		System.out.println(color.get(1));
		System.out.println(color.get(2));
		
		System.out.println();
		
		for(int i=0;i<color.size();i++) {
			System.out.println(color.get(i));
		}	
	}

}

//연습문제1)  Collection  Framework
//패키지명 : com.the703.basic014_ex
//클래스명 : ListEx001
//다음과 같이 코드를 작성하시오.
// 1. ArrayList이용해서 colors 만들기
// 2. red, green, blue 데이터 추가
// 3. 출력
//
//red
//green
//blue
