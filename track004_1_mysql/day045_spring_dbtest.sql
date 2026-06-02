-- use mbasic;
-- desc userinfo;

-- >1. 테이블 만들기
-- mysql> desc userinfo_e;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | email | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | YES  |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.01 sec) 

-- desc userinfo_e;
-- create table userinfo_e select * from userinfo where 1=2;
-- alter table userinfo_e modify no int not null primary key auto_increment;

-- >2. crud - insert, select, update, delete
-- insert : 
insert into userinfo_e(email,age) values (?,?);
-- select (전체):
select* from userinfo_e;
-- select (해당번호의 읽기):
select * from userinfo_e where no = ?;
-- update (해당번호 수정) : 
update userinfo_e
set name = ?,
	age = ?
where no = ?;
-- delete (해당번호 삭제) : 
delete from userinfo_e where no = ?;

