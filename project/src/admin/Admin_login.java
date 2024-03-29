package admin;
import project.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void admin_login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login frame = new Admin_login();
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
	public Admin_login() {
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAdministratorLogin = new JLabel("---- Administrator Login ----");
		lblAdministratorLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministratorLogin.setForeground(Color.WHITE);
		lblAdministratorLogin.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblAdministratorLogin.setBounds(10, 11, 414, 40);
		
		contentPane.add(lblAdministratorLogin);

		JButton btnStudentDetails = new JButton("STUDENT DETAILS");
		btnStudentDetails.setForeground(Color.BLUE);
		btnStudentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student_admin_menu.student_admin_menu();
			}
		});
		btnStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStudentDetails.setBackground(Color.GRAY);
		btnStudentDetails.setBounds(45, 118, 160, 69);
		contentPane.add(btnStudentDetails);

		JButton btnTeachersDetails = new JButton("TEACHERS DETAILS");
		btnTeachersDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Teacher_admin_menu.teacher_admin_menu();
			}
		});
		btnTeachersDetails.setForeground(Color.BLUE);
		btnTeachersDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTeachersDetails.setBackground(Color.GRAY);
		btnTeachersDetails.setBounds(233, 118, 160, 69);
		contentPane.add(btnTeachersDetails);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBounds(222, 263, 89, 23);
		contentPane.add(btnExit);
		
		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.login();
			}
		});
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Tahoma", Font.BOLD, 11));
		login.setBackground(Color.DARK_GRAY);
		login.setBounds(124, 263, 89, 23);
		contentPane.add(login);
	}
}