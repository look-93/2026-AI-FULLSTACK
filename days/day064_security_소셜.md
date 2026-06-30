### ■1. 복습문제 - 노트 준비 ~09:40


### ■2. mysql


### ■3. jsp


### ■4. springboot + security
# local 로그인 
1. header (navbar security 적용)
    - login
    - login.html 에 있는 복사
    ```
    xmlns:sec="http://www.thymeleaf.org/extras/spring-security"
    ``` 
    header.html 에 붙여넣기

    - principal.username
        principal.username은 현재 로그인한 사용자의 아이디(username)를 가져오는 것입니다.
        Spring Security에서는 로그인에 성공하면 사용자 정보를 Principal 객체에 저장합니다.
2. header (navbar security 적용)
    logout
    ```
    <li class="nav-item" sec:authorize="isAuthenticated()"> <!-- li태그에 -->
    <form th:action="@{/users/logout}" method="post">
        <button type="submit" class="nav-link" >LOGOUT</button>
    </form>
    </li>  

    ```
3. join 
4. mypage
    ```
    // 마이페이지
	@GetMapping("/mypage")
	public String mypage(Authentication authentication, Model model) { // authentication -> 사용자정보 가지고있는 principal 가지고있음
		String email = null, provider = null;
		Object principal = authentication.getPrincipal();
		//1. local
        //CustomUserDetails 여기서 파생된거니?
		if(principal instanceof CustomUserDetails) {}
		//2. social
		return "/users/mypage";
	}	

    ```

5. 수정
6. 삭제


# social 로그인
    - pom.xml
    <!-- SOCIAL --> 추가
    ctrl + 스페이스 - add starters
    OAuth2 Client 추가
    pom.xml 클릭 - finish

    ```
    <!-- SOCIAL -->		
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-client</artifactId>
    </dependency>
    ```
    추가
    ```		
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
    </dependency>

    ```

    - 받아오는 값(providerId)
      값이 다르기 떄문에 공통으로 매핑 UserInfoOAuth2 생성 
      - package com.the703.oauth2;
    ```
    1. provider   = "local" / "google" , "kakao" , "naver"
    2. providerId = google → sub , kakao/facebook   → id, naver  → response

    <google>
    {
    sub=103058387739722400130, 
    name=안효정, 
    given_name=효정, 
    family_name=안, 
    picture=https://lh3.googleusercontent.com/a/AEdFTp5SiCyTaOLog9sDPN6QhWwsUj7xPbfj4HQF0fdC=s96-c, 
    email=sally03915@gmail.com, 
    email_verified=true, 
    locale=ko
    }

    <kakao>
    {
        id=2632890179, 
        connected_at=2023-01-22T08:17:54Z, 
        properties = {nickname=효정}, 
        kakao_account = {
            profile_nickname_needs_agreement=false, 
            profile={nickname=효정}, 
            has_email=true, 
            email_needs_agreement=false, 
            is_email_valid=true, 
            is_email_verified=true, 
            email=sally03915@naver.com
        }
    }

    <naver>
    {
        resultcode=00, 
        message=success, 
        response = {
            id=pvdq1FSG3VZlD7Cp3JuWfAFi-3xir6A-WPlP5f8kXIo, 
            email=sally03915@naver.com, 
            name=안효정
        }
    }
    ```
    - google , kakao, naver 각각 작성
    UserGoogle.java
    
    - CustomUserDetails.java 
        - implements OAuth2User 추가


1. Oauth2UserService
2. SecurityConfig - 설정
3. Controller + view

------ 
4)  naver    ( 네아로 - 연습용 )   → id/비번
5)  kakao   
6)  google  ( 도메인 , https )

https://developers.naver.com/main/
https://developers.kakao.com/
https://console.cloud.google.com/

................
■1. - 확장기능 - 새로운기능추가
    - crud - oo 기능 확장 →  확장기능 / 업그레이드 기능 체크  (기존에 놓친기능 포함)
■2. api 아이디어 (2~3개)
................
1. 프로젝트올리고
2. pr 시간 팀체크 - 1일1커밋
................

### ■5. 복습문제
