package second;
import java.util.*;
import java.sql.*;

public class teacher_insert {
		static int teacher_id;
		static String teacher_name;
		static String teacher_addrss;
		static long teache_phn_no;
		static int subject_id;
		
	            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
	            static final String DB_URL = "jdbc:mysql://localhost/stud";          
	    static final String USER = "root";
	    static final String PASS = "";
		 static Scanner a;
	   

	 public static void insert_teacher() 
	 {
		char y='y';
		
	    Connection conn = null;
	    Statement stmt = null;
		
		a = new Scanner (System.in);
		while(y=='y')
		{
		System.out.println("Enter teacher id");
		 int teacher_id = a.nextInt();
		
	  	
		
		System.out.println("Enter teacher Name");
		String teacher_name = a.next();
		 while(!teacher_name.matches("[a-zA-Z ,]+"))
		 {
	 System.out.println("Re-enter teacher Name");
		  teacher_name = a.next();
		 }
		 
		System.out.println("Enter subject Id");
		int subject_id= a.nextInt();
		
			
		System.out.println("Enter teacher phn no");
		 long teache_phn_no=a.nextLong();
		
		System.out.println("Enter  teacher address");
		String teacher_addrss = a.next();
			


	


		


	    try{
		      
		  Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		

	  	


	        stmt = conn.createStatement();
	System.out.println("Connection is created successfully:");
	        String sql;
	        sql =  "insert into teacher values("+teacher_id+",' "+teacher_name+" ',' "+subject_id+" ',"+teache_phn_no+" ,' "+teacher_addrss+" ')";
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
	         } catch (SQLException se) 
	         {
	        	 
	         }
	        	 
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
