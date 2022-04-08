package item;

import frames.*;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class insert_item extends JFrame {

	static String sp_id;
	static int sup_id;
	static String nme;
	static String name;
	static String des;
	static String ct_stk;
	static long crt_stk;
	static String al_cons;
	static long anual_cons;
	static String or_cost;
	static double order_cost;
	static String pt_unt;
	static long prdct_unt;
	static double sales;
	static double prdct_price;
	static String sk_mant;
	static double stk_mant;
	static double eoq;
	static long re_order;
	static long safty_stk;
	static String l_size;
	static long lt_size;
	static long no_odr;
	static String l_tme;
	static long ld_tme;

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/new_system";
	static final String USER = "root";
	static final String PASS = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert_item frame = new insert_item();
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
	public insert_item() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInsertItem = new JLabel("Insert Item");
		lblInsertItem.setForeground(Color.WHITE);
		lblInsertItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertItem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblInsertItem.setBounds(12, 33, 1878, 32);
		contentPane.add(lblInsertItem);

		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setForeground(Color.LIGHT_GRAY);
		lblSupplierId.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblSupplierId.setBounds(75, 174, 149, 42);
		contentPane.add(lblSupplierId);

		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setForeground(Color.LIGHT_GRAY);
		lblItemName.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblItemName.setBounds(76, 262, 127, 29);
		contentPane.add(lblItemName);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(356, 253, 194, 50);
		contentPane.add(textField_1);

		JLabel lblItemDescription = new JLabel("Item Description");
		lblItemDescription.setForeground(Color.LIGHT_GRAY);
		lblItemDescription.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblItemDescription.setBounds(76, 348, 136, 22);
		contentPane.add(lblItemDescription);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(356, 336, 194, 50);
		contentPane.add(textField_2);

		JLabel lblNumberOfUnits = new JLabel("No. of units purchasesd");
		lblNumberOfUnits.setForeground(Color.LIGHT_GRAY);
		lblNumberOfUnits.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNumberOfUnits.setBounds(76, 421, 194, 22);
		contentPane.add(lblNumberOfUnits);

		JLabel lblPerUnitPrice = new JLabel("Per unit price");
		lblPerUnitPrice.setForeground(Color.LIGHT_GRAY);
		lblPerUnitPrice.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblPerUnitPrice.setBounds(76, 506, 115, 22);
		contentPane.add(lblPerUnitPrice);

		JLabel lblAnualConsumption = new JLabel("Annual Consumption");
		lblAnualConsumption.setForeground(Color.LIGHT_GRAY);
		lblAnualConsumption.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblAnualConsumption.setBounds(76, 585, 164, 22);
		contentPane.add(lblAnualConsumption);

		JLabel lblOrderingCost = new JLabel("Ordering Cost");
		lblOrderingCost.setForeground(Color.LIGHT_GRAY);
		lblOrderingCost.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblOrderingCost.setBounds(946, 179, 133, 32);
		contentPane.add(lblOrderingCost);

		JLabel lblNewLabel = new JLabel("Storage and Maintainence cost");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(946, 265, 279, 22);
		contentPane.add(lblNewLabel);

		JLabel lblLotSize = new JLabel("Lot Size");
		lblLotSize.setForeground(Color.LIGHT_GRAY);
		lblLotSize.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblLotSize.setBounds(946, 348, 79, 22);
		contentPane.add(lblLotSize);

		JLabel lblLeadTime = new JLabel("Lead Time");
		lblLeadTime.setForeground(Color.LIGHT_GRAY);
		lblLeadTime.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblLeadTime.setBounds(946, 430, 99, 22);
		contentPane.add(lblLeadTime);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				Statement stmt = null;

				sp_id = textField.getText();
				name = textField_1.getText();
				des = textField_2.getText();
				ct_stk = textField_3.getText();
				pt_unt = textField_4.getText();
				al_cons = textField_5.getText();
				or_cost = textField_6.getText();
				sk_mant = textField_7.getText();
				l_size = textField_8.getText();
				l_tme = textField_9.getText();
				if (!sp_id.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Supplier id cannot be null or in char");
				} else if (!name.matches("[a-zA-Z ,0-9]+")) {
					JOptionPane.showMessageDialog(null, "Item name cannot be null");
				} else if (des.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Item description cannot be null");
				} else if (!ct_stk.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "current Stock cannot be null or in char");
				} else if (pt_unt.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Per unit price cannot be null");
				} else if (!al_cons.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Anual consumption cannot be null");
				} else if (!or_cost.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "ordering cost cannot be null");
				} else if (!sk_mant.matches("[0-9,.]+")) {
					JOptionPane.showMessageDialog(null, "Storing and mainatence Cost cannot be null");
				} else if (!l_size.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Lot size cannot be null");
				} else if (!l_tme.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Lead time cannot be null");
				} else {
					// id= Integer.parseInt(iid);
					sup_id = Integer.parseInt(sp_id);
					crt_stk = Integer.parseInt(ct_stk);
					prdct_unt = Long.parseLong(pt_unt);
					anual_cons = Integer.parseInt(al_cons);
					order_cost = Float.parseFloat(or_cost);
					stk_mant = Float.parseFloat(sk_mant);
					lt_size = Integer.parseInt(l_size);
					ld_tme = Long.parseLong(l_tme);
					prdct_price = prdct_unt;
					safty_stk = (ld_tme / 2) * (anual_cons / 300);
					crt_stk = crt_stk - safty_stk;
					eoq = Math.sqrt((2 * anual_cons * order_cost) + safty_stk);
					re_order = (lt_size * (anual_cons / 365) + safty_stk);
					no_odr = (int) Math.floor(re_order / lt_size);
					sales = prdct_price + prdct_price*.20;
					try {

						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);

						stmt = conn.createStatement();
						System.out.println("Connection is created successfully:");
						String sql;

						sql = "insert into item(sup_id, item_name, item_des, crt_stk, anual_cons, order_cost, "
								+ "prdct_unt, prdct_price, load_time, stck_mant, eoq, re_order_lvl, safty_stk, lt_siz, no_odr,sale_price) values("
								+ sup_id + ",'" + name + "','" + des + "'," + crt_stk + "," + anual_cons + ","
								+ order_cost + "," + prdct_unt + "," + prdct_price + "," + ld_tme + "," + stk_mant + ","
								+ eoq + "," + re_order + "," + safty_stk + "," + lt_size + "," + no_odr +","+sales+ ")";
						stmt.executeUpdate(sql);
						
						System.out.println("Record is inserted in the table successfully..................");
						JOptionPane.showMessageDialog(null,
								"Record is inserted in the table successfully..................");
						insert_item insert = new insert_item();
						insert.setVisible(true);
					} catch (SQLException excep) {
						excep.printStackTrace();
					} catch (Exception excep) {
						excep.printStackTrace();
					} finally {
						try {
							if (stmt != null)
								conn.close();
						} catch (SQLException se) {
						}
						try {
							if (conn != null)
								conn.close();
						} catch (SQLException se) {
							se.printStackTrace();
						}
					}
				}
				// System.out.println("Please check it in the MySQL
				// Table.........
				// ……..");
				

			}
		});
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnInsert.setBounds(1319, 739, 177, 35);
		contentPane.add(btnInsert);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert_item insert = new insert_item();
				insert.setVisible(true);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnReset.setBounds(1319, 825, 177, 35);
		contentPane.add(btnReset);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(356, 172, 194, 50);
		contentPane.add(textField);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(356, 413, 194, 42);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(356, 495, 194, 48);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(356, 577, 194, 42);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(1331, 176, 194, 43);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(1331, 257, 194, 42);
		contentPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(1331, 337, 194, 50);
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(1334, 418, 194, 50);
		contentPane.add(textField_9);

		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_main_page frame2 = new admin_main_page();
				frame2.setVisible(true);
			}
		});
		btnMainMenu.setBounds(913, 740, 200, 35);
		contentPane.add(btnMainMenu);

		JButton btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item_main_menu frame3 = new item_main_menu();
				frame3.setVisible(true);
			}
		});
		btnPreviousMenu.setBounds(913, 825, 200, 35);
		contentPane.add(btnPreviousMenu);

		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setBounds(169, 174, 23, 27);
		contentPane.add(label);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(168, 260, 23, 27);
		contentPane.add(label_1);

		JLabel label_1_1 = new JLabel("*");
		label_1_1.setForeground(Color.RED);
		label_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_1.setBounds(211, 343, 23, 27);
		contentPane.add(label_1_1);

		JLabel label_1_2 = new JLabel("*");
		label_1_2.setForeground(Color.RED);
		label_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_2.setBounds(272, 413, 23, 27);
		contentPane.add(label_1_2);

		JLabel label_1_3 = new JLabel("*");
		label_1_3.setForeground(Color.RED);
		label_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_3.setBounds(186, 501, 23, 27);
		contentPane.add(label_1_3);

		JLabel label_1_4 = new JLabel("*");
		label_1_4.setForeground(Color.RED);
		label_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_4.setBounds(247, 580, 23, 27);
		contentPane.add(label_1_4);

		JLabel label_1_5 = new JLabel("*");
		label_1_5.setForeground(Color.RED);
		label_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_5.setBounds(1060, 174, 23, 27);
		contentPane.add(label_1_5);

		JLabel label_1_6 = new JLabel("*");
		label_1_6.setForeground(Color.RED);
		label_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_6.setBounds(1191, 260, 23, 27);
		contentPane.add(label_1_6);

		JLabel label_1_7 = new JLabel("*");
		label_1_7.setForeground(Color.RED);
		label_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_7.setBounds(1014, 343, 23, 27);
		contentPane.add(label_1_7);

		JLabel label_1_8 = new JLabel("*");
		label_1_8.setForeground(Color.RED);
		label_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_8.setBounds(1035, 421, 23, 27);
		contentPane.add(label_1_8);
	}
}
