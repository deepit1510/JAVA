package inventory;
import java.util.*;
import java.sql.*;



public class update{
	static int item_id;
	static String item_name;
	static long item_stock;
	static double item_price;
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
	System.out.println("Enter the item stock:");
	item_stock = input.nextLong();
	System.out.println("Enter the price of the stock:");
	 item_price = input.nextDouble();
    try{
  
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        stmt = conn.createStatement();
System.out.println("Connection is created successfully:");


      String sql;
sql = "update inventory_management set item_name='"+item_name+"',item_stock="+item_stock+",item_price="+item_price+" where item_id="+item_id;
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