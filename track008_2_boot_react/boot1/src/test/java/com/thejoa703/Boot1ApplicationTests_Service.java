package com.thejoa703;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.entity.AppUser;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.AppUserRepository;
import com.thejoa703.repository.PostRepository;
import com.thejoa703.service.PostService;
import com.thejoa703.service.UserService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional // 테스트완료 후 데이터 자동롤백
class Boot1ApplicationTests_Service {
	
	@Autowired UserService userService;
	@Autowired PostService postService;	
	private AppUser testUser;
	private Post testPost;
	
   @Autowired  AppUserRepository   appUserRepository;   
   @Autowired  PostRepository   postRepository;   
   
   @BeforeEach
   void createTest() {
      //// AppUser  공통으로 사용할 테스트용 회원
      AppUser  user = AppUser.builder()
            .email("z@z")
            .password("z")
            .nickname("first")
            .provider("local")
            .build(); 
      testUser = appUserRepository.save(user);
      
      /// Post 
      Post post = new Post();
      post.setContent("테스트");
      post.setAppuser(testUser);
      testPost = postRepository.save(post);       
   } 
	
	@Test
	@DisplayName("1. 회원가입 및 사용자 간단 테스트")
	void testCreate() {
        UserRequestDto requestDto = new UserRequestDto();
        requestDto.setEmail("2@2");
        requestDto.setPassword("2");
        requestDto.setNickname("one");
        requestDto.setMobile("010111111");
        requestDto.setMbtitype(2);
        
        UserResponseDto createdUser = userService.createUser(requestDto);
        assertThat(createdUser.getId()).isNotNull();
        assertThat(createdUser.getEmail()).isEqualTo("2@2");
        
        UserResponseDto findUser = userService.getUser(createdUser.getId());
        assertThat(findUser.getId()).isNotNull();
	}
	
	@Test
	@DisplayName("2. 게시글 작성 테스트")
	void testPost() {
		Post createdPost = postService.createPost(testUser.getId(), "테스트");
		assertThat(createdPost.getId()).isNotNull();
		assertThat(createdPost.getContent()).isEqualTo("테스트");
	}
	
	@Test
	@DisplayName("3. 게시글 수정 및 검색 테스트")
	void testUpdatePost() {
		//작성
		Post createdPost = postService.createPost(testUser.getId(), "테스트");
		assertThat(createdPost.getId()).isNotNull();
		
		//수정
		Post updatedPost = postService.updatePost(createdPost.getId(), "수정");
		assertThat(updatedPost.getContent()).isEqualTo("수정");
		
		//조회
		Post foundPost = postService.getPostById(createdPost.getId());
		assertThat(foundPost.getContent()).isEqualTo("수정");
	}
	
	@Test
	@DisplayName("4. 삭제 테스트")
	void deletePost() {
		
		Post createdPost = postService.createPost(testUser.getId(), "테스트");
		assertThat(createdPost.getId()).isNotNull();
		
		//삭제
		postService.deletedPost(createdPost.getId());
		
		//여러글
		List<Post> posts = postService.getAllPosts();
		
		boolean exists = posts.stream()
				 			  .anyMatch(post -> post.getId().equals(createdPost.getId()));
		
		assertThat(exists).isFalse();
	}
	
}
