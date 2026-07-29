import authReducer, {
    signupRequest, signupSuccess, signupFailure,
    fatchUserRequest, fatchUserSuccess, fatchUserFailure,
    resetUserState
} from '../authReducer';

describe('user slice reducer', ()=>{
    const initialState = {
        user: null,     //단건 조회된 사용자 정보
        loading:false,  //로딩상태
        error: null,    //에러메시지
        success:false   //성공여부
    };

    it('resetUserState', ()=>{
        const prev = {user:{id:1}, loading:true, error:'err', success:true } // 상태꼬임

        const state = authReducer(prev, resetUserState());
        //1. resetUserState() 실행, - 인자없음
        //2. 리듀서툴킷 - {type:resetUserState, paload:undefined}
        //3. 리듀서의 resetUserState: (state.action) => {} 액션받아서 - 상태초기화
        // action = {type:resetUserState, payload:undefined}
        expect(state.loading).toBe(false);
        expect(state.error).toBe(null);
        expect(state.success).toBe(false);
    });

    it('fatchUserSuccess', ()=>{
        const userData = {id:1, email:'1@1'};
        const state = authReducer(initialState, fatchUserSuccess(userData));
        expect(state.loading).toBe(false);
        expect(state.user).toEqual(userData);
        expect(state.success).toBe(true);
    });

    it('fatchUserFailure', ()=>{
        const state = authReducer(initialState, fatchUserFailure());
        expect(state.loading).toBe(false);
        expect(state.error).toBe(null);
        expect(state.success).toBe(false);
    });
 
    it('fatchUserRequest', ()=>{
        const state = authReducer(initialState, fatchUserRequest());
        expect(state.loading).toBe(true);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);
    });   

    it('signupRequest', ()=>{
        const state = authReducer(initialState,  signupRequest());
        expect(state.loading).toBe(true);
        expect(state.error).toBeNull();
        expect(state.success).toBe(false);
    });

    it('signupSuccess', ()=>{
        const userData = {id:1, email:'1@1'};
                     //signupSuccess : (state, action)
        const state = authReducer(initialState, signupSuccess(userData));
        //1. signupSuccess(userData) 실행하면 - {id:1, email:'1@1'};
        //2. 리듀서툴킷에서 {type: signupSuccess, payload:userData} 객체를 만듦
        //3. 리듀서의 signupSuccess: (state.action)=>{} 액션받아서 처리
        
        expect(state.loading).toBe(false);
        expect(state.user).toEqual(userData); //action.payload
        expect(state.success).toBe(true);
    });

    it('signupFailure', ()=>{
        const error = "회원가입실패";
        const state = authReducer(initialState, signupFailure(error));
        expect(state.loading).toBe(false);
        expect(state.error).toEqual(error);
        expect(state.success).toBe(false);
    });
});