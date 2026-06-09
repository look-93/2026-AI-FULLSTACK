1. SPRING?

---

## #1. SPRING?

▶ Step0. jsp

1. mvc1 - jsp( controller )역할
2. mvc2 - servlet( controller )역할

예) JSP = html + java → web

▶ Step1. framework

1. framework [ 디자인패턴 + 라이브러리 = 프레임워크 ]
2. 소프트웨어 개발의 뼈대역할

---

## #2. DI

▶ Step2. ioc + di

1. ioc

- inversion of control
- 제어의 역전
- 인스턴스의 생성~소멸까지 생명주기를 개발자가 아니라 컨테이너가 하는 것
- pojo ( plain old java object)

class A{}
A a1 = new A()

생성 → 초기화 → 서비스 → 소멸
↑ ↓

---

ioc가 아닌경우 - [ 개발자★ → ( Class A)
→ ( Class B)
→ ( Class C) ] 컨테이너

<!-- 개발자가 new 안해도됨 -->

ioc인 경우 - [ 개발자 ← ( Class A)
← ( Class B)
← ( Class C)★ ] 컨테이너

2. di ( dependency injection : 의존성주입 )

- 각 클래스간의 의존관계를 [설정파일]을 통해 [컨테이너]가 자동으로 연결
  장점 : 코드단순화 / 결합도 제거

---

## #3. Bean

1.  xml vs Annotation
    > > xml : 운영
    > > Annotation : 개발
    > > XML - [운영] , 모든 Bean을 명시적으로 xml에 등록
        - 여러개발자가 같은 설정파일을 공유해서 개발하면
          수정시 충돌이 일어날 경우가 많음.

2.@Component

- @Component 일반적인 컴포넌트 <bean> 스프링이 관리하는 객체
- @Component 구체화된 형식
  @Controller 웹요청받아서 응답
  @Service 서비스 레이어, 비즈니스 로직
  @Repository 데이터베이스

3. Bean 의존관계주입
   1. @Autowired - 정밀한 의존관계
      - 프로퍼티, setter, 생성자,, 적용
   2. @Qualifier - 동일한타입의 bean 구분
   3. @Value 단순값
   4. @Resource - 자원연결( .properties)

4. component-scan
   <context:component-scan base-package="경로설정"/>

---

## #4. DB + Mybatis

1. DataSource

- SimpleDrdiverDataSource - 가장단순한버젼

2. mybatis

- sql을 별도로 파일분리해서 관리
- orm (object relational mapping) 프레임워크

3. 설정내용
   root-context.xml 환경정보설정
   db.propertis db정보설정
   SqlSessionFacotryBean : SqlSession 생성 및 관리
   SqlSession : sql 실행 , 트랜잭션
   mapper.xml

```
	<dependencies>
	<!-- TEST Unit -->
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>

		<!-- spring di, context-info 어떤정보를 가지고있어라고 알려주는 -->
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.3.27.RELEASE</version>
		</dependency>

        <!-- spring test - spring 로딩시켜주세요 , 테스트 툴 들어가있음-->
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>4.3.27.RELEASE</version>
			<scope>test</scope>
		</dependency>

		<!-- LOMBOK : getters/setters, constructor, toString -->
		<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.18</version>
			<scope>provided</scope>
		</dependency>


		<!-- MYSQL/ORACLE <dependency> <groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc11</artifactId> <version>21.9.0.0</version> </dependency> -->
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.28</version>
		</dependency>


        <!-- spring-jdbc  -->
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>4.3.20.RELEASE</version>
		</dependency>

        <!-- mybatis - mapper -->
		<!-- MYBATIS -->
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.5.6</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>2.0.6</version>
		</dependency>

        <!-- HikariCP : Connection Pool / jdbc 연동 /
        db연결하는 Connection을 여러개 만들어놓고 꺼내쓴 후에 다쓰면 반납/ 원래는 conn.close()를 안해도됨-->
		<!-- HikariCP -->
		<!-- https://mvnrepository.com/artifact/com.zaxxer/HikariCP -->
		<dependency>
			<groupId>com.zaxxer</groupId>
			<artifactId>HikariCP</artifactId>
			<version>2.7.4</version>
		</dependency>

        <!-- sql query : sql이 화면상에 어떻게 들어가있는지 확인하는 도구 -->
		<!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4 -->
		<dependency>
			<groupId>org.bgee.log4jdbc-log4j2</groupId>
			<artifactId>log4jdbc-log4j2-jdbc4</artifactId>
			<version>1.16</version>
		</dependency>

	</dependencies>


```
------------------
# 5.   MVC
------------------
▶STEP1. MVC
>> 서로 영향없이 쉽게 고칠수 있는 애플리케이션을 만들수 있음.
- MODEL   데이터 ( dto, dao, service )
- VIEW      화면   ( html, css, js/jquery)
- Controller 비지니스로직

