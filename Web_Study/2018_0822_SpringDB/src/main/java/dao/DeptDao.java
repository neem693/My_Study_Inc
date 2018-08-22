package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import vo.DeptVo;

public class DeptDao {
	
	SqlSessionTemplate seesion;
	
	public DeptDao() {
		// TODO Auto-generated constructor stub
		
	}

	public DeptDao(SqlSessionTemplate seesion) {
		super();
		this.seesion = seesion;
	}

	//목록조회
	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		List<DeptVo> list = null;
		list = seesion.selectList("dept.dept_list");
		
		return list;
	}
	
	

}
