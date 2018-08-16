


/*성적 db*/

--일련번호관리객체(시퀀스)
drop sequence seq_sungtb_idx;
create sequence seq_sungtb_idx;

select seq_sungtb_idx.nextVal from dual


CREATE TABLE SUNGTB
(
	IDX INT,   --일련번호
	NAME VARCHAR2(100) NOT NULL,
	KOR INT,
	ENG INT,
	MAT INT
)

drop table sungtb;

alter table sungtb
add constraint pk_sungtb_idx primary key(idx)

select * from sungtb;

insert into sungtb(idx,name) values(seq_sungtb_idx.nextVal,'aaa');
insert into sungtb(idx,name,kor) values(seq_sungtb_idx.nextVal,'bbb',213);


--check 제약(점수범위설정)

alter table sungtb
add constraint ck_sungtb_kor check(kor between 0 and 100);
alter table sungtb
add constraint ck_sungtb_eng check(eng between 0 and 100);
alter table sungtb
add constraint ck_sungtb_mat check(mat between 0 and 100);


insert into sungtb values(seq_sungtb_idx.nextVal , '일길동',99,66,77);
insert into sungtb values(seq_sungtb_idx.nextVal , '이길동',89,67,87);
insert into sungtb values(seq_sungtb_idx.nextVal , '이길동',67,90,81);




create or replace view sungtb_view
as
	select s.*,
			kor+eng+mat as tot,
			round((kor+eng+mat)/3,1) as avg,
			rank() over(order by (kor+eng+mat) desc) as rank
	from
		(select * from sungtb)s
		order by idx;
		
		
		
insert into sungtb values(seq_sungtb_idx.nextVal,'만길동',100,100,100);

select * from sungtb_view;
			
select name from sungtb_view;

update sungtb set kor = 80,eng = 90, mat= 70 where idx=6;
update sungtb set name = '빵길동',kor=80,eng=70, mat=70 where idx =6;