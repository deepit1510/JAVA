package supplier;

import item.*;
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

public class displays extends JFrame {
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
					displays frame = new displays();
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
	public displays() {
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 77, 1837, 826);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		JButton btnPreviousMenu = new JButton("Previous Menu");
		btnPreviousMenu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_3_5 frame3 = new frame_3_5();
				frame3.setVisible(true);
			}
		});
		btnPreviousMenu.setBounds(742, 945, 232, 47);
		contentPane.add(btnPreviousMenu);

		JButton btnLoadTable = new JButton("Load Table");
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection conn = null;
				Statement stmt = null;

				try {

					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Connecting to database...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					System.out.println("Creating statement...");
					stmt = conn.createStatement();
					String sql;
					sql = "SELECT * FROM supplier";
					ResultSet rs = stmt.executeQuery(sql);
					table_1.setModel(DbUtils.resultSetToTableModel(rs));

					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				}
			}

		});
		btnLoadTable.setBounds(791, 13, 344, 47);
		contentPane.add(btnLoadTable);
	}

}
