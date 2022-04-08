package Reorder;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SendEmail {
	static String sup_email;
	static int id;
	static int sup_id;
	static String tdate;
	static String item_name;
	static double eoq;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	public static void reorder() {
		Connection conn = null;
		Statement stmt = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
	    tdate =formatter.format(date);
	    System.out.println(tdate);
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			Statement stmt1 = conn.createStatement();
			String sql;
			sql = "SELECT item_id, item_name, sup_id, eoq  FROM item where crt_stk <= re_order_lvl";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				id = rs.getInt("item_id");
				sup_id = rs.getInt("sup_id");
				item_name = rs.getString("item_name");
				eoq = rs.getDouble("eoq");
				String sql1;
				sql1 = "SELECT sup_email from supplier where sup_id="+sup_id;
				ResultSet rs1 = stmt.executeQuery(sql1);
				while (rs1.next()) {
				sup_email = rs1.getString("sup_email");
				}
				sende(sup_email,id,item_name,eoq);
				//rs1.close();
			//	stmt = conn.createStatement();
				String sql2;
				sql2 = "Insert into re_order(sup_id, item_id, odr_date) values(" +sup_id + "," + id +",'"+tdate+ "')";
				stmt.executeUpdate(sql2);
				rs1.close();
				//stmt.close();
			}
			//rs1.close();
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally
		} // end try
		System.out.println("Goodbye.");
	}
	
	public static void sende(String sup_email,int item_id,String item_name,Double eoq) {
		 String host = "smtp.gmail.com";
		 final String user="deepitaggarwal@gmail.com"; 
		 final String password="deepit1234";//change accordingly  

		 String to = sup_email;//change accordingly
		 //Get the session object
		 Properties props = new Properties();
		 props.put("mail.smtp.host", host);
		 props.put("mail.smtp.auth", true);
		 props.put("mail.smtp.starttls.enable", true);
		 props.put("mail.smtp.port", 587); 

		 Session session = Session.getDefaultInstance(props,  
		 new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		 return new PasswordAuthentication(user,password);  
		    }  
		 });  

		 //Compose the message  
		 try {  
		  MimeMessage message = new MimeMessage(session);  
		  message.setFrom(new InternetAddress(user));  
		  message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		  message.setSubject("Placing an order");  
		  message.setText("We are here by placing an order for the quantity equivalent to "+eoq+"for item id:-"+item_id+"and item name:-"+item_name);  

		 //send the message  
		  Transport.send(message);  

		  System.out.println("message sent successfully...");  

		  } catch (MessagingException e) {e.printStackTrace();}  
		 }  

}
