package com.the703.basic007_ex;

public class For2Ex004 {

	public static void main(String[] args) {
		
		//ver-1 작은단위로 눈에 보이는 그대로 		
		System.out.print('#');      System.out.print('#');  System.out.print('#');      System.out.print('#');     System.out.println();
		System.out.print('#');      System.out.print('#');  System.out.print('#');      System.out.println();
		System.out.print('#');      System.out.print('#');   System.out.println();  // 2번째부터
		System.out.print('#');      System.out.println();

		//ver-2 칸정리
		System.out.println();
		
		for(int i=1; i<=4; i++){  System.out.print('#');   }     System.out.println();
		for(int i=1; i<=3; i++){  System.out.print('#');   }     System.out.println();
		for(int i=1; i<=2; i++){  System.out.print('#');   }     System.out.println();
		for(int i=1; i<=1; i++){  System.out.print('#');   }     System.out.println();
 
		
		//ver-3 층정리
		System.out.println();
		for(int ch=4; ch>=1; ch--)
		{  for(int i=1; i<=ch; i++){  System.out.print('#');   }     System.out.println();  }

		
		//ver-4
		for(int i=4;i>=1;i--) {
			for(int i1=4;i1>=1;i1--) {
				if(i>=i1) {
					System.out.print("#");
				}
			}
			System.out.println();
		}
		
		//ver-5
		//4 3 2 1
		for(int i=4;i>=1;i--) {
			
			for(int i1=1;i1<=i;i1++) {
				System.out.print("#");
			}
			System.out.println();
		}

	}

}

/*


패키지명 : ccom.the703.basic007
클래스명 :  For2Ex004   (이중for 이용)

####
###
##
#

*/
