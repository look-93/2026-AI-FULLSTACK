0. SSR vs CSR
1) SSR (Server-Side Rendering)
→ 서버가 완성된 html을 만들어 클라이어트(브라우저)에게 보낸다.
기술스택 : BOOT + security +thymeleaf + oracle + mybatis (backend+frontend)
- 렌더링주체 : 서버
- 초기로딩 : 빠름
- 화면전환 : 새로고림

2) CSR (Client-Side Rendering)
→ 클라이언트(브라우저)가 html + js를 이용해서 화면그리기
기술스택 : node(backend) / react + next (frontend)
- 렌더링주체 : 브라우저
- 초기로딩 : 느림
- 화면전환 : 부드러움

> backend : boot + security + jwt + redis + jpa
> frontend : react + next

### 1. 프로젝트구조
back/
├── config/
│   └── db.js                  # Oracle DB 설정
├── middlewares/
│   └── isAuthenticated.js     # 로그인 인증 미들웨어
├── models/
│   └── users.js               # 사용자 DB 모델 및 쿼리 함수
├── passport/
│   ├── index.js               # Passport 초기화
│   └── local.js               # Local 전략 설정
├── routes/
│   └── user.js                # 사용자 관련 API 라우터
├── node_modules/              # npm 패키지
├── .env                       # 환경변수
├── app.js                     # 서버 진입점
├── package.json               # 프로젝트 설정 및 스크립트
├── package-lock.json          # 패키지 버전 고정
├── test1_model_testUsers.js   # 모델 함수 테스트 스크립트

```
https://nodejs.org/ko
1) 다운로드 및 설치
2) 확인 cmd
```
node -v
npm -v
```
3) 관리자 권한으로 power shell 실행
```

- RemoteSigned : 로컬에서 만든 스크립트 실행가능
```

### 1) 프로젝트만들기
0. 구조확인
```
back/ node
front react + next
```
1. 프로젝트 만들기
```js
npm init
```
2. 실습
```
mkdir back
cd back
npm init
```
### 2) 패키지설치
```
npm install
```
{
  "name": "back",
  "version": "1.0.0",
  "main": "app.js",
  "scripts": {
    "dev": "nodemon app", -- 개발시
    "start": "cross-env NODE_ENV=production pm2 start app.js" -- 운영환경
  },
  "dependencies": {
    "aws-sdk": "^2.710.0",      -- aws 서비스 연동
    "bcrypt": "^5.1.0",         -- 비밀번호 암호화
    "cookie-parser": "^1.4.6",  -- 쿠키 데이터 파싱
    "cors": "^2.8.5",           -- 웹보안정책 cors 
    "cross-env": "^7.0.3",      -- 운영체제별 환경변수 통일
    "dotenv": "^16.3.1",        -- 환경변수 파일관리 (git hub  x)
    "express": "^4.21.2",       -- node.js 웹서버 프레임워크
    "express-session": "^1.17.3", -- 로그인 상태 세션관리
    "helmet": "^7.0.0",         -- 보안관련 http 헤더설정
    "hpp": "^0.2.3",            -- http 파라미터 오염방지 보안
    "morgan": "^1.10.0",        -- 서버 요청 로그기록
    "multer": "^1.4.5-lts.1",   -- 파일업로드 미들웨어
    "oracledb": "^6.4.0",       -- oracle 
    "passport": "^0.7.0",       -- 인증처리
    "passport-local": "^1.0.0", -- 이메일/비번 로그인
    "pm2": "^5.3.0",            -- 서버 무중단 관리
    "swagger-jsdoc": "^6.2.8",  -- api 문서화엔진
    "swagger-ui-express": "^5.0.1"  -- 페이지처리
  },
  "devDependencies": {
    "nodemon": "^3.0.1" -- 개발중에 코드변경 자동반영
  }
}


### 3) 서버진입점
```
back/
├── app.js  #서버 진입점
```

1. app.js
```
```

2.실행
```
npx nodemon app.js
```

브라우저에서 http://localhost:3065

### 2. 개발

### 1) model

back/
├── config/
│   └── db.js                  # Oracle DB 설정
├── models/
│   └── users.js               # 사용자 DB 모델 및 쿼리 함수
├── .env                       # 환경변수
├── test1.js   # 모델 함수 테스트 스크립트

1. id: node / pass: react oracle 유저 만들기
2. appuser 테이블
3. .env
4. [config] - db.js
5. [models] - users.js
6. 모델함수 테스트

### 1. id: node/ pass: react oracle 유저만들기
``` sql
-- cmd
-- sqlplus
-- conn system/1234

-- 유저만들기 ( 오라클 12 이상에서 기존방식으로 사용자 생성 허용 )
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
create user node  identified by react;

-- 권한부여
grant  connect , resource  to node;

ALTER USER node DEFAULT TABLESPACE users QUOTA UNLIMITED ON users;    -- 물리적공간이용
grant  create table to node;
```
### 2. appuser 테이블
```
conn node/react 연결확인

DROP  TABLE APPUSER  CASCADE CONSTRAINTS;

CREATE TABLE APPUSER (
    APP_USER_ID     NUMBER NOT NULL,
    EMAIL           VARCHAR2(255) NOT NULL UNIQUE,
    PASSWORD        VARCHAR2(255) NOT NULL,
    NICKNAME        VARCHAR2(100),
    MOBILE          VARCHAR2(20),
    MBTI_TYPE_ID    NUMBER,
    UFILE           VARCHAR2(255),
    CREATED_AT      DATE DEFAULT SYSDATE,
    CONSTRAINT PK_APPUSER PRIMARY KEY (APP_USER_ID)
);

