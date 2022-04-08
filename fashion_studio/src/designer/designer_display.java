package designer;
//import java.util.*;
import java.sql.*;

public class designer_display {
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
	    static final String DB_URL = "jdbc:mysql://localhost/fashion_studio";          
	    static final String USER = "root";
		static final String PASS = "";
		static int d_id;
		static String d_name;
		static long d_phone;
		 static String p_type;
	
		 //public static void main(String args[]) {
	public static void designer_display(){
	Connection conn = null;
	Statement stmt = null;

	try{

	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Connecting to database...");
	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	System.out.println("Creating statement...");
	stmt = conn.createStatement();
	String sql;
	sql = "SELECT * FROM designer";
	ResultSet rs = stmt.executeQuery(sql);

	while(rs.next()){
//	D_ID	D_NAME	D_PHONE	P_TYPE	

	    d_id = rs.getInt("D_ID");
	    d_name = rs.getString("D_NAME");
	    d_phone = rs.getLong("D_PHONE");
	    p_type = rs.getString("P_TYPE");
	   	
		System.out.println("Enter designer id :" +d_id);
		 
		
		System.out.println("Enter designer name :" +d_name);
			
		System.out.println("Enter designer phone number :" +d_phone);
				 	
		System.out.println("Enter designer type" +p_type);
	
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






