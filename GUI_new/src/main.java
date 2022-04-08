import frames.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void makeFrameFullSize(JFrame aFrame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setSize(screenSize.width, screenSize.height);
	}

	/**
	 * Create the frame.
	 */
	public main() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInventoryControl = new JLabel("INVENTORY CONTROL ");
		lblInventoryControl.setForeground(Color.WHITE);
		lblInventoryControl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblInventoryControl.setBounds(128, 440, 371, 39);
		contentPane.add(lblInventoryControl);

		JLabel lblManagementSystem = new JLabel("MANAGEMENT SYSTEM ");
		lblManagementSystem.setForeground(Color.WHITE);
		lblManagementSystem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblManagementSystem.setBounds(287, 541, 384, 39);
		contentPane.add(lblManagementSystem);

		JButton btnNewButton = new JButton("EXISTING USER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		btnNewButton.setBounds(1275, 307, 316, 43);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("NEW USER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_user newu = new new_user();
				newu.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		btnNewButton_1.setBounds(1275, 457, 316, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Guest User");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame_3_5 frame = new frame_3_5();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		btnNewButton_1_1.setBounds(1275, 599, 316, 43);
		contentPane.add(btnNewButton_1_1);
	}
}
