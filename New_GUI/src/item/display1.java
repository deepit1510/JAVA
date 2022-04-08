package item;

import frames.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class display1 extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display1 frame = new display1();
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
	public display1() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(0, 0, 0, 0);
		contentPane.add(table);
		table.setFont(new Font("Times New Roman", Font.BOLD, 25));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 88, 1825, 767);
		contentPane.add(scrollPane_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		scrollPane.setForeground(Color.RED);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		JButton btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setBounds(816, 905, 202, 63);
		btnPreviousMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_3_5 frame5 = new frame_3_5();
				frame5.setVisible(true);
			}
		});
		contentPane.add(btnPreviousMenu);

		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.setBounds(740, 6, 461, 69);
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				Statement stmt = null;

				try {

					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Connecting to databASe...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					System.out.println("Creating statement...");
					stmt = conn.createStatement();
					String sql;
					sql = "SELECT item_id AS Item_ID, sup_id AS Supplier_ID, item_name AS Item_Name, item_des AS Item_Description, crt_stk AS Current_Stock, anual_cons AS Annual_Consumption, "
							+ "order_cost AS Ordering_Cost, prdct_unt AS No_of_Units, prdct_price AS Per_unit_Price, load_time AS Load_Time,stck_mant AS Storage_and_Maintenance, "
							+ "eoq AS Economic_Order_Quantity, re_order_lvl AS Reorder_Level, safty_stk AS Safty_Stock, lt_siz AS Lot_Size, no_odr AS No_of_Order FROM item";
					ResultSet rs = stmt.executeQuery(sql);
					table_1.setModel(DbUtils.resultSetToTableModel(rs));

					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for ClASs.forName
					e1.printStackTrace();
				}
			}

		});
		contentPane.add(btnLoadTable);
	}
}
