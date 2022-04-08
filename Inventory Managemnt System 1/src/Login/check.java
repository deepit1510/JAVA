package Login;

import main_file.*;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class check {
	static String name;
	static String no;
	static String year;
	static String pass;

	static Scanner input;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	public static void check() {

		Connection conn = null;
		Statement stmt = null;
		input = new Scanner(System.in);
		System.out.println("!!--------Login--------!!");
		System.out.println("Enter your email id");
		String user = input.next();
		System.out.println("Enter your passowrd");
		String str = input.next();

		if (user.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Username  cannot be empty");
		} else if (str.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Password cannot be empty");
		} else {
			try {

				Class.forName("com.mysql.jdbc.Driver");
				//System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Creating statement...");
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT pswd FROM login where usr='" + user + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {

					String pswrd = rs.getString("pswd");
				////	System.out.println("Login1" + pswrd);

				//	System.out.println(str);
					if (pswrd.equals(str)) {
						System.out.println("Login successfull");
						main_menu file = new main_menu();
						main_menu.main_page();

					} else {
						String z = "Password is incorrect";
						System.out.println(z);
						}

					rs.close();
					stmt.close();
					conn.close();
				} else {
					JOptionPane.showMessageDialog(null, "Username does not exist");
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally
			} // end try
			System.out.println("Goodbye.");
		}
	}

}
