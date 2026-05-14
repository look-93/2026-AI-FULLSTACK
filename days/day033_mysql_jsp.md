
- mysql workbench 다운로드
- ddl 
---

https://dev.mysql.com/downloads/workbench/?utm_source=copilot.com 

---

jsp 설치


### ■3. 복습문제

1.  데이터베이스 언어
-- DDL(  정의어   )  CREATE, ALTER, DROP 
-- DML( 조작어  )    __insert______, __update______, ___delete_____ , ___select_____ 
-- DCL( 제어어 )     ____revoke____, ___grant_____


2. 다음과 같이 테이블준비
-- DB명     : mbasic    
-- 테이블명: userinfo
-- 필드1 -  필수입력 no    ,  숫자자동증가, 기본키      정수형
-- 필드2 -  필수입력  name  가변형문자열(100)
-- 필드3 -  필수입력  age      정수형
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| no    | int          | NO   | PRI | NULL    | auto_increment |
| name  | varchar(100) | NO   |     | NULL    |                |
| age   | int          | NO   |     | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

create database mbasic;
create table userinfo(
    no int not null priymary key auto_increment,
    name varchar(100) not null,
    age int not null
);

3. 다음을 수정  
-- 1. 이메일 필드 추가(add)       email varchar(100)
-- 2. 이메일 필드 수정(change)   email을 email2로  자료형은 varchar(50) 으로 
-- 3. 이메일 필드 수정(modify)   email을 email2로  자료형은 varchar(50) 으로 
-- 4. 이메일 필드 삭제(drop)   