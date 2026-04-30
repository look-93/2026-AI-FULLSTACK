package com.the703.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class User{
	public String name;
	public int age;
	public User(String name,int age){
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString(){
		return "(name:"+name+", age:"+age+")";
	}
}

class UserComparator implements Comparator<User>{
	@Override
	public int compare(User a,User b){
		if(a.age>b.age) return 1;
		if(a.age<b.age) return -1;
		return 0;
	}
}
public class test2 {

	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		
		list.add(new User("A",40));
		list.add(new User("B",25));
		list.add(new User("C",10));
		list.add(new User("D",30));
		list.add(new User("E",26));
		
		System.out.println("정렬 전 ->"+list);
		Collections.sort(list,new UserComparator());
		//list.sort(new UserComparator()); 이 방법 역시 정렬 방법
		System.out.println("정렬 후->"+list);

	}

}
