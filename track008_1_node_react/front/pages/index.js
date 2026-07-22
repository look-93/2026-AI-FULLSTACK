//// ver-2
//useSelector - 전역상태 
//useEffect   - 변경감지
//dispatch    - 액션발생

import { useEffect } from "react"; //특정동작 실행 / 컴포넌트 생명주기, 부수 효과 처리(API 호출, 이벤트 등록 등)
import { useRouter } from "next/router"; //이동
export default function HOME(){
    //1. 코드
    const router = useRouter();
    useEffect( ()=>{
        router.replace('/users'); // /usres 뒤로가기남지 않음.
    } ,[router]); // [] <- router 변경감지시 useEffect 실행

    //2. view
    return null;
};


///// ver-1
// export default function Home(){
//   return <h1>REACT PROJECT 정상실행</h1>;
// }

// npm run dev