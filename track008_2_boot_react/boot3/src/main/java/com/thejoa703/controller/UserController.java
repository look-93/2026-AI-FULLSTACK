package com.thejoa703.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.security.JwtProperties;
import com.thejoa703.security.JwtProvider;
import com.thejoa703.security.TokenStore;
import com.thejoa703.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Tag(name="User Api", description="회원 인증 및 관리 관련 API (Session & Swagger 지원)") //swagger
@RestController // @Controller + @ResponseBody
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final JwtProperties props;          // JWT 출입증(설정값)  
    private final JwtProvider jwtProvider;      // JWT 토큰생성 / 검증 (access Token / refresh Token)
    private final TokenStore tokenStore;    	// JWT 저장소
	
	//사용자 등록(회원가입)
	//ResponseEntity - 상태코드 전달 - /api/users
	@Operation(summary = "회원가입" , description = "새로운 사용자를 등록합니다.") //swagger
	@PostMapping(value ="/signup", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) // multipart/form-data
	public ResponseEntity<UserResponseDto> createUser(@ModelAttribute UserRequestDto request,
													  @Parameter(description = "프로필 이미지 파일") // Swagger 파라미터 설명을 표시하기 위한 어노테이션
													  @RequestPart(name="ufile", required = false) MultipartFile ufile){ // @ModelAttribute -> 파일업로드와 같이 사용
		return ResponseEntity.ok(userService.createUser(request, ufile));
	}
	
	//이메일중복조회
	@Operation(summary = "이메일중복조회" , description = "사용 중인 이메일인지 중복 여부를 확인합니다.") //swagger
	@GetMapping("/check-email")
	public ResponseEntity<Boolean> checkEmail(@Parameter(description = "확인할 이메일") @RequestParam("email") String email){
		return ResponseEntity.ok(userService.existsByEmail(email));
	}
	
	//닉네임중복확인
	@Operation(summary = "닉네임중복조회" , description = "사용 중인 닉네임인지 중복 여부를 확인합니다.") //swagger
	@GetMapping("/check-nickname")
	public ResponseEntity<Boolean> checkNickname(@Parameter(description = "확인할 닉네임") @RequestParam("nickname") String nickname){
		return ResponseEntity.ok(userService.existsByNickname(nickname));
	}
	
	//로그인
//	@Operation(summary = "사용자 로그인" , description = "이메일과 비밀번호로 로그인하여 세션을 생성합니다.")
//	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<UserResponseDto> login(@RequestBody LoginRequest request, HttpSession session){
////		Long userId = (Long) session.getAttribute("LOGIN_USER_ID");
////		if(userId == null) {return ResponseEntity.status(401).build();}//권한없음
////		return ResponseEntity.ok(userService.getUser(userId));
//		
//		UserResponseDto user = userService.login(request);
//		session.setAttribute("LOGIN_USER_ID", user.getId()); //세션셋팅
//		return ResponseEntity.ok(user);
//	}
    @Operation(summary = "로그인 (Access Token + Refresh Token 발급)")
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> login(
            @RequestBody LoginRequest request,
            HttpServletResponse response   // 응답객체 (쿠키설정)
    ) { 
    	// 1. 사용자 인증처리
        UserResponseDto user = userService.login(request);
        
        // 2-1 AccessToken 생성 (사용자 id + 역할) - room (그방에 맞는 키 왔다갔다)
        String accessToken = jwtProvider.createAccessToken(
                user.getId().toString(),
                Map.of("role", user.getRole())
        );
        
        // 2-2 Refresh Token - room 아예빼기 (checkout)
        String refreshToken = jwtProvider.createRefreshToken(user.getId().toString());
        
        //2-3 redis 에 저장
        tokenStore.saveRefreshToken(
                user.getId().toString(),
                refreshToken,
                (long) props.getRefreshTokenExpSeconds()
        );
         
        //3. 쿠키설정
        ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true) 		// js 접근불가   
                .secure(true)   		// https 전송한 허용
                .sameSite("Strict")  	// csrf 방지, 다른 사이트에서 요청할 때 이 쿠키를 보내지 않도록 제한하는 설정
                .path("/")   			// 전체경로 적용
                .maxAge(props.getRefreshTokenExpSeconds())	// 만료시간설정  
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString()); 
        //4. 사용자정보반환
        return ResponseEntity.ok(Map.of(
                "accessToken", accessToken,
                "user", user
        ));
    }

    
	//로그아웃
//	@Operation(summary = "사용자 로그아웃" , description = "현재 세션을 만료시켜 로그아웃합니다.")
//	@PostMapping("/logout")
//	public ResponseEntity<Void> logout( HttpSession session){
//		session.invalidate();
//		return ResponseEntity.noContent().build();
//	}	
    @Operation(summary = "로그아웃")
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
          @CookieValue(name = "refreshToken", required = false) String refreshToken,
                                       HttpServletResponse response) {
        var claims = jwtProvider.parse(refreshToken).getBody();
        String userId = claims.getSubject();

        tokenStore.deleteRefreshToken(userId); // redis 제거
 
        ResponseCookie deleteCookie = ResponseCookie.from("refreshToken", "")
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .path("/")
                .maxAge(0)
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, deleteCookie.toString());

        return ResponseEntity.noContent().build();
    }
    
	//마이페이지
