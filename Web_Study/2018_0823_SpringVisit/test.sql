select rownum num,v.* 
from (select * from visit order by idx desc) v
order by num asc


select rownum num,v.*
		from 
		(select * from visit
		order by idx desc) v
		where rownum between 1 and 5
		
		
				select nvl(count(*),0)
		from visit
		
		
		
		select *
		from(
		select rownum num,v.*
		from
		(select * from visit
		order by idx desc) v
		)s
		where num between 6 and 19