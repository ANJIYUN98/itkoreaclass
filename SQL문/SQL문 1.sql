-- 00 확인
use shopdb;
show tables;
select * from usertbl;
select * from buytbl;
desc usertbl;
desc buytbl;

-- 01 select
 select * from usertbl;
 select userid, birthyear from usertbl;
 
 select userid as '아이디', birthyear as '생년월일' from usertbl; -- as 별칭지정
 select userid as '아이디', birthyear as '생년월일', concat(mobile1,'-', mobile2) as '연락처'
 from usertbl;
 
 -- 02 select where(조건절 - 비교연산자)
 select * from usertbl where name='김경호'; -- 동등 비교 연산자(=)
 select * from usertbl where userid='LSG';
 
 select * from usertbl where birthyear >= 1970; -- 대소 비교 연산자 (>=)
 select * from usertbl where height <= 170; -- 대소 비교 연산자(<=)
 
 -- 03 select whrer (조건절 - 논리연산자)
  -- and 연산자( 참 and 참)을 만족하는 경우
 select * from usertbl where birthyear >= 1970 and height >= 180;
  -- or 연산자([참 or 참], [거짓 or 참], [참 or 거짓])을 만족하는 경우
 select * from usertbl where birthyear >= 1970 or height >= 180;
  -- between and
 select * from usertbl where height >=170 and height <= 180;
  select * from usertbl where height between 170 and 180;
  
  -- in(포함문자열 - 완성된 문자열) , like(포함문자열 - 미완성된 문자열 필터링)
  select * from usertbl where addr in ('서울', '경남');
  select * from usertbl where addr='서울' or addr='경남';
  select * from usertbl where name='김범수';
  
  select * from usertbl where name like '김%'; -- 길이 제한 없는 모든 문자
  select * from usertbl where name like '%수'; -- 길이 제한 없는 모든 문자
  select * from usertbl where name like '김__'; -- _개수만큼의 길이제한 있는 모든 문자
  
  -- '경' 문자를 포함하는 모든 이름 검색?
  select * from usertbl where name like '%경%';
  
  
  -- 연습 문제
  show tables;
  select * from buytbl;
  
 -- 1 구매양(amount)가 5개 이상인 행을 출력
select * from buytbl where amount>=5;
 -- 2 가격이(price) 50 이상 500 이하인 행의 userid와 prodname 만 출력
select userid, prodname from buytbl where price>=50 and price<=500;
select userid, prodname from buytbl where price between 50 and 500;
 -- 3 구매양(amount)이 10 이상 이거나 가격이 100 이상인 행 출력
select * from buytbl where amount>=10 or price>=100;
 -- 4 UserID가 K로 시작하는 행 출력
select * from buytbl where userid like 'K%';
 -- 5 '서적'이거나 '전자'인 행 출력
select * from buytbl where groupname='서적' or groupname='전자';
select * from buytbl where groupname in ('서적', '전자');
 -- 6 상품 (ProdName)이 책이거나 userID가 W로 끝나는 행출력
select * from buytbl where prodname='책' or userid like '%W';
 -- 7 groupname이 비어있지 않는 행만 출력 (!= , <>)
select * from buytbl where groupname != ''; 
select * from buytbl where groupname != 'null'; 
select * from buytbl where groupname <> ''; 
select * from buytbl where groupname <> 'null'; 

-- 04 select 조건절 - 서브쿼리
select height from usertbl where name='김경호'; -- 김경호의 키
-- 김경호보다 큰키를 가지는 모든열의 값
select * from usertbl;
select * from usertbl where height > (select height from usertbl where name='김경호');
-- 성시경보다 나이가 많은 모든열의 값
select * from usertbl where birthyear < (select birthyear from usertbl where name='성시경');
-- 지역이 '경남'인 height보다 큰 행 출력
select * from usertbl where height > any(select height from usertbl where addr='경남');
select * from usertbl where height > any(select height from usertbl where addr in ('경남'));

-- all(모든 조건을 만족하는)
select * from usertbl where height > all(select height from usertbl where addr in ('경남'));
-- any(어느 조건이든 하나이상 만족)
select * from usertbl where height > any(select height from usertbl where addr in ('경남'));

-- 문제 buytbl
-- 1 amount가 10인 행의 price보다 큰 행을 출력하세요(서브쿼리)
select * from buytbl;
select * from buytbl where price > (select price from buytbl where amount = 10);
-- 2 userID가 K로 시작하는 행의 amount 보다 큰 행을 출력하세요(서브쿼리 + ANY)
select * from buytbl where amount > any(select amount from buytbl where userID like 'K%');
-- 3 amount 가 5인 행의 price보다 큰 행을 출력하세요(서브쿼리 + ALL)
select * from buytbl where price > all(select price from buytbl where amount=5);




-- 05 Select Order by
use shopdb;
-- 가입 날짜 기준으로 정렬
select * from usertbl order by mDate asc; -- 오름차순(asc)
select * from usertbl order by mDate desc; -- 내림차순(desc)

select * from usertbl where birthyear >= 1970 order by mdate;

-- 같은 값을 가진 행을 오름차순으로 차순변경(기존에는 같은 값에 한해 내림차순 되어있었음 ex.임재범, 이승기의 키)
select * from usertbl order by height, name; 
select * from usertbl order by height;

-- 06 distinct(중복값 없애기 - 단일 열 값을 기준으로 ex)다른 열에 다른 값이 들어있으면 안 사라짐)
select distinct addr from usertbl;


-- 07 limit(제한해서 조회하기)
select * from usertbl limit 3; -- (0번 인덱스를 기준으로 3개 보겠다.)
select * from usertbl limit 2,3; -- (2번 인덱스를 기준으로 3개를 보겠다.)

-- 08 복사(테이블 복사)
-- 08-01 구조 + 값 복사(PK, FK 복사 x)
create table tbl_buy_copy(select * from buytbl);
select * from tbl_buy_copy;
desc tbl_buy_copy; -- (관계형에 대한 속성 값들(ex. primarykey, foreign key)은 들어가지 않음)
desc buytbl;
create table tbl_buy_copy2(select userid, prodname, amount from buytbl);
select * from tbl_buy_copy2;

-- 08-02 구조만 복사(값은 복사 x, pk는 복사 o, fk는 복사 x, index o)
create table tbl_buy_copy3 like buytbl;
select * from tbl_buy_copy3;
desc tbl_buy_copy3;


-- 08-03 복사된 구조물에 값 삽입 (데이터만 복사)
insert into tbl_buy_copy3 select * from buytbl where amount >= 3;
select * from tbl_buy_copy3;


-- 연습문제 
-- 1 userid 순으로 오름차순 정렬
-- 2 price 순으로 내림차순 정렬
-- 3 amount 순으로 오름차순 prodname으로 내림차순 정렬
-- 4 prodname을 오름차순으로 정렬시 중복 제거
-- 5 userid열의 검색시 중복된 아이디 제거하고 select
-- 6 구매양(amount)가 3이상인 행을 prodname 내림차순으로 정렬
-- 7 usertbl의 addr가 서울, 경기인 값들을 cusertbl에 복사


select * from buytbl order by userid asc;
select * from buytbl order by price desc;
select * from buytbl order by amount asc, prodname desc;
select distinct prodname from buytbl order by prodname asc;
select distinct userid from buytbl;
select * from buytbl where amount >= 3 order by prodname desc;
create table cusertbl (select * from usertbl where addr in('서울', '경기'));
select * from cusertbl;









