package com.the703.basic010;

//1) basic010, basic010_ex
class UserInfo{
	public 		String name;		//아무데서나 다 접근가능
	protected 	String safeCode; 	//자식에서 사용가능(extends 시)
		   		String house;		//패키지(폴더)
	private	int iQ;					//클래스내부 - The value of the field UserInfo.iQ is not used
	
	//alt + shift + s
	public int getiQ() {  // private 은 UserInfo에서만 사용가능함, 외부에서 사용하려면 geter ,geter사용
		return iQ;
	}
	public void setiQ(int iQ) {
		this.iQ = iQ;
	}
}


public class Class007_modifier {

	public static void main(String[] args) {
		System.out.println("\n\n1. 홍길동 아버지 정보");
		UserInfo2 user = new UserInfo2();
		user.name="홍상직"; 			//public 아무데서나 다 접근가능
		user.safeCode = "1234";
		user.house = "전라남도 장성군";
		
		// private - The field UserInfo.iQ is not visible
		//user.iQ = 148; 				
		user.setiQ(148);
		System.out.println(user.getiQ());
		
	}

}

/*
1. 지정접근자
- 클래스의 구성요소에 대한 접근을 제한하는 역할
			클래스내부		패키지(폴더)	하위클래스		그외
public		o			o			o			o
protected	o			o			o			x
default		o			o			x			x				
private		o			x			x			x 
 */