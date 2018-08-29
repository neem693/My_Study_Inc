package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.CommentVo;

public class CommentDaoImpl implements CommentDao {

	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	
	SqlSession session;
	
	
	
	public SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public int insert(CommentVo vo) {
		int res = 0;

		
		res = session.insert("comment.comment_insert", vo);
		

		return res;
	}

	public List<CommentVo> selectList(int b_idx) {
		// TODO Auto-generated method stub
		List<CommentVo> list = null;

		
		list = session.selectList("comment.comment_list", b_idx);
		

		return list;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;

		
		res = session.delete("comment.comment_delete", idx);
		

		return res;
	}

	public List<CommentVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<CommentVo> list = null;

		
		list = session.selectList("comment.comment_list_page", map);


		return list;
	}

	public int selectListCount(int b_idx) {
		// TODO Auto-generated method stub
		int count = 0;

		
		count = session.selectOne("comment.comment_count", b_idx);


		return count;
	}

}
