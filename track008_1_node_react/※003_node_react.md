```
사용자 액션 (버튼클릭, 로그인 요청 등)
             ↓
        [View  컴포넌트]   
    _______________________________
    - dispatch({type:LOG_IN_REQUEST , data})
    - 화면에서 액션발생    

             ↓
          [Store]
    _______________________________
    - 중앙창고 (Redux Store)
    - 모든상태(state)저장
    - 액션을  reducer/saga 로 전달

             ↓
          [Saga (Middleware)]
    _______________________________
    - 비동기 작업 담당 (API)
    - 예) axios.post('/user/login')
    - 성공 -  LOG_IN_SUCCESS
    - 실패 -  LOG_IN_FAILURE
    
             ↓
          [Reducer]
    _______________________________
    - 상태(state) 변경 규칙서
    - LOG_IN_SUCCESS → me 업데이트
    - LOG_IN_FAILURE → error 저장

             ↓
          [Store]
    _______________________________
    - 변경된 상태를 중앙창고에 반영

             ↓

        [View  리렌더링]   
    _______________________________
    - useSelector로 상태읽기

```
6. 개발(reducer - saga - view) (2) saga

```
front/
├── sagas/                  # ✅ Redux-Saga 폴더
│   ├── index.js            # 루트 사가
│   ├── user.js             # 사용자 관련 사가
│   └── user.test.js        # 사가 테스트 코드
```

<!--순서-->
```
6. sagas
    - index.js 
    - user.js
```

1) 제너레이터 함수
// 내가계속 어떤 기능을 하고있어 , 계속 요청 x 유지
```js
function* g1(){ // * < 무한반복
    let i=0;
    while(true){
        yield i++; // < yield 양보 /값 던져주고 스탑
    }
}

const gen1 = g1();

console.log(gen1.next().value); // gen1.next() 호출
console.log(gen1.next().value); // gen1.next() 호출
```

```js
function* g2(){ // * < 무한반복
   console.log("first");
   yield 1; //첫번쨰 반환

   console.log("second");
   yield 2; //두번쨰 반환

   console.log("third");
   yield 3; //세번째 반환
}

const gen2 = g2();
console.log(gen2.next());
console.log(gen2.next());
console.log(gen2.next());
```

2) saga 기본함수
- all, fork , call, put, takeLatest

1. all - 여러 saga를 동시에 실행
2. fork - [비동기]로 saga 실행
3. call - api를 호출하고 겷과를 기다림(blocking) > 동기 
4. put - Redux에 Action을 보냄(dispatch)
5. takeLatest - 같은 액션이 여러 번 오면 가장 마지막 액션만 처리

주소경로
post : /user/register (requestBody)
post : /user/login    (requestBody)
post : /user/logout   
get  : /user/
patch: /user/{id}/nickname 
delete: /user/{id} 

