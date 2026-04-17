package com.the703.basic008_ex;

public class Array1Ex004 {

	public static void main(String[] args) {
		char [] ch  = {'B', 'a', 'n', 'a', 'n', 'a'};
		String  ch2 = "";
		
		for(int i=0; i<ch.length; i++) {
			if(ch[i]>='A' && ch[i]<='Z') {
				ch2 = (String)(ch2 + Character.toUpperCase(ch[i]));
			}else {
				ch2 = (String)(ch2 + Character.toLowerCase(ch[i]));
			}
		}
		
		System.out.println(ch2);
	}

}


//toUpperCase() / toLowerCase() / equalsIgnoreCase()