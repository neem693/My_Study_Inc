package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import vo.BoardVo;

public interface BoardDao {


	
	public List<BoardVo> selectList();

	/* 페이징 처리위한 select */
	public List<BoardVo> selectList(Map map);

	public BoardVo selectOne(int idx);

	public int selectOne(BoardVo vo) ;

	public BoardVo selectOne_detail(BoardVo vo) ;

	public int update_readhit(int idx) ;

	public int update_all(BoardVo vo);

	public int update_stepUp(BoardVo base_vo) ;

	public int delete(BoardVo vo) ;

	public int delete_continue(BoardVo vo);

	public int insert_reply(BoardVo vo);

	public int insert(BoardVo vo) ;

	public int selectCount(Map map);

	public int selectOne_IsOnlyOne(BoardVo vo);

	public int update_del_mod(BoardVo vo);

}
