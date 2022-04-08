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

public class Teacher_update {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/project";
	static final String USER = "root";
	static final String PASS = "";

	private JFrame frame;
	private JTextField t_id1;
	static String t_id;

	/**
	 * Launch the application.
	 */
	public static void teacher_update() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_update window = new Teacher_update();
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
	public Teacher_update() {
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

		JLabel lblStudentRecord = new JLabel("---- Enter the Details to Update ----");
		lblStudentRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRecord.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblStudentRecord.setForeground(Color.WHITE);
		lblStudentRecord.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblStudentRecord);

		JLabel lblEnterTheRoll = new JLabel("TEACHER ID");
		lblEnterTheRoll.setForeground(Color.WHITE);
		lblEnterTheRoll.setBounds(36, 80, 128, 14);
		frame.getContentPane().add(lblEnterTheRoll);

		t_id1 = new JTextField();
		t_id1.setForeground(new Color(128, 0, 0));
		t_id1.setBackground(Color.LIGHT_GRAY);
		t_id1.setBounds(269, 77, 115, 20);
		frame.getContentPane().add(t_id1);
		t_id1.setColumns(10);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				Statement stmt = null;
				// admiss_no = Integer.parseInt(admiss_no1.getText());
				t_id = t_id1.getText();
				if (!t_id.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Admission Number must be a Number...");

				} else {
					try {
						int t_id1 = Integer.parseInt(t_id);
						Class.forName("com.mysql.jdbc.Driver");
						conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
						stmt = (Statement) conn.createStatement();

						System.out.println("Connection is created successfully: ");
						String sql;
						sql = "select teacher_id from teachers where teacher_id = " + t_id1;
						ResultSet rs = stmt.executeQuery(sql);
						if (rs.absolute(1)) {
							Teacher_update_details.teacher_update_details(t_id);
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
