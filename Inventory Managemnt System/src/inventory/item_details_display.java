package inventory;
import java.sql.*;


public class item_details_display{
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/inventory_control";          
    static final String USER = "root";
    static final String PASS = "";

public static void display_item() {
    Connection conn = null;
    Statement stmt = null;

    try{
  
        Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
     System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT item_id, item_name, reorder_level, average_monthly_usage, reorder_qty, stock FROM item";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){

            int id = rs.getInt("item_id");
            String name = rs.getString("item_name");
	    long re_level = rs.getLong("reorder_level");
	    long avg_usage = rs.getLong("reorder_level");
	    long re_qty = rs.getLong("reorder_qty");
	    long stock = rs.getLong("stock");
    
            System.out.println("ID: " + id);
            System.out.println(" Name: " + name);
	    System.out.println(" Reorder Level: " + re_level);
	    System.out.println(" Average Monthly Usage: " + avg_usage);
	    System.out.println(" Reorder Qty: " + re_qty);
	    System.out.println("Stock: "+stock);
	    
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