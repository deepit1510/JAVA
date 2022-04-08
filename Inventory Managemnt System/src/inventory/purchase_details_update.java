package inventory;
import java.util.*;
import java.sql.*;



public class purchase_details_update{
	static int purchase_id;
	static int item_id;
	static int supplier_id;
	static String supplier_name;
	static long purchase_qty;
	static double purchase_rate;
	static double purchase_amt;
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/inventory_control";          
    static final String USER = "root";
    static final String PASS = "";

public static void update_purchase() {
    Connection conn = null;
    Statement stmt = null;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the purchase id:");
	purchase_id = input.nextInt();
    System.out.println("Enter the item id:");
	item_id = input.nextInt();
	System.out.println("Enter the supplier id:");
	supplier_id = input.nextInt();
	System.out.println("Enter the supplier name:");
	supplier_name = input.next();
	System.out.println("Enter the purchase quantity:");
	purchase_qty = input.nextLong();
	System.out.println("Enter the purchase rate:");
	purchase_rate = input.nextDouble();
    try{
  
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        stmt = conn.createStatement();
System.out.println("Connection is created successfully:");


      String sql;
sql = "update purchase_details set item_id="+item_id+",supplier_id="+supplier_id+",supplier_name='"+supplier_name+"',purchase_qty="+purchase_qty+",purchase_rate="+purchase_rate+",purchase_amt="+purchase_amt+" where purchase_id="+purchase_id;
      stmt.executeUpdate(sql);

     
    //  rs.close();
System.out.println("Connection is Updated successfully:");


   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
   System.out.println("Goodbye!");
} 
}