package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Service_DB {
	
	DataSource ds;
	
	//single-ton pattern: 1개의 객체만 생성해서 서비스하자
	static Service_DB single = null;

	public static Service_DB getInstance() {
		if (single == null)
			single = new Service_DB();
		return single;
	}

	public Service_DB() {
		// TODO Auto-generated constructor stub
		try {
			InitialContext ic = new InitialContext();
			Context context = (Context) ic.lookup("java:/comp/env");
			ds = (DataSource) context.lookup("jdbc/oracle_test");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
		
	
	
	

}
