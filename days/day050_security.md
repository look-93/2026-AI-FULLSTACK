### ■1. 복습문제 - 노트 준비 ~09:40



### ■2. mysql



### ■3. spring
1. 인증성공
    LoginSuccessHandler.java
    - com.the703.security
 ```
public class LoginSuccessHandler implements AuthenticationSuccessHandler{ // ## 인증(누구)

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//## 인가(접근,허용)
		
	}

}

 ```
2. 인증실패
    - AccessDeniedHandler.java

```
public class DeniedHandler  implements AccessDeniedHandler{

   @Override
   public void handle(HttpServletRequest request, HttpServletResponse response,
         AccessDeniedException accessDeniedException) throws IOException, ServletException { 
      
   }

}


```

3. 유저 정보 주는 클래스
```
@Getter
public class CustomUser extends User{

	private static final long serialVersionUID = 8898560806394691845L;
	AuthListDto dto;
	
	//2. 유저아이디와 비밀번호를 받아서 권한이 있는지 체크
	public CustomUser(String username, 
					  String password, 
					  Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	//1. 유저이메일(유저아이디)과 비밀번호를 받아서 권한이 다른경우 맞게 셋팅
	public CustomUser(AuthListDto dto) { //해당데이터 받아서 위쪽CustomUser 로 맞게 셋팅
		super(dto.getEmail(), // db상 email bpass 를 dto 를 가져와서 
			  dto.getBpass(), 
			  dto.getAuthList()
			  .stream()
			  .map(auth->new SimpleGrantedAuthority(auth.getAuth()))
			  .collect(Collectors.toList()) 
			 );
		
		this.dto = dto; // dto에 꽂아줌
	}	
}

```

4. 

```
public class CustonUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

}

```
5. security-context.xml에 부품추가
```
	<!-- 로그인성공 -->
	<bean id="successHandler" class="com.the703.security.LoginSuccessHandler" />
	<!-- 로그인실패 -->
	<bean id="deniedHandler" class="com.the703.security.DeniedHandler" />
	<!-- 유저정보 --> <!-- 유저정보받아서 셋팅해줄거데 아이디비번 다를경우 실제db와 다를경우 셋팅 -->
	<bean id="custonUserDetailsService" class="com.the703.security.CustonUserDetailsService" /> <!-- 실제db정보 가져오는 -->

```

    - authentication-manager 수정
```
    <!-- ver-2 authentication-manager-->
	<security:authentication-manager>
		<security:authentication-provider user-service-ref="custonUserDetailsService">
			<security:password-encoder ref="passwordEncoder" /> <!-- 암호화된 비밀번호 -->
		</security:authentication-provider>
	</security:authentication-manager>


```

6. UserService.java 추가
	/* security login*/
	public AuthListDto readAuth();

    UserServiceImple.java
    ````
	@Override
	public AuthListDto readAuth(AuthDto dto) {
		return dao.readAuth(dto);
	}
    ```
    imsert 
    ```
    	AuthDto adto = new AuthDto();
		adto.setEmail(adto.getEmail());
		adto.setAuth("ROLE_MEMBER");
		dao.insertAuth(adto); // 권한추가

    ```
7. modeltest2
```
	@Test
	public void test3() {
		AuthDto dto2 = new AuthDto();
		dto2.setEmail("a@a");
		System.out.println(userService.readAuth(dto2));
	}

```


8. CustonUserDetailsService.java 설정
    ```
public class CustonUserDetailsService implements UserDetailsService{

	@Autowired UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//우리는 유저네임아니고 이메일
		
		AuthDto adto = new AuthDto(); adto.setEmail(username); 
		AuthListDto dto = userService.readAuth(adto);		
		return dto == null? null: new CustomUser(dto);
	}

}
    ```

9. LoginSuccessHandler.java 설정

    ```
    public class LoginSuccessHandler implements AuthenticationSuccessHandler{ // ## 인증(누구)

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                Authentication authentication) throws IOException, ServletException {
            
            //## 인가(접근,허용)
            List<String> roles = new ArrayList<>();
            authentication.getAuthorities().forEach(auth -> {
                roles.add(auth.getAuthority());
            });
            
            //각각의 유저처리
            // 각 유저의 권한을 확인해서 접근할 수 있는 페이지로 이동 
            // ex) if(roles.contains("ROLE_ADMIN")){ response.sendRedirect(request.getContextPath() + "/security/admin");	 }
            
            response.sendRedirect(request.getContextPath() + "/security/mypage");		
        }

    }

    ```
10. DeniedHandler.java 설정

```
public class DeniedHandler  implements AccessDeniedHandler{

