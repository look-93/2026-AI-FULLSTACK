-------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------
[지문]
1.  다음과 같이 TESTEMP , TESTDEPT 테이블을  생성하시오
    이름       	널?       	  유형                			 [TESTEMP]
    -------- 	-------- 	  ------------
    EMP_ID   	NOT NULL        INT           			--사원번호  기본키
    EMP_NAME 	NOT NULL        VARCHAR(100)  	    	--사원이름
    JOB      	NOT NULL        VARCHAR(100)       		--직업
    DEPT_ID           	        INT           			--부서번호
    SAL      	NOT NULL        INT             	 	--급여
    BONUS             	        INT                   	--보너스
    MGR_ID            	        INT                		--관리자번호
    HIREDATE 	NOT NULL DATE              			    --입사일


       DEPT_ID DNAME                    [TESTDEPT]
    ---------- --------------------
           100 관리부
           200 경리부
           300 생산부
           400 영업부

CREATE TABLE TESTEMP(
    EMP_ID INT NOT NULL PRIMARY KEY,
    EMP_NAME VARCHAR(100) NOT NULL ,
    JOP VARCHAR(100) NOT NULL ,
    DEPT_ID INT,
    SAL INT NOT NULL ,
    BONUS INT,
    MGR_ID INT,
    HIREDATE DATE NOT NULL 
);

CREATE TABLE TESTDEPT(
    DEPT_ID INT PRIMARY KEY,
    DNAME VARCHAR(100)
);

INSERT INTO TESTDEPT VALUES (100,'관리부');
INSERT INTO TESTDEPT VALUES (200,'경리부');
INSERT INTO TESTDEPT VALUES (300,'생산부');
INSERT INTO TESTDEPT VALUES (400,'영업부');

2. 다음과 같이 데이터를 삽입하시오.    -- 마지막 1줄만 넣는 코드를 작성하시오.
    [ SELECT * FROM TESTEMP ]
        EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
    ---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
          6200 민병권     대표이사          200       5000                       97/12/17
          6311 송지연     부장              100       3500                  6200 98/12/17
          7489 김소담     세일즈            400       1850        200       6321 99/02/27
          7522 박선영     세일즈            400       1850        300       6321 98/02/28 
          6321 정순진     부장              400       3800        500       6200 99/04/20
          6351 최원석     부장              300       2850                  6200 00/05/31
          7910 최준혁     경리              300       1000                  6351 01/05/01
          6361 홍경일     부장              200       3200                  6200 00/06/09
          7878 박성희     연구직            200       3000                  6361 01/06/05
          7854 홍양숙     세일즈            400       1500          0       6321 01/09/08
          7872 신현욱     사무직            100       1500                  6311 01/02/12
          7920 조성미     사무직            300       1050                  6351 01/03/18
          7901 마동석     연구직                      3000                       01/12/03
          7933 박재영     사무직            200       1050                  6361 02/01/02

    14개 행이 선택되었습니다.

   [ SELECT * FROM TESTDEPT ]
       DEPT_ID DNAME
    ---------- --------------------
           100 관리부
           200 경리부
           300 생산부
           400 영업부

INSERT INTO TESTEMP VALUES (6200,'민병권','대표이사',200,  5000,NULL,NULL, '1997-12-17');
INSERT INTO TESTEMP VALUES (6311,'송지연','부장',100, 3500,Null,6200, '1998-12-17');
INSERT INTO TESTEMP VALUES (7489,'김소담','세일즈',400,  1850,200,6321, '1999-02-27') ;
INSERT INTO TESTEMP VALUES (7522,'박선영','세일즈',400, 1850,300,6321,'1998-02-28') ;
INSERT INTO TESTEMP VALUES (6321,'정순진','부장',400, 3800,500,6200,'1999-04-20') ;
INSERT INTO TESTEMP VALUES (6351,'최원석','부장',300,   2850,NULL,6200,'2000-05-31');
INSERT INTO TESTEMP VALUES (7910,'최준혁','경리',300, 1000,NULL,6351,'2001-05-01');
INSERT INTO TESTEMP VALUES (6361,'홍경일','부장',200, 3200,NULL,6200,'2000-06-09') ;
INSERT INTO TESTEMP VALUES (7878,'박성희','연구직',200, 3000,NULL,6361,'2001-06-05') ;
INSERT INTO TESTEMP VALUES (7854,'홍양숙','세일즈',400, 1500,0,6321,'2001-09-08') ;
INSERT INTO TESTEMP VALUES (7872,'신현욱','사무직',100, 1500,NULL,6311,'2001-02-12') ;
INSERT INTO TESTEMP VALUES (7920,'조성미','사무직',300, 1050,NULL,6351,'2001-03-18');
INSERT INTO TESTEMP VALUES (7901,'마동석','연구직',NULL, 3000,NULL,NULL,'2001-12-03');

