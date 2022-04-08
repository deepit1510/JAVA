package second;

import java.sql.*;
import java.util.Scanner;

public class teacher_delete {
	static int teacher_id;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
    static final String DB_URL = "jdbc:mysql://localhost/stud";          
static final String USER = "root";
static final String PASS = "";
 static Scanner a;

public static void delete_teacher(){
	char y='y';
Connection conn = null;
Statement stmt = null;
a = new Scanner(System.in);
while(y=='y')
{
System.out.println("Enter teacher id ");
teacher_id = a.nextInt();



try{

Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL, USER, PASS);

stmt = conn.createStatement();
System.out.println("Connection is created successfully:");


String sql;
sql = "delete from teacher where  teacher_id="+teacher_id;
stmt.executeUpdate(sql);

// Now you can extract all the records
// to see the updated records
sql = "SELECT * FROM teacher";
ResultSet rs2 = stmt.executeQuery(sql);

/*while(rs2.next())
{
 //Retrieve by column name
	 int teacher_id = rs2.getInt("teacher_id");
     String teacher_name = rs2.getString("teacher_name");
     String course_id = rs2.getString("course_id");
     String teache_phn_no = rs2.getString("teache_phn_no");
     String teacher_addrss= rs2.getString("teacher_addrss");	


System.out.println("Teacher Id :" +teacher_id);
System.out.println("Teacher Name: " +teacher_name);
System.out.println(" course:" +course_id);
System.out.println(" Teacher phno:" +teache_phn_no);
System.out.println(" Address: " +teacher_addrss);

*/
rs2.close();
System.out.println("Connection is Deleted successfully:");


}

catch(SQLException se){
//Handle errors for JDBC
se.printStackTrace();
}catch(Exception e){
//Handle errors for Class.forName
e.printStackTrace();
}
System.out.println("Goodbye!");
System.out.println("Do you want to insert more record(y for 'Yes' and n for 'No'");
y = a.next().charAt(0);

} 
}

}