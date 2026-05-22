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

desc mvcboard1;
select*from mvcboard1;

insert into mvcboard1 (bname, bpass, bcontent,bhit,bip) values ("1", "1" , "1",1,"dd");
insert into mvcboard1 (bname, bpass, bcontent,bhit,bip) values ("2", "2" , "2",2,"dd");
select * from mvcboard1 order by bno desc;

show tables;