### 1. Mysql?

> 1. mysql why?

1. DBMS

- Database Management System
- 데이터베이스를 관리해주는 시스템

2. Database?

- Data + Base
- Data 1. 데이터(수집된 사실, 값) 2. 정보(의미 부여)
- Data(의미를 제공하는 데이터) + Base(체계와 규격을 가진 집합)

Q1. 다음 빈칸을 채우시오
      1.     (#1 데이터 )는  수집된 사실이나 값을 의미하고
      2.    (#2 정보 )는  데이터들 중에서 의미를 제공하는 데이터를 의미

3. Database 종류

- Oracle, Mysql, MSSql,,,

  > 2. mysql 셋팅
  1. MYSQL 다운로드
     https://dev.mysql.com/
     - Download - typical - install
     - MySQL Community Server (하단 목록)
     - 8.4.9LTS (No thanks, just start my download.)
     - 오류 뜨면 설치
       - https://learn.microsoft.com/ko-kr/cpp/windows/latest-supported-vc-redist?view=msvc-170
     - 지원되는 최신 재배포 가능 버전 (X64 https://aka.ms/vc14/vc_redist.x64.exe) -> 재부팅

     - mysql configurator -> pass입력 -> next
     - mysql commend line -> pass 입력(버전확인) -> exit

  2. MYSQL 설치
  3. MYSQL 환경설정 (1) path
     - c드라이브 - 보기 (숨긴 항목 : 파일 확장명,숨긴항목 체크) - ProgramData
     - C:\Program Files\MySQL\MySQL Server 8.4\bin 경로 복사
     - 내 pc -> 속성 -> 고급시스템설정 -> 고급 -> 환경변수 -> 시스템변수(path) -> 새로만들기 -> 경로 붙여넣기 -> 맨위로 이동 -> 확인
     - cmd -> mysql -u root -p -> 비번
  4. MYSQL 환경설정 (2) utf-8 (cmd창 언어 설정)
     - cmd -> chcp 65001 -> mysql -u root -p -> status -> Client characterset: utf8mb4
     - cmd -> -u root -p -> status Client characterset: euckr
     - C:\ProgramData\MySQL\MySQL Server 8.4 -> my.ini파일 맨아래 붙여넣기 (프로그램상 언어설정)
       #################################################

       # Chatset Setting

       #################################################
       [client]
       default-character-set=utf8mb4

       [mysqld]
       character-set-server=utf8mb4
       collation-server=utf8mb4_unicode_ci
       init_connect='SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci'

       [mysqldump]
       default-character-set=utf8mb4

       [mysql]
       default-character-set=utf8mb4
       #################################################

     - 바탕화면 검색 - 서비스 - 이름정렬 - MYSQL84 - 중지 - 시작 (설정 후 서비스 재시작)

### 2. RDBMS

> 1. RDBMS(Relational Datase Management System)

    - 관계형 데이터 베이스 관리 시스템
    - 테이블들의 관계

> 2. RDBMS 구성요소

    - 개체 (Entity : Table)
    - 관계 (RelationShip)
    - 속성 (Attribute : 필드)

    ※ 스키마 - 데이터베이스 구조와 제약조건을 명세정의
        외부스키마 = 사용자뷰
        개념스키마 = 전체적인뷰
        내부스키마 = 저장스키마

    ※ 데이터베이스 설계단계
        #1. 개념적설계 - 요구사항분석 후 개념적 설계 ERD
            (집을어떻게?, 방몇개, 주방어디... 거실은 얼마나 크게)
        #2. 논리적설계 - ERD를 이용하여 데이터베이스 스키마를 설계
            (방 = 테이블 , 사람 = 엔터티, 관계 = 외래키)
        #3. 물리적설계 - 테이블 저장구조 설계 ( mysql,oracle,,,,)
            (실제건축자재로 만들기 - mysql, oracle)

> 3. 데이터베이스 언어

1. DDL = Data Definition Language (데이터 정의어)
   CREATE, ALTER, DROP → CAD
2. DML = Data Manipulation Language (데이터 조작어)
   INSERT, SELECT, UPDATE, DELETE → CRUD
3. DCL = Data Control Language (데이터 제어어)
   GRANT, REVOKE

> 4. [실습] Database 만들기

1. 만들기 : create database db명
2. 확인 : show databases
3. 삭제(복구x) : drop database db명
4. DB 사용 : use db명

1) 접속
   mysql -u root -p
   1234

> 5. [연습]

1. db명 : test , mbasic , db703 3개 db만들기
2. db만들어진것 확인
3. db703 삭제

```mysql
create database  test;
create database  mbasic;
create dadtabase db703;

show databases;

drop database db703;
```

### 3. 테이블

1. RDBMS (Relational Data Management System)

- 관계형 데이터 베이스
- 테이블의 관계
- 속성(필드) 연결

2. 테이블 만들기 (집안의 방, 가방안의 분류표)
   DDL (정의:create, alter, drop), DML(조작:), DCL(제어:)

자료형 : 1. 숫자 : int(정수), double(실수) 2. 문자 : char(고정, 남/여), varchar(가변, abc, abcd, abcde), nvarchar(다국어지원) 3. 날짜 : data, datetime

옵션 :
필수입력 - not null
숫자자동증가 - auto-increment
기본키 - primary key

---

CREATE TABLE table명(
필드1 자료형 옵션,
필드2 자료형 옵션
);

---

[실습1]create table t1(
name varchar(100) not null,
age int
);
show tables; -- 테이블목록확인
desc t1; -- 구조확인

create table t11(
no int not null,
name varchar(30) not null
);

crate table t12(
bookid int not null,
title varchar(100) not null -- 필수입력
);

show tables; -- 테이블목록확인
desc t12; -- 구조확인

※ ERROR 1046(3D000): NO database selected use db명

mssql> show databases;
mssql> use mbasic;
mssql> ststus -- 상태확인

※ 참고사항) not null 필수입력
mysql> insert into t1 (age) values (1);
ERROR 1364 (HY000): Field 'name' doesn't have a default value (값넣어!)

mysql> insert into t1 (name, age) values ('aaa', 1);
Query OK, 1 row affected (0.00 sec)

mysql> insert into t1 (name) values ('bbb');
Query OK, 1 row affected (0.00 sec)

mysql> select \* from t1;
+------+------+
| name | age |
+------+------+
| aaa | 1 |
| bbb | NULL |
+------+------+
2 rows in set (0.00 sec)

[실습2] auto_increment(숫자 자동증가), primary key(기본키)

create table t2(
jumin int not null auto_increment primary key,
name varchar(100) not null,
age int,
);

※ 참고사항)
insert into t2 (name, age) values ('aaa' , 1); -- 숫자자동증가
insert into t2 (name) values ('bbb'); -- 숫자자동증가
insert into t2 (jumin, name, age) values (1 , 'ccc' , 1); -- error 기본키
insert into t2 (jumin, name, age) values (3 , 'ccc' , 1);

mysql> select \* from t2;
+-------+------+------+
| jumin | name | age |
+-------+------+------+
| 1 | aaa | 1 |
| 2 | bbb | NULL |
| 3 | aaa | 1 | <-- aaa, 1 / aaa,1 구분을 해줄수 있는 필드는 jumin 1,3  
+-------+------+------+
2 rows in set (0.00 sec)
