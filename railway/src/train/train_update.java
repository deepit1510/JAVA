package train;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class train_update {

	static int T_ID;
	static String T_NAME;
	static String T_SOURCE;
	static String T_DESTINATION;
	static int C_ID;
	static String C_NAME;

	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
    static final String DB_URL = "jdbc:mysql://localhost/railway";          
    static final String USER = "root";
    static final String PASS = "";
//private static Scanner a;
    static Scanner a;
	

public static void train_delete()
{

char y='y';
Connection conn = null;
Statement stmt = null;

a = new Scanner(System.in);
while(y=='y')
{
	System.out.println("Enter Train id");
	 int T_ID = a.nextInt();
	
		
	
	System.out.println("Enter Train Name");
	String T_NAME = a.next();
	 while(!T_NAME.matches("[a-zA-Z ,]+"))
	 {
System.out.println("Re-enter Train Name");
T_NAME = a.next();
	 }
	 
	
	
		
	System.out.println("Enter source");
	  T_SOURCE=a.next();
		
		while(!T_SOURCE.matches("[a-zA-Z ,]+"))
	 {
			System.out.println("Re-enter Source");
			T_SOURCE = a.next();
	 }
	
	
	System.out.println("Enter  destination");
	  T_DESTINATION=a.next();
		
			while(!T_DESTINATION.matches("[a-zA-Z ,]+"))
		 {
				System.out.println("Re-enter Destination");
				T_DESTINATION = a.next();
		 }
		
	
	
	System.out.println("Enter  customer id");
	 C_ID = a.nextInt();
	 
	 System.out.println("Enter customer Name");
		String C_NAME = a.next();
		 while(!C_NAME.matches("[a-zA-Z ,]+"))
		 {
	 System.out.println("Re-enter customer Name");
	 C_NAME = a.next();
		 }
			




try{

Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL, USER, PASS);



stmt = conn.createStatement();
System.out.println("Connection is created successfully:");


String sql;
sql = "update train set T_NAME='"+T_NAME+"',T_SOURCE='"+T_SOURCE+"',T_DESTINATION='"+T_DESTINATION+"',C_ID="+C_ID+", C_NAME='"+C_NAME +"' where T_ID= "+T_ID;
stmt.executeUpdate(sql);


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
y = a.next().charAt(0);
}

} 
}



