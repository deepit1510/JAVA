package Login;

import java.sql.*;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class new_user {
	static String name;
	static String no;
	static String year;
	static String pass;
	static int rnd;

	static Scanner input;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	public void new_usr() {

		input = new Scanner(System.in);
		System.out.println("!!--------New User--------!!");
		System.out.println("Enter your email id");
		String email = input.next();
		System.out.println("Enter your passowrd");
		String password = input.next();
		System.out.println("Renter your passowrd");
		String rpassword = input.next();

		if (email.trim().isEmpty()) {
			System.out.println("Username  cannot be empty");
		} else if (password.trim().isEmpty()) {
			System.out.println("Password cannot be empty");
		} else if (rpassword.trim().isEmpty()) {
			System.out.println("Re-enter password field cannot be empty");
		} else {
			if (!password.equals(rpassword)) {
				System.out.println("Password and Re-entered password are not same");
				// actionPerformed(rand);

			} else if (password.equals(rpassword)) {

				Random rand = new Random();
				int random = rand.nextInt((9999 - 100) + 1) + 10;
				rnd = random;
				sende(email, random);
				System.out.println("OTP send to the mail");
				System.out.println("Enter the OTP");
				int otp = input.nextInt();
				Connection conn1 = null;
				Statement stmt1 = null;
				try {

					Class.forName("com.mysql.jdbc.Driver");
					conn1 = DriverManager.getConnection(DB_URL, USER, PASS);

					stmt1 = conn1.createStatement();
					System.out.println("Connection is created successfully:");
					String sql;
					String sql1;
					if (otp == rnd) {
						sql1 = "Select * from login where usr='" + email + "'";
						ResultSet rs = stmt1.executeQuery(sql1);
						if (rs.next()) {
							System.out.println("Username  exist");
							check check = new check();
							Login.check.check();

							// textField_1.setText(x);
						} else {
							sql = "insert into login(Usr, pswd) values('" + email + "','" + password + "')";
							stmt1.executeUpdate(sql);
							System.out.println("Record is inserted in the table successfully..................");
							String z = "User name :-" + email + "\n Password :-" + password;
							System.out.println(z);
							sende1(email, password);
							check check = new check();
							Login.check.check();
						}
						rs.close();
						stmt1.close();
						conn1.close();
					} else {
						JOptionPane.showMessageDialog(null, "OTP Incorrect");
					}

				} catch (SQLException excep) {
					excep.printStackTrace();
				} catch (Exception excep) {
					excep.printStackTrace();
				} finally {
					try {
						if (stmt1 != null)
							conn1.close();
					} catch (SQLException se) {
					}
					try {
						if (conn1 != null)
							conn1.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}

			}
		}
	}

	public static int sende(String email, int rand) {
		String host = "smtp.gmail.com";
		final String user = "deepitaggarwal@gmail.com";
		final String password = "deepit1234";// change accordingly
		System.out.println("Generating OTP");
		String to = email;// change accordingly
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.port", 587);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("OTP for LOGIN");
			message.setText("Your one time password for the varification of the e-mail is " + rand);

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int sende1(String email, String pswd) {
		String host = "smtp.gmail.com";
		final String user = "deepitaggarwal@gmail.com";
		final String password = "deepit1234";// change accordingly

		String to = email;// change accordingly
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.port", 587);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Login details");
			message.setText("Your login details are as follows:- \n Username is " + email + "\n Password is " + pswd);

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
