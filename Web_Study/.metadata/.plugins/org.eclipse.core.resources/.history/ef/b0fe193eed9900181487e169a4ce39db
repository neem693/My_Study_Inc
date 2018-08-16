

--장바구니 일련번호
create sequence seq_cart_idx

--장바구니 테이블
create table cart
(
  c_idx  int  primary key,
  c_cnt  int  not null,
  p_idx  int,
  m_idx  int
)

--상품테이블(product)의 idx와 p_idx간의 외래키 설정
alter table cart
  add constraint fk_cart_p_idx foreign key(p_idx) 
                               references product(idx)

alter table cart
  add constraint fk_cart_m_idx foreign key(m_idx) 
                               references member(idx)


select * from member;
select * from product


insert into cart values(seq_cart_idx.nextVal,1,2,2);
insert into cart values(seq_cart_idx.nextVal,1,1,2);
insert into cart values(seq_cart_idx.nextVal,1,9,2);

insert into cart values(seq_cart_idx.nextVal,1,11,13);
insert into cart values(seq_cart_idx.nextVal,1,13,13);
insert into cart values(seq_cart_idx.nextVal,1,9,13);

select * from cart

commit

-- Join을 통해서 조회정보를 추출
create or replace view cart_view
as
	select
	   p.idx p_idx,c_idx, m_idx,m.name m_name, p_num,p_name,p_price,p_saleprice,
	   c_cnt, c_cnt* p_saleprice amount
	from product p inner join  cart c on p.idx = c.p_idx  
	inner join member m on m.idx = c.m_idx

select * from cart_view;

--장바구니 상품의 총계
select sum(amount) from cart_view;
















