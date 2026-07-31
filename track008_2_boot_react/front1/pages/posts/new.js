import { Card, Button, Form, Input, message } from "antd";
import { useEffect, useState } from "react"; // 감지: useEffect(이벤트변경감지)
import { useRouter } from "next/router";
import { useSelector, useDispatch } from "react-redux";
import { createPostRequest, resetPostState } from '../../reducers/postReducer'


function NewPostPage(){
    const {user} = useSelector((state)=>state.auth);
    const {posts, error, success, loading} = useSelector((state) => state.post);
    const dispatch = useDispatch();
    const router = useRouter()
// useEffect(()=>{
//     dispatch(resetPostState());
// },[dispatch]);
// useEffect(()=>{

//     if(success){
//         message.success("게시글 작성을 성공하였습니다.");
//         dispatch(resetPostState());
//         router.push("/");
        
//     }

//     if(error){
//         message.error(error);
//     }

// },[success,error,router,dispatch]);
    if(!user){
        return (
            <div style={{maxWidth:600, margin:"40px auto"}}>
                <p>로그인된 사용자없어요</p>
                <Button type="primary" onClick={()=>router.push("/signup")}>회원가입하러가기</Button>
            </div>
        );
    }

    const onFinish = (values) => {
        const dto = {
            content : values.content,
            userId : 67 // 세션연결예정 -> user.id
        }

        dispatch(createPostRequest(dto));
        message.success("게시글 작성을 성공하였습니다.");
        router.push("/");
    };

    return(<div style={{maxWidth:600, margin:"40px auto"}}>
        <Card title="게시글작성">
            <Form layout="vertical" onFinish={onFinish}>
                <Form.Item
                        label="내용"
                        name="content"
                        hasFeedback
                        rules={[
                            {
                                required: true,
                                message: "게시글 내용을 입력하세요."
                            }
                        ]}
                >
                    <Input.TextArea 
                        rows={6}
                        placeholder="게시글 내용을 입력하세요."
                    />
                </Form.Item>
                <Button type="primary" htmlType="submit" loading={loading}>게시글 작성</Button>
                {error && <p style={{color:"red"}}>{error}</p>}
            </Form>
        </Card>

    </div>);
}

export default NewPostPage;