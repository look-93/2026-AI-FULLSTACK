// useDispatch - 스토어알림, useSelector - 전역상태
import { useSelector, useDispatch } from 'react-redux';
// useEffect - 이벤트 변경감지, useState - 변수
import { useEffect, useState } from "react";
// useRouter - 경로
import { useRouter } from 'next/router';
import { LOAD_USER_REQUEST, UPDATE_NICKNAME_REQUEST, DELETE_USER_REQUEST, LOG_OUT_REQUEST } from '../reducers/user'

export default function UsersPage(){
    // 1. 코드
    // const users = [
    // { id: 1, email: 'test1@test.com', nickname: 'aaa' },
    // { id: 2, email: 'test2@test.com', nickname: 'tt' },
    // ];
    // 초기화
    const dispatch = useDispatch();
    const router = useRouter();
    const {users, isLoading, error, me} = useSelector((state)=> state.user);
    
    //1-1 사용자 목록 불러오기
    useEffect(() => {
       if(!me){
            router.push('/login'); //로그인이 안되어있으면 ,로그인페이지로 이동
       }else {
         dispatch({
            type: LOAD_USER_REQUEST //사용자 목록요청
        });
       }
    }, [dispatch, me, router]);
    
    //1-2 로그아웃
    //logout
    const onLogout = () => {
        dispatch({
            type:LOG_OUT_REQUEST
        });
    };
    //logout 감지 후 화면이동
    useEffect(()=>{
        if(me === null) {router.push('/login')};
    }, [me, router]);

    //1-3 유저삭제
    const onDelete = (id)=>{
        //console.log("삭제 id =", id, typeof id);
        dispatch({
            type: DELETE_USER_REQUEST,
            data:{id}
        });
    }

    //1-4 닉네임수정
    //수정모드
    const [editId, setEditId] = useState(null); //닉네임 수정할 아이디 번호
    const onEdit = (id) => setEditId(id)
    
    const [newNickname,setNewNickname] = useState('');
    const onUpdateNickname = (id) => {
        dispatch({
            type: UPDATE_NICKNAME_REQUEST,
            data: {id, nickname:newNickname}
        });
        setEditId(null);
        setNewNickname('');
    };

    // 2. 뷰 - 렌더링
    return (
        <div className="container my-4">
            <h3 className="mb-3">사용자목록</h3>
            {/* 로딩/에러 상태 표시 */}
            {isLoading && <div className="alert alert-info">로딩 중..</div>}
            {error && <div className="alert alert-danger">{error}</div>}

            {/* 사용자 목록 테이블 */}
            
            <table className="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>이메일</th>
                        <th>닉네임</th>
                        <th>액션</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((user)=>(                       
                        <tr key={user.id}>
                            <td>{user.email}</td>
                            <td>
                                {editId === user.id ?
                                    <input type="text" className="form-control" placeholder="새닉네임입력" value={newNickname} onChange={(e)=>setNewNickname(e.target.value)}/>
                                    :(user.nickname)
                                }
                            </td>
                            <td>
                                {editId !== user.id ?
                                    <button className="btn btn-primary me-2" onClick={()=>onEdit(user.id)}>닉네임수정</button>
                                    :<button className="btn btn-primary me-2" onClick={()=>onUpdateNickname(user.id)}>수정완료</button>
                                 }
                                <button type="button" className="btn btn-danger" onClick={()=>{onDelete(user.id)}}>삭제</button>
                            </td>
                        </tr>                                             
                    ))}
                </tbody>
            </table>

            {/* 로그아웃 */}
            {me && 
                <div className="mt-3">          
                    <button type="button" className="btn btn-secondary" onClick={onLogout}>로그아웃</button>                     
                </div>
            }
        </div>
    );
}