package connection;

//import java.util.*;
import java.sql.*;
import java.util.Scanner;

public class student_update {
	static int student_id;
	static String student_name;
	static String father_name;
	static long mobile_no;
	static int teacher_id;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/stud";
	static final String USER = "root";
	static final String PASS = "";
	 static Scanner b;

	public static void update_student() {
		char y = 'y';

		Connection conn = null;
		Statement stmt = null;

		b = new Scanner(System.in);
		while (y == 'y') {

			System.out.println("Enter Student Id");
			student_id = b.nextInt();

			System.out.println("Enter Student Name");
			student_name = b.next();
			while (!student_name.matches("[a-zA-Z ,]+")) {
				System.out.println("Re-enter Student Name");
				student_name = b.next();
			}

			System.out.println("Enter Father Name");
			father_name = b.next();
			while (!father_name.matches("[a-zA-Z ,]+")) {
				System.out.println("Re-enter Father Name");
				father_name = b.next();
			}

			System.out.println("Enter mobile no");
			mobile_no = b.nextLong();

			System.out.println("Enter teacher Id");
			teacher_id = b.nextInt();

			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				stmt = conn.createStatement();
				System.out.println("Connection is created successfully:");

				String sql;
				sql = "update student set student_name='" + student_name + "',father_name='" + father_name
						+ "',mobile_no=" + mobile_no + ",teacher_id=" + teacher_id + "  where student_id= "
						+ student_id;
				stmt.executeUpdate(sql);

				// Now you can extract all the records
				// to see the updated records
				sql = "SELECT * FROM student";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					// Retrieve by column name
					int student_id = rs.getInt("student_id");
					String student_name = rs.getString("student_name");
					String father_name = rs.getString("father_name");
					long mobile_no = rs.getLong("mobile_no");
					int subject_id = rs.getInt("subject_id");

					System.out.println("Id :" + student_id);
					System.out.println(" Name: " + student_name);
					System.out.println(" Father Name: " + father_name);
					System.out.println(" mobile: " + mobile_no);
					System.out.println(" subject: " + subject_id);

					System.out.println(" ");

					// rs.close();
					System.out.println("Connection is Updated successfully:");

				}
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
			System.out.println("Goodbye!");
			System.out.println("Do you want to insert more record(y for 'Yes' and n for 'No'");
			y = b.next().charAt(0);

		}
	}
}
