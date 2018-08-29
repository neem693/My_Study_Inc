package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import vo.BoardVo;

public class Board_DaoImple implements BoardDao {

	SqlSession session;

	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	
	public List<BoardVo> selectList() {
		List<BoardVo> list = null;

		list = session.selectList("board.board_list");
		return list;
	}

	/* 페이징 처리위한 select */
	public List<BoardVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<BoardVo> list = null;

		list = session.selectList("board.board_condition_list", map);

		return list;
	}

	public BoardVo selectOne(int idx) {
		// TODO Auto-generated method stub
		BoardVo vo = null;

		vo = session.selectOne("board.board_select_one", idx);

		return vo;
	}

	public int selectOne(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		BoardVo check_vo = null;

		check_vo = session.selectOne("board.board_check_one", vo);

		if (check_vo != null) {
			res = 1;
		}

		return res;
	}

	public BoardVo selectOne_detail(BoardVo vo) {
		// TODO Auto-generated method stub
		BoardVo voo = null;

		voo = session.selectOne("board.board_select_one_detail", vo);

		return voo;
	}

	public int update_readhit(int idx) {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.update("board.board_update_readhit", idx);

		return res;
	}

	public int update_all(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.update("board.board_update_all", vo);

		return res;
	}

	public int update_stepUp(BoardVo base_vo) {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.update("board.board_update_stepUp", base_vo);

		return res;
	}

	public int delete(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.delete("board.board_delete", vo);

		return res;
	}

	public int delete_continue(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.delete("board.board_delete_continue", vo);

		return res;
	}

	public int insert_reply(BoardVo vo) {
		int res = 0;

		res = session.insert("board.board_reply", vo);

		return res;
	}

	public int insert(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.insert("board.board_insert", vo);

		return res;
	}

	public int selectCount(Map map) {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.selectOne("board.board_all_count", map);
		// System.out.println(res);

		return res;
	}

	public int selectOne_IsOnlyOne(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.selectOne("board.board_is_only_one", vo);
		// System.out.println(res);

		return res;
	}

	public int update_del_mod(BoardVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		res = session.update("board.board_update_del_mod", vo);
		// System.out.println(res);

		return res;
	}

}
