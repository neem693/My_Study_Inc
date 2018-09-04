create table visit(

idx int auto_increment,
name varchar(100) not null,
content varchar(2000) not null,
pwd varchar(100) not null,
ip varchar(100) not null,
regdate datetime  ,
constraint pk_visit_idx primary key(idx)
);




insert into visit(name,content,pwd,ip,regdate) values('오라트리','안녕하세요. 하하하하하하하호호호하하하하하하히히히히히히히히다가가가가기기기기마마마마사사사사오오오오오오오오오','1234','127.0.0.1',now());
insert into visit(name,content,pwd,ip,regdate)  values('이길동','냠냠냠냠','1234','127.0.0.1',now());

commit;


update visit set name ='SCP재단',content='1231231234',pwd='1234',regdate=sysdate where idx=6;
select * from visit;
delete from visit;