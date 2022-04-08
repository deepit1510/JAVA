package cancellation;

import java.util.*;
import java.sql.*;
import java.sql.Connection;

//T_ID	C_ID	C-NAME	C-AGE	NUMBER OF TICKET	PRICE PER TICKET	TOTAL AMOUNT	
public class cancellation_delete {
	static int id;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/railway";
	static final String USER = "root";
	static final String PASS = "";

	public static void cancellation_delete() {
		Connection conn = null;
		Statement stmt = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the ticket id");
		id = input.nextInt();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Connection is created successfully:");

			String sql;

			sql = "delete from cancellation where  TICKET_ID=" + id;
			stmt.executeUpdate(sql);

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
