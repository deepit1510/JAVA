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
//import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import javax.swing.JSpinner;
//import javax.swing.JFormattedTextField;

public class update_item extends JFrame {
	static String iid;
	static int id;
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
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_item frame = new update_item();
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
	public update_item() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInsertItem = new JLabel("Update Item");
		lblInsertItem.setForeground(Color.WHITE);
		lblInsertItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertItem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblInsertItem.setBounds(12, 33, 1878, 32);
		contentPane.add(lblInsertItem);

		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setForeground(Color.LIGHT_GRAY);
		lblSupplierId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblSupplierId.setBounds(39, 229, 136, 38);
		contentPane.add(lblSupplierId);

		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setForeground(Color.LIGHT_GRAY);
		lblItemName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblItemName.setBounds(39, 337, 127, 29);
		contentPane.add(lblItemName);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(259, 318, 187, 54);
		contentPane.add(textField_1);

		JLabel lblItemDescription = new JLabel("Item Description ");
		lblItemDescription.setForeground(Color.LIGHT_GRAY);
		lblItemDescription.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblItemDescription.setBounds(39, 420, 194, 27);
		contentPane.add(lblItemDescription);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(259, 414, 187, 47);
		contentPane.add(textField_2);

		JLabel lblNumberOfUnits = new JLabel("No. of units purchasesd ");
		lblNumberOfUnits.setForeground(Color.LIGHT_GRAY);
		lblNumberOfUnits.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNumberOfUnits.setBounds(978, 158, 265, 27);
		contentPane.add(lblNumberOfUnits);

		JLabel lblPerUnitPrice = new JLabel("Per unit price ");
		lblPerUnitPrice.setForeground(Color.LIGHT_GRAY);
		lblPerUnitPrice.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblPerUnitPrice.setBounds(975, 318, 163, 27);
		contentPane.add(lblPerUnitPrice);

		JLabel lblAnualConsumption = new JLabel("Anual Consumption");
		lblAnualConsumption.setForeground(Color.LIGHT_GRAY);
		lblAnualConsumption.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAnualConsumption.setBounds(975, 399, 254, 22);
		contentPane.add(lblAnualConsumption);

		JLabel lblOrderingCost = new JLabel("Ordering Cost");
		lblOrderingCost.setForeground(Color.LIGHT_GRAY);
		lblOrderingCost.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblOrderingCost.setBounds(39, 522, 163, 27);
		contentPane.add(lblOrderingCost);

		JLabel lblNewLabel = new JLabel("Storage & Maintainence cost ");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(978, 229, 337, 38);
		contentPane.add(lblNewLabel);

		JLabel lblLotSize = new JLabel("Lot Size");
		lblLotSize.setForeground(Color.LIGHT_GRAY);
		lblLotSize.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblLotSize.setBounds(56, 613, 112, 47);
		contentPane.add(lblLotSize);

		JLabel lblLeadTime = new JLabel("Lead Time");
		lblLeadTime.setForeground(Color.LIGHT_GRAY);
		lblLeadTime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblLeadTime.setBounds(56, 704, 130, 27);
		contentPane.add(lblLeadTime);

		JButton btnInsert = new JButton("Update");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				Statement stmt = null;
				Statement stmt1 = null;
				iid = textField_10.getText();
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
				if (!iid.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Item id cannot be null or in char");
				} else if (!sp_id.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Supplier id cannot be null or in char");
				} else if (!name.matches("[a-zA-Z ,0-9]+")) {
					JOptionPane.showMessageDialog(null, "Item name cannot be null");
				} else if (des.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Item description cannot be null");
				} else if (!ct_stk.trim().matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Number of unit purchsed cannot be null or in char");
				} else if (pt_unt.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Per unit price cannot be null");
				} else if (!al_cons.matches("[0-9,.]+")) {
					JOptionPane.showMessageDialog(null, "Annual Consumption cannot be null");
				} else if (!or_cost.matches("[0-9,.]+")) {
					JOptionPane.showMessageDialog(null, "Ordering Cost cannot be null");
				} else if (!sk_mant.matches("[0-9,.]+")) {
					JOptionPane.showMessageDialog(null, "Storage and maintanence cost cannot be null");
				} else if (!l_size.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Lot Size cannot be null");
				} else if (!l_tme.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Lead Time cannot be null");
				}

