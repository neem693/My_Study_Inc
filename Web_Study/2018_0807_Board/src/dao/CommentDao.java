package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CommentVo;

public class CommentDao {

	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	SqlSessionFactory factory;
	static CommentDao single = null;

	public static CommentDao getInstance() {
		if (single == null)
			single = new CommentDao();
		return single;
	}

	public CommentDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	public int insert(CommentVo vo) {
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.insert("comment.comment_insert", vo);
		session.close();

		return res;
	}

	public List<CommentVo> selectList(int b_idx) {
		// TODO Auto-generated method stub
		List<CommentVo> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("comment.comment_list", b_idx);
		session.close();

		return list;
	}

	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;

		SqlSession session = factory.openSession(true);
		res = session.delete("comment.comment_delete", idx);
		session.close();

		return res;
	}

	public List<CommentVo> selectList(Map map) {
		// TODO Auto-generated method stub
		List<CommentVo> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("comment.comment_list_page", map);
		session.close();

		return list;
	}

	public int selectListCount(int b_idx) {
		// TODO Auto-generated method stub
		int count = 0;

		SqlSession session = factory.openSession();
		count = session.selectOne("comment.comment_count", b_idx);
		session.close();

		return count;
	}

}
