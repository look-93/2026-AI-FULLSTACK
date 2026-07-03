package com.the703.llmrag;

public record Choice(
		int index,
		Message message,
		String finish_reason
) {}

//record 

/* 
컴파일하면 자동으로 아래가 생성됩니다.

생성자(Constructor) ✅
Getter 역할 메서드 ✅
equals() ✅
hashCode() ✅
toString() ✅
*/


// @Value 기본으로 final 기본 get/set /생성자 가지고있음
//------------------
//@Getter 
//@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE) - 모든필드를 private final 로 변경
//@AllArgsConstructor 
//@ToString 
//@EqualsAndHashCode 