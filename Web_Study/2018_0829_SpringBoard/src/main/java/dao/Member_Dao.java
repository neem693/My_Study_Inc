package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public interface Member_Dao {


	
	

	public SqlSession getSession() ;

	public void setSession(SqlSession session);

	public List<MemberVo> selectList() ;

	public MemberVo selectOne(int idx);

	public MemberVo selectOne(String id);

	// È¸¿ø insert

	

	public MemberVo selectOne(MemberVo vo);

	public MemberVo selectOne2(MemberVo vo);
	
	public int insert(MemberVo vo);

	public int delete(MemberVo vo);

	public int update(MemberVo vo);
	
}
