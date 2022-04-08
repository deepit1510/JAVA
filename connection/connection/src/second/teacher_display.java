package second;
//import java.util.*;
//import java.util.Scanner;
import java.sql.*;
public class teacher_display {
					//String teache_phn_id;
	            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
	            static final String DB_URL = "jdbc:mysql://localhost/stud";          
	    static final String USER = "root";
	    static final String PASS = "";
	public static void display_teacher()
	{
	    Connection conn = null;
	    Statement stmt = null;

	    try{
	  
	        Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	     System.out.println("Creating statement...");
	        stmt = conn.createStatement();
	        String sql;
	        sql = "SELECT teacher_id, teacher_name,subject_id,teache_phn_no,teacher_addrss FROM teacher";
	        ResultSet rs = stmt.executeQuery(sql);

	        while(rs.next()){
		

	            int teacher_id = rs.getInt("teacher_id");
	            String teacher_name = rs.getString("teacher_name");
	            int subject_id = rs.getInt("subject_id");
	            String teache_phn_no = rs.getString("teache_phn_no");
	           	String teacher_addrss= rs.getString("teacher_addrss");	
		
		
		System.out.println("Teacher Id :" +teacher_id);
	    System.out.println("Teacher Name: " +teacher_name);
		System.out.println(" subject id:" +subject_id);
		System.out.println(" Teacher phno:" +teache_phn_no);
		 System.out.println(" Address: " +teacher_addrss);


	        }

	        rs.close();
	        stmt.close();
	        conn.close();
	    }catch(SQLException se){     se.printStackTrace();
	    }catch(Exception e){
	        // Handle errors for Class.forName
	        e.printStackTrace();
	    }finally{
	        // finally block used to close resources
	        try{
	            if(stmt!=null)
	                stmt.close();
	        }catch(SQLException se){
	            se.printStackTrace();
	        } // end finally
	    } // end try
	System.out.println("Goodbye.");
	} // End method main
	} // end class ClientBase

