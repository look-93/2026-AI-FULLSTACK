// reducers/authReducer.js
import { createSlice }  from "@reduxjs/toolkit";

//1. 초기화 상태 (공용)
const initialState={
    user: null ,     // 단건 조회된 사용자 정보
    loading: false,  // 로딩상태   
    error:   null,   // 에러메시지
    success: false,  // 성공여부
};
//2. 상태변화
const authReducer=createSlice({
    name : "user",
    initialState , 
    reducers : {
        // --- 회원 가입 ---
        signupRequest : (state)=>{
            state.loading = true;  
            state.error   = null;   
            state.success = false;  
        },
        signupSuccess : (state, action)=>{ 
            state.loading = false;  
            state.user    = action.payload;  //가입된 회원정보저장 
            state.success = true;  
        },
        signupFailure : (state, action)=>{
            state.loading = false;  
            state.error   = action.payload;  // 오류메시지
            state.success = false;  
        },

        // --- 상태 초기화 ---
        resetUserState: (state)=>{
            state.loading = false;  
            state.error   = null;   
            state.success = false;  
        } , 

        // --- 로그인 (세션 기반으로 user 정보만 관리) ---
        loginRequest: (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;
        },
        loginSuccess: (state, action)=>{
            state.loading = false;
            state.user = action.payload || null;
            state.success = true;  
        },
        loginFailure: (state, action)=>{
            state.loading = false;
            state.error = action.payload;
            state.user = null;
            state.success = false;
        },

        // --- 로그아웃 ---
        logoutRequest: (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;
        },
        logoutSuccess: (state)=>{
            state.loading = false;
            state.error = null;
            state.user = null;
            state.success = true;
        },
        logoutFailure: (state, action)=>{
            state.loading = false;
            state.error = action.payload;
            state.user = null;
            state.success = false;
        },    

        // --- 닉네임변경 ---
        updateNicknameRequest: (state, action)=>{
            state.loading = true;
            state.error = null;
            state.success = false;
        },
        updateNicknameSuccess: (state, action)=>{
            state.loading = false;
            state.user = action.payload;
            state.success = true;
        },
        updateNicknameFailure: (state, action)=>{
            state.loading = false;
            state.error = action.payload;
            state.user = null;
            state.success = false;
        },

        // --- 프로필 이미지 변경 ---
        updateProfileImageRequest: (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;
        },
        updateProfileImageSuccess: (state, action)=>{
            state.loading = false;
            state.user = action.payload;
            state.success = true;
        },
        updateProfileImageFailure: (state, action)=>{
            state.loading = true;
            state.error = action.payload;
            state.success = false; 
        },

    },
});
//3.  action
export const {signupRequest , signupSuccess , signupFailure, resetUserState,
    loginRequest, loginSuccess, loginFailure,
    logoutRequest, logoutSuccess, logoutFailure,
    updateNicknameRequest, updateNicknameSuccess, updateNicknameFailure,
    updateProfileImageRequest, updateProfileImageSuccess, updateProfileImageFailure
} = authReducer.actions;
//4.  export
export default  authReducer.reducer;