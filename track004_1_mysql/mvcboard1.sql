create table mvcboard1(
	bno int not null primary key auto_increment,
    bname varchar(200) not null,
    bpass varchar(50) not null,
    btitle varchar(1000),
    bcontent text not null,
    bdate timestamp default current_timestamp,
    bhit int not null default 0,
    bip varchar(50) not null
);
delete from mvcboard1;
desc mvcboard1;
select*from mvcboard1;

insert into mvcboard1 (bname, bpass, bcontent,bhit,bip) values ("1", "1" , "1",1,"dd");
insert into mvcboard1 (bname, bpass, bcontent,bhit,bip) values ("2", "2" , "2",2,"dd");
select * from mvcboard1 order by bno desc;
select * from mvcboard1 where bno=5;
show tables;

use mbasic;

select bno as bno, 
b.*,
row_number() over(order by b.bno) as orderNum,
(select count(*) from mvcboard1) as cnt

from   mvcboard1 as b
order by bno desc;

-- +----------+--------------+------+-----+-------------------+-------------------+
-- | Field    | Type         | Null | Key | Default           | Extra             |
-- +----------+--------------+------+-----+-------------------+-------------------+
-- | uno      | int          | NO   | PRI | NULL              | auto_increment    |
-- | nickname | varchar(20)  | NO   |     | NULL              |                   |
-- | bpass    | varchar(50)  | NO   |     | NULL              |                   |
-- | email    | varchar(100) | NO   |     | NULL              |                   |
-- | mobile   | varchar(50)  | NO   |     | NULL              |                   |
-- | udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | bip      | varchar(50)  | NO   |     | NULL              |                   |
-- +----------+--------------+------+-----+-------------------+-------------------+

desc users;

create table users(
uno int not null primary key auto_increment,
nickname varchar(20) not null,
bpass varchar(50) not null,
email varchar(100) not null,
mobile varchar(50) not null,
udate  timestamp  not null default  CURRENT_TIMESTAMP,
bip varchar(50 )not null
);
select*From users;
-- 회원가입
-- insert into users (nickname, bpass, email, mobile) value(?,?,?,?,?);
select * from users where email= 'dd@dd3' and bpass = 3;
-- 로그인
-- select * from users where email= ? and bpass = ?