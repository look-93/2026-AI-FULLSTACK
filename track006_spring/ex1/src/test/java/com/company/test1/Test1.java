package com.company.test1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.ioctest.IceCreamShop;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/test1.xml")
public class Test1 {
	
	// import org.springframework.context.ApplicationContext;
	@Autowired ApplicationContext context; // ±¸µ¿	

	@Test
	public void test() {
	    IceCreamShop shop = (IceCreamShop) context.getBean("iceCreamShop");
	    shop.print();
	}
}
