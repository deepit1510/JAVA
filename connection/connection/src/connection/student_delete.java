package connection;

//import java.util.*;
import java.sql.*;
import java.util.Scanner;

public class student_delete {
	static int student_id;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/stud";
	static final String USER = "root";
	static final String PASS = "";
	static Scanner a;

	public static void delete_student() {
	//	char y = 'y';

		Connection conn = null;
		Statement stmt = null;
		a = new Scanner(System.in);
		// while (y == 'y') {
		System.out.println("Enter student id ");
		student_id = a.nextInt();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Connection is created successfully:");

			String sql;
			sql = "delete from student where  student_id=" + student_id;
			stmt.executeUpdate(sql);

			// Now you can extract all the records
			// to see the updated records
			// sql = "SELECT * FROM student";
			// ResultSet rs2 = stmt.executeQuery(sql);

			/*
			 * while(rs2.next()) { //Retrieve by column name int student_id =
			 * rs2.getInt("student_id"); String student_name =
			 * rs2.getString("student_name"); String father_name =
			 * rs2.getString("father_name"); String mobile_no =
			 * rs2.getString("mobile_no"); String course_id =
			 * rs2.getString("course_id");
			 * 
			 * 
			 * //Display values System.out.println("Id :" +student_id);
			 * System.out.println(" Name: " +student_name);
			 * System.out.println(" Father Name: " +father_name);
			 * System.out.println(" mobile: " +mobile_no);
			 * System.out.println(" course: " +course_id);
			 */
			//rs2.close();
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

