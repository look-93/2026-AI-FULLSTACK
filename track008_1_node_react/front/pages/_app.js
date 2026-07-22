import 'bootstrap/dist/css/bootstrap.min.css'; //부트스트랩 css
import Layout  from '../components/Layout';    //공통레이아웃 컴포넌트
import '../styles/globals.css'; // 글로벌css
import {wrapper} from '../store/configureStore'; //store 연결

function MyApp({Component, pageProps}){ // Component:현재 렌더링할 컴포넌트, pageProps:해당페이지에 전달되는 초기 props
    return (
        <Layout>
            {/*각 페이지 컴포넌트*/}
            <Component {...pageProps}/>
        </Layout>
    );
}
export default wrapper.withRedux(MyApp); // next-redux-wrapper로 store 연결