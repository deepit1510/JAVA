package order;

import frames.*;
import item.delete_item;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class delete_order extends JFrame {
	static int odr_id;
	static String oid;

	private JPanel contentPane;
	private JTextField textField;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_order frame = new delete_order();
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
	public delete_order() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDeleteItem = new JLabel("Delete Item");
		lblDeleteItem.setForeground(Color.WHITE);
		lblDeleteItem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblDeleteItem.setBounds(805, 62, 150, 38);
		contentPane.add(lblDeleteItem);

		JLabel lblItemId = new JLabel("Order ID");
		lblItemId.setForeground(Color.LIGHT_GRAY);
		lblItemId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblItemId.setBounds(119, 345, 144, 64);
		contentPane.add(lblItemId);

		textField = new JTextField();
		textField.setBounds(330, 356, 172, 46);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				oid = textField.getText();
				if (!oid.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Order id cannot be null or in char");
				} else {
					odr_id = Integer.parseInt(oid);
					try {

						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);

						stmt = conn.createStatement();
						System.out.println("Connection is created successfully:");

						String sql;

						sql = "delete from re_order where  odr_id=" + odr_id;
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,
								"Record is deleted from the table successfully..................");
						delete_order delete = new delete_order();
						delete.setVisible(true);
						System.out.println("Connection is Deleted successfully:");

					} catch (SQLException se) {
						// Handle errors for JDBC
						se.printStackTrace();
					} catch (Exception e1) {
						// Handle errors for Class.forName
						e1.printStackTrace();
					}
				}
			}
		});
		btnDelete.setBounds(1341, 338, 172, 46);
		contentPane.add(btnDelete);

		JButton btnResest = new JButton("Resest");
		btnResest.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnResest.setBounds(1341, 465, 172, 46);
		contentPane.add(btnResest);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_2 frame2 = new frame_2();
				frame2.setVisible(true);
			}
		});
		btnMainMenu.setBounds(613, 693, 172, 46);
		contentPane.add(btnMainMenu);

		JButton btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_3_1 frame3 = new frame_3_1();
				frame3.setVisible(true);
			}
		});
		btnPreviousMenu.setBounds(1024, 686, 172, 53);
		contentPane.add(btnPreviousMenu);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(204, 356, 23, 27);
		contentPane.add(label_1);
	}

}
