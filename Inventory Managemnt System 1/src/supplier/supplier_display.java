package supplier;

import java.sql.*;

public class supplier_display {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	public static void supplier_display() {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM supplier";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int sup_id = rs.getInt("sup_id");
				String sup_name = rs.getString("sup_name");
				String sup_email = rs.getString("sup_email");
				String gst_no = rs.getString("gst_no");
				String sup_address = rs.getString("sup_address");
				Long sup_phn = rs.getLong("sup_phn");

				System.out.print(" Supplier ID: " + sup_id);
				System.out.print(" Supplier Name: " + sup_name);
				System.out.println(" Supplier Email id" + sup_email);
				System.out.println(" Supplier GSTIN" + gst_no);
				System.out.println(" Supplier address" + sup_address);
				System.out.println(" Supplier phone number" + sup_phn);

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