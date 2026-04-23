package com.the703.basic010_ex;

import com.the703.basic010.UserInfo2;

public class UserInfoSon2 extends UserInfo2{
	public void show() {
		System.out.println("홍길동 아버지 이름 >  " + name);
		System.out.println("홍길동 아버지 비번 >  " + safeCode); 	//protected
		//System.out.println("홍길동 아버지 집  > " + house); 		//default - 같은 패키지(폴더가 아니라서 오류)
		System.out.println("홍길동 아버지 아이큐 > " + getiQ());	//private - getters + setters 사용해서접근
	}
}
