// useDispatch - 스토어알림, useSelector - 전역상태
import { useSelector, useDispatch } from 'react-redux';
// useEffect - 이벤트 변경감지, useState - 변수
import { useEffect, useState } from "react";
// useRouter - 경로
import { useRouter } from 'next/router';
import { SIGN_UP_REQUEST, FIND_USER_EMAIL_REQUEST, FIND_USER_NICKNAME_REQUEST } from '../reducers/user'

export default function JoinPage(){
    // 1. 코드
    const [logo, setLogo] = useState("MyReact - 회원가입")
    
    const dispatch = useDispatch();
    const router = useRouter();
    const {me, isLoading, error, signUpDone, isEmailAvailable, checkNickName} = useSelector((state)=> state.user); //1. store : 전역상태감지

    //      변수 변수함수셋팅
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [nickname, setNickname] = useState('');


    // 회원가입 요청액션 dispatch
    const onSubmit = (e)=> {
        e.preventDefault(); //브라우저의 기본 동작을 막는 함수야.
        //console.log("onSubmit 실행");
        // console.log(email.trim());
        // console.log(!email.trim());

        if(!email.trim()){
            alert('이메일을 입력해주세요.'); return;
        }
        if(!password.trim()){
            alert('비밀번호를 입력해주세요.'); return;
        }
        if(!nickname.trim()){
            alert('닉네임을 입력해주세요.'); return;
        }

        //2. store : 액션알림
        dispatch({type:SIGN_UP_REQUEST, data:{email, password, nickname} });
    }
    // function setChangeEmail(){
    //     setEmail(".......");
    // }

    //상태변화 감지
    useEffect(()=>{
        if(signUpDone){
            router.push({
                pathname:'/login',
                query:{signUpSuccess: 'true'} // 회원가입여부 주소표시창출
            })
        }
    }, [signUpDone, router]);

    //로그인시... me 값이 있다면
    // useEffect(()=>{
    //     if(me) router.push('/users');
    // }, [me, router]);

    //이메일 중복확인
    const onCheckEmail  = (e) => {       
        e.preventDefault();
        if(!email.trim()){
            alert('이메일을 입력해주세요.'); return;
        }

        dispatch({
            type: FIND_USER_EMAIL_REQUEST,
            data: {email} 
        });
    };

    //닉네임 중복확인
    const [nicknameChecked, setNicknameChecked] = useState(false);   
    const nicknameCheck = (nickname) => {
        setNicknameChecked(true);
        dispatch({
            type: FIND_USER_NICKNAME_REQUEST,
            data: { nickname }
        });
    };

    // 2. 뷰 - 렌더링
    return (
        <div className="container my-4">
            {/* <h3 className="mb-3" onClick={setChangeEmail}>{email}</h3> */}
            {/* <h3 className="mb-3" onClick={()=>(setLogo("haha"))}>{logo}</h3> */}
            <h3 className="mb-3" disabled={isLoading}>회원가입</h3>
            <form className="w-50 mx-auto" onSubmit={onSubmit}>
                {/* 이메일 입력 */}
                <div className="mb-3 d-flex">
                    <input type="email" className="form-control" placeholder="이메일" title="이메일입력" value={email} onChange={(e)=> {setEmail(e.target.value)}}/>
                    <button type="button" className="btn btn-success" style={{ width: '120px'}} onClick={onCheckEmail}>중복확인</button>
                </div>
                <div className="mb-3">
                    {isEmailAvailable === false && <div type="text" className='text-danger'>이미 사용중인 이메일입니다.</div>}
                    {isEmailAvailable === true && <div type="text" className='text-success'>사용 가능한 이메일입니다.</div>}                    
                </div>

                 {/* 비밀번호 입력 */}
                <div className="mb-3">
                    <input type="password" className="form-control" placeholder="비밀번호" title="비밀번호입력" value={password} onChange={(e)=> setPassword(e.target.value)}/>
                </div>
                 {/* 닉네임 입력 */}
                <div className="mb-3 d-flex">
                    <input type="nickname" className="form-control" placeholder="닉네임" title="닉네임입력" value={nickname} onChange={(e)=> {setNickname(e.target.value), 
                                                                                                                                             setNicknameChecked(false)}}/>
                    <button type="button" className="btn btn-success" style={{ width: '120px'}} onClick={()=>nicknameCheck(nickname)}>중복확인</button>
                </div>           
                 <div className="mb-3">
                    { nicknameChecked && (checkNickName ?
                    <div type="text" className='text-danger'>이미 사용중인 닉네임입니다.</div>
                    :<div type="text" className='text-success'>사용 가능한 닉네임입니다.</div>
                    )}
                </div>               
                 {/* 버튼 입력 */}
                <div className="mb-3">
                    <button type="button" type="submit" className="btn btn-primary w-100">회원가입</button>
                </div>                                
            </form>

            {/* 에러메시지  {여기는 자바스크립트 영역임}*/}
            {error && <div className="alert alert-danger mt-3">{error}</div>}
        </div>
    );
}