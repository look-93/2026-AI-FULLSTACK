package ex2_dev;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.TestMapper;
import com.the703.dao.UserInfoMapper;
import com.the703.dto.UserInfoDto;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration (locations = "classpath:config/root-context.xml") //설정파일
public class ModelTest001 {
	
	@Autowired ApplicationContext context;
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession; 
	@Autowired TestMapper test;
	@Autowired UserInfoMapper userInfoMapper;	
	
	@Ignore //@Test
	public void test1() {
		System.out.println(test.now());
	}
	
	@Ignore //@Test
	public void test2() {
		UserInfoDto user = new UserInfoDto();
		user.setEmail("dd@gmail.com");
		user.setAge(11);
		System.out.println(userInfoMapper.insert(user));
		
	}
	
	@Ignore //@Test	
	public void test3() {
		System.out.println(userInfoMapper.selset(1));		
	}
	
	@Ignore //@Test	
	public void test4() {
		System.out.println(userInfoMapper.selsetAll());		
	}
	
	@Ignore //@Test
	public void test5() {
		UserInfoDto user = new UserInfoDto();
		user.setEmail("qqqq@daum.net");
		user.setNo(1);
		System.out.println(userInfoMapper.update(user));
	}		
	@Test	
	public void test6() {
		System.out.println(userInfoMapper.delete(1));		
	}	
}
