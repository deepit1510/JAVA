package train;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class train_display {

	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
	    static final String DB_URL = "jdbc:mysql://localhost/railway";          
	    static final String USER = "root";
		static final String PASS = "";
		static int T_ID;
		static String T_NAME;
		static String T_SOURCE;
		static String T_DESTINATION;
		static int C_ID;
		static String C_NAME;

	public static void train_delete()
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
	sql = "SELECT * FROM train";
	ResultSet rs = stmt.executeQuery(sql);

	while(rs.next())
	{


	  T_ID = rs.getInt("T_ID");
	    T_NAME = rs.getString("T_NAME");
	    T_SOURCE = rs.getString("T_SOURCE");
	    T_DESTINATION = rs.getString("T_DESTINATION");	
	   	C_ID = rs.getInt("C_ID");
	   	C_NAME = rs.getString("C_NAME");
	   	
	   	
		System.out.println("Enter Train id:" +T_ID);
		 
		
		System.out.println("Enter Train name :" +T_NAME);
		
		
		System.out.println("Enter  Train source :" +T_SOURCE);
		
		System.out.println("Enter  Train destination :" +T_DESTINATION);	
		
		System.out.println("Enter Customer id  :" +C_ID);
		
		System.out.println("Enter Train name :" +T_NAME);
		
		

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





