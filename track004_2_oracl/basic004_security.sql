desc appuser;
desc authorities;

--SQL> desc appuser;
--Name                                      Null?    Type
------------------------------------------- -------- ----------------------------
--APP_USER_ID                               NOT NULL NUMBER(5)
--EMAIL                                     NOT NULL VARCHAR2(100)
--PASSWORD                                           VARCHAR2(100)
--MBTI_TYPE_ID                                       NUMBER(3)
--CREATED_AT                                         DATE
--UFILE                                              VARCHAR2(255)
--MOBILE                                             VARCHAR2(50)
--NICKNAME                                           VARCHAR2(50)
--PROVIDER                                  NOT NULL VARCHAR2(50)
--PROVIDER_ID                                        VARCHAR2(100)
--
--SQL> desc authorities;
-- Name                                      Null?    Type
-- ----------------------------------------- -------- ----------------------------
-- AUTH_ID                                   NOT NULL NUMBER(5)
-- EMAIL                                              VARCHAR2(255)
-- AUTH                                      NOT NULL VARCHAR2(255)
-- APP_USER_ID                                        NUMBER(5)
--
--SQL>

CREATE TABLE APPUSER (
    APP_USER_ID   NUMBER(5)       CONSTRAINT PK_APPUSER PRIMARY KEY,
    EMAIL         VARCHAR2(100)   CONSTRAINT NN_APPUSER_EMAIL NOT NULL,
    PASSWORD      VARCHAR2(100),
    MBTI_TYPE_ID  NUMBER(3),
    CREATED_AT    DATE default sysdate,
    UFILE         VARCHAR2(255),
    MOBILE        VARCHAR2(50),
    NICKNAME      VARCHAR2(50),
    PROVIDER      VARCHAR2(50)    CONSTRAINT NN_APPUSER_PROVIDER NOT NULL,
    PROVIDER_ID   VARCHAR2(100)
);
create sequence appuser_seq;

  
CREATE TABLE AUTHORITIES (
    AUTH_ID      NUMBER(5)        CONSTRAINT PK_AUTHORITIES PRIMARY KEY,
    EMAIL        VARCHAR2(255),
    AUTH         VARCHAR2(255)    CONSTRAINT NN_AUTHORITIES_AUTH NOT NULL,
    APP_USER_ID  NUMBER(5)
);
create sequence authorities_seq;

--    1) 회원가입
    insert into APPUSER(APP_USER_ID, EMAIL, PASSWORD, MBTI_TYPE_ID, CREATED_AT, UFILE, MOBILE, NICKNAME, PROVIDER, PROVIDER_ID)
    values(appuser_seq.nextval, 'first@gmail.com', '11', 1, sysdate, '1.png', '0100000000', 'd', 'the703', 't7-1');
--    2) 로그인
--    - 이메일로 이메일, 비밀번호, 권한
    select u.email, u.password, a.auth
      from APPUSER           u
      left join AUTHORITIES  a on a.EMAIL = u.EMAIL
     where u.email = 'first@gmail.com';
 
--    3) 이메일로 유저잦기
    select * from APPUSER where email = 'first@gmail.com';
--    4) 이메일로 중복검사
    select count(*) from APPUSER where email = 'first@gmail.com';
--    5) 회원수정
    update APPUSER
    set PASSWORD = '22',
        MBTI_TYPE_ID = 2,
        UFILE = '2.png',
        NICKNAME = 'second',
        MOBILE = '0102222222', 
        PROVIDER = 'naver',
        PROVIDER_ID = 'n-1'
    where APP_USER_ID = 3;

--    6) 회원삭제
    delete from APPUSER where APP_USER_ID = 3;
--    7) 권한삽입
    insert into AUTHORITIES(AUTH_ID, EMAIL, AUTH)
    values(authorities_seq.nextval, 'first@gmail.com', 'ROLE_MEMBER');
--    8) 권한삭제
    delete from AUTHORITIES where email = 'first@gmail.com';
