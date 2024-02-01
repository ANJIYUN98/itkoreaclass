
set @var1 = 100; -- 변수 지정
set @var2 = 200;

select @var1,@var2;
select @var1>@var2;
select if(@var1>@var2,concat(@var1,'이 더 큽니다'),concat(@var2,'이 더 큽니다'));

select * ,if(amount>5,'우수고객','일반고객') as '등급' from buytbl;



-- 키가 170이상이면 170이상 170미만면 170미만로 표시
select *,if(height>=170,'170이상', '170미만') from usertbl;


select case 6
when 1 then '일'
when 5 then '오'
when 10 then '십'
else '몰라'
end as 'CASETEST';


select
*,
case
when amount>=10 then 'VIP'
when amount>=5 then '우수'
else '일반'
end as '등급'
from buytbl;



