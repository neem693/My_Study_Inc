package dao;

import java.util.List;
import java.util.Map;

import vo.CommentVo;

public interface CommentDao {

	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	


	public int insert(CommentVo vo);

	public List<CommentVo> selectList(int b_idx);

	public int delete(int idx);

	public List<CommentVo> selectList(Map map);

	public int selectListCount(int b_idx);

}
