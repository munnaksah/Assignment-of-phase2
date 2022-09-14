package adjava1;

import java.sql.*;
import java.sql.SQLException;

public class JdbcDemo {
	public static void main(String[] args) throws SQLException {

		Connection conn = ConnectionManager.getConnection();
		Statement st = null;
		ResultSet res = null;

		try {

			if (conn != null) {
				System.out.println("connected");

				st = conn.createStatement();
				String query = "select * from books";
				res = st.executeQuery(query);

				while (res.next()) {
					System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " "
							+ res.getString(4) + " " + res.getString(5));
				}
			}

			ConnectionManager.closeConnection();

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			// close jdbc connection
			try {
				if (res != null)
					st.cancel();
			} catch (Exception ce) {
				ce.printStackTrace();

			}
			if (conn != null) {
				ConnectionManager.closeConnection();

			}
		}

	}

}
