# 이메일 보내기
1. naver - 이메일 (로그인)
2. 2차보안 - 비밀번호
3. Service
4. Controller
5. view

    - 네이버 로그인
    - 환경설정 - pop3/impa설정 - 탭 두개 사용함 - 저장
    - 메인이동 - 아이디클릭 - 보안설정 - 2단계인증 - 비밀번호 복사 
    - application-oauth.properties - NaverEmail - naver.user:이메일, naver.user:2단계인증에서 받은 비밀번호
    - com.the703.api - ApiEmail.java (service)
        - private String host = "이메일";  : 이렇게 사용하면 보안 다 뚫림
            - @Value("${naver.host}") private String host;  
                : application-oauth.properties @Value("${naver.host}") 값을 가져옴

        - sendEmail 
        ```      
        Properties props = new Properties();
        props.put("mail.smtp.host", host);   
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.port", "587");  
        props.put("mail.debug", "true");    
        
        props.put("mail.smtp.starttls.enable", "true");     
        props.put("mail.smtp.ssl.trust", "smtp.naver.com");  
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); 
        //                javax.mail.Session , javax.mail.Authenticator
        Session session = Session.getInstance(props, new Authenticator() { 
            @Override protected PasswordAuthentication getPasswordAuthentication() { 
                return new PasswordAuthentication(user, password);
            } 
        });
        //4. 메일보내기 (Mime   텍스트 text/plain , html  text/html , 이미지 image/png) 멀티미디어메시지
        MimeMessage message = new MimeMessage(session);  
        try {
            message.setFrom(  new  InternetAddress(user));  
            message.addRecipient(Message.RecipientType.TO, new  InternetAddress(to));  
            message.setSubject(subject);  
            message.setContent("" 
                    + "<div style='max-width:600px; margin:auto; background-color:#ffffff; border:1px solid #e0e0e0; border-radius:8px; padding:30px; font-family:Segoe UI, sans-serif; color:#333;'>"
                    + "<h2 style='color:#005bac; border-bottom:1px solid #ddd; padding-bottom:10px;'>정기수신 메일 안내</h2>"
                    + "<p style='font-size:15px; line-height:1.8; margin-top:20px;'>"
                    + content
                    + "</p>"
                    + "<div style='margin-top:30px; text-align:center;'>"
                    + "<a href='https://d2big.com' style='display:inline-block; background-color:#005bac; color:#fff; padding:12px 24px; border-radius:4px; text-decoration:none; font-size:14px;'>홈페이지 바로가기</a>"
                    + "</div>"
                    + "<hr style='margin:40px 0; border:none; border-top:1px solid #eee;'>"
                    + "<p style='font-size:12px; color:#888; text-align:center;'>이 메일은 자동 발송된 안내 메일입니다.<br>문의: <a href='mailto:cozizii@naver.com' style='color:#005bac; text-decoration:none;'>cozizii@naver.com</a></p>"
                    + "</div>"
                    , "text/html; charset=euc-kr");
            
            Transport.send(message);
            System.out.println("....... successfully .......");
        }catch( Exception e) { e.printStackTrace();}

        ```
        
        - import 시 부품 없으면 pom.xml  추가 (javax)
        ```
        <!-- api -->
        <!-- https://mvnrepository.com/artifact/javax.mail/mail -->
        <dependency>
            <groupId>javax.mail</groupId>
            <artifactId>mail</artifactId>
            <version>1.4.7</version>
        </dependency>
        <!-- COOLSMS -->
        <!-- COOLSMS -->
        <!-- https://mvnrepository.com/artifact/net.nurigo/javaSDK -->
        <dependency>
            <groupId>net.nurigo</groupId>
            <artifactId>javaSDK</artifactId>
            <version>2.2</version>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
            <version>2.13.5</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.jsoup/jsoup -->
        <dependency>
            <groupId>org.jsoup</groupId>
            <artifactId>jsoup</artifactId>
            <version>1.14.3</version>
        </dependency>

        <!-- Apache PDFBox -->
        <dependency>
            <groupId>org.apache.pdfbox</groupId>
            <artifactId>pdfbox</artifactId>
            <version>3.0.1</version>
        </dependency>
        ```
        
        - summernote 편집도구
            - https://github.com/summernote/summernote/releases
            - Assets summernote-0.9.1-dist.zip 다운
            - static - js 폴더만들기 - summernote-lite.min.js 넣기
            - css - summernote-lite.min.css , font폴더 넣기
            - layout에 css추가
                ```
                 <link rel="stylesheet" th:href="@{/css/summernote-lite.min.css}" />
                ```
        - util -  mail.html
            - 에디터 타겟 textarea summernote 끼우기
            <!-- ★  타임리프 템플릿 경로를 통해 프로젝트 로컬 JS 파일 로드 ★ -->
            ```
		    <script th:src="@{/js/summernote-lite.min.js}"></script>
            ```

            ```
             window.jQuery('#content').summernote({ // window에서 jQuery를 찾아서 content에 summernote를 끼워줌
            ```

        - ApiUtilController.java

        
# 일정시간되면 메일보내기
1. 스케쥴링구동
@SpringBootApplication
@EnableScheduling // 1. 구동시작점에 추가
public class Boot001Application { }

2. 스케쥴부품
@Component
public class ApiScheduledTask { 
   @Scheduled(fixedRate = 2000)   2초마다 실행 
   @Scheduled(fixedDelay = )  어떤작업이 끝난후에 지정된 시간에 시행
   @Scheduled(cron="0 0 10 * * ?")
   public void runTesk2() {
      System.out.println(".......스케쥴러 실행중 : " + System.currentTimeMillis());
   }
   cron="0 0  0  * * ?"    // 0초  0분  0시   일  월 요일- 매일자정
   cron="0 0  12 * * ?"    // 0초  0분  12시  일  월 요일- 매일정오
   cron="0 30 18 * * ?"    // 매일 오후 6시 30분
   cron="0 0  0  1 * ?"    // 매월 1일 자정
   cron="0 0  0  ? * MON"  // 매주 월요일 자정
   
   * 제한없는 모든값
   ? 특정값 없음
   SUN 일, MON 월, TUE 화, WED 수, THU 목, FRI 금, SAT토


   # rest api (책)

    - 네이버개발자사이트 로그인

    ```
    참고 사항 
    API를 요청할 때 다음 예와 같이 HTTP 요청 헤더에 클라이언트 아이디와 클라이언트 시크릿을 추가해야 합니다.

    > GET /v1/search/book.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1 HTTP/1.1
    > Host: openapi.naver.com
    > User-Agent: curl/7.49.1
    > Accept: */*
    > X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}
    > X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}
    >
    요청 예 
    curl "https://openapi.naver.com/v1/search/book.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1" \
        -H "X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}" \
        -H "X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}" -v
    ```

    - ApiNaverBook.java
    - application-oauth.properties
    ```
        book.clientId=네이버개발자 Client ID 
        book.clientSecret=네이버개발자 Client Secret
    ```
    - ApiNaverBook.java 
        ```
            @Value("${book.clientId}") private String clientId;
            @Value("${book.clientSecret}") private String clientSecret;

        ``` 
    - controller
    - view