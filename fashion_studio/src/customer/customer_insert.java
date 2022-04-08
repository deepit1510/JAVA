package customer;

import java.util.*;
import java.sql.*;

public class customer_insert {
	static int c_id;
	static String c_name;
	static String c_add;
	static double c_phone;
	static double amount;
	static int p_id;
	static int d_id;

	// static int subject_id;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/fashion_studio";
	static final String USER = "root";
	static final String PASS = "";
	static Scanner a;

	//public static void main(String args[]) {
	public static void customer_insert() {
		char y = 'y';

		Connection conn = null;
		Statement stmt = null;
		// C_ID C_NAME C_ADD C_PHONE P_ID AMOUNT D_ID
		a = new Scanner(System.in);
		while (y == 'y') {
			System.out.println("Enter customer id");
			c_id = a.nextInt();

			System.out.println("Enter customer  name");
			c_name = a.next();

			System.out.println("Enter customer address");
			c_add = a.next();

			System.out.println("Enter customer phone number");
			c_phone = a.nextInt();

			System.out.println("Enter product Id");
			p_id = a.nextInt();

			System.out.println("Enter designer Id");
			d_id = a.nextInt();

			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				stmt = conn.createStatement();
				System.out.println("Connection is created successfully:");
				String sql;
				sql = "insert into customer(C_ID,C_NAME,C_ADD,C_PHONE,P_ID,AMOUNT,D_ID) values(" + c_id + " , '" + c_name
						+ "' ,'" + c_add + "'," + c_phone + ", " + p_id + " ," + amount + "," + d_id + ")";
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
			System.out.println("Please check it in the MySQL Table...........");
			System.out.println("Do you want to insert more record(y for 'Yes' and n for 'No'");
			y = a.next().charAt(0);
			// if(y=='n'){

			// break;
		}

	}

}