▶STEP2. MVC1  vs  MVC2
1. MVC1 -   Controller 의 역할 jsp 담당
2. MVC2 -   Controller 의 역할 servlet 담당

▶STEP3. SPRING MVC
--------FrontController
            /list.do              BList           /board/list.jsp
[클라이언트] → [FrontController]  → 세부Controller → View
                              → 세부Controller → View
                              → 세부Controller → View
1. FrontController  공통작업수행
2. 세부Controller  View에 최종결과 생성
   
--------SPRING MVC
[클라이언트] 
↓  ① /list.do
 [FrontController] 
            <<DispatcherServlet>>  ② Handler Mapping   @Controller
                        ↓ 위임      
                     ★③세부Controller   
                                  ← ④ 
                         ⑥↑↓ ⑤   
                          View
① 클라이언트 요청  ( 코요테/ web.xml 
             - spring관련: root-context.xml,servlet-context.xml )
② DispatcherServlet - Handler Mapping을 사용해서 처리할 Controller확인
③ 세부Controller  클라이언트 요청처리 ( service - 비지니스로직 )
④ 요청결과와 View정보를 DispatcherServlet에게 줌
⑤ DispatcherServlet는 ViewResolver로 부터 응답결과를 생성할 View객체 생성
⑥ View 응답생성 - response


------------------
# 6.security
------------------
▶ 1. Security?
 - 애플리케이션의 보안(인증, 인가)을 담당
 - Filter의 흐름에 따라 처리

▶ 2. 인증  VS  인가
 - 인증  Authentication - [본인]이 맞는지 확인
 - 인가  Authorization  - 인증된사용자가 [접근가능]

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

-------------------------------------





# jar 파일 다운후(dependence) db연동 xml 설정파일 (보통 한번 설정하면 변경x)

- 드라이버연동

1. src/main/java ctrl+n -> spring
2. spring bean configuration file
3. root-context.xml -> next
   -> beans (관리하는객체이런거야)
   -> context()
   -> jdbc(db연동)
   -> mybatis-spring
   (설정잘못했다 ? -> 하단 namespaces에 다시 설정가능)

# db.properties

1. src/main/java/config + ctrl+n -> file
   -> filename(db.properties)

```
#db.driverClass=oracle.jdbc.driver.OracleDriver
#db.url=jdbc:oracle:thin:@localhost:1521:xe
#db.username=scott
#db.password=tiger

db.driverClass=com.mysql.cj.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/mbasic
db.username=root
db.password=1234
```

# Test file

1. src/test/java ctrl+n -> class
2. ModelTest001

<!--이러이러한 거 있으니까 spring 아 너가 생명주기 관리해서 나한테 보여줘 하는 친구들-->

@RunWith(SpringJUnit4ClassRunner.class) // 1. spring 구동
@ContextConfiguration(locations ="classpath:config/root-context.xml") // 2. 설정파일
public class test{

@Autowired ApplicationContext context; // 3. Been (스프링이 관리하는 객체)생성~소멸
@Autowired DataSource dataSource; //import javax.sql.DataSource;

}

```
ex)
	//부품단위로 테스트

	@Ignore //이거무시해 //@Test
	public void test1() {
		System.out.println(context);
	}

	@Test
	public void test2() {
		System.out.println(dataSource);
	}

```

# de셋팅

1. SqlSessionFactoryBeen : 스프링에서 SqlSession 객체들을 생성 및 관리
   - private Resource configLocation; - 설정파일
   - private Resource[] mapperLocations; - mapper.xml (sql 구문파일)
   - private DataSource dataSource; - db연동

2. SqlSesstionTemplate : sql 구문처리(crud)

- mybatis 설정
  https://mybatis.org/mybatis-3/ko/index.html

mybatis? -db <-마이바티스-> 스프링 중간에서 연결해주는놈

- template 만들기
  window -> preferences -> XML Files > Editor > Templates
  -> new - Context : New XML : #1/#2 각각 붙여놓고 -> ok -> close

- #1 mybatis-config

```

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

</configuration>

```

- #2 mybatis-mapper

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.mybatis.example.BlogMapper"> <!-- org.mybatis.example.BlogMapper 지우기 -->
  <select id="selectBlog" resultType="Blog">
    select * from Blog where id = #{id}
  </select>
</mapper>

