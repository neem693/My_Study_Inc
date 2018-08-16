package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;

public class SawonDao {
	// single-ton : 객체1개만 생성 서비스
	static SawonDao single = null;

	// SessionFactory생성하는 객체
	SqlSessionFactory factory;
	// SqlSessionFactory factory;

	public SawonDao() {
		super();
		// TODO Auto-generated constructor stub

		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		// factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}

	public List<SawonVo> selectList(String saname, int deptno) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		SawonVo vo = new SawonVo();

		vo.setDeptno(deptno);
		vo.setSaname(saname);
		list = factory.openSession().selectList("select_deptno_name", vo);
		factory.openSession().close();
		return list;
	}

	public List<SawonVo> selectList(String saname) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		SawonVo vo = new SawonVo();

		list = factory.openSession().selectList("select_name", saname);
		factory.openSession().close();
		return list;
	}

}
