package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx004_v1 {
//	📌 실행 예시
//	====== 전화번호부 메뉴 ======
//	1. 연락처 추가
//	2. 전체 출력
//	3. 연락처 검색
//	4. 종료
//	===========================
//	메뉴 선택> 1
//	그룹 입력 (가족/회사/친구/기타)> 가족
//	이름 입력> 홍길동
//	전화번호 입력> 010-1234-5678
//	✅ 연락처 추가 완료!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Map<String, ContactDTO>> phoneBook = new HashMap<>();
		
		
	}
}

/* 
## 📘 연습문제4) Collection Framework + 중첩 HashMap (전화번호부)
패키지명 : com.company.basic014_ex
클래스명 : MapEx004

### 요구사항
1. 중첩 Map 구조 만들기  
   - Map<String, Map<String, ContactDTO>> phoneBook = new HashMap<>();  
   - 첫 번째 Key : 그룹 이름 ("가족", "회사", "친구", "기타")  
   - 두 번째 Key : 이름  
   - Value : ContactDTO 객체  

2. DTO 클래스   
   class ContactDTO {
       private String name;
       private String phone;
       // 생성자, getter/setter, toString()
   }

3. 메뉴 기능 구현
====== 전화번호부 메뉴 ======
1. 연락처 추가 (그룹, 이름, 전화번호 입력 → Map에 저장)
→ 그룹이 없으면 자동으로 생성 후 추가
2. 전체 출력 (그룹별 연락처 출력)
3. 연락처 검색 (그룹과 이름 입력 → 해당 연락처 출력)
4. 종료

📌 실행 예시
====== 전화번호부 메뉴 ======
1. 연락처 추가
2. 전체 출력
3. 연락처 검색
4. 종료
===========================
메뉴 선택> 1
그룹 입력 (가족/회사/친구/기타)> 가족
이름 입력> 홍길동
전화번호 입력> 010-1234-5678
✅ 연락처 추가 완료!

메뉴 선택> 2
=== 전체 전화번호부 ===
📂 그룹: 가족
홍길동 | 010-1234-5678
📂 그룹: 회사
가길동 | 010-1111-1111
📂 그룹: 친구
나길동 | 010-2222-2222
📂 그룹: 기타 
다길동 | 010-3333-3333
*/