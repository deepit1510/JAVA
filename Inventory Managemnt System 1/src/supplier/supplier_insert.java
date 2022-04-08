package supplier;

import java.util.*;
import java.sql.*;

public class supplier_insert {
	static int sup_id;
	static String sup_name;
	static String gst_no;
	static String email;
	static long phn;
	static String sup_adr;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";
	static Scanner input;

	public static void supplier_insert() {
		char y = 'y';
		char b = 'y';
		Connection conn = null;
		Statement stmt = null;
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
				System.out.println("Re-Enter tsupplier GST number::");
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
				phone = input.next();
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

				sql = "insert into supplier(sup_name,sup_email,gst_no,sup_address,sup_phn) values('" + sup_name + "','"
						+ email + "','" + gst_no + "','" + sup_adr + "'," + phn + ")";
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
			// System.out.println("Please check it in the MySQL Table.........
			// ……..");
			System.out.println("Do you want to inset more data(y for 'Yes' and n for 'No'");
			y = input.next().charAt(0);
		}
	}
}
