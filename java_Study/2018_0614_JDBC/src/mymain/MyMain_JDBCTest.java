package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyMain_JDBCTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 1. Connection 획득 : 연결관리객체
		// jdbc: 오라클:드라이버:@서버:포트:DB <mailto:오라클:드라이버:@서버:포트:DB>
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String pwd = "test";
		Connection conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("--연결성공--");
		PreparedStatement pstmt;
		int deptnumber = 10;
		String location = "202";
		String sql = "select * from dept where deptno =? or loc =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptnumber);
		pstmt.setString(2, location);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			System.out.printf("%d-%s-%s\n", deptno, dname, loc);
		}
		rs.close();
		// stmt.close();
		pstmt.close();
		conn.close();
	}
}
