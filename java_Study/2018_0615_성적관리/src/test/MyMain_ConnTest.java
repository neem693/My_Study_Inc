package test;

import java.sql.Connection;
import java.sql.SQLException;

import service.DBService;

public class MyMain_ConnTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBService.getInstance().getConnection();

		if (conn == null)
			System.out.println("--failed connection--");
		else
			System.out.println("--success connection--");
		conn.close();

	}

}
