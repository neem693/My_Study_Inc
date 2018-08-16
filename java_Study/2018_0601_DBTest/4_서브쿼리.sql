
select * from sawon
where deptno=(select deptno from sawon where saname = '장동건');


##장동건과 직급이 동일한 직원추출
select * from sawon where sajob = (select sajob from sawon where saname = '장동건');

##장동건과 동일한 년도에 입사한 직원추출
select * from sawon where to_char(sahire,'yyyy') = (select to_char(sahire,'yyyy') from sawon where saname = '장동건');

##장동건과 동일한 계절에 입사한 직원추출
select * from sawon
where case floor(to_number(to_char(sahire,'MM'))/3)
	when 1 then '봄'
	when 2 then '여름'
	when 3 then '가을'
	else '겨울'
	end = (

	select 
	case floor(to_number(to_char(sahire,'MM'))/3)
	when 1 then '봄'
	when 2 then '여름'
	when 3 then '가을'
	else '겨울' 
	end as 계절
	from sawon where saname = '장동건');
	
	
	##장동건과 동일한 년대에 입사한 직원 추출 (1993 =>1990년대 입사자)
	select * from sawon where  substr(to_char(sahire,'yyyy'),1,3)=(
	select substr(to_char(sahire,'yyyy'),1,3) from sawon where saname ='장동건');
	
	
	##장동건 또는 안재욱의 부서직원 추출
	select * from sawon where deptno in (select deptno from sawon where saname='안재욱' or saname = '장동건');
	
	
	
	
	
	
	