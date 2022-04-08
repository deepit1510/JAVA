
import java.util.*;
import java.sql.*;
import java.lang.*;
public class Price_update {
					
	            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
	            static final String DB_URL = "jdbc:mysql://localhost/water_bill_management";          
	    static final String USER = "root";
	    static final String PASS = "";
                     static Scanner a;
                    static int id;
static float amount;

                 
	public static void pp_update()
	{
	 char y='y';
           Connection conn = null;
          Statement stmt = null;
       a = new Scanner(System.in);
	
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
	        sql = "update price set amount="+amount+" where pid="+id;
	        stmt.executeUpdate(sql);

System.out.println("Record updated the table successfully..................");
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
    


}
}
