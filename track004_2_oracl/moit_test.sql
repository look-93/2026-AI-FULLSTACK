create table member_type(
    member_type_id number primary key,
    type_name varchar2(30) unique not null
);


insert into member_type(member_type_id,type_name) values(1,'ROLE_MEMBER'); -- 유저
insert into member_type(member_type_id,type_name) values(2,'ROLE_PARTNER'); -- 제휴업체
insert into member_type(member_type_id,type_name) values(3,'ROLE_ADMIN'); -- 관리자
insert into member_type(member_type_id,type_name) values(4,'ROLE_SUPERADMIN'); -- 최고 관리자


create table member_status(
    status_id number primary key,
    status_name varchar2(30) unique not null
);

insert into member_status (status_id , status_name) values(1,'ACTIVE'); -- 활성화
insert into member_status (status_id , status_name) values(2,'PENDING'); -- 대기중
insert into member_status (status_id , status_name) values(3,'SUSPENDED'); -- 거절
insert into member_status (status_id , status_name) values(4,'DELETED'); -- 정지

create table reports_status(
    reports_status_id number primary key,
    status_name varchar2(30) unique not null
);

insert into reports_status (reports_status_id , status_name) values(1,'ACTIVE'); -- 정상
insert into reports_status (reports_status_id , status_name) values(2,'WARNING'); -- 주의
insert into reports_status (reports_status_id , status_name) values(3,'SUSPENDED'); -- 정지

create table members(
    member_id number primary key,
    login_id varchar2(50) unique not null,
    mobile varchar2(20) unique not null,
    nickname varchar2(50) unique not null,
    email varchar2(100) unique not null,
    password varchar2(255) unique not null,
    profile_url varchar2(500),
    member_type_id number not null,
    status_id number not null,
    report_status_id number, -- 신고 상태 id
    created_at date default sysdate not null,
    update_at date default sysdate not null,
    delete_yn char(1) default 'N' not null,
    gender char(1) not null, -- 성별
    birth date not null, -- 생년월일
    point number default 0 not null, -- 보유 포인트
    trust_score number default 100 not null, -- 신뢰도 점수
    login_ip varchar2(50), -- 현재 로그인 IP

    constraint fk_member_type
        foreign key(member_type_id)
        references member_type(member_type_id),

    constraint fk_member_status
        foreign key(status_id)
        references member_status(status_id),

    constraint fk_report_status
        foreign key(report_status_id)
        references reports_status(reports_status_id)    
);

create table point_history( -- 포인트 사용 내역
    history_id number primary key, 
    member_id number not null,
    point_pm number not null, -- 포인트 증감
    point_type varchar2(30) not null, -- 포인트 사용 타입 (USE,SAVE,BONUS 등)
    point_reason varchar2(100) not null, -- 포인트 사용 내용(회원가입 이벤트, 출석체크 등)
    created_at date default sysdate,

    constraint fk_point_member
        foreign key(member_id)
        references members(member_id)
);


INSERT INTO members (
    member_id, login_id, mobile, nickname, email, password,
    profile_url, member_type_id, status_id, report_status_id,
    created_at, update_at, delete_yn, gender, birth,
    point, trust_score, login_ip
) VALUES (
    1,
    'hong123',
    '01012345678',
    '홍길동',
    'hong@example.com',
    '$2a$10$passwordHash1',
    'https://example.com/profile/hong.jpg',
    1,
    1,
    NULL,
    SYSDATE,
    SYSDATE,
    'N',
    'M',
    TO_DATE('1995-03-15','YYYY-MM-DD'),
    1200,
    100,
    '192.168.0.10'
);

INSERT INTO members (
    member_id, login_id, mobile, nickname, email, password,
    profile_url, member_type_id, status_id, report_status_id,
    created_at, update_at, delete_yn, gender, birth,
    point, trust_score, login_ip
) VALUES (
    2,
    'kim456',
    '01023456789',
    '김영희',
    'kim@example.com',
    '$2a$10$passwordHash2',
    'https://example.com/profile/kim.jpg',
    1,
    1,
    NULL,
    SYSDATE,
    SYSDATE,
    'N',
    'F',
    TO_DATE('1998-07-20','YYYY-MM-DD'),
    800,
    98,
    '192.168.0.11'
);

