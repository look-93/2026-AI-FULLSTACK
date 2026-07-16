// npx  jest  reducers/user.test.js
import reducer, {
    initialState , 
    LOG_IN_REQUEST , LOG_IN_SUCCESS , LOG_IN_FAILURE , 
    LOG_OUT_REQUEST , LOG_OUT_SUCCESS , LOG_OUT_FAILURE , 
    SIGN_UP_REQUEST , SIGN_UP_SUCCESS , SIGN_UP_FAILURE , 
    LOAD_USER_REQUEST , LOAD_USER_SUCCESS , LOAD_USER_FAILURE , 
    UPDATE_NICKNAME_REQUEST , UPDATE_NICKNAME_SUCCESS , UPDATE_NICKNAME_FAILURE , 
    DELETE_USER_REQUEST , DELETE_USER_SUCCESS , DELETE_USER_FAILURE , 
}  from './user';

describe( 'user reducer' , ()=>{
    it('LOG_IN_REQUEST' , ()=>{
        const state = reducer( initialState , { type:LOG_IN_REQUEST }  );
        expect(state.isLoading).toBe(true);
    }); // return {  ...state , isLoading: true ,  error:  null }

    it('LOG_IN_SUCCESS' , ()=>{
        const fakeUser = {id:1, email:'1@1', nickname:'first'};
        const state = reducer( initialState , { type:LOG_IN_SUCCESS, data:fakeUser}  );
        expect(state.me).toBe(fakeUser);
    }); // return {  ...state , isLoading: true ,  error:  null }

    it('LOG_IN_FAILURE' , ()=>{
        const state = reducer( initialState , { type:LOG_IN_FAILURE, error: '로그인 실패'}  );
        expect(state.error).toBe('로그인 실패');
        expect(state.isLoading).toBe(false);
    }); // return {  ...state , isLoading: true ,  error:  null }
    
    //////////////////////////////////////////////////////
    it('LOG_OUT_REQUEST' , ()=>{
        const state = reducer( initialState , { type:LOG_OUT_REQUEST }  );
        expect(state.isLoading).toBe(true);
    }); 

    it('LOG_OUT_SUCCESS' , ()=>{
        const state = reducer( initialState , { type:LOG_OUT_SUCCESS }  );
        expect(state.me).toBe(null);
        expect(state.isLoading).toBe(false);
    });
    
    it('LOG_OUT_FAILURE' , ()=>{
        const state = reducer( initialState , { type:LOG_OUT_FAILURE, error: '로그아웃 실패' }  );
        expect(state.error).toBe('로그아웃 실패');
        expect(state.isLoading).toBe(false);
    }); 

    //////////////////////////////////////////////////////
    it('SIGN_UP_REQUEST' , ()=>{
        const state = reducer( initialState , { type:SIGN_UP_REQUEST }  );
        expect(state.isLoading).toBe(true);
    });

    it('SIGN_UP_SUCCESS' , ()=>{
        const state = reducer( initialState , { type:SIGN_UP_SUCCESS }  );        
        expect(state.isLoading).toBe(false);
        expect(state.signUpDone).toBe(true);
    });   
    
    it('SIGN_UP_FAILURE' , ()=>{
        const state = reducer( initialState , { type:SIGN_UP_FAILURE, error: '회원가입 실패' }  );        
        expect(state.error).toBe('회원가입 실패');
        expect(state.isLoading).toBe(false);
    });   
    
    it('LOAD_USER_REQUEST' , ()=>{
        const state = reducer( initialState , { type:LOAD_USER_REQUEST}  );
        expect(state.isLoading).toBe(true);
    });   

    it('LOAD_USER_SUCCESS' , ()=>{
        const fakeUser = [{id:1, email:'1@1', nickname:'first'}];
        const state = reducer( initialState , { type:LOAD_USER_SUCCESS, data: fakeUser }  );
        expect(state.users).toEqual(fakeUser);
        expect(state.isLoading).toBe(false);
    });

    it('LOAD_USER_FAILURE' , ()=>{
        const state = reducer( initialState , { type:LOAD_USER_FAILURE, error: '조회 실패'}  );
        expect(state.error).toBe('조회 실패');
        expect(state.isLoading).toBe(false);
    });


    it('UPDATE_NICKNAME_SUCCESS' , ()=>{
        const prev = {...initialState, me:{id:1, nickname:'old'}, users:[{id:1, nickname:'old'}]};
        const state = reducer(prev, {type:UPDATE_NICKNAME_SUCCESS, data: {id:1, nickname: 'new'}});
        expect(state.me.nickname).toBe('new');
        expect(state.users[0].nickname).toBe('new');
    });    
    
});