import java.util.*;
import java.util.Scanner;
import java.sql.*;
public class Bill_insert {
					
	            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
	            static final String DB_URL = "jdbc:mysql://localhost/water_bill_management";          
	    static final String USER = "root";
	    static final String PASS = "";
                     static Scanner a;
                    static int bid;
                   static String reading;
                  static String duration;
static String status;
static int pid;

                 
	public static void bb_insert()
	{
	 char y='y';
           Connection conn = null;
          Statement stmt = null;
       a = new Scanner (System.in);
	
	while(y=='y')
	{
	System.out.print("Enter Bill Id = ");
	  bid = a.nextInt();

	System.out.print("Enter Bill reading = ");
	  reading = a.next();
	System.out.print("Enter Bill duration = ");
	  duration = a.next();
	System.out.print("Enter Bill status = ");
	  status = a.next();
	System.out.print("Enter Price ID= ");
	  pid = a.nextInt();
	
	    try{
	  
	        Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	     System.out.println("Creating statement...");
	        stmt = conn.createStatement();
	        String sql;
	        sql = "insert into bill (bid,reading,duration,status,pid) values("+bid+",'"+reading+"','"+duration+"','"+status+"',"+pid+")";
	        ResultSet rs = stmt.executeQuery(sql);

System.out.println("Record is inserted in the table successfully..................");
      } catch (SQLException excep) {
         excep.printStackTrace();
      } catch (Exception excep) {
         excep.printStackTrace();
      } finally {
         try {
            if (stmt != null)
               conn.close();
         } catch (SQLException se) {}
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
