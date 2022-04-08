package train;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class train_delete {

	static int T_ID;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/railway";
	static final String USER = "root";
	static final String PASS = "";
	static Scanner a;

	public static void train_delete() {
	//	char y = 'y';

		Connection conn = null;
		Statement stmt = null;
		a = new Scanner(System.in);
		// while (y == 'y') {
		System.out.println("Enter Train id ");
		T_ID = a.nextInt();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Connection is created successfully:");

			String sql;
			sql = "delete from train where  T_ID="+T_ID;
			stmt.executeUpdate(sql);

			System.out.println("Connection is Deleted successfully:");

			// System.out.println("Do you want to insert more record(y for
			// 'Yes' and n for 'No'");
			// y = a.next().charAt(0);

		}

		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
		// System.out.println("Do you want to insert more record(y for 'Yes' and
		// n for 'No'");
		// y = a.next().charAt(0);

	}

		
	



}


