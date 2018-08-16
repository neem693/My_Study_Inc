



/*dept->sawon foreign key 설정*/
 alter table sawon
 add constraint fk_sawon_deptno foreign key(deptno)
 								references dept(deptno);
 								
 								


alter table gogek
add constraint fk_goeck_damdang foreign key(godam)
								references sawon(sabun);
								
								
alter table sawon
add constraint fk_sawon_samgr foreign key(samgr)
								references sawon(sabun);
								

								
								
								
								
select * from sawon,dept
where sawon.deptno = dept.deptno;


select sabun,saname,sajob,dname
from sawon inner join dept on sawon.deptno = dept.deptno;
								
select * from gogek;
							
select 
	sabun,saname,dname,goname
	from sawon s,dept d,gogek g
	where 	s.deptno = d.deptno
			and
			s.sabun = g.godam
	order by sabun;
	
	
	
	
	

	
	
select sabun,saname,dname,goname
from sawon inner join dept 
on sawon.deptno = dept.deptno
inner join gogek on sawon.sabun = gogek.godam
order by sabun;


select 
	sabun,saname,dname,goname
	from sawon s,dept d,gogek g
	where 	s.deptno = d.deptno
			and
			s.sabun = g.godam(+)
	order by sabun;
	
	

	
	
	
select sabun,saname,dname,goname
from sawon inner join dept 
on sawon.deptno = dept.deptno
left outer join gogek on sawon.sabun = gogek.godam
order by sabun;
	
select * from sawon;

select s.sabun,s.saname,m.saname 상사,m.sajob 상사직위
from sawon s,sawon m
where s.samgr = m.sabun
order by sabun;

select s.sabun,s.saname,m.saname 상사,m.sajob 상사직위
from sawon s left outer join sawon m
on s.samgr= m.sabun
order by sabun;

select * from gogek;

select s.saname,g.goname,d.dname,s2.sabun,s2.saname,g2.goname
from sawon s inner join gogek g
on s.sabun = g.godam
inner join dept d
on s.deptno = d.deptno
inner join sawon s2
on s.samgr = s2.sabun
inner join gogek g2
on s2.sabun = g2.godam;
								