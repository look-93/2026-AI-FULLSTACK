/*
루트 사가(rootSaga)설정파일
모든 개별 saga(userSaga 등) 를 합쳐서 실행
redux-saga 의 all, fork 를 사용해서 병렬 실행
*/

import {all, fork} from 'redux-saga/effects'; // 여러 saga를 동시에 실행하기 위해 쓰는 함수
import userSaga from './user';

export default function* rootSaga(){
    yield all([//다 반환
        fork(userSaga), //userSaga 를 병렬 실행 / fork는 userSaga를 실행하고 기다리지 않는다.
        //fork(postSaga), 예시/ 나중에 연결 여러개 연결가능
    ]);
}