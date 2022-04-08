package Reorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class delete_reorder {
	static int odr_id;
	static Scanner input;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	public static void reorder_delete() {
		char y = 'y';
		Connection conn = null;
		Statement stmt = null;
		input = new Scanner(System.in);
		while (y == 'y') {
			System.out.println("Enter the reorder id");
			odr_id = input.nextInt();
			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				stmt = conn.createStatement();
				System.out.println("Connection is created successfully:");

				String sql;

				sql = "delete from re_order where  odr_id=" + odr_id;
				stmt.executeUpdate(sql);

				System.out.println("Connection is Deleted successfully:");

			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
			// System.out.println("Goodbye!");
			System.out.println("Do you want to delete more record(y for 'Yes' and n for 'No'");
			y = input.next().charAt(0);
		}
	}
}

