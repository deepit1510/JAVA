package inventory;
import java.util.*;
import java.sql.*;


public class sales_details_insert{
	static int sales_id;
	static int item_id;
	static int customer_id;
	static String customer_name;
	static double price;
	static long qty;
	static double total;
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/inventory_control";          
    static final String USER = "root";
    static final String PASS = "";

public static void insert_sales() {
    Connection conn = null;
    Statement stmt = null;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the sales id:");
	sales_id = input.nextInt();
    System.out.println("Enter the item id:");
	item_id = input.nextInt();
	System.out.println("Enter the customer id:");
	customer_id = input.nextInt();
	System.out.println("Enter the customer name:");
	customer_name = input.next();
	System.out.println("Enter the price:");
	price = input.nextDouble();
	System.out.println("Enter the quantity:");
	qty = input.nextLong();
	total = qty*price;
    try{
  
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        stmt = conn.createStatement();
System.out.println("Connection is created successfully:");
        String sql;
	
        sql = "insert into purchase_details values("+sales_id+","+item_id+","+customer_id+",'"+customer_name+"',"+price+","+qty+","+total+")";
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