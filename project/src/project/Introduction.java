package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Introduction {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void introduction() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Introduction window = new Introduction();
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
	public Introduction() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 490, 350);
		frame.getContentPane().setLayout(null);

		JLabel lblStudentRecord = new JLabel("JAGANNATH INSTITUTE OF MANAGEMENT SCIENCES");
		lblStudentRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentRecord.setFont(new Font("Colonna MT", Font.BOLD | Font.ITALIC, 15));
		lblStudentRecord.setForeground(Color.WHITE);
		lblStudentRecord.setBounds(10, 11, 454, 40);
		frame.getContentPane().add(lblStudentRecord);

		JLabel lblNewLabel = new JLabel("Sector-3, Rohini, New Delhi-110085");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 37, 454, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblExaminationResultManagement = new JLabel("==== EXAMINATION RESULT MANAGEMENT SYSTEM ====");
		lblExaminationResultManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblExaminationResultManagement.setForeground(Color.WHITE);
		lblExaminationResultManagement.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblExaminationResultManagement.setBounds(10, 126, 454, 30);
		frame.getContentPane().add(lblExaminationResultManagement);

		JLabel lblName = new JLabel("DESIGNED BY : JAI AGGARWAL");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(10, 252, 199, 14);
		frame.getContentPane().add(lblName);

		JLabel lblDepartmentBca = new JLabel("DEPARTMENT : BCA 2nd YEAR");
		lblDepartmentBca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDepartmentBca.setForeground(Color.WHITE);
		lblDepartmentBca.setBounds(10, 271, 199, 14);
		frame.getContentPane().add(lblDepartmentBca);
		
	}
}