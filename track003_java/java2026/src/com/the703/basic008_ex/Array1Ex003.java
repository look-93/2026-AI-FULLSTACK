package com.the703.basic008_ex;

import java.util.Arrays;

public class Array1Ex003 {

	public static void main(String[] args) {
		char [] chs = new char[52]; 		
		char eng = 'A';
		
//		for(int i=0;i<26;i++) {
//			ch[i] = (char)(eng+i);
//		}	
//
//		for(int i=26;i<52;i++) {
//			ch[i] = (char)(eng+32+ i-26);
//		}	

//		for(int i=0;i<ch.length;i++) {
//			if(ch[i]=='a' || ch[i]=='e' || ch[i]=='i' || ch[i]=='o' || ch[i]=='u' ||
//			   ch[i]=='A' || ch[i]=='E' || ch[i]=='I' || ch[i]=='O' || ch[i]=='U'		
//			  ) {
//				cnt = cnt+1;
//			}
//
//		}		
//		System.out.println(ch);
		
		for(int i=0;i<51;i++) {			
			int add = i;
			
//			if(i<26) {
//				 65~90 90=> 25(i) + 65(eng)
//				chs[i] = (char)(eng+i); 			
//			}else {
//				 97~122  97 => 26 + 65(eng)+6
//				chs[i] = (char)(eng+6+i); 
//			}
			
			if(i>25) {
				add += 6;
			}
			chs[i] = (char)(eng+add);
		}
//		System.out.println(chs);
		
		int cnt=0;
		char [] ch2s = {'a', 'e', 'i', 'o','u','A','E','I','O','U'};
		for(int i=0;i<chs.length;i++) {
			char ch = chs[i]; 
			
			for(int j=0;j<ch2s.length;j++) {
				char ch2 = ch2s[j];
				if(ch == ch2) {
					cnt++;
					break;
				}
			}			
		}
		System.out.println(cnt);		
		
	}
}


