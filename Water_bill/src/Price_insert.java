import java.util.*;
import java.util.Scanner;
import java.sql.*;
public class Price_insert {
					
	            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
	            static final String DB_URL = "jdbc:mysql://localhost/water_bill_management";          
	    static final String USER = "root";
	    static final String PASS = "";
                     static Scanner a;
                    static int id;

static float amount;                 
	public static void pp_insert()
	{
	 char y='y';
           Connection conn = null;
          Statement stmt = null;
       a = new Scanner (System.in);
	
	while(y=='y')
	{
	System.out.print("Enter Price Id = ");
	  id = a.nextInt();

	System.out.print("Enter Price amount = ");
	  amount = a.nextFloat();
	

	    try{
	  
	        Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	     System.out.println("Creating statement...");
	        stmt = conn.createStatement();
	        String sql;
	        sql = "insert into price (pid,amount) values("+id+","+amount+")";
	        stmt.executeUpdate(sql);

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
