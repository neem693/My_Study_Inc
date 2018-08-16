package vo;

import java.util.Comparator;

public class PersonComp implements Comparator<PersonVo> {
	
	//정렬기준필드
	public static final int SORT_FIELD_NAME = 1;
	public static final int SORT_FIELD_AGE = 2;
	
	//정렬방식
	public static final int SORT_TYPE_ASC = 1;
	public static final int SORT_TYPE_DESC = 2;
	
	int sort_field = SORT_FIELD_NAME;
	int sort_type = SORT_TYPE_ASC;
	
	
	
	
	
	

	public int getSort_field() {
		return sort_field;
	}



	public void setSort_field(int sort_field) {
		this.sort_field = sort_field;
	}



	public int getSort_type() {
		return sort_type;
	}



	public void setSort_type(int sort_type) {
		this.sort_type = sort_type;
	}



	@Override
	public int compare(PersonVo o1, PersonVo o2) {
		
		int ret = 0;
		if(sort_field == SORT_FIELD_NAME) {
			if(o1.getName().compareTo(o2.getName())>0) ret = 1;
			else if(o1.getName().compareTo(o2.getName())<0) ret = -1;
		}
		else if(sort_field == SORT_FIELD_AGE)
		{
			if(o1.getAge() > o2.getAge()) ret = 1;
			else if(o1.getAge() < o2.getAge()) ret =-1;
		}

		if(sort_type == SORT_TYPE_DESC)
			ret = - ret;
		
		
		return ret;
	}

}
