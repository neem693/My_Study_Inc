package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static DBService single =null;
	public static DBService getInstance() {
		if(single ==null)
			single = new DBService();
		return single;
	}
	
	private DBService() {
		// TODO Auto-generated constructor stub
		//자바 SQL 가져와야 한다. Connection 클래스 말이다!!!!!!!!!!!
		
	}
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "test";
			String pwd = "test";
			
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
