create database testdb1;



-- 1번
use testdb1;
create table tbl_member(
	member_id int not null,
    member_name varchar(10) not null,
    member_identity varchar(10),
    member_grade char(2) not null,
    member_addr varchar(100) not null,
    member_phone varchar(20)
);

desc tbl_member;


create table tbl_book(
	book_code int not null,
    classification_id int not null,
    book_author varchar(45),
    book_name varchar(45),
    publisher varchar(45),
    isrental char(1) not null
);

desc tbl_book;

create table tbl_rental(
	rental_id int not null,
    book_code int not null,
    member_id int not null
);

desc tbl_rental;



-- 2번
alter table tbl_member modify member_id int auto_increment primary key;

-- 3번
alter table tbl_book modify book_code int auto_increment primary key first;

-- 4번 
alter table tbl_rental modify rental_id int auto_increment primary key first;

-- 5번
alter table tbl_rental add constraint fk_rental_book_bookcode
foreign key (book_code) references tbl_book(book_code)
on update restrict
on delete cascade;

-- 6번 
alter table tbl_rental add constraint fk_rental_member_id
foreign key(member_id) references tbl_member(member_id)
on update cascade
on delete cascade;

-- 7번
alter table tbl_member modify member_grade char(3);
insert into tbl_member values
(111,'aaa','111','일반','대구','010-111-222'),
(222,'bbb','111','VIP','울산','010-111-222'),
(333,'ccc','111','VIP','인천','010-111-222'),
(444,'ddd','111','일반','부산','010-111-222'),
(555,'eee','111','VIP','서울','010-111-222'),
(666,'fff','111','일반','경기','010-111-222');

select * from tbl_member;

insert into tbl_book values
(1010,1,'윤성우','열혈C','오렌지미디어','1'),
(1011,1,'남궁성','JAVA의정석','00미디어','1'),
(1012,1,'남길동','이것이리눅스다','한빛미디어','1'),
(2010,2,'데일카네기','인간관계론','00미디어','1'),
(2011,2,'홍길동','미움받을용기','00미디어','1');

select * from tbl_book;

insert into tbl_rental values
(1,1010,111),
(2,1011,222),
(3,1012,333);

select * from tbl_rental;


-- 8번
select column_name, is_nullable, column_type, column_key, extra, privileges
from information_schema.columns
where table_name = 'tbl_member';


select column_name, is_nullable, column_type, column_key, extra, privileges
from information_schema.columns
where table_name = 'tbl_book';

select *
from information_schema.table_constraints
where table_name = 'tbl_rental';


-- 9번
show index from tbl_member;
alter table tbl_member add index index_mem(member_addr);


alter table tbl_book add index index_book(book_author, book_name, publisher);
show index from tbl_book;


-- 10번
create view view_showrental
as
select rental_id, member_name, book_name
from tbl_rental R
inner join tbl_member M
on R.member_id = M.member_id
inner join tbl_book B
on R.book_code = B.book_code;

select * from view_showrental;