const {createUser, findUserByEmail, findUserById, 
       verifyUser, getAllUsers, updateUserNickname, 
       deleteUser, findUserByNickname} = require('./models/users');

async function runTests(){
    try{
        //1. 회원가입
        await createUser('z@z', 'z', 'zzz', '0202222222', 1, '1.png');
        console.log('✅ createUser 성공');
        //2. 이메일로 조회
        await findUserByEmail('z@z');
        console.log('✅ findUserByEmail 성공')
    }catch(err){
        console.log('❌테스트중 오류 발생' + err);
    }
}

runTests();

//node test1.js