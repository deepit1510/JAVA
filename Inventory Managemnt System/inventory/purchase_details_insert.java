package inventory;
import java.util.*;
import java.sql.*;


public class purchase_details_insert{
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

public static void insert_purchase() {
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
	purchase_amt = purchase_rate*purchase_qty;
    try{
  
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        stmt = conn.createStatement();
System.out.println("Connection is created successfully:");
        String sql;
	
        sql = "insert into purchase_details values("+purchase_id+","+item_id+","+supplier_id+",'"+supplier_name+"',"+purchase_qty+","+purchase_rate+","+purchase_amt+")";
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
   }
}