package second;
import java.util.Scanner;
import java.sql.*;
public class teacher_update {
	static int teacher_id;
	static String teacher_name;
	static String teacher_addrss;
	static String teache_phn_no;
	static int student_id;
	
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/stud";          
    static final String USER = "root";
    static final String PASS = "";
	//private static Scanner a;
	 static Scanner a2;

public static void update_teacher()
{

		char y='y';
    Connection conn = null;
    Statement stmt = null;
    
a2 = new Scanner(System.in);
while(y=='y')
{
System.out.println("Enter teacher id");
 int teacher_id = a2.nextInt();

	

System.out.println("Enter teacher Name");
String teacher_name = a2.next();
while(!teacher_name.matches("[a-zA-Z ,]+"))
{
System.out.println("Re-enter teacher Name");
 teacher_name = a2.next();
}

System.out.println("Enter subject Id");
int subject_id= a2.nextInt();

	
System.out.println("Enter teacher phn no");
 String teache_phn_no=a2.next();

System.out.println("Enter  teacher address");
String teacher_addrss = a2.next();
	


    try{
  
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
	

        stmt = conn.createStatement();
System.out.println("Connection is created successfully:");


      String sql;
sql = "update teacher set teacher_name='"+teacher_name+"',subject_id="+subject_id+",teache_phn_no='"+teache_phn_no+"',teacher_addrss='"+teacher_addrss+"'  where teacher_id= "+teacher_id;
      stmt.executeUpdate(sql);

    // Now you can extract all the records
      // to see the updated records
      /*sql = "SELECT * FROM teacher";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         //Retrieve by column name

          int teacher_id = rs.getInt("teacher_id");
          String teacher_name = rs.getString("teacher_name");
          String course_id = rs.getString("course_id");
          String teache_phn_no = rs.getString("teache_phn_no");
          String teacher_addrss= rs.getString("teacher_addrss");	
	
	
	System.out.println("Teacher Id :" +teacher_id);
	System.out.println("Teacher Name: " +teacher_name);
	System.out.println(" course:" +course_id);
	System.out.println(" Teacher phno:" +teache_phn_no);
	 System.out.println(" Address: " +teacher_addrss);


         System.out.println(" ");
      
    //  rs.close();
System.out.println("Connection is Updated successfully:");


   }*/
    }
      catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }
   catch(Exception e)
   {
      //Handle errors for Class.forName
      e.printStackTrace();
   }
   System.out.println("Goodbye!");
   System.out.println("Do you want to insert more record(y for 'Yes' and n for 'No'");
	y = a2.next().charAt(0);
}
   
} 
}




