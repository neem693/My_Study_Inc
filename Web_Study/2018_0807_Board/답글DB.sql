/*

--老访锅龋包府按眉

*/


drop table comment_tb

select idx from board;

create sequence comment_seq

create table comment_tb
(
	idx int constraint CommentTb_IDX_PK primary key,
	id varchar2(100),
	name varchar2(100),
	ip varchar2(100),
	content varchar2(2000),
	regdate date,
	b_idx int 
	constraint CommentTb_BIDX_FK references board(idx) on delete cascade
)

select * from comment_tb where b_idx = 59
insert into comment_tb values(comment_seq.nextVal,'123','hong','efef','sdfef',sysdate,2)

select * from comment_tb

create or replace view comment_tb_view 
as
select c.*
from (select * from comment_tb) c

select * from comment_tb_view 
drop view comment_tb_view



		select *
		from (select rownum no, c.* from comment_tb c where b_idx =91) 
		where no between 6 and 10

		
		
		select rownum as no, c.*
		from comment_tb_view c
		where b_idx = 91
		
		
	
		
		