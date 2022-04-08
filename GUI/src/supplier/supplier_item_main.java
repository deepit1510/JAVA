package supplier;
import frames.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Statement;

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

public class supplier_item_main extends JFrame {

	private JPanel contentPane;
	static int id1;
	static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplier_item_main frame = new supplier_item_main(id1);
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
	 * @param id1 
	 */
	public supplier_item_main(int id1) {
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
		
		JLabel lblInventoryControlManagement = new JLabel("INVENTORY CONTROL MANAGEMENT SYSTEM");
		lblInventoryControlManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventoryControlManagement.setForeground(Color.WHITE);
		lblInventoryControlManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblInventoryControlManagement.setBounds(12, 27, 1878, 32);
		contentPane.add(lblInventoryControlManagement);
		
		JLabel lblSelectOneOption = new JLabel("Select one option");
		lblSelectOneOption.setForeground(Color.LIGHT_GRAY);
		lblSelectOneOption.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblSelectOneOption.setBounds(96, 502, 420, 89);
		contentPane.add(lblSelectOneOption);
		
		JButton btnInsertNewItem = new JButton("INSERT NEW ITEM");
		btnInsertNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplier_insert_item frame1 = new supplier_insert_item(id1);
				frame1.setVisible(true);
			}
		});
		btnInsertNewItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsertNewItem.setBounds(1173, 313, 332, 67);
		contentPane.add(btnInsertNewItem);
		
		JButton btnDisplayItems_2 = new JButton("DISPLAY SUPPLIER ITEM");
		btnDisplayItems_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplayItems_2.setBounds(1173, 450, 334, 67);
		contentPane.add(btnDisplayItems_2);
		
		JButton btnDeleteSupplierItem = new JButton("DELETE SUPPLIER ITEM");
		btnDeleteSupplierItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteSupplierItem.setBounds(1173, 580, 332, 67);
		contentPane.add(btnDeleteSupplierItem);
		
		JButton btnMainMenu = new JButton("MAIN MENU");
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMainMenu.setBounds(1173, 716, 332, 67);
		contentPane.add(btnMainMenu);
	}

}
