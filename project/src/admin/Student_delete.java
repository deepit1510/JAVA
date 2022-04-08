package admin;
import project.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Student_delete {

	private JFrame frame;
	private JTextField admin_no1;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/project";
	static final String USER = "root";
	static final String PASS = "";
	static int admin_no;

	/**
	 * Launch the application.
	 */
	public static void student_delete() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_delete window = new Student_delete();
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
	public Student_delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 336);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblStudentRecord = new JLabel("---- Enter the Details to Delete ----");
		lblStudentRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRecord.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblStudentRecord.setForeground(Color.WHITE);
		lblStudentRecord.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblStudentRecord);

		JLabel lblEnterTheRoll = new JLabel("ADMISSION NUMBER");
		lblEnterTheRoll.setForeground(Color.WHITE);
		lblEnterTheRoll.setBounds(36, 80, 128, 14);
		frame.getContentPane().add(lblEnterTheRoll);

		admin_no1 = new JTextField();
		admin_no1.setForeground(new Color(128, 0, 0));
		admin_no1.setBackground(Color.LIGHT_GRAY);
		admin_no1.setBounds(269, 77, 115, 20);
		frame.getContentPane().add(admin_no1);
		admin_no1.setColumns(10);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				Statement stmt = null;

				admin_no = Integer.parseInt(admin_no1.getText());

				try {

					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					stmt = conn.createStatement();
					System.out.println("Connection is created successfully:");

					String sql;
					sql = "DELETE FROM students WHERE admiss_no =" + admin_no;
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "RECORD DELETE");
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.absolute(1)) {
						JOptionPane.showMessageDialog(null, "RECORD DELETE");
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Admission Number !!!!");
					}
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e) {
					// Handle errors for Class.forName
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(25, 263, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_admin_menu.student_admin_menu();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(124, 263, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.login();
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setBounds(223, 263, 89, 23);
		frame.getContentPane().add(btnLogin);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBounds(322, 263, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}