package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public class Member_DaoImpl implements Member_Dao {

	SqlSession session;
	
	

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<MemberVo> selectList() {

		// String sql = "select * from member";

		List<MemberVo> list = null;
		
		list = session.selectList("member.member_list");

		return list;

	}

	public MemberVo selectOne(int idx) {

		// String sql = "select * from member where idx = ?";
		MemberVo vo = null;

		
		vo = session.selectOne("member.member_select_idx", idx);
		

		return vo;
	}

	public MemberVo selectOne(String id) {

		// String sql = "select * from member where id = ?";
		MemberVo vo = null;

		
		vo = session.selectOne("member.member_select_id", id);
		

		return vo;
	}

	// 雀盔 insert

	

	public MemberVo selectOne(MemberVo vo) {

		// String sql = "select * from member where idx = ? and pwd = ?";

		MemberVo voo = null;

		
		voo = session.selectOne("member.member_select_vo", vo);
		

		return voo;

	}

	public MemberVo selectOne2(MemberVo vo) {

		// String sql = "select * from member where idx = ? and id = ?";

		MemberVo voo = null;

		
		voo = session.selectOne("member.member_select_vo_id", vo);
		

		return voo;

	}
	
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub

		// String sql = "insert into member values(seq_member_idx.nextVal,?,?,?,?,?,?,sysdate)";
		int res = 0;

		
		res = session.insert("member.member_insert", vo);
		

		return res;
	}

	public int delete(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// 贸府等 青荐

		// String sql = "delete from member where idx = ? and pwd = ?";

		
		res = session.delete("member.member_delete", vo);
		

		return res;
	}

	public int update(MemberVo vo) {

		// String sql = "update member set name = ?,pwd=?,addr=?,zipcode=? where idx =?";
		int res = 0;

		
		res = session.update("member.member_update", vo);
		

		return res;
	}
	
}
