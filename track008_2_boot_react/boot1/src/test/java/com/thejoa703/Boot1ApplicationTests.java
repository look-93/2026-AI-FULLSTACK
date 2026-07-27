package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.PostRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional // 테스트완료 후 데이터 자동롤백
class Boot1ApplicationTests {
	
	@Autowired AppUserRepository appUserRepository;
	@Autowired PostRepository postRepository;
	
	private AppUser savedUser;	
	private Post savedPost;
	
	//insert, update(save) select(findBy필드명) deleteById	
	
	//1. create(생성테스트)
	@BeforeEach
	void createTest() {
		// builder insert 순서대로 안해도됨
		
		//AppUser 공통으로 사용할 테스트용 회원
		AppUser user = AppUser.builder()
						.email("z@z")
						.password("z")
						.nickname("first")
						.provider("local")
						.build();
		
		savedUser = appUserRepository.save(user);
		assertThat(savedUser.getId()).isNotNull();
		
		//Post 공통으로 사용할 테스트용 게시글
		Post post = new Post();
		post.setContent("CRUD 테스트용 게시글 내용입니다.");
		post.setAppuser(savedUser);
		
		savedPost = postRepository.save(post);
		assertThat(savedPost.getId()).isNotNull();
	}
	
	@Test
	@DisplayName("1. CREATE 생성테스트")
	void testCreate() {
		assertThat(savedUser.getId()).isNotNull();
		assertThat(savedPost.getId()).isNotNull();
	}
	
	@Test
	@DisplayName("2. READ 생성테스트")
	void testRead() {
		Optional<AppUser> foundUser = appUserRepository.findById(savedUser.getId());
		assertThat(foundUser).isPresent(); // true, false
		assertThat(foundUser.get().getNickname()).isEqualTo("first");
		
		Optional<AppUser> foundEmail = appUserRepository.findByEmail("z@z");
		assertThat(foundEmail).isPresent();
		assertThat(foundEmail.get().getEmail()).isEqualTo("z@z");
		
		List<Post> posts = postRepository.findByDeletedFalse();
		assertThat(posts).isNotEmpty();
	}
	
	@Test
	@DisplayName("3. UPDATE 생성테스트 (save)")
	void testUpate() {
		savedUser.setNickname("zero");
		appUserRepository.save(savedUser);
		
		savedPost.setContent("new ...................... 20260727");
		postRepository.save(savedPost);
		
		AppUser updatedUser =  appUserRepository.findById(savedUser.getId()).get();
		Post updatedPost =  postRepository.findById(savedPost.getId()).get();
		
		assertThat(updatedUser.getNickname()).isEqualTo("zero");
		assertThat(updatedPost.getContent()).isEqualTo("new ...................... 20260727");
		
	}
	
	@Test
	@DisplayName("4. DELETE 생성테스트 (delete)")
	void testDelete() {
		appUserRepository.delete(savedUser);
		postRepository.delete(savedPost);
		
		Optional<AppUser> deletedUser =  appUserRepository.findById(savedUser.getId());
		Optional<Post> deletedPost =  postRepository.findById(savedPost.getId());
		
		assertThat(deletedUser).isEmpty();
		assertThat(deletedPost).isEmpty();
	}
}

//Jpa : save(insert, update) / delete(delete) / findBy필드명(select) 
