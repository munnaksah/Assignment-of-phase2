package adjava1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static Connection conn = null;
	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "Munna@123");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;

	}

	public static void closeConnection() {
		try {

		} catch (Exception ce) {

			ce.printStackTrace();
		}
	}
}
