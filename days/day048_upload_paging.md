### ■1. 복습문제 - 노트 준비 ~09:40



### ■2. mysql



### ■3. spring

- img / file upload
    - <form img, encType>  </form>

    1. 업로드 부품객체 - pom.xm

    ```
    <!-- img upload -->   
    <!-- img upload -->    
    <!-- commons-fileupload -->
    <dependency>
        <groupId>commons-fileupload</groupId>
        <artifactId>commons-fileupload</artifactId>
        <version>1.3.1</version>
    </dependency>

    <!-- commons-io -->
    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.11.0</version>
    </dependency>
    <!-- img upload -->   
    <!-- img upload -->  

    ```

    2. servlet-context.xml
    ``` 
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<property name="maxUploadSize" value="10485760" /> <!-- 1kb=2^10 => 1mb=2^10*2^10 =>  10MB -->
		<property name="defaultEncoding" value="UTF-8" />	
	</bean>

    <!-- <mvc:resources  mapping ="/resources/upload/**" location="/resources/upload/"></mvc:resources> --> <!-- 배포용 --> 
	<mvc:resources mapping="/upload/**" location="file:///C:/file/"></mvc:resources>

    ```
    *root-context : db와관련
    *servlet-context - 컨트롤러/ view
    3. UploadController.java
        - com.the703.controller 
        - 핵심 코드
            - 경로 + 파일명 조립 후 transferTo
        ``
        	String uploadPath = "C:/file/";
			File dest = new File(uploadPath + file.getOriginalFilename());
			file.transferTo(dest); //올리기
        ```
    4. jsp파일 만들기
        - webapp -> view -> basic -> uploadFrom.jsp
        - webapp -> view -> basic -> uploadResult.jsp


- 실습1) board에 이미지 업로드 추가
    0. 테이블에 이미지 경로추가
        bfile varchar(500) 기본값 the703.png

        - 테이블수정
        - dto수정
        - board-mapper.xml수정

    1. 글삽입에서 이미지 업로드 추가
    2. 상세보기 이미지나오게
    3. 글수정에서 이미지 업로드 추가 - 글 수정 안올리면 이전이미지, 없다면 the703.png 이미지가 나오게

- 3. paging
진행1. paging? 

 - paging 처리를 위해 데이터 만들기
cmd) 
insert into mvcboard2(bname, bpass, btitle, bcontent, bip, bfile) 
select bname, bpass, btitle, bcontent, bip, bfile from mvcboard2;
100 개이상

진행2. Paging 컴포넌트 만들기
 
Paging 1 - Model 1) Mapper
   1) 최신글을 기준으로 10개씩 가져오기(mysql)
    select * from mvcboard2 order by bno desc limit 0,10 ;  -- 어디서부터, 몇개
    select * from mvcboard2 order by bno desc limit 10,10 ; -- 그다음 10개부터 10개
    select * from mvcboard2 order by bno desc limit 20,10 ;
   2) 전체 게시글 갯수
    select count(*) as cnt from mvcboard2;

    - board-test
    ```
    @Test
	public void test8() {
		//최신글 10개씩
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", 0);
		map.put("end", 10);
		System.out.println(mvcBoardMapper.select10(map));
		
		
		System.out.println(mvcBoardMapper.selectCnt());
	}

    ```

Paging 2 - Model 2) PagingUtil 
    - @Data / @NoArgsConstructor 

    ```
    @Data
    @NoArgsConstructor 
    public class PagingUtil {
        private int listtotal; 		//#1) 전체글 토탈
        private int onepagelist;	//#2) 한페이지에 보여줄 게시물의 수 10
        private int pagetotal; 		//#3) 총 페이지 수 ex)256/10=26, 123/10=13 (하단)
        private int bottomlist;		//#4) 하단의 페이지 나누기- 이전 11 12 13 ,,, 19 20
        private int pstartno;		//#5) 페이지 시작번호 - 스타트 번호

        private int current;		//#6) 현재 페이지 번호 ex)15(현재 눌린 페이지)
        private int start;			//#7) 시작 11
        private int end;			//#8) 마지막 20
        
        public PagingUtil(int listtotal, int pagetotal) { //전체페이지수, 시작하는 번호 1 2 3 4 5...
            super();
            this.listtotal = listtotal; //#1
            this.onepagelist = 10; // #2
            this.pagetotal = listtotal <= 0 ? 1: (int)Math.ceil(listtotal/(double)onepagelist); //전체페이지 게수 0이면 1 아니면 전체글/10 , 숫자올림처리
            this.bottomlist = 10;
            
            this.pstartno  = (pagetotal-1)*onepagelist; //시작하는 번호 (1) 1 -> 0,10, (2) 2 -> 10,10, (3) 3 -> 20,10  // 현재 페이지-1 * 한페이지에 보여줄 게시물의 수 10
            this.current = pstartno; //<이전 11 12 13 14 15(현재) 16 17 18 19 20 다음> 
            this.start =  ((this.current-1)/this.bottomlist)*this.bottomlist+1; //15라면 11로 만들기 20이라면 11로 만들기
                        // 앞자리를1로 ((15-1)/10)*10+1 = 11
                        // 앞자리를1로 ((20-1)/10)*10+1 = 11
            this.end = this.start + this.bottomlist -1;
                        // 15 -> 20  11+10-1 = 20
                        // 20 -> 20  11+10-1 = 20					
            if(this.end > this.pagetotal) {this.end = this.pagetotal;} // 전체페이지 갯수가 256 -> 마지막은 30이 아니라 26
        }
        
        
    }


    ```

Paging 3 
- service, serviceimpl 추가
    ```
        //paging
        @Override
        public int selectCnt() {		
            return dao.selectCnt();
        }

        @Override
        public List<MvcBoardDto> select10(int pstartno) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("start", (pstartno-1)*10);
            map.put("end", 10);
            return dao.select10(map);
        }


    ```

- Controller)  BoardController  사용
    ```
	@RequestMapping("/board/list.do")
	public String list(Model model, @RequestParam(value="pstartno", defaultValue="1") int pstartno) {
		model.addAttribute("paging", new PagingUtil(service.selectCnt(), pstartno)); /*service 전제갯수*/
		model.addAttribute("list", service.select10(pstartno)); /*list10 */
		return "board/list"; // /view(폴더)/board(폴더)/list(파일명).jsp(확장자)
	}

    ```

Paging 4 - jsp )  View

list.jsp test
```
        <pre>
        페이징: ${paging }
        전체리스트:${list }
        </pre>

```


### ■4. 복습문제
