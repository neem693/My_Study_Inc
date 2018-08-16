
--시퀀스 생성
create sequence seq_visit_idx;

--방명록 테이블 생성
drop table visit;

create table visit(

idx int,
name varchar2(100) not null,
content clob not null,
pwd varchar2(100) not null,
ip varchar2(100) not null,
regdate date  --작성일자

)
alter table visit
add constraint pk_visit_idx primary key(idx);


--샘플
insert into visit values(seq_visit_idx.nextVal,'오라트리','안녕하세요. 하하하하하하하호호호하하하하하하히히히히히히히히다가가가가기기기기마마마마사사사사오오오오오오오오오','1234','127.0.0.1',sysdate);
insert into visit values(seq_visit_idx.nextVal,'이길동','냠냠냠냠','1234','127.0.0.1',sysdate);

update visit set name ='SCP재단',content='1231231234',pwd='1234',regdate=sysdate where idx=6
select * from visit;
delete from visit;