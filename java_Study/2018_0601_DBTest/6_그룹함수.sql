
select count(*) 전체사원수, count(samgr) 일반사원수
from sawon


	select count(*) 전체사원수,
		   max(sapay) 최대급여액,
		   min(sapay) 최소급여액,
		   max(sahire) 최근입사일자,
		   min(sahire) 최초입사일자,
		   sum(sapay) 전체급여합계,
		   avg(sapay) 전체급여평균
	from sawon

 ##1.부서별 인원수 및 급여합계
 
 select deptno,
 		count(*) 인원수,
 		sum(sapay) 급여합계
 from sawon
 group by deptno 
 order by deptno;
 
 ##2. 부서별 성별 인원수
 select 
 	deptno,sasex,
 	count(*) 인원수
 	from sawon
 	group by deptno,sasex
 	order by deptno,sasex;
 
 ##입사년도별 
 select *
 from sawon;
 
 select to_number(to_char(sahire,'yyyy')) 년도별,count(*) 입사인원수
 from sawon
 group by to_number(to_char(sahire,'yyyy'))
 order by to_number(to_char(sahire,'yyyy'));
 
 
 ##입사년대별 인원수
 select 
 	count(*) 인원수,
 	substr(to_char(sahire,'YYYY'),1,3) || '0' as 입사년도
 	from sawon
 	group by substr(to_char(sahire,'YYYY'),1,3) || '0'
 	order by substr(to_char(sahire,'YYYY'),1,3) || '0';
 	
 	
 ##5. 입사계절별 인원수
 
 select case floor(to_number(substr(sahire,4,2))/3)
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
    end;
 
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

    
    
    
    
 select *
 from gogek;
 
 ##6. 고객테이블에서 거주지역별 인원수
 
 select substr(goaddr,1,2) 거주지역별,count(*) 인원수
 from gogek
 group by substr(goaddr,1,2);
 

 
 
 
 ##7. 
 
 select  substr(gojumin,1,1) || '0년도',count(*) 인원수
 from gogek
 group by substr(gojumin,1,1) || '0년도';
 
 
 
 select 
 case to_number(substr(gojumin,8,1))
 when 1 then '남'
 when 2 then '여'
 end 성별,
 count(*) 인원수
 from gogek
 group by case to_number(substr(gojumin,8,1))
 when 1 then '남'
 when 2 then '여'
 end;
 
 select deptno,
 		count(*)
 		from sawon
 		group by deptno
 		having count(*) >=5;
 		
 select *
 from sawon;
 
 select substr(saname,1,1) || '씨' as 성씨, count(*) 인원수
 from sawon
 group by substr(saname,1,1)
 order by substr(saname,1,1);
 
 
 select sapay 연봉,count(*) as 인원수
 from sawon
 group by sapay;
 
 
 select case 
 when floor(sapay/1000) * 1000>1000 then to_char(floor(sapay/1000) * 1000)
 when floor(sapay/1000) * 1000<1000 then '1000만원미만'
 end,
 count(*) 인원수
 from sawon
 group by case 
 when floor(sapay/1000) * 1000>1000 then to_char(floor(sapay/1000) * 1000)
 when floor(sapay/1000) * 1000<1000 then '1000만원미만'
 end;
	
 	
 	
 