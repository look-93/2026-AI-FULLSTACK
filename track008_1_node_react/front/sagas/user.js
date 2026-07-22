/*
사용자 관련 비동기 작업을 처리하는 saga
- 로그인, 로그아웃, 회원가입, 사용자조회, 닉네임수정, 사용자삭제
- axios로 api 호출 -> 성공/실패에 따라 reducer 로 액션 전달 
*/
/*
Effect	역할	비유
all	여러 Saga를 동시에 실행	여러 명에게 동시에 일 시키기
fork	Saga를 백그라운드에서 실행	새 직원 한 명 투입
call	함수를 호출하고 결과를 기다림	직원에게 일을 맡기고 끝날 때까지 기다림
put	Redux에 Action을 보냄(dispatch)	Redux에게 "이 액션 실행해!"
takeLatest	같은 액션이 여러 번 오면 가장 마지막 것만 처리 마지막 요청만 처리

*/
import{all, fork, call, put, takeLatest, take} from 'redux-saga/effects'; // takeLatest 액션이 들어올 때까지 계속 대기
import axios from 'axios'; // http 라이브러리
import reducer, {
    initialState , 
    LOG_IN_REQUEST , LOG_IN_SUCCESS , LOG_IN_FAILURE , 
    LOG_OUT_REQUEST , LOG_OUT_SUCCESS , LOG_OUT_FAILURE , 
    SIGN_UP_REQUEST , SIGN_UP_SUCCESS , SIGN_UP_FAILURE , 
    LOAD_USER_REQUEST , LOAD_USER_SUCCESS , LOAD_USER_FAILURE , 
    UPDATE_NICKNAME_REQUEST , UPDATE_NICKNAME_SUCCESS , UPDATE_NICKNAME_FAILURE , 
    DELETE_USER_REQUEST , DELETE_USER_SUCCESS , DELETE_USER_FAILURE ,
    FIND_USER_EMAIL_FAILURE, FIND_USER_EMAIL_SUCCESS, FIND_USER_EMAIL_REQUEST,
    FIND_USER_NICKNAME_FAILURE, FIND_USER_NICKNAME_SUCCESS, FIND_USER_NICKNAME_REQUEST,
    
}  from '../reducers/user';


//Axios 객체를 새로 만들어서 공통 설정을 넣는 것입니다.
/* 이렇게쓰면됨
client.get('/user');
client.post('/login');
client.delete('/post/1');

안그러면 매번 이렇게 주소 써야됨
axios.get('http://localhost:3065/user');
axios.post('http://localhost:3065/login');
axios.delete('http://localhost:3065/post/1'); 
*/
const client = axios.create({
    baseURL : 'http://localhost:3065', // api 서버 주소
    withCredentials : true, // 쿠키/세션 인증포함
    //쿠키(세션)를 요청에 함께 보내고 받아서 저장하도록 하는 설정으로, Passport 세션 로그인에서는 거의 필수입니다.
});

// 로그아웃 watchLogout
// post : /user/logout
export function logoutApi(){
    return client.post('/user/logout');
}
export function* logout(){
    try{
        yield call(logoutApi);
        yield put({type: LOG_OUT_SUCCESS});
    }catch(err){
        yield put({type:LOG_OUT_FAILURE, error: err.response?.data || err.message} ); 
    }
}
function* watchLogout(){
    yield takeLatest(LOG_OUT_REQUEST, logout);
}

// 로그인 watchSignout
// post : /user/login    (requestBody)
export function loginApi(data){
    return client.post('/user/login', data);
}
export function* login(action){
    try{
        const result = yield call(loginApi, action.data);
        //console.log(result);
        //console.log(result.data);
        const user = {
            id:result.data.user.APP_USER_ID,
            email:result.data.user.EMAIL,
            nickname:result.data.user.NICKNAME
        }
        //console.log(user);
        yield put ({type: LOG_IN_SUCCESS, data:user});
    }catch(err){
        yield put({type:LOG_IN_FAILURE, error: err.response?.data || err.message} ); // 실패 액션 dispatch
    }
}
function* watchLogin(){
    yield takeLatest(LOG_IN_REQUEST, login);
}

