package cancellation;

import java.sql.*;

public class cancellation_display {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/railway";
	static final String USER = "root";
	static final String PASS = "";

	public static void cancellation_display() {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM cancellation";
			ResultSet rs = stmt.executeQuery(sql);
			// 
			//TICKET_ID	T_ID	C_ID
			while (rs.next()) {
				// C_ID C_NAME C_PHONE NUMBER C_AGE GENDER T_ID
				int id = rs.getInt("TICKET_ID");
				int t_id = rs.getInt("T_ID");
				int c_id = rs.getInt("C_ID");
				

				System.out.print("Ticket ID: " + id);
				System.out.print("Train ID: " + t_id);
				System.out.print("Customer ID: " + c_id);
				

			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally
		} // end try
		System.out.println("Goodbye.");
	} // End method main
} // end class ClientBase