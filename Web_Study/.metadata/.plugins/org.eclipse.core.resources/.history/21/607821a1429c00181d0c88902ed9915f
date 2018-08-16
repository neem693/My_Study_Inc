/*

--일련번호관리객체

*/


drop table board

create table board(

idx int, --일련번호
id	varchar2(100), 		--작성자 아이디
name varchar2(100), 	--작성자 이름
subject varchar2(300), 	--제목
content clob, 			--내용
pwd	varchar2(100),		--비밀번호
ip varchar2(100), 		--ip
regdate date, 			--작성일자
readhit int, 			--조회수
--답변형게시판관리속성
ref 	int,			--주인글 번호
step 	int,			--수식적 순서
depth 	int 			--수평적 순서
)




alter table board
add constraint pk_board_idx primary key(idx)


--외래키 지정
alter table board
add constraint fk_board_id foreign key(id) references member(id)

select * from member;

select * from board

delete from board where idx = 6

insert into board values(seq_board_idx.nextVal,'hong','홍길동','내가1등','제곧내',1234,'127.0.0.1',sysdate,0,seq_board_idx.currVal,0,0)
--답글쓰기 인서트 문

insert into board values(seq_board_idx.nextVal,'admin','관리자','그래 네가 1등이다','일등이나 해라',1234,'127.0.0.1',sysdate,0,1,1,1)
insert into board values(seq_board_idx.nextVal,'admin','관리자','근데 정말 1등하고 싶냐?','네까진 놈이',1234,'127.0.0.1',sysdate,0,1,2,2)

insert into board values(seq_board_idx.nextVal,'hong','홍길동','오늘은 여기까지','관리자놈아',1234,'127.0.0.1',sysdate,0,seq_board_idx.currVal,0,0);
insert into board values(seq_board_idx.nextVal,'hong','홍길동','도배한다. 오늘은 에어컨이 안나오니까 도배한다. 냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐냐','에어컨',1234,'127.0.0.1',sysdate,0,seq_board_idx.currVal,0,0);


commit



delete from board where idx>=34

create or replace view board_show as select rownum no,s.* from (select * from board order by ref desc,step asc) s

create or replace view board_show_rank as select  rank() over(order by ref desc,step asc) no ,b.* from(select * from board) b



select * from board_show_rank



select * from member



update board set id = 1,ref =1 where idx = 11

rollback

update board set idx =1,ref = 1 where idx =11
update board set idx=3 where idx =13

update board set subject = '뭐지? 이건',content = '야야야야야',pwd=121212 where idx = 48


select *
from board_show
where ref = 60


--select b2.*
--from board b1 inner join board b2
--on b1.idx = b2.ref
--where b1.idx = 47 and b2.idx 

select count(*)
from board
where ref = 47 and step>6;


alter table board
ADD(del NUMBER(1));

update board set del = 0;



select * from board where ref = 60;
select * from board where idx = 65;
	select nvl(count(*),0)
	from board
	where ref =60 and step>3
