package com.thejoa703.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.PostDto.PostRequestDto;
import com.thejoa703.dto.PostDto.PostResponseDto;
import com.thejoa703.entity.Post;
import com.thejoa703.repository.PostRepository;
import com.thejoa703.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Post Api", description = "게시글 관련 API")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

	private final PostService postService;
  
	@Operation(summary = "게시글작성", description = "새로운 게시글을 작성합니다.")
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // multipart/form-data
	public ResponseEntity<PostResponseDto> createPost(@Parameter(description = "작성자 사용자 ID") @RequestParam("userId") Long userId,
													  @ModelAttribute PostRequestDto dto,
													  @Parameter(description = "업로드할 이미지 파일 리스트") // Swagger 파라미터 설명을 표시하기 위한 어노테이션
													  @RequestPart(name="files", required = false) List<MultipartFile> files){ // @ModelAttribute -> 파일업로드와 같이 사용){

		
		return ResponseEntity.ok(postService.createPost(userId, dto, files));
	}
	
	@Operation(summary = "게시글 단건 조회", description = "게시글 아이디로 특정 게시글을 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<PostResponseDto> getPost(@PathVariable("id") Long id){
		Post response = postService.getPostById(id);
		return ResponseEntity.ok(new PostResponseDto(response));
	}
	
	@Operation(summary = "전체 게시글 조회", description = "전체 게시글을 조회합니다.")
	@GetMapping
	public ResponseEntity<List<PostResponseDto>> getPosts(){		
		List<Post> posts = postService.getAllPosts();
		List<PostResponseDto> lists = posts.stream().map(PostResponseDto::new).toList(); // PostResponseDto::new 이런자료형으로 만들어주세요
		return ResponseEntity.ok( lists );		// 200
	}
	
	@Operation(summary = "게시글 수정", description = "게시글 아이디로 특정 게시글을 수정합니다.")
	@PatchMapping(value= "/{postId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // Put(리소스의 전체 교체) patch (부분수정)
	public ResponseEntity<PostResponseDto> updatePost(@Parameter(description = "수정할 게시글 ID") @PathVariable("postId") Long postId,
													  @Parameter(description = "작성자 사용자 ID") @RequestParam("userId") Long userId,
													  @ModelAttribute PostRequestDto dto,
													  @Parameter(description = "수정 이미지 파일 리스트") // Swagger 파라미터 설명을 표시하기 위한 어노테이션
													  @RequestPart(name="files", required = false) List<MultipartFile> files){
		
		
		return ResponseEntity.ok(postService.updatePost(userId, postId, dto, files));
	}
	
	
	
	
	@Operation(summary = "게시글 삭제", description = "게시글 아이디로 특정 게시글을 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> deletePost(@PathVariable("id") Long id){
		postService.deletedPost(id);
		return ResponseEntity.ok(id);
	}
}

//http://localhost:8080/swagger-ui/index.html#/
/*
2. Post API     - 게시글 관련 API
- DELETE      /api/posts/{id}      게시글 삭제
- PUT      /api/posts/{id}      게시글 수정
- GET      /api/posts      전체 게시글 조회
- GET      /api/posts/{id}      게시글 단건 조회
- POST      /api/posts      게시글 작성 
*/