CREATE SEQUENCE APPUSER_SEQ;
```

### 3. .env 설정
```
# 세션쿠키 암호화 키
COOKIE_SECRET=appsecret

# Oracle DB 접속 정보
DB_USER=node
DB_PASSWORD=react
DB_CONNECT=localhost:1521/XE
```

### 4. [config] - db.js
``` env에서 설정한 값과 매핑
require(`dotenv`).config();

module.exports={
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD ,
    connectString: process.env.DB_CONNECT
};
```

### 5. [models] - users.js
### 1. 사용자 등록 (Create - Insert)

INSERT INTO appuser (
    APP_USER_ID,     EMAIL,     PASSWORD,  NICKNAME,    MOBILE,    MBTI_TYPE_ID,    UFILE,    CREATED_AT
) VALUES (
    APPUSER_SEQ.NEXTVAL ,  :email,    :password,   :nickname,     :mobile,   :mbtiTypeId,     :ufile,    SYSDATE
)

### 2. 사용자 조회 (Email 기준)

이메일을 사용해 특정 사용자의 상세 정보를 조회합니다.

```sql
SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
FROM appuser 
WHERE EMAIL = :email

```

### 3. 사용자 조회 (ID 기준)

기본 키(PK)인 `APP_USER_ID`를 사용해 특정 사용자의 상세 정보를 조회합니다.

```sql
SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
FROM appuser 
WHERE APP_USER_ID = :id

```

### 4. 로그인 & 로그아웃

* **로그인 (비밀번호 제외 조회):** 보안상 DB 내에서 비밀번호 비교 처리를 하는 것보다, 이메일로 사용자 정보와 암호화된 `PASSWORD` 필드를 함께 가져와 애플리케이션(Node.js/Spring 등) 단에서 비밀번호 검증을 수행하는 것이 안전하고 일반적입니다.
* **로그아웃:** 로그아웃은 보통 데이터베이스를 직접 조회하거나 수정하지 않고, 
**애플리케이션 세션(Session)을 만료**시키거나 **JWT 토큰을 삭제/무효화**하는 방식으로 처리하므로 별도의 SQL 구문이 필요하지 않습니다.

### 5. 전체 사용자 조회 (Read All)
```sql
SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
FROM appuser 
ORDER BY CREATED_AT DESC

```

### 6. 닉네임 수정 (Update Nickname)
```sql
UPDATE appuser 
SET NICKNAME = :nickname 
WHERE APP_USER_ID = :nickname

```

### 7. 사용자 삭제 (Delete)
```sql
DELETE FROM appuser 
WHERE APP_USER_ID = :id;

```
### 8. 닉네임 조회

특정 닉네임을 가진 사용자가 있는지 조회합니다. (주로 회원가입 시 **닉네임 중복 체크** 용도로 사용됩니다.)

```sql
SELECT APP_USER_ID, EMAIL, NICKNAME 
FROM appuser 
WHERE NICKNAME = :nickname

```

### 6. 모델함수 테스트


### 2) controller
back/
├── middlewares/
│   └── isAuthenticated.js     # 로그인 인증 미들웨어
├── passport/
│   ├── index.js               # Passport 초기화
│   └── local.js               # Local 전략 설정
├── routes/
│   └── user.js                # 사용자 관련 API 라우터 
├── app.js

1. [routers] - user.js
```
주소경로
post : /user/register (requestBody)
post : /user/login    (requestBody)
post : /user/logout   
get  : /user/
patch: /user/{id}/nickname
※비교  /user/nickname?id=1
delete: /user/{id}

```

patch: /user/{id}/nickname  ← rest 방식                 - 데이터접근방식 : url 자원소스가 포함
※비교  /user/nickname?id=1  ← queryString (쿼리스트링)  - 데이터접근방식 : url ?key=value

http 표준프로토콜 사용
- GET(조회), POST(생성), PUT/PATCH(수정), DELETE(삭제)

``` 경로설정 app.js
const userRouter = require('./routes/user'); //user
app.use('/user', userRouter);

```
2. app.js
```
const  express = require('express');
const dotenv = require('dotenv');
const morgan = require('morgan');
const cors = require('cors');
const  swaggerUi    = require('swagger-ui-express'); 
const  swaggerJsdoc = require('swagger-jsdoc');
const  userRouter = require('./routes/user');  
//const  postRouter = require('./routes/post');
//////////////////////////////////////////////////////////

dotenv.config();
const  app = express();
app.use(express.json());
app.use(express.urlencoded({extended: true}));
app.use(cors());
app.use( morgan('dev'));
const swaggerOptions = {
  definition: {
    openapi: '3.0.0',   
    info: {
      title: 'User API',    
      version: '1.0.0',      
      description: '회원가입, 로그인, 사용자 조회/수정/삭제 API 문서', //설명
    },
  },
  apis: ['./routes/*.js'],  
}; 
const swaggerSpecs = swaggerJsdoc(swaggerOptions);

////////////////////////////////////////////////////////// 
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpecs));
app.use('/user' , userRouter)   
app.get('/' , (req, res)=>{    res.send('hello express');   }); 
const PORT = process.env.PORT || 3065;
app.listen(  3065 , ()=>{
    console.log(`✅ 서버 실행중!   http://localhost:${PORT}`);
    console.log(`✅ Swagger UI :  http://localhost:${PORT}/api-docs`);
}); 
 

```
3. [passport] - index.js / local.js
4. [middlewares] - isAuthenticated.js
