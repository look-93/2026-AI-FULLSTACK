- Todo1:  CSS기본
- Todo2:  java 자료형2/연산자/제어문?

---

### ■1. 복습문제  -  노트 준비 ~09:40
- 1. html/css/js 역할
  - 1) html :   구조
  - 2) css  :   꾸미기
  - 3) js   :   움직임

-2. 태그
  - <> </> : 브라우저에게 명령
  - div    :  그룹핑 (영역) 
  - h      :  제목
  - p      :  문단 - 내용
  - pre    :  문단 - 줄바꿈인식O
  - img    :  이미지    ,   속성1) src="경로"  ,  속성2) alt="설명"
  - a      :  링크      ,   속성1) href="경로" ,  속성2) title="설명"

-3. java
  1. 자바의 자료형 분류( 기본형  / 참조  )
  2. 기본형 : 값
  2-1 논리형 : 예) boolean  - true/false (1byte)	
  2-2 정수형 : byte(1) - short(2) - int(4★) - long(8L)   - 10
  2-3 실수형 : float(4) - double(8★)  - 1.23


---

### ■2. Todo1:  CSS기본
- 6. block vs line
Q) a 태그에 margin 적용 x, text-align 적용 x, width x

display:block  박스( 갈치냄비 )                   - width o, 줄바꿈 o
    예) div, p, pre
display:inline 박스 안에 내용물( 국물, 무, 갈치 )  - width x(△), 줄바꿈 x
    예) img, a, span, strong

- 7. css(2) 내부적용 / id vs class

css 적용방법
1) 인라인 스타일  - 태그안에 직접적용 

```html
<p style="color:red">color</p>
```

2) 내부 스타일 시트 - head 안에 style을 사용해 작성

```html
<style> p{ color: red; } </style>
```

3) 외부 스타일 시트 


---

### ■3.   Todo2:  java 자료형2 

1. 형변환 
2. 자료형 - char



---

### ■4.  복습문제

### ■4.  복습문제

> 정리문제 (1)
1. 배경을 파란색으로 설정하는 속성은?
- background-color: blue;
2. 글자색상을 빨간색으로 지정하는 속성은? 
- color: red;
3. 글자 크기를 20px로 지정하는 속성은?  
- font-size: 20px;
4. 글자를 가운데 정렬하는 속성은?  
- font-align: 20px;
5. 글자에 밑줄을 추가하는 속성은?  
- text-decoration:underline;
6. 글꼴을 Arial로 지정하는 속성은?
- font-family: 'Arial';
7. 글자를 굵게 표시하는 속성은?  
- font-weight:bold;
8. 요소의 가로 길이를 300px로 지정하는 속성은?  
- width: 300px;
9. 요소의 바깥쪽 여백을 10px로 지정하는 속성은?
- margin: 10px;
10. 요소의 안쪽 여백을 15px로 지정하는 속성은?  
- padding: 15px;
11. 요소에 1px 실선 테두리를 추가하는 속성은?  
- border: 1px solid;
12. 모서리를 둥글게 10px로 만드는 속성은?
- boder-radius: 10px;
13. 그림자 효과를 추가하는 속성은?  
- box-shadow: 0 4px 12px rgba(0,0,0,0.1);
14. 천천히 움직이는 장면전환효과를 주는 속성은? 
- transition: all 2s;

> 정리문제 (2)
15.  가로 사이즈 지정가능한것은 block ✔  /    inline
16.  a태그에 margin-top 줄수   o  /   x ✔
17.  css 적용방법 3가지 (  인라인 / 내부   /  외부  )
18.  css 적용 내부적용방법은 ( head ) 태그안에 ( style ) 태그 적용해서 사용


> 정리문제 (3)
1.  연산자의 우선순위를 적으시오.
- 1.값( ++ -- + - * / % )  2.비교(> < == !=)  3.조건(&& || ?:) 4.대입(=)

2.  다음오류 해결
short sh1 = 1 , sh2=2;
short result = sh1 + sh2;

- short result = (short)(sh1 + sh2);

3. 필수조건
q1-1 int형 변수 x가 3보다 크고 10보다 작을때 true인 조건식 
- System.out.print( x > && 10 < 10);
q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식
- Systen.out.print( ch == 'a' || ch == 'A' ); 
q1-3 char형 변수 ch가 숫자('0'~'9')일때   true인 조건식     
- System.out.print(ch >= '0' && ch <= '9')
q1-4 char형 변수 ch가 영문자(대문자 또는 소문자) 일때   true인 조건식
- System.out.print( ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
