### ■4. springboot + 소셜

064 이어서..

# 소셜로그인
com.the703.oauth2 
- Oauth2UserService

```
@Service
public class Oauth2UserService extends DefaultOAuth2UserService{
	//alt + shift + (override) -> loadUser
	
	
}
```
- SecurityConfig 수정
  // outh2 - social 부분
  ```
    .oauth2Login(oauth2 -> oauth2
            .loginPage("/users/login")
            .defaultSuccessUrl("/users/mypage", true)
            .userInfoEndpoint(userinfo -> userinfo.userService(oauth2UserService)) // 소셜에서 로그인하면 값 여기다 넘겨줄게
            )
  ```
    - 필요페이지 만들기
        src/main/resources
        - application-oauth.properties
        /static (정적소스/파일)
        - css , images
        
    -application.properties 내용추가

    ```
    ###################################
    ###         OAUTH             ###
    ###################################
    # application-oauth.properties
    spring.profiles.include=oauth

    ```

    - login.html
      - 소셜 버튼 추가

    - 네이버개발자사이트
        api 설정/개요설정
            api 설정 -> 네이버 로그인 Callback URL
             -> http://localhost:8080/login/oauth2/code/naver (application-oauth.properties) 에 있음
        application-oauth.properties 
            - client id , Client Secret  붙여넣기
    - 카카오개발자사이트
        - 앱 - 일반 - 이메일
        - 대시보드 - 비즈 앱 나오는지확인
        - application-oauth.properties 
            - REST API 키 붙여넣기

        - REST API 클릭 - 붙여넣기
            카카오 로그인 리다이렉트 URI 아래 붙여넣기
            - application-oauth.properties 아래 정보있음
            redirect-uri=http://localhost:8080/login/oauth2/code/kakao

            - 클라이언트 시크릿
                카카오 로그인 코드 복사
                - application-oauth.properties
                client-secret 붙여넣기

            

            - 카카오로그인 - 일반 - 활성화
                          - 동의항목 - 닉네임 프로필 사진 카카오계정(이메일) 설정 필수동의
                          - 고급 - 로그아웃 리다이렉트 URI 등록 (logout-url=http://localhost:8080/kakaologout)

            - 구글 - cookmap - 새 프로젝트 - 프로젝트이름설정 - 만들기
                - api 서비스 - 사용자인증정보 - 사용자인증정보만들기 - oauth 클라이언트 id 만들기 - 동의 화면 구성 - 시작하기 -> 입력 -> 다음 -> 외부 -> 다음 -> 연락처정보입력 -> 다음 -> 완료
                
            - 승인된 리디렉션 URI 붙혀넣기
                - redirect-uri=http://localhost:8080/login/oauth2/code/google - 만들기
                -  클라이언트 ID , 보안 비밀번호 application-oauth.properties 붙혀넣기
                
            - 대상
                - 테스트 사용자 - add users 등록


api 상담 , db추가 -> erd
구글시트 진행사항 체크

                