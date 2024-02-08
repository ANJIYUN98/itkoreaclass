-- -------------------
-- Stored Procedure
-- -------------------
-- 데이터베이스에서 실행 가능한 저장 프로그램
-- SQL문들의 논리적인 묶음
-- Function(함수)와 유사하나 특정부분에서의 차이점이 존재한다.
-- (함수 : 수를 받아서 처리하는 논리적 공간)

-- ------------------
-- Stored Procedure와 Function 과의 공통점
-- ------------------ 
-- 01 재사용성
-- 02 모듈화
-- 03 매개변수의 존재
-- 04 흐름제어 처리(if, case, while 사용가능)
-- 05 트랜잭션 처리
-- 06 커서 사용
-- 07 변환값 존재
-- 08 동적 SQL문 실행가능(prepare - execute)

 
-- ------------------
-- Stored Procedure 와 Function 과의 차이점
-- ------------------ 
-- 반환값
	-- 프로시저에서는 반환값이 필수는 아니다
	-- 함수에서는 항상 값을 반환한다.

-- 허용되는 문맥
	-- 프로시저는 SELECT, INSERT, UPDATE, DELETE문과 같은 SQL문 내에서 직접호출 가능
	-- 함수는 주로 SELECT 문이나 WHERE절에서 호출되어 사용, SQL문에서 직접 호출되는 경우가 적음
    
-- 트랜잭션
	-- 프로시저 : 트랙잭션 내에서 여러 SQL문을 실행 할 수 있다.
    -- 함수 : 주로 읽기 전용 작업에 사용되며, 트랜잭션에서 변경사항을 가지지 않도록 설계
    
-- 예외처리
	-- 프로시저 : 프로시저 내에서 예외처리
    -- 함수 : 예외처리가 가능하지만 주로 SELECT문을 사용하기 때문에(조회) 예외처리를 적용하는 경우가 적음


-- --------------------
-- 예제 01
-- --------------------

delimiter $$
create procedure pro1()
begin
	-- 변수 선언
    declare var1 int;
    -- 값 삽입
    set var1 = 100;
    -- if문(조건절)
    if var1 = 100 
		then
			select 'var1은 100입니다';
		else
			select 'var1은 100이 아닙니다';
	end if;

end $$
delimiter ;

call pro1();

show procedure status;
show procedure status where db='shopdb';

call pro1();


-- 02 프로시저(Argument - Parameter)


delimiter $$
create procedure pro2(in param int)
begin
	
    -- if문(조건절)
    if param = 100 
		then
			select param, '은 100입니다';
		else
			select param, '은 100이 아닙니다';
	end if;

end $$
delimiter ;

call pro2(105);
call pro2(100);


-- 03 프로시저 (테이블에 적용)
delimiter $$
create procedure pro3(in amt int)
begin
	select * from buytbl where amount >= amt;
    
end $$
delimiter ;

call pro3(4);
call pro3(5);
call pro3(6);



-- 04 프로시저 테이블에적용(if)

delimiter $$
create procedure pro4(in amt int, isGt int)
begin
	if isGt != 0 -- 0이 아니다
		then
			select * from buytbl where amount >= amt;
		else
			select * from buytbl where amount <= amt;
	end if;
end $$
delimiter ;

-- 참, 거짓 (c언어에는 0이 거짓이고 나머지는 다 참이다.)
call pro4(3,0);
call pro4(3,1);



-- 05 프로시저 평균 구하기
drop procedure pro5;

delimiter $$
create procedure pro5()
begin
	declare avg_total_price double;
    set avg_total_price = (select avg(amount*price) from buytbl);
    select *, amount*price, if(amount*price >= avg_total_price, '평균이상', '평균이하') as '평균이상/이하' from buytbl;
end $$
delimiter ; 

select *, amount*price, if(amount*price >= avg_total_price, '평균이상', '평균이하') as '평균이상/이하' from buytbl;

call pro5();


-- 연습문제
-- 1 usertbl에서 출생년도를 입력받아 해당 출생년도보다 나이가 많은 행만 출력
-- birthyear 열을 이용
-- 프로시저명 : older(in param int)

select * from usertbl;
drop procedure older;

delimiter $$
create procedure older(in param int)
begin
	select * from usertbl where birthyear < param;
end $$
delimiter ; 

call older(1970);

-- 2 근태일, 가입일로부터 지난일 구하기(usertbl)
-- 가입일로부터 지난 날짜 확인 (테이블 조회시 열하나 추가해서 보여주기)
-- select curdate(); -- 현재 날짜(YYYY-MM-DD)
-- select now(); -- 현재 날짜시간
-- select curtime(); -- 현재 시간
-- select *, ceil(datediff(curdate(),mDate)/365) as '근속년수' from usertbl;


