package com.the703.basic007;

public class For2Ex001 {

	public static void main(String[] args) {
//		####
//		####
//		####
//		####		
		
		for(int i=1;i<=4;i++) {
			for(int i1=1;i1<=4;i1++) {
				System.out.print("#"+(i1%4==0?"\n":""));
			}
		}
		
		for(int i=1;i<=4;i++) {
			System.out.println();
			for(int i1=1;i1<=4;i1++) {
				System.out.print("#");
			}
		}		
		
	}
}
