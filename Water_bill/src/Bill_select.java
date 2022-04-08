//import java.util.*;
//import java.util.Scanner;
import java.sql.*;
public class Bill_select {
					
	            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
	            static final String DB_URL = "jdbc:mysql://localhost/water_bill_management";          
	    static final String USER = "root";
	    static final String PASS = "";
	public static void bb_select()
	   // public static void main(String[]args)
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
	        sql = "SELECT * FROM bill";
	        ResultSet rs = stmt.executeQuery(sql);

	        while(rs.next()){
		

	            int id = rs.getInt("bid");
	            String reading = rs.getString("reading");
                            String duration = rs.getString("duration");
                            String status = rs.getString("status");
                             int pid = rs.getInt("pid");



		System.out.println("bill Id :" +id);
	    System.out.println("Bill Reading: " +reading);
		System.out.println("Bill duration :" +duration);
		System.out.println("Bill status :" +status);
		System.out.println("Price id :" +pid);
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

