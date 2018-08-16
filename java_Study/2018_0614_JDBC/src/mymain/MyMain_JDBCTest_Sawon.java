package mymain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyMain_JDBCTest_Sawon {


	
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
		//1. Connection 획득 : 연결관리객체
		//				jdbc: 오라클:드라이버:@서버:포트:DB
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String pwd = "test";
		
		Connection conn = DriverManager.getConnection(url, user, pwd);
		System.out.println("--연결성공--");
		
		

		PreparedStatement pstmt;
		

		
		
		int deptnumber = 10;
		String location = "202";
		String sql = "select * from sawon";
		
		pstmt = conn.prepareStatement(sql);
		
		int sano;
		String name;
		String sex;
		int dno;
		String job;
		String hiredate;
		int mgr;
		int pay;
		
		
	
		ResultSet rs = pstmt.executeQuery();
		System.out.println("사번\t이름\t성별\t부서번호\t직위\t고용날짜\t\t\t관리자사번\t연봉");
		while(rs.next()) {
			

			
			int sabun = rs.getInt("sabun");
			String saname = rs.getString("saname");
			String sasex = rs.getString("sasex");
			int deptno = rs.getInt("deptno");
			String sajob = rs.getString("sajob");
			String sahire = rs.getString("sahire");
			int samgr = rs.getInt("samgr");
			int sapay = rs.getInt("sapay");
			
			
		
			System.out.printf("%d\t%s\t%s\t%d\t%s\t%s\t%d\t%d\n", sabun,saname,sasex,deptno,sajob,sahire,samgr,sapay);
		}
		
		
		
		
		rs.close();
		//stmt.close();
		pstmt.close();
		conn.close();
		
		

	}

}
