package com.the703.basic014;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListVsVector {

	public static void main(String[] args) throws InterruptedException {
		//면접문제 2026-05-13 day032
		
		//ArrayList : 비동기화 → 단일스레드 환경에서 빠름
		//Vector    : 동기화  → 멀티스레드 환경에서 안정, 성능은 떨어짐
		
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> vector = new Vector<>();
		
		//arrayList			 //run
		Thread t1 = new Thread(()->{
			for(int i=0;i<100000;i++) {
				arrayList.add(i);
			}
		});
		Thread t2 = new Thread(()->{
			for(int i=100000;i<200000;i++) {
				arrayList.add(i);
			}
		});		
		
		t1.start(); t2.start();
		t1.join(); t2.join();
		
		System.out.println("ArrayList 크기 : " + arrayList.size());		
		
		//vector
		Thread t3 = new Thread(()->{
			for(int i=0;i<100000;i++) {
				vector.add(i);
			}
		});
		Thread t4 = new Thread(()->{
			for(int i=100000;i<200000;i++) {
				vector.add(i);
			}
		});		
		
		t3.start(); t4.start();
		t3.join(); t4.join();
		
		System.out.println("vector 크기 : " + vector.size());	
	}
}
