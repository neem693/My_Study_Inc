package RMI;

import java.util.List;
import java.util.Map;

import RMI.BoardVo;





public interface BoardDao {


	//게시판 목록 얻어오기
	public List<BoardVo> selectList();
	
	//조건별 목록 얻어오기
	public List<BoardVo> selectList(Map map);

	public BoardVo selectOne(int idx);

	public int update_readhit(int idx) ;

	public int insert(BoardVo vo) ;

	public int update_step(BoardVo baseVo) ;

	public int reply(BoardVo vo) ;

	public int selectRowTotal(Map map) ;

	public int update(BoardVo vo) ;

	public int delete(int idx) ;

	
	
	
	
	
	
	
	
	
}
