package employee;

import java.sql.*;

public class employe_display {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
    static final String DB_URL = "jdbc:mysql://localhost/railway";          
    static final String USER = "root";
	static final String PASS = "";
	static int E_ID;
	static String E_NAME;
	static String E_PHONE_NUMBER;
	static String GENDER;
	static int C_ID;

public static void employe_display()
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
sql = "SELECT * FROM employee";
ResultSet rs = stmt.executeQuery(sql);

while(rs.next())
{


   E_ID = rs.getInt("E_ID");
    E_NAME = rs.getString("E_NAME");
    E_PHONE_NUMBER = rs.getString("E_PHONE_NUMBER");
   	GENDER = rs.getString("GENDER");	
   	C_ID = rs.getInt("C_ID");

   	
   	
	System.out.println("Enter Employee id:" +E_ID);
	 
	
	System.out.println("Enter Employee name :" +E_NAME);
	
	
	System.out.println("Enter  employee phone number :" +E_PHONE_NUMBER);
	
	System.out.println("Enter GENDER :" +GENDER);	
	
	System.out.println("Enter Customer id  :" +C_ID);
	
	
	
	

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