```

- #3 템플릿 사용 최종 파일 만들기
  mybatis-config.xml /test.mapper.xml / userinfo.mapper.xml

```
config - ctrl+n ->XML file -> next -> mybatis-config.xml
->next -> create file from a template -> 내가만들 템플릿 선택 (mybatis-config.xml/ mybatis-mapper.xml)
```

- #4 연결 test

```
	@Test
	public void test3() {
		System.out.println(sqlSession);
	}

```

# 테이블 만들기, crud

- day045_spring_dbtest.sql 참고

# userinfo.mapper.xml 작성

# root-context.xml

- MapperScannerConfigurer 추가

Mapper 인터페이스가 있을 때 하나씩

```
<bean id="userMapper"
      class="org.mybatis.spring.mapper.MapperFactoryBean">
    <property name="mapperInterface"
              value="com.test.mapper.UserMapper"/>
    <property name="sqlSessionFactory"
              ref="sqlSessionFactory"/>
</bean>
```

bean 을 등록해야 하는 것을

```
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage"
              value="com.test.mapper"/>
</bean>
```

만 쓰면 자동으로 bean에 등록됨

# test

```
@Autowired TestMapper test;
@Test
public void test4() {
    System.out.println(test.now());
}
```

# com.the703.dto > UserInfoMapper.java

- @Data 객체 셋팅

# userinfo.mapper.xml

- UserInfoMapper.java 보고 id parameterType resultType 맞추기
- 리턴값:resultType,메서드명:id,파라미터:parameterType

# test

```
@Autowired UserInfoDto userinfo;

	@Test
	public void test6() {
		// 5.삭제
		System.out.println(userInfo.delete(2));

		// 4.수정
//		UserInfoDto dto = new UserInfoDto();
//		dto.setEmail("hello@gmail.com");
//		dto.setAge(40);
//		dto.setNo(2);
//		System.out.println(userInfo.update(dto));

		// 3.한명검색
		//System.out.println(userInfo.select(2));

		// 2.삽입
		//UserInfoDto dto = new UserInfoDto(); dto.setEmail("hi@gamil.com");
		//dto.setAge(10); System.out.println(userInfo.insert(dto));

		// 1. 전체검색
		//System.out.println(userInfo.selectAll());
	}


```

# ▶ Step3. 실습

# 실습(1) 설치

- 버젼다운그레이드 0. java.sun.com - java11 / build path
  JAVA_HOME C:\Program Files\Java\jdk-11
  path %JAVA_HOME%\bin - 맨위로
  1. 스프링 3버젼 다운로드
  2. 다운로드 경로
     https://github.com/spring-attic/toolsuite-distribution/wiki/Spring-Tool-Suite-3
     - 다운로드
       Latest STS3 Downloads ->
       Spring Tool Suite 3.9.18 ->
       full distribution on Eclipse 4.21
       https://download.springsource.com/release/STS/3.9.18.RELEASE/dist/e4.21/spring-tool-suite-3.9.18.RELEASE-e4.21.0-win32-x86_64.zip
       STS.exe 있는지 확인 -> 더블클릭 -> 실행

  3. 압축 - 경로짧게 / 공백, 한글,특수기호(-) 경로에있으면 빼기
  <!-- 압축푸는 경로 짧게하기, d드라이브나 c드라이브에하기-->

4.  프로젝트 우클릭-> configure -> maven -> 설정하면 project 하면 jar파일 자동 다운

5.  add Spring project Nature
    - "이 프로젝트는 일반 Java 프로젝트가 아니라 Spring 프로젝트야" 라고 알려주는 기능이야.
    - 추가하면 Eclipse가 Spring 관련 기능을 활성화

    ***

    ex
    applicationContext.xml 자동 인식
    Spring Bean 연결 관계 분석
    Spring 설정 파일 자동 완성
    Spring 전용 아이콘 표시
    Bean 참조 오류 검사

    ***

6.  pom.xml (packaging 와 build 태그 사이 붙여넣기)

```
   <dependencies>
   <!-- https://mvnrepository.com/artifact/junit/junit -->
   <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.12</version>
       <scope>test</scope>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context</artifactId>
       <version>4.3.27.RELEASE</version>
   </dependency>
   <!-- https://mvnrepository.com/artifact/org.springframework/spring-test -->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-test</artifactId>
       <version>4.3.27.RELEASE</version>
       <scope>test</scope>
   </dependency>

   <!-- LOMBOK  -->
   <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <version>1.18.18</version>
       <scope>provided</scope>
   </dependency>
   </dependencies>

