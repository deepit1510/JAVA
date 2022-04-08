package supplier;
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

public class delete_supplier extends JFrame {
	static int sup_id;
	static String sid;

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
					delete_supplier frame = new delete_supplier();
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
	public delete_supplier() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteItem = new JLabel("Delete Item");
		lblDeleteItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteItem.setForeground(Color.WHITE);
		lblDeleteItem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblDeleteItem.setBounds(767, 68, 250, 38);
		contentPane.add(lblDeleteItem);
		
		JLabel lblItemId = new JLabel("Supplier ID");
		lblItemId.setForeground(Color.LIGHT_GRAY);
		lblItemId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblItemId.setBounds(110, 346, 165, 59);
		contentPane.add(lblItemId);
		
		textField = new JTextField();
		textField.setBounds(326, 347, 213, 58);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				sid = textField.getText();
				if (!sid.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Supplier id cannot be null or in char");
				}
				else{
					sup_id = Integer.parseInt(textField.getText());
				}
				try {

					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					stmt = conn.createStatement();
					System.out.println("Connection is created successfully:");

					String sql;

					sql = "delete from supplier where  sup_id=" + sup_id;
					stmt.executeUpdate(sql);

					System.out.println("Connection is Deleted successfully:");
					JOptionPane.showMessageDialog(null,
							"Record deleted from the table successfully..................");
					delete_supplier delete_supplier = new delete_supplier();
					delete_supplier.setVisible(true);
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(1203, 341, 162, 35);
		contentPane.add(btnDelete);
		
		JButton btnResest = new JButton("Resest");
		btnResest.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnResest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete_supplier delete = new delete_supplier();
				delete.setVisible(true);
			}
		});
		btnResest.setBounds(1194, 504, 171, 35);
		contentPane.add(btnResest);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_main_page frame2 = new admin_main_page();
				frame2.setVisible(true);
			}
		});
		btnMainMenu.setBounds(458, 626, 165, 35);
		contentPane.add(btnMainMenu);
		
		JButton btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplier_main_menu frame3 = new supplier_main_menu();
				frame3.setVisible(true);
			}
		});
		btnPreviousMenu.setBounds(778, 626, 196, 35);
		contentPane.add(btnPreviousMenu);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(216, 356, 23, 27);
		contentPane.add(label_1);
	}

}
