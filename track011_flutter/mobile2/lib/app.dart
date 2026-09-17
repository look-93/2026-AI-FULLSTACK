import 'package:flutter/material.dart';

//공통 상단바 레이아웃 (AppLayout)
import 'shared/components/app_layout.dart';
import './features/auth/presentation/login_page.dart';
import './features/auth/presentation/signup_page.dart';
import './features/auth/presentation/users_page.dart';

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'bora 앱',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        useMaterial3: true, // 구글 최신 Material Design 3 테마적용
        appBarTheme: const AppBarTheme(
          backgroundColor: Colors.blue, //파란색 테마헤더
          foregroundColor: Colors.white, //글자 하얀색
        ),
      ),
      initialRoute: '/', // 시작경로

      routes: {
        //'/': (context) => const UsersPage(),
        '/': (context) => const UsersPage(), // 메인페이지 (게시글 목록)
        '/login': (context) => const LoginPage(), // 로그인
        '/signup': (context) => const SignupPage(), // 회원가입
        '/uses': (context) => const UsersPage(), // 마이페이지
      },
    );
  }
}
