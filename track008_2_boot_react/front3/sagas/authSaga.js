// sagas/authSaga.js
import { all, call, put, takeLatest} from  'redux-saga/effects';
import  api  from  '../api/axios';
import {signupRequest , signupSuccess , signupFailure, resetUserState,
    loginRequest, loginSuccess, loginFailure,
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure,

    refreshTokenRequest, refreshTokenSuccess, refreshTokenFailure,
    loadUserRequest, loadUserSuccess, loadUserFailure,
 } from '../reducers/authReducer';
import Cookies from 'js-cookie'; //###

const USER_API_BASE = '/auth';

// ---  회원가입  POST  /api/auth/signup ---
export  const  signupApi = ( formData )=> api.post(  `${USER_API_BASE}/signup` , formData, {
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
export const loginApi = (payload) => api.post(`${USER_API_BASE}/login`, payload);
export function* login(action){
    try{
        const result = yield  call( loginApi,  action.payload  );  //■3.  result.data
        
        //추가
        const accessToken = result.data?.accessToken;
        const user = result.data?.user;

        //있습니까?
        if(accessToken && user){
            //localStorage, Cookies 셋팅
            if(typeof window != "undefined"){
                localStorage.setItem("accessToken", accessToken);
                Cookies.set("accessToken", accessToken);
            }
            yield  put(loginSuccess({
                user,
                accessToken
            })); // 처리결과 put
        }
        /* boot 리턴값 확인
            return ResponseEntity.ok(Map.of(
            "accessToken", accessToken,
            "user", user
            ));
        */
        //yield  put(loginSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(loginFailure(err.response?.data?.message || err.message));
    }
}
function* watchLogin(){   yield  takeLatest( loginRequest.type , login);  } 

// --- 토큰 재발급 ---
export const refreshApi = () => {return api.post(`${USER_API_BASE}/refresh`)}
export function* refresh(){
    try{
        const result = yield call(refreshApi);
        const newAccessToken = result.data?.accessToken || null;
        //CSR 환경에서 localStorage 와 쿠키에저장
        if(typeof window != "undefined" && newAccessToken){
            localStorage.setItem("accessToken", newAccessToken);
            Cookies.set("accessToken", newAccessToken);
        }
        yield put(refreshTokenSuccess({accessToken : newAccessToken}));

    }catch(err){
        yield put(refreshTokenFailure(err.response?.data?.message || err.message));
        yield put(logout());
    }
}
function* watchRefresh(){ yield takeLatest(refreshTokenRequest.type, refresh)}

// ---  로그아웃  POST  /api/auth/logout ---
export const logoutApi = () => api.post(`${USER_API_BASE}/logout`);
export function* logout(){
    try{
        yield  call(logoutApi);  //■3.  result.data

        if(typeof window != "undefined"){
            localStorage.removeItem("accessToken");
            Cookies.remove("accessToken");
        }

        yield  put(logoutSuccess()); // 처리결과 put
    }catch(err){
        yield  put(logoutFailure(err.response?.data?.message || err.message));
    }
}
function* watchLogout(){   yield  takeLatest( logoutRequest.type , logout);  }

// ---  닉네임수정  patch  /api/auth/{userId}/nickname ,params통해서 닉네임넘기기 ---
export const updateNicknameApi = ({ userId, nickname }) =>api.patch(`${USER_API_BASE}/${userId}/nickname`, null, {params: {nickname}});
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
    return api.patch(`${USER_API_BASE}/${userId}/profile-image`, formData, {headers: {"Content-Type": "multipart/form-data"}})};

export function* updateProfileImage(action){
    try{
        const result = yield  call( updateProfileImageApi,  action.payload  );  //■3.  result.data
        yield  put(updateProfileImageSuccess(result.data)); // 처리결과 put
    }catch(err){
        yield  put(updateProfileImageFailure(err.response?.data?.message || err.message));
    }
}
function* watchUpdateProfileImage(){   yield  takeLatest( updateProfileImageRequest.type , updateProfileImage);  }

// --- 유저 정보 로드  마이페이지 ---
export const loadUserApi = (cookieHeader) => api.get(`${USER_API_BASE}/me`, {
    headers: {cookie: cookieHeader || ""},
    withCredentials: true // Axios에게: "요청할 때 쿠키 같은 인증 정보를 포함해서 요청해."
})
export function* loadUser(action){
    try{
        const result = yield call(loadUserApi, action.payload?.cookie);
        yield put(loadUserSuccess(result.data));
    }catch(err){
        yield  put(loadUserFailure(err.response?.data?.message || err.message));
    }
}
function* watchLoadUser(){   yield  takeLatest( loadUserRequest.type , loadUser);  }
//loadUserRequest, loadUserSuccess, loadUserFailure,
    
export default  function * authSaga(){
    yield all([
        call(watchSignup),
        call(watchLogin),
        call(watchLogout),
        call(watchUpdateNickname),
        call(watchUpdateProfileImage),
        call(watchRefresh),
        call(watchLoadUser),
    ]);
}