package com.the703.basic018;

import java.text.SimpleDateFormat;

public class test {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd"); //포멧설정
		long millis = System.currentTimeMillis(); // 시스템시간가져오기
		String date = sdf.format(millis); 
		
		System.out.println(date);

	}

}
