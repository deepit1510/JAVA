package inventory;

import java.util.*;
import java.sql.*;

public class item_details_delete {
	static int item_id;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control";
	static final String USER = "root";
	static final String PASS = "";

	public static void delete_item() {
		Connection conn = null;
		Statement stmt = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the stock id");
		item_id = input.nextInt();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			// System.out.println("Connection is created successfully:");

			String sql;

			sql = "delete from item_details where  item_id=" + item_id;
			stmt.executeUpdate(sql);

			// Now you can extract all the records
			// to see the updated records
			// sql = "SELECT * FROM inventory_management";
			// ResultSet rs = stmt.executeQuery(sql);

			// rs.close();
			System.out.println("Connection is Deleted successfully:");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}
}