use testdb;

-- --------------------
-- JOIN
-- --------------------
-- 두개 이상의 테이블을 서로 묶어서 하나의 조회 결과를 만드는데 사용


-- --------------------
-- JOIN 종류
-- --------------------
-- INNER JOIN : ON 이하의 조건절을 만족하는 행만 JOIN 
-- OUTER JOIN : ON 이하의 조건절을 만족하지 않는 행도 JOIN
   -- LEFT OUTER JOIN : 조건을 만족하지 않는 왼쪽 테이블의 행도 JOIN
   -- RIGHT OUTER JOIN : 조건을 만족하지 않는 오른쪽 테이블의 행도 JOIN
   -- FULL OUTER JOIN : 조건을 만족하지 않는 왼/오른쪽 테이블의 행도 JOIN
   
-- CROSS JOIN : 한쪽 테이블의 모든 행과 반대쪽 테이블의 모든 행을 조인, 조건절이 없음
-- SELF JOIN : 한 테이블 내에서 JOIN


-- INNER JOIN
-- 기본
use shopdb;
select * from usertbl;
select * from buytbl;

select * from usertbl -- 왼쪽 테이블 지정
inner join buytbl -- 오른쪽 테이블 지정
on usertbl.userid = buytbl.userid;


-- 원하는 열만 출력 (열 이름 중복시 특정 테이블의 열이름으로 선택해서 지정한다.)
select usertbl.userid, name, addr, mobile1, mobile2, prodname, price, amount
from usertbl 
inner join buytbl 
on usertbl.userid = buytbl.userid;
-- userid를 그냥 넣으면 두개가 존재해 모호하다는 에러가 뜸 그래서 usertbl.userid로 입력해야함


-- 별칭 지정 (별칭으로 U.userid 사용)
select U.userid, name, addr, mobile1, mobile2, prodname, price, amount
from usertbl U -- 'U' 별칭 지정
inner join buytbl B -- 'B' 별칭 지정
on U.userid = B.userid;


-- WHERE 조건절 적용
select U.userid, name, addr, mobile1, mobile2, prodname, price, amount
from usertbl U 
inner join buytbl B 
on U.userid = B.userid
where amount <= 5;


-- 연습문제
-- 1 바비킴의 userid, birthyear, prodname, groupname을 출력하세요
-- 2 amount*price 의 값이 100이상인 행의 name, addr, prodname, mobile1- mobile2를 (concat()함수 사용) 출력하세요
-- 3 groupname이 전자인 행의 userid, name, birthyear, prodname을 출력하세요

select U.userid, birthyear, prodname, groupname
from usertbl U 
inner join buytbl B 
on U.userid = B.userid
where name ='바비킴';


select name, addr, prodname, concat(mobile1,'-', mobile2) as PHONE
from usertbl U 
inner join buytbl B 
on U.userid = B.userid
where amount*price >= 100;



select U.userid, name, birthyear, prodname
from usertbl U 
inner join buytbl B 
on U.userid = B.userid
where groupname = '전자';



-- OUTER JOIN 

-- LEFT OUTER JOIN(on 조건을 만족하지 않는 left 테이블의 행도 출력)
select * 
from usertbl U
left outer join buytbl B 
on U.userid = B.userid;




-- RIGHT OUTER JOIN(on 조건을 만족하지 않는 right 테이블의 행도 출력)
select * 
from buytbl B
right outer join usertbl U
on U.userid = B.userid;


-- FULL OUTER JOIN(on 조건을 만족하지 않는 left, right 테이블의 행도 출력)
-- mysql에서는 full outer join 을 지원하지 않는다.
-- 대신 union 을 사용해서 left, right outer join을 연결한다.

select * from usertbl left outer join buytbl on usertbl.userid=buytbl.userid
union
select * from usertbl right outer join buytbl on usertbl.userid=buytbl.userid;




-- 여러 테이블들을 JOIN
-- INNER JOIN
use classicmodels;

select P.productCode, productName, quantityOrdered, priceEach, orderDate, O.status
from orderdetails OD
inner join products P
on OD.productCode = P.productCode
inner join orders O 
on O.orderNumber = OD.orderNumber; 


-- 여러 RIGHT OUTER JOIN

select P.productCode, productName, quantityOrdered, priceEach, orderDate, O.status
from orderdetails OD
right outer join products P
on OD.productCode = P.productCode
right outer join orders O 
on O.orderNumber = OD.orderNumber; 








