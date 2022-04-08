package student;

import net.proteanit.sql.DbUtils;
import project.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;



public class Student_login_search_view extends JFrame {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/project";
	static final String USER = "root";
	static final String PASS = "";
	
	private JPanel contentPane;
	private JTable table;
	static String admiss_no;

	/**
	 * Launch the application.
	 */
	public static void student_login_search_view(String admiss_no) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_login_search_view frame = new Student_login_search_view(admiss_no);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Student_login_search_view(String admiss_no) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Display");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
					final String DB_URL = "jdbc:mysql://localhost/project";
					final String USER = "root";
					final String PASS = "";
					Connection conn = null;
					Statement stmt = null;

					Class.forName("com.mysql.jdbc.Driver");
					JOptionPane.showMessageDialog(null, "Connecting to database...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					JOptionPane.showMessageDialog(null, "Creating statement...");
					stmt = conn.createStatement();
					String sql;
					sql = "SELECT * FROM students where admiss_no = " + admiss_no;
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));

					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(195, 72, 97, 25);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 0, 128));
		scrollPane.setBounds(12, 108, 462, 242);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnMainMenu = new JButton("LOGIN");
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setBackground(Color.DARK_GRAY);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.login();
			}
		});
		btnMainMenu.setBounds(377, 72, 97, 25);
		contentPane.add(btnMainMenu);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_login.student_login();
			}
		});
		btnBack.setBounds(12, 72, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblStudentsRecord = new JLabel("---- Student's Records ----");
		lblStudentsRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentsRecord.setForeground(Color.WHITE);
		lblStudentsRecord.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblStudentsRecord.setBounds(12, 11, 462, 50);
		contentPane.add(lblStudentsRecord);
	}
}