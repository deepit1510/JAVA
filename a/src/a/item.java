package a;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;


public class item extends JFrame {
	static String id;
	static int iid;
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
	static double prdct_unt;
	// static String pt_price;
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
	private static JTable table;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					item frame = new item();
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
	public item() {
		int a = l_table();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInsertItem = new JLabel("Insert Item");
		lblInsertItem.setBounds(12, 33, 1878, 32);
		lblInsertItem.setForeground(Color.WHITE);
		lblInsertItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertItem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		contentPane.add(lblInsertItem);

		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setBounds(76, 142, 149, 42);
		lblSupplierId.setForeground(Color.LIGHT_GRAY);
		lblSupplierId.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblSupplierId);

		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(76, 200, 127, 29);
		lblItemName.setForeground(Color.LIGHT_GRAY);
		lblItemName.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblItemName);

		textField_1 = new JTextField();
		textField_1.setBounds(356, 191, 194, 50);
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		JLabel lblItemDescription = new JLabel("Item Description");
		lblItemDescription.setBounds(76, 266, 136, 22);
		lblItemDescription.setForeground(Color.LIGHT_GRAY);
		lblItemDescription.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblItemDescription);

		textField_2 = new JTextField();
		textField_2.setBounds(356, 254, 194, 50);
		textField_2.setColumns(10);
		contentPane.add(textField_2);

		JLabel lblNumberOfUnits = new JLabel("No. of units purchasesd");
		lblNumberOfUnits.setBounds(76, 325, 194, 22);
		lblNumberOfUnits.setForeground(Color.LIGHT_GRAY);
		lblNumberOfUnits.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblNumberOfUnits);

		JLabel lblPerUnitPrice = new JLabel("Per unit price");
		lblPerUnitPrice.setBounds(76, 383, 115, 22);
		lblPerUnitPrice.setForeground(Color.LIGHT_GRAY);
		lblPerUnitPrice.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblPerUnitPrice);

		JLabel lblAnualConsumption = new JLabel("Annual Consumption");
		lblAnualConsumption.setBounds(76, 441, 171, 22);
		lblAnualConsumption.setForeground(Color.LIGHT_GRAY);
		lblAnualConsumption.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblAnualConsumption);

		JLabel lblOrderingCost = new JLabel("Ordering Cost");
		lblOrderingCost.setBounds(76, 491, 133, 32);
		lblOrderingCost.setForeground(Color.LIGHT_GRAY);
		lblOrderingCost.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblOrderingCost);

		JLabel lblNewLabel = new JLabel("Storage and Maintainence cost");
		lblNewLabel.setBounds(76, 552, 279, 22);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblNewLabel);

		JLabel lblLotSize = new JLabel("Lot Size");
		lblLotSize.setBounds(76, 611, 79, 22);
		lblLotSize.setForeground(Color.LIGHT_GRAY);
		lblLotSize.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblLotSize);

		JLabel lblLeadTime = new JLabel("Lead Time");
		lblLeadTime.setBounds(76, 674, 99, 22);
		lblLeadTime.setForeground(Color.LIGHT_GRAY);
		lblLeadTime.setFont(new Font("Tahoma", Font.ITALIC, 18));
		contentPane.add(lblLeadTime);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(447, 775, 177, 35);
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
					prdct_price = prdct_unt * crt_stk;
					safty_stk = (ld_tme / 2) * (anual_cons / 300);
					crt_stk = crt_stk - safty_stk;
					eoq = Math.sqrt((2 * anual_cons * order_cost) + safty_stk);
					re_order = (lt_size * (anual_cons / 365) + safty_stk);
					no_odr = (int) Math.floor(re_order / lt_size);
					try {

						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);

						stmt = conn.createStatement();
						System.out.println("Connection is created successfully:");
						String sql;

						sql = "insert into item(sup_id, item_name, item_des, crt_stk, anual_cons, order_cost, prdct_unt, prdct_price, load_time, stck_mant, eoq, re_order_lvl, safty_stk, lt_siz, no_odr) values("
								+ sup_id + ",'" + name + "','" + des + "'," + crt_stk + "," + anual_cons + ","
								+ order_cost + "," + prdct_unt + "," + prdct_price + "," + ld_tme + "," + stk_mant + ","
								+ eoq + "," + re_order + "," + safty_stk + "," + lt_size + "," + no_odr + ")";
						stmt.executeUpdate(sql);
						System.out.println("Record is inserted in the table successfully..................");
						JOptionPane.showMessageDialog(null,
								"Record is inserted in the table successfully..................");
						item insert = new item();
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
				item itm = new item();
				itm.setVisible(true);
				}
				// System.out.println("Please check it in the MySQL
				// Table.........
				// ��..");

			}
		});
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		contentPane.add(btnInsert);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(447, 875, 177, 35);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item itm = new item();
				itm.setVisible(true);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		contentPane.add(btnReset);

		textField = new JTextField();
		textField.setBounds(356, 128, 194, 50);
		textField.setColumns(10);
		contentPane.add(textField);

		textField_3 = new JTextField();
		textField_3.setBounds(356, 317, 194, 42);
		textField_3.setColumns(10);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setBounds(356, 372, 194, 48);
		textField_4.setColumns(10);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setBounds(356, 433, 194, 42);
		textField_5.setColumns(10);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setBounds(356, 488, 194, 43);
		textField_6.setColumns(10);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setBounds(356, 544, 194, 42);
		textField_7.setColumns(10);
		contentPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setBounds(356, 599, 194, 50);
		textField_8.setColumns(10);
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setBounds(356, 662, 194, 42);
		textField_9.setColumns(10);
		contentPane.add(textField_9);

		JButton btnMainMenu = new JButton("Main Login");
		btnMainMenu.setBounds(102, 775, 200, 35);
		btnMainMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame2 = new Login();
				frame2.setVisible(true);
			}
		});
		contentPane.add(btnMainMenu);

		JButton btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setBounds(102, 875, 200, 35);
		btnPreviousMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				record_menu menu = new record_menu();
				menu.setVisible(true);
			}
		});
		contentPane.add(btnPreviousMenu);

		JLabel label = new JLabel("*");
		label.setBounds(168, 142, 23, 27);
		label.setForeground(Color.RED);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label);

		JLabel label_1 = new JLabel("*");
		label_1.setBounds(168, 197, 23, 27);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label_1);

		JLabel label_1_1 = new JLabel("*");
		label_1_1.setBounds(209, 265, 23, 27);
		label_1_1.setForeground(Color.RED);
		label_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label_1_1);

		JLabel label_1_2 = new JLabel("*");
		label_1_2.setBounds(266, 317, 23, 27);
		label_1_2.setForeground(Color.RED);
		label_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label_1_2);

		JLabel label_1_3 = new JLabel("*");
		label_1_3.setBounds(184, 378, 23, 27);
		label_1_3.setForeground(Color.RED);
		label_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label_1_3);

		JLabel label_1_4 = new JLabel("*");
		label_1_4.setBounds(241, 426, 29, 32);
		label_1_4.setForeground(Color.RED);
		label_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label_1_4);

		JLabel label_1_5 = new JLabel("*");
		label_1_5.setBounds(196, 490, 29, 32);
		label_1_5.setForeground(Color.RED);
		label_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label_1_5);

		JLabel label_1_6 = new JLabel("*");
		label_1_6.setBounds(143, 610, 23, 27);
		label_1_6.setForeground(Color.RED);
		label_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label_1_6);

		JLabel label_1_7 = new JLabel("*");
		label_1_7.setBounds(324, 544, 23, 27);
		label_1_7.setForeground(Color.RED);
		label_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label_1_7);

		JLabel label_1_8 = new JLabel("*");
		label_1_8.setBounds(164, 669, 27, 27);
		label_1_8.setForeground(Color.RED);
		label_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(label_1_8);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				id = textField_10.getText();
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
					iid= Integer.parseInt(id);
					sup_id = Integer.parseInt(sp_id);
					crt_stk = Integer.parseInt(ct_stk);
					prdct_unt = Long.parseLong(pt_unt);
					anual_cons = Integer.parseInt(al_cons);
					order_cost = Float.parseFloat(or_cost);
					stk_mant = Float.parseFloat(sk_mant);
					lt_size = Integer.parseInt(l_size);
					ld_tme = Long.parseLong(l_tme);
					prdct_price = prdct_unt * crt_stk;
					safty_stk = (ld_tme / 2) * (anual_cons / 300);
					crt_stk = crt_stk - safty_stk;
					eoq = Math.sqrt((2 * anual_cons * order_cost) + safty_stk);
					re_order = (lt_size * (anual_cons / 365) + safty_stk);
					no_odr = (int) Math.floor(re_order / lt_size);
					try {

						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);

						stmt = conn.createStatement();
						System.out.println("Connection is created successfully:");
						String sql;

						sql = "update item set sup_id=" + sup_id + ",item_name='" + name + "',item_des='" + des
								+ "',crt_stk=" + crt_stk + ",anual_cons=" + anual_cons + ",order_cost=" + order_cost
								+ ",prdct_unt=" + prdct_unt + ",prdct_price=" + prdct_price + ",load_time=" + ld_tme
								+ ",stck_mant=" + stk_mant + ",eoq=" + eoq + " ,re_order_lvl=" + re_order
								+ " ,safty_stk=" + safty_stk + " ,lt_siz=" + lt_size + " ,no_odr=" + no_odr
								+ " where item_id=" + iid;
						int rowCount = stmt.executeUpdate(sql);
						if(rowCount>0){
						System.out.println("Record is inserted in the table successfully..................");
						JOptionPane.showMessageDialog(null,
								"Record is updated in the table successfully..................");
						
						item insert = new item();
						insert.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null,
									"Item id does not exist in the table..................");
						}
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
					item itm = new item();
					itm.setVisible(true);
				}
				// System.out.println("Please check it in the MySQL
				// Table.........
				// ��..");

			}

		});
		btnUpdate.setBounds(706, 775, 177, 35);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				id = textField_10.getText();
				if (!id.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Item id cannot be in char or Null");
				} else {
					iid = Integer.parseInt(id);
					try {

						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);

						stmt = conn.createStatement();
						System.out.println("Connection is created successfully:");

						String sql;

						sql = "delete from item where  item_id=" + iid;
						int rowCount= stmt.executeUpdate(sql);
						if(rowCount>0) {
						JOptionPane.showMessageDialog(null,
								"Record is deleted from the table successfully..................");
						
						System.out.println("Connection is Deleted successfully:");
						item insert = new item();
						insert.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null,
									"Item ID does not exist in the table..................");
						}
					} catch (SQLException se) {
						// Handle errors for JDBC
						se.printStackTrace();
					} catch (Exception e1) {
						// Handle errors for Class.forName
						e1.printStackTrace();
					}
				}
				item itm = new item();
				itm.setVisible(true);
			}
		});
		btnDelete.setBounds(706, 875, 177, 35);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		contentPane.add(btnDelete);

		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				l_table();

			}
		});
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnLoadTable.setBounds(1633, 749, 177, 35);
		contentPane.add(btnLoadTable);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				id = sp_id = table.getValueAt(table.getSelectedRow(), 0).toString();
				sp_id = table.getValueAt(table.getSelectedRow(), 1).toString();
				name = table.getValueAt(table.getSelectedRow(), 2).toString();
				des = table.getValueAt(table.getSelectedRow(), 3).toString();
				ct_stk = table.getValueAt(table.getSelectedRow(), 4).toString();
				pt_unt = table.getValueAt(table.getSelectedRow(), 5).toString();
				al_cons = table.getValueAt(table.getSelectedRow(), 6).toString();
				or_cost = table.getValueAt(table.getSelectedRow(), 7).toString();
				sk_mant = table.getValueAt(table.getSelectedRow(), 8).toString();
				l_size = table.getValueAt(table.getSelectedRow(), 9).toString();
				l_tme = table.getValueAt(table.getSelectedRow(), 10).toString();
				textField.setText(sp_id);
				textField_1.setText(name);
				textField_2.setText(des);
				textField_3.setText(ct_stk);
				textField_4.setText(pt_unt);
				textField_5.setText(al_cons);
				textField_6.setText(or_cost);
				textField_7.setText(sk_mant);
				textField_8.setText(l_size);
				textField_9.setText(l_tme);
				textField_10.setText(id);
			}
		});
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setBounds(744, 128, 1066, 568);
		contentPane.add(table);
		
		textField_10 = new JTextField();
		textField_10.setBounds(370, 75, 116, 22);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		textField_10.setVisible(false);

	}

	public static int l_table() {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to databASe...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT item_id AS Item_ID, sup_id AS Supplier_ID, item_name AS Item_Name, item_des AS Item_Description, crt_stk AS Current_Stock, prdct_unt AS No_of_Units,"
					+ " anual_cons AS Annual_Consumption,order_cost AS Ordering_Cost, stck_mant AS Storage_and_Maintenance,lt_siz AS Lot_Size, load_time AS Load_Time,"
					+ " prdct_price AS Per_unit_Price, eoq AS Economic_Order_Quantity, re_order_lvl AS Reorder_Level, safty_stk AS Safty_Stock,  no_odr AS No_of_Order FROM item";
			ResultSet rs = stmt.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e1) {
			// Handle errors for ClASs.forName
			e1.printStackTrace();
		}
		return 0;
	}
}
