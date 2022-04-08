package frames;
import item.*;
import order.*;
import supplier.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import item.display_item;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class frame_3_5 extends JFrame {

	private JPanel contentPane;
	
	private void makeFrameFullSize(JFrame aFrame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		aFrame.setSize(screenSize.width, screenSize.height);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_3_5 frame = new frame_3_5();
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
	public frame_3_5() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInventoryControl = new JLabel("INVENTORY CONTROL ");
		lblInventoryControl.setForeground(Color.WHITE);
		lblInventoryControl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblInventoryControl.setBounds(85, 438, 371, 39);
		contentPane.add(lblInventoryControl);
		
		JLabel lblManagementSystem = new JLabel("MANAGEMENT SYSTEM ");
		lblManagementSystem.setForeground(Color.WHITE);
		lblManagementSystem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblManagementSystem.setBounds(257, 536, 384, 39);
		contentPane.add(lblManagementSystem);
		
		JButton btnDisplayItems = new JButton("Display Items Records");
		btnDisplayItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display1 item = new display1();
				item.setVisible(true);
			}
		});
		btnDisplayItems.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnDisplayItems.setBounds(1306, 329, 290, 51);
		contentPane.add(btnDisplayItems);
		
		JButton btnDisplaySupplierRecords = new JButton("Display Supplier Records");
		btnDisplaySupplierRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displays supplier = new displays();
				supplier.setVisible(true);
			}
		});
		btnDisplaySupplierRecords.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnDisplaySupplierRecords.setBounds(1306, 452, 290, 51);
		contentPane.add(btnDisplaySupplierRecords);
		
		JButton btnDisplayReorder = new JButton("Display Reorder");
		btnDisplayReorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayo order = new displayo();
				order.setVisible(true);
			}
		});
		btnDisplayReorder.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnDisplayReorder.setBounds(1306, 563, 290, 51);
		contentPane.add(btnDisplayReorder);
		
		JLabel lblGuestLogin = new JLabel("Guest Login");
		lblGuestLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuestLogin.setForeground(Color.WHITE);
		lblGuestLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblGuestLogin.setBounds(826, 117, 211, 36);
		contentPane.add(lblGuestLogin);
	}

}
