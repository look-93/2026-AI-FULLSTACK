■1. ERD (ENTITY RELATIONSHIP DIAGRAN)
→ 데이터 관계간에 초점을 둔 모델

1. 개체(ENTITY) - 테이블
2. 속성(ATTRIBUTE) - 열, 컬럼
3. 관계(RELATIONSHIP) - 외래키

예) dept(deptno) ┼----∈ emp(deptno) ★
    deptno(★pk)         empno(★pk)
                         deptno(☆fk)

풀이
1) emp와 dept은 1:다
        한 부서는 여러명의 사원이 소속
2) 부모테이블  : dept  /  자식테이블 : emp
    dept테이블이 존재해야 사원을 해당 부서에 배치
3) 점선 / 실선 : 점선(비식별관계)


■2. ~ 구성되어 있다
ex1) 하나의 A 는 하나의 B로 구성되어 있다.
[홍길동] ┼───┼ [주민증]

ex2) 하나의 A 는 여러개의 B로 구성되 있다.
한명의 학생은 여러개의 수강내역을 가진다.
[홍길동] ┼───∈ [JAVA, JSP, SPRING, MYSQL]

■3. 점선 vs 실선
실선: 부모테이블의 기본키를 자식테이블의 기본키로 사용
점선: 부모테이블의 기본키를 자식테이블의 기본키로 사용 안한 경우

1:1     1:다    다:다

- 학과와 학생       1:다
    학과는 많은 학생을 가질 수 있다.
    학생은 한 학과에 소속된다.
- 학과와 교수       1:다
    학과는 많은 교수을 가질 수 있다.
    교수은 한 학과에 소속된다.
- 교수와 개설과목   1:다
    교수는 많은 과목을 가르칠 수 있다.
    과목은 강의하는 교수 한명이 지정된다.    
- 과목과 학생       다:다
    과목은 수강하는 많은 학생을 가진다
    학생은 많은 과목을 수강할 수 있다




ex1) 학과와 학생은  
<< 학과(Department)>> ┼----∈ <<학생(Student)>>
학과코드(dept_id: ★pk)         학번(std_id: ★pk) 
학과명(dept_name)              성명(std_name)   
                               키(height)   
                               학과코드(dept_id:☆fk)

풀이
> ex2)   학과와 교수  → 1:다
    학과는 많은 교수를 가질 수 있다.
    교수는 한 학과에 소속된다.
<< 학과(Department)>> ┼-----------------∈<< 교수(Professor)>>
학과코드(dept_id:★PK)                    교수코드(prof_id:★PK)  
학과명(dept_name)                        교수명(prof_name
                                       학과코드(dept_id:☆FK)   
 
풀이1) 학과와 교수  → 1:다
풀이2) 부모테이블 :  학과     /  자식테이블  :   교수
풀이3) 점선    

---

> ex3)   교수와 개설과목   → 1:다
    학과는 많은 과목을 가르칠 수 있다.
    과목은 강의하는 교수한명이 지정된다. 

<< 교수(Professor)>> ┼-----------------------------∈ <<개설과목(Course)>>
교수코드(prof_id:★PK)                               과목코드(course_id:prof_id:★PK)      
교수명(prof_name                                    과목명(course_name)  
학과코드(dept_id:☆FK)                               교수코드(prof_id:☆FK)
                                                   시작일(start_date)
                                                   종료일(end_date)

풀이
1) 교수와 개설과목 1:다
2) 부모테이블 : 교수 / 자식테이블 : 개설과목
3) 점선


ex4) 과목와 학생     → 다:다
    과목은 수강하는 많은 학생을 가진다.
    학생은 많은 과목을 수강할 수 있다.

<<개설과목(Course)>┼────────────∈ <<수강(std_Course)>> ∋──────────────┼ <<학생(Student)>>
과목코드(course_id:prof_id:★PK)        < 학번(std_id★PK)                  학번(std_id:★PK)       
과목명(course_name)               과목코드(course_id★PK)>               성명(std_name)
교수코드(prof_id:☆FK)                                                 키(height)
시작일(start_date)                                                     학과코드(dept_id:☆FK)
종료일(end_date)

풀이1) 과목와 학생     → 다:다
풀이2) 부모테이블 : 개설과목  , 학생    /  자식테이블  :  수강
풀이3) 실선(부모테이블 PK - 자식테이블 PK) ,    점선(부모테이블 PK - 자식테이블 FK)




■2. workbanch

<<테이블>>
    학생(Student)
        학번(std_id), 성명(std_name), 키(height), 학과코드(dept_id)

    학과(Department)
        학과코드(dept_id), 학과명(dept_name)

    교수(Professor)
        교수코드(prof_id), 교수명(prof_name), 학과코드(dept_id)

    개설과목(Course)
        과목코드(course_id), 과목명(course_name), 교수코드(prof_id),
        시작일(start_date), 종료일(end_date)

    수강(std_Course)
        학번(std_id), 과목코드(course_id)

■3. FOREIGN KEY
    => 외래키(참조키)
    => 다른테이블의 기본키를 참조하는 키
    => 중복가능 / NULL 허용함
    => 참조되고있는테이블의 데이터 값 이외의 값은 삽입할수 없음.
    => insert할때 잘못된 데이터 삽입이 안되록하는 것
    => 레코드 삭제나 테이블삭제를 할때는 반드시 FOREIGN KEY가
       지정된 레코드나 테이블을 삭제한후에 참조대상을 삭제할수 있다.


    방법
       [ CONSTRAINT 별칭 ] REFERENCES 테이블이름(필드명)


