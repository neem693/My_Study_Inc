package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;


public class DBService {

	DataSource ds;
	BasicDataSource ds1;

	// single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static DBService single = null;

	public static DBService getInstance() {
		if (single == null)
			single = new DBService();
		return single;
	}

	public DBService() {
		// TODO Auto-generated constructor stub
		// JNDI(Java Naming Directory(탐색) Interface)로 등록된 자원정보를 획득
		try {
			// 1. 자원을 탐색할 객체를 생성
			InitialContext ic = new InitialContext();
			// 2. 자원의 포함하고 있는 Context정보를 획득
			Context context = (Context) ic.lookup("java:comp/env");
			// 3. Context내에 있는 정보 획득
			ds = (DataSource) context.lookup("jdbc/oracle_test");

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			// JNDI를 통해서 획득한 DataSource로 부터 커넥션을 얻어온다.
			conn = ds.getConnection();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

}
