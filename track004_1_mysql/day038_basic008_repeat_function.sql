-- 1. CRUD (SELECT 복습문제)
-- 2. CRUD (SELECT Function-Number)
-- 3. CRUD (SELECT Function-Number 연습문제)
-- 4. CRUD (SELECT Function-String)
-- 5. CRUD (SELECT Function-String 연습문제)
-- ________________________________________________________________
-- ________________________________________________________________

-- ■ 진행1. CRUD (SELECT 복습문제)

-- Q1. 다음과 같이 테이블을 작성하시오  ( 있다면 pass)
-- mysql> desc userinfo_select;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.01 sec)

-- drop table userinfo_select;
-- desc userinfo_select;
select * from userinfo_select;

create table userinfo_select select * from userinfo where 1=2; -- 구조만 복사
create table userinfo_select select * from userinfo; -- 데이터까지 복사

-- Q2. userinfo 테이블을 다음과 같이 수정하시오.
-- mysql> desc userinfo_select;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | YES  |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.01 sec)

alter table userinfo_select modify no int not null primary key auto_increment;
alter table userinfo_select modify age int null;
-- Q3. 다음과 같이 데이터가 있다
--  AFTER와 같이 데이터를 추가하시오.
-- >> BEFORE)
-- mysql> select * from userinfo_select;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  NULL|
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- +----+--------+-----+
-- 6 rows in set (0.01 sec)

insert into userinfo_select values (1, 'first' , null);
insert into userinfo_select values (2, 'second' , 22);
insert into userinfo_select values (3, 'third' , 33);

-- >> AFTER)
-- mysql> select * from userinfo_select;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  NULL |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- +----+--------+-----+
-- 6 rows in set (0.01 sec)
insert into userinfo_select values (4, 'fourth' , 44);

-- Q4. 이름이 fourth 이고 age가 44인데이터의 no를 10으로 수정하시오.
update userinfo_select 
set no = 10
where name = "fourth" and age = 44;

-- Q5. no가 10인데이터를 삭제하시오.
delete from userinfo_select
where no = 10;

-- Q6. 나이가 많은순으로 2명을 검색하시오.
select *
  from userinfo_select
order by age desc
limit 2;

-- Q7. 나이가 NULL이 아니고
--     no가 2또는 3중에서
--     이름의 두번째 글자가 e가아닌 데이터를 조회하시오
select *
from userinfo_select
where age is not null 
  and (no = 2 or no = 3) -- no in(2,3)
  and name not like '_e%';

-- Q8.  emp 테이블에서 GROUP BY절만  사용하여
-- -- 각부서의 직책별 사원수, 가장높은 급여, 급여합, 평균급여를  다음과 같이  사원데이터를  조회하시오.
select deptno,
	   job,
       count(*) as `사원수`,
	   max(sal) as `최고급여`,
       sum(sal) as `급여합`,
       avg(sal) as `평균급여`
from emp 
group by deptno, job
order by deptno, job;

-- >> 결과
-- +--------+-----------+--------+----------+--------+-----------+
-- | deptno | job       | 사원수   | 최고급여   | 급여합   | 평균급여   |
-- +--------+-----------+--------+----------+--------+-----------+
-- |     10 | CLERK     |      1 |     1300 |   1300 | 1300.0000 |
-- |     10 | MANAGER   |      1 |     2450 |   2450 | 2450.0000 |
-- |     10 | PRESIDENT |      1 |     5000 |   5000 | 5000.0000 |
-- |     20 | ANALYST   |      2 |     3000 |   6000 | 3000.0000 |
-- |     20 | CLERK     |      2 |     1100 |   1900 |  950.0000 |
-- |     20 | MANAGER   |      1 |     2975 |   2975 | 2975.0000 |
-- |     30 | CLERK     |      1 |      950 |    950 |  950.0000 |
-- |     30 | MANAGER   |      1 |     2850 |   2850 | 2850.0000 |
-- |     30 | SALESMAN  |      4 |     1600 |   5600 | 1400.0000 |
-- +--------+-----------+--------+----------+--------+-----------+
-- 9 rows in set (0.00 sec)

