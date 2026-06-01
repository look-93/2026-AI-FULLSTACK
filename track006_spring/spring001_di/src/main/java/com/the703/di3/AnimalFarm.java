package com.the703.di3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component("animalFarm")
@Data
@AllArgsConstructor // 생성자
@NoArgsConstructor // 필드있는생성자
public class AnimalFarm {
	@Value("${name}")
	private String name;
	
	@Resource (name="${ani}")
	private Animal ani;	
	
	public String aniSleep(){return name + ">" + ani.sleep();}
	public String aniEat(){return name + ">" + ani.eat();}
	public String aniPoo(){return name + ">" + ani.poo();}	
	public void print() {
		System.out.println(aniSleep() );
		System.out.println(aniEat() );
		System.out.println(aniPoo() );
	}
}
