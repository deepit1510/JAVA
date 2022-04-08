package frames;

import item.*;

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

public class frame_3_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_3_1 frame = new frame_3_1();
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
	public frame_3_1() {
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
		lblSelectOneOption.setFont(new Font("Times New Roman", Font.BOLD, 31));
		lblSelectOneOption.setBounds(122, 463, 288, 83);
		contentPane.add(lblSelectOneOption);

		JLabel lblInventoryControlManagement = new JLabel("INVENTORY CONTROL MANAGEMENT SYSTEM");
		lblInventoryControlManagement.setForeground(Color.WHITE);
		lblInventoryControlManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventoryControlManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblInventoryControlManagement.setBounds(12, 50, 1878, 32);
		contentPane.add(lblInventoryControlManagement);

		JButton btnDisplayItems = new JButton("INSERT ITEMS");
		btnDisplayItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert_item item = new insert_item();
				item.setVisible(true);
			}
		});
		btnDisplayItems.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplayItems.setBounds(1220, 246, 316, 65);
		contentPane.add(btnDisplayItems);

		JButton btnDisplayItems_2 = new JButton("DISPLAY ITEMS");
		btnDisplayItems_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display_item display = new display_item();
				display.setVisible(true);
			}
		});
		btnDisplayItems_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDisplayItems_2.setBounds(1220, 361, 316, 56);
		contentPane.add(btnDisplayItems_2);

		JButton btnDeleteItems = new JButton("DELETE ITEMS");
		btnDeleteItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_item delete = new delete_item();
				delete.setVisible(true);
			}
		});
		btnDeleteItems.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteItems.setBounds(1220, 603, 316, 56);
		contentPane.add(btnDeleteItems);

		JButton btnMainMenu = new JButton("MAIN MENU");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_2 frame2 = new frame_2();
				frame2.setVisible(true);
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMainMenu.setBounds(1220, 718, 316, 65);
		contentPane.add(btnMainMenu);

		JButton btnUpdateItems = new JButton("UPDATE ITEMS");
		btnUpdateItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_item update = new update_item();
				update.setVisible(true);

			}
		});
		btnUpdateItems.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdateItems.setBounds(1220, 480, 316, 56);
		contentPane.add(btnUpdateItems);
	}
}
