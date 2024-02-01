-- 01 변수
-- 변하는 수
-- 수(Data, 자료)는 기본 선저장, 후처리를 원칙으로 한다.
-- 저장된 수가 특정상황에 있어 바뀔가능성이 있는 경우 이 수를 변수라고 한다

use shopdb;
set @var1 = 5;
set @var2 = 4.56; -- =는 대입연산자
set @var3 = "가수이름=>";

-- select로 출력
select @var1;
select @var2;
select @var3;
select @var1+@var2;

select @var3, name, addr from usertbl;
select @var3 as 'TITLE', name, addr from usertbl;


-- LIMIT에서 변수 사용
set @rowcnt = 5;
prepare sqlQuery01 from 'select * from usertbl order by height limit ?'; -- ?로 변수가 들어갈 공간을 만듬
execute sqlQuery01 using @rowcnt;



-- 형변환
-- cast
-- 연산작업시(ex 대입연산, 비교연산...) 자료형(Data Type)이 불일치시 자료형을 일치시키는 작업
-- 자료형변환(암시적 형변환) : 시스템에 의한 형 변환(데이터 손실을 최소화 방향)
-- 강제형변환(명시적 형변환) : 프로그래머에 의한 형 변환(프로그램 제작 목적에 따른 -> 데이터 손실 우려가 비교적 큼)

select mdate from usertbl;
select ('2024$01$01');
select cast('2024$01$01' as date); -- 문자열 형태를 날짜열 형태로 바꿈

select num, price*amount from buytbl;
select num, concat(cast(price as char(10)),'X',cast(amount as char(10))) as '가격*수량' from buytbl;
select num, concat(cast(price as char(10)),'X',cast(amount as char(10)),"=") as '가격*수량',
price*amount as '결과값'
from buytbl;

-- 비교연산자
 -- mysql에서는 문자열에 숫자가 들어가면 연산처리가 됨, 찐문자가 들어가면 연산안됨
select 100+200;
select '100'+200;
select '100'+'200';
select 'a100';
select 'a100'+'200'; -- 문자가 앞에 들어가면 숫자로 생각 안함
select 'a100'*1; -- 'a100'을 0으로 봄
select '10a0'+'200';
select '100a'+'200';

-- 숫자 비교연산의 결과 (참 :1, 거짓 :0)
select 1>2;
select 2>1;
select '1abcd'<2;
select 'a1bcd'<2; -- 문자열이 시작되면 그 이후로는 0으로 봄
select 'a1bcd'>2;
select 0 = 'mega';


-- 연습문제
-- 1.usertbl의 평균키를 구하라 (cast를 이용, 평균키 정수형으로 형변환 할 것)
select avg(height) from usertbl;
select cast(avg(height) as signed integer) as '평균키' from usertbl;

-- 2.'2020년 5월 7일' 문자열을 date자료형으로 바꿔서 출력하세요(예:2020-05-07)
select cast('2020-05-07' as date);
