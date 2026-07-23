/**
 * 사용자관련 상태(user state) 를 관리하는 리듀서
 *  - 로그인, 로그아웃, 회원가입, 사용자등록, 닉네임수정, 사용자삭제
 *  - 1. 각 액션타입정의 2. 초기상태 3. reducer 함수 LOG_IN_REQUEST
 */

// 1. 각 액션타입 정의 / view,saga,store 에 공유할수있음
export const LOG_IN_REQUEST = 'LOG_IN_REQUEST'; // 로그인요청
export const LOG_IN_SUCCESS = 'LOG_IN_SUCCESS'; // 로그인성공
export const LOG_IN_FAILURE = 'LOG_IN_FAILURE'; // 로그인실패

export const LOG_OUT_REQUEST = 'LOG_OUT_REQUEST'; // 로그아웃요청
export const LOG_OUT_SUCCESS = 'LOG_OUT_SUCCESS'; // 로그아웃성공
export const LOG_OUT_FAILURE = 'LOG_OUT_FAILURE'; // 로그아웃실패

export const SIGN_UP_REQUEST = 'SIGN_UP_REQUEST'; // 회원가입요청
export const SIGN_UP_SUCCESS = 'SIGN_UP_SUCCESS '; // 회원가입성공
export const SIGN_UP_FAILURE = 'SIGN_UP_FAILURE'; // 회원가입실패

export const LOAD_USER_REQUEST = 'LOAD_USER_REQUEST'; // 사용자목록요청
export const LOAD_USER_SUCCESS = 'LOAD_USER_SUCCESS'; // 사용자목록성공
export const LOAD_USER_FAILURE = 'LOAD_USER_FAILURE'; // 사용자목록실패

export const UPDATE_NICKNAME_REQUEST = 'UPDATE_NICKNAME_REQUEST'; // 닉네임수정요청
export const UPDATE_NICKNAME_SUCCESS = 'UPDATE_NICKNAME_SUCCESS'; // 닉네임수정성공
export const UPDATE_NICKNAME_FAILURE = 'UPDATE_NICKNAME_FAILURE'; // 닉네임수정실패

export const DELETE_USER_REQUEST = 'DELETE_USER_REQUEST'; // 사용자삭제요청
export const DELETE_USER_SUCCESS = 'DELETE_USER_SUCCESS'; // 사용자삭제성공
export const DELETE_USER_FAILURE = 'DELETE_USER_FAILURE'; // 사용자삭제실패

export const FIND_USER_EMAIL_REQUEST = 'FIND_USER_EMAIL_REQUEST' //이메일 조회 요청
export const FIND_USER_EMAIL_SUCCESS = 'FIND_USER_EMAIL_SUCCESS' //이메일 조회 성공
export const FIND_USER_EMAIL_FAILURE = 'FIND_USER_EMAIL_FAILURE' //이메일 조회 실패

export const FIND_USER_NICKNAME_REQUEST = 'FIND_USER_NICKNAME_REQUEST' //닉네임 조회 요청
export const FIND_USER_NICKNAME_SUCCESS = 'FIND_USER_NICKNAME_SUCCESS' //닉네임 조회 성공
export const FIND_USER_NICKNAME_FAILURE = 'FIND_USER_NICKNAME_FAILURE' //닉네임 조회 실패

// 2. user 초기상태
export const initialState = {
    me: null,  // 로그인사용자정보 {id, email, nickname}
    users: [], // 전체 사용자 목록 [{id, email, nickname}]
    isLoading: false, // api 요청 중 여부
    error: null,      // 에러메시지
    signUpDone: false, // 회원가입완료여부
    checkEmail: null, //이메일중복검사
    checkNickName: null,
    isEmailAvailable: null
};

// 3. reducer 함수
const reducer = (state=initialState, action) => { //현재상태 / 요청액션  , 두가지 상태를 가짐
    switch(action.type){
        // 요청 액션 -> 로딩시작
            case LOG_IN_REQUEST:
            case LOG_OUT_REQUEST:
            case SIGN_UP_REQUEST:
            case LOAD_USER_REQUEST:
            case UPDATE_NICKNAME_REQUEST:
            case DELETE_USER_REQUEST:
            case FIND_USER_EMAIL_REQUEST:
            case FIND_USER_NICKNAME_REQUEST:
                return {...state, isLoading: true, error: null}; // 로딩중 true...
            

        // 성공 액션 -> 상태업데이트]
            case LOG_IN_SUCCESS:
                return {...state, isLoading: false, me: action.data}; // 로딩완료 false...

            case LOG_OUT_SUCCESS:
                return {...state, isLoading: false, me: null};

            case SIGN_UP_SUCCESS:
                return {...state, isLoading: false, signUpDone: true};

            case LOAD_USER_SUCCESS:
                return {...state, isLoading: false, users: action.data};
                
            case UPDATE_NICKNAME_SUCCESS:
                    return  {  ...state, isLoading: false , 
                            me: state.me  &&  state.me.id === action.data.id
                                ? { ...state.me ,  nickname:action.data.nickname } 
                                : state.me  ,
                            users: state.users.map( (u)=> u.id === action.data.id ? {  ...u , nickname: action.data.nickname } : u)
                    };

            case DELETE_USER_SUCCESS:
                return { ...state, isLoading: false , 
                    me : state.me?.id === action.data.id? null : state.me , 
                    users: state.users.filter(  (u) => u.id !== action.data.id )
                };
            case FIND_USER_EMAIL_SUCCESS:
                return {...state, isLoading: false, isEmailAvailable: action.data.isAvailable};
            case FIND_USER_NICKNAME_SUCCESS:
                return {...state, isLoading: false, isEmailAvailable: action.data.isAvailable};
        // 실패 액션 -> 에러메시지 저장
            case LOG_IN_FAILURE:
            case LOG_OUT_FAILURE:
            case SIGN_UP_FAILURE:
            case LOAD_USER_FAILURE:
            case UPDATE_NICKNAME_FAILURE:
            case DELETE_USER_FAILURE:
                      
            case FIND_USER_NICKNAME_FAILURE:   
                return {...state, isLoading: false, error: action.error?.message || action.error};
            case FIND_USER_EMAIL_FAILURE:
                return {...state, isLoading: false, error: action.error?.message || action.error, isEmailAvailable: false}
        // 기본값 - 상태변경없음
        default:
            return state;
    }
};

export default reducer;