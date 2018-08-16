package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.DeptVo;

public class DeptDao {
	
	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static DeptDao single = null;

	public static DeptDao getInstance() {
		if (single == null)
			single = new DeptDao();
		return single;
	}

	public DeptDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<DeptVo> selectList() {

		List<DeptVo> list = new ArrayList<DeptVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dept";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();

			//2.명령처리(PreparedStatement)객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.결과행처리(ResultSet)객체 획득
			rs = pstmt.executeQuery();

			//전체행 처리
			while (rs.next()) {

				//rs의 현재 레코드의 값을 읽어오기
				//argType에 포장
				DeptVo vo = new DeptVo();
				
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));

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

}
