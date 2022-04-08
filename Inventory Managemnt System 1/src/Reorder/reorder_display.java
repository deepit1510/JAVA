package Reorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class reorder_display {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	public static void reorder_display() {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM re_order";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				int odr_id = rs.getInt("odr_id");
				int sup_id = rs.getInt("sup_id");
				int item_id = rs.getInt("item_id");
				String odr_date = rs.getString("odr_date");
				
				System.out.print(" Reorder ID: " + odr_id);
				System.out.print(" Supplier ID: " + sup_id);
				System.out.print(" Item ID: " + item_id);
				System.out.print(" Order Date: " + odr_date);
				
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