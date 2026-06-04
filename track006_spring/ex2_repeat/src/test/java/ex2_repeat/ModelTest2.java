package ex2_repeat;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/root-context.xml")
public class ModelTest2 {
	
	@Autowired ApplicationContext context;
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired UserMapper userMapper;
	

	@Ignore //@Test
	public void test3() throws UnknownHostException {
		UserDto dto = new UserDto();
		dto.setNickname("test");
		dto.setBpass("1234");
		dto.setEmail("test@gmail.com");
		dto.setMobile("010-111-111");
		dto.setUdate("2026-06-04");
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		System.out.println(userMapper.insert(dto));
	}
	
	
	@Ignore //@Test
	public void test2() {
		System.out.println(userMapper.selectAll());
	}
	
	@Ignore //@Test
	public void test1() {
		System.out.println(userMapper.select(3));
	}
}
