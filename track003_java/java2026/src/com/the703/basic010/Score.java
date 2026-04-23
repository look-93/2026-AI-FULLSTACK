package com.the703.basic010;

public class Score { // com.the703.basic010 패키지에 설정해주세요
	private String name;
	private int kor, eng, math, total;
	private double aver;
	private String p, s, rank;

	public static void info() {
		System.out.print("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n"
				+ "이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹\n"
				+ "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
	}

	public void show() {
		this.total = this.kor + this.eng + this.math;
		this.aver = total/(double)3;
		if(aver >= 95) {
			p = "합격";
			s ="장학생";
		}else {
			p = "불합격";
			s ="";
		}
		
		int cnt = (int)aver/10;
		for(int i=0; i<cnt; i++) {
			if (rank==null) rank="";
			rank = rank + "★";
		}
		
		System.out.print(this.name + "\t" + this.kor + "\t" + this.eng + "\t"  + this.math + "\t"
						+ total	   + "\t" + String.format("%.2f", aver) + "\t" + p         + "\t"  
						+ s        + "\t" + rank + "\n");
	}

	public Score() {
		super();
	}

	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
//		this.total = total;
//		this.aver = aver;
//		this.p = p;
//		this.s = s;
//		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
//	public int getTotal() {
//		return total;
//	}
//	public void setTotal(int total) {
//		this.total = total;
//	}
//	public double getAver() {
//		return aver;
//	}
//	public void setAver(double aver) {
//		this.aver = aver;
//	}
//	public String getP() {
//		return p;
//	}
//	public void setP(String p) {
//		this.p = p;
//	}
//	public String getS() {
//		return s;
//	}
//	public void setS(String s) {
//		this.s = s;
//	}
//	public String getRank() {
//		return rank;
//	}
//	public void setRank(String rank) {
//		this.rank = rank;
//	}

}