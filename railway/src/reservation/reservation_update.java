package reservation;

import java.util.*;
import java.sql.*;

public class reservation_update {
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

	public static void reservation_update() {
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
		System.out.println("Enter the customer name:");
		name = input.next();
		System.out.println("Enter the customer age:");
		age = input.nextInt();
	//	System.out.println("Enter the number of tickets:");
		//n_tickets = input.nextInt();
		System.out.println("Enter the price of the ticket:");
		ptkt = input.nextDouble();
		//t_tkt = n_tickets * ptkt;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// TICKET_ID T_ID C_ID C_NAME C_AGE NUMBER_OF_TICKET
			// PRICE_PER_TICKET TOTAL_AMOUNT
			stmt = conn.createStatement();
			System.out.println("Connection is created successfully:");
			String sql;

			sql = "update reservation set T_ID=" + t_id + ",C_ID=" + c_id + ",C_NAME='" + name + "',C_AGE=" + age
					+ ",Price_of_Ticket=" + ptkt +"where TICKET_ID="+id+")";
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
	}
}