INSERT INTO members (
    member_id, login_id, mobile, nickname, email, password,
    profile_url, member_type_id, status_id, report_status_id,
    created_at, update_at, delete_yn, gender, birth,
    point, trust_score, login_ip
) VALUES (
    3,
    'park789',
    '01034567890',
    '박철수',
    'park@example.com',
    '$2a$10$passwordHash3',
    NULL,
    2,
    1,
    NULL,
    SYSDATE,
    SYSDATE,
    'N',
    'M',
    TO_DATE('1992-11-08','YYYY-MM-DD'),
    3500,
    95,
    '192.168.0.12'
);

INSERT INTO members (
    member_id, login_id, mobile, nickname, email, password,
    profile_url, member_type_id, status_id, report_status_id,
    created_at, update_at, delete_yn, gender, birth,
    point, trust_score, login_ip
) VALUES (
    4,
    'lee111',
    '01045678901',
    '이수진',
    'lee@example.com',
    '$2a$10$passwordHash4',
    'https://example.com/profile/lee.jpg',
    1,
    2,
    1,
    SYSDATE,
    SYSDATE,
    'N',
    'F',
    TO_DATE('2000-01-30','YYYY-MM-DD'),
    500,
    85,
    '192.168.0.13'
);

INSERT INTO members (
    member_id, login_id, mobile, nickname, email, password,
    profile_url, member_type_id, status_id, report_status_id,
    created_at, update_at, delete_yn, gender, birth,
    point, trust_score, login_ip
) VALUES (
    5,
    'choi999',
    '01056789012',
    '최민수',
    'choi@example.com',
    '$2a$10$passwordHash5',
    NULL,
    1,
    1,
    NULL,
    SYSDATE,
    SYSDATE,
    'N',
    'M',
    TO_DATE('1997-09-12','YYYY-MM-DD'),
    2000,
    92,
    '192.168.0.14'
);

COMMIT;




CREATE TABLE meetups (
    meetup_id          NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    member_id          NUMBER NOT NULL,
    title              VARCHAR2(100) NOT NULL,
    content            CLOB NOT NULL,
    max_participants   NUMBER NOT NULL,
    min_participants   NUMBER NOT NULL,
    sigungu_id         NUMBER NOT NULL,
    category_id        NUMBER NOT NULL,
    address            VARCHAR2(255),
    address_detail     VARCHAR2(255), -- 상세 주소
    meetup_at          DATE NOT NULL,

    status             VARCHAR2(20) DEFAULT 'RECRUITING' NOT NULL,

    latitude           NUMBER(10,7), -- 위도
    longitude          NUMBER(11,7), -- 경도    
    weather_status     VARCHAR2(20), -- 감지된 날씨
    rain_probability   NUMBER(3), -- 감지된 강수확률 (0~100)

    delete_yn          CHAR(1) DEFAULT 'N' NOT NULL,
    created_at         DATE DEFAULT SYSDATE NOT NULL,
    updated_at         DATE DEFAULT SYSDATE NOT NULL);
    
    
    INSERT INTO meetups (
    member_id, title, content,
    max_participants, min_participants,
    sigungu_id, category_id,
    address, address_detail,
    meetup_at, status,
    latitude, longitude,
    weather_status, rain_probability,
    delete_yn, created_at, updated_at
) VALUES (
    1,
    '한강 러닝 크루 모집',
    '저녁에 한강에서 함께 5km 러닝하실 분 모집합니다.',
    10,
    3,
    101,
    1,
    '서울특별시 영등포구 여의동',
    '여의나루역 2번 출구',
    TO_DATE('2026-07-10 19:00','YYYY-MM-DD HH24:MI'),
    'RECRUITING',
    37.5270000,
    126.9320000,
    'SUNNY',
    10,
    'N',
    SYSDATE,
    SYSDATE
);

INSERT INTO meetups (
    member_id, title, content,
    max_participants, min_participants,
    sigungu_id, category_id,
    address, address_detail,
    meetup_at, status,
    latitude, longitude,
    weather_status, rain_probability,
    delete_yn, created_at, updated_at
) VALUES (
    2,
    '보드게임 모임',
    '초보도 환영합니다. 다양한 보드게임을 함께 즐겨요.',
    8,
    4,
    102,
    2,
    '서울특별시 강남구 역삼동',
    '역삼역 인근 카페',
    TO_DATE('2026-07-12 14:00','YYYY-MM-DD HH24:MI'),
    'RECRUITING',
    37.5005000,
    127.0360000,
    'CLOUDY',
    30,
    'N',
    SYSDATE,
    SYSDATE
);

