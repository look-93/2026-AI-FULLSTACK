package com.the703.basic008_ex;

public class Array1Ex010 {

	public static void main(String[] args) {
		int []datas = {1,3,1,1,4,4,3,1,4,1,2};
		int []stars = new int[4];
		
//		for(int i =0; i<=4; i++) {System.out.print("★");}System.out.println();
//		for(int i =0; i<=0; i++) {System.out.print("★");}System.out.println();
//		for(int i =0; i<=1; i++) {System.out.print("★");}System.out.println();
//		for(int i =0; i<=2; i++) {System.out.print("★");}System.out.println();	
		
//		for(int i=0;i<datas.length;i++) {
//			int num = datas[i];
//			
//			if(num==1) {
//				stars[0] = ++stars[0];	
//			}else if(num==2) {
//				stars[1] = ++stars[1];
//			}else if(num==3) {
//				stars[2] = ++stars[2];				
//			}else if(num==4) {
//				stars[3] = ++stars[3];					
//			}	
//		}	

		for(int i=0;i<datas.length;i++) {
//			int num = datas[i];
//			stars[num-1] = ++stars[num-1];	
			stars[datas[i]-1]++;			
		}	
		
		for(int i=0;i<stars.length;i++) {
//			System.out.println(stars[i]);
			int j = stars[i];
//			System.out.println(j);
			for(int i2=0;i2<j;i2++) {
				System.out.print("★");
			}

			System.out.println();
		}			
	}

}

//배열을 이용하여 다음의 프로그램을 작성하시오.
//다음은 보험의 실적을 적은  datas 배열이다
//datas 배열에는 각 회원의 보험 실적 건수마다 datas배열에 회원의 아이디가 적혀있다.
//회원번호 1~4까지의 각 실적의 갯수를 세어서 갯수만큼stars 배열에 갯수를 담으시오.
//그다음 해당 숫자만큼 * 을 출력하는 프로그램을 작성하시오.
//int []datas = {1,3,1,1,4,4,3,1,4,1,2}
//int []stars = new int[4]

// 1: 5
// 3: 2
// 4: 3
// 2: 1

// 1: 5
// 2: 1
// 3: 2
// 4: 3 
