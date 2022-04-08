package designer;
import java.util.*;
import java.sql.*;

public class designer_delete {
	static int d_id;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/fashion_studio";
	static final String USER = "root";
	static final String PASS = "";
	static Scanner a;

	public static void designer_delete() {
	
		Connection conn = null;
		Statement stmt = null;
		a = new Scanner(System.in);
		// while (y == 'y') {
		System.out.println("Enter designer id ");
		d_id = a.nextInt();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Connection is created successfully:");
			String sql;
			sql = "delete from designer where D_ID="+d_id;
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



