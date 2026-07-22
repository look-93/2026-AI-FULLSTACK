/*************
 * routes-user.js
 -----------------
 * 사용자관련 API 라우터
*************/
// 1. require
const express = require(`express`);
const passport = require(`passport`); // ## passport
const {createUser, findUserByEmail, findUserById, 
       verifyUser, getAllUsers, updateUserNickname, 
       deleteUser, findUserByNickname
    } = require('../models/users');
const isAuthenticated = require('../middlewares/isAuthenticated'); //## 미들웨어
const router = express.Router();

// 2. 부품
///user - > app.js에서 설정해줌 : 아래는 /user뒤에 경로만 적어주기
// post : /user/register (requestBody) 회원가입
/**
*  @swagger
*  /user/register:
*    post:
*      summary: 회원가입
*      description: 새로운 사용자를 등록합니다.
*      requestBody:
*        required: true
*        content:
*          application/json:
*            schema:
*              type: object
*              properties:
*                email: {type: string}
*                password: {type: string}
*                nickname: {type: string}
*                mobile: {type: string}
*                mbtiTypeId: {type: integer}
*                ufile: {type: string}
*      responses:
*        200:
*          description: 회원가입성공
*/

router.post('/register', async(req, res)=>{
    try{
        const {email, password, nickname, mobile, mbtiTypeId, ufile} = req.body;
        await createUser(email, password, nickname, mobile, mbtiTypeId, ufile);
        res.status(201).json({message:'회원가입성공'}) //200 ok , 201 created
    }catch(err){
        console.err('register', err);
        res.status(500).json({message:'회원가입실패'});
    }
});

// post : /user/login    (requestBody) 로그인
/**
*  @swagger
*  /user/login:
*    post:
*      summary: 로그인
*      description: Passport를 이용해 이메일과 비밀번호를 인증하고, 로그인 성공 시 세션을 생성한 후 사용자 정보를 반환합니다.
*      requestBody:
*        required: true
*        content:
*          application/json:
*            schema:
*              type: object
*              properties:
*                email: {type: string}
*                password: {type: string}
*      responses:
*        200:
*          description: 로그인
*/
router.post('/login', (req, res, next) => {
    passport.authenticate('local', (err, user, info) => { //err, 성공시반환된 사용자객체, 실패에러
        // 인증 중 에러
        if (err) return next(err);

        // 로그인 실패
        if (!user) {
            return res.status(401).json({
                message: info?.message || '로그인 실패'
            });
        }

        // 세션 로그인
        req.login(user, (loginErr) => { // passport 가 제공해주는 함수 , 인증된 사용자객체를 세션에 저장하는 과정
            // serializeUser 호출되면 세션에 저장, 실행 deserializeUser, req.user 사용자 객체 복원
            if (loginErr) return next(loginErr);

            const { password , PASSWORD, ...safeUser } = user; // db에서 가져온 사용자객체를 password 필드제거
            //       뺼 필드,     나머지 속성들 그대로
            
            return res.status(200).json({
                message: '로그인 성공',
                user: safeUser
            });
        });
    })(req, res, next);
});

// post : /user/logout   로그아웃
// post : /user/login    (requestBody) 로그인
/**
*  @swagger
*  /user/logout:
*    post:
*      summary: passport 로그아웃
*      description: 세션/쿠키 없이 단순 응답반환(passport 미적용).
*      responses:
*        200:
*          description: 로그아웃(테스트용)
*/
router.post('/logout', (req, res)=>{
    req.logout((err)=>{
        if(err) return res.status(500).json({message: '로그아웃 실패'});
        req.session.destroy(()=>{
            res.clearCookie('connect.sid')
            res.json({message: '로그아웃 성공'});
        });
    });
});

// get  : /user/ 전체사용자조회
/**
*  @swagger
*  /user/:
*    get:
*      summary: 전체 사용자조회
*      description: 로그인된 전체사용자 목록을 조회할 수 있습니다.
*      responses:
*        200:
*          description: 사용자 목록 반환
*        401:
*          description: 인증 필요
*/

router.get('/', async(req, res)=>{
    try{
        const users = await getAllUsers();
        res.json(users);
    }catch(err){
        console.err('getAllUsers', err);
        res.status(500).json({message:'사용자 조회 실패'});
    }

});

// patch: /user/{id}/nickname 닉네임수정
/**
*  @swagger
*  /user/{id}/nickname:
*    patch:
*      summary: 닉네임 수정
*      description: 특정 사용자의 닉네임 수정(인증 미적용)
*      parameters:
*        - in: path
*          name: id
*          required: true
*          schema: {type: integer}
*      requestBody:
*        required: true
*        content:
*          application/json:
*            schema:
*              type: object
*              properties:
*                nickname: {type: string}
*      responses:
*        200:
*          description: 닉네임 수정
*        400: 
*          description: 로그인 후 사용
*/
router.patch('/:id/nickname', isAuthenticated, async(req, res)=>{
    try{
        const {nickname} = req.body; // Body에서
        await updateUserNickname(nickname, req.params.id);

        //const {id} = req.params; // URL에서
        //await updateUserNickname(nickname, id);
        res.status(201).json({message:'닉네임수정 성공'}) //200 ok , 201 created
    }catch(err){
        console.err('updateUserNickname', err);
        res.status(500).json({message:'닉네임수정 실패'});
    }

});
// delete: /user/{id} 사용자삭제
/**
*  @swagger
*  /user/{id}:
*    delete:
*      summary: 사용자 삭제
*      description: 특정 사용자삭제(인증 미적용)
*      parameters:
*        - in: path
*          name: id
*          required: true
*          schema: { type: integer }
*      responses:
*        200:
*          description: 사용자 삭제
*        400: 
*          description: 로그인 후 사용
*/
router.delete('/:id', isAuthenticated, async(req, res)=>{
     try{
        //const {id} = req.params;
        await deleteUser(req.params.id);
        res.json({message: '사용자 삭제 완료'})
    }catch(err){
        console.error('deleteUser', err);
        res.status(500).json({message:'사용자삭제 실패'});
    }   
});


// get  : /user/check-email/email 사용자이메일중복검사
/**
*  @swagger
*  /user/check-email/{email}:
*    get:
*      summary: 사용자이메일중복검사
*      description: 사용자이메일중복검사
*      parameters:
*        - in: path
*          name: email
*          required: true
*          schema: { type: string }
*      responses:
*        200:
*          description: 사용자 목록 반환
*        401:
*          description: 인증 필요
*/
router.get('/check-email/:email', async(req, res)=>{
    try{
        const users = await findUserByEmail(req.params.email);
        //console.log(users);   // ★ 여기 찍어보기
        res.json(users);
    }catch(err){
        console.error('findUserByEmail', err);
        res.status(500).json({message: '이메일중복조회 실패'})
    }
});

// get  : /user/check-email/email 사용자이메일중복검사
/**
*  @swagger
*  /user/check-nickname/{nickname}:
*    get:
*      summary: 사용자닉네임중복검사
*      description: 사용자닉네임중복검사
*      parameters:
*        - in: path
*          name: nickname
*          required: true
*          schema: { type: string }
*      responses:
*        200:
*          description: 사용자 목록 반환
*        401:
*          description: 인증 필요
*/
router.get('/check-nickname/:nickname', async(req, res)=>{
    try{
        const users = await findUserByNickname(req.params.nickname);
        //console.log(users);   // ★ 여기 찍어보기
        res.json(users);
    }catch(err){
        console.error('findUserByNickname', err);
        res.status(500).json({message: '닉네임중복조회 실패'})
    }
});


//3. export
module.exports = router;