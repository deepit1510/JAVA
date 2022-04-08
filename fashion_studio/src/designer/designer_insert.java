package designer;

import java.util.*;
import java.sql.*;

public class designer_insert {
	static int d_id;
	static String d_name;
	static Long d_phone;
	static String p_type;

	// static int subject_id;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/fashion_studio";
	static final String USER = "root";
	static final String PASS = "";
	static Scanner a;

	
		public static void designer_insert() {
		char y = 'y';

		Connection conn = null;
		Statement stmt = null;

		a = new Scanner(System.in);
		while (y == 'y') {
			// System.out.println("Enter staff id");
			// D_ID D_NAME D_PHONE P_TYPE

			System.out.println("Enter designer id");
			d_id = a.nextInt();

			System.out.println("Enter designer Name");
			d_name = a.next();
			while (!d_name.matches("[a-zA-Z ,]+")) {
				System.out.println("Re-enter product Name");
				d_name = a.next();
			}

			System.out.println("Enter designer phone");
			d_phone = a.nextLong();

			System.out.println("Enter  product type");
			p_type = a.next();

			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				stmt = conn.createStatement();
				System.out.println("Connection is created successfully:");
				String sql;
				sql = "insert into designer(D_ID,D_NAME,D_PHONE,P_TYPE) values(" + d_id + ",'" + d_name + " ', "
						+ d_phone + " " + " , '" + p_type + "')";
				stmt.executeUpdate(sql);

				System.out.println("Record is inserted in the table successfully..................");
			} catch (SQLException excep) {
				excep.printStackTrace();
			} catch (Exception excep) {
				excep.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						conn.close();
				} catch (SQLException se) {

				}

				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			System.out.println("Please check it in the MySQL Table......... ��..");
			System.out.println("Do you want to insert more record(y for 'Yes' and n for 'No'");
			y = a.next().charAt(0);

		}

	}

}