   @Override
   public void handle(HttpServletRequest request, HttpServletResponse response,
         AccessDeniedException accessDeniedException) throws IOException, ServletException { 
	   
       //로그인실패시 알림창 띄우거나 해도됨
	   response.sendRedirect(request.getContextPath() + "/security/login");	
      
   }

}


```


11. 여기까지 구동 잘 되는지 구동 테스트 - run
permitall - 전체권한
hasrol(권한있는 사람만 허용)

12. security-context 추가
	<!-- permitAll:모두다접근가능 
		 hasRole('ROLE_MEMBER') : ROLE_MEMBER 권한
		 isAuthenticated() : 인증된사용자(로그인)
         ※ 구체적인 패턴을 위해 , 포괄패턴은 아래
	-->	

```
	<!-- Dispatcher가 훔치기 전에 -->
   <security:http>
      <security:intercept-url  pattern="/board/**"         access="permitAll" />   
      <security:intercept-url  pattern="/security/all"     access="permitAll" />
      <security:intercept-url  pattern="/security/member"  access="hasRole('ROLE_MEMBER')" />
      
      <security:intercept-url  pattern="/security/join"    access="permitAll" />
      <security:intercept-url  pattern="/security/login"   access="permitAll" />   
      <security:intercept-url  pattern="/security/**"      access="isAuthenticated()" />      
      
	  <security:form-login/> <!-- 로그인정보 -->
	  <security:logout/> // 추가
   </security:http>

```


- 로그인페이지를 내가 만든 페이지로
```
		<security:form-login login-page="/security/login" 
							 authentication-success-handler-ref="successHandler"
						     authentication-failure-forward-url="/security/fail"/> <!-- 로그인정보 -->
```
- 로그아웃
```
		<security:logout logout-url="/security/logout"
					     logout-success-url="/security/login"
					     invalidate-session="true"/>

```


14. SecurityController.java

````
@Controller
@RequestMapping("/security/*")
public class SecurityController {

		@RequestMapping("/all")
		public String all() {
			return "security/all";
		}
		
		@RequestMapping("/member")
		public String member() {
			return "security/member";
		}
		
		@RequestMapping("/join")
		public String join() {
			return "security/join";
		}		
		
		@RequestMapping("/login")
		public String login() {
			return "security/login";
		}	
		
		@RequestMapping("/fail")
		public String fail() {
			return "security/fail";
		}	

		// Authentication 그림 9,10번 - Principal(현재 로그인한 사용자정보만 가르쳐좀)
		@RequestMapping("/mypage")
		public String mypage() {
			return "security/mypage";
		}// LoginSuccessHandler.jave에서 사용
		
		//logout 컨트롤러 탈 필요x
}


````


15. view

security 폴더
- login.jsp
```
<div class="container my-5">
  <h3>로그인</h3>
  <!-- 2. Login
	*1) 처리해결사   : login
	 2) 데이터 노출  : post
	*3) 보관데이터   : username , password  
	csrf(Cross-Site Request Forgery) : 사이트간 요청 위조 방지 - 서버가 발급한 토큰을 던져줌 
   -->
  <form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return checkForm()">
   <input  type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" /> <!-- 보안 -->
    <div class="my-3">
      <label for="email" class="form-label">이메일</label>
      <input type="email" class="form-control" id="email" name="username" /> <!-- 주의 name -->
    </div>
    <div class="my-3">
      <label for="bpass" class="form-label">비밀번호</label>
      <input type="password" class="form-control" id="bpass" name="password" /> <!-- 주의 password -->
    </div>
    <div class="text-end">
      <button type="reset" class="btn btn-outline-primary">취소</button>
      <button type="submit" class="btn btn-primary">로그인</button>
    </div>
  </form>
</div> 

- run test
```


- all.jsp
- join.jsp



- member.jsp
- mypage.jsp

16. controller 
마이페이지 컨트롤러 테스트
```
		// Authentication 그림 9,10번 - Principal(현재 로그인한 사용자정보만 가르쳐좀)
		@RequestMapping("/mypage")
		public String mypage(Principal principal, Model model) {
			System.out.println("....." + principal);
			System.out.println("....." + principal.getName()); // username -> email
			model.addAttribute("email", principal.getName());
			return "security/mypage";
		}// LoginSuccessHandler.jave에서 사용


- run trst - 로그인하기

