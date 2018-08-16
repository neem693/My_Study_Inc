



--일련번호 관리객체

create sequence seq_photo_idx;

create table photo
(

idx 		int, --일련번호
title 		varchar2(100), --제목
filename 	varchar2(255), --화일명
pwd 		varchar2(100), -- 비번
ip 			varchar2(100), --IP
regdate 	date --날짜

)

alter table photo
add constraint pk_photo_idx primary key(idx);

select * from photo;