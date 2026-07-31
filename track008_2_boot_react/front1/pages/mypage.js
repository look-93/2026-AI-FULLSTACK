import { Card, Descriptions, Button } from "antd";
import { useSelector } from "react-redux";
import { useRouter } from "next/router";

function Mypage(){
    /// Redux에서 회원가입시 저장된 사용자 정보 가져오기 - user
    const {user} = useSelector((state)=>state.auth);
    const router = useRouter()
    if(!user){
        return (
            <div style={{maxWidth:600, margin:"40px auto"}}>
                <p>로그인된 사용자없어요</p>
                <Button type="primary" onClick={()=>router.push("/signup")}>회원가입하러가기</Button>
            </div>
        );
    }

    return(<div style={{maxWidth:600, margin:"40px auto"}}>
        <Card title="마이페이지 (회원정보)">
            <Descriptions title="User Info" bordered column={1}>
                <Descriptions.Item label="회원번호">{user?.id}</Descriptions.Item>
                <Descriptions.Item label="이메일">{user?.email}</Descriptions.Item>
                <Descriptions.Item label="닉네임">{user?.nickname}</Descriptions.Item>
            </Descriptions>
        </Card>

    </div>);
}

export default Mypage;