-- ceil은 소수점 올리기???
select *, ceil(datediff(curdate(),mDate)/365) as '근속년수' from usertbl;
select *, ceil(datediff(curdate(),mDate)) as '근속일수' from usertbl;

delimiter $$
create procedure exam2()
begin
	select *, ceil(datediff(curdate(),mDate)) as '가입일로부터 N일' from usertbl;
end $$
delimiter ; 

call exam2();


-- 3 mdate를 입력받아 해당 mdate년도 보다 빠른 값 구하기

select * from usertbl;
delimiter $$
create procedure fast(in param int)
begin
	select * from usertbl where year(mdate) < param;
end $$
delimiter ; 

call fast(2010);



-- 06 인자 2개

delimiter $$
create procedure pro6(in arg1 int, in arg2 int)
begin
	select * from usertbl where height between arg1 and arg2;
end $$;
delimiter ;

call pro6(170, 180);



-- 07 인자 3개
drop procedure pro7;

select 
*,
 case
	when amount >= 10 then 'VIP'
    when amount >= 5 then '우수'
    when amount >= 1 then '일반'
    else '구매없음'
end as 'GRADE'
 from buytbl;



delimiter $$
create procedure pro7(in arg1 int, in arg2 int, in arg3 int)
begin
	select 
*,
 case
	when amount >= arg1 then 'VIP'
    when amount >= arg2 then '우수'
    when amount >= arg3 then '일반'
    else '구매없음'
end as 'GRADE'
 from buytbl;
end $$;
delimiter ;

call pro7(10,5,1);


-- 08 프로시저 + 반복문
delimiter $$
create procedure proc_while_01()
begin
	-- HELLO WORLD를 10회 반복해서 출력
    declare i int;
    set i = 1;
    while i <= 10 do
		select "HELLO WORLD";
		set i=i+1;
	end while;
    
end $$;
delimiter ;

call proc_while_01();


-- 08_2 외부에서 인자받기
delimiter $$
create procedure proc_while_02(in n int)
begin
	-- HELLO WORLD를 10회 반복해서 출력
    declare i int;
    set i = 1;
    while i <= n do
		select "HELLO WORLD";
		set i=i+1;
	end while;
    
end $$;
delimiter ;

call proc_while_02(3);



-- 09_01 1~10 합

drop procedure proc_while_03;
delimiter $$
create procedure proc_while_03()
begin
	declare i int;
    declare sum int;
    set i =1;
    set sum =0;
    
    while i<=10 do
		set sum = sum+i;
		set i=i+1;
    end while;
    select sum;
end $$;
delimiter ;

call proc_while_03();

-- 09_02 1~n 합

delimiter $$
create procedure proc_while_04(in n int)
begin
	declare i int;
    declare sum int;
    set i =1;
    set sum =0;
    
    while i<=n do
		set sum = sum+i;
		set i=i+1;
    end while;
    select sum;
end $$;
delimiter ;

call proc_while_04(4);



-- 09_03 n~m 합 (n < m)

delimiter $$
create procedure proc_while_05(in n int, in m int)
begin
	declare i int;
    declare sum int;
    declare tmp int; -- 임시 공간
    
	-- m은 n보다 작으면 안되니까 임시 공간 만들어서 스왑
    -- 임시공간 if를 set보다 먼저 선언해야 적용됨 
    if n>m
		then 
            set tmp = n;
            set n = m;
            set m = tmp;
    end if;
    
    set i =n;
    set sum =0;
    
    while i<=m do
		set sum = sum+i;
		set i=i+1;
    end while;
    select sum;
end $$;
delimiter ;

call proc_while_05(3,1);


-- 09_04 2단 구구단

create table googoodantbl(mul int, i int, result int); 
delimiter $$
create procedure proc_while_06()
begin
	declare i int;
    declare mul int;
    set i =1;
    set mul =2;
    
    while i<=9 do
		insert into googoodantbl values(mul, i, i*mul);
		set i=i+1;
    end while;
end $$;
delimiter ;

call proc_while_06;
select * from googoodantbl;



-- 09_05 n단 구구단
 
 drop procedure proc_while_07;
 create table googoodan2tbl(mul int, i int, result int); 
delimiter $$
create procedure proc_while_07(in n int)
begin
	declare i int;
    declare mul int;
    set i =1;
    set mul = n;
    
    while i<10 do
		insert into googoodan2tbl values(mul, i, i*mul);
		set i=i+1;
    end while;
end $$;
delimiter ;

call proc_while_07(3);
select * from googoodan2tbl;


-- 반환값 지정

delimiter $$
create procedure proc_output_01(in h_val int, out o_val char(100))
begin
	select userid into o_val from usertbl where height = h_val; -- set 써도 되고 into 넣어도 됨
end $$
delimiter ;

set @o_value='';
call proc_output_01(182, @o_value);
select @o_value;

select * from usertbl where height = 182;












