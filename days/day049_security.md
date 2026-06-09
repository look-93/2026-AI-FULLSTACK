### ■1. 복습문제 - 노트 준비 ~09:40



### ■2. mysql



### ■3. spring

# user 실습
- spring003_mvc 안전한 복사해서 ex3만들기
    * 복사해서 만든 프로젝트는 아래 진행
    - properties -> web project setting -> context root -> ex3
    - pom.xml 수정
        ```
        <groupId>ex3</groupId>
        <artifactId>ex3</artifactId>
        ```
    - web.xml 수정
        ```
        <display-name>ex3</display-name>
        ```
- users 테이블 만들기
```
 create table users(
 uno int not null primary key auto_increment,
 nickname varchar(20) not null,
 bpass varchar(50) not null,
 email varchar(100) not null,
 mobile varchar(50) not null,
 udate  timestamp  not null default  CURRENT_TIMESTAMP,
 bip varchar(50 )not null
 );

```

- model 
    1) Dto - UserDto user-mapper.xml
    2) Dao - join / login/ mypage / 아이디 중복검사 (해당sql 찾기)
    3) Service 테스트
    4) user 완료하기

# security
▶ 1. Security?
 - 애플리케이션의 보안(인증, 인가)을 담당
 - Filter의 흐름에 따라 처리

▶ 2. 인증  VS  인가
 - 인증  Authentication - [본인]이 맞는지 확인      : 여권갖고 비행기탑승, 로그인
 - 인가  Authorization  - 인증된사용자가 [접근가능] : 승객은 조종실 접근불가

▶ 3. Security 아키텍쳐

=====================
       ② [UsernamePasswordAuthentication Token]
          ↓
① Http Request  →     [AuthenticationFilter] ③ ...  →  [Authentication  Manager]
         ↓⑩               ⑨     ←
          [SecurityContextHolder]
=====================

-1. 사용자가 로그인 폼태그 시도 (username + password 전달)
-2. UsernamePasswordAuthentication 요청정보  Authentication 를 생성
-3. Authentication 인증처리
★UsernamePasswordAuthentication

-10. 인증 완료가 [사용자정보]   SecurityContextHolder 담기
    - AuthenticationSuccessHandler   를 실행( 성공 )
    - AuthenticationFailureHandler   를 실행( 실패 )

=====================
 [AuthenticationFilter] ③   → [Authentication  Manager] → ④[AuthenticationProvider(s)]
                                            ← ⑨       ↑   ↓⑤   
                     ↑                            [ UserDetailsService ]    
                        ProviderManager                ↑   ↓⑥
                                                 [ UserDetails ]   

=====================
-4. Authentication  Manager  인증담당
★UsernamePasswordAuthentication  Token은 Provider를 찾는데 사용
 
AuthenticationProvider
★ 로그인정보 DB정보와 비교

UserDetailsService
★ DB에 있는 [사용자정보]가져오기

- 순서

1. pom.xml 
```
      <!-- SECURITY -->
      <!-- SECURITY -->
      <!-- SECURITY -->
      <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-core -->
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-web</artifactId>
         <version>4.2.2.RELEASE</version>
         <!-- <version>5.0.7.RELEASE</version> -->
      </dependency>
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-config</artifactId>
         <version>4.2.2.RELEASE</version>
      </dependency>
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-core</artifactId>
         <version>4.2.2.RELEASE</version>
      </dependency>
      <dependency>
         <groupId>org.springframework.security</groupId>
         <artifactId>spring-security-taglibs</artifactId>
         <version>4.2.2.RELEASE</version>
      </dependency>
      <!-- SECURITY -->
      <!-- SECURITY -->
      <!-- SECURITY -->


```

3. security-context.xml 부품셋팅
    - config - ctril+n - spring - Spring Bean Configurarion File -  security-context.xml - bean, context, security
     
```
	<!-- 암호화 -->
	<bean id="passwordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" />
		
	
	<!-- 로그인성공 -->
	<!-- 로그인실패 -->
	<!-- 유저정보 -->

	<!-- Dispatcher가 훔치기 전에 -->
	<security:http>
		<security:intercept-url pattern="/security/all"  access="permitAll" />
		<security:intercept-url pattern="/security/member"  access="hasRole('ROLE_MEMBER')" /> 
		<security:form-login/> <!-- 로그인정보 -->
	</security:http>
	
	<!-- security:authentication-manager provider에 인가 -> provider(db정보비교) -> UserDetailsService (db정보 가져오기)-->
	<security:authentication-manager> <!-- provider에 인가 -->
		<security:authentication-provider> <!-- (db정보비교) -->
			<security:user-service> <!-- (db정보 가져오기) -->
				<security:user name="member" password="{noop}member" authorities="ROLE"/> <!--어디까지 권한이 있나?  ROLE:기본권한-->
			</security:user-service>		
		</security:authentication-provider>	
	</security:authentication-manager>


```
    - http://localhost:8080/ex3/login 로그인페이지 확인하기

