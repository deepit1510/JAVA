package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_main_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_main_page frame = new admin_main_page();
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
	public admin_main_page() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 1259, 752);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInventoryControlManagement = new JLabel("INVENTORY CONTROL MANAGEMENT SYSTEM");
		lblInventoryControlManagement.setForeground(Color.WHITE);
		lblInventoryControlManagement.setBounds(12, 26, 1897, 29);
		lblInventoryControlManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventoryControlManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblInventoryControlManagement);

		JLabel lblSelectOneOption = new JLabel("SELECT ONE OPTION");
		lblSelectOneOption.setForeground(Color.LIGHT_GRAY);
		lblSelectOneOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectOneOption.setBounds(176, 393, 440, 88);
		lblSelectOneOption.setBackground(Color.LIGHT_GRAY);
		lblSelectOneOption.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		contentPane.add(lblSelectOneOption);

		JButton btnNewButton = new JButton("ITEM");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				item_main_menu frame3_1 = new item_main_menu();
				frame3_1.setVisible(true);
			}
		});
		btnNewButton.setBounds(1200, 219, 289, 74);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("SUPPLIER");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				supplier_main_menu frame3_2 = new supplier_main_menu();
				frame3_2.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1200, 378, 289, 74);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("REORDER");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reorder_main_menu frame3 = new reorder_main_menu();
				frame3.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(1200, 551, 289, 74);
		contentPane.add(btnNewButton_2);
	}
}
