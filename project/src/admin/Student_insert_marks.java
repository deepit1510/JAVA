package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Student_insert_marks extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/project";
	static final String USER = "root";
	static final String PASS = "";
static int count;
	private JPanel contentPane;
	private JTextField english1;
	private JTextField hindi1;
	private JTextField maths1;
	private JTextField sst1;
	private JTextField science1;
	Connection conn1;
	static String session;
	static String section;
	static String admin_no;
	static String roll_no;
	static String name;
	static String gender;
	static String dob;
	static String fname;
	static String address;
	static String phn;
	static String email;
	static String t_id;
	static String remark;
	static int per;
	static String english, hindi, maths, sst, science;

	/**
	 * Launch the application.
	 */
	public static void student_insert_marks(int admiss_no) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_insert_marks frame = new Student_insert_marks(session, section, admin_no, roll_no, name,
							dob, fname, address, phn, email, t_id, gender);
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
	public Student_insert_marks(String session, String section, String admin_no, String roll_no, String name,
			String dob, String fname, String address, String phn, String email, String t_id, String gender) {
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStudentMarks = new JLabel("---- Enter The Marks Of Student ----");
		lblStudentMarks.setForeground(Color.WHITE);
		lblStudentMarks.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentMarks.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblStudentMarks.setBounds(10, 11, 414, 40);
		contentPane.add(lblStudentMarks);

		JLabel lblEnglish = new JLabel("ENGLISH");
		lblEnglish.setForeground(Color.WHITE);
		lblEnglish.setBounds(30, 76, 62, 14);
		contentPane.add(lblEnglish);

		JLabel lblHindi = new JLabel("HINDI");
		lblHindi.setForeground(Color.WHITE);
		lblHindi.setBounds(30, 107, 62, 14);
		contentPane.add(lblHindi);

		JLabel lblMaths = new JLabel("MATHS");
		lblMaths.setForeground(Color.WHITE);
		lblMaths.setBounds(30, 138, 62, 14);
		contentPane.add(lblMaths);

		JLabel lblSocialScience = new JLabel("SOCIAL SCIENCE");
		lblSocialScience.setForeground(Color.WHITE);
		lblSocialScience.setBounds(30, 169, 99, 14);
		contentPane.add(lblSocialScience);

		JLabel lblScience = new JLabel("SCIENCE");
		lblScience.setForeground(Color.WHITE);
		lblScience.setBounds(30, 200, 62, 14);
		contentPane.add(lblScience);

		english1 = new JTextField();
		english1.setFont(new Font("Tahoma", Font.BOLD, 11));
		english1.setForeground(new Color(128, 0, 0));
		english1.setBackground(Color.LIGHT_GRAY);
		english1.setBounds(324, 73, 86, 20);
		contentPane.add(english1);
		english1.setColumns(10);

		hindi1 = new JTextField();
		hindi1.setFont(new Font("Tahoma", Font.BOLD, 11));
		hindi1.setForeground(new Color(128, 0, 0));
		hindi1.setBackground(Color.LIGHT_GRAY);
		hindi1.setBounds(324, 104, 86, 20);
		contentPane.add(hindi1);
		hindi1.setColumns(10);

		maths1 = new JTextField();
		maths1.setFont(new Font("Tahoma", Font.BOLD, 11));
		maths1.setForeground(new Color(128, 0, 0));
		maths1.setBackground(Color.LIGHT_GRAY);
		maths1.setBounds(324, 135, 86, 20);
		contentPane.add(maths1);
		maths1.setColumns(10);

		sst1 = new JTextField();
		sst1.setFont(new Font("Tahoma", Font.BOLD, 11));
		sst1.setForeground(new Color(128, 0, 0));
		sst1.setBackground(Color.LIGHT_GRAY);
		sst1.setBounds(324, 166, 86, 20);
		contentPane.add(sst1);
		sst1.setColumns(10);

		science1 = new JTextField();
		science1.setFont(new Font("Tahoma", Font.BOLD, 11));
		science1.setForeground(new Color(128, 0, 0));
		science1.setBackground(Color.LIGHT_GRAY);
		science1.setBounds(324, 197, 86, 20);
		contentPane.add(science1);
		science1.setColumns(10);

		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count=0;
				Connection conn = null;
				Statement stmt = null;
				Statement stmt1 = null;
				english = english1.getText();
				hindi = hindi1.getText();
				maths = maths1.getText();
				sst = sst1.getText();
				science = science1.getText();

				if (!english.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Marks must be the Numbers...");
					count+=1;
				}
				if (!english.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Marks must be the Numbers...");
					count+=1;
				} 
				if (!hindi.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Marks must be the Numbers...");
					count+=1;
				} 
				if (!maths.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Marks must be the Numbers...");
					count+=1;
				} 
				if (!sst.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Marks must be the Numbers...");
					count+=1;
				}
				if (!science.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Marks must be the Numbers...");
					count+=1;
				}
				if(count == 0){
				int ph1 = Integer.parseInt(phn);
				int admiss_no1 = Integer.parseInt(admin_no);
				int roll_no1 = Integer.parseInt(roll_no);
				int t_id1 = Integer.parseInt(t_id);
				int english1 = Integer.parseInt(english);
				int hindi1 = Integer.parseInt(hindi);
				int maths1 = Integer.parseInt(maths);
				int sst1 = Integer.parseInt(sst);
				int science1 = Integer.parseInt(science);

				per = ((english1 + hindi1 + maths1 + sst1 + science1) / 5);
				if (per >= 33)
					remark = "PASS";
				else
					remark = "FAIL";

				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
					conn1 = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
					stmt = (Statement) conn.createStatement();
					stmt1= (Statement) conn1.createStatement();
					

					System.out.println("Connection is created successfully: ");
					String sql, sql1;

					sql = "insert into students values('" + session + "','" + section + "'," + admiss_no1 + ","
							+ roll_no1 + ",'" + name + "','" + gender + "','" + dob + "', '" + fname + "','" + address
							+ "', " + ph1 + ", '" + email + "','" + t_id1 + "'," + per + ",'" + remark + "')";
					stmt.executeUpdate(sql);
					sql1 = "insert into marks values(" + admiss_no1 + "," + english1 + "," + hindi1 + "," + maths1 + ","
							+ sst1 + "," + science1 + ")";
					stmt1.executeUpdate(sql1);

				} catch (SQLException excep) {
					excep.printStackTrace();
				} catch (Exception excep) {
					excep.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							conn.close();
						conn1.close();
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
		submit.setBounds(24, 263, 89, 23);
		contentPane.add(submit);

		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_admin_menu.student_admin_menu();
			}
		});
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.BOLD, 11));
		back.setBackground(Color.DARK_GRAY);
		back.setBounds(222, 263, 89, 23);
		contentPane.add(back);

		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Tahoma", Font.BOLD, 11));
		exit.setBackground(Color.DARK_GRAY);
		exit.setBounds(321, 263, 89, 23);
		contentPane.add(exit);

		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset.setText("");
			}
		});
		reset.setForeground(Color.WHITE);
		reset.setFont(new Font("Tahoma", Font.BOLD, 11));
		reset.setBackground(Color.DARK_GRAY);
		reset.setBounds(123, 263, 89, 23);
		contentPane.add(reset);
	}
}