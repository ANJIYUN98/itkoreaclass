-- 제약조건

-- PK
create table tbl_aa(
	id int primary key, 
	name varchar(45)
);
desc tbl_aa;

insert into tbl_aa values(2, '홍길동');
insert into tbl_aa values(1, '홍길동'); -- pk가 오름차순으로 index되어 있어서 나중에 넣어도 순번이 1번이 됨
select * from tbl_aa;

create table tbl_bb(
	id int,
    name varchar(45) not null,
    primary key(id)
);
desc tbl_bb;

create table tbl_cc(
	id int,
    name varchar(45) not null,
    primary key(id, name)
);
desc tbl_cc;

select * from information_schema.columns where table_schema='shopdb' and column_key='PRI'; -- 열 정보 보기

create table tbl_dd(
	id int,
    name varchar(45) not null
);
desc tbl_dd;

-- 구조변경(제약조건 추가)
-- alter table 테이블명 add constraint PK명 primary key(열1, 열2); 
alter table tbl_dd add constraint PK_tbl_dd_id primary key(id,name);



-- pk 삭제
alter table tbl_dd drop primary key;


-- 연습 문제
-- buytbl을 buytbl_copy로 구조+데이터 복사(create table_select 이용)하고 num를 primary key로 설정해보세요 


create table buytbl_copy(select * from buytbl);
desc buytbl_copy;
alter table buytbl_copy add constraint pk_buytbl_copy primary key(num);


-- FK
create table tbl_aa(
	id int primary key, 
	name varchar(45)
);
desc tbl_aa;

create table tbl_bb(
	num int primary key, 
    tbl_aa_id int,
	name varchar(45),
    -- constraint 외래키명 foreign key(외래키열명) references tbl_a(기본키열명)
    constraint fk_tbl_bb_tbl_aa foreign key(tbl_aa_id) references tbl_aa(id)
);
desc tbl_bb;

-- FK Options(외래키열의 옵션 정리)
-- RESTRICT    : PK, FK 열의 값의 변경 차단
-- CASCADE     : PK 열의 값 on Update, on Delete 이 변경시 FK 열의 값도 함께 변경
-- SET NULL    : PK 열의 값이 변경시 FK 열의 값을 NULL로 설정
-- SET DEFAULT : PK 열의 값이 변경시 FK 열의 값은 Default로 설정된 기본값을 적용
-- NO ACTION   : PK 열의 값이 변경시 FK 열의 값은 변경되지 않음으로 설정

-- 명령어로 옵션 정리
create table tbl_cc(
	num int primary key, 
    tbl_aa_id int,
	name varchar(45),
    -- constraint 외래키명 foreign key(외래키열명) references tbl_a(기본키열명)
    constraint fk_tbl_cc_tbl_aa foreign key(tbl_aa_id) references tbl_aa(id)
    on update cascade
    on delete set null
);


-- 연습문제
-- buytbl을 copy_buytbl로 구조+데이터 복사(create table_select 이용)하고 
-- num를 primary key로 설정한 뒤
-- userid를 FK설정(on delete restrict on update cascade)


create table copy_buytbl(select * from buytbl);
alter table copy_buytbl add constraint pk_copy_buytbl primary key (num);
alter table copy_buytbl add constraint fk_copy_buytbl foreign key (userid) references buytbl(userid) on update cascade on delete restrict;
desc copy_buytbl;



-- UNIQUE(중복 허용 x, NULL 허용 o) - ex) Email 등록
create table tbl_a(
	id int primary key,
    name varchar(45),
    email varchar(100) unique
);
desc tbl_b;

create table tbl_b(
	id int primary key,
    name varchar(45),
    email varchar(100),
    constraint uk_email unique(email)
);

-- 테이블 만들어진 후 유니크 설정
create table tbl_c(
	id int primary key,
    name varchar(45),
    email varchar(100)
);
desc tbl_c;
-- alter table 테이블명 add constraint 유니크제약조건 unique(열명);
alter table tbl_c add constraint uk_tbl_c_email unique(email);

-- 제약조건 삭제
alter table tbl_c drop constraint uk_tbl_c_email;



-- CHECK (값을 제한)
create table tbl_d(
	id int primary key,
    name varchar(50),
    age int check(age>=20 and age<=50),
    addr varchar(5),
    constraint CK_ADtbl_dDR check (addr in('대구', '부산', '대전')) 
);
desc tbl_d;
-- check 조건 확인
select * from information_schema.check_constraints;

-- 제약조건 삭제
alter table tbl_d drop check CK_ADDR;
alter table tbl_d drop check tbl_d_chk_1;



-- DEFAULT
create table tbl_e(
	id int primary key,
    name varchar(45) default '이름없음',
    addr varchar(100)
);
desc tbl_e;
insert into tbl_e values(1,'홍길동','null');
select * from tbl_e;
insert into tbl_e(id) values(2);



-- 조건 추가
alter table tbl_e alter column addr set default '대구';
insert into tbl_e(id) values(3);



-- 조건 삭제
alter table tbl_e alter column addr drop default;


