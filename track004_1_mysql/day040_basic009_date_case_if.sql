-- 1. CRUD (SELECT Function-Date)
-- 2. CRUD (SELECT Function-Date  연습문제)
-- 3. CRUD (SELECT Function-IF , CASE)
-- 4. CRUD (SELECT Function-IF , CASE 연습문제)
-- ________________________________________________________________
-- ________________________________________________________________

-- DDL : CREATE, ALTER, DROP (CAD)
-- DML : INSERT, DELETE, UPDATE, SELECT
-- DCL : GRANT, REVOKE

-- ■ 1. CRUD (SELECT Function-Date)
-- select (1) - 기본문법
-- select (2) - 집계함수
-- select (3) - 함수 ( Number, String, Date , if, case )
-- select (4) - join
-- select (5) - subquery

-- ==
-- select (3) - 함수 ( Number, String, Date , if, switch )

-- 1. 시스템의 현재 시각 조회 
select now();			-- 2026-05-26 14:38:02
select current_time();	-- 14:38:09

-- 2.  요일  ( 0= Mon  , 1=Tue    6=Sun)
select weekday(now()); -- 0 월요일 ,1 화요일 ,,, 6 일요일
select weekday('2026-05-26'); 

-- 3.  날짜형식  date_format(  날짜지정, '%Y-%m-%d %H:%i-%s' )
select date_format('2026-05-26 14:38:02', '%Y-%m-%d');
select date_format(now(), '%Y-%m-%d');
select date_format(now(), '%Y-%m-%d %H:%i-%s');

-- 참고사항)
-- https://www.w3schools.com/sql/func_mysql_date_format.asp

-- 4.  100일전/ 100일 후  - date_add 
select date_add(now(), interval -10 day); -- 10일 전
select date_add(now(), interval 10 day);  -- 10일 후
select date_add(now(), interval 3 hour);  -- 3시간 전

-- YEAR MONTH DAY HOUR MINUTE SECOND
-- https://www.w3schools.com/sql/func_mysql_date_add.asp

-- 5. datediff  /  timestampdiff 
select datediff('2026-05-26','2026-05-25' ); -- 1일 (두 날짜 간 차이)
select timestampdiff(hour, '2026-05-25', '2026-05-26'); -- 24시간 시간차이

-- now(), weekday(): (0 월, 6 일), date_format(날짜, 'format형식'), date_add, datediff, timestampdiff

-- ■ 2. CRUD (SELECT Function-Date  연습문제)
-- >> 연습문제1)  date_userinfo

-- mysql>
-- mysql> desc date_userinfo;
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | Field | Type         | Null | Key | Default           | Extra             |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- | no    | int          | NO   |     | 0                 |                   |
-- | name  | varchar(100) | NO   |     | NULL              |                   |
-- | age   | int          | NO   |     | NULL              |                   |
-- | date  | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- +-------+--------------+------+-----+-------------------+-------------------+
-- 4 rows in set (0.01 sec)
create table date_userinfo select * from userinfo where 1=2;
alter table date_userinfo add date datetime null default CURRENT_TIMESTAMP;
alter table date_userinfo modify no int not null primary key auto_increment;

desc date_userinfo;
desc userinfo;

-- mysql> select * from date_userinfo;
-- +----+------+-----+---------------------+
-- | no | name | age | date                |
-- +----+------+-----+---------------------+
-- |  1 | aaa  |  11 | 2022-12-30 00:00:00 |
-- |  2 | bbb  |  22 | 2022-11-30 00:00:00 |
-- |  3 | ccc  |  33 | 2022-10-30 00:00:00 |
-- |  4 | ddd  |  44 | 2022-09-30 00:00:00 |
-- +----+------+-----+---------------------+
-- 4 rows in set (0.00 sec)
insert into date_userinfo values (1, 'aaa', 11, '2022-12-30 00:00:00');
insert into date_userinfo values (2, 'bbb', 22, '2022-11-30 00:00:00');
insert into date_userinfo values (3, 'ccc', 33, '2022-10-30 00:00:00');
insert into date_userinfo values (4, 'ddd', 44, '2022-09-30 00:00:00');

-- > [001] '2022-11-01' 이전에 회원가입한 유저의 다음과 같이 데이터를 조회하시오
-- +------+---------------------+
-- | name | date                |
-- +------+---------------------+
-- | ccc  | 2022-10-30 00:00:00 |
-- | ddd  | 2022-09-30 00:00:00 |
-- +------+---------------------+
select name, date
from date_userinfo
where date < '2022-11-01';

-- > [002] '12'월달에  회원가입한 유저에게 30일 연장 이벤트를 실시하려고 한다.
-- +------+---------------------+---------------------+
-- | name | date                | event               |
-- +------+---------------------+---------------------+
-- | aaa  | 2022-12-30 00:00:00 | 2023-01-29 00:00:00 |
-- +------+---------------------+---------------------+
select name, 
	   date,
	   date_add(date, interval 30 day) as `event`
