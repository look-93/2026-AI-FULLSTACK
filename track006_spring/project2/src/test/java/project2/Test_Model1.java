package project2;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.TestMapper;
import com.the703.dto.BoardDto;
import com.the703.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/root-context.xml", "classpath:config/security-context.xml"} )
public class Test_Model1 {
	@Autowired DataSource dataSource;
	@Autowired SqlSession sqlSession;
	@Autowired ApplicationContext context;
	@Autowired TestMapper testMapper;
	
	@Autowired BoardService boardService;
	
	@Ignore //@Test
	public void test3() {
		//리스트가져오기 - 페이징10
		//System.out.println(boardService.select10(1));
		BoardDto dto = new BoardDto();
		dto.setBname("ddddd");
		dto.setBpass("1");
		dto.setBcontent("ddd");
		dto.setBtitle("adadadad");
		dto.setBip("123");
		//dto.setBfile("the.png");
		/*
		 * MockMultipartFile file = new MockMultipartFile( "file", "the703.png",
		 * "image/png", new byte[0] );
		 */
		//System.out.println(boardService.insert(dto, file));
		
		 //(bname , bpass , btitle , bcontent , bip, bfile)
	}
	
	@Ignore //@Test
	public void test2() {
		System.out.println(testMapper.now());
	}
	
	@Ignore //@Test
	public void test1() {
		System.out.println(context);
	}
}
