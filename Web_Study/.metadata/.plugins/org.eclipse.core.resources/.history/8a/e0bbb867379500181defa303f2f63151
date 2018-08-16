package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.GogekVo;

public class GogekDbo {

	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static GogekDbo single = null;
	SqlSessionFactory factory;

	public static GogekDbo getInstance() {
		if (single == null)
			single = new GogekDbo();
		return single;
	}

	public GogekDbo() {
		// TODO Auto-generated constructor stub

		factory = MyBatisConnector.getInstance().getSqlSessionFactory();

	}

	public List<GogekVo> selectSido() {
		// TODO Auto-generated method stub
		List<GogekVo> list = null;

		list = factory.openSession().selectList("gogek_selectlist_sido");
		factory.openSession().close();

		return list;
	}

	public List<GogekVo> selectSido(String addr) {
		// TODO Auto-generated method stub
		List<GogekVo> list = null;
System.out.println(addr);
		list = factory.openSession().selectList("gogek_select_sido", addr);
		factory.openSession().close();

		return list;
	}

}
