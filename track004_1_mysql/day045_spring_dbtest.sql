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
alter table userinfo_e change name email varchar(100) not null ;
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

use mbasic;
CREATE TABLE mvcboard2 (
    bno INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    bname VARCHAR(20) NOT NULL,
    bpass VARCHAR(50) NOT NULL,
    btitle VARCHAR(1000) NOT NULL,
    bcontent TEXT NOT NULL,
    bdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    bhit INT NOT NULL DEFAULT 0,
    bip VARCHAR(50) NOT NULL
);


desc mvcboard2;
select*from mvcboard2;

select bname, bpass, btitle, bcontent, bip, bfile from mvcboard2;

alter table mvcboard2 add bfile varchar(500) null default "the703.png";

insert into mvcboard2(bname, bpass, btitle, bcontent, bip, bfile) 
select bname, bpass, btitle, bcontent, bip, bfile from mvcboard2;

select count(*) as cnt from mvcboard2;

select * from mvcboard2 order by bno desc limit 10 ;
