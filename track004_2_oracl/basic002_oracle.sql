
--SQL> desc  sboard2;
-- 이름                                         널?      유형
-- ----------------------------------------- -------- ----------------------------
-- ID                                        NOT NULL NUMBER
-- APP_USER_ID                          NOT NULL NUMBER
-- BTITLE                                   NOT NULL VARCHAR2(1000)
-- BCONTENT                             NOT NULL CLOB
-- BPASS                                   NOT NULL VARCHAR2(255)
-- BFILE                                                   VARCHAR2(255)
-- BHIT                                                    NUMBER
-- BIP                                       NOT NULL VARCHAR2(255)
-- CREATED_AT                                          DATE
-- 

create table sboard2(
 ID             NUMBER NOT NULL ,
 APP_USER_ID    NUMBER NOT NULL ,
 BTITLE         VARCHAR2(1000) NOT NULL ,
 BCONTENT       CLOB NOT NULL ,
 BPASS          VARCHAR2(255) NOT NULL ,
 BFILE          VARCHAR2(255) default 'the703.png',
 BHIT           NUMBER  default 0,
 BIP            VARCHAR2(255) NOT NULL ,
 CREATED_AT     DATE default sysdate
);

create sequence sboard2_seq;

	   insert into sboard2 (id, APP_USER_ID, btitle, BPASS, bcontent, bip)
	   values(sboard2_seq.nextval, 1, '111', '11', '1111', '1')

select * from sboard2

