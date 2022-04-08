package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionEvent;

public class new_user extends JFrame {

	private JPanel contentPane;
	private JTextField mail;
	private JPasswordField pswdf;
	private JPasswordField rpswdf;
	private JTextField ot;
	public static int rnd;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_user frame = new new_user();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void makeFrameFullSize(JFrame aFrame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setSize(screenSize.width, screenSize.height);
	}

	/**
	 * Create the frame.
	 */
	public new_user() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 703, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("E-mail");
		lblName.setForeground(Color.LIGHT_GRAY);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblName.setBounds(1032, 294, 86, 25);
		contentPane.add(lblName);

		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(1331, 292, 148, 35);
		contentPane.add(mail);

		JLabel lblPhoneNumber = new JLabel("Password");
		lblPhoneNumber.setForeground(Color.LIGHT_GRAY);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblPhoneNumber.setBounds(1030, 367, 108, 25);
		contentPane.add(lblPhoneNumber);

		pswdf = new JPasswordField();
		pswdf.setBounds(1331, 365, 148, 35);
		contentPane.add(pswdf);

		JLabel lblYearOfBirth = new JLabel("Re-enter Password");
		lblYearOfBirth.setForeground(Color.LIGHT_GRAY);
		lblYearOfBirth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblYearOfBirth.setBounds(1030, 423, 209, 25);
		contentPane.add(lblYearOfBirth);

		rpswdf = new JPasswordField();
		rpswdf.setBounds(1331, 431, 148, 35);
		contentPane.add(rpswdf);

		JButton btnNewButton = new JButton("Send OTP ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton.setBounds(1368, 501, 157, 25);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("OTP");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(1034, 565, 56, 16);
		contentPane.add(lblNewLabel);

		ot = new JTextField();
		ot.setColumns(10);
		ot.setBounds(1331, 559, 148, 35);
		contentPane.add(ot);

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
							new_user login = new new_user();
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
		btnNewUser.setBounds(1175, 720, 173, 35);
		contentPane.add(btnNewUser);

		JLabel lblNewUser = new JLabel("New User?");
		lblNewUser.setForeground(Color.LIGHT_GRAY);
		lblNewUser.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lblNewUser.setBounds(1252, 183, 126, 33);
		contentPane.add(lblNewUser);

		JLabel lblInventoryControl = new JLabel("INVENTORY CONTROL ");
		lblInventoryControl.setForeground(Color.WHITE);
		lblInventoryControl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblInventoryControl.setBounds(52, 336, 371, 39);
		contentPane.add(lblInventoryControl);

		JLabel lblManagementSystem = new JLabel("MANAGEMENT SYSTEM ");
		lblManagementSystem.setForeground(Color.WHITE);
		lblManagementSystem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblManagementSystem.setBounds(133, 411, 384, 39);
		contentPane.add(lblManagementSystem);
		
		JButton btnNewButton_1 = new JButton("Login Page");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(624, 718, 186, 39);
		contentPane.add(btnNewButton_1);
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
			message.setText("Your login details are as follows:- \n Username is " + email + "\n Password is " + pswd);

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
