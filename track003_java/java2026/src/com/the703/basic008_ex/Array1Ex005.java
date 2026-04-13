package com.the703.basic008_ex;

public class Array1Ex005 {

	public static void main(String[] args) {
		int [] su  = {-3,5,-1,9,-7};
		int cnt=0;
		
		for(int i=0;i<su.length;i++) {
			if(su[i]<0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}

