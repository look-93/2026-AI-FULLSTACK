//1. require = impoert
import { Row, Col, Form, Input, Button, Upload, Spin, message } from "antd";    
import { UploadOutlined } from "@ant-design/icons";   
import { useState, useEffect } from "react"; // 감지: useEffect(이벤트변경감지), useState(변수)
import { useSelector, useDispatch } from "react-redux"; //store: useSelector(전역), useDispatch(스토어이벤트알림)
import { useRouter } from "next/router"; // 경로
import { signupRequest, resetUserState } from '../reducers/authReducer'
//2. function(부품)
function SignUpPage(){
    //5개 부품

    const dispatch = useDispatch();//이벤트감지
    const router = useRouter(); //경로
    const { user, error, success, loading } = useSelector((state) => state.auth);

    // 데이터 받아서 회원가입전송
    const onFinish = (values) => {
        //console.log(values);
        const sendData = {
            email : values.email,
            password : values.password,
            nickname : values.nickname
        }
        dispatch(signupRequest(sendData))
    };

    useEffect(()=>{
        if(success){
            message.success("회원가입이 성공적으로 완료되었습니다.");
            router.push("/mypage");
            dispatch(resetUserState());
        }
        if(error){
            message.error(error);
        }
    },[success,router,dispatch]);

    ////// Layout > Row > Col Col
    // 모바일 제일 작은 사이즈 : 24 xm 모바일2: 16 md: 테블릿: md,lg
    return (<Row justify="center">
        <Col xm={24} sm={16} md={8} >
        {loading && <Spin/>}
        {error && <p style={{color:"red"}}>{error}</p>}
        {!success && (
            <Form layout="vertical" onFinish={onFinish}>
            {/* 이메일 입력 */}
                <Form.Item
                    label="이메일"
                    name="email"
                    hasFeedback
                    rules={[
                        {
                            required: true,
                            message: "이메일을 입력하세요."
                        }
                    ]}
                >
                    <Input/>
                </Form.Item>
                {/* 비밀번호 입력 */}
                <Form.Item
                    label="비밀번호"
                    name="password"                
                    rules={[
                        {
                            required: true,
                            message: "비밀번호를 입력하세요."
                        }
                    ]}
                >
                    <Input.Password/>
                </Form.Item>           
                {/* 닉네임 입력 */}
                <Form.Item
                    label="닉네임"
                    name="nickname"      
                    hasFeedback          
                    rules={[
                        {
                            required: true,
                            message: "닉네임을 입력하세요."
                        }
                    ]}
                >
                    <Input/>
                </Form.Item>  
                <Button type="primary" htmlType="submit">회원가입</Button>
            </Form>
        )}
        </Col>
    </Row>)
}
//3. export
export default SignUpPage;