//1. require / import
import { Row, Col, Form, Input, Button, Upload, Spin, message } from "antd";    
// store : useSelector(전역)      , useDispatch(스토어이벤트알림)  
//  감지 : useEffect(이벤트변경감지) , useState( 변수 ) 
//  경로 : useRouter
import React , {useState , useEffect, useRef}  from  "react";
import {useSelector , useDispatch}  from  "react-redux";
import {useRouter} from "next/router";
import { loginRequest , resetUserState } from "../reducers/authReducer";
import axios from "axios";

export default function LoginPage(){
    //Q1. useDispatch, useRouter
    const dispatch = useDispatch();
    const router = useRouter();

    //Q2. useSelector 이용헤사 user 상태 가져오기 - user loading, error
    const {user, error, success, loading} = useSelector((state)=>state.auth);

    //Q3. 로그인 버튼을 누르고나면 - 스토어이벤트알림(useDispatch) 이용해서 loginRequest 처리
    const onFinish = (values) => {
        //console.log(values)
        dispatch(loginRequest({...values, provider:'local'}));
        
    }

    //Q4. 로그인 성공 시 ㅇㅇ님 환영합니다 메시지 띄우고 (massage), 마이페이지로 이동(router.push)
    useEffect(()=>{
        if(user && user.email){
            message.success(`${user.nickname} || ${user.email} 님 환영합니다!`)
            router.push("/mypage")
        }
    },[user, router]);

    /////////////////////////////////
    return (
        <Row justify="center" style={{marginTop: 40}}> {/* Q5. justify 이용해서 중앙으로 배치, 위쪽에 여백 주기 40 */}
            <Col flex="auto" xs={24} sm={16} md={8}> {/* Q6. 반응형처리 xs 제일작은 모바일 24, sm 16칸, md는 8칸 */}
                <Form layout="vertical" onFinish={onFinish}>
                    <Form.Item 
                    label="이메일"
                    name="email" 
                    hasFeedback
                    rules={[{require: true, message:'이메일을 입력하세요.'}]}
                    >
                        <Input placeholder="aaa@email.com"/>
                    </Form.Item>
                    <Form.Item 
                    label="비밀번호"
                    name="password"
                    hasFeedback
                    rules={[{require: true, message:'비밀번호를 입력하세요.'}]}
                    >
                        <Input.Password placeholder="******"/>
                    </Form.Item>
                    <div style={{ textAlign: 'center', marginTop: 20 }}>
                        <Button 
                            type="primary" 
                            htmlType="submit"   
                            style={{ width: '200px', height: '50px' }}
                        >
                            로그인
                        </Button>
                    </div>
                </Form>
            </Col>
        </Row>)
}