```

5. 프로젝트우클릭 -> build path -> configure build path -> classpath -> add library -> junit -> junit4 : test 파일 생성

 <!-- error -->

java버전 확인
프로젝트 우클릭
java compiler 11로 되어있음 됨,
java build path -> modulepath -> jre 버전확인
project facets -> java 버전 11

서버설정 tomcat 아니면 delete
tomcat9.0으로 설정

===================
실습(2) spring setting 구조셋팅
=================== 1. dynamic web project - spring001 2. configure - [Convert to Maven Project] 3. spring - add Spring project Nature 4. java se-11 / project facts, build path 5. build path - add Libraries - JUnit 4

    구조확인

1.  pom.xml 설치 다운로드 2. src/main/java 실제 자바파일들 위치 3. src/test/java 실제 테스트파일위치 4. src/main/webapp jsp 파일들위치

연습문제) ex1 프로젝트만들기

===================
실습(3) SPRING 정리
===================

1.  프레임워크

- 소프트웨어개발의 뼈대역할 [디자인패턴 + 라이브러리]

2.  IOC

- 인스턴스 생성~소멸까지 생명주기를 스프링이 관리
<!-- 스프링이 알아서 개발자한테 객체생성해줌 -->

3.  DI

- 각클래스의 의존관계를 [설정파일]을 통해서 컨테이너가 자동연결

4.  BEAN

- 스프링이 관리하는 객체(부품)
- beanFactory ← ApplicationContext

[AnimalFarm] (사용)→ [<<interface>>Animal]  
 ↑(삽입) ↑(구현) ↑ (구현)

[beans.xml ] (생성)→ [Cat / Dog]

> > di? 각클래스의 의존관계를 [설정파일]을통해서 컨테이너가 자동연결

  <!-- 부품객체의 연관관계를 알기위해서 설정파일(xml 로되어있는 )부터 확인 -->

  <!-- 고전적문제 확인!! spring spring-boot 똑같은 문제
      @Data  : ctrl + shift + o
      lombok 동작되는지 확인해야함 getter/setter 등 안생김  
      내 프레임워크에 맞는 버전 써야함
      롬북 수동설치
  -->

- 롬북 설정안될 시 롬북 재설치
  https://projectlombok.org/download

1. 버전에 맞게 다운로드 - all-versions - lombok-1.18.18.jar
2. 경로짧게 - c드라이브로 이동
3. cmd
   c드라이브 경로이동

   ```
   java - jar lombok-1.18.18.jar
   ```

4. sts 설치 위치 - 이클립스 선택 - install

- 재부팅
- @Data import 했을때, getter/setter, hasgCode() 등생성되면 완료

- 관계연결해조 src/ ctrl+n

1. spring bean conriguration file
2. spring001_di/src/main/java/'config' 컨피그폴더에
3. file name
4. beans / context 체크
5. beans1.xml

```
<!-- Cat    cat   = new Cat() -->
<bean   id="cat"  class="com.the703.di1.Cat" />
```

테스트?
src/text/java 경로에서
junit으로 기능단위로 테스트했음

## #5. 예시)

@Data
class MyA{
private String name;
private Animal ani;

public MyA(String name, Animal ani){
this.name = name;
this.ani = ani;
}
}

---

1. setter 방식
   <bean  id="myA"  class="com.company.MyA">
   <property name="name"   value="sally"/>
   <property name="ani"    ref=""/>
   </bean>

2. 생성자
   <bean  id="myA"  class="com.company.MyA">
   <constructor-arg   index="0"   value="sally"/>
   <constructor-arg   index="1"   ref="ani"/>
   </bean>

3. di-properties
   name=sally
   ani=cat
   <context:property-placeholder location="classpath:config/test.properties"/>

<bean  id="myA"  class="com.company.MyA">
   <constructor-arg   index="0"   value="${name}"/>
   <constructor-arg   index="1"   ref="${ani}"/>
</bean>

6. di 연습문제)

1. 구성확인
   코드
   [IceCreamShop] (사용) → [<<interface>> IceCream]  
    ↑(삽입) ↑(구현) ↑(구현)  
    [beans.xml] (생성) → [Vanilla / Chocolate]

> > di? 각 클래스의 의존관계를 [설정파일]을 통해 컨테이너가 자동연결

1. 인터페이스
   com.company.ioctest

public interface IceCream {
public String flavor();
public String scoop();
public String melt();
} 2) 구현클래스
com.company.ioctest

public class Vanilla implements IceCream {
@Override public String flavor() { return "Vanilla-flavor"; }
@Override public String scoop() { return "Vanilla-scoop"; }
@Override public String melt() { return "Vanilla-melt"; }
}

public class Chocolate implements IceCream {
@Override public String flavor() { return "Chocolate-flavor"; }
@Override public String scoop() { return "Chocolate-scoop"; }
@Override public String melt() { return "Chocolate-melt"; }
}

3. 사용클래스 - IceCreamShop

package com.company.ioc;

public class IceCreamShop {
private String shopName;
private IceCream iceCream;

    public IceCreamShop() { super(); }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public IceCream getIceCream() { return iceCream; }
    public void setIceCream(IceCream iceCream) { this.iceCream = iceCream; }

    public String serveFlavor() { return shopName + ">" + iceCream.flavor(); }
    public String serveScoop()  { return shopName + ">" + iceCream.scoop(); }
    public String serveMelt()   { return shopName + ">" + iceCream.melt(); }

    public void print() {
        System.out.println(serveFlavor());
        System.out.println(serveScoop());
        System.out.println(serveMelt());
    }

}

QUESTION1) DI - property 를 이용하여 셋팅하고 JUnit Test를 하시오
--1-1 com.company.test1 [IceCreamShop, Vanilla, Chocolate]

public class IceCreamShop {
private String shopName;
private IceCream1 iceCream;
}

--1-2 com.company.config [test1.xml]

<!-- Vanilla vanilla = new Vanilla() -->
<!-- Chocolate chocolate = new Chocolate() -->

<!-- IceCreamShop shop = new IceCreamShop()
     shop.setShopName("SweetHouse");
     shop.setIceCream(vanilla);
-->

// JUnit Test  
public void test1() {
IceCreamShop shop = (IceCreamShop) context.getBean("iceCreamShop");
shop.print();
}

QUESTION2) DI - component-scan, properties 를 이용해서 셋팅하고 JUnit Test를 하시오
-- 1-1 com.company.config[test2.xml]
<context:component-scan base-package="com.company.ioc2"/>
<context:property-placeholder location="classpath:shop.properties"/>

-- 1-2 com.company.test1 [IceCreamShop, Vanilla, Chocolate]
public void test1() {
IceCreamShop shop = (IceCreamShop) context.getBean("iceCreamShop");
shop.print();
}

===================
실습 2026-06-02
===================

> 실습

1. project 만들기
   1. dynamic web project - ex02
   2. configure - [Convert to Maven Project]
   3. spring - add Spring project Nature
   4. java se-11 / project facts, build path
   5. build path - add Libraries - JUnit 4
2. pom.xml 에 jar 파일 다운로드 받기

3. root-context 에 내용설정
   1. DataSource
   - DB 연결 정보 설정
   - URL, Username, Password, DriverClassName 등
   2. Mybatis
   - MyBatis 설정 파일(mybatis-config.xml) 및 Mapper XML 등록
   - MyBatis가 SQL을 실행할 수 있도록 설정
   3. Mapper
   - DAO 인터페이스(Mapper)를 스프링 빈으로 등록
   - Mapper 인터페이스 ↔ Mapper XML 연결
4. 각종 설정파일들설정
   com.the703.dao - @Mapper
   com.the703.dto  
   config  
    ㄴ db.properties
   ㄴ mybatis-config.xml
   ㄴ test-mapper.xml
   ㄴ board-mapper.xml
5. 테스트파일설정

6. test-mapper.xml
   select now()

7. mvcboard
   mysql> desc mvcboard2;
   +----------+---------------+------+-----+-------------------+-------------------+
   | Field | Type | Null | Key | Default | Extra |
   +----------+---------------+------+-----+-------------------+-------------------+
   | bno | int | NO | PRI | NULL | auto_increment |
   | bname | varchar(20) | NO | | NULL | |
   | bpass | varchar(50) | NO | | NULL | |
   | btitle | varchar(1000) | NO | | NULL | |
   | bcontent | text | NO | | NULL | |
   | bdate | timestamp | NO | | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
   | bhit | int | NO | | 0 | |
   | bip | varchar(50) | NO | | NULL | |
   +----------+---------------+------+-----+-------------------+-------------------+
   8 rows in set (0.00 sec)

mysql>



===================
실습 2026-06-04 [실습]
===================
1) view.zip 다운로드
2) servlet-context.xml 확인 - /view/폴더안에 압축풀기
3) com.the703.controller

■RequestMapping 경로        ■view 경로
/board/list.do             /view/board/list.jsp 
/board/write.do           /view/board/write.jsp    (글쓰기폼)
/board/detail.do          /view/board/detailjsp    (상세보기)
/board/edit.do            /view/board/edit.jsp     (수정하기폼)
/board/delete.do          /view/board/delete.jsp   (삭제하기폼)

* 프로젝트 시
/view/board/list.jsp  -> /moit/login/login.jsp
