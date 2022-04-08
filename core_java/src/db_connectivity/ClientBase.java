package db_connectivity;

//import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.*;


public class ClientBase{
            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
            static final String DB_URL = "jdbc:mysql://localhost/inventory_control";          
    static final String USER = "root";
    static final String PASS = "";

public static void display() {
    Connection conn = null;
    Statement stmt = null;

    try{
  
        Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
     System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM inventory_management";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){

            int id = rs.getInt("item_id");
            String name = rs.getString("item_name");
	    long stock = rs.getLong("item_stock");
	    double price = rs.getDouble("item_price");
    
            System.out.print("ID: " + id);
            System.out.print(" Name: " + name);
	    System.out.print(" Stock: " + stock);
	    System.out.print(" Price: " + price);
    
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
} // End function

public static void insert() {
    Connection conn = null;
    Statement stmt = null;
    Scanner input = new Scanner(System.in);
    try{
  
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        stmt = conn.createStatement();
System.out.println("Connection is created successfully:");
        String sql;
	System.out.println("Enter the item id:");
	int id = input.nextInt();
	System.out.println("Enter the item name:");
	String name = input.next();
	System.out.println("Enter the item stock:");
	long stock = input.nextLong();
	System.out.println("Enter the price of the stock:");
	double price = input.nextDouble();
        sql = "insert into inventory_management values(id,name,stock,price)";
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
public static void delete() {
    Connection conn = null;
    Statement stmt = null;

    try{
  	Scanner input=new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        stmt = conn.createStatement();
System.out.println("Connection is created successfully:");


      String sql;
System.out.println("Enter the stock id");
	int id = input.nextInt();
sql = "delete from inventory_management where  id="id;
      stmt.executeUpdate(sql);

      // Now you can extract all the records
      // to see the updated records
      sql = "SELECT * FROM inventory_management";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("item_id");
        String name = rs.getString("item_name");
	Long stock = rs.getLong("item_stock");
	double price = rs.getDouble("item_price");

         //Display values
         System.out.print("ID: " + id);
         System.out.print("Name: " + name);
	 System.out.print("Stock: " + name);
	 System.out.print("Name: " + name);
         System.out.println(" ");
      }
      rs.close();
System.out.println("Connection is Deleted successfully:");


   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
   System.out.println("Goodbye!");
} 
} // end class ClientBase