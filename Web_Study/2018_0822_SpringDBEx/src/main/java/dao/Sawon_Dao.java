package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import vo.SawonVo;

public class Sawon_Dao {

	SqlSessionTemplate session;

	public SqlSessionTemplate getSession() {
		return session;
	}

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}

	public Sawon_Dao(SqlSessionTemplate session) {
		super();
		this.session = session;
	}

	public Sawon_Dao() {
		// TODO Auto-generated constructor stub
	}

	public List<SawonVo> selectList() {
		// TODO Auto-generated method stub
		List<SawonVo> list = session.selectList("sawon.sawon_list");
		
		return list;
	}

}