-- >> 주어진조건
-- mysql> desc emp;
-- +----------+-------------+------+-----+---------+----------------+
-- | Field    | Type        | Null | Key | Default | Extra          |
-- +----------+-------------+------+-----+---------+----------------+
-- | empno    | int         | NO   | PRI | NULL    | auto_increment |
-- | ename    | varchar(20) | YES  |     | NULL    |                |
-- | job      | varchar(20) | YES  |     | NULL    |                |
-- | mgr      | int         | YES  |     | NULL    |                |
-- | hiredate | date        | YES  |     | NULL    |                |
-- | sal      | int         | YES  |     | NULL    |                |
-- | comm     | int         | YES  |     | NULL    |                |
-- | deptno   | int         | NO   |     | NULL    |                |
-- +----------+-------------+------+-----+---------+----------------+
-- 8 rows in set (0.00 sec)

-- ■ 진행2. CRUD (SELECT Function-Number)
-- >> 데이터베이스언어
-- DDL  : create, alter , drop
-- DML : insert, select # , update, delete
-- DCL  : grant, revoke

-- ==========================
-- #1. Number
-- 1.   ceil     올림
-- 2.   floor   내림
-- 3.   round 반올림
-- 4.   mod(숫자 , 나눌 수)   나머지 연산자

-- = BASIC 

select ceil(1.1) `올림 2` , 
	   floor(1.9) `내림 1`, 
       round(1.5) `반올림 2`, 
       mod(10,3) `나머지 1`  
from dual;

select 12.2345,
	   round(12.2345,1),
	   round(12.2545,1), -- 소수점 1번째자리 반올림 12.3
       round(15.2345,-1) -- 정수 1번째 반올림할 자리 20
  from dual;

-- +-----------+------------+------------+-----------+
-- | ceil(1.1) | floor(1.9) | round(1.5) | mod(10,3) |
-- +-----------+------------+------------+-----------+
-- |         2 |          1 |          2 |         1 |
-- +-----------+------------+------------+-----------+
-- 1 row in set (0.01 sec)

-- mysql>

-- ■ 진행3. CRUD (SELECT Function-Number 연습문제)

-- EX1    123.4578을 ROUND를 이용하여 다음과 같이 출력하시오.
select 123.4578,
	   round(123.4578,0),
	   round(123.4578,-1),
	   round(123.4578,1),
       round(123.4578,2)
from dual;

-- +----------+--------+--------+--------+--------+
-- | 123.4578 | ROUND1 | ROUND2 | ROUND3 | ROUND4 |
-- +----------+--------+--------+--------+--------+
-- | 123.4578 |    123 |    120 |  123.5 | 123.46 |
-- +----------+--------+--------+--------+--------+
-- 1 row in set (0.00 sec)


-- EX2  다음과 같이 출력하시오.
select ceil(123.4578),
	   floor(123.4578)
from dual;

-- +----------+------+-------+
-- | 123.4578 | CEIL | FLOOR |
-- +----------+------+-------+
-- | 123.4578 |  124 |   123 |
-- +----------+------+-------+
-- 1 row in set (0.00 sec)

-- ■ 진행4. CRUD (SELECT Function-String)
-- #2. String
-- length
-- upper / lower

-- instr( 문자열, 찾을 문자열 ) - 위치
-- substr( 문자열, 시작, 갯수 )  - 문자열일부분 추출
-- left( 문자열, 갯수)
-- right( 문자열, 갯수)

-- concat ( 문자열, 문자열 ) - 문자열연결

-- trim()  - ltrim, rtrim  공백제거
-- replace (문자열, 찾아서, 바꾸기)
-- repeat (문자열, 몇번)

-- lpad(문자열, 전체자리수, 특정문자)
-- rpad(문자열, 전체자리수, 특정문자)


-- = BASIC
-- mysql> -- 1. length(문자열)
select length('abc')
from dual;

-- +---------------+
-- | length('abc') |
-- +---------------+
-- |             3 |
-- +---------------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql> -- 2. upper/lower 
select 'ABC'        as `DEFAULT`,
	   upper('abc') as `s1`,
       lower('ABC') as `s2`
from dual;
       
-- +---------+------+------+
-- | DEFAULT | s1   | s2   |
-- +---------+------+------+
-- | ABC     | ABC  | abc  |
-- +---------+------+------+
-- 1 row in set (0.01 sec)

