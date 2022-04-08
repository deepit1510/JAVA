package supplier;
import frames.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class supplier_main_page extends JFrame {

	private JPanel contentPane;
	static int id;
	static int id1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplier_main_page frame = new supplier_main_page(id);
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
	public supplier_main_page(int id) {
	id1 = id;
		Connection conn = null;
		Statement stmt = null;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("SUPPLIER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplier_supplier_main frame1 = new supplier_supplier_main(id1);
				frame1.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(1410, 441, 289, 74);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("ITEM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplier_item_main frame = new supplier_item_main(id1);
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(1410, 295, 289, 74);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("REORDER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplier_reorder_main frame2 = new supplier_reorder_main(id1);
				frame2.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(1410, 592, 289, 74);
		contentPane.add(btnNewButton_2);
		
		JLabel lblSelectOneOption = new JLabel("SELECT ONE OPTION");
		lblSelectOneOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectOneOption.setForeground(Color.LIGHT_GRAY);
		lblSelectOneOption.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblSelectOneOption.setBackground(Color.LIGHT_GRAY);
		lblSelectOneOption.setBounds(264, 459, 440, 88);
		contentPane.add(lblSelectOneOption);
		
		JLabel lblInventoryControlManagement = new JLabel("INVENTORY CONTROL MANAGEMENT SYSTEM");
		lblInventoryControlManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventoryControlManagement.setForeground(Color.WHITE);
		lblInventoryControlManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblInventoryControlManagement.setBounds(-7, 49, 1897, 29);
		contentPane.add(lblInventoryControlManagement);
	}

}
