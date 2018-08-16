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
import vo.MemberVo;

public class Member_Dao {

	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	SqlSessionFactory factory;
	static Member_Dao single = null;

	public static Member_Dao getInstance() {
		if (single == null)
			single = new Member_Dao();
		return single;
	}

	public Member_Dao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public List<MemberVo> selectList() {

		// String sql = "select * from member";

		List<MemberVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("member.member_list");

		return list;

	}

	public MemberVo selectOne(int idx) {

		// String sql = "select * from member where idx = ?";
		MemberVo vo = null;

		SqlSession session = factory.openSession();
		vo = session.selectOne("member.member_select_idx", idx);
		session.close();

		return vo;
	}

	public MemberVo selectOne(String id) {

		// String sql = "select * from member where id = ?";
		MemberVo vo = null;

		SqlSession session = factory.openSession();
		vo = session.selectOne("member.member_select_id", id);
		session.close();

		return vo;
	}

	// 회원 insert

	

	public MemberVo selectOne(MemberVo vo) {

		// String sql = "select * from member where idx = ? and pwd = ?";

		MemberVo voo = null;

		SqlSession session = factory.openSession();
		voo = session.selectOne("member.member_select_vo", vo);
		session.close();

		return voo;

	}

	public MemberVo selectOne2(MemberVo vo) {

		// String sql = "select * from member where idx = ? and id = ?";

		MemberVo voo = null;

		SqlSession session = factory.openSession();
		voo = session.selectOne("member.member_select_vo_id", vo);
		session.close();

		return voo;

	}
	
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub

		// String sql = "insert into member values(seq_member_idx.nextVal,?,?,?,?,?,?,sysdate)";
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.insert("member.member_insert", vo);
		session.close();

		return res;
	}

	public int delete(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// 처리된 행수

		// String sql = "delete from member where idx = ? and pwd = ?";

		SqlSession session = factory.openSession(true);
		res = session.delete("member.member_delete", vo);
		session.close();

		return res;
	}

	public int update(MemberVo vo) {

		// String sql = "update member set name = ?,pwd=?,addr=?,zipcode=? where idx =?";
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.update("member.member_update", vo);
		session.close();

		return res;
	}
	
}
