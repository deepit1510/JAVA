package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import supplier.supplier_main_page;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usr;
	private JPasswordField pswd;
	static int id;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/new_system";
	static final String USER = "root";
	static final String PASS = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(1197, 159, 422, 33);
		lblLogin.setForeground(Color.LIGHT_GRAY);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		contentPane.add(lblLogin);

		JLabel lblUserName = new JLabel("USER NAME:");
		lblUserName.setForeground(Color.LIGHT_GRAY);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUserName.setBounds(1139, 321, 127, 25);
		contentPane.add(lblUserName);

		usr = new JTextField();
		usr.setColumns(10);
		usr.setBounds(1361, 312, 177, 48);
		contentPane.add(usr);

		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(1140, 445, 126, 25);
		contentPane.add(lblPassword);

		pswd = new JPasswordField();
		pswd.setBounds(1361, 435, 177, 50);
		contentPane.add(pswd);

		JButton btnLogin = new JButton("LOGIN");
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
						sql = "SELECT pswd,type FROM login where usr='" + user + "'";
						ResultSet rs = stmt.executeQuery(sql);
						if (rs.next()) {
							String pswrd = rs.getString("pswd");
							String type = rs.getString("type");
							System.out.println("Login1" + pswrd);

							System.out.println(str);
							if (pswrd.equals(str)) {
								if(type.equals("admin")) {
								System.out.println("Login successfull");
								admin_main_page frame1 = new admin_main_page();
								frame1.setVisible(true);
								}
								else if(type.equals("supplier")) {
									System.out.println("Login successfull");
									String sql1 = "Select sup_id from supplier where sup_email = '"+user+"'";
									ResultSet rs1 = stmt.executeQuery(sql1);
									if(rs1.next()) {
										id = rs1.getInt("sup_id");
									}
								supplier_main_page frame2 = new supplier_main_page(id);
									frame2.setVisible(true);
								}
								else if(type.equals("customer")){
									System.out.println("Login successfull");
									String sql1 = "Select sup_id from customer where sup_email = '"+user+"'";
									ResultSet rs1 = stmt.executeQuery(sql1);
									if(rs1.next()) {
										id = rs1.getInt("customer_id");
									}
									customer_main_page frame2 = new customer_main_page(id);
									frame2.setVisible(true);
								}
								else if(type.equals("guest")){
									System.out.println("Login successfull");
									String sql1 = "Select sup_id from guest where sup_email = '"+user+"'";
									ResultSet rs1 = stmt.executeQuery(sql1);
									if(rs1.next()) {
										id = rs1.getInt("guest_id");
									}
									guest_main_page frame2 = new guest_main_page(id);
									frame2.setVisible(true);
								}

							} else {
								String z = "Password is incorrect";
								JOptionPane.showMessageDialog(null, z + "..................");
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
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnLogin.setBounds(1169, 604, 127, 33);
		contentPane.add(btnLogin);

		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnReset.setBounds(1455, 604, 127, 33);
		contentPane.add(btnReset);

		JLabel lblInventoryControl = new JLabel("INVENTORY CONTROL ");
		lblInventoryControl.setForeground(Color.WHITE);
		lblInventoryControl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblInventoryControl.setBounds(113, 276, 371, 39);
		contentPane.add(lblInventoryControl);

		JLabel lblManagementSystem = new JLabel("MANAGEMENT SYSTEM ");
		lblManagementSystem.setForeground(Color.WHITE);
		lblManagementSystem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblManagementSystem.setBounds(209, 366, 384, 39);
		contentPane.add(lblManagementSystem);

		JButton btnNewButton = new JButton("New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_user newu = new new_user();
				newu.setVisible(true);
			}
		});
		btnNewButton.setBounds(1683, 164, 133, 33);
		contentPane.add(btnNewButton);
	}
}
