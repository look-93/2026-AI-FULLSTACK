import {all, call, put, fork, takeLatest} from 'redux-saga/effects';
import axios from 'axios';
import { 
    signupRequest, signupSuccess, signupFailure,
    fatchUserRequest, fatchUserSuccess, fatchUserFailure,
    resetUserState
} from '../reducers/authReducer';

const USRE_API_BASE = 'http://localhost:8080/api/users';

//--- 회원가입 post /api/users--- 
export const signupApi = (userData) => axios.post(USRE_API_BASE, userData);
export function* signup(action){
    try{
        const result = yield call(signupApi, action.payload);
        yield put(signupSuccess(result.data));
    }catch(err){//HTTP 400을 반환하면 Axios는 catch로 옴
        yield put(signupFailure(err.response?.data?.message || err.message)); //err.message : "Network Error" -> Axios가 제공해주는 기본 에러 메시지
    }
}
//1. takeLatest : 요청이 여러번와도 가장 마지막발생요청 처리
function* watchSignup(){
    yield takeLatest(signupRequest.type, signup);
}

//--- 단건조회 get /api/users/1 ---
//호출3
export const fetchUserApi = (userId) => axios.get(`USRE_API_BASE/${userId}`);
//호출2
export function* fetchUser(action){
    //action = {type: ,payload:{}}
    try{
        const result = yield call(fetchUserApi, action.payload);
        yield put(fatchUserSuccess(result.data));
    }catch(err){
        yield put(fatchUserFailure(err.response?.data?.message || err.message)); //err.message : "Network Error" -> Axios가 제공해주는 기본 에러 메시지        
    }
}
// 호출1
function* watchFetchUser(){
    yield takeLatest(fatchUserRequest.type, fetchUser);
}

export default function* authSaga(){
    yield all([
        call(watchSignup),
        call(watchFetchUser),
    ]);
}

//fork : 기다리지않음 (다른일 할수 있게 양보) - 동시에 실행 - 비동기
//call : 기다림(어떠한 일이 끝날떄까지 기다리기) - 결과물이 필수적 - 동기