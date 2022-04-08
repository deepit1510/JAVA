package inventory;
import java.sql.*;


public class purchase_details_display{
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/inventory_control";          
    static final String USER = "root";
    static final String PASS = "";

public static void display_purchase() {
    Connection conn = null;
    Statement stmt = null;

    try{
  
        Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
     System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT purchase_id, item_id, supplier_id, supplier_name, purchase_qty, purchase_rate, purchase_amt FROM purchase_details";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
        	int purchase_id = rs.getInt("purchase_id");
            int item_id = rs.getInt("item_id");
            int supplier_id = rs.getInt("supplier_id");
            String supplier_name = rs.getString("supplier_name");
	    long purchase_qty = rs.getLong("purchase_qty");
	    Double purchase_rate = rs.getDouble("purchase_rate");
	    Double purchase_amt = rs.getDouble("purchase_amt");
    
	    System.out.println("Purchase ID: " + purchase_id);
            System.out.println("Item ID: " + item_id);
            System.out.println(" Supplier ID: " + supplier_id);
            System.out.println(" Supplier Name: " + supplier_name);
	    System.out.println(" Purchase Quantity: " + purchase_qty);
	    System.out.println(" Purchase Rate: " + purchase_rate);
	    System.out.println(" Purchase Amount: " + purchase_amt);
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