// 회원가입 watchSignup
// post : /user/register (requestBody)
export function signUpApi(data){ // api 주소
    return client.post('/user/register', data);
}
export function* signup(action){
    try{
        yield call(signUpApi, action.data); // api 호출, 결과물 받음
        yield put({type:SIGN_UP_SUCCESS} ); // 성공 액션 dispatch
    }catch(err){
        yield put({type:SIGN_UP_FAILURE, error: err.response?.data || err.message} ); // 실패 액션 dispatch
    }
}
function* watchSignup(){
    yield takeLatest(SIGN_UP_REQUEST, signup);  
    // SIGN_UP_REQUEST 액션발생 -> 여러번 요청이 있어도 가장 마지막것만 실행(takeLatest) 
}
// 사용자조회 watchLoadUsers
// get  : /user/
export function loadUserApi(){
    return client.get('/user/')
}
export function* loadUser(){
    try{    
        const result = yield call(loadUserApi);
        //console.log(result.data)
        const users = result.data.map((u)=>({
            id:u.APP_USER_ID,
            email:u.EMAIL,
            nickname:u.NICKNAME
        }));
        //console.log(users)
        yield put({type:LOAD_USER_SUCCESS, data:users});
    }catch(err){
         yield put({type:LOAD_USER_FAILURE, error: err.response?.data || err.message} ); // 실패 액션 dispatch
    }
}
function* watchLoadUsers(){
    yield takeLatest(LOAD_USER_REQUEST, loadUser);  
    // SIGN_UP_REQUEST 액션발생 -> 여러번 요청이 있어도 가장 마지막것만 실행(takeLatest) 
}

// 닉네임수정 watchUpdateNickname
// patch: /user/{id}/nickname 
export function updateNicknameApi(data){
    return client.patch(`/user/${data.id}/nickname`, {nickname:data.nickname});
}
export function* updateNickname(action){
    try{
        yield call(updateNicknameApi, action.data);
        yield put({type:UPDATE_NICKNAME_SUCCESS, data:{id:action.data.id, nickname:action.data.nickname}});
    }catch(err){
        yield put({type:UPDATE_NICKNAME_FAILURE, error: err.response?.data || err.message} ); // 실패 액션 dispatch
    }
}
function* watchUpdateNickname(){
    yield takeLatest(UPDATE_NICKNAME_REQUEST, updateNickname);
}

// 사용자삭제 watchDeleteUser
// delete: /user/{id} 
export function deleteUserApi(id){
    return client.delete(`/user/${id}`);
}
export function* deleteUser(action){
    try{
        yield call(deleteUserApi, action.data.id);
        yield put({type:DELETE_USER_SUCCESS, data:{id:action.data.id}});

    }catch(err){
         yield put({type:DELETE_USER_FAILURE, error: err.response?.data || err.message} ); // 실패 액션 dispatch
    }
}
function* watchDeleteUser(){
    yield takeLatest(DELETE_USER_REQUEST, deleteUser);
}

//이메일 중복검사
export function findUserByEmailApi(email){
    return client.get(`/user/check-email/${email}`);
}
export function* findUserByEmail(action){
    try{
        const result = yield call(findUserByEmailApi, action.data.email);
        //console.log(result); // API 응답
        yield put({type:FIND_USER_EMAIL_SUCCESS, data:result.data});
    }catch(err){
        yield put({type:FIND_USER_EMAIL_FAILURE, err: err.response?.data || err.message});
    }
}
function* watchFindUserByEmail(){
    yield takeLatest(FIND_USER_EMAIL_REQUEST, findUserByEmail)
}

//닉네임 중복검사
export function findUserByNicknameApi(nickname){
    return client.get(`/user/check-nickname/${nickname}`);
}
export function* findUserByNickname(action){
    try{
        const result = yield call(findUserByNicknameApi, action.data.nickname);
        //console.log(result); // API 응답
        yield put({type:FIND_USER_NICKNAME_SUCCESS, data:result.data});
    }catch(err){
        yield put({type:FIND_USER_NICKNAME_FAILURE, err: err.response?.data || err.message});
    }
}
function* watchFindUserByNickname(){
    yield takeLatest(FIND_USER_NICKNAME_REQUEST, findUserByNickname)
}

export default function* userSaga(){ //index.js 의 import userSaga 이름이랑 같아야함
    yield all([
        fork(watchLogin),
        fork(watchLogout),
        fork(watchSignup),
        fork(watchLoadUsers),
        fork(watchUpdateNickname),
        fork(watchDeleteUser),
        fork(watchFindUserByEmail),
        fork(watchFindUserByNickname),
    ]);
}

/*
watchSignup을 백그라운드에서 실행한다.
watchSignup은 SIGN_UP_REQUEST 액션을 계속 감시한다.
SIGN_UP_REQUEST가 발생하면 signup Saga를 실행한다.
all을 사용하면 여러 watchXXX Saga를 동시에 등록할 수 있다.
fork -> 여러 Watcher Saga를 동시에 실행해서 각각의 액션을 계속 감시하도록 만드는 것
*/