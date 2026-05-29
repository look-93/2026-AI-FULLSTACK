- Todo1: MYSQL
- Todo2: JSP

- mysql workbench 다운로드
  https://dev.mysql.com/downloads/workbench/?utm_source=copilot.com

---

### ■1. MYSQL

1. WEB BASIC - HTML + CSS + JS ( 화면단 )
2. JAVA ( 프로그래밍 )
3. MYSQL/ORACLE (DB)
4. JSP (Html+Java)

##### TABLE

##### ALTER

---

### ■2. JSP
※ tomcat 셋팅
- 프로젝트 임포트 시 톰캣 오류나면 확인하기
- The superclass "jakarta.servlet.http.HttpServlet" was not found on the Java Build Path
1. 프로젝트 우클릭 - Properties - java build path / project fecets 자바버전수정


1. project
2. ws vs was



---

### ■3. 복습문제

1.  데이터베이스 언어
    -- DDL( 정의어 ) CREATE, ALTER, DROP
    -- DML( 조작어 ) **insert**, **update**, **delete** , **select**
    -- DCL( 제어어 ) **revoke**, **grant**

2.  다음과 같이 테이블준비
    -- DB명 : mbasic  
    -- 테이블명: userinfo
    -- 필드1 - 필수입력 no , 숫자자동증가, 기본키 정수형
    -- 필드2 - 필수입력 name 가변형문자열(100)
    -- 필드3 - 필수입력 age 정수형
    +-------+--------------+------+-----+---------+----------------+
    | Field | Type | Null | Key | Default | Extra |
    +-------+--------------+------+-----+---------+----------------+
    | no | int | NO | PRI | NULL | auto_increment |
    | name | varchar(100) | NO | | NULL | |
    | age | int | NO | | NULL | |
    +-------+--------------+------+-----+---------+----------------+
    3 rows in set (0.00 sec)

create database mbasic;
create table userinfo(
no int not null priymary key auto_increment,
name varchar(100) not null,
age int not nu,ll
);

3. 다음을 수정

- 1. 이메일 필드 추가(add) email varchar(100)
  - alter table userinfo add email varchar(100);
- 2. 이메일 필드 수정(change) email을 email2로 자료형은 varchar(50) 으로
  - alter table userinfo change email email2 varchar(50);
- 3. 이메일 필드 수정(modify) email을 email2로 자료형은 varchar(50) 으로
  - modify는 자료형, 옵션만 수정가능
- 4. 이메일 필드 삭제(drop)
  - alter table userinfo drop column email2;