//	@Operation(summary = "현재 로그인한 사용자 정보조회" , description = "세션기반으로 현재 로그인된 사용자의 정보를 조회합니다.")
//	@GetMapping("/me")
//	public ResponseEntity<UserResponseDto> mypage(HttpSession session){
//		Long userId = (Long) session.getAttribute("LOGIN_USER_ID");
//		if(userId == null) {return ResponseEntity.status(401).build();}//권한없음
//			
//		return ResponseEntity.ok(userService.getUser(userId));
//
//	}
    
    @Operation(summary = "현재 로그인한 사용자 정보 조회")
    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> me(HttpServletRequest request,
                 @CookieValue(name = "refreshToken", required = false) String refreshToken) {
        try { 
            // AUTHORIZATION 헤더에서 AccessToken 확인
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);  //Bearer  제거
                var claims = jwtProvider.parse(token).getBody(); // 토큰파싱  
                String userId = claims.getSubject();   // 사용자 id 추출
                UserResponseDto user = userService.getUser(Long.valueOf(userId)); //사용자조회  
                return ResponseEntity.ok(user); //사용자반환
            }  
            if (refreshToken != null) {
                var claims = jwtProvider.parse(refreshToken).getBody();
                String userId = claims.getSubject(); //사용자 id값
                UserResponseDto user = userService.getUser(Long.valueOf(userId)); //사용자 조회  
                return ResponseEntity.ok(user);
            }
            return ResponseEntity.status(401).build();   //인증실패
        } catch (Exception e) {
            return ResponseEntity.status(401).build();  // 예외 발생시 인증실패
        }
    }
    
    
	//사용자 단건조회	- /api/users/1 해당번호
	@Operation(summary = "사용자 단건조회", description = "사용자 아이디로 특정 회원정보를 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDto> getUser(@PathVariable("id") Long id){
		UserResponseDto response = userService.getUser(id); 
		return ResponseEntity.ok(response); // ok 200
		//return ResponseEntity.status(HttpStatus.ok).body(response);
	}
	
	//닉네임수정
	@Operation(summary = "닉네임변경" , description = "특정 사용자의 닉네임을 변경합니다")
	@PatchMapping("/{userId}/nickname")
	public ResponseEntity<UserResponseDto> updateNickname(@Parameter(description="사용자ID") @PathVariable("userId") Long userId,
														  @Parameter(description="변경할 닉네임") @RequestParam("nickname") String nickname){
		return ResponseEntity.ok(userService.updateNickname(userId, nickname)); 
	}
	//이미지프로필수정
	@Operation(summary = "프로필이미지업로드/교체" , description = "특정 사용자의 프로필 이미지를 변경합니다.")
	@PatchMapping(value = "/{userId}/profile-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UserResponseDto> updateProfileImage (@Parameter(description="사용자ID") @PathVariable("userId") Long userId,
			  												   @Parameter(description="변경할 이미지") @RequestParam("ufile") MultipartFile ufile){
		return ResponseEntity.ok(userService.updateProfileImage(userId, ufile));
	}
	
	//탈퇴, 토큰재발급
//	@Operation(summary = "회원탈퇴" , description = "로그인된 사용자 계정을 삭제하고 세션을 만료시킵니다.")
//	@DeleteMapping("/me")
//	public ResponseEntity<UserResponseDto> updateProfileImage (HttpSession session){
//		Long userId = (Long) session.getAttribute("LOGIN_USER_ID");
//		if(userId == null) {return ResponseEntity.status(401).build();}
//		
//		userService.deleteById(userId);
//		session.invalidate();
//		return ResponseEntity.noContent().build();
//	}
    @Operation(summary = "회원 탈퇴")
    @DeleteMapping("/me")
    public ResponseEntity<Void> deleteMe(HttpServletRequest request,
                                         HttpServletResponse response,
                                         @CookieValue(name = "refreshToken", required = false) String refreshToken) {
        try {
        	//AccessToken 확인
            String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(401).build();
            }  
            String accessToken = authHeader.substring(7); // (Bearer )뺴고 추출
            var claims = jwtProvider.parse(accessToken).getBody();
            String userId = claims.getSubject();
            // 해당유저삭제
            userService.deleteById(Long.valueOf(userId));
            // refreshToken 삭제
            if (refreshToken != null) {
                tokenStore.deleteRefreshToken(userId);
            }
            //쿠키삭제
            ResponseCookie deleteCookie = ResponseCookie.from("refreshToken", "")
                    .httpOnly(true)
                    .secure(true)
                    .sameSite("Strict")
                    .path("/")
                    .maxAge(0)
                    .build();
            response.addHeader(HttpHeaders.SET_COOKIE, deleteCookie.toString());

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }
   

    @Operation(summary = "Access Token 재발급")
    @PostMapping("/refresh")
    public ResponseEntity<Map<String, Object>> refresh(@CookieValue("refreshToken") String refreshToken) {
        var claims = jwtProvider.parse(refreshToken).getBody();
        String userId = claims.getSubject();

        String stored = tokenStore.getRefreshToken(userId);
        if (stored == null || !stored.equals(refreshToken)) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid refresh token"));
        }

        String role = userService.findRoleByUserId(Long.valueOf(userId));

        String newAccessToken = jwtProvider.createAccessToken(
                userId,
                Map.of("role", role)
        );

        return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
    }
	
}
