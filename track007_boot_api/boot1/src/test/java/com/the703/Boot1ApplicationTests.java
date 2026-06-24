package com.the703;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.the703.dao.Sboard2Dao;
import com.the703.dao.TestDao;
import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;

@SpringBootTest
class Boot1ApplicationTests {
	@Autowired TestDao dao;
	@Autowired Sboard2Dao sboard2Dao;
	@Autowired Sboard2Service sboard2Service;
	
	
	@Disabled //@Test 
	public void test10() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(4);
		assertEquals(1, sboard2Service.delete(dto));
	}
	
	@Disabled //@Test
	public void test9() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(4);
		assertEquals(4, sboard2Service.detail(dto).getId());
	}
	
	@Test
	public void test8() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setBtitle("title-new2"); 
		dto.setBcontent("content-new2");
		dto.setId(4);
		MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "data".getBytes());
		
		int result = sboard2Service.update(file, dto);
		assertEquals(1, result); 
	}
	
	@Disabled //@Test
	public void test7() {
		int cnt = sboard2Service.selectCnt();
		assertEquals(4, cnt);
	}
	
	@Disabled //@Test
	public void test6(){		
		List<Sboard2Dto> list = sboard2Service.list10(1);
		assertEquals(4, list.size());		
	}
	
	@Disabled //@Test
	public void test5() throws UnknownHostException {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setAppUserId(1);
		dto.setBtitle("title");
		dto.setBcontent("content");
		dto.setBpass("111");
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		
		// 
		MockMultipartFile file = new MockMultipartFile("file", "test.txt", "text/plain", "data".getBytes());
		
		int result = sboard2Service.insert(file, dto);
		System.out.println("...1 > " + result ); //기존방식 - 수동으로 값확		
		assertEquals(1, result);
	}

	
	@Disabled // @Test
	public void test4() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setBtitle("title-new"); 
		dto.setBcontent("content-new");
		dto.setId(4);
		/* dto.setBfile("1.png"); */
		
		int result = sboard2Dao.update(dto);
		assertEquals(1, result); // 자동확인 결과물이1인지 junit 체크
	}	

	@Disabled //@Test
	public void test3() {
		Sboard2Dto dto = new Sboard2Dto();
		dto.setId(3);
		Sboard2Dto result = sboard2Dao.selectById(dto);
		assertEquals(3, result.getId());		
	}
	
	@Disabled //@Test
	public void test2() throws UnknownHostException {
		
		HashMap<String, Object> para = new HashMap<>();
		para.put("start", 0);
		para.put("end", 10);
		List<Sboard2Dto> list10 = sboard2Dao.selectPaging(para);
		assertEquals(2, list10.size()); // 6숫자는 지금 있는 list의 갯수로(예상되는결과, 해당코드)
		assertNotNull(list10);
		assertEquals(2, sboard2Dao.selectCnt()); // 전체갯수 4
	
		
//		Sboard2Dto dto = new Sboard2Dto();
//		dto.setAppUserId(1);
//		dto.setBtitle("title");
//		dto.setBcontent("content");
//		dto.setBpass("111");
//		dto.setBfile("1.png");
//		dto.setBip(InetAddress.getLocalHost().getHostAddress());
//		
//		int result = sboard2Dao.insert(dto);
//		System.out.println("...1 > " + result ); //기존방식 - 수동으로 값확인 : 콘솔에 1
//		assertEquals(1, result); // 자동확인 : 결과물이1인지 junit이 체크
	}
	
	
	@Disabled //@Test
	void test1() {
		System.out.println(dao.readTime());
	}

}
