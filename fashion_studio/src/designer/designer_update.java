package designer;
import java.util.*;
import java.sql.*;

public class designer_update {
	static int d_id;
	static String d_name	;
	static Long d_phone;
	static String p_type;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
    static final String DB_URL = "jdbc:mysql://localhost/fashion_studio";          
    static final String USER = "root";
    static final String PASS = "";
//private static Scanner a;
    static Scanner a;
	
   // public static void main(String args[]) {
public static void designer_update() {

char y='y';
Connection conn = null;
Statement stmt = null;

a = new Scanner(System.in);
while(y=='y')
{
	System.out.println("Enter designer id");
	int d_id = a.nextInt();
	

System.out.println("Enter designer Name");
String 	d_name	 = a.next();
 while(!	d_name	.matches("[a-zA-Z ,]+"))
 {
System.out.println("Re-enter product Name");
d_name	 = a.next();
 }
 
System.out.println("Enter designer phone");
d_phone =a.nextLong();

System.out.println("Enter  product type");
p_type = a.next();	
try{

Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection(DB_URL, USER, PASS);

stmt = conn.createStatement();
System.out.println("Connection is created successfully:");
//	D_ID	D_NAME	D_PHONE	P_TYPE	
String sql;
sql = "update designer set D_NAME='"+d_name+"',D_PHONE='"+d_phone+"',P_TYPE='"+p_type+"' where d_id= "+d_id;
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






