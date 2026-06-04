package ex2;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.MvcBoardMapper;
import com.the703.dao.TestMapper;
import com.the703.dto.MvcBoardDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/root-context.xml")
public class ModelTest001 {
	
	@Autowired ApplicationContext context;
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired TestMapper test;
	@Autowired MvcBoardMapper mvcBoardMapper;
	
	@Ignore //@Test
	public void test1() {
		System.out.println(test.now());
	}
	
	@Test
	public void test2() {
		System.out.println(mvcBoardMapper.selectAll());
	}
	
	@Ignore //@Test
	public void test3() {
		System.out.println(mvcBoardMapper.select(1));
	}
	
	@Ignore //@Test
	public void test4() {
		MvcBoardDto dto = new MvcBoardDto();
		dto.setBname("haha");
		dto.setBpass("123");
		dto.setBtitle("title");
		dto.setBcontent("content");
		dto.setBdate("2026-06-04");
		dto.setBhit(0);
		dto.setBip("0.0.0");
		System.out.println(mvcBoardMapper.insert(dto));		
	}	
	
	@Ignore @Test
	public void test5() {
		MvcBoardDto dto = new MvcBoardDto();
		dto.setBtitle("TEST");
		dto.setBno(1);
		System.out.println(mvcBoardMapper.update(dto));
	}
	
	@Ignore //@Test
	public void test6() {
		System.out.println(mvcBoardMapper.delete(1));
	}
}
