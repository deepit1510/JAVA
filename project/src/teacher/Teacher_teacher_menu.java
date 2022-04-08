package teacher;
import project.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.*;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teacher_teacher_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void teacher_teacher_menu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_teacher_menu frame = new Teacher_teacher_menu();
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
	public Teacher_teacher_menu() {
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("----TEACHER MENU ----");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(10, 11, 414, 40);
		contentPane.add(lblNewLabel);

		JButton btnCreateRecord = new JButton("CREATE RECORD");
		btnCreateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Teacher_teacher_insert.teacher_teacher_insert();
			}
		});
		btnCreateRecord.setForeground(Color.YELLOW);
		btnCreateRecord.setBackground(Color.GRAY);
		btnCreateRecord.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreateRecord.setBounds(75, 87, 132, 40);
		contentPane.add(btnCreateRecord);

		JButton btnUpdateRecord = new JButton("UPDATE RECORD");
		btnUpdateRecord.setForeground(Color.YELLOW);
		btnUpdateRecord.setBackground(Color.GRAY);
		btnUpdateRecord.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Teacher_teacher_update.teacher_teacher_update();
			}
		});
		btnUpdateRecord.setBounds(229, 87, 132, 40);
		contentPane.add(btnUpdateRecord);

		JButton btnDeleteRecord = new JButton("ALL RECORDS");
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Teacher_teacher_view_all.teacher_teacher_view_all();
			}
		});
		btnDeleteRecord.setForeground(Color.YELLOW);
		btnDeleteRecord.setBackground(Color.GRAY);
		btnDeleteRecord.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteRecord.setBounds(229, 150, 132, 40);
		contentPane.add(btnDeleteRecord);

		JButton btnSearchRecord = new JButton("SEARCH RECORD");
		btnSearchRecord.setForeground(Color.YELLOW);
		btnSearchRecord.setBackground(Color.GRAY);
		btnSearchRecord.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearchRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearchRecord.setBounds(75, 150, 132, 40);
		contentPane.add(btnSearchRecord);

		JButton submit = new JButton("BACK");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher_login.teacher_login();
			}
		});
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Tahoma", Font.BOLD, 11));
		submit.setBackground(Color.DARK_GRAY);
		submit.setBounds(75, 263, 89, 23);
		contentPane.add(submit);

		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.login();
			}
		});
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Tahoma", Font.BOLD, 11));
		login.setBackground(Color.DARK_GRAY);
		login.setBounds(174, 263, 89, 23);
		contentPane.add(login);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBounds(272, 263, 89, 23);
		contentPane.add(btnExit);
	}
}
