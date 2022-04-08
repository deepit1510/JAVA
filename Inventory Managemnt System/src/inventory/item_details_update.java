package inventory;
import java.util.*;
import java.sql.*;



public class item_details_update{
	static int item_id;
	static String item_name;
	static long reorder_level;
	static long average_monthly_usage;
	static long reorder_qty;
	static long stock;
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/inventory_control";          
    static final String USER = "root";
    static final String PASS = "";

public static void update_item() {
    Connection conn = null;
    Statement stmt = null;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the item id:");
	item_id = input.nextInt();
	System.out.println("Enter the item name:");
	item_name = input.next();
	System.out.println("Enter the monthly average sales of item:");
	average_monthly_usage = input.nextLong();
	reorder_level = ((average_monthly_usage/10)*4);
	reorder_qty = average_monthly_usage - reorder_level;
	stock = average_monthly_usage;
    try{
  
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        stmt = conn.createStatement();
System.out.println("Connection is created successfully:");


      String sql;
sql = "update item set item_name='"+item_name+"' ,reorder_level="+(int)reorder_level+", average_monthly_usage="+average_monthly_usage+",reorder_qty="+reorder_qty+",stock="+stock+" where item_id="+item_id;
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