INSERT INTO TESTEMP VALUER (7933,'박재영','사무직',200,1050, NULL,6361, '02/01/02');


3. 급여를 3000이상 받는 사원이 소속된 부서와  동일한 부서에서 근무하는 사원들의 정보를 구하시오.

        EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
    ---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
          7933 박재영     사무직            200       1050                  6361 02/01/02
          7878 박성희     연구직            200       3000                  6361 01/06/05
          6361 홍경일     부장              200       3200                  6200 00/06/09
          6200 민병권     대표이사          200       5000                       97/12/17
          7872 신현욱     사무직            100       1500                  6311 01/02/12
          6311 송지연     부장              100       3500                  6200 98/12/17
          7854 홍양숙     세일즈            400       1500          0       6321 01/09/08
          6321 정순진     부장              400       3800        500       6200 99/04/20
          7522 박선영     세일즈            400       1850        300       6321 98/02/28
          7489 김소담     세일즈            400       1850        200       6321 99/02/27

    10개 행이 선택되었습니다.
select *
  from TESTEMP as A  
 where A.DEPT_ID in (select distinct DEPT_ID
                       from TESTEMP as B
                      where B.DEPT_ID = A.DEPT_ID
                        and B.SAL >= 3000                      
                    );

4. 부서번호가 300인 사원들중에서 급여를 가장 많이 받는 사원보다  더 많은 급여를 받는 사람의 정보를 검색.
        EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
    ---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
          7878 박성희     연구직            200       3000                  6361 01/06/05
          7901 마동석     연구직                      3000                       01/12/03
          6361 홍경일     부장              200       3200                  6200 00/06/09
          6311 송지연     부장              100       3500                  6200 98/12/17
          6321 정순진     부장              400       3800        500       6200 99/04/20
          6200 민병권     대표이사          200       5000                       97/12/17

    6개 행이 선택되었습니다.

select * 
  from TESTEMP as a
  where a.SAL > (select MAX(b.SAL)
                   from TESTEMP as b
                  where b.DEPT_ID = 300
                )
 order by a.SAL



5. 부서번호가 300인 사원들중에서 급여를 가장 적게 받는 사원보다 더 많은 급여를 받는 사람의 정보를 검색하시오.

        EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
    ---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
          7920 조성미     사무직            300       1050                  6351 01/03/18
          7933 박재영     사무직            200       1050                  6361 02/01/02
          7872 신현욱     사무직            100       1500                  6311 01/02/12
          7854 홍양숙     세일즈            400       1500          0       6321 01/09/08
          7489 김소담     세일즈            400       1850        200       6321 99/02/27
          7522 박선영     세일즈            400       1850        300       6321 98/02/28
          6351 최원석     부장              300       2850                  6200 00/05/31
          7878 박성희     연구직            200       3000                  6361 01/06/05
          7901 마동석     연구직                      3000                       01/12/03
          6361 홍경일     부장              200       3200                  6200 00/06/09
          6311 송지연     부장              100       3500                  6200 98/12/17
          6321 정순진     부장              400       3800        500       6200 99/04/20
          6200 민병권     대표이사          200       5000                       97/12/17

    13개 행이 선택되었습니다.

select * 
  from TESTEMP as a
  where a.SAL > (select MIN(b.SAL)
                   from TESTEMP as b
                  where b.DEPT_ID = 300
                )
  order by a.SAL



6. 마동석의 급여와 동일 하거나 더 많이 받는 사원의 정보검색하시오.
        EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
    ---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
          6200 민병권     대표이사          200       5000                       97/12/17
          6311 송지연     부장              100       3500                  6200 98/12/17
          6321 정순진     부장              400       3800        500       6200 99/04/20
          6361 홍경일     부장              200       3200                  6200 00/06/09
          7878 박성희     연구직            200       3000                  6361 01/06/05
          7901 마동석     연구직                      3000                       01/12/03

    6개 행이 선택되었습니다.
select *
  from TESTEMP
 where SAL >= (select SAL
                 from TESTEMP
                where EMP_NAME = "마동석"
              )
 order by HIREDATE;


7. 직급이 사무직인 사원의 부서번호와 부서명 출력하시오.
       DEPT_ID DNAME
    ---------- --------------------
           100 관리부
           300 생산부
           200 경리부

