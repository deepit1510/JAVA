package inventory;
import java.util.*;
import java.sql.*;



public class sales_details_update{
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

public static void update_sales() {
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
sql = "update sales_details set item_id="+item_id+",customer_id="+customer_id+",customer_name='"+customer_name+"',price="+price+",qty="+qty+",total_price="+total+" where sales_id="+sales_id;
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