from date_userinfo
where date between '2022-12-01' and '2022-12-31';

select name, 
	   date,
	   date_add(date, interval 30 day) as `event`
from date_userinfo
where date(month()) = 12;

-- > [003] 다음과 같이 유저의 가입날자를 조회하시오.
-- +------+----------------+
-- | name | 가입날짜       |
-- +------+----------------+
-- | aaa  | 2022년12월30일 |
-- | bbb  | 2022년11월30일 |
-- | ccc  | 2022년10월30일 |
-- | ddd  | 2022년09월30일 |
-- +------+----------------+
-- 4 rows in set (0.01 sec)
select name, 
	   date_format(date, '%Y년%m월%d일') as `가입날짜`
from date_userinfo;

-- >> 연습문제2)  select_emp
-- > 1. 금일날짜를 출력하시오.
select now();

-- > 2.  금일과  이번년도 크리스마스  날짜사이의 일수 차이를 구하시오
select datediff('2026-12-25', now());

-- > 3. 현재날짜에서 5개월 더해 출력하시오.
select date_add(now(), interval 5 month);

-- > 4. 현재날짜를 기준으로 가장 가까운 일요일의 날짜를 구하시오.
-- -- 0 = Monday, 1 = Tuesday, 2 = Wednesday, 3 = Thursday, 4 = Friday, 5 = Saturday, 6 = Sunday
select now(); -- 오늘날짜
select 6-weekday(now()  );
select date_add(now(), interval 5 day); -- 결론
select date_add(now(), interval (6-weekday(now())) day); -- 결론: 내일이와도 가장 가까운 오는 일요일

-- 지난일요일
select date_add(now(), interval -(weekday(now()) +1) day);

-- ■ 3. CRUD (SELECT Function-IF , CASE)
-- mysql> desc control;
-- +-------+------+------+-----+---------+-------+
-- | Field | Type | Null | Key | Default | Extra |
-- +-------+------+------+-----+---------+-------+
-- | NO    | int  | YES  |     | NULL    |       |
-- +-------+------+------+-----+---------+-------+
-- 1 row in set (0.00 sec)

-- mysql> select * from control;
-- +------+
-- | NO   |
-- +------+
-- |    1 |
-- |    2 |
-- |    3 |
-- +------+
-- 3 rows in set (0.00 sec)
create table control (no int);
insert into control  values(1),(2),(3);

select*from control;

-- 1이다, 1이 아니다
select no, 
	   if(no=1, '1이다', '1이 아니다') as `1상태`
from control;

-- 1보다 크다,작다
select no, 
	   if(no>1, '크다', '작다') as `1작다,크다`
from control;

-- case
select no, 
       case when no = 1 then '1이다'
			when no = 2 then '2이다'
            when no = 3 then '3이다'
            else '1,2,3 아니다'
	    end as `상태`
from control;

select no, 
       case when no > 2 then '2보다크다'
			when no = 2 then '2이다'
            when no < 2 then '2보다 작다'
            else '1,2,3 아니다'
	    end as `2상태`
from control;

-- ■ 4. CRUD (SELECT Function-IF , CASE 연습문제)

-- mysql> desc if_userinfo;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | YES  |     | 0       |                |
-- | sex   | char(1)      | YES  |     | NULL    |                |
-- | sns   | char(1)      | YES  |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 5 rows in set (0.00 sec)
create table if_userinfo(
no int not null primary key auto_increment,
name varchar(100) not null,
age int,
sex char(1),
sns char(1)
);
desc if_userinfo;

-- mysql> select * from if_userinfo;
-- +----+--------+------+------+------+
-- | no | name   | age  | sex  | sns  |
-- +----+--------+------+------+------+
-- |  1 | first  |   11 | NULL | n    |
-- |  2 | second |  122 | m    | y    |
-- |  3 | third  |   33 | m    | y    |
-- |  4 | fourth |   44 | f    | n    |
-- |  5 | fifth  |   55 | f    | y    |
-- |  6 | sixth  |   66 | m    | n    |
-- +----+--------+------+------+------+
-- 6 rows in set (0.00 sec)

insert into if_userinfo value(1, 'first', 11, null, 'n');
insert into if_userinfo value(2, 'second', 122, 'm', 'y');
insert into if_userinfo value(3, 'third', 33, 'm', 'y');
insert into if_userinfo value(4, 'fourth',44, 'f', 'n');
insert into if_userinfo value(5, 'fifth', 55, 'f', 'y');
insert into if_userinfo value(6, 'sixth', 66, 'm', 'n');


