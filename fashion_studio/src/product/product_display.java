package product;

import java.util.*;
import java.sql.*;

public class product_display {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/fashion_studio";
	static final String USER = "root";
	static final String PASS = "";

	static int p_id;
	static String p_type;
	static String amount;
	static int d_id;

	// public static void main(String args[]) {
	public static void product_display() {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM product";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				// P_ID P_TYPE AMOUNT D_ID
				p_id = rs.getInt("P_ID");
				p_type = rs.getString("P_TYPE");
				amount = rs.getString("AMOUNT");
				d_id = rs.getInt("D_ID");

				System.out.println("Enter product id :" + p_id);

				System.out.println("Enter product type :" + p_type);

				System.out.println("Enter amount :" + amount);

				System.out.println("Enter designer Id :" + d_id);

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
