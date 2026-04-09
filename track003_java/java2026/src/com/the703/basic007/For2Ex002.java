package com.the703.basic007;

public class For2Ex002 {

	public static void main(String[] args) {
//		@###
//		#@##
//		##@#
//		###@
		for(int i=1;i<=4;i++) {					
			for(int i1=1;i1<=4;i1++) {				
				if(i==i1) {
					System.out.print("@");
				}else {
					System.out.print("#");
				}				
			}			
			System.out.println();
		}

	}
}
