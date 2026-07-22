7. 개발(reducer - saga - view) (2) store
```
front/
├── store/                  # ✅ Redux 스토어 설정 폴더
│   ├── configureStore.js   # Redux 스토어 설정
│   └── configureStore.test.js # 스토어 테스트 코드
```


8. View
```
front/
├── pages/                 
│   ├── _app.js     # Next.js 기반 페이지 설정 - 전체앱의 -공통설정
│   ├── index.js    #메인페이지
│   ├── login.js    #로그인
│   ├── signup.js   #회원가입
│   └── users.js    #사용자 목록, 정보페이지
```

1. `useSelector`    -> Redux Store에서 사용자 상태 가져오기
    - 상태조회: 스토어저장된 전역상태(State) react에서 가져오기
    - useSelect((state) => state.user)

2. `useEffect`      -> 로그인 여부 확인 및 사용자 목록 불러오기
    - 생명주기 및 부수효과처리
    - 부품 맨처음 나올때, 사라질때, 특정상태 변경 시

3. `dispatch`       -> 액션발생(로그인, 사용자 삭제...)
    - 알림 : 스토어한테 이러한 액션 발생 알리기
    - store.dispatch({ type: LOG_IN_REQUEST });

실습0) back - app.js
```
app.use(express.json()) // json
app.use(express.urlencoded({extended:true})) // form 데이터처리
app.use(cors({ "다른 서버인데 요청해도 돼?" 라고 확인하는데, cors()가 "응, 허용할게." 라고 응답
  origin: 'http://localhost:3000' ,   // 프론트엔드 주소를 명시
  credentials: true                   // 쿠키, 세션, 인증 정보를 함께 보내는 것을 허용해.
}));
```

실습1) front - pages - [_app.js]
- import {wrapper} from '../store/configureStore'; //store 연결 추가
- export default wrapper.withRedux(MyApp); // store 연결

pages   - [index.js] 작성
        - login, signup, users.js 만들기
        ```
        export default function UsersPage(){
            return "USERS";
        }

        ```
        - npm run dev 오류없는지 실행
        - 각 화면 뷰 완성하기
        - join 화면 import 후 코드작성