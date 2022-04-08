import java.sql.*;


public class javaconnect {
    Connection conn;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/isp";
	static final String USER = "root";
	static final String PASS = "";
    public static java.sql.Connection ConnecrDb(){
    	Connection conn = null;
		Statement stmt = null;
        try{
        	Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//System.out.println("Creating statement...");
			stmt = conn.createStatement();
           // java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/isp", "root", "");
            return conn;
        } catch(Exception e){
        	System.out.println("Unable");
        	
        }
        return null;
    }
    public static void main(String args[]) {
    	javaconnect a = new javaconnect();
    	
    	a.ConnecrDb();
    }
}