-- mysql> -- 3. 찾기1 - 위치  instr  
select instr('abc','b' ) as `a(1)b(2)c에서b`, 
	   instr('abc','ab') as `ab의 위치`,
       instr('abc','ac') as `ac의 위치`
from dual;

-- +----------+-----------+-----------+
-- | b의 위치 | ab의 위치 | ac의 위치 |
-- +----------+-----------+-----------+
-- |        2 |         1 |         0 |
-- +----------+-----------+-----------+
-- 1 row in set (0.00 sec)


-- mysql> -- 4.   찾기 2 - 문자열 left, right, substr
select left('abc',1)  as `l1`,
       left('abc',2)  as `l2`,
       right('abc',1) as `r1`,
       right('abc',2) as `r2`
from dual; 
       
-- +------+------+------+------+
-- | l1   | l2   | r1   | r2   |
-- +------+------+------+------+
-- | a    | ab   | c    | bc   |
-- +------+------+------+------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql> -- 5. 찾기 3  - substr 
select substr('abcde',2,2) as `s1`,
       substr('abcde',2,3) as `s2`,
       substr('abcde',1,3) as `s3`
from dual;
       
-- +------+------+------+
-- | s1   | s2   | s3   |
-- +------+------+------+
-- | bc   | bcd  | abc  |
-- +------+------+------+
-- 1 row in set (0.00 sec)

-- mysql> -- 6. 문자열 연결   - concat 
select concat('choco', 'milk') as `concat('choco' , 'milk')`
from dual;
-- +--------------------------+
-- | concat('choco' , 'milk') |
-- +--------------------------+
-- | chocomilk                |
-- +--------------------------+
-- 1 row in set (0.00 sec)

-- mysql> -- 7. 공백빼기 - trim
select trim(' a b c ') as `trim(' a b c ')`
from dual;
-- +-----------------+
-- | trim(' a b c ') |
-- +-----------------+
-- | a b c           |
-- +-----------------+
-- 1 row in set (0.00 sec)

-- mysql>
select concat('#', trim(' a b c '),  '#') as `t1`, -- #a b c#
	   concat('#', rtrim(' a b c '), '#') as `t2`, -- # a b c#
	   concat('#', ltrim(' a b c '), '#') as `t3`  -- #a b c #
from dual;
-- +---------+----------+----------+
-- | t1      | t2       | t3       |
-- +---------+----------+----------+
-- | #a b c# | #a b c # | # a b c# |
-- +---------+----------+----------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql> -- 8. 찾아서 바꾸기 - replace 
select replace('hello sally' , 'sally','a') as `replace`
from dual;
-- +--------------------------------------+
-- | replace('hello sally' , 'sally','a') |
-- +--------------------------------------+
-- | hello a                              |
-- +--------------------------------------+
-- 1 row in set (0.00 sec)

-- mysql>
-- mysql> -- 9. 반복 repeat
select repeat('*', 5)
from dual;
-- +---------------+
-- | repeat('*',5) |
-- +---------------+
-- | *****         |
-- +---------------+
-- 1 row in set (0.00 sec)

-- mysql> -- 10. 빈칸채우기
select lpad('abc', 5, '#') as `lpad`,
       rpad('abc', 5, '#') as `rpad`
from dual;
-- +----------------------+----------------------+
-- | lpad('ABC' , 5, '#') | rpad('ABC' , 5, '#') |
-- +----------------------+----------------------+
-- | ##ABC                | ABC##                |
-- +----------------------+----------------------+
-- 1 row in set (0.00 sec)

-- ■ 진행5. CRUD (SELECT Function-Number 연습문제)

-- mysql> desc fn_select_userinfo2;
create table fn_select_userinfo2 select * from select_userinfo where 1=2;
alter table fn_select_userinfo2 modify age int not null;
alter table fn_select_userinfo2 modify name varchar(20) not null;
alter table fn_select_userinfo2 add email varchar(20) not null;
desc fn_select_userinfo2;
select * from fn_select_userinfo2;
-- +-------+-------------+------+-----+---------+-------+
-- | Field | Type        | Null | Key | Default | Extra |
-- +-------+-------------+------+-----+---------+-------+
-- | no    | int         | NO   |     | 0       |       |
-- | name  | varchar(20) | NO   |     | NULL    |       |
-- | age   | int         | NO   |     | NULL    |       |
-- | email | varchar(20) | NO   |     | NULL    |       |
-- +-------+-------------+------+-----+---------+-------+
-- 4 rows in set (0.01 sec)

