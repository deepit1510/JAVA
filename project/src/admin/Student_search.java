package admin;
import project.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Student_search {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/project";
	static final String USER = "root";
	static final String PASS = "";
	
	private JFrame frame;
	private JTextField admiss_no1;
	static String admiss_no;

	/**
	 * Launch the application.
	 */
	public static void student_search() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_search window = new Student_search();
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
	public Student_search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 336);
		frame.getContentPane().setLayout(null);

		JLabel lblStudentRecord = new JLabel("---- Enter the Details to Search ----");
		lblStudentRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRecord.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblStudentRecord.setForeground(Color.WHITE);
		lblStudentRecord.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblStudentRecord);

		JLabel lblEnterTheRoll = new JLabel("ADMISSION NUMBER");
		lblEnterTheRoll.setForeground(Color.WHITE);
		lblEnterTheRoll.setBounds(36, 80, 128, 14);
		frame.getContentPane().add(lblEnterTheRoll);

		admiss_no1 = new JTextField();
		admiss_no1.setForeground(new Color(128, 0, 0));
		admiss_no1.setBackground(Color.LIGHT_GRAY);
		admiss_no1.setBounds(269, 77, 115, 20);
		frame.getContentPane().add(admiss_no1);
		admiss_no1.setColumns(10);

		JButton submit = new JButton("SEARCH");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				Statement stmt = null;
				admiss_no = admiss_no1.getText();
				if (!admiss_no.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Admission Number must be a Number...");
				} else {
					try {
						int admiss_no1 = Integer.parseInt(admiss_no);
						Class.forName("com.mysql.jdbc.Driver");
						conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
						stmt = (Statement) conn.createStatement();

						System.out.println("Connection is created successfully: ");
						String sql;
						sql = "select admiss_no from students where admiss_no = " + admiss_no1;
						ResultSet rs = stmt.executeQuery(sql);
						if (rs.absolute(1)) {
							Student_search_view search = new Student_search_view(admiss_no);
							search.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Invalid Admission Number !!!!");
						}

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
			}
		});
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Tahoma", Font.BOLD, 11));
		submit.setBackground(Color.DARK_GRAY);
		submit.setBounds(25, 263, 89, 23);
		frame.getContentPane().add(submit);

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