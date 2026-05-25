package com.the703.v5_burger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Admin {
	Scanner sc = new Scanner(System.in);	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	String date = sdf.format(new Date());
	List<Item> item = new ArrayList<>();
	
	public void startAdmin() { // 키오스크 시작
		int categoryNum;

		categoryNum = showCategory();
		if(categoryNum == 1) {
			showSales();
		}else if(categoryNum == 2){
			showCategoryRanking();
		}
	}
	
	public Integer showCategory() { // 카테고리 조회		
		int categoryNum = -1;
		
		System.out.println("╔══════════════════════╗");
		System.out.println("      CATEGORY MENU     ");
		System.out.println("╚══════════════════════╝");
		System.out.println("1. 매출조회");
		System.out.println("2. 카테고리 랭킹 조회");
		System.out.println("9. 종료");
		System.out.println("────────────────────────");
		System.out.print("👉 선택 : ");
		categoryNum = sc.nextInt();
		
		return categoryNum;
	}
	
	public void showSales() {
		int sum = 0;
		
		System.out.println();
		System.out.println("╔══════════════════════╗");
		System.out.println("       🍔 매출 확인 🥤    ");
		System.out.println("╚══════════════════════╝");
		
		for(int i=0; i<item.size(); i++) {
			sum += item.get(i).getPrice();
		}
		System.out.println(date + " 총 매출 : " + sum + "원");		
	}	
	
	public void showCategoryRanking() {
		System.out.println("ddd");
	}
	
	public static void main(String[] args) {		
		Admin admin = new Admin();
		admin.startAdmin();
	}
}
