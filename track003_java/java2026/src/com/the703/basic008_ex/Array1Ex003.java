package com.the703.basic008_ex;

import java.util.Arrays;

public class Array1Ex003 {

	public static void main(String[] args) {
		char [] ch = new char[52]; 
		
		char eng = 'A', eng2='a';
		for(int i=0;i<ch.length;i++) {
			if(eng>='A'&&eng<='Z') {
				ch[i] = eng;
				eng = (char)(eng+1);
			}
			for(int i2=26;i2<ch.length;i2++) {
				if(eng2>='a'&&eng2<='z') {
					ch[i2] = eng2;
					eng2 = (char)(eng2+1);
				}
			}
		}	

		int cnt=0;
		char [] ch2 = {'a', 'e', 'i', 'o','u','A','E','I','O','U'};
		for(int i=0;i<ch.length;i++) {
			if(ch[i]=='a' || ch[i]=='e' || ch[i]=='i' || ch[i]=='o' || ch[i]=='u' ||
			   ch[i]=='A' || ch[i]=='E' || ch[i]=='I' || ch[i]=='O' || ch[i]=='U'		
			  ) {
				cnt = cnt+1;
			}

		}		
		System.out.println(cnt);

		
	}
}


