// sagas/authSaga.js
import { all, call, put, takeLatest} from  'redux-saga/effects';
import  axios  from  'axios';
import {signupRequest , signupSuccess , signupFailure, resetUserState,
    loginRequest, loginSuccess, loginFailure,
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure
 } from '../reducers/authReducer';

const USER_API_BASE = 'http://localhost:8080/auth';

// ---  회원가입  POST  /api/auth/signup ---
export  const  signupApi = ( formData )=> axios.post(  `${USER_API_BASE}/signup` , formData, {
    headers: {"Content-Type": "multipart/form-data"}, // 이미지
}); // /api/users
//■2.  signup(action) - action.payload 사용자가 입력한 값 (회원정보)
export  function*   signup(action){
    // action = { type: auth/signupRequest, payload: { email:'1@1' , password:'1'} }
    try{
        const result = yield  call( signupApi,  action.payload  );  //■3.  result.data
        yield  put(signupSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(signupFailure(err.response?.data?.message || err.message));
    }
}
//■1.takeLatest( signupRequest.type , signup) :  takeLatest - 요청이 여러번, 가장마지막발생요청 처리
function* watchSignup(){   yield  takeLatest( signupRequest.type , signup);  } 

// ---  로그인  POST  /api/auth/login ---
export const loginApi = (payload) => axios.post(`${USER_API_BASE}/login`, payload);
export function* login(action){
    try{
        const result = yield  call( loginApi,  action.payload  );  //■3.  result.data
        yield  put(loginSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(loginFailure(err.response?.data?.message || err.message));
    }
}
function* watchLogin(){   yield  takeLatest( loginRequest.type , login);  } 

// ---  로그아웃  POST  /api/auth/logout ---
export const logoutApi = () => axios.post(`${USER_API_BASE}/logout`);
export function* logout(){
    try{
        yield  call(logoutApi);  //■3.  result.data
        yield  put(logoutSuccess()); // 처리결과 put
    }catch(err){
        yield  put(logoutFailure(err.response?.data?.message || err.message));
    }
}
function* watchLogout(){   yield  takeLatest( logoutRequest.type , logout);  }

// ---  닉네임수정  patch  /api/auth/{userId}/nickname ,params통해서 닉네임넘기기 ---
export const updateNicknameApi = ({ userId, nickname }) =>axios.patch(`${USER_API_BASE}/${userId}/nickname`, null, {params: {nickname}});
export function* updateNickname(action){
    try{
        const result = yield  call( updateNicknameApi,  action.payload  );  //■3.  result.data
        yield  put(updateNicknameSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(updateNicknameFailure(err.response?.data?.message || err.message));
    }
}
function* watchUpdateNickname(){   yield  takeLatest( updateNicknameRequest.type , updateNickname);  }


// ---  이미지수정  patch  /api/auth/{userId}/profile-image ,params통해서 닉네임넘기기 ---
export function updateProfileImageApi ({ userId, file }){  
    const formData = new FormData();
    formData.append("ufile", file);
    return axios.patch(`${USER_API_BASE}/${userId}/profile-image`, formData, {headers: {"Content-Type": "multipart/form-data"}})};

export function* updateProfileImage(action){
    try{
        const result = yield  call( updateProfileImageApi,  action.payload  );  //■3.  result.data
        yield  put(updateProfileImageSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(updateProfileImageFailure(err.response?.data?.message || err.message));
    }
}
function* watchUpdateProfileImage(){   yield  takeLatest( updateProfileImageRequest.type , updateProfileImage);  }

export default  function * authSaga(){
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
    ]);
}