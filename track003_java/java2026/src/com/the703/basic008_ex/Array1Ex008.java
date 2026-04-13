package com.the703.basic008_ex;

public class Array1Ex008 {

	public static void main(String[] args) {
		int [] su  = {-3,-5,-1,-9,-7};
		int max=-99999, min=99999;
		int num1;
		
		for(int i=0;i<su.length;i++) {
			if(su[i]>max) {
				max = su[i];		
				
			}
			if(su[i]<min){
				min = su[i];
			}
		}
		
		System.out.println("최댓값 : " + max + " 최솟값 : " + min);
	}

}

