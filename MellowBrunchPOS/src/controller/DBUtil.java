package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static final String driver = "oracle.jdbc.driver.OracleDriver";
	static final String url = "jdbc:oracle:thin:@175.193.9.63:1521:myoracle";
//	static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:myoracle";
	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		return con;
	}
}