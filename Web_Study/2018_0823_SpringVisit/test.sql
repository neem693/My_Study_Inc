select rownum num,v.* 
from (select * from visit order by idx desc) v
order by num asc


select rownum num,v.*
		from 
		(select * from visit
		order by idx desc) v
		where rownum between 1 and 5