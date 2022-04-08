import frames.*;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Main_login extends frame_2 {

	private JFrame frame;
	private JTextField usr;
	private JPasswordField pswd;
	private JTextField mail;

	public static int rnd;
	public static String phone;
	public static String year;

	// frame_2 frame2 = new frame_2();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";
	private JTextField ot;
	private JPasswordField pswdf;
	private JPasswordField rpswdf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_login window = new Main_login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_login() {
		initialize();
	}
	private void makeFrameFullSize(JFrame aFrame) {
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		 aFrame.setSize(screenSize.width, screenSize.height);
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		//frame.setBounds(100, 100, 1259, 752);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblInve = new JLabel("INVENTORY CONTROL MANAGEMENT SYSTEM");
		lblInve.setForeground(Color.WHITE);
		lblInve.setHorizontalAlignment(SwingConstants.CENTER);
		lblInve.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 34));
		lblInve.setBounds(12, 13, 1878, 42);
		frame.getContentPane().add(lblInve);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.LIGHT_GRAY);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblLogin.setBounds(256, 150, 91, 48);
		frame.getContentPane().add(lblLogin);

		JLabel lblUserName = new JLabel("USER NAME:");
		lblUserName.setForeground(Color.GRAY);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserName.setBounds(141, 279, 127, 25);
		frame.getContentPane().add(lblUserName);

		usr = new JTextField();
		usr.setBounds(349, 270, 177, 48);
		frame.getContentPane().add(usr);
		usr.setColumns(10);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(141, 357, 126, 25);
		frame.getContentPane().add(lblPassword);

		pswd = new JPasswordField();
		pswd.setBounds(349, 347, 177, 50);
		frame.getContentPane().add(pswd);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(155, 455, 350, 127);
		frame.getContentPane().add(textArea);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = usr.getText();
				char[] pass = pswd.getPassword();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < pass.length; i++) {
					sb.append(pass[i]);
				}
				String str = sb.toString();
				Connection conn = null;
				Statement stmt = null;
				if (user.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Username  cannot be empty");
				} else if (str.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Password cannot be empty");
				} else {
					try {

						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Connecting to database...");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);
						System.out.println("Creating statement...");
						stmt = conn.createStatement();
						String sql;
						sql = "SELECT pswd FROM login where usr='" + user + "'";
						ResultSet rs = stmt.executeQuery(sql);
						if (rs.next()) {

							String pswrd = rs.getString("pswd");
							System.out.println("Login1" + pswrd);

							System.out.println(str);
							if (pswrd.equals(str)) {
								System.out.println("Login successfull");
								frame_2 frame2 = new frame_2();
								frame2.setVisible(true);

							} else {
								String z = "Password is incorrect";
								textArea.setText(z);
							}

							rs.close();
							stmt.close();
							conn.close();
						} else {
							JOptionPane.showMessageDialog(null, "Username does not exist");
						}
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
			}

		});
		btnLogin.setBounds(174, 639, 127, 33);
		frame.getContentPane().add(btnLogin);

		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnReset.setBounds(352, 639, 127, 33);
		frame.getContentPane().add(btnReset);

		JLabel lblName = new JLabel("E-mail");
		lblName.setForeground(Color.LIGHT_GRAY);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblName.setBounds(1226, 240, 86, 25);
		frame.getContentPane().add(lblName);

		mail = new JTextField();
		mail.setBounds(1447, 238, 148, 35);
		frame.getContentPane().add(mail);
		mail.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Password");
		lblPhoneNumber.setForeground(Color.LIGHT_GRAY);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPhoneNumber.setBounds(1226, 305, 108, 25);
		frame.getContentPane().add(lblPhoneNumber);

		JLabel lblYearOfBirth = new JLabel("Re-enter Password");
		lblYearOfBirth.setForeground(Color.LIGHT_GRAY);
		lblYearOfBirth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblYearOfBirth.setBounds(1226, 357, 209, 25);
		frame.getContentPane().add(lblYearOfBirth);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(1261, 517, 308, 105);
		frame.getContentPane().add(textArea_1);

		JLabel lblNewUser = new JLabel("New User?");
		lblNewUser.setForeground(Color.LIGHT_GRAY);
		lblNewUser.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblNewUser.setBounds(1359, 158, 126, 33);
		frame.getContentPane().add(lblNewUser);

		JButton btnNewUser = new JButton("Create User");
		btnNewUser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int otp = Integer.parseInt(ot.getText());
				String email = mail.getText();
				char[] pswd = pswdf.getPassword();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < pswd.length; i++) {
					sb.append(pswd[i]);
				}
				String password = sb.toString();
				Connection conn = null;
				Statement stmt = null;
				try {

					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					stmt = conn.createStatement();
					System.out.println("Connection is created successfully:");
					String sql;
					String sql1;
					if (otp == rnd) {
						sql1 = "Select * from login where usr='" + email + "'";
						ResultSet rs = stmt.executeQuery(sql1);
						if (rs.next()) {
							JOptionPane.showMessageDialog(null, "Username  exist");
							// textField_1.setText(x);
						} else {
							sql = "insert into login(Usr, pswd) values('" + email + "','" + password + "')";
							stmt.executeUpdate(sql);
							System.out.println("Record is inserted in the table successfully..................");
							String z = "User name :-" + email + "\n Password :-" + password;
							JOptionPane.showMessageDialog(null, z);
							sende1(email,password);
							Main_login login = new Main_login();
							login.setVisible(true);
						}
						rs.close();
						stmt.close();
						conn.close();
					} else {
						JOptionPane.showMessageDialog(null, "OTP Incorrect");
					}

				}

				catch (SQLException excep) {
					excep.printStackTrace();
				} catch (Exception excep) {
					excep.printStackTrace();
				} finally {
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

			}

		});
		btnNewUser.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		btnNewUser.setBounds(1347, 659, 148, 29);
		frame.getContentPane().add(btnNewUser);

		JLabel lblNewLabel = new JLabel("OTP");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(1226, 461, 56, 16);
		frame.getContentPane().add(lblNewLabel);

		ot = new JTextField();
		ot.setBounds(1447, 455, 148, 35);
		frame.getContentPane().add(ot);
		ot.setColumns(10);

		JButton btnNewButton = new JButton("Send OTP ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = mail.getText();
				char[] pswd = pswdf.getPassword();
				char[] rpswd = rpswdf.getPassword();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < pswd.length; i++) {
					sb.append(pswd[i]);
				}
				String password = sb.toString();
				StringBuffer sb1 = new StringBuffer();
				for (int i = 0; i < rpswd.length; i++) {
					sb1.append(rpswd[i]);
				}
				String rpassword = sb1.toString();
				if (email.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email field cannot be empty");
				} else if (password.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Password field cannot be empty");
				} else if (rpassword.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Re-enter password field cannot be empty");
				} else {
					if (password.equals(rpassword)) {

						Random rand = new Random();
						int random = rand.nextInt((9999 - 100) + 1) + 10;
						rnd = random;
						sende(email, random);
						JOptionPane.showMessageDialog(null, "OTP send to the mail");
					} else {
						JOptionPane.showMessageDialog(null, "Password and Re-entered password are not same");
						// actionPerformed(rand);

					}
				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnNewButton.setBounds(1467, 417, 157, 25);
		frame.getContentPane().add(btnNewButton);

		pswdf = new JPasswordField();
		pswdf.setBounds(1447, 303, 148, 35);
		frame.getContentPane().add(pswdf);

		rpswdf = new JPasswordField();
		rpswdf.setBounds(1447, 355, 148, 35);
		frame.getContentPane().add(rpswdf);

	}

	public static void sende(String email, int rand) {
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
			message.setSubject("OTP");
			message.setText("Your one time password for the varification of the e-mail is " + rand);

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void sende1(String email, String pswd) {
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
			message.setText("Your login details are as follows:- \n Username is " + email+"\n Password is "+pswd);

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
