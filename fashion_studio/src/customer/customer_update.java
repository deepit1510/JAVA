package customer;
import java.util.*;
import java.sql.*;

public class customer_update {
	static int c_id;
	static String c_name;
	static String c_add;
	static double c_phone;
	static double amount;
	static int p_id;
	static int d_id;
		
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
    static final String DB_URL = "jdbc:mysql://localhost/fashion_studio";          
    static final String USER = "root";
    static final String PASS = "";
    static Scanner a;
	

public static void customer_update() {
//	public static void main(String args[]) {
char y='y';
Connection conn = null;
Statement stmt = null;

a = new Scanner(System.in);
while(y=='y')
{

	System.out.println("Enter customer id");
	c_id = a.nextInt();

	System.out.println("Enter customer  name");
	c_name = a.next();

	System.out.println("Enter customer address");
	c_add = a.next();

	System.out.println("Enter customer phone number");
	c_phone = a.nextInt();

	System.out.println("Enter product Id");
	p_id = a.nextInt();

	System.out.println("Enter designer Id");
	d_id = a.nextInt();

try{

Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL, USER, PASS);



stmt = conn.createStatement();
System.out.println("Connection is created successfully:");


String sql;
sql = "update customer set C_NAME='"+c_name+"',C_ADD='"+c_add+"',c_phone="+c_phone+",p_id="+p_id+",p_id="+p_id+" where c_id= "+c_id;
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


	

