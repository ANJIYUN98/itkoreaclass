
use testdb;

create table tbl_file(
	title varchar(50),
    filedata longblob
);

desc tbl_file;
select * from tbl_file;


insert into tbl_file 
values('practice', load_file('c:\\sql\\1234.zip'));

select * from tbl_file;

select filedata from tbl_file where title='practice'
into dumpfile 'c:/sql/down1.pdf';

delete from tbl_file;
select * from tbl_file;




-- 파일 다운로드
-- sql 폴더에 파일넣고 시작
insert into tbl_file 
values('practice.zip', load_file('c:\\sql\\practice.zip'));

select * from tbl_file;


-- 파일 업로드
-- sql 폴더에 있는거 삭제하고 시작
select filedata from tbl_file where title='practirce.zip'
into dumpfile 'c:/sql/down1.zip';











