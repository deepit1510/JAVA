package frames;

import supplier.*;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class frame_3_2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_3_2 frame = new frame_3_2();
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
	public frame_3_2() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 1259, 752);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSelectOneOption = new JLabel("Select one option");
		lblSelectOneOption.setForeground(Color.LIGHT_GRAY);
		lblSelectOneOption.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblSelectOneOption.setBounds(104, 538, 294, 66);
		contentPane.add(lblSelectOneOption);

		JLabel lblInventoryControlManagement = new JLabel("INVENTORY CONTROL MANAGEMENT SYSTEM");
		lblInventoryControlManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventoryControlManagement.setForeground(Color.WHITE);
		lblInventoryControlManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblInventoryControlManagement.setBounds(12, 50, 1878, 32);
		contentPane.add(lblInventoryControlManagement);

		JButton btnDisplayItems = new JButton("INSERT NEW SUPPLIER");
		btnDisplayItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert_supplier insert = new insert_supplier();
				insert.setVisible(true);
			}
		});
		btnDisplayItems.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplayItems.setBounds(1181, 316, 334, 66);
		contentPane.add(btnDisplayItems);

		JButton btnDisplayItems_2 = new JButton("DISPLAY SUPPLIER RECORDS");
		btnDisplayItems_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display_supplier display = new display_supplier();
				display.setVisible(true);
			}
		});
		btnDisplayItems_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplayItems_2.setBounds(1181, 431, 334, 57);
		contentPane.add(btnDisplayItems_2);

		JButton btnDeleteItems = new JButton("DELETE SUPPLIER RECORD");
		btnDeleteItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_supplier delete = new delete_supplier();
				delete.setVisible(true);
			}
		});
		btnDeleteItems.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteItems.setBounds(1182, 642, 333, 57);
		contentPane.add(btnDeleteItems);

		JButton btnMainMenu = new JButton("MAIN MENU");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_2 frame2 = new frame_2();
				frame2.setVisible(true);
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMainMenu.setBounds(1181, 739, 334, 66);
		contentPane.add(btnMainMenu);

		JButton btnDisplayItems_2_1 = new JButton("UPDATE SUPPLIER RECORDS");
		btnDisplayItems_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_supplier update = new update_supplier();
				update.setVisible(true);
			}
		});
		btnDisplayItems_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplayItems_2_1.setBounds(1181, 538, 334, 57);
		contentPane.add(btnDisplayItems_2_1);
	}
}
