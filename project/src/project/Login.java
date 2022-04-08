package project;

import student.*;
import teacher.*;
import admin.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login {

	private JFrame frame;
	private JPasswordField password;
	private JTextField username;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/project";
	static final String USER = "root";
	static final String PASS = "";

	/**
	 * Launch the application.
	 */
	public static void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 450, 336);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("RESET");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(176, 263, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usr = username.getText();
				String pswd = new String(password.getPassword());
				Connection conn = null;
				Statement stmt = null;
				Statement stmt1 = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					stmt = conn.createStatement();
					stmt1 = conn.createStatement();
					System.out.println("Connection is created successfully:");
					String sql1, sql2;

					sql1 = "Select dob from students where admiss_no = '" + usr + "'";
					ResultSet rs = stmt.executeQuery(sql1);

					sql2 = "Select dob from teachers where teacher_id = '" + usr + "'";
					ResultSet rs1 = stmt1.executeQuery(sql2);
					if (usr.equals("admin")) {
						if (pswd.equals("admin")) {
							Admin_login.admin_login();
						} else {
							JOptionPane.showMessageDialog(null, "Incorrect PASSWORD!!!, Please Try Again....");
						}
					} else if (rs.next()) {
						String dob = rs.getString("dob");
						if (dob.equals(pswd)) {
							Student_login student = new Student_login();
							student.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Incorrect PASSWORD!!!, Please Try Again....");
						}
					} else if (rs1.next()) {
						String dob = rs.getString("dob");
						if (dob.equals(pswd)) {
							Teacher_login teacher = new Teacher_login();
							teacher.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Incorrect PASSWORD!!!, Please Try Again....");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Username does not Exist!!!, Please Try Again....");
					}
					rs.close();
					stmt.close();
				} catch (SQLException excep) {
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
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(44, 263, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		password = new JPasswordField();
		password.setForeground(new Color(51, 0, 102));
		password.setBackground(Color.LIGHT_GRAY);
		password.setBounds(266, 114, 134, 20);
		frame.getContentPane().add(password);

		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(44, 86, 89, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(44, 117, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);

		username = new JTextField();
		username.setBackground(Color.LIGHT_GRAY);
		username.setForeground(new Color(51, 0, 102));
		username.setBounds(266, 83, 134, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);

		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(311, 263, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JLabel lblLogin = new JLabel("---- LOGIN ----");
		lblLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(10, 11, 414, 41);
		frame.getContentPane().add(lblLogin);
	}
}
