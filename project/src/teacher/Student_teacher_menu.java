package teacher;
import project.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_teacher_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void student_teacher_menu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_teacher_menu frame = new Student_teacher_menu();
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
	public Student_teacher_menu() {
		setBounds(100, 100, 445, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton create_record = new JButton("CREATE RECORD");
		create_record.setForeground(new Color(128, 0, 0));
		create_record.setBackground(Color.GRAY);
		create_record.setFont(new Font("Tahoma", Font.BOLD, 11));
		create_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student_teacher_insert.student_teacher_insert();
			}
		});
		create_record.setBounds(75, 97, 132, 40);
		contentPane.add(create_record);

		JLabel lblNewLabel = new JLabel("---- Student Details ----");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 414, 40);
		contentPane.add(lblNewLabel);

		JButton update_record = new JButton("UPDATE RECORD");
		update_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student_teacher_update.student_teacher_update();
			}
		});
		update_record.setForeground(new Color(128, 0, 0));
		update_record.setBackground(Color.GRAY);
		update_record.setFont(new Font("Tahoma", Font.BOLD, 11));
		update_record.setBounds(75, 161, 132, 40);
		contentPane.add(update_record);

		JButton submit = new JButton("BACK");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Teacher_login.teacher_login();
			}
		});
		submit.setForeground(Color.WHITE);
		submit.setBackground(Color.DARK_GRAY);
		submit.setFont(new Font("Tahoma", Font.BOLD, 11));
		submit.setBounds(75, 258, 89, 23);
		contentPane.add(submit);

		JButton login = new JButton("LOGIN");
		login.setForeground(Color.WHITE);
		login.setBackground(Color.DARK_GRAY);
		login.setFont(new Font("Tahoma", Font.BOLD, 11));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.login();
			}
		});
		login.setBounds(174, 258, 89, 23);
		contentPane.add(login);

		JButton delete_record = new JButton("ALL RECORDS");
		delete_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_teacher_view_all.student_teacher_view_all();
			}
		});
		delete_record.setForeground(new Color(128, 0, 0));
		delete_record.setBackground(Color.GRAY);
		delete_record.setFont(new Font("Tahoma", Font.BOLD, 11));
		delete_record.setBounds(229, 161, 132, 40);
		contentPane.add(delete_record);

		JButton search_record = new JButton("SEARCH RECORD");
		search_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student_teacher_search.student_teacher_search();
			}
		});
		search_record.setForeground(new Color(128, 0, 0));
		search_record.setBackground(Color.GRAY);
		search_record.setFont(new Font("Tahoma", Font.BOLD, 11));
		search_record.setBounds(229, 97, 132, 40);
		contentPane.add(search_record);

		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setForeground(Color.WHITE);
		btnExit.setBounds(272, 258, 89, 23);
		contentPane.add(btnExit);
	}
}