```

17.  원래 마이페이지 mapper가 email만 가져오고있어서 하나 더 만듦
     만들어서 controller에 mypage 매서드에 적용
<!-- email 검색시 해당유저 정보 가져오기 --> 
```

		// Authentication 그림 9,10번 - Principal(현재 로그인한 사용자정보만 가르쳐좀)
		@RequestMapping("/mypage")
		public String mypage(Principal principal, Model model) {
			System.out.println("....." + principal);
			System.out.println("....." + principal.getName()); // username -> email
			//model.addAttribute("email", principal.getName());
			//model.addAttribute("dto", userService.findUser(principal.getName()));
			
			//mapper - email 검색시 해당유저 정보 가져오기
 			Object dto = userService.findUser(principal.getName());

			System.out.println("dto = " + dto);	           
			model.addAttribute("dto", dto);
			return "security/mypage";
		}// LoginSuccessHandler.jave에서 사용
```


18. header.jsp 영역잡기
- 라이브러리추가
```
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 

```

```
<!-- 현재 사용자가 인증된 상태인지 보는 친구 access="isAuthenticated() / 특정권한access="hasRole("ROLE_ADMIN")-->
<sec:authorize access="isAuthenticated()">               
</sec:authorize>
<!-- 로그인 안한상태 -->
<sec:authorize access="isAnonymous()">               
</sec:authorize>


aaccess="isAuthenticated()" : 접근하는친구들
```


```이제 이거 안씀
                
<c:if test="${empty  sessionScope.email}"> // 헤더에 세션기록남기겠다하면 이거 사용
    <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/LoginAction">Login</a>
    </li>
    <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/JoinAction">Join</a>
    </li>
</c:if>

<c:if test="${not empty  sessionScope.email}">
    <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/MyAction">${sessionScope.email}</a>
    </li>

    <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
    </li>
</c:if>

```

```

                <!-- 로그인 안한상태 -->
                <sec:authorize access="isAnonymous()">             
                    <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/security/login">Login</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/security/join">Join</a>
                    </li>

                </sec:authorize>

```
```

                    <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/board/list.do">BPARD</a>
                    </li>

```

```

                <!-- 현재 사용자가 인증된 상태인지 보는 친구 access="isAuthenticated() / 특정권한access="hasRole("ROLE_ADMIN")-->
                <sec:authorize access="isAuthenticated()">     
                    <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/security/mypage">
                    	<sec:authentication property="principal.dto.email"/>
                    </a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/security/logout">logout</a>
                    </li>                          
                </sec:authorize>

```

- 인증된상태에 있던 로그아웃 버튼을 아래처럼 수정
   
```                   -- 아래수정부분
                      <form  action="${pageContext.request.contextPath}/security/logout"   method="post">
                         <input type="hidden"   name="${_csrf.parameterName}"    value="${_csrf.token}"/>
                         <input type="submit"  value="로그아웃"   class="btn btn-danger"/>
                      </form>


                <!--  현재 사용자가 인증된 상태    access="isAuthenticated()" / 특정권한 access="hasRole('ROLE_ADMIN')"  -->
                <sec:authorize  access="isAuthenticated()" >     
                    <li class="nav-item">
                       <a class="nav-link" href="${pageContext.request.contextPath}/security/mypage">
                          <sec:authentication property="principal.dto.email"/>
                       </a>
                    </li> 
                      <form  action="${pageContext.request.contextPath}/security/logout"   method="post">
                         <input type="hidden"   name="${_csrf.parameterName}"    value="${_csrf.token}"/>
                         <input type="submit"  value="로그아웃"   class="btn btn-danger"/>
                      </form>
                </sec:authorize>
