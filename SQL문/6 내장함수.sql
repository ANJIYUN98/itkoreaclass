-- 내장함수

-- Concat(), Concat_ws() : 두 개 이상의 문자열을 결합
select concat('hello','-','world');
select concat('hello','-','world',5,6);

select concat_ws("-",'hello','world',5,6);

-- SubString()
select substring("HELLO WORLD",6); -- 6번 index부터 마지막 index까지 잘라냄
select substring("HELLO WORLD",1,7); -- 1번 index부터 7번째 index까지 잘라냄

select substring_index("HELLO MY NAME IS JUNG"," ",3); -- 찾는 문자열('공백')이 3번째 등장하면 그 뒤 index부터 버려짐
select userid, substring_index(mdate,'-',2) as'가입연월' from usertbl;


-- length()
select length("HelloWorld"); -- 문자열 길이 값 출력
select length("Hello World");

select length(lastname) from classicmodels.employees;

-- Lower(), Uppder()

-- Trim()
select trim(" HELLO WORLD "); -- 앞, 뒤 공백 제거

-- Replace
select replace("hello i have a dog", "dog", "cat");


-- instr
select instr("bowwow bowwow","wow");

-- lpad, rpad
select lpad("abc",7,"0");
select rpad("abc",7,"0");

-- left, right
select left("abcdefg",3);
select right("abcdefg",3);

-- mid
select mid("abcdefg",4,2);

-- bin,oct,hex
select 'h';
select bin(1);
select bin(2);
select bin(3);
select bin(4);
select bin(5);
select bin(6);
select bin(7);
select bin(8);
select bin(9);
select bin(10);
select bin(11);
select bin(12);
select bin(13);
select bin(14);
select bin(15);

-- REVERSE : 거꾸로 반환
select reverse("12345");

-- SPACE : 공백 반환
select concat("HELLO", space(5), "WORLD");

-- REPEAT : 문자열 반복
select repeat("hello",3);

-- LOCATE
select locate("ef","abcdefg");
select position("ef" in "abcdefg");
select instr("abcdefg", "ef");

select locate("ef", "abcdefgabcdefg",6); -- 시작위치 지정하기

-- FORMAT : 문자를 화폐단위로 지정하면 좋을 것 같음
select format(1231233.123,6);


-- 날짜관련 함수 생략
select mDate from usertbl;
select Year(mdate) from usertbl;
select Month(mdate) from usertbl;
select Day(mdate) from usertbl;

select now();
select date(now());
select curdate(); -- date()랑 같음
select time(now());
select curtime();

-- 현재 날짜시간에서 연,월,일,시,분,초를 각각 추출해내고 다음과 같은 포맷팅으로 출력하세요
-- YYYY#MM#DD-HH|mm|ss

select concat(year(now()),'#',month(now()),'#',day(now()),'-',hour(now()),'|',minute(now()),'|',second(now()));
select concat(replace(curdate(), '-','#'),"-", replace(curtime(),':','|'));










