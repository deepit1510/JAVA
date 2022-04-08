package db_connectivity;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class Inventory_Management_System extends DB_Connection {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Inventory_Management_System window = new Inventory_Management_System();
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
	public Inventory_Management_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(240, 240, 240));
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(297, 13, 123, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDisplayData = new JButton("Display Data");
		btnDisplayData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		btnDisplayData.setBounds(297, 51, 123, 25);
		frame.getContentPane().add(btnDisplayData);
		
		JButton btnDeleteData = new JButton("Search Data");
		btnDeleteData.setBounds(297, 89, 123, 25);
		frame.getContentPane().add(btnDeleteData);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(29, 203, 97, 25);
		frame.getContentPane().add(btnExit);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(162, 203, 97, 25);
		frame.getContentPane().add(btnMainMenu);
		
		JButton btnIncreaseStock = new JButton("Increase Stock");
		btnIncreaseStock.setBounds(297, 127, 123, 25);
		frame.getContentPane().add(btnIncreaseStock);
		
		JButton btnDeleteData_1_1 = new JButton("Decrease Stock");
		btnDeleteData_1_1.setBounds(297, 165, 123, 25);
		frame.getContentPane().add(btnDeleteData_1_1);
		
		JButton btnDeleteData_1_2 = new JButton("Delete Data");
		btnDeleteData_1_2.setBounds(297, 203, 123, 25);
		frame.getContentPane().add(btnDeleteData_1_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, -3, 285, 145);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventory Control Management System");
		lblNewLabel.setBounds(6, 18, 273, 120);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
	}
}
