package com.the703.v5_burger;

import com.the703.v5_burger.service.Admin;
import com.the703.v5_burger.service.AdminImpl;

public class AdminMain {

	public static void main(String[] args) {
		Admin admin = new AdminImpl(); 
		Thread thread = new Thread(admin);
		thread.start();
		
		int categoryNum;

		do {
			categoryNum = admin.showCategory();

			if (categoryNum == 1) {
				admin.showSales();
			} else if (categoryNum == 2) {
				admin.showCategoryRanking();
			}
		} while (categoryNum != 9);
	}
}