```
19. 회원가입도전~(join)
- mapper - service - serviceimpl - controller 

- service

```
	@Override
	public int insert(UserDto dto) {
		AuthDto adto = new AuthDto();
		adto.setEmail(adto.getEmail());
		adto.setAuth("ROLE_MEMBER");
		dao.insertAuth(adto); // 권한추가
		
		try {
			dto.setBip(InetAddress.getLocalHost().getHostAddress());
			dto.setBpass(pwencoder.encode(dto.getBpass()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return dao.insert(dto);
	}

```


- controller
```
		@RequestMapping(value = "/join", method = RequestMethod.POST)
		public String join_post(UserDto dto, RedirectAttributes rttr) {
			
			String result = "실패";
			
			if(userService.insert(dto) > 0) {				
				result ="성공";
			}
			
			rttr.addAttribute("result", result);
			return "redirect:/security/login";
		}	

```

여기까지 하고 run
```
HTTP 상태 403 – 금지됨
타입 상태 보고

메시지 Invalid CSRF Token 'null' was found on the request parameter '_csrf' or header 'X-CSRF-TOKEN'.

설명 서버가 요청을 이해했으나 승인을 거부합니다.


```

- join.jsp csrf 추가


```
<input type="hidden"   name="${_csrf.parameterName}"    value="${_csrf.token}"/>

```


- join.jsp 
이메일 중복검사 fetch - then -then   도전~!
```
		<div class="my-3 alert alert-warning target">아이디 중복검사는 필수입니다.</div>
		<script>
			 window.addEventListener("load", function() {
				let email = document.gerElementById("email");
				let target = document.querySelector(".target");
				
				email.addEventListener("keyup", function(e) {
					//consol.log(e.target.value);
					let value = e.terget.value.trim(); // 공백뺴기
					if(value !== ""){// 빈칸이 아니면 서버에요청
						fetch("/doubleEmail?email=" + encodeURIComponent(value))
						.then(response=>response.json()) // json으로 응답
						.then(data => {
							if(data.exists){								
								target.textContent = "이미 사용중인 이메일입니다.";
								target.className = "my-3 alert alert-danger target";
							}else{// 빈칸이면 메시지유지
				                 target.textContent="사용가능한 이메일입니다.";
				                 target.className ="my-3  alert  alert-warning  target";
							}										
						}).catch(err => {
							target.textContent = "서버오류입니다.";
							target.className = "my-3 alert alert-danger target";							
						});
					}
				});

			});
		</script>

-- 서버오류뜨는지 확인 run
```

20. SearchController.java
``
@Controller
public class SearchController {
	@Autowired UserService userService;
	
	@ResponseBody
	@RequestMapping(value="/doubleEmail", method=RequestMethod.GET)
	public Map<String, Object> doubleEmail( @RequestParam("email") String email){
		
		Map<String, Object> result = new HashMap<>();
		
		//db에서 이메일 존재여부 확인
		String find = userService.findEmail(email);
		if(find != null) {
			result.put("exists", true);
		}else {
			result.put("exists", false);
		}
		return result;
	}
}

주소창 test 
http://localhost:8080/ex3/doubleEmail?email=b@b

{"exists":true} 성공

``
Controller 등록시 context에 등록

21. pom.xml 추가
```
      <!-- jackson -->
      <!-- jackson -->
      <!-- https://mvnrepository.com/artifact/org.codehaus.jackson/jackson-mapper-asl -->
      <!-- <dependency> <groupId>org.codehaus.jackson</groupId> <artifactId>jackson-mapper-asl</artifactId> 
         <version>1.9.13</version> </dependency> -->
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId>
         <version>2.17.2</version> <!-- 최신 안정 버전 사용 -->
      </dependency>
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-core</artifactId>
         <version>2.17.2</version>
      </dependency>
      <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-annotations</artifactId>
         <version>2.17.2</version>
      </dependency>

```

```완성
		<div class="my-3 alert alert-warning target">아이디 중복검사는 필수입니다.</div>
		<script>
        window.addEventListener("load" , function(){
           let email  = document.getElementById("email");
           let target = document.querySelector(".target");
            
           email.addEventListener("keyup" , function(  e ){ //console.log( e.target.value );
              let value = e.target.value.trim();   // 공백빼기
              if(value !== ""){ //빈칸이 아니면 서버에 요청
                 fetch("${pageContext.request.contextPath}/doubleEmail?email=" + encodeURIComponent(value))
                 .then( response=> response.json() )  // json 으로 응답
                 .then( data=>{  
                    if(data.exists){
                       target.textContent="이미 사용중인 이메일입니다.";
                       target.className ="my-3  alert  alert-danger  target";
                    }else{
                       target.textContent="사용가능한 이메일입니다.";
                       target.className ="my-3  alert  alert-success  target";
                    }
                 }).catch(err =>{  
                    target.textContent="서버오류입니다.";
                    target.className ="my-3  alert  alert-info  target";
                 });
              } 
              else{//빈칸이면
                 target.textContent="아이디 중복검사는 필수입니다.";
                 target.className ="my-3  alert  alert-warning  target";
              }  //빈칸이면 메시지 유지
           }); 
        });
   </script>

``

22. security-context
```
<security:intercept-url  pattern="/security/doubleEmail"   access="permitAll" /> 
```

run test

### ■4. 복습문제