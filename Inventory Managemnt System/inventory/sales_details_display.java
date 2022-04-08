package inventory;
import java.sql.*;


public class sales_details_display{
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/inventory_control";          
    static final String USER = "root";
    static final String PASS = "";

public static void display_sales() {
    Connection conn = null;
    Statement stmt = null;

    try{
  
        Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
     System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT sales_id, item_id, customer_id, customer_name, price, qty, total_price FROM sales_details";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){

            int sales_id = rs.getInt("sales_id");
            int item_id = rs.getInt("item_id");
            int customer_id = rs.getInt("customer_id");
            String customer_name = rs.getString("customer_name");
	    long price = rs.getLong("price");
	    long qty = rs.getLong("qty");
	    long total_price = rs.getLong("total_price");
	  //  long stock = rs.getLong("stock");
    
            System.out.println("Sales ID: " + sales_id);
            System.out.println(" Item ID: " + item_id);
	    System.out.println(" Customer ID: " + customer_id);
	    System.out.println(" Customer name: " + customer_name);
	    System.out.println(" Price: " + price);
	    System.out.println(" Qty: "+qty);
	    System.out.println(" Total Price:"+total_price);
	    
	    System.out.println("\n");
    
        }

        rs.close();
        stmt.close();
        conn.close();
    }catch(SQLException se){     se.printStackTrace();
    }catch(Exception e){
        // Handle errors for Class.forName
        e.printStackTrace();
    }finally{
        // finally block used to close resources
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se){
            se.printStackTrace();
        } // end finally
    } // end try
System.out.println("Goodbye.");
} // End method main
} // end class ClientBase