//1. require (import)
const dbConfig = require('../config/db'); //user, password, connectString
const oracledb = require('oracledb');
const bcrypt = require('bcrypt');
//oracle 초기화
oracledb.initOracleClient();
//옵션 - 오토커밋
const options = {outFormat: oracledb.OUT_FORMAT_OBJECT, autoCommit:true};

//2.각기능  sql
//1. 사용자 등록 (Create - Insert)
async function createUser(email, password, nickname, mobile, mbtiTypeId, ufile){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const hashhadPassword = await bcrypt.hash(password, 10);
        const result = await conn.execute(
            `
                INSERT INTO appuser (
                    APP_USER_ID,     EMAIL,     PASSWORD,  NICKNAME,    MOBILE,    MBTI_TYPE_ID,    UFILE
                ) VALUES (
                    APPUSER_SEQ.NEXTVAL ,  :email,    :password,   :nickname,     :mobile,   :mbtiTypeId,     :ufile
                )            
            `
            , {email, password:hashhadPassword, nickname, mobile, mbtiTypeId, ufile}
            , options) //sql, 사용자입력값(파라미터), 옵션
    }catch(err){
        console.log('createUser Error', err);
        throw err;
    }finally{
        if(conn) await conn.close();
    }
}
//2. 사용자조회 - email
async function findUserByEmail(email){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `
                SELECT APP_USER_ID, EMAIL, PASSWORD, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
                FROM appuser 
                WHERE EMAIL = :email
            `
            , {email}
            , options); // 실행
        return result.rows[0] //결과처리 유저 찾았어요 return
            
    }catch(err){
        console.log('findUserByEmail Error', err);
        throw err;
    }finally{
        if(conn) await conn.close();
    }
}
//3. 사용자조회 - id
async function findUserById(id){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `
                SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
                FROM appuser 
                WHERE APP_USER_ID = :id
            `
            , {id}
            , options);
        return result.rows[0];
    }catch(err){
        console.log('findUserById Error', err);
        throw err;
    }finally{
        if(conn) await conn.close();
    }
}
//4. 로그인 - sqp 빼기 pass /  로그아웃
async function verifyUser(email, password){
    const user = await findUserByEmail(email);
    if(!user) return null;

    const match = await bcrypt.compare(password, user.PASSWORD);
    if(!match) return null;

    return {
        id: user.APP_USER_ID,
        email: user.EMAIL,
        nickname: user.NICKNAME,
    }
}
//5. 전체조회
async function getAllUsers(){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `
                SELECT APP_USER_ID, EMAIL, NICKNAME, MOBILE, MBTI_TYPE_ID, UFILE, CREATED_AT 
                FROM appuser 
                ORDER BY CREATED_AT DESC
            `
            ,{}
            ,options);
            return result.rows;
    }catch(err){
        console.log('getAllUsers Error', err);
        throw err;
    }finally{
        if(conn) await conn.close();
    }
}
//6. 닉네임수정
async function updateUserNickname(nickname, id){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `
                UPDATE appuser 
                SET NICKNAME = :nickname 
                WHERE APP_USER_ID = :id
            `
            , {nickname, id}
            , options)
    }catch(err){
        console.log('updateUserNickname Error', err);
        throw err;
    }finally{
        if(conn) await conn.close();
    }
}
//7. 사용자삭제
async function deleteUser(id){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `
                DELETE FROM appuser 
                WHERE APP_USER_ID = :id
            `
            , {id}
            , options);
    }catch(err){
        console.log('deleteUser Error', err);
        throw err;
    }finally{
        if(conn) await conn.close();
    }
}
//8. 닉네임조회
async function findUserByNickname(nickname){
    let conn;
    try{
        conn = await oracledb.getConnection(dbConfig);
        const result = await conn.execute(
            `
                SELECT APP_USER_ID, EMAIL, NICKNAME 
                FROM appuser 
                WHERE NICKNAME = :nickname
            `
            ,{nickname}
            ,options);
        return result.rows[0];
    }catch(err){
        console.log('createUser Error', err);
        throw err;
    }finally{
        if(conn) await conn.close();
    }
}

//3.export
module.exports={createUser, findUserByEmail, findUserById, 
                verifyUser, getAllUsers, updateUserNickname, deleteUser, findUserByNickname}; // 각 기능 만들고 exports에 추가