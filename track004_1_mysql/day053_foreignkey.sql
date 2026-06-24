use mbasic;
desc t1;
desc t2;
-- (1)부모테이블
create table t1(
no int not null primary key auto_increment,
name varchar(100) null 
);

-- (2)자식테이블
create table t2(
ino int not null primary key,
foreign key(ino) references t1(no)
); -- 외래키(ino) 참고테이블 t1(no필드)

-- (3)t1에서 no는 1,2 부모의 값이 : 1,2
insert into t1 value(1,"first");
insert into t1 value(2,"second");

-- (4) 다음에서 오류나는 코드?
insert into t2(ino) values (1);
insert into t2(ino) values (3); -- 부모가 3이없어 오류
-- 0	27	15:52:50	insert into t2(ino) values (3)	
-- Error Code: 1452. Cannot add or update a child row: 
-- a foreign key constraint fails (`mbasic`.`t2`, CONSTRAINT `t2_ibfk_1` FOREIGN KEY (`ino`) REFERENCES `t1` (`no`))	0.000 sec


-- (5)부모테이블 
create table t3(
no int not null primary key auto_increment,
name varchar(100) null 
);

-- (6)자식테이블
create table t4(
ino int not null primary key,
foreign key(ino) references t3(no) on delete cascade on update cascade
); -- 외래키(ino) 참고테이블 t3(no필드)

-- (7)
insert into t3 (no, name) values(1,'first');
insert into t3 (no, name) values(2,'second');
insert into t4 (ino) values(2);

-- (8) 부모수정시 자식값들도 수정, 부모삭제시 자식값들도 삭제 확인
  update  t3  set  no=20   where no=2;   
  select * from t3;
  select * from t4;  
  
  delete  from t3  where no=20; 
  select * from t3;
  select * from t4;    