-- >> 연습문제1)
-- [question1]sns의 수신여부상태를 구하시오
-- +----+--------+-----+------+------+--------------+
-- | no | name   | age | sex  | sns  | 수신여부상태 |
-- +----+--------+-----+------+------+--------------+
-- |  1 | first  |  11 | NULL | n    | 수신거부     |
-- |  2 | second |  22 | m    | y    | 수신유지     |
-- |  3 | third  |  33 | m    | y    | 수신유지     |
-- |  4 | fourth |  44 | f    | n    | 수신거부     |
-- |  5 | fifth  |  55 | f    | y    | 수신유지     |
-- |  6 | sixth  |  66 | m    | n    | 수신거부     |
-- +----+--------+-----+------+------+--------------+

select *,
	   case 
			when sns = 'n' then '수신거부' 
            else '수신유지' 
		end as `수신여부상태`
from if_userinfo;

-- [question2]나이가 19세 미만이면 미성년자, 성인을 구하시오.
-- +----+--------+-----+------+------+----------+
-- | no | name   | age | sex  | sns  | 성인여부 |
-- +----+--------+-----+------+------+----------+
-- |  1 | first  |  11 | NULL | n    | 미성년자 |
-- |  2 | second |  22 | m    | y    | 성인     |
-- |  3 | third  |  33 | m    | y    | 성인     |
-- |  4 | fourth |  44 | f    | n    | 성인     |
-- |  5 | fifth  |  55 | f    | y    | 성인     |
-- |  6 | sixth  |  66 | m    | n    | 성인     |
-- +----+--------+-----+------+------+----------+
-- 6 rows in set (0.00 sec)

select *,
	   case 
			when age < 19 then '미성년자'
            else '성인'
		end as `성인여부`
from if_userinfo;


-- [question3]sns의 수신거부 숫자를 구하시오.
-- +---------------+
-- | sns수신거부수 |
-- +---------------+
-- |             3 |
-- +---------------+

select count(*) as `sns수신거부수`
from if_userinfo
where sns = 'n';

-- == (2) case
-- [question1] emp 테이블을 이용하여
--  부서번호가 10이면 ACCOUNTING , 20이면 RESEARCH , 30이면 SALES을 다음과 같이 출력하시오.
select ename,
	   deptno,
	   case 
			when deptno = 10 then 'ACCOUNTING'
            when deptno = 20 then 'RESEARCH'
            when deptno = 30 then 'SALES'
		end as `부서이름`
from emp;

-- +--------+--------+------------+
-- | ENAME  | DEPTNO | 부서이름   |
-- +--------+--------+------------+
-- | SMITH  |     20 | RESEARCH   |
-- | ALLEN  |     30 | SALES      |
-- | WARD   |     30 | SALES      |
-- | JONES  |     20 | RESEARCH   |
-- | MARTIN |     30 | SALES      |
-- | BLAKE  |     30 | SALES      |
-- | CLARK  |     10 | ACCOUNTING |
-- | SCOTT  |     20 | RESEARCH   |
-- | KING   |     10 | ACCOUNTING |
-- | TURNER |     30 | SALES      |
-- | ADAMS  |     20 | RESEARCH   |
-- | JAMES  |     30 | SALES      |
-- | FORD   |     20 | RESEARCH   |
-- | MILLER |     10 | ACCOUNTING |
-- +--------+--------+------------+
-- 14 rows in set (0.00 sec)

-- [question2] emp 테이블에서
-- JOB이 CLERK이면 판매원, SALESMAN이면 영업사원, 기타는 사원을  다음과 같이 출력하시오.
select ename,
	   JOB,
	   case 
			when JOB = 'CLERK'    then '판매원'
            when JOB = 'SALESMAN' then '영업사원'
            else '사원'
		end as `JOB2`
from emp;
-- +--------+-----------+----------+
-- | ENAME  | JOB       | JOB2     |
-- +--------+-----------+----------+
-- | SMITH  | CLERK     | 판매원   |
-- | ALLEN  | SALESMAN  | 영업사원 |
-- | WARD   | SALESMAN  | 영업사원 |
-- | JONES  | MANAGER   | 사원     |
-- | MARTIN | SALESMAN  | 영업사원 |
-- | BLAKE  | MANAGER   | 사원     |
-- | CLARK  | MANAGER   | 사원     |
-- | SCOTT  | ANALYST   | 사원     |
-- | KING   | PRESIDENT | 사원     |
-- | TURNER | SALESMAN  | 영업사원 |
-- | ADAMS  | CLERK     | 판매원   |
-- | JAMES  | CLERK     | 판매원   |
-- | FORD   | ANALYST   | 사원     |
-- | MILLER | CLERK     | 판매원   |
-- +--------+-----------+----------+
-- 14 rows in set (0.00 sec)