-- mysql> select * from fn_select_userinfo2;
insert into fn_select_userinfo2 values (1,'aaa',11,'aaa@gmail.com');
insert into fn_select_userinfo2 values (2,'bbb',22,'bbb@gmail.com');
insert into fn_select_userinfo2 values (3,'ccc',33,'ccc@gmail.com');
insert into fn_select_userinfo2 values (4,'ddd',44,'ddd@gmail.com');
insert into fn_select_userinfo2 values (5,'abc',55,'abc@gmail.com');
insert into fn_select_userinfo2 values (6,'bca',66,'bca@gmail.com');
-- +----+------+-----+---------------+
-- | no | name | age | email         |
-- +----+------+-----+---------------+
-- |  1 | aaa  |  11 | aaa@gmail.com |
-- |  2 | bbb  |  22 | bbb@gmail.com |
-- |  3 | ccc  |  33 | ccc@gmail.com |
-- |  4 | ddd  |  44 | ddd@gmail.com |
-- |  5 | abc  |  55 | abc@gmail.com |
-- |  6 | bca  |  66 | bca@gmail.com |
-- +----+------+-----+---------------+
-- 6 rows in set (0.00 sec)

-- mysql>


-- 1. 유저의 이름의 글자수를 조회하시오.
select name as `이름`, 
	   length(name) as `갯수`
  from fn_select_userinfo2;
  
-- +------+------+
-- | 이름 | 갯수 |
-- +------+------+
-- | aaa  |    3 |
-- | bbb  |    3 |
-- | ccc  |    3 |
-- | ddd  |    3 |
-- | abc  |    3 |
-- | bca  |    3 |
-- +------+------+
-- 6 rows in set (0.00 sec)

-- 2. 유저의 이름과 이름의  첫번째 글자 , 마지막글자 를 조회하시오. (left, right)
select name,
	   left(name, 1) as `첫번쨰 글자`,
       right(name,1) as `마지막 글자`
  from fn_select_userinfo2;
-- +------+-------------+------------+
-- | name | 첫번째 글자 | 마지막글자 |
-- +------+-------------+------------+
-- | aaa  | a           | a          |
-- | bbb  | b           | b          |
-- | ccc  | c           | c          |
-- | ddd  | d           | d          |
-- | abc  | a           | c          |
-- | bca  | b           | a          |
-- +------+-------------+------------+
-- 6 rows in set (0.00 sec)

-- 3. 유저이름의 aaa인 유저를 찾아서 'aaa 1등'으로 변경하시오.
select name,
	   replace(name, 'aaa', 'aaa 1등')       
from fn_select_userinfo2;
-- +------+-----------------------------------+
-- | name | replace( name, 'aaa' , 'aaa 1등') |
-- +------+-----------------------------------+
-- | aaa  | aaa 1등                           |
-- | bbb  | bbb                               |
-- | ccc  | ccc                               |
-- | ddd  | ddd                               |
-- | abc  | abc                               |
-- | bca  | bca                               |
-- +------+-----------------------------------+
-- 6 rows in set, 1 warning (0.00 sec)

-- 4. 다음과 같이 직업을 출력하시오.   (concat)
select concat(name , '는 개발자입니다.')
from fn_select_userinfo2;
-- +---------------------+
-- | 직업                |
-- +---------------------+
-- | aaa는 개발자입니다. |
-- | bbb는 개발자입니다. |
-- | ccc는 개발자입니다. |
-- | ddd는 개발자입니다. |
-- | abc는 개발자입니다. |
-- | bca는 개발자입니다. |
-- +---------------------+
-- 6 rows in set, 1 warning (0.00 sec)

