### ■1. 복습문제 - 노트 준비 ~09:40



### ■2. mysql



### ■3. spring
spring003_mvc 연장

- service (db+view 연동)
1. com.the703.service
2. interface 
    - BoardService.java
3. class
    - BoardServiceImpl.java
4. modeltest
5. BoardController.java
    - service 연결

6. .jsp 파일 수정
    - action 수정
* 참고
    addFlashAttribute 
    -> list.jsp script로 받아서 처리
    ```
    <script>
    window.addEventListener("load", function(){
        let result = '${result}'
        console.log(result);
    });
    </script>

    ```

    ...
7. index 처리
    - run as 했을때 http://localhost:8080/spring003_mvc/"여기가없어서 매번 주소 붙여넣기함" 까지만 처리됨
    - BasicController 수정
    ```
    @RequestMapping("/")
	public String index() {
		//구동시작점 - db 컨트롤러 : index.jsp
		return "redirect:/board/list.do";
	}


    ```
8. 한글 인코딩 
    - web.xml
    ```
    <!-- 한글 인코딩 필터 설정 -->
    <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>encodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    ```

- git branch
■1.  git branch

🛠️ 팀장 작업 흐름
1. 깃허브저장소 만들기
2. 팀원초대 - [Settings] - Collaborations
> https://github.com/sally03915/2026-ai_branch.git


🛠️ 팀원 작업 흐름
1. 저장소 클론하기
git clone https://github.com/sally03915/2026-ai_branch.git
cd 2026-ai_branch

2. 브랜치 생성하기
git branch              - 브랜치 확인
git checkout -b feature-브랜치이름
git branch 브랜치명     -- 브랜치바꾸기

```
git checkout -b featuer-kbr

```

3. 작업 후 커밋하기
git add .
git commit -m "작업 내용 설명"

4. 원격 저장소에 브랜치 푸시하기
git push origin feature-브랜치이름

# Permission 403 권한확인오류
[Settings] - Collaborations 

### ■4. 복습문제
