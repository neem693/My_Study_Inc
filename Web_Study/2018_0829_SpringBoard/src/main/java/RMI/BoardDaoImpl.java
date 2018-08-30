package RMI;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import RMI.BoardVo;

public class BoardDaoImpl implements BoardDao{

	SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//게시판 목록 얻어오기
	public List<BoardVo> selectList(){
	 
		List<BoardVo> list = null;
		
		
		list = sqlSession.selectList("board_rmi.board_list");
		
		
		return list;
		
	}
	
	//조건별 목록 얻어오기
	public List<BoardVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<BoardVo> list = null;
		
		
		list = sqlSession.selectList("board_rmi.board_condition_list",map);
		
		
		return list;
	}

	public BoardVo selectOne(int idx) {
		// TODO Auto-generated method stub
		BoardVo vo = null;
		
	
		vo = sqlSession.selectOne("board_rmi.board_one",idx);
		
		
		return vo;
	}

	public int update_readhit(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = sqlSession.update("board_rmi.board_update_readhit", idx);
		
		return res;
	}

	public int insert(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = sqlSession.insert("board_rmi.board_insert", vo);
		
		return res;
	}

	public int update_step(BoardVo baseVo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = sqlSession.update("board_rmi.board_update_step", baseVo);
		
		return res;
	}

	public int reply(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = sqlSession.insert("board_rmi.board_reply", vo);
		
		return res;
	}

	public int selectRowTotal(Map map) {
		// TODO Auto-generated method stub
		int count = 0;
		
		
		count = sqlSession.selectOne("board_rmi.board_total_count",map);
		
	
		
		return count;
	}

	public int update(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = sqlSession.update("board_rmi.board_update", vo);
		
		return res;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = sqlSession.update("board_rmi.board_delete_update", idx);
		
	
		return res;
	}

	
	
	
	
	
	
	
	
	
}
