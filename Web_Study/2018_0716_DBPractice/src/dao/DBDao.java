package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.Service_DB;
import vo.GogekVo;
import vo.SawonVo;

public class DBDao {

	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static DBDao single = null;

	public static DBDao getInstance() {
		if (single == null)
			single = new DBDao();
		return single;
	}

	public DBDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<GogekVo> gogekSelect() {

		List<GogekVo> list = new ArrayList<GogekVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from gogek";

		try {
			//1.Connection획득
			conn = Service_DB.getInstance().getConnection();

			//2.명령처리(PreparedStatement)객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.결과행처리(ResultSet)객체 획득
			rs = pstmt.executeQuery();

			//전체행 처리
			while (rs.next()) {

				//rs의 현재 레코드의 값을 읽어오기
				//GogekVo에 포장
				GogekVo vo = new GogekVo();
				
				vo.setGobun(rs.getInt("gobun"));
				vo.setGoname(rs.getString("goname"));
				vo.setGoaddr(rs.getString("goaddr"));
				vo.setGojumin(rs.getString("gojumin"));
				vo.setGodam(rs.getInt("godam"));

				//ArrayList담는다
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//닫기:역순으로
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

	public List<SawonVo> sawonSelect() {

		List<SawonVo> list = new ArrayList<SawonVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon";

		try {
			// 1.Connection획득
			conn = Service_DB.getInstance().getConnection();

			// 2.명령처리(PreparedStatement)객체 획득
			pstmt = conn.prepareStatement(sql);

			// 3.결과행처리(ResultSet)객체 획득
			rs = pstmt.executeQuery();

			// 전체행 처리
			while (rs.next()) {

				// rs의 현재 레코드의 값을 읽어오기
				// SawonVo에 포장
				SawonVo vo = new SawonVo();
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getString("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));

				// ArrayList담는다
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				// 닫기:역순으로
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

}
