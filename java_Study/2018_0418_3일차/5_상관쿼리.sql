##전체 직원중에서 최대급여자를 추출
select * from sawon
where sapay = 4500

##10번 부서의 최대급여자를 추출
select * from sawon
where sapay = 4000 and deptno =10;


##10번 부서의 최대 급여자를 추출
select max(sapay) from sawon;

##각부서의 최대급여자를 추출
select * from sawon
where 
(sapay=(select max(sapay) from sawon where deptno = 10) and deptno = 10)
or
 (sapay=(select max(sapay) from sawon where deptno = 20) and deptno = 20)
or
 (sapay=(select max(sapay) from sawon where deptno = 30) and deptno = 30)
or
 (sapay=(select max(sapay) from sawon where deptno = 40) and deptno = 40);
 
 
 
 ##상관쿼리이용해서 각 부서의 최대급여자를 추출
 select * from sawon s
 where sapay = (select max(sapay) from sawon where s.deptno=deptno);
 
 