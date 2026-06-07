### ■1. 복습문제 - 노트 준비 ~09:40



### ■2. mysql



### ■3. spring
# ex02 - mvcboard2 실습

```
순서
1. dynamic web project
    - 셋팅
2. pom.xml
3. root-context.xml(DataSource/Mybatis/Mapper 설정)
    - mybatis-config.xml
    - db.properties
4. - com.the703.dao 
    - Mapper.java
    ```
    public @interface Mapper {}
    ```
   com.the703.dto 패키지   

5.  db설정확인테스트
    - src/test/java -> ModelTest.java
    ```
    @Test
	public void test1(){
		System.out.println(sqlSession);
	}
    ```
    
6. mapper test
    - com.the703.dao.config -> test-mapper.xml
    - com.the703.dao -> TestMapper.java
    ```
    @Test
	public void test2(){
		System.out.println(test.now());
	}
    ```

7. board 실전
    - com.the703.dto -> BoardDto.java(@Data)
    - com.the703.dao.config -> board-mapper.xml
    - com.the703.dao -> BoardMapper.java

9. board 테스트

    ```
    @Test
	public void test3(){
		System.out.println(boardMapper.selectAll());
	}	
    ```

```

* db.properties -> HikariCP로 변경
HikariCp: 연결해주는 소켓 만들어놓고 꺼내쓰고 반납 close() 안해도됨
1. db.properties 주석
    - DriverSpy
    ```
    db.driverClass=net.sf.log4jdbc.sql.jdbcapi.DriverSpy;
    db.url=jdbc:log4jdbc:mysql://localhost:3306/mbasic
    db.username=root
    db.password=1234
    ```
2. root-context.xml
    - SimpleDriverDataSource -> HikariDataSource 변경
    ```
	<context:property-placeholder location="classpath:config/db.properties"/>	
	<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource">
		<property name="driverClassName" value="${db.driverClass}"/>
		<property name="jdbcUrl"  value="${db.url}"/>
		<property name="username" value="${db.username}" />
		<property name="password" value="${db.password}"/>
	</bean>
    ```
3. new -> source folder -> src/main/resources
    - log4j2.properties
    - log4jdbc.log4j2.properties
        - Log4j2SpyLogDelegator : sql 구문 출력해줄게
4. pom.xml 
    - resources 추가
    ```
    <build>
        <resources>
			<resource>
				<directory>src/main/resources</directory>
			</resource>
		</resources>
    ....
    
    </build>
    ```
    - dependency 추가
    ```
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.17.2</version>
    </dependency>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.17.2</version>
    </dependency>

    ```

 5. 테스트진행
    - ModelTest001.java 실행
    ```
    [14:56:07] INFO  com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Starting...
    [14:56:07] INFO  log4jdbc.log4j2 - 1. Connection opened. {executed in 457ms} 
    [14:56:07] INFO  log4jdbc.log4j2 - 1. Connection.new Connection returned 
    [14:56:07] INFO  com.zaxxer.hikari.pool.PoolBase - HikariPool-1 - Driver does not support get/set network timeout for connections. (Receiver class net.sf.log4jdbc.sql.jdbcapi.ConnectionSpy does not define or inherit an implementation of the resolved method 'abstract int getNetworkTimeout()' of interface java.sql.Connection.)
    [14:56:07] INFO  log4jdbc.log4j2 - 1. Connection.setReadOnly(false) returned 
    [14:56:07] INFO  log4jdbc.log4j2 - 1. Connection.setAutoCommit(true) returned 
    [14:56:07] INFO  log4jdbc.log4j2 - 1. Connection.isValid(1) returned true
    [14:56:07] INFO  log4jdbc.log4j2 - 1. Connection.getTransactionIsolation() returned 4
    [14:56:07] INFO  com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Start completed.
    [14:56:07] INFO  log4jdbc.log4j2 - 1. Connection.getAutoCommit() returned true
    [14:56:07] INFO  log4jdbc.log4j2 - 1. PreparedStatement.new PreparedStatement returned 

    ...

    ```

# spring003_mvc
    - ex2 복사 후 프로젝트 변경
      * 복사해서 만든 프로젝트는 아래 진행
        - properties -> web project setting -> context root -> spring003_mvc
        - pom.xml 수정
            ```
            <groupId>spring003_mvc</groupId>
            <artifactId>spring003_mvc</artifactId>
            ```

    - pom.xml 추가
        - spring-webmvc
        - jstl
        - 

    ```
		<!-- spring-webmvc -->
		<!-- spring-webmvc -->
		<!-- spring-webmvc -->
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>4.3.27.RELEASE</version>
		</dependency>
		<!-- jstl -->
		<!-- jstl -->
		<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>

    ```

    - servlet-context.xml 생성 (부품관리 xml파일)    
        - config -> ctrl+n -> spring -> servlet-context.xml
            - beans, context, jdbc, mvc, mybatis-spring 체크
        - MVC Controller
            ```
            <context:component-scan base-package="com.the703" /> 
            <mvc:annotation-driven /> 		
            <mvc:default-servlet-handler/>
            ```
        - View Resolver
            ```
            <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                <property name="prefix" value="/view/" /> <!-- 폴더 -->	
                <property name="suffix" value=".jsp"/> <!-- 확장자 -->	
	        </bean>

            ```
    - web.xml - 스프링구동을 해당 파일에 설정
    - 요청이 들어오면 web.xml 실행
        - ContextLoaderListen (스프링구동)
            - c + ctrl + space
        - DispatcherServlet
            - d + ctrl + space
    
    - BasicController.java 생성
        - com.the703.controller -> class ->BasicController

    - jsp 파일 생성
        - webapp
            - view 폴터
            - basic.jsp
    - 실행테스트


### ■4. 복습문제
