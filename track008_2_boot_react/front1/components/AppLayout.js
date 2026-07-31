//# 재사용 가능한 UI 컴포넌트 폴더
//1. require
import { Layout, Menu, Input, Row, Col, Drawer, Button, Grid } from "antd";  
import { MenuOutlined, SearchOutlined } from "@ant-design/icons";  

import {useSelector, useDispatch} from 'react-redux'; // 전역상태, 액션스토어알림
import {useRouter} from 'next/router'; // 경로이동
import { useEffect, useState } from 'react'; //이벤트변경감지, 변수
import Link from 'next/link';

const {Header, Content} = Layout; // <Layout.Header> -> <Header>
const {useBreakpoint} = Grid;

//2. 부품
//Header/Drawer
//                  각 부품대체, 초기값
function AppLayout({children, initialUser}){

    const menuItems = [
        { key: "new",     label: <Link href="/posts/new">✏️ NEW POST</Link> },
        { key: "profile", label: <Link href="/mypage">👤 MYPAGE </Link> },
        { key: "home",    label: <Link href="/signup">🏠 JOIN</Link> },
    ];

    const [drawerOpen, setDrawerOpen] = useState(false);
  
    ////////// #1) Row(줄) - Col(칸) / Col
    /////////  #2) 반응형속성 (모바일: xs, sm,테블릿: md, pc: lg) - 24칸
    // display : "flex" 자식요소 배치 알아서, flex="none" : 고정
    // justify= "space-between" 양쪽에 콘텐츠 배치
    return (<Layout>
        {/* Header */}
        <Header style={{display:"flex"}}>
            <Row align="middle" justify="space-between" style={{width:"100%"}}>
                <Col flex="none">
                    <Link href="/">
                        <a style={{color:"white", fontWeight:"bold", fontSize:"18px"}}>THEJOA703 (POST VER)</a>
                    </Link>
                </Col>
                {/* xs,sm(모바일): 0숨김처리, md(테블릿):16, 24칸중에 16, lg(pc): 18 */}
                <Col flex="auto" xs={0} sm={0} md={16} lg={18}>
                    <Menu
                    theme="dark"
                    mode="horizontal"
                    items={menuItems}
                    />                
                </Col>
                {/*button 종류 : primary, default(하얀색), text(없음) */}
                <Col flex="none" xs={2} md={0}>
                    <Button  type="default"
                    icon={<MenuOutlined style={{color:"pink", fontSize:20}} />}
                    onClick={()=>setDrawerOpen(true)}
                    >
                        Open
                    </Button>
                </Col>
            </Row>
        </Header>
        <Drawer
        title="Basic Drawer"
        placement="right"
        onClose={()=>setDrawerOpen(false)}
        open={drawerOpen}
        >
            <Menu
            mode="vertical"
            items={menuItems}
            onClick={()=>setDrawerOpen(false)}
            />  
        </Drawer>

        <Content style={{padding:"40px"}}>{children}</Content>
    </Layout>);
}

export default AppLayout;


// Layout: https://ant.design/components/layout 
// Menu: https://ant.design/components/menu 
// Input: https://ant.design/components/input 
// Drawer: https://ant.design/components/drawer 
// Grid(Row/Col): https://ant.design/components/grid 
// Button: https://ant.design/components/button