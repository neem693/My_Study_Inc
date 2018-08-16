package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.DBService;
import service.MyBatisConnector;
import vo.VisitVo;

public class VisitDao {

	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static VisitDao single = null;
	SqlSessionFactory factory;

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();
		return single;
	}

	public VisitDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<VisitVo> selectList() {

		List<VisitVo> list = null;

		// String sql = "select * from visit order by idx desc";

		SqlSession session = factory.openSession();
		list = session.selectList("visit.select_visit_list");
		session.close();

		return list;
	}

	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// 처리된 행수
		// String sql = "insert into visit
		// values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";

		SqlSession session = factory.openSession();
		res = session.insert("visit.insert_visit", vo);
		if (res != 0) {
			session.commit();
		}
		session.close();

		return res;
	}

	public int delete(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// 처리된 행수

		// String sql = "delete from visit where idx = ?";

		SqlSession session = factory.openSession(true);
		session.delete("visit.delete_visit", vo);
		session.close();

		return res;
	}

	public VisitVo selectOne(int idx) {

		VisitVo vo = null;

		//String sql = "select * from visit where idx=?";

		SqlSession session = factory.openSession();
		vo = session.selectOne("visit.selectone_visit",idx);
		session.close();

		return vo;
	}
	
	public int selectRowCount() {
		int count =0;
		SqlSession session = factory.openSession();
		count = session.selectOne("visit.count_visit");
		session.close();
		
		return count;
		
		
	}

	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res =0;

		
		//String sql = "update visit set name =?,content=?,pwd=?,ip=?,regdate=sysdate where idx=?";
		SqlSession session = factory.openSession();
		 res = session.update("visit.update_visit",vo);
		 if(res!=0) {
			 session.commit();
		 }
		session.close();
	

		return res;
	}

	public List<VisitVo> selectList(VisitVo vo) {
		// TODO Auto-generated method stub
		
		List<VisitVo> list = null;

		// String sql = "select * from visit order by idx desc";

		SqlSession session = factory.openSession();
		list = session.selectList("visit.select_visit_codition_list",vo);
		session.close();

		return list;
	}

}
