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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class Teacher_update_details extends JFrame {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/project";
	static final String USER = "root";
	static final String PASS = "";

	private JPanel contentPane;
	private JTextField quali1;
	private JTextField name1;
	private JTextField dob1;
	private JTextField email1;
	private JTextField phn1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField sub_id1;

	static String t_id;
	static String name;
	static String dob;
	static String gender;
	static String quali;
	static String phn;
	static String address;
	static String email;
	static String sub_id;

	/**
	 * Launch the application.
	 */
	public static void teacher_update_details(String t_id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_update_details frame = new Teacher_update_details(t_id);
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
	public Teacher_update_details(String t_id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterTheDetails = new JLabel("-- Enter The Personal Details Of Teacher --");
		lblEnterTheDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheDetails.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblEnterTheDetails.setBackground(Color.WHITE);
		lblEnterTheDetails.setForeground(Color.WHITE);
		lblEnterTheDetails.setBounds(10, 11, 414, 40);
		contentPane.add(lblEnterTheDetails);

		JLabel lblLabel1 = new JLabel("SUBJECT ' S ID");
		lblLabel1.setBackground(Color.WHITE);
		lblLabel1.setForeground(Color.WHITE);
		lblLabel1.setBounds(20, 353, 115, 14);
		contentPane.add(lblLabel1);

		JLabel lblLabel2 = new JLabel("QUALIFICATION");
		lblLabel2.setForeground(Color.WHITE);
		lblLabel2.setBounds(20, 189, 115, 14);
		contentPane.add(lblLabel2);

		JLabel lblLabel4 = new JLabel("DATE OF BIRTH ( DD - MM - YYYY)");
		lblLabel4.setForeground(Color.WHITE);
		lblLabel4.setBounds(20, 127, 206, 14);
		contentPane.add(lblLabel4);

		quali1 = new JTextField();
		quali1.setFont(new Font("Tahoma", Font.BOLD, 11));
		quali1.setForeground(new Color(128, 0, 0));
		quali1.setBackground(Color.LIGHT_GRAY);
		quali1.setBounds(260, 186, 150, 20);
		contentPane.add(quali1);
		quali1.setColumns(10);

		name1 = new JTextField();
		name1.setFont(new Font("Tahoma", Font.BOLD, 11));
		name1.setForeground(new Color(128, 0, 0));
		name1.setBackground(Color.LIGHT_GRAY);
		name1.setBounds(260, 93, 150, 20);
		contentPane.add(name1);
		name1.setColumns(10);

		dob1 = new JTextField();
		dob1.setFont(new Font("Tahoma", Font.BOLD, 11));
		dob1.setForeground(new Color(128, 0, 0));
		dob1.setBackground(Color.LIGHT_GRAY);
		dob1.setBounds(260, 124, 150, 20);
		contentPane.add(dob1);
		dob1.setColumns(10);

		JLabel lblNewLabel = new JLabel("GENDER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 159, 64, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("PHONE NUMBER ( +91 )");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(20, 220, 131, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("ADDRESS");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(20, 253, 64, 14);
		contentPane.add(lblNewLabel_4);

		JTextArea address1 = new JTextArea();
		address1.setFont(new Font("Tahoma", Font.BOLD, 11));
		address1.setForeground(new Color(128, 0, 0));
		address1.setWrapStyleWord(true);
		address1.setLineWrap(true);
		address1.setBackground(Color.LIGHT_GRAY);
		address1.setBounds(260, 248, 150, 60);
		contentPane.add(address1);

		JLabel lblTeacherId = new JLabel("E - MAIL ID");
		lblTeacherId.setForeground(Color.WHITE);
		lblTeacherId.setBounds(20, 322, 80, 14);
		contentPane.add(lblTeacherId);

		email1 = new JTextField();
		email1.setFont(new Font("Tahoma", Font.BOLD, 11));
		email1.setForeground(new Color(128, 0, 0));
		email1.setBackground(Color.LIGHT_GRAY);
		email1.setBounds(260, 319, 150, 20);
		contentPane.add(email1);
		email1.setColumns(10);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("MALE");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()){
					gender = "Male";
				}
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setForeground(new Color(51, 0, 102));
		rdbtnNewRadioButton.setBounds(260, 155, 74, 23);
		contentPane.add(rdbtnNewRadioButton);

		JLabel lblSemester = new JLabel("SESSION");
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setBounds(10, 372, 46, -41);
		contentPane.add(lblSemester);

		JLabel lblSessionYear = new JLabel("FULL NAME");
		lblSessionYear.setBackground(Color.WHITE);
		lblSessionYear.setForeground(Color.WHITE);
		lblSessionYear.setBounds(20, 96, 115, 14);
		contentPane.add(lblSessionYear);

		JRadioButton rdbtnFemale = new JRadioButton("FEMALE");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFemale.isSelected()){
					gender = "Female";
				}
			}
		});
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnFemale.setForeground(new Color(51, 0, 102));
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemale.setBackground(Color.LIGHT_GRAY);
		rdbtnFemale.setBounds(336, 155, 74, 23);
		contentPane.add(rdbtnFemale);

		phn1 = new JTextField();
		phn1.setFont(new Font("Tahoma", Font.BOLD, 11));
		phn1.setForeground(new Color(128, 0, 0));
		phn1.setBackground(Color.LIGHT_GRAY);
		phn1.setBounds(260, 217, 150, 20);
		contentPane.add(phn1);
		phn1.setColumns(10);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;

				name = name1.getText();
				dob = dob1.getText();
				quali = quali1.getText();
				phn = phn1.getText();
				address = address1.getText();
				email = email1.getText();
				sub_id = sub_id1.getText();

				if (!phn.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Phone Number must be a Number...");
				} else if (phn.length() > 10 && phn.length() < 10) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Phone Number must be of 10 Digits...");
				} else if (!t_id.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Teacher I.D. must be a Number...");
				} else if (!sub_id.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Subject I.D. must be a Number...");
				} else if (!name.matches("[a-zA-Z]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Name must be a Character...");
				} else {
					int t_id1 = Integer.parseInt(t_id);
					int phn1 = Integer.parseInt(phn);
					int sub_id1 = Integer.parseInt(sub_id);

					try {
						Class.forName("com.mysql.jdbc.Driver");
						conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
						stmt = (Statement) conn.createStatement();
						System.out.println("Connection is created successfully: ");
						String sql;

						sql = "update into teachers set(" + t_id1 + ",'" + name + "','" + dob + "','" + gender
								+ "','" + quali + "', " + phn1 + ", '" + address + "','" + email + "'," + sub_id1 + ")";
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "RECORD UPDATED");
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
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(24, 394, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacher_update_details(t_id);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(123, 394, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnLogin = new JButton("BACK");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher_admin_menu.teacher_admin_menu();
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(222, 394, 89, 23);
		contentPane.add(btnLogin);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(321, 394, 89, 23);
		contentPane.add(btnExit);

		sub_id1 = new JTextField();
		sub_id1.setForeground(new Color(128, 0, 0));
		sub_id1.setFont(new Font("Tahoma", Font.BOLD, 11));
		sub_id1.setColumns(10);
		sub_id1.setBackground(Color.LIGHT_GRAY);
		sub_id1.setBounds(260, 350, 150, 20);
		contentPane.add(sub_id1);
	}
}