package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Total {

	public static void main(String[] args) {
		String[] names={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kors={100,20,90,70,35};   
	    int[] engs={100,50,95,80,100};
	    int[] mats={100,30,90,60,100};
	    int[] avers = new int[5];
	    int[] ranks  = new int [5];
	    String [] stars  = new String [5];
	    String [] pass = new String [5];
	    String [] jang = new String [5];	    
	    String result = "";
	    int cnt = 1;
	    for(int i=0;i<avers.length;i++) {
	    	int kor = kors[i];
	    	int eng = engs[i];
	    	int mat = mats[i];
	    	
	    	avers[i] = (int)(kor + eng + mat)/3;

	    	if(avers[i]>=60) {
	    		pass[i] = "합격";
	    	}else {
	    		pass[i] = "불합격";
	    	}
	    	
	    	if(avers[i]>=95) {
	    		jang[i] = "장학생";
	    	}else {
	    		jang[i] = " ";
	    	}
	    }
//	    System.out.println(Arrays.toString(stars));
	    for(int i=0;i<avers.length;i++) {
	    	int aver = avers[i]/10;
	    	for(int j=0;j<aver;j++) {
	    		if(stars[i] == null) stars[i] = "";
	    		stars[i] = stars[i]+"★";
//	    		System.out.print("★");
	    	}
//	    	System.out.println(aver);
	    }
	    
	    for(int i=0;i<avers.length;i++) {
	    	for(int j=0;j<avers.length;j++) {
	    		if(avers[i] <= avers[j]) {
	    			ranks[i] = ranks[i]+cnt;	    			
	    		}		    	
	    	}
//	    	System.out.println(rank);
	    }	    
//	    System.out.println(Arrays.toString(ranks));	    
	    
	    for(int i=0;i<names.length;i++) {
	    	String name = names[i], p = pass[i], j = jang[i], star = stars[i];
	    	int kor = kors[i], eng = engs[i], mat = mats[i], aver = avers[i], rank = ranks[i];
	    	result = result +name 	+"\t" 	+kor 	+"\t" 
	    			+eng 	+"\t" 	+mat 	+"\t" 	+aver 	
	    			+"\t" 	+rank	+"\t"	+p 		+"\t" 	
	    			+j 		+"\t" 	+star 	+"\n";
	    	}

	       //최종출력
	       System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
	    		   			+ "이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹\n"
	    		   			+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	       System.out.print(result);
	       System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");		

	}

}