INSERT INTO meetups (
    member_id, title, content,
    max_participants, min_participants,
    sigungu_id, category_id,
    address, address_detail,
    meetup_at, status,
    latitude, longitude,
    weather_status, rain_probability,
    delete_yn, created_at, updated_at
) VALUES (
    3,
    '맛집 탐방',
    '홍대 유명 맛집을 함께 돌아다니며 식사해요.',
    6,
    2,
    103,
    3,
    '서울특별시 마포구 홍익로',
    '홍대입구역 9번 출구',
    TO_DATE('2026-07-15 18:30','YYYY-MM-DD HH24:MI'),
    'RECRUITING',
    37.5563000,
    126.9237000,
    'RAIN',
    80,
    'N',
    SYSDATE,
    SYSDATE
);

INSERT INTO meetups (
    member_id, title, content,
    max_participants, min_participants,
    sigungu_id, category_id,
    address, address_detail,
    meetup_at, status,
    latitude, longitude,
    weather_status, rain_probability,
    delete_yn, created_at, updated_at
) VALUES (
    4,
    '등산 같이 가요',
    '주말 아침 북한산 등산 멤버 모집합니다.',
    12,
    5,
    104,
    4,
    '서울특별시 은평구',
    '북한산성 입구',
    TO_DATE('2026-07-18 08:00','YYYY-MM-DD HH24:MI'),
    'CLOSED',
    37.6586000,
    126.9779000,
    'SUNNY',
    5,
    'N',
    SYSDATE,
    SYSDATE
);

INSERT INTO meetups (
    member_id, title, content,
    max_participants, min_participants,
    sigungu_id, category_id,
    address, address_detail,
    meetup_at, status,
    latitude, longitude,
    weather_status, rain_probability,
    delete_yn, created_at, updated_at
) VALUES (
    5,
    '영화 함께 보기',
    '최신 영화 관람 후 카페에서 이야기 나눠요.',
    5,
    2,
    105,
    5,
    '서울특별시 송파구',
    '롯데월드몰 5층',
    TO_DATE('2026-07-20 19:30','YYYY-MM-DD HH24:MI'),
    'RECRUITING',
    37.5133000,
    127.1028000,
    'CLOUDY',
    20,
    'N',
    SYSDATE,
    SYSDATE
);

COMMIT;


CREATE TABLE meetup_applications (
    application_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    meetup_id      NUMBER NOT NULL,
    member_id      NUMBER NOT NULL,
    status         VARCHAR2(30) DEFAULT 'PENDING' NOT NULL,
    reject_reason  VARCHAR2(255),
    delete_yn      CHAR(1) DEFAULT 'N' NOT NULL,
    created_at     DATE DEFAULT SYSDATE NOT NULL,
    updated_at     DATE DEFAULT SYSDATE NOT NULL);
    
    
INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    1, 2, 'APPROVED', NULL,
    'N', SYSDATE, SYSDATE
);

INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    1, 3, 'PENDING', NULL,
    'N', SYSDATE, SYSDATE
);

INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    2, 1, 'APPROVED', NULL,
    'N', SYSDATE, SYSDATE
);

INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    2, 4, 'REJECTED', '모집 조건에 맞지 않습니다.',
    'N', SYSDATE, SYSDATE
);

INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    3, 2, 'APPROVED', NULL,
    'N', SYSDATE, SYSDATE
);

INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    3, 5, 'PENDING', NULL,
    'N', SYSDATE, SYSDATE
);

INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    4, 1, 'APPROVED', NULL,
    'N', SYSDATE, SYSDATE
);

INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    4, 3, 'CANCELED', NULL,
    'N', SYSDATE, SYSDATE
);

INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    5, 2, 'PENDING', NULL,
    'N', SYSDATE, SYSDATE
);

