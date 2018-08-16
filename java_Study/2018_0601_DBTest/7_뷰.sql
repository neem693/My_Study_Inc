create or replace view sawon_view_man
as
select * from sawon where sasex = '남자';


select * from sawon_view_man;

create or replace view sawon_view_man
as
select count(*) 인원수,
 case  floor(to_number(substr(sahire,4,2))/3)
    when   1    then '봄'
    when   2    then '여름'
    when   3    then '가을'
    else '겨울'
    end as 계절
    from sawon
    group by case floor(to_number(substr(sahire,4,2))/3)
    when   1    then '봄'
    when   2    then '여름'
    when   3    then '가을'
    else '겨울'
    end
    order by case floor(to_number(substr(sahire,4,2))/3)
    when   1    then '봄'
    when   2    then '여름'
    when   3    then '가을'
    else '겨울'
    end;
    
    
    
    select * from gogek;
    
    create or replace view gogek_view
    as
	    select gobun,goname,goaddr,
	    to_number(substr(gojumin,1,2)) +
	    (
	    case when substr(gojumin,8,1) in (1,2,5,6) then 1900
	    else 2000
	    end
	    )  as year, 
	    to_number(substr(gojumin,3,2)) month, to_number(substr(gojumin,5,2)) day 
	    from gogek;
	    
	    
	    
	    create user test2 identified by test2;
	    grant connect to test2;
	    
	    ##데이터 소유주(dbo.test)가 test2에게 개체사용권한 부여
	    //개체 사용에 대한 권한
	    grant select on gogek_view to test2;
	    
	    
	    ##test2계정으로 조회
	    (test로부터 gogek_view의 select 권한부여 받은내용으로 쿼리 가능)
	    dbo.개체명
	    select s.*, sapay*0.1 as bonus from (select * from sawon) s;
	    
	    select 	s.*, 
	    		sapay*0.1 as bonus,
	    		(select avg(sapay) from sawon) as tot_avg,
	    		sapay - (select avg(sapay) from sawon) as gap
	    		from(select * from sawon) s
	    		
	   select 
	   s.*,
	   rank() over(order by sapay desc) as rank
	   from (select * from sawon)s
	   order by sabun;
	   
	   
	   select *
	   from(
	   select 
	   s.*,
	   rank() over(order by sapay desc) as rank
	   from (select * from sawon)s
	   order by sabun
	   )
	   where rank<=5;
	    
	   
	   
	   
	   
	    
	    
	    
