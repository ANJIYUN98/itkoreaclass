use shopdb;

 -- INSERT
 select * from buytbl;
 create table tbl_buy_copy4(select * from buytbl);
 select * from tbl_buy_copy4;
 
 -- 한번에 여러 값 넣기
 insert into tbl_buy_copy4 values
 (8, 'aad', '운동화', '의류', 1000, 2),
 (9, 'aad', '운동화', '의류', 1000, 2),
 (10, 'aad', '운동화', '의류', 1000, 2),
 (11, 'aad', '운동화', '의류', 1000, 2);
 
-- Auto_increment (넘버링 자동 증가) 
desc tbl_aa;
insert into tbl_aa(name) values('홍길동');
insert into tbl_aa(name) values('남길동');
insert into tbl_aa(name) values('서길동');
select * from tbl_aa;

-- 다른 방법
insert into tbl_aa values(null, '김민수');

delete from tbl_aa; -- 삭제했다가 다시 값을 집어 넣으면 넘버 카운팅이 1부터가 아닌 이어서 됨
select * from tbl_aa;
insert into tbl_aa(name) values('홍길동');

-- auto-increment 초기화
delete from tbl_aa;
alter table tbl_aa auto_increment=0;
insert into tbl_aa(name) values('홍길동'); -- 초기화 시키고 다시 값을 넣으면 넘버가 1이 됨
select * from tbl_aa;


 
 -- UPDATE
 
 
 -- DELETE