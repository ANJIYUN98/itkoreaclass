-- -------------------------
-- TRIGGER
-- -------------------------
-- 데이터 변경 이벤트가 발생했을 때 추가적으로 자동 실행되는 프로그램
-- Before trigger : 이벤트 발생 이전에 작동되는 트리거
--                  INSERT, UPDATE, DELETE 세가지 이벤트로 작동
-- After trigger : INSERT, UPDATE, DELETE 등의 작업이 일어났을 때 작동하는 트리거



use shopdb;

-- 01 After Trigger

drop table c_usertbl;
drop table c_usertbl_bak;
create table c_usertbl select * from usertbl;
select * from c_usertbl;
create table c_usertbl_bak like c_usertbl; -- 백업 테이블 만들기(구조 복사)
select * from c_usertbl_bak;
alter table c_usertbl_bak add column type char(5);
alter table c_usertbl_bak add column U_D_date char(5);
alter table c_usertbl_bak change column U_D_date U_D_date datetime;
desc c_usertbl_bak;
select * from c_usertbl_bak;


delimiter $$
create trigger trg_c_usertbl_update
after update
on c_usertbl
for each row
begin -- 수정 이후 수정 전 데이터를 백업 테이블에 넣음
	insert into c_usertbl_bak values(
    old.userid,old.name,old.birthyear,old.addr,old.mobile1,old.mobile2,old.height,
    old.mDate,'수정',now()
    );
end $$
delimiter ;

show triggers;
show create trigger trg_c_usertbl_update;

select * from c_usertbl;
select * from c_usertbl_bak; -- 수정하면 수정 전 데이터가 들어감
update c_usertbl set name='바비' where userid='BBK';
update c_usertbl set addr='경남' where userid='EJW';


-- 02 삭제 트리거
delimiter $$
create trigger trg_c_usertbl_delete
after delete
on c_usertbl
for each row
begin
	insert into c_usertbl_bak values(
    old.userid,old.name,old.birthyear,old.addr,old.mobile1,old.mobile2,old.height,
    old.mDate,'삭제',now()
    );
end $$
delimiter ;

delete from c_usertbl where userid='KKH';
select * from c_usertbl_bak;

-- buytbl의 c_buytbl의 구조+값복사
-- c_buytbl의 구조만 복사한 c_buytbl_bak 만들기
-- c_buytbl_bak 에 type char(5)와 mDate datetime 을 열로 추가
-- c_buytbl의 update시 c_buytbl_bak에 내용저장되는 trg_c_buytbl_update 트리거 만들기
-- c_buytbl의 delete시 c_buytbl_bak에 내용저장되는 trg_c_buytbl_delete 트리거 만들기