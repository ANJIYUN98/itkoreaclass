

-- ----------------------------
-- TRANSACTION
-- ----------------------------
-- 데이터베이스의 상태를 변환시키는 작업 단위(임의로 조절 가능)
-- 작업 중 문제가 생기면 rollback으로 원래 상태로 되돌릴 수 있음


-- ----------------------------
-- 트랜잭션 성질
-- ----------------------------
-- 원자성 : 트랜잭션 내의 모든 명령은 반드시 완벽히 수행되어야 함
-- 		 (트랜잭션의 연산은 모두 반영되도록 COMMIT 되거나 전혀 반영되지 않도록 ROLLBACK 되어야 함)
-- 		  어느 하나라도 오류가 발생하면 트랜잭션 전부가 취소되야 함
       
-- 일관성 : 트랜잭션의 작업 처리 결과는 항상 일관성이 있어야 함
-- 독립성, 격리성 : 트랜잭션 수행 시 다른 트랜잭션 연산에 끼어들지 못하도록 보장
-- 				수행 중인 트랜잭션은 완전히 완료될 때까지 다른 트랜잭션에서의 수행 결과를 참조할 수 없음
-- 영속성, 지속성 : 성공적으로 완료된 트랜잭션의 결과는 시스템이 고장 나더라도 영구적으로 반영되어야 함

drop table tbl_tx;


create table tbl_tx(
	no int primary key,
    name varchar(20),
    age int,
    gentder char(1)
);


delete from tbl_tx;

select * from tbl_tx;
insert into tbl_tx values(1,'aa',55,'W'); -- auto commit
insert into tbl_tx values(2,'bb',44,'M'); -- auto commit

start transaction; -- start transaction 하면 auto commit은 사라짐
	insert into tbl_tx values(3,'cc',50,'W'); 
	insert into tbl_tx values(4,'dd',40,'M'); 
    insert into tbl_tx values(5,'ee',60,'M'); 
	rollback; -- 전체 rollback 
    -- commit 하지 않고 rollback하면 start transaction하기 전으로 돌아감
    
    
    
    
-- save point로 어느 위치에서 rollback 할지 지정

select * from tbl_tx;

start transaction; 
	savepoint s1;
    insert into tbl_tx values(3,'cc',50,'W'); 
	insert into tbl_tx values(4,'dd',40,'M'); 
	savepoint s2;
	insert into tbl_tx values(5,'cc',50,'W'); 
	insert into tbl_tx values(6,'dd',40,'M'); 
    savepoint s3;
	insert into tbl_tx values(7,'cc',50,'W'); 
	insert into tbl_tx values(8,'dd',40,'M'); 
	rollback to s2;


select * from tbl_tx;
delete from tbl_tx;
drop procedure Tx_test;

-- 예외 처리

delimiter $$
create procedure Tx_test()
begin
	declare continue handler for SQLEXCEPTION 
	begin
		show errors;
        rollback;
	end;
    
	start transaction;
        insert into tbl_tx values(1,'dd',40,'M'); -- sql 문장 삽입
        insert into tbl_tx values(2,'dd',40,'M'); 
        insert into tbl_tx values(2,'dd',40,'M'); -- sql 오류 발생
    commit;
    
end $$
delimiter ;
call Tx_test();





































