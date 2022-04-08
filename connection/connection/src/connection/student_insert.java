package connection;
import java.util.*;
import java.sql.*;
//import java.text.NumberFormat;

public class student_insert {
	
	static int student_id;
	static String student_name;
	static String father_name;
	static long mobile_no;
	static int teacher_id;
	static String subject_1;
	static String subject_2;
	static String subject_3;
	static String subject_4;
	static String subject_5;
	
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/stud";          
    static final String USER = "root";
    static final String PASS = "";
    static Scanner a;
   

 public static void insert_student()
 {
	char y='y';
    Connection conn = null;
    Statement stmt = null;
	
	a = new Scanner (System.in);
	
	while(y=='y')
	{
	System.out.print("Enter Student Id = ");
	  student_id = a.nextInt();
	 
	  
	
  	
	System.out.println("Enter Student Name");
	String student_name = a.next();
	 while(!student_name.matches("[a-zA-Z ,]+"))
		 {
	 System.out.println("Re-enter Student Name");
		  student_name = a.next();
		 }
	
	System.out.println("Enter Father Name");
	String father_name = a.next();
	 while(!father_name.matches("[a-zA-Z ,]+"))
	 {
 System.out.println("Re-enter Father Name");
	  father_name = a.next();
	 }
	
	
	System.out.println("Enter mobile no");
	 long mobile_no=a.nextLong();
	
	
	System.out.println("Enter teacher Id");
	int teacher_id = a.nextInt();


	


    try{
	      
	  Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
	

  	


        stmt = conn.createStatement();
System.out.println("Connection is created successfully:");
        String sql;
        sql =  "insert into student(student_name, father_name,mobile_no,teacher_id) values('"+student_name+" ',' "+father_name+" ', "+mobile_no+","+teacher_id+")";
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
         } catch (SQLException se) {}
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         }  
      }
    
     System.out.println("Please check it in the MySQL Table......... ……..");
    System.out.println("Do you want to insert more record(y for 'Yes' and n for 'No'");
	y = a.next().charAt(0);
   }


}
}
