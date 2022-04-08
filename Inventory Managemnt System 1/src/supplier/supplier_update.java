package supplier;

import java.sql.*;
import java.util.Scanner;

public class supplier_update {
	static int sup_id;
	static String sup_name;
	static String email;
	static String gst_no;
	static long phn;
	static String sup_adr;
	static Scanner input;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	public static void supplier_update() {
		Connection conn = null;
		Statement stmt = null;
		char y = 'y';
		char b = 'y';
		input = new Scanner(System.in);
		while (y == 'y') {
			System.out.println("Enter the supplier id:");
			String id = input.next();
			if (!id.matches("[0-9]+")) {
				b = 'n';
			} else {
				sup_id = Integer.parseInt(id);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the supplier id:");
				id = input.next();
				if (!id.matches("[0-9]+")) {
					b = 'n';
				} else {
					b = 'y';
					sup_id = Integer.parseInt(id);
				}
			}
			System.out.println("Enter the supplier name:");
			sup_name = input.next();
			if (!sup_name.matches("[A-Za-z]+")) {
				b = 'n';
			}
			while (b == 'n') {
				System.out.println("Re-Enter the supplier name:");
				sup_name = input.next();
				if (!sup_name.matches("[A-Za-z]+")) {
					b = 'n';
				} else {
					b = 'y';
				}
			}
			System.out.println("Enter the supplier email:");
			email = input.next();
			// sup_name = input.next();
			if (!email.matches("[A-Za-z,@,0-9]+")) {
				b = 'n';
			}
			while (b == 'n') {
				System.out.println("Re-Enter the supplier email:");
				email = input.next();
				if (!email.matches("[A-Za-z,@,0-9]+")) {
					b = 'n';
				} else {
					b = 'y';
				}
			}
			System.out.println("Enter the supplier GST number:");
			gst_no = input.next();
			if (!email.matches("[A-Za-z,0-9]+")) {
				b = 'n';
			}
			while (b == 'n') {
				System.out.println("Re-Enter the supplier email:");
				email = input.next();
				if (!email.matches("[A-Za-z,0-9]+")) {
					b = 'n';
				} else {
					b = 'y';
				}
			}
			System.out.println("Enter the supplier address:");
			sup_adr = input.next();
			System.out.println("Enter the phn:");
			String phone = input.next();
			if (!phone.matches("[0-9]+")) {
				b = 'n';
			} else if (phone.length() > 10) {
				b = 'n';
			}
			while (b == 'n') {
				System.out.println("Re-Enter the supplier email:");
				email = input.next();
				if (!email.matches("[A-Za-z,0-9]+")) {
					b = 'n';
				} else if (phone.length() > 10) {
					b = 'n';
				} else {
					b = 'y';
				}
			}
			//phn = input.nextLong();

			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				stmt = conn.createStatement();
				System.out.println("Connection is created successfully:");

				String sql;
				sql = "update supplier set sup_name='" + sup_name + "',sup_email='"+email+"',gst_no='" + gst_no + "',sup_address='" + sup_adr
						+ "',sup_phn=" + phn + " where sup_id=" + sup_id;
				stmt.executeUpdate(sql);

				System.out.println("Connection is Updated successfully:");

			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
			// System.out.println("Goodbye!");
			System.out.println("Do you want to update more record(y for 'Yes' and n for 'No'");
			y = input.next().charAt(0);
		}
	}
}
