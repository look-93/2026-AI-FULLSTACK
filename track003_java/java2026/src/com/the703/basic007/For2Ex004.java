package com.the703.basic007;

public class For2Ex004 {

	public static void main(String[] args) {
			
		for(int i=4;i>=1;i--) {
			for(int i1=4;i1>=1;i1--) {
				if(i>=i1) {
					System.out.print("#");
				}
			}
			System.out.println();
		}
		
		//4 3 2 1
		for(int i=4;i>=1;i--) {
			
			for(int i1=1;i1<=i;i1++) {
				System.out.print("#");
			}
			System.out.println();
		}

	}

}
