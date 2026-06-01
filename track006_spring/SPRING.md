1. SPRING?

--------------------------------
#1. SPRING?
--------------------------------
▶ Step0. jsp
1. mvc1    -  jsp( controller )역할
2. mvc2 - servlet( controller )역할

예) JSP = html + java → web

▶ Step1.  framework
1. framework  [  디자인패턴 + 라이브러리 = 프레임워크 ]
2. 소프트웨어 개발의 뼈대역할


--------------------------------
#2. DI
--------------------------------
▶ Step2.  ioc + di
1. ioc
 - inversion of control
 - 제어의 역전
 - 인스턴스의 생성~소멸까지 생명주기를 개발자가 아니라 컨테이너가 하는 것
 - pojo ( plain old java object)

  class A{}
  A a1 = new A()

  생성 → 초기화 → 서비스  → 소멸
    ↑                                      ↓
     ----------------------------------
 
   ioc가 아닌경우   - [ 개발자★  → ( Class A)  
                                    → ( Class B)
                                        → ( Class C)     ] 컨테이너

<!-- 개발자가 new 안해도됨 -->
   ioc인      경우   - [ 개발자  ← ( Class A)  
                                    ← ( Class B)
                                        ← ( Class C)★     ] 컨테이너



2. di ( dependency injection : 의존성주입 )
- 각 클래스간의 의존관계를  [설정파일]을 통해 [컨테이너]가 자동으로 연결
  장점 : 코드단순화 / 결합도 제거



▶ Step3.  실습
===================
실습(1) 설치
===================
* 버젼다운그레이드
  0. java.sun.com   -  java11   / build path
   JAVA_HOME   C:\Program Files\Java\jdk-11
   path                      %JAVA_HOME%\bin             - 맨위로
              
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
 


 4. 프로젝트 우클릭-> configure -> maven -> 설정하면 project 하면 jar파일 자동 다운

 5. add Spring project Nature 
    - "이 프로젝트는 일반 Java 프로젝트가 아니라 Spring 프로젝트야" 라고 알려주는 기능이야.
    -  추가하면 Eclipse가 Spring 관련 기능을 활성화
    
    ---
    ex
    applicationContext.xml 자동 인식
    Spring Bean 연결 관계 분석
    Spring 설정 파일 자동 완성
    Spring 전용 아이콘 표시
    Bean 참조 오류 검사
    ---

  6. pom.xml (packaging 와 build 태그 사이 붙여넣기)

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

  5. 프로젝트우클릭 -> build path -> configure  build path -> classpath -> add library -> junit -> junit4 : test 파일 생성


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
===================
    1. dynamic web project - spring001
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path
    5. build path - add Libraries - JUnit 4

    구조확인
   1. pom.xml         설치 다운로드
              2. src/main/java   실제 자바파일들 위치
              3. src/test/java    실제 테스트파일위치
              4. src/main/webapp   jsp 파일들위치

   연습문제)  ex1  프로젝트만들기


===================
실습(3)  SPRING 정리
===================
1.  프레임워크
   - 소프트웨어개발의 뼈대역할 [디자인패턴 + 라이브러리]
2.  IOC
   - 인스턴스 생성~소멸까지 생명주기를 스프링이 관리
   <!-- 스프링이 알아서 개발자한테 객체생성해줌 -->
3.  DI
   - 각클래스의 의존관계를  [설정파일]을 통해서 컨테이너가 자동연결
4.  BEAN
   -  스프링이 관리하는 객체(부품)
   - beanFactory   ← ApplicationContext

  [AnimalFarm]  (사용)→    [<<interface>>Animal]   
   ↑(삽입)                   ↑(구현)    ↑ (구현)   

  [beans.xml ]  (생성)→     [Cat     /   Dog]

  >> di? 각클래스의 의존관계를 [설정파일]을통해서 컨테이너가 자동연결   
  <!-- 부품객체의 연관관계를 알기위해서 설정파일(xml 로되어있는 )부터 확인 -->


  <!-- 고전적문제 확인!! spring spring-boot 똑같은 문제
      @Data  : ctrl + shift + o
      lombok 동작되는지 확인해야함 getter/setter 등 안생김  
      내 프레임워크에 맞는 버전 써야함
      롬북 수동설치
  -->
  * 롬북 설정안될 시 롬북 재설치
  https://projectlombok.org/download 
  1. 버전에 맞게 다운로드 - all-versions - lombok-1.18.18.jar
  2. 경로짧게 - c드라이브로 이동
  3. cmd
     c드라이브 경로이동
    ``` 
    java - jar lombok-1.18.18.jar
    ```
  4) sts 설치 위치 - 이클립스 선택 - install
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




#5. 예시)
---------------------------------
@Data
class MyA{
   private String name;
   private Animal ani;

   public MyA(String name, Animal ani){
      this.name = name;
      this.ani = ani;
   }
}
---------------------------------
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
[IceCreamShop]  (사용)  →   [<<interface>> IceCream]   
   ↑(삽입)                   ↑(구현)         ↑(구현)   
 [beans.xml] (생성)     →   [Vanilla / Chocolate]

 >> di? 각 클래스의 의존관계를 [설정파일]을 통해 컨테이너가 자동연결

1) 인터페이스
com.company.ioctest

public interface IceCream {
    public String flavor();
    public String scoop();
    public String melt();
}
2) 구현클래스
com.company.ioctest

public class Vanilla implements IceCream {
    @Override public String flavor() { return "Vanilla-flavor"; }
    @Override public String scoop()  { return "Vanilla-scoop"; }
    @Override public String melt()   { return "Vanilla-melt"; }
}

public class Chocolate implements IceCream {
    @Override public String flavor() { return "Chocolate-flavor"; }
    @Override public String scoop()  { return "Chocolate-scoop"; }
    @Override public String melt()   { return "Chocolate-melt"; }
}


3) 사용클래스 - IceCreamShop

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
