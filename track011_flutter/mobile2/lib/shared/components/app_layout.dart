import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import '../../features/auth/data/auth_provider.dart';

class AppLayout extends ConsumerWidget {
  final Widget child;
  const AppLayout({super.key, required this.child});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final authState = ref.watch(authProvider);
    final bool isLogined =
        authState.accessToken != null && authState.user != null;
    final userNickname = authState.user?['nickname'] ?? '유저';

    return Scaffold(
      appBar: AppBar(
        title: const Text('마이페이지'),
        actions: [
          if (isLogined) ...[
            Center(
              // [핵심] 일반 Text/Container 영역을 클릭 및 물결 터치(Ripple) 반응형으로 만들어 주는 위젯
              child: InkWell(
                onTap: () {
                  Navigator.pushNamed(context, '/users');
                },
                borderRadius: BorderRadius.circular(4.0),
                child: Padding(
                  padding: const EdgeInsets.symmetric(
                    horizontal: 8.0,
                    vertical: 4.0,
                  ),
                  child: Text(
                    '$userNickname님 환영합니다!',
                    style: const TextStyle(
                      decoration: TextDecoration.underline,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                ),
              ),
            ),
            const SizedBox(width: 4),
            TextButton(
              onPressed: () {
                // [핵심] 읽기 전용으로 Notifier의 메서드 실행
                ref.read(authProvider.notifier).logout();
                ScaffoldMessenger.of(context)
                    .showSnackBar(const SnackBar(content: Text('로그아웃 되었습니다.')));
              },
              child: const Text('로그아웃', style: TextStyle(color: Colors.white)),
            ),
          ] else ...[
            TextButton(
              onPressed: () => Navigator.pushNamed(context, '/login'),
              child: const Text('로그인', style: TextStyle(color: Colors.white)),
            ),
          ],
        ],
      ),
      body: child,
    );
  }
}
