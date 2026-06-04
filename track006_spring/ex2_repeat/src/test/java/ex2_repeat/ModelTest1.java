package ex2_repeat;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.BoardMapper;
import com.the703.dao.TestMapper;
import com.the703.dto.BoardDto;

@RunWith(SpringJUnit4ClassRunner.class) //1. spring 구동테스트
@ContextConfiguration(locations = "classpath:config/root-context.xml") //2. 설정
public class ModelTest1 {
	
	@Autowired ApplicationContext context; // 3. Bean(스프링이 관리하는 객체) 생성~소멸 
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired TestMapper test;
	@Autowired BoardMapper boardMapper;
	
	@Ignore //@Test
	public void test7(){
		System.out.println(boardMapper.delete(1));
	}	
	
	@Ignore //@Test
	public void test6(){
		BoardDto dto = new BoardDto(); 
		dto.setBname("updatetest");
		dto.setBno(1);
		System.out.println(boardMapper.update(dto));
	}	
	
	@Ignore //@Test
	public void test5(){
		BoardDto dto = new BoardDto(); 
		dto.setBname("boardname");
		dto.setBpass("1234");
		dto.setBtitle("boardtitle");
		dto.setBcontent("boardcontent");
		dto.setBdate("2026-06-04");
		dto.setBhit(0);
		dto.setBip("0.0");
		System.out.println(boardMapper.insert(dto));
	}	
	
	@Ignore //@Test
	public void test4(){
		System.out.println(boardMapper.select(1));
	}	
	
	@Test
	public void test3(){
		System.out.println(boardMapper.selectAll());
	}		
	
	@Ignore //@Test
	public void test2(){
		System.out.println(test.now());
	}	
	
	@Ignore //@Test
	public void test1(){
		System.out.println(sqlSession);
	}	
}
