package employee;

import java.sql.*;
import java.util.*;

public class employe_update {

	static int E_ID;
	static String E_NAME;
	static String E_PHONE_NUMBER;
	static String GENDER;
	static int C_ID;
	
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
    static final String DB_URL = "jdbc:mysql://localhost/railway";          
    static final String USER = "root";
    static final String PASS = "";
//private static Scanner a;
    static Scanner a;
	

public static void employe_update()
{

char y='y';
Connection conn = null;
Statement stmt = null;

a = new Scanner(System.in);
while(y=='y')
{
	System.out.println("Enter Employe id");
	 int E_ID = a.nextInt();
	
		
	
	System.out.println("Enter Employe Name");
	String E_NAME = a.next();
	 while(!E_NAME.matches("[a-zA-Z ,]+"))
	 {
System.out.println("Re-enter Employe Name");
E_NAME = a.next();
	 }
	 
	
	
		
	System.out.println("Enter employe phone number");
	  E_PHONE_NUMBER=a.next();
		
		while(!E_PHONE_NUMBER.matches("[0-9]+"))
	 {
			System.out.println("Re-enter phone number");
			E_PHONE_NUMBER = a.next();
	 }
	
	
	System.out.println("Enter  Gender");
	System.out.println("Select the gender:");
	System.out.println("1. For Male");
	System.out.println("2. For Female");
	System.out.println("3. For Others");
	int choice = a.nextInt();
	if (choice == 1) {
		GENDER = "Male";
	} else if (choice == 2) {
		GENDER = "Female";
	} else {
		GENDER = "other";
	}

	System.out.println("Enter  customer id");
	 C_ID = a.nextInt();
	 
		





try{

Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL, USER, PASS);



stmt = conn.createStatement();
System.out.println("Connection is created successfully:");


String sql;
sql = "update employee set E_NAME='"+E_NAME+"',E_PHONE_NUMBER='"+E_PHONE_NUMBER+"',GENDER='"+GENDER+"',C_ID="+C_ID+"  where E_ID= "+E_ID;
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



