package item;

import frames.*;

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
import javax.swing.SwingConstants;

public class delete_item extends JFrame {
	static int item_id;
	static String iid;

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
					delete_item frame = new delete_item();
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
	public delete_item() {
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
		lblDeleteItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteItem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblDeleteItem.setBounds(12, 64, 1863, 28);
		contentPane.add(lblDeleteItem);

		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setForeground(Color.LIGHT_GRAY);
		lblItemId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblItemId.setBounds(144, 323, 105, 29);
		contentPane.add(lblItemId);

		textField = new JTextField();
		textField.setBounds(371, 315, 219, 54);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				iid = textField.getText();
				if (!iid.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Item id cannot be in char or Null");
				} else {
					item_id = Integer.parseInt(iid);
					try {

						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);

						stmt = conn.createStatement();
						System.out.println("Connection is created successfully:");

						String sql;

						sql = "delete from item where  item_id=" + item_id;
						stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,
								"Record is deleted from the table successfully..................");
						delete_item delete = new delete_item();
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
		btnDelete.setBounds(1395, 278, 219, 54);
		contentPane.add(btnDelete);

		JButton btnResest = new JButton("Reset");
		btnResest.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnResest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_item delete = new delete_item();
				delete.setVisible(true);
			}
		});
		btnResest.setBounds(1395, 404, 219, 54);
		contentPane.add(btnResest);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_2 frame2 = new frame_2();
				frame2.setVisible(true);
			}
		});
		btnMainMenu.setBounds(373, 570, 244, 46);
		contentPane.add(btnMainMenu);

		JButton btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_3_1 frame3 = new frame_3_1();
				frame3.setVisible(true);
			}
		});
		btnPreviousMenu.setBounds(1219, 566, 219, 54);
		contentPane.add(btnPreviousMenu);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(248, 315, 23, 27);
		contentPane.add(label_1);
	}

}
