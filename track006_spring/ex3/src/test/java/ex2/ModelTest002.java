package ex2;

import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder; // 확인
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.UserDto;
import com.the703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:config/*-context.xml")
@ContextConfiguration(locations = {"classpath:config/root-context.xml", "classpath:config/security-context.xml"} )
public class ModelTest002 {
	
	@Autowired UserService userService;
	@Autowired UserMapper userMapper;
	@Autowired @Qualifier("passwordEncoder") PasswordEncoder pwencoder;
	
	/*security*/
	@Test
	public void test2() throws UnknownHostException {
		
		/* 로그인시 인가 */
		AuthDto dto2 = new AuthDto();
		dto2.setEmail("a@a");
		System.out.println(userMapper.readAuth(dto2));
		
		/* 권한 2개 줬으면 주석달고 위에 해당유저정보 가져오기 */
		/* 권한 2개 - 회원, ADMIN*/
		/*AuthDto dto1 = new AuthDto();
		dto1.setEmail("a@a");
		dto1.setAuth("ROLE_ADMIN");
		System.out.println(userMapper.insertAuth(dto1));*/
		
		/*회원가입시 암호화 성공했으면 주석달고 위에 권한실행*/
		/*회원가입 (비밀번호암호화) pwencoder.encode()*/
		/*
		 * UserDto dto = new UserDto(); dto.setNickname("1");
		 * dto.setBpass(pwencoder.encode("a")); dto.setEmail("a@a");
		 * dto.setMobile("0101111111");
		 * dto.setBip(InetAddress.getLocalHost().getHostAddress());
		 * System.out.println(userService.insert(dto));
		 */
	}
	
	
	@Ignore //@Test
	public void test1() {
		UserDto dto = new UserDto();
		//이메일중복		
		//System.out.println(userService.findEmail("dd@gmail.com"));
		
		//마이페이지
		System.out.println(userService.findMypage(1));
		
		//로그인
		/*
		 * dto.setEmail("rr@gmail.com"); dto.setBpass("1");
		 * System.out.println(userService.findLogin(dto));
		 */
		//회원가입
		
		/*
		 * dto.setNickname("1"); dto.setBpass("1"); dto.setEmail("rr@gmail.com");
		 * dto.setMobile("010-111-1111"); dto.setBip(InetAddress.getLocalHost().getHostAddress());
		 * System.out.println(userService.insert(dto));
		 */
	}

}
