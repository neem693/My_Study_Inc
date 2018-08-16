select sysdate 입대일자,add_months(sysdate,21) 제대일자 from dual;

select * from sawon;



   
        select sabun,saname,sahire,months_between(sysdate,sahire) 근무월수
        from sawon;



select sabun,saname,sahire,
		floor(mod(months_between(sysdate,sahire),12)) 전체근무월수,
		floor(months_between(sysdate,sahire)/12) 근무년수,
		round(sapay/13 + 0.5,0) as 월급,
		round(months_between(sysdate,sahire) * round(sapay/13 + 0.5,0)/12,0) as 퇴직금
from sawon;