				else {
					try {
						id = Integer.parseInt(iid);
						sup_id = Integer.parseInt(sp_id);
						crt_stk = Integer.parseInt(ct_stk);
						prdct_unt = Long.parseLong(pt_unt);
						anual_cons = Integer.parseInt(al_cons);
						order_cost = Float.parseFloat(or_cost);
						stk_mant = Float.parseFloat(sk_mant);
						lt_size = Integer.parseInt(l_size);
						ld_tme = Long.parseLong(l_tme);
						prdct_price = prdct_unt;
						sales = prdct_price +prdct_price*.2;
						safty_stk = (ld_tme / 2) * (anual_cons / 300);
						crt_stk = crt_stk - safty_stk;
						eoq = Math.sqrt((2 * anual_cons * order_cost) + safty_stk);
						re_order = (lt_size * (anual_cons / 365) + safty_stk);
						no_odr = (int) Math.floor(re_order / lt_size);
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
								+",sales_price="+sales+" where item_id=" + id;
						stmt.executeUpdate(sql);
						String sql1;
						sql1 = "update sales_price set item_name='"+name+"',qty="+crt_stk+",sales_price="+prdct_price;
						stmt.executeUpdate(sql1);
						System.out.println("Record is inserted in the table successfully..................");
						JOptionPane.showMessageDialog(null,
								"Record is updated in the table successfully..................");
						update_item update = new update_item();
						update.setVisible(true);
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
					// System.out.println("Please check it in the MySQL
					// Table.........
					// ……..");

				}

			}
		});
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnInsert.setBounds(1253, 650, 193, 52);
		contentPane.add(btnInsert);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_item update = new update_item();
				update.setVisible(true);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnReset.setBounds(1253, 766, 193, 52);
		contentPane.add(btnReset);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(259, 228, 187, 48);
		contentPane.add(textField);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(1418, 138, 193, 47);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(1418, 311, 193, 49);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1418, 391, 193, 47);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(259, 512, 187, 54);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(1418, 229, 193, 47);
		contentPane.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(259, 617, 187, 47);
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(259, 698, 188, 47);
		contentPane.add(textField_9);

		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setForeground(Color.LIGHT_GRAY);
		lblItemId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblItemId.setBounds(39, 150, 112, 43);
		contentPane.add(lblItemId);

		textField_10 = new JTextField();
		textField_10.setBounds(259, 151, 187, 48);
		contentPane.add(textField_10);
		textField_10.setColumns(10);

		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_main_page frame2 = new admin_main_page();
				frame2.setVisible(true);
			}
		});
		btnNewButton.setBounds(743, 649, 193, 54);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Previous Menu");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item_main_menu frame3 = new item_main_menu();
				frame3.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(743, 766, 193, 52);
		contentPane.add(btnNewButton_1);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(127, 153, 23, 27);
		contentPane.add(label_1);

		JLabel label_1_1 = new JLabel("*");
		label_1_1.setForeground(Color.RED);
		label_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_1.setBounds(172, 227, 23, 27);
		contentPane.add(label_1_1);

		JLabel label_1_2 = new JLabel("*");
		label_1_2.setForeground(Color.RED);
		label_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_2.setBounds(172, 331, 23, 27);
		contentPane.add(label_1_2);

		JLabel label_1_3 = new JLabel("*");
		label_1_3.setForeground(Color.RED);
		label_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_3.setBounds(234, 414, 23, 27);
		contentPane.add(label_1_3);

		JLabel label_1_4 = new JLabel("*");
		label_1_4.setForeground(Color.RED);
		label_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_4.setBounds(201, 512, 23, 27);
		contentPane.add(label_1_4);

		JLabel label_1_5 = new JLabel("*");
		label_1_5.setForeground(Color.RED);
		label_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_5.setBounds(149, 613, 23, 27);
		contentPane.add(label_1_5);

		JLabel label_1_6 = new JLabel("*");
		label_1_6.setForeground(Color.RED);
		label_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_6.setBounds(179, 693, 23, 27);
		contentPane.add(label_1_6);

		JLabel label_1_7 = new JLabel("*");
		label_1_7.setForeground(Color.RED);
		label_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_7.setBounds(1246, 153, 23, 27);
		contentPane.add(label_1_7);

		JLabel label_1_8 = new JLabel("*");
		label_1_8.setForeground(Color.RED);
		label_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_8.setBounds(1304, 229, 23, 27);
		contentPane.add(label_1_8);

		JLabel label_1_9 = new JLabel("*");
		label_1_9.setForeground(Color.RED);
		label_1_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_9.setBounds(1131, 311, 23, 27);
		contentPane.add(label_1_9);

		JLabel label_1_10 = new JLabel("*");
		label_1_10.setForeground(Color.RED);
		label_1_10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1_10.setBounds(1197, 394, 23, 27);
		contentPane.add(label_1_10);
	}
}
