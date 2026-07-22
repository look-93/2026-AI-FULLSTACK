// useDispatch - 스토어알림, useSelector - 전역상태
import { useSelector, useDispatch } from 'react-redux';
// useEffect - 이벤트 변경감지, useState - 변수
import { useEffect, useState } from "react";
// useRouter - 경로
import { useRouter } from 'next/router';
import { LOG_IN_REQUEST } from '../reducers/user'

export default function LoginPage(){
    // 초기화
    const dispatch = useDispatch();
    const router = useRouter();
    const {me, isLoading, error} = useSelector((state)=>state.user)

    //form 연결
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    //1-1. 회원가입했다고 알림창
    useEffect(()=>{
        if(router.query.signUpSuccess == 'true'){
            alert('회원가입이 완료되었습니다. 로그인 해주세요!');
            // 알림창 띄우고, 쿼리스트링(signUpSuccess) 제거하고 새로고침해도 alert 다시 안뜨게
            //             주소표시창중, 주소표시창출 감출필요없어서.. undefined
            router.replace('/login', undefined, {shallow : true});
        }
    },[router.query]);

    //1-2. 로그인    
    const onSubmit = (e)=>{
        e.preventDefault();
        
        if(!email.trim()){
            alert('이메일을 입력해주세요.'); return;
        }
        if(!password.trim()){
            alert('비밀번호를 입력해주세요.'); return;
        }    
        dispatch({type: LOG_IN_REQUEST, data:{email, password}});
        
    }
    
    //1-3. 로그인 후 페이지 이동
    useEffect(() => {
        //console.log(me);
        if (me) router.push("/users"); 
        // replace: 주소표시창줄이 바뀜, history 추가 x         
        // push: 주소표시창줄이 바뀜, history 추가 o, 뒤로가기 가능
    }, [me, router]);

    return (
        <div className="container my-4">
            <h3 className="mb-3">로그인</h3>
            <form className="w-50 mx-auto" onSubmit={onSubmit}>
                {/* 이메일 입력 */}
                <div className="mb-3">
                    <input type="email" className="form-control" placeholder="이메일" title="이메일입력" value={email} onChange={(e)=>setEmail(e.target.value)}/>
                </div>
                 {/* 비밀번호 입력 */}
                <div className="mb-3">
                    <input type="password" className="form-control" placeholder="비밀번호" title="비밀번호입력" value={password} onChange={(e)=>setPassword(e.target.value)}/>
                </div>          
                 {/* 버튼 입력 */}
                <div className="mb-3">
                    <button type="submit" className="btn btn-primary w-100">로그인</button>
                </div>                                
            </form>
            
            {/* 에러메시지 */}
            {error && <div className="alert alert-danger mt-3">에러메시지 출력</div>}
        </div>
    );
}