select *
   from TESTDEPT
  where DEPT_ID in (select DEPT_ID
                      from TESTEMP 
                     where JOB = "사무직"
                    );


8.  이름에 '최'를 포함하고 있는 사원들과 같은 부서에서 근무하고 있는 사원 정보검색하시오.
    EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
      7920 조성미     사무직            300       1050                  6351 01/03/18
      7910 최준혁     경리              300       1000                  6351 01/05/01
      6351 최원석     부장              300       2850                  6200 00/05/31

select *
  from TESTEMP
 where DEPT_ID in (select DEPT_ID
                     from TESTEMP
                    where EMP_NAME like '%최%'
                   );


9. 부서가 경리부인 모든 사원의 정보출력하시오
    EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
      6200 민병권     대표이사          200       5000                       97/12/17
      6361 홍경일     부장              200       3200                  6200 00/06/09
      7878 박성희     연구직            200       3000                  6361 01/06/05
      7933 박재영     사무직            200       1050                  6361 02/01/02
select * 
  from TESTEMP 
 where DEPT_ID = 200;


10. 대표이사에게 보고를 하는 모든 사원의 정보를 출력하시오.
(mgr_id 가 대표이사의 사원번호로 사용하고 있는 관리자번호로 사용하고 있는 사원 검색)
         EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
    ---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
          6311 송지연     부장              100       3500                  6200 98/12/17
          6321 정순진     부장              400       3800        500       6200 99/04/20
          6351 최원석     부장              300       2850                  6200 00/05/31
          6361 홍경일     부장              200       3200                  6200 00/06/09
select * 
  from TESTEMP 
 where MGR_ID = 6200;



11. 자신의 급여가 평균급여보다 많고 이름에 '최' 이 들어 가는 사원과  동일한 부서에서 근무하는 사원의 정보를 검색하시오.
        EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
    ---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
          6351 최원석     부장              300       2850                  6200 00/05/31
          7910 최준혁     경리              300       1000                  6351 01/05/01
          7920 조성미     사무직            300       1050                  6351 01/03/18

select *
  from TESTEMP
 where DEPT_ID in (
                    select DEPT_ID
                      from TESTEMP
                     where SAL > (select avg(SAL) from TESTEMP)
                       and EMP_NAME like '%최%'
                  );

12. 모든 부서의 평균 급여보다 급여를 많이 받는 사원의 정보를 검색하시오.
        EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
    ---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
          6200 민병권     대표이사          200       5000                       97/12/17
          6311 송지연     부장              100       3500                  6200 98/12/17
          6321 정순진     부장              400       3800        500       6200 99/04/20
          6351 최원석     부장              300       2850                  6200 00/05/31
          6361 홍경일     부장              200       3200                  6200 00/06/09
          7878 박성희     연구직            200       3000                  6361 01/06/05
          7901 마동석     연구직                      3000                       01/12/03

    7개 행이 선택되었습니다.

select *
  from TESTEMP as a 
 where a.SAL > (select avg(b.SAL)
                  from TESTEMP as b
               );


13.    각 부서의 평균 급여보다 급여를 많이 받는 사원의 정보를 검색
        EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
    ---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
          6200 민병권     대표이사          200       5000                       97/12/17
          6311 송지연     부장              100       3500                  6200 98/12/17
          6321 정순진     부장              400       3800        500       6200 99/04/20
          6361 홍경일     부장              200       3200                  6200 00/06/09
select *
  from TESTEMP as a
 where a.SAL > (select avg(b.SAL)
                  from TESTEMP as b
                 where b.DEPT_ID = a.DEPT_ID
               );
select * from testemp  where  sal  > all (   select  avg(sal) from testemp  group by dept_id );

14.  홍양숙 사원의 부서명(dname)을 검색하시오.
    DNAME
    --------------------
    영업부

select DNAME
  from TESTDEPT
 where DEPT_ID = (select DEPT_ID
                    from TESTEMP
                   where EMP_NAME = "홍양숙"     
                 );

15.  dept_id가 100인 사원급여의 최대값보다 많이 받는 사원을 검색하시오.

    EMP_ID EMP_NAME   JOB           DEPT_ID        SAL      BONUS     MGR_ID HIREDATE
---------- ---------- ---------- ---------- ---------- ---------- ---------- --------
      6200 민병권     대표이사          200       5000                       97/12/17
      6321 정순진     부장              400       3800        500       6200 99/04/20

select *
  from TESTEMP as a 
 where a.SAL > (select max(sal) 
                  from TESTEMP as a 
                 where a.DEPT_ID = 100);




