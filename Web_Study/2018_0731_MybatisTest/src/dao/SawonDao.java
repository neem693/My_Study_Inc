package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SawonVo;
import vo.SawonYearVo;

public class SawonDao {
	// single-ton : 객체1개만 생성 서비스
	static SawonDao single = null;

	// SessionFactory생성하는 객체
	SqlSessionFactory factory;

	public SawonDao() {
		super();
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public static SawonDao getInstance() {

		if (single == null)
			single = new SawonDao();

		return single;
	}

	public List<SawonVo> selectList() {
		List<SawonVo> list = null;
		// 1. mybatis 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		// 2.작업수행
		list = sqlSession.selectList("sawon_list");

		// 3.작업객체 반환시킨다(내부적으로 connection close)
		sqlSession.close();

		return list;
	}

	public List<SawonVo> selectList(int deptno) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		// 1. mybatis 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		// 2.작업수행
		list = sqlSession.selectList("sawon_list_deptno", deptno);

		// 3.작업객체 반환시킨다(내부적으로 connection close)
		sqlSession.close();

		return list;
	}

	public List<SawonVo> selectList(String sajob) {
		// TODO Auto-generated method stub

		List<SawonVo> list = null;
		// 1. mybatis 작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		// 2.작업수행
		list = sqlSession.selectList("sawon_list_sajob", sajob);
		
		

		// 3.작업객체 반환시킨다(내부적으로 connection close)
		sqlSession.close();

		return list;
	}

	public List<SawonVo> selectList(SawonVo vo) {
		// TODO Auto-generated method stub
		
		List<SawonVo> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("deptno_sajob_select",vo);
		sqlSession.close();
		
		return list;
	}

	public List<SawonVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<SawonVo> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("deptno_sajob_selectMap",map);
		sqlSession.close();
		
		
		return list;
	}

	public List<SawonYearVo> selectYearList() {
		// TODO Auto-generated method stub
		List<SawonYearVo> list = null;
		SqlSession sqlSession = factory.openSession();
		list = sqlSession.selectList("sawon_year_list");
		sqlSession.close();
		return list;
	}

}
