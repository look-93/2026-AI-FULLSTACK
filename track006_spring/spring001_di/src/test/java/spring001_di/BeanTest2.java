package spring001_di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.di2.AnimalFarm;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = "classpath:config/beans2.xml" ) // 경로 - src/main/java경로에서 config파일에서 beans2.xml 찾아오기
public class BeanTest2 {
	
	// import org.springframework.context.ApplicationContext;
	@Autowired ApplicationContext context; // 구동
	
	@Test
	public void test() {// Bean - 스프링이 관리하는 부품객체
		AnimalFarm animalFarm = (AnimalFarm)(context.getBean("animalFarm"));
		animalFarm.print(); // ##사용하기 ctrl + f11 -> junit 선택
		
//		AnimalFarm animalFarm2 = (AnimalFarm)(context.getBean("animalFarm2"));
//		animalFarm2.print();
	}
	
}
