package admin;
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

public class Student_admin_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void student_admin_menu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_admin_menu frame = new Student_admin_menu();
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
	public Student_admin_menu() {
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
				Student_insert.student_insert();
			}
		});
		create_record.setBounds(75, 70, 132, 40);
		contentPane.add(create_record);

		JLabel lblNewLabel = new JLabel("---- Student Menu ----");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 414, 40);
		contentPane.add(lblNewLabel);

		JButton update_record = new JButton("UPDATE RECORD");
		update_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student_update.student_update();
			}
		});
		update_record.setForeground(new Color(128, 0, 0));
		update_record.setBackground(Color.GRAY);
		update_record.setFont(new Font("Tahoma", Font.BOLD, 11));
		update_record.setBounds(75, 124, 132, 40);
		contentPane.add(update_record);

		JButton view_all = new JButton("VIEW ALL RECORDS");
		view_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student_view_all.student_view_all();
			}
		});
		view_all.setForeground(new Color(128, 0, 0));
		view_all.setBackground(Color.GRAY);
		view_all.setFont(new Font("Tahoma", Font.BOLD, 11));
		view_all.setBounds(102, 178, 235, 40);
		contentPane.add(view_all);

		JButton submit = new JButton("BACK");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_login.admin_login();
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

		JButton delete_record = new JButton("DELETE RECORD");
		delete_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_delete.student_delete();
			}
		});
		delete_record.setForeground(new Color(128, 0, 0));
		delete_record.setBackground(Color.GRAY);
		delete_record.setFont(new Font("Tahoma", Font.BOLD, 11));
		delete_record.setBounds(229, 124, 132, 40);
		contentPane.add(delete_record);

		JButton search_record = new JButton("SEARCH RECORD");
		search_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student_search.student_search();
			}
		});
		search_record.setForeground(new Color(128, 0, 0));
		search_record.setBackground(Color.GRAY);
		search_record.setFont(new Font("Tahoma", Font.BOLD, 11));
		search_record.setBounds(229, 70, 132, 40);
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