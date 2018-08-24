package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;


import vo.VisitVo;

public class VisitDao {

	SqlSessionTemplate session; //Spring栏肺何磐 Injection(setter injection)罐绰促.
	
	
	

	public SqlSessionTemplate getSession() {
		return session;
	}

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	

	public VisitDao() {
		// TODO Auto-generated constructor stub
	}

	public List<VisitVo> selectList() {

		List<VisitVo> list = null;

		// String sql = "select * from visit order by idx desc";

	
		list = session.selectList("visit.select_visit_list");
	

		return list;
	}

	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// 贸府等 青荐
		// String sql = "insert into visit
		// values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";


		res = session.insert("visit.insert_visit", vo);
//		if (res != 0) {
//			session.commit();
//		}
		//session.close();

		return res;
	}

	public int delete(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// 贸府等 青荐

		// String sql = "delete from visit where idx = ?";

		//SqlSession session = factory.openSession(true);
		session.delete("visit.delete_visit", vo);
		//session.close();

		return res;
	}

	public VisitVo selectOne(int idx) {

		VisitVo vo = null;

		//String sql = "select * from visit where idx=?";

		//SqlSession session = factory.openSession();
		vo = session.selectOne("visit.selectone_visit",idx);
		//session.close();

		return vo;
	}
	
	public int selectRowCount() {
		int count =0;
		//SqlSession session = factory.openSession();
		count = session.selectOne("visit.count_visit");
		//session.close();
		
		return count;
		
		
	}

	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res =0;

		
		//String sql = "update visit set name =?,content=?,pwd=?,ip=?,regdate=sysdate where idx=?";
		//SqlSession session = factory.openSession();
		 res = session.update("visit.update_visit",vo);
//		 if(res!=0) {
//			 session.commit();
//		 }
		//session.close();
	

		return res;
	}

	public List<VisitVo> selectList(VisitVo vo) {
		// TODO Auto-generated method stub
		
		List<VisitVo> list = null;

		// String sql = "select * from visit order by idx desc";

		//SqlSession session = factory.openSession();
		list = session.selectList("visit.select_visit_codition_list",vo);
		//session.close();

		return list;
	}

	public int selectOne_all_count() {
		// TODO Auto-generated method stub
		
		int count = session.selectOne("visit.all_visit");
		return count;
	}

	public List<VisitVo> selectList_map(Map map) {
		// TODO Auto-generated method stub
		
		List<VisitVo> list = session.selectList("select_visit_codition_list", map);
		
		return list;
	}

}