-- 5. 이름을 대문자로 조회하시오.
select upper(name)
from fn_select_userinfo2;
-- +-------------+
-- | upper(name) |
-- +-------------+
-- | AAA         |
-- | BBB         |
-- | CCC         |
-- | DDD         |
-- | ABC         |
-- | BCA         |
-- +-------------+
-- 6 rows in set (0.00 sec)

--  6. 이름을 소문자로 조회하시오.
select lower(name)
from fn_select_userinfo2;

-- +-------------+
-- | lower(name) |
-- +-------------+
-- | aaa         |
-- | bbb         |
-- | ccc         |
-- | ddd         |
-- | abc         |
-- | bca         |
-- +-------------+
-- 6 rows in set (0.00 sec)

-- 7. 나이가 40대이상의 유저의 이름과 b의 위치를  조회하시오. (instr)
select name,
	   instr(name,'b') as `instr(name,'b')`
from fn_select_userinfo2
where age >= 40;
-- +------+-----------------+
-- | name | instr(name,'b') |
-- +------+-----------------+
-- | ddd  |               0 |
-- | abc  |               2 |
-- | bca  |               1 |
-- +------+-----------------+
-- 3 rows in set (0.03 sec)

-- 8. [upgrade] 나이가 40대이상의 유저의 이름과 b의 위치를  조회시 나이 많은 순으로 2분을 조회하시오(instr)
select name,
	   instr(name,'b') as `instr(name,'b')`
from fn_select_userinfo2
where age >= 40
order by age desc
limit 2;
-- +------+-----------------+
-- | name | instr(name,'b') |
-- +------+-----------------+
-- | bca  |               1 |
-- | abc  |               2 |
-- +------+-----------------+
-- 2 rows in set (0.02 sec)

-- 9. [upgrade] 유저의 이름과 이름의  첫번째 글자 , 마지막글자 를 조회하시오.
select name,
       concat(left(name,1), '*' , right(name,1)) as `test`
from fn_select_userinfo2;

-- +------+------+
-- | name | test |
-- +------+------+
-- | aaa  | a*a  |
-- | bbb  | b*b  |
-- | ccc  | c*c  |
-- | ddd  | d*d  |
-- | abc  | a*c  |
-- | bca  | b*a  |
-- +------+------+
-- 6 rows in set (0.00 sec)

-- mysql>

-- 10. 테이블 select_userinfo복사해서 한개더 만들기
-- mysql> select * from select_userinfo2;
create table fn_select_userinfo2  select * from select_userinfo where 1=2;
alter table fn_select_userinfo2   modify   no int not null  auto_increment primary key;

insert into fn_select_userinfo2 (name, age, email) values ('aaaaa' , 11 ,'aaa@gmail.com');
insert into fn_select_userinfo2 (name, age, email) values ('bbaab' , 22 ,'bbb@gmail.com');
insert into fn_select_userinfo2 (name, age, email) values ('ccaac' , 33 ,'ccc@gmail.com');
insert into fn_select_userinfo2 (name, age, email) values ('ddddd' , 44 ,'ddd@gmail.com');
insert into fn_select_userinfo2 (name, age, email) values ('abc' , 55 ,'abc@gmail.com');
insert into fn_select_userinfo2 (name, age, email) values ('baaca' , 66 ,'bca@gmail.com');

-- +----+-------+-----+---------------+
-- | no | name  | age | email         |
-- +----+-------+-----+---------------+
-- |  1 | aaaa  |  11 | aaa@gmail.com |
-- |  2 | bbaab |  22 | bbb@gmail.com |
-- |  3 | ccaac |  33 | ccc@gmail.com |
-- |  4 | daadd |  44 | abc@gmail.com |
-- |  5 | abc   |  55 | abc@gmail.com |
-- |  6 | baaca |  66 | bca@gmail.com |
-- +----+-------+-----+---------------+
-- 6 rows in set (0.00 sec)

select name,
       concat(left(name,1), repeat('*', length(name) - 2) , right(name,1)) as `test`
from select_userinfo2;

-- +-------+-------+
-- | name  | test  |
-- +-------+-------+
-- | aaaa  | a**a  |
-- | bbaab | b***b |
-- | ccaac | c***c |
-- | daadd | d***d |
-- | abc   | a*c   |
-- | baaca | b***a |
-- +-------+-------+
