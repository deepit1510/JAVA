package db_connectivity;

import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.DriverManager;

public class DB_Connection {
	
	public Connection get_connection(){

		Connection connection = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_control","root","");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return connection;
	}
	
/*	public static void main(String[] args) {
		DB_Connection obj_DB_Connection = new DB_Connection();
		Connection connection = null;
		connection = obj_DB_Connection.get_connection();
		System.out.println(connection);
		
	}
	*/
}
