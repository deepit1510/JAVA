import java.util.*;
import java.sql.*;
public class Product_select {
					
	            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";                
	            static final String DB_URL = "jdbc:mysql://localhost/water_bill_management";          
	    static final String USER = "root";
	    static final String PASS = "";
	public static void customer_select()
	    //public static void main(String[]args)
	{
	    Connection conn = null;
	    Statement stmt = null;

	    try{
	  
	        Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	     System.out.println("Creating statement...");
	        stmt = conn.createStatement();
	        String sql;
	        sql = "SELECT * FROM customer";
	        ResultSet rs = stmt.executeQuery(sql);

	        while(rs.next()){
		

	            int id = rs.getInt("cid");
	            String name = rs.getString("fname");
                            String lname = rs.getString("lname");
         	            int phone = rs.getInt("phone");
                           String address = rs.getString("address");
                            String city = rs.getString("city");
                            String email = rs.getString("email");  		
         	            int pid = rs.getInt("pid");         	            
                             int bid = rs.getInt("bid");



		System.out.println("Product Id :" +id);
	    System.out.println("Product  Name: " +name);
		System.out.println("Product last name :" +lname);
		System.out.println("Product phone :" +phone);
		System.out.println("Product address :" +address);
		System.out.println("Product city :" +city);
		System.out.println("Product email :" +email);
		System.out.println("Product Price Id :" +pid);
		System.out.println("Product Bill Id :" +bid);
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