2. web.xml 부품낌 (여기까지하고 run하면 오류->security-context.xml 없어서)

- root-context.xml 수정
```
<param-value>classpath:/config/*-context.xml</param-value>
``

- DispatcherServlet가 경로를 훔쳐오기 전에 실행되야함
- Security동작하게 해주세요
```
	<filter>
		<filter-name>springSecurityFilterChain</filter-name>
		<filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	</filter>
	
	<filter-mapping>
		<filter-name>springSecurityFilterChain</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

```
-  view - member -  all.jsp, member.jsp
- BasicController 수정
        ```
            @RequestMapping("/")
            public String index() {
                //구동시작점 - db 컨트롤러 : index.jsp (원래 index.jsp)
                //return "redirect:/board/list.do";
                return "index"; // /view / + index + .jsp
            }
        ```
- webapp - index.jsp

4. SecurityController
```
@Controller
@RequestMapping("/security/*")
public class SecurityController {

		@RequestMapping("/all")
		public String all() {
			return "member/all";
		}
		
		@RequestMapping("/member")
		public String member() {
			return "member/member";
		}
		
		@RequestMapping("/admin")
		public String admin() {
			return "security/admin";
		}
}

```

5. test
- run

6. authorities 테이블만들기
```
create table authorities(
email varchar(50) not null ,
auth  varchar(50) not null 
);
```
    1) insert 구문찾기 first@gmail.com / ROLE_MEMBER
    insert into authorities (email, auth)
    value(#{email}, #{auth})

    2) join 이용해서 first@gmail.com 의  email, bpass, auth 필드값찾기

    select b.*, a.bpass
    from authorities  as a
    left outer join users as b on b.email = a.email
    where a.email = #{email}


7. AuthDto.java 권한하나
   AuthListDto  권한 여러개

8. mybatis-config.xml 추가
```
		<typeAlias type="com.the703.dto.AuthDto"     	alias="AuthDto"/>
		<typeAlias type="com.the703.dto.AuthListDto"	alias="AuthListDto"/>
```
9. user-mapper.xml 추가
    * resultType x -> resultMap

    ``` 권한
  <!-- authorities -->
  <insert id="insertAuto" parameterType="AuthDto" >
  	 insert into  authorities (email, auth) values ( #{email} , #{auth} )
  </insert>  
  <select id="readAuth" resultMap="AuthDto" parameterType="AuthDto">
	  select u.email, u.bpass,  a.auth
	    from users as u 
        left join authorities as a on u.email   = a.email  
	   where u.email =#{email}
  </select>

  <!-- authorities -->

    ```

    ``` 권한들

  <!-- authorities -->
  <insert id="insertAuto" parameterType="AuthDto" >
  	 insert into  authorities (email, auth) values ( #{email} , #{auth} )
  </insert>  
  <select id="LeadAhit" resultMap="authListMap" parameterType="AuthDto">
	  select u.email, u.bpass,  a.auth
	    from users as u 
        left join authorities as a on u.email   = a.email  
	   where u.email =#{email}
  </select>
  <resultMap id="authListMap" type="AppUserAuthDto" > <!-- 권한여러개 -->
  	<result property="email" column="email" />
  	<result property="bpass" column="bpass" />
  	<collection property="authList" resultMap="authMap" />
  </resultMap>
  
  <resultMap id="authMap" type="AuthDto">  
  	<result property="email" column="email" />
  	<result property="auth"  column="auth" />  
  			<!-- dto값 -->    <!-- 테이블컬럼값 -->
  </resultMap>
  
  <!-- authorities -->

    ````

- UserMapper.java 
```
	/*security*/
	public int insertAuth(AuthDto dto);
	public AuthListDto readAuth(AuthDto dto);

```

- dbtest
@ContextConfiguration(locations = "classpath:config/*context.xml")


```

	@Test
	public void test2() throws UnknownHostException {
		
		/*회원가입 (비밀번호암호화) pwencoder.encode()*/
		UserDto dto = new UserDto();
		dto.setNickname("1"); dto.setBpass(pwencoder.encode("a")); dto.setEmail("a@a");
		dto.setMobile("0101111111"); dto.setBip(InetAddress.getLocalHost().getHostAddress());
		 System.out.println(userService.insert(dto));
	}

```


### ■4. 복습문제
