package Com.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection provideConn() {
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url="jdbc:mysql://localhost:3306/Unit_5_HRMS";
		
		try {
			conn=DriverManager.getConnection(url, "root", "Mp21mk6293");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
}
//@This method Provide Connection with SQL;