INSERT INTO meetup_applications (
    meetup_id, member_id, status, reject_reason,
    delete_yn, created_at, updated_at
) VALUES (
    5, 4, 'APPROVED', NULL,
    'N', SYSDATE, SYSDATE
);

COMMIT;    


CREATE TABLE meetup_likes (
    meetup_id NUMBER NOT NULL,
    member_id NUMBER NOT NULL);
    
    
INSERT INTO meetup_likes (meetup_id, member_id) VALUES (1, 2);
INSERT INTO meetup_likes (meetup_id, member_id) VALUES (1, 3);
INSERT INTO meetup_likes (meetup_id, member_id) VALUES (1, 5);

INSERT INTO meetup_likes (meetup_id, member_id) VALUES (2, 1);
INSERT INTO meetup_likes (meetup_id, member_id) VALUES (2, 4);

INSERT INTO meetup_likes (meetup_id, member_id) VALUES (3, 1);
INSERT INTO meetup_likes (meetup_id, member_id) VALUES (3, 2);
INSERT INTO meetup_likes (meetup_id, member_id) VALUES (3, 4);

INSERT INTO meetup_likes (meetup_id, member_id) VALUES (4, 2);
INSERT INTO meetup_likes (meetup_id, member_id) VALUES (4, 5);

INSERT INTO meetup_likes (meetup_id, member_id) VALUES (5, 1);
INSERT INTO meetup_likes (meetup_id, member_id) VALUES (5, 3);

COMMIT;    



CREATE TABLE sidos (
    sido_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name    VARCHAR2(100) NOT NULL
);

CREATE TABLE sigungus (
    sigungu_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sido_id    NUMBER NOT NULL,
    name        VARCHAR2(100) NOT NULL);

CREATE TABLE categories (
    category_id   NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    parent_id     NUMBER,
    category_name VARCHAR2(100) NOT NULL);
    
    
INSERT INTO sidos (name) VALUES ('서울특별시');
INSERT INTO sidos (name) VALUES ('경기도');
INSERT INTO sidos (name) VALUES ('인천광역시');

COMMIT;    

INSERT INTO sigungus (sido_id, name) VALUES (1, '강남구');
INSERT INTO sigungus (sido_id, name) VALUES (1, '마포구');
INSERT INTO sigungus (sido_id, name) VALUES (1, '송파구');
INSERT INTO sigungus (sido_id, name) VALUES (2, '성남시');
INSERT INTO sigungus (sido_id, name) VALUES (2, '수원시');
INSERT INTO sigungus (sido_id, name) VALUES (3, '연수구');
INSERT INTO sigungus (sido_id, name) VALUES (3, '남동구');

COMMIT;

INSERT INTO categories (parent_id, category_name) VALUES (NULL, '운동');
INSERT INTO categories (parent_id, category_name) VALUES (NULL, '맛집');
INSERT INTO categories (parent_id, category_name) VALUES (NULL, '문화');
INSERT INTO categories (parent_id, category_name) VALUES (NULL, '여행');
INSERT INTO categories (parent_id, category_name) VALUES (NULL, '스터디');

-- 운동
INSERT INTO categories (parent_id, category_name) VALUES (1, '러닝');
INSERT INTO categories (parent_id, category_name) VALUES (1, '등산');
INSERT INTO categories (parent_id, category_name) VALUES (1, '헬스');

-- 맛집
INSERT INTO categories (parent_id, category_name) VALUES (2, '카페');
INSERT INTO categories (parent_id, category_name) VALUES (2, '한식');
INSERT INTO categories (parent_id, category_name) VALUES (2, '양식');

-- 문화
INSERT INTO categories (parent_id, category_name) VALUES (3, '영화');
INSERT INTO categories (parent_id, category_name) VALUES (3, '전시회');
INSERT INTO categories (parent_id, category_name) VALUES (3, '공연');

-- 여행
INSERT INTO categories (parent_id, category_name) VALUES (4, '당일치기');
INSERT INTO categories (parent_id, category_name) VALUES (4, '캠핑');

-- 스터디
INSERT INTO categories (parent_id, category_name) VALUES (5, 'IT');
INSERT INTO categories (parent_id, category_name) VALUES (5, '영어');
INSERT INTO categories (parent_id, category_name) VALUES (5, '독서');

COMMIT;