/*
루트리듀서(rootReducer) 설정파일
- 여러개의 리듀서를 하나로 합쳐서 redux 스토어
- 현재는 user리듀서만 포함
*/

import {combineReducers} from 'redux'; // 여러개의 리듀서를 합치는 Redux 함수
import user from './user';          // 사용자 관련 상태를 관리하는 user 리듀서
//import post from './post';        // 사용자 관련 상태를 관리하는 post 리듀서

const rootReducer = combineReducers({
    user, //post
})

export default rootReducer;