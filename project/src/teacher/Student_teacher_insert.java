package teacher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.text.SimpleDateFormat;

public class Student_teacher_insert extends JFrame {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/project";
	static final String USER = "root";
	static final String PASS = "";

	private JPanel contentPane;
	private JTextField dob1;
	private JTextField admin_no1;
	private JTextField roll_no1;
	private JTextField fname1;
	private JTextField name1;
	private JTextField phn1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField email1;
	private JTextField sess1;
	private JTextField cls1;
	private JTextField teacher_id1;

	static String session;
	static String cls;
	static String admin_no;
	static String roll_no;
	static String name;
	static String gender;
	static String dob;
	static String date;
	static String fname;
	static String address;
	static String phn;
	static String email;
	static String teacher_id;

	/**
	 * Launch the application.
	 */
	public static void student_teacher_insert() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_teacher_insert frame = new Student_teacher_insert();
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
	public Student_teacher_insert() {
		setBounds(100, 100, 450, 549);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterTheDetails = new JLabel("-- Enter The Personal Details Of Student --");
		lblEnterTheDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheDetails.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblEnterTheDetails.setBackground(Color.WHITE);
		lblEnterTheDetails.setForeground(Color.WHITE);
		lblEnterTheDetails.setBounds(10, 11, 414, 40);
		contentPane.add(lblEnterTheDetails);

		JLabel lblLabel1 = new JLabel("SESSION YEAR ( YYYY - YYYY )");
		lblLabel1.setBackground(Color.WHITE);
		lblLabel1.setForeground(Color.WHITE);
		lblLabel1.setBounds(20, 65, 150, 14);
		contentPane.add(lblLabel1);

		JLabel lblLabel2 = new JLabel("ROLL NUMBER");
		lblLabel2.setForeground(Color.WHITE);
		lblLabel2.setBounds(20, 158, 115, 14);
		contentPane.add(lblLabel2);

		JLabel lblLabel4 = new JLabel("ADMISSION NUMBER");
		lblLabel4.setForeground(Color.WHITE);
		lblLabel4.setBounds(20, 127, 150, 14);
		contentPane.add(lblLabel4);

		dob1 = new JTextField();
		dob1.setFont(new Font("Tahoma", Font.BOLD, 11));
		dob1.setForeground(new Color(128, 0, 0));
		dob1.setBackground(Color.LIGHT_GRAY);
		dob1.setBounds(260, 248, 150, 20);
		contentPane.add(dob1);
		dob1.setColumns(10);

		admin_no1 = new JTextField();
		admin_no1.setFont(new Font("Tahoma", Font.BOLD, 11));
		admin_no1.setForeground(new Color(128, 0, 0));
		admin_no1.setBackground(Color.LIGHT_GRAY);
		admin_no1.setBounds(260, 124, 150, 20);
		contentPane.add(admin_no1);
		admin_no1.setColumns(10);

		roll_no1 = new JTextField();
		roll_no1.setFont(new Font("Tahoma", Font.BOLD, 11));
		roll_no1.setForeground(new Color(128, 0, 0));
		roll_no1.setBackground(Color.LIGHT_GRAY);
		roll_no1.setBounds(260, 155, 150, 20);
		contentPane.add(roll_no1);
		roll_no1.setColumns(10);

		fname1 = new JTextField();
		fname1.setFont(new Font("Tahoma", Font.BOLD, 11));
		fname1.setForeground(new Color(128, 0, 0));
		fname1.setBackground(Color.LIGHT_GRAY);
		fname1.setBounds(260, 279, 150, 20);
		contentPane.add(fname1);
		fname1.setColumns(10);

		JLabel lblNewLabel = new JLabel("FULL NAME");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 189, 115, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("GENDER");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(20, 221, 74, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DATE OF BIRTH ( DD - MM - YYYY )");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(20, 251, 190, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("ADDRESS");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(20, 315, 80, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("FATHER' S NAME");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(20, 282, 103, 14);
		contentPane.add(lblNewLabel_4);

		JTextArea address1 = new JTextArea();
		address1.setFont(new Font("Tahoma", Font.BOLD, 11));
		address1.setForeground(new Color(128, 0, 0));
		address1.setWrapStyleWord(true);
		address1.setLineWrap(true);
		address1.setBackground(Color.LIGHT_GRAY);
		address1.setBounds(260, 310, 150, 60);
		contentPane.add(address1);

		JLabel lblTeacherId = new JLabel("PHONE NUMBER ( + 91 )");
		lblTeacherId.setForeground(Color.WHITE);
		lblTeacherId.setBounds(20, 384, 133, 14);
		contentPane.add(lblTeacherId);

		name1 = new JTextField();
		name1.setFont(new Font("Tahoma", Font.BOLD, 11));
		name1.setForeground(new Color(128, 0, 0));
		name1.setBackground(Color.LIGHT_GRAY);
		name1.setBounds(260, 186, 150, 20);
		contentPane.add(name1);
		name1.setColumns(10);

		JRadioButton male1 = new JRadioButton("MALE");
		male1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gender = "Male";
			}
		});
		buttonGroup.add(male1);
		male1.setFont(new Font("Tahoma", Font.BOLD, 11));
		male1.setHorizontalAlignment(SwingConstants.CENTER);
		male1.setBackground(Color.LIGHT_GRAY);
		male1.setForeground(new Color(51, 0, 102));
		male1.setBounds(260, 217, 74, 23);
		contentPane.add(male1);

		JLabel lblSemester = new JLabel("SESSION");
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setBounds(10, 372, 46, -41);
		contentPane.add(lblSemester);

		JLabel lblSessionYear = new JLabel("CLASS");
		lblSessionYear.setBackground(Color.WHITE);
		lblSessionYear.setForeground(Color.WHITE);
		lblSessionYear.setBounds(20, 96, 115, 14);
		contentPane.add(lblSessionYear);

		JRadioButton female1 = new JRadioButton("FEMALE");
		female1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Female";
			}
		});
		buttonGroup.add(female1);
		female1.setFont(new Font("Tahoma", Font.BOLD, 11));
		female1.setForeground(new Color(51, 0, 102));
		female1.setHorizontalAlignment(SwingConstants.CENTER);
		female1.setBackground(Color.LIGHT_GRAY);
		female1.setBounds(336, 217, 74, 23);
		contentPane.add(female1);

		JLabel lblNewLabel_5 = new JLabel("TEACHER' S ID");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(20, 446, 115, 14);
		contentPane.add(lblNewLabel_5);

		phn1 = new JTextField();
		phn1.setFont(new Font("Tahoma", Font.BOLD, 11));
		phn1.setForeground(new Color(128, 0, 0));
		phn1.setBackground(Color.LIGHT_GRAY);
		phn1.setBounds(260, 381, 150, 20);
		contentPane.add(phn1);
		phn1.setColumns(10);

		JButton next = new JButton("NEXT");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				session = sess1.getText();
				cls = cls1.getText();
				admin_no = admin_no1.getText();
				roll_no = roll_no1.getText();
				name = name1.getText();
				dob = dob1.getText();
				fname = fname1.getText();
				address = address1.getText();
				phn = phn1.getText();
				email = email1.getText();
				teacher_id = teacher_id1.getText();

				session = session.replace("//s+", "");
				int s = Integer.parseInt(session.substring(5, 9));
				int s1 = Integer.parseInt(session.substring(0, 4));
				// System.out.println(s);
				// System.out.println(s1);
				if (!(s == s1 + 1)) {
					JOptionPane.showMessageDialog(null, "INVALID Session...");
				} else if (!phn.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Phone Number must be a Number...");
				} else if (phn.length() > 10 && phn.length() < 10) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Phone Number must be of 10 Digits...");
				} else if (!roll_no.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Roll Number must be a Number...");
				} else if (!admin_no.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Admission Number must be a Number...");
				} else if (!name.matches("[a-zA-Z]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Name must be a Character...");
				} else if (!fname.matches("[a-zA-Z]+")) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT !!!, Father's Name must be a Character...");
				} else {
					Student_teacher_insert_marks student_teacher_insert_marks = new Student_teacher_insert_marks(
							session, cls, admin_no, roll_no, name, dob, fname, address, phn, email, teacher_id, gender);
					student_teacher_insert_marks.setVisible(true);
				}
			}
		}

		);
		next.setForeground(Color.WHITE);
		next.setBackground(Color.DARK_GRAY);
		next.setFont(new Font("Tahoma", Font.BOLD, 11));
		next.setBounds(24, 476, 89, 23);
		contentPane.add(next);

		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_teacher_menu.student_teacher_menu();
			}
		});
		back.setForeground(Color.WHITE);
		back.setBackground(Color.DARK_GRAY);
		back.setFont(new Font("Tahoma", Font.BOLD, 11));
		back.setBounds(222, 476, 89, 23);
		contentPane.add(back);

		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.DARK_GRAY);
		exit.setFont(new Font("Tahoma", Font.BOLD, 11));
		exit.setBounds(321, 476, 89, 23);
		contentPane.add(exit);

		JLabel lblNewLabel_2_1 = new JLabel("EMAIL - ID");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(20, 415, 74, 14);
		contentPane.add(lblNewLabel_2_1);

		email1 = new JTextField();
		email1.setFont(new Font("Tahoma", Font.BOLD, 11));
		email1.setForeground(new Color(128, 0, 0));
		email1.setColumns(10);
		email1.setBackground(Color.LIGHT_GRAY);
		email1.setBounds(260, 412, 150, 20);
		contentPane.add(email1);

		sess1 = new JTextField();
		sess1.setForeground(new Color(128, 0, 0));
		sess1.setFont(new Font("Tahoma", Font.BOLD, 11));
		sess1.setColumns(10);
		sess1.setBackground(Color.LIGHT_GRAY);
		sess1.setBounds(260, 62, 150, 20);
		contentPane.add(sess1);

		cls1 = new JTextField();
		cls1.setForeground(new Color(128, 0, 0));
		cls1.setFont(new Font("Tahoma", Font.BOLD, 11));
		cls1.setColumns(10);
		cls1.setBackground(Color.LIGHT_GRAY);
		cls1.setBounds(260, 93, 150, 20);
		contentPane.add(cls1);

		teacher_id1 = new JTextField();
		teacher_id1.setForeground(new Color(128, 0, 0));
		teacher_id1.setFont(new Font("Tahoma", Font.BOLD, 11));
		teacher_id1.setColumns(10);
		teacher_id1.setBackground(Color.LIGHT_GRAY);
		teacher_id1.setBounds(260, 443, 150, 20);
		contentPane.add(teacher_id1);

		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset.setText("");
			}
		});
		reset.setForeground(Color.WHITE);
		reset.setFont(new Font("Tahoma", Font.BOLD, 11));
		reset.setBackground(Color.DARK_GRAY);
		reset.setBounds(123, 476, 89, 23);
		contentPane.add(reset);
	}
}