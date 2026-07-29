import { createSlice } from "@reduxjs/toolkit";

//1. 초기화 상태(공용)
const initialState = {
    user: null,     //단건 조회된 사용자 정보
    loading:false,  //로딩상태
    error: null,    //에러메시지
    success:false   //성공여부
};
//2. 상태변화
const authReducer = createSlice({
    name: "user",
    initialState,
    reducers: {
        //... 회원가입 ...
        signupRequest : (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false; 
        },
        // 서버에서 받는 값 있다 하면 action
        signupSuccess : (state, action)=>{
            state.loading = false;
            state.user = action.payload; //가입된 회원정보저장  -> user 는  서버에서 responce 결과가 들어갑
            state.success = true;            
        }, 
        signupFailure : (state, action)=>{
            state.loading = false;
            state.error = action.payload; //오류메시지  -> user 는  서버에서 responce 결과가 들어갑
            state.success = false;   
        },

        //... 사용자 단건조회 ....
        fatchUserRequest : (state)=>{
            state.loading = true;
            state.error = null;
            state.success = false;           
        },
        fatchUserSuccess : (state, action)=>{
            state.loading = false;
            state.user = action.payload; //가입된 회원정보저장  -> user 는  서버에서 responce 결과가 들어갑
            state.success = true;                 
        },
        fatchUserFailure : (state, action)=>{
            state.loading = false;
            state.user = action.payload; //오류메시지  -> user 는  서버에서 responce 결과가 들어갑
            state.success = false;              
        },

        //... 상태 초기화 ...
        resetUserState : (state)=>{
            state.loading = false;
            state.error = null;
            state.success = false;
        },
    },
});
//3. action
export const {
    signupRequest, signupSuccess, signupFailure,
    fatchUserRequest, fatchUserSuccess, fatchUserFailure,
    resetUserState
} = authReducer.actions;
//4. export
export default authReducer.reducer;

