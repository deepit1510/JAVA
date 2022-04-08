package cancellation;

import java.util.*;
import java.sql.*;

public class cancellation_update {
	static int id;
	static int t_id;
	static int c_id;
	static String name;
	static int age;
	static int n_tickets;
	static double ptkt;
	static double t_tkt;
	// static int t_id;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/railway";
	static final String USER = "root";
	static final String PASS = "";

	public static void cancellation_update() {
		Connection conn = null;
		Statement stmt = null;
		// TICKET_ID T_ID C_ID C-NAME C-AGE NUMBER OF TICKET PRICE PER TICKET
		// TOTAL AMOUNT
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the ticket id:");
		id = input.nextInt();
		System.out.println("Enter the train id:");
		t_id = input.nextInt();
		System.out.println("Enter the customer id:");
		c_id = input.nextInt();
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Connection is created successfully:");
			String sql;

			sql = "update cancellation set T_ID=" + t_id + ",C_ID=" + c_id + "where TICKET_ID="+id+")";
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
		System.out.println("Please check it in the MySQL Table......... ……..");
	}
}
