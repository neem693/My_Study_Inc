package vo;

import java.util.List;

public class SawonSeasonVo {
	
	String season;
	List<SawonVo> sa_list;
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public List<SawonVo> getSa_list() {
		return sa_list;
	}
	public void setSa_list(List<SawonVo> sa_list) {
		this.sa_list = sa_list;
	}

}
