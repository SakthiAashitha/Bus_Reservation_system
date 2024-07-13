package Bus_res;

import java.sql.*;

public class DB {
	
	private static final String url = "jdbc:mysql://localhost:3306/busRev";
	private static final String u="root";
	private static final String p="Ksheerabdi@03";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,u,p);
	}

}
