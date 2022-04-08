package customer;

import java.sql.*;

public class customer_display {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/fashion_studio";
	static final String USER = "root";
	static final String PASS = "";
	static int c_id;
	static String c_name;
	static String c_add;
	static double c_phone;
	static double amount;
	static int p_id;
	static int d_id;

	public static void customer_display() {
	//public static void main(String args[]) {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM customer";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				c_id = rs.getInt("C_ID");
				c_name = rs.getString("C_NAME");
				c_add = rs.getString("C_ADD");
				c_phone = rs.getFloat("C_PHONE");
				p_id = rs.getInt("P_ID");
				amount = rs.getInt("AMOUNT");
				d_id = rs.getInt("D_ID");

				System.out.println("Enter customer id :" + c_id);
				System.out.println("Enter customer  name :" + c_name);
				System.out.println("Enter customer address :" + c_add);
				System.out.println("Enter customer phone :" + c_phone);
				System.out.println("Enter  staff Id :" + p_id);
				System.out.println("Enter the amount :" + amount);
				System.out.println("Enter Designer Id :" + d_id);

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
