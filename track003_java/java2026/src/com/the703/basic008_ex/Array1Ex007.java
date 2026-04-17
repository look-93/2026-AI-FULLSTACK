package com.the703.basic008_ex;

public class Array1Ex007 {

	public static void main(String[] args) {
		int [] su  = {-3,-5,-1,-9,-7};
		int rank=0;
		
		for(int i=0;i<su.length;i++) {
			if(su[i]>=su[4]) {					
				rank = rank + 1;			
//				System.out.println(su[i]);
			}
		}
		System.out.println(rank+"등");

	}

}

