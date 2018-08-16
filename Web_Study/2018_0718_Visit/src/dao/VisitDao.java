package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.VisitVo;

public class VisitDao {

	// single-ton pattern: 1°³ÀÇ °´Ã¼¸¸ »ý¼ºÇØ¼­ ¼­ºñ½ºÇÏÀÚ
	static VisitDao single = null;

	public static VisitDao getInstance() {
		if (single == null)
			single = new VisitDao();
		return single;
	}

	public VisitDao() {
		// TODO Auto-generated constructor stub
	}

	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from visit order by idx desc";

		try {
			// 1.ConnectionÈ¹µæ
			conn = DBService.getInstance().getConnection();

			// 2.¸í·ÉÃ³¸®(PreparedStatement)°´Ã¼ È¹µæ
			pstmt = conn.prepareStatement(sql);

			// 3.°á°úÇàÃ³¸®(ResultSet)°´Ã¼ È¹µæ
			rs = pstmt.executeQuery();

			// ÀüÃ¼Çà Ã³¸®
			while (rs.next()) {

				// rsÀÇ ÇöÀç ·¹ÄÚµåÀÇ °ªÀ» ÀÐ¾î¿À±â
				// VisitVo¿¡ Æ÷Àå
				VisitVo vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent((rs.getString("content")));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));

				// ArrayList´ã´Â´Ù
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// ´Ý±â:¿ª¼øÀ¸·Î
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// Ã³¸®µÈ Çà¼ö
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate)";

		try {
			// 1.ConnectionÈ¹µæ
			conn = DBService.getInstance().getConnection();
			// 2.¸í·ÉÃ³¸®°´Ã¼ È¹µæ
			pstmt = conn.prepareStatement(sql);

			// 3.psmt parameter ¼³Á¤
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());

			// 4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

	public int delete(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// Ã³¸®µÈ Çà¼ö
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from visit where idx = ?";
		int idx = vo.getIdx();

		try {
			// 1.ConnectionÈ¹µæ
			conn = DBService.getInstance().getConnection();
			// 2.¸í·ÉÃ³¸®°´Ã¼ È¹µæ
			pstmt = conn.prepareStatement(sql);

			// 3.psmt parameter ¼³Á¤
			pstmt.setInt(1, idx);

			// 4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from visit where idx=?";

		try {
			// 1.ConnectionÈ¹µæ
			conn = DBService.getInstance().getConnection();

			// 2.¸í·ÉÃ³¸®(PreparedStatement)°´Ã¼ È¹µæ
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, idx);

			// 3.°á°úÇàÃ³¸®(ResultSet)°´Ã¼ È¹µæ
			rs = pstmt.executeQuery();

			// ÀüÃ¼Çà Ã³¸®
			while (rs.next()) {

				// rsÀÇ ÇöÀç ·¹ÄÚµåÀÇ °ªÀ» ÀÐ¾î¿À±â
				// VisitVo¿¡ Æ÷Àå
				vo = new VisitVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setContent((rs.getString("content")));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				// ArrayList´ã´Â´Ù
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// ´Ý±â:¿ª¼øÀ¸·Î
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}

	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;// Ã³¸®µÈ Çà¼ö
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update visit set name =?,content=?,pwd=?,ip=?,regdate=sysdate where idx=?";

		try {
			// 1.ConnectionÈ¹µæ
			conn = DBService.getInstance().getConnection();
			// 2.¸í·ÉÃ³¸®°´Ã¼ È¹µæ
			pstmt = conn.prepareStatement(sql);

			// 3.psmt parameter ¼³Á¤
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getIdx());

			// 4.DB insert
			res = pstmt.executeUpdate(); // insert update delete

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return res;
	}

}
