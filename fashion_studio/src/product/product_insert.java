package product;

import java.util.*;
import java.sql.*;

public class product_insert {
	static int p_id;
	static String p_type;
	static int amount;
	static int d_id;

	// static int subject_id;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/fashion_studio";
	static final String USER = "root";
	static final String PASS = "";
	static Scanner a;

	//public static void main(String args[]) {
		 public static void product_insert() {
		char y = 'y';

		Connection conn = null;
		Statement stmt = null;

		a = new Scanner(System.in);
		while (y == 'y') {
			System.out.println("Enter product id");
			p_id = a.nextInt();

			System.out.println("Enter product type");
			p_type = a.next();
			while (!p_type.matches("[a-zA-Z ,]+")) {
				System.out.println("Re-enter product type");
				p_type = a.next();
			}

			System.out.println("Enter product amount");
			amount = a.nextInt();

			System.out.println("Enter designer Id");
			int d_id = a.nextInt();
			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				stmt = conn.createStatement();
				System.out.println("Connection is created successfully:");
				String sql;
				sql = "insert into product(P_ID,	P_TYPE,	AMOUNT,	D_ID) values(" + p_id + ",'" + p_type + " ',"
						+ amount + "," + d_id + " )";
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
