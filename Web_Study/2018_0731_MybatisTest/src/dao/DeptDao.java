package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import service.MyBatisConnector;
import vo.DeptVo;
import vo.SawonVo;

public class DeptDao {
	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static DeptDao single = null;

	SqlSessionFactory factory;

	public static DeptDao getInstance() {
		if (single == null)
			single = new DeptDao();
		return single;
	}

	public DeptDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		List<DeptVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("dept_list");
		session.close();
		return list;
	}

	public List<DeptVo> selectList(int deptno) {
		// TODO Auto-generated method stub
		List<DeptVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("dept_list_select", deptno);
		session.close();
		return list;
	}

}
