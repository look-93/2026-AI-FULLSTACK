### 1. back

#### [실습] 3. oracle 유저셋팅

```sql
-- cmd
-- sqlplus
-- conn  system/1234
 
-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 사용자 생성 허용 )
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user boot  identified by react;

-- 권한부여
grant  connect , resource  to boot;

ALTER USER boot DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;    -- 물리적공간이용
grant  create table to boot;
```

#### [실습] 4. Boot + React ver1 (기본게시판 + 회원가입)

1. board
- [ ] 1. project
- [ ] 2. 부품객체 : gradle
    ※ https://mvnrepository.com/
- [ ] 3. application.yml
```
spring:
  datasource:
    url: jdbc:oracle:thin:@localhost:1521/XE    # jdbc url
    username: boot                              # 사용자계정 (보안때문에 .env 파일롭 변경)
    password: react                             # 비밀번호   (보안때문에 .env 파일롭 변경)
    driver-class-name: oracle.jdbc.OracleDriver # oracle, mysql,,,

  jpa:
    hibernate:
      ddl-auto: update          # 엔티티 변경사항 db테이블 자동으로 변경사항 반영
                                # update :수정반영, 기존데이터유지 / create-drop : 생성후삭제, 매번초기화
                                # 배포할때는 none (기본), validate
    properties:
      hibernate:
        format_sql: true        # 콘솔 및 로그에 출력되는 sql 들여쓰기 속성
        show_sql: true          # sql 쿼리 문장을 그대로 로그 출력

  servlet:
    multipart:
      enabled: true             # 파일업로드처리 기능 활성화
      max-file-size: 10MB       # 업로드하는 최대허용 용량
      max-request-size: 20MB    # 한번에 전송되는 총 용량

  data:
    redis:
      host: localhost           # redis 연결주소
      port: 6379                # 서버포트
      timeout: 2000             # 서버와 연결 대기시간

  config:
    import: 
      - optional:application-oauth.yml  # api 설정관련
      - optional:file:.env[.properties] # .env 파일 실제 보관키


mybatis:
  config-location: classpath:mybatis-config.xml # 전역설정파일
  mapper-locations: classpath:mapper/**/*.xml   # mapper 경로패턴
  type-aliases-package: com.thejoa703.domain    # 도메인 설정 

jwt:
  issuer: thejoa703                         # jwt 토큰 발행한 주체자
  secret: ${JWT_SECRET}                     # 사용할 비밀키 - 외부환경변수에서 불러와서 설정
  access-token-exp-seconds: 900             # 유효시간
  refresh-token-exp-seconds: 1209600        # 유효시간
  header: Authorization                     # http 토큰 전달시 http 요청헤더 이름 지정
  prefix: Bearer                            # 토큰 앞에 붙는 이름(접두사)

file:
  upload-dir: uploads   # 업로드된 파일설정경로

#server:
#  port: 8484

```

    ※ 기존 : (oracle db:table) → mapper      → dto → service → controller → view
    ※ @Entity                 → repository  → dto → service → controller → view
- [ ] 4. entity (테이블을 객체로 처리)
    back1
        ㄴ src/main/java
            ㄴ com.thejoa703.entity
                - AppUser
                - Post

    A. JPA
        - ORM(Object-Relational Mapping)
        - 부품객체(자바클래스)와 RDB(관계형데이터베이스)의 불일치를 해결하려고
          sql 중심이 아니라 객체중심으로 데이터를 다룰 수 있게 해주는 기술

        - 1. @Entity DB의 테이블과 맵핑
        - 테이블 컬럼 변경시 sql 을 일일히 수정할 필요없이 엔티티클래스만 수정
        - 데이터베이스 방언(Dialect) 지원 - oracle, mysql 특정데이터에 종속

        - 2. @JpaRepository - db에 접속해서 crud 작업을 처리하는 인터페이스
        - 3. 외래키설정
            한사람이 여러글을 쓸 수 있다.

            > AppUser
            @OneToMany
            
            > Post
            @ManyToOne

- [ ] 5. Repository
    back1
        ㄴ src/main/java
            ㄴ com.thejoa703.repository
                - AppUserRepository
                - PostRepository
    https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    - test 하기

- [ ] 6. Dto   
    back1
        ㄴ src/main/java
            ㄴ com.thejoa703.dto
                - UserDto
                - PostDto

- [ ] 7. Service
    back1
        ㄴ src/main/java
            ㄴ com.thejoa703.service
                - UserService
                - PostService

```
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //데이터 저장(insert)시 rollback / 
// readOnly = true -> 변경 감지(Dirty Checking)를 하지 않음 , 성능이 조금 더 좋아짐, 실수로 



데이터를 수정하는 것을 방지
public class UserService {
	private final AppUserRepository appUserRepository;
}
```
7-1. 클래스 명   : UserService (package com.thejoa703.service;)
메서드 명
- createUser (회원가입 / 사용자 등록 기능)
- getUser (사용자 단건 조회 기능)

7-2. 클래스 명   : PostService
- getAllPosts (모든 글)
- getPostById (단건 조회)
- getPostPaged (오라클 네이티브 페이징 조회)
- createPost (게시글 생성)
- updatePost (게시글 수정)
- deletePost (게시글 삭제)

- [ ] 8. Controller
    back1
        ㄴ src/main/java
            ㄴ com.thejoa703.controller
                - UserController
                - PostController

  1. User Api    - 사용자 관련 API
  - POST   /api/users      회원가입
  - GET      /api/users/{id}      사용자 단건조회

  2. Post API     - 게시글 관련 API
  - GET        /api/posts/{id}      게시글 단건 조회
  - PUT        /api/posts/{id}      게시글 수정
  - DELETE   /api/posts/{id}      게시글 삭제
  - GET        /api/posts      전체 게시글 조회
  - POST      /api/posts      게시글 작성

...............................
- [ ] 9. View

1. 회원가입
   ↓
2. 마이페이지
   ↓
3. 글쓰기
   ↓
4. 글수정   
   ↓
5. 글삭제

Step1) 프로젝트만들기
```
mkdir front1
cd .\front1\
npm init
```
Step2) 기본셋팅 (store)
```
package.json 셋팅
npm install
```
Step3) reducer
Step4) saga
Step5) vide

##### [실습]  5.   Boot + React + 세션/쿠키  - ver2  (기본게시판 + 회원가입 + 이미지 / 해쉬태그 / 좋아요 / 팔로우)
※ entity → repository  → service  →  controller 

##### [실습]  6.   Boot + React + jwt+ security + redis  - ver3  (기본게시판 + 회원가입 + 이미지 / 해쉬태그 / 좋아요 / 팔로우 )

2. 회원가입