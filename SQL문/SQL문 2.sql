-- group by
use shopdb;
select userid, amount from buytbl;

-- userid별 amount 총합 (sum)
select userid, sum(amount) as '구매총량' from buytbl group by userid;

-- userid별 amount*price의 총합(sum)
select userid, sum(amount*price) from buytbl group by userid;
select userid, sum(amount*price) as '구매총액' from buytbl group by userid;

-- userid별 amount 평균(avg)
select userid, avg(amount) as '구매평균값' from buytbl group by userid;
-- truncate(값, 소숫점자리)
select userid, truncate(avg(amount*price),2) as '구매평균액' from buytbl group by userid;

-- max(), min()
select max(height) from usertbl;
select min(height) from usertbl;
-- 가장 큰 키를 가지는 user의 모든 열의 값 확인
select * from usertbl where height=(select max(height) from usertbl);
-- 가장 작은 키를 가지는 user의 모든 열의 값 확인
select * from usertbl where height=(select min(height) from usertbl);
-- 가장 큰 키와 가장 작은 키의 값만 확인
select * from usertbl where height=(select max(height) from usertbl) or height=(select min(height) from usertbl);

-- 연습 문제
-- 1 buytbl에서 userid 별로 구매량(amount)의 합을 출력하세요
-- 2 usertbl에서 키의 평균값을 구하세요
-- 3 buy테이블에서 최대구매량과 최소구매량을 userid와 함께 출력하세요
-- 4 buytbl의 groupname의 개수를 출력하세요


-- 문제 (classicmodels db로 이동 이후 작업하세요)
use classicmodels;
-- 1 customers테이블의 city를 그룸으로 creditlimit의 평균을 구하세요
-- 2 orderdetails 테이블의 ordernumber를 그룸으로 quntityordered의 총합을 출력하세요
-- 3 products테이블의 productvendor를 그룹으로 quantityinstock의 총합을 출력하세요



select userid, sum(amount) from buytbl group by userid;
select truncate(avg(height),2) from usertbl;
select userid,amount from buytbl where amount=(select max(amount) from buytbl) or amount=(select min(amount) from buytbl);
select count(groupname) from buytbl;


select city, avg(creditlimit) from customers group by city;
select orderNumber, sum(quantityOrdered) from orderdetails group by ordernumber;
select productVendor, sum(quantityinstock) from products group by productVendor;





-- 02 select group by + having (group by에 조건 붙일 때)
use shopdb;
select userid, sum(amount) as '구매총량' from buytbl group by userid having sum(amount)>5; -- o
select userid, sum(amount) as '구매총량' from buytbl group by userid having '구매총량'>5; -- x

select userid, truncate(avg(amount*price),2) as '구매평균액' 
from buytbl 
group by userid
having truncate(avg(amount*price),2) > 50
;

-- 03 select + group by + rollup (부분합과 총합 구하기)
select * from buytbl;
select num, groupname, sum(price*amount) from buytbl group by groupname, num with rollup; 
-- 총합만 구하기
select groupname, sum(price*amount) from buytbl group by groupname with rollup;

-- 지역별로 키의 평균구하고 전체 평균 구하기 (group by 뒤에 순서 중요 - addr로 먼저 묶고 userid로 묶음)
select userid, addr, avg(height) from usertbl group by addr,userid with rollup;


-- 연습문제

-- 1. prodname별로 그룹화 한 뒤 userid / prodname / price*amount 순으로 출력될 수 있도록 설정
-- 2. 1번 명령어에서 price*amount 값이 1000이상인 행만 출력
-- 3. price 가격이 가장 큰 행과 작은 행의 userid. prodname, price를 출력
-- 4. 다음 행 중에 그룹네임이 있는 행만 출력
-- 5. prodname 별로 총합을 구해보세요(rollup 사용)

select userid, prodname, sum(price*amount) from buytbl group by prodname, userid;
select userid, prodname, sum(price*amount) from buytbl group by prodname, userid having sum(price*amount) >= 1000;
select distinct userid, prodname, price from buytbl where price=(select max(price) from buytbl) or price=(select min(price) from buytbl);
select * from buytbl where groupname is not null;
select prodname,sum(price*amount) from buytbl group by prodname with rollup;



