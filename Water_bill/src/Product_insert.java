import java.util.Scanner;
import java.sql.*;
public class  Product_insert {
					

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/water_bill_management";
	static final String USER = "root";
	static final String PASS = "";
                     static Scanner a;
                    static int id;

static String fname;
static String lname;
static String address;
static int phone;
static String city;
static String email;
static int pid,bid;

                 
	public static void customer_insert()
	{
	 char y='y';
           Connection conn = null;
          Statement stmt = null;
       a = new Scanner (System.in);
	
	while(y=='y')
	{
	System.out.print("Enter Product Id = ");
	  id = a.nextInt();
	System.out.print("Enter Product fname = ");
	  fname = a.next();
	System.out.print("Enter Product lname = ");
	  lname = a.next();
	System.out.print("Enter Product Address = ");
	  address = a.next();
	System.out.print("Enter Product phone= ");
	  phone = a.nextInt();
	System.out.print("Enter Product city = ");
	  city = a.next();
	System.out.print("Enter Product email = ");
	  email = a.next();
	System.out.print("Enter Product price Id = ");
	  pid = a.nextInt();
	System.out.print("Enter Product bill Id = ");
	  bid = a.nextInt();

	    try{
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
	        
	      System.out.println("Connecting to database...");
	        String sql;
	        sql = "insert into customer (cid,fname,lname,phone,address,city,email,pid,bid) values("+id+","
	        		+ "'"+fname+"','"+lname+"',"+phone+","
	        		+ "'"+address+"','"+city+"','"+email+"',"+pid+","+bid+")";
	        stmt.executeUpdate(sql);
	        System.out.println("Record is inserted in the table successfully..................");
		} catch (SQLException excep) {
			excep.printStackTrace();
		}finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
        System.out.println("Please check it in the MySQL Table......... ……..");
    System.out.println("Do you want to insert more record(y for 'Yes' and n for 'No'");
	y = a.next().charAt(0);
   }


}
}
