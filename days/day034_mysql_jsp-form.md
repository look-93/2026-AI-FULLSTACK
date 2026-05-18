- Todo1:  MYSQL
- Todo2:  JSP 



---
### ■1.  MYSQL 
1) WEB BASIC - HTML + CSS + JS ( 화면단 )
2) JAVA ( 프로그래밍 )
3) MYSQL/ORACLE (DB)
4) JSP (Html+Java)

##### TABLE
##### ALTER


 
---
### ■2.  JSP
1. project
2. ws vs  was


---
### ■3.  복습문제

-- STEP1)
-- 1. 데이터베이스 언어 - 다음과 같은형식으로 빈칸 채우기
-- DDL( 정의어 ) create, drop, alter
-- DML( 조작어 ) insert, delete, select, update
-- DCL( 제어어 ) GRANT , REVOKE

-- STEP2)
-- Q1. userinfo 테이블을 복사해서 userinfo_ex 테이블을 만드시오.
create table userinfo_ex select \* from userinfo;
alter table change no int not null primary key auto_increment;

-- mysql> desc userinfo_ex;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type | Null | Key | Default | Extra |
-- +-------+--------------+------+-----+---------+----------------+
-- | no | int | NO | PRI | NULL | auto_increment |
-- | name | varchar(100) | NO | | NULL | |
-- | age | int | NO | | NULL | |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)

-- mysql> select \* from userinfo_ex;
-- +----+--------+-----+
-- | no | name | age |
-- +----+--------+-----+
-- | 1 | first | 11 |
-- | 2 | second | 22 |
-- | 3 | third | 33 |
-- | 4 | fourth | 44 |
-- +----+--------+-----+

insert into userinfo_ex values (1, "first", 11);
insert into userinfo_ex values (2, "second", 22);
insert into userinfo_ex values (3, "third", 33);
insert into userinfo_ex values (4, "fourth", 44);

-- Q2. userinfo_re1 에 다음과 같이 데이터 추가
-- mysql> select \* from userinfo_re1;
-- +----+--------+-----+
-- | no | name | age |
-- +----+--------+-----+
-- | 1 | first | 11 |
-- | 2 | second | 22 |
-- | 3 | third | 33 |
-- | 4 | fourth | 44 |
-- | 5 | fifth | 50 |
-- | 6 | six | 66 |
-- +----+--------+-----+

create table userinfo_re1 select \* from userinfo;
insert into userinfo_re1 select \* from userinfo_ex;
insert into userinfo_re1 values (5, "fifth", 50);
insert into userinfo_re1 values (6, "six", 66);

-- Q3. userinfo_re1 에 데이터 수정
-- mysql> select \* from userinfo_re1;
-- +----+--------+-----+
-- | no | name | age |
-- +----+--------+-----+
-- | 1 | first | 11 |
-- | 2 | second | 22 |
-- | 3 | third | 33 |
-- | 4 | fourth | 44 |
-- | 5 | fifth | 55 | ← age 55로 수정
-- | 6 | six | 66 | ← name sixth로 수정
-- +----+--------+-----+

update userinfo_re1
set age = 55
where no = 5;

update userinfo_re1
set name = "sixth"
where no = 6;

-- Q4. userinfo_re1 에 데이터 삭제
-- mysql> select \* from userinfo_re1;
-- +----+--------+-----+
-- | no | name | age |
-- +----+--------+-----+
-- | 1 | first | 11 |
-- | 2 | second | 22 |
-- | 3 | third | 33 |
-- | 4 | fourth | 44 |
-- +----+--------+-----+
delete from userinfo_re1
where no = 5 or no = 6;
