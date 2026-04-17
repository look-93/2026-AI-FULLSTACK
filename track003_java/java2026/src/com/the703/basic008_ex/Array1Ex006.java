package com.the703.basic008_ex;

public class Array1Ex006 {

	public static void main(String[] args) {
		int [] su  = {-3,5,-1,9,-7,2,-11};
		int hab=0;
		
		for(int i=0;i<su.length;i++) {
			if(su[i]>=0&&su[i]%2!=0) {
				hab = hab + su[i];
			}
		}	
		System.out.println(hab);
	}

}

