package a;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

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
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class supplier extends JFrame {
	static int sup_id;
	static String sp_id;
	static String sup_name;
	static String gst_no;
	static String sup_email;
	static String sup_adr;
	static String phon;
	static Long phn;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/new_system";
	static final String USER = "root";
	static final String PASS = "";
	private JTextField textField_4;
	private JTable table;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplier frame = new supplier();
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
	public supplier() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInsertSupplierRecord = new JLabel("Supplier");
		lblInsertSupplierRecord.setForeground(Color.WHITE);
		lblInsertSupplierRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertSupplierRecord.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblInsertSupplierRecord.setBounds(12, 36, 1878, 58);
		contentPane.add(lblInsertSupplierRecord);

		JLabel lblNewLabel = new JLabel("Supplier Name");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(99, 179, 132, 22);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(357, 168, 235, 49);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblSupplierEmail = new JLabel("Supplier E-mail");
		lblSupplierEmail.setForeground(Color.LIGHT_GRAY);
		lblSupplierEmail.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblSupplierEmail.setBounds(99, 276, 132, 22);
		contentPane.add(lblSupplierEmail);

		textField_1 = new JTextField();
		textField_1.setBounds(357, 260, 235, 58);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("GST No.");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(99, 374, 75, 22);
		contentPane.add(lblNewLabel_1);

		textField_2 = new JTextField();
		textField_2.setBounds(357, 363, 235, 49);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Supplier Address");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(99, 480, 142, 22);
		contentPane.add(lblNewLabel_2);

		JLabel lblSupplierPhoneNumber = new JLabel("Supplier Phone Number");
		lblSupplierPhoneNumber.setForeground(Color.LIGHT_GRAY);
		lblSupplierPhoneNumber.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblSupplierPhoneNumber.setBounds(99, 595, 201, 22);
		contentPane.add(lblSupplierPhoneNumber);

		textField_3 = new JTextField();
		textField_3.setBounds(357, 579, 235, 58);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				phn = Long.parseLong(textField_4.getText());
				sup_name = textField.getText();
				sup_email = textField_1.getText();
				gst_no = textField_2.getText();
				sup_adr = textField_3.getText();
				phon = textField_4.getText();
				if (!sup_name.matches("[a-zA-Z ,]+")) {
					JOptionPane.showMessageDialog(null, "Supplier name cannot be null");
				} else if (sup_email.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Supplier Email cannot be null");
				} else if (gst_no.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "GST number cannot be null");
				} else if (sup_adr.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Supplier address cannot be null");
				} else if (!phon.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Supplier phone number cannot be null");
				}

				else {
					double phn = Double.parseDouble(phon);
					try {

						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);
						stmt = conn.createStatement();
						System.out.println("Connection is created successfully:");
						String sql;

						sql = "insert into supplier(sup_name, sup_email, gst_no, sup_address, sup_phn) values('"
								+ sup_name + "','" + sup_email + "','" + gst_no + "','" + sup_adr + "'," + phn + ")";
						int rowCount = stmt.executeUpdate(sql);
						if(rowCount>0){
						System.out.println("Record is inserted in the table successfully..................");
						JOptionPane.showMessageDialog(null, "Record inserted");
						supplier spl = new supplier();
						spl.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Record can not be inserted");
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
				}
			}
		});
		btnInsert.setBounds(99, 787, 199, 49);
		contentPane.add(btnInsert);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supplier update = new supplier();
				update.setVisible(true);
			}
		});
		btnReset.setBounds(101, 898, 199, 49);
		contentPane.add(btnReset);

		JButton btnM = new JButton("Main Login");
		btnM.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame2 = new Login();
				frame2.setVisible(true);
			}
		});
		btnM.setBounds(443, 901, 205, 42);
		contentPane.add(btnM);

		JButton btnNewButt = new JButton("Previous Menu");
		btnNewButt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnNewButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				record_menu menu = new record_menu();
				menu.setVisible(true);
			}
		});
		btnNewButt.setBounds(449, 790, 199, 42);
		contentPane.add(btnNewButt);

		textField_4 = new JTextField();
		textField_4.setBounds(357, 80, 235, 49);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setVisible(false);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(218, 168, 23, 37);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel(" *");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_2.setBounds(218, 249, 23, 52);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_3.setBounds(168, 363, 23, 27);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_4.setBounds(235, 475, 23, 27);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_5.setBounds(291, 584, 23, 22);
		contentPane.add(label_5);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sp_id = table.getValueAt(table.getSelectedRow(), 0).toString();
				sup_name = table.getValueAt(table.getSelectedRow(), 1).toString();
				sup_email = table.getValueAt(table.getSelectedRow(), 2).toString();
				gst_no = table.getValueAt(table.getSelectedRow(), 3).toString();
				sup_adr = table.getValueAt(table.getSelectedRow(), 4).toString();
				phon = table.getValueAt(table.getSelectedRow(), 5).toString();
				textField_4.setText(sp_id);
				textField.setText(sup_name);
				textField_1.setText(sup_email);
				textField_2.setText(gst_no);
				textField_5.setText(sup_adr);
				textField_3.setText(phon);
			}
		});
		table.setBounds(721, 157, 1059, 591);
		contentPane.add(table);

		JButton btnLoadTable = new JButton("Load Table");
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
					table.setModel(DbUtils.resultSetToTableModel(rs));

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
		btnLoadTable.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnLoadTable.setBounds(1581, 787, 199, 42);
		contentPane.add(btnLoadTable);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(357, 450, 235, 87);
		contentPane.add(textField_5);

		JButton btnInsert_1 = new JButton("Update");
		btnInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				sp_id = textField_4.getText();
				sup_name = textField.getText();
				sup_email = textField_1.getText();
				gst_no = textField_2.getText();
				sup_adr = textField_5.getText();
				phon = textField_3.getText();
				if (!sp_id.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Supplier id cannot be null or in char");
				} else if (!sup_name.matches("[a-zA-Z ,]+")) {
					JOptionPane.showMessageDialog(null, "Supplier name cannot be null");
				} else if (sup_email.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Supplier Email cannot be null");
				} else if (gst_no.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "GST number cannot be null");
				} else if (sup_adr.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Supplier address cannot be null");
				} else if (!phon.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Supplier phone number cannot be null");
				} else {
					try {
						phn = Long.parseLong(phon);
						sup_id = Integer.parseInt(sp_id);
						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);

						stmt = conn.createStatement();
						System.out.println("Connection is created successfully:");
						String sql;

						sql = "update supplier set sup_name='" + sup_name + "',sup_email='" + sup_email + "',gst_no='"
								+ gst_no + "',sup_address='" + sup_adr + "',sup_phn=" + phn + " where sup_id=" + sup_id;
						int rowCount = stmt.executeUpdate(sql);
						if(rowCount>0){
						System.out.println("Record is inserted in the table successfully..................");
						JOptionPane.showMessageDialog(null, "Supplier record updated");
						supplier update = new supplier();
						update.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Supplier ID does not exist................");
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
				}
			}
		});
		btnInsert_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnInsert_1.setBounds(778, 787, 199, 49);
		contentPane.add(btnInsert_1);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				sp_id = textField_4.getText();
				if (!sp_id.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Supplier id cannot be null or in char");
				} else {
					sup_id = Integer.parseInt(textField_4.getText());
				}
				try {

					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					stmt = conn.createStatement();
					System.out.println("Connection is created successfully:");

					String sql;

					sql = "delete from supplier where  sup_id=" + sup_id;
					int rowCount = stmt.executeUpdate(sql);
					if(rowCount>0) {
					System.out.println("Connection is Deleted successfully:");
					JOptionPane.showMessageDialog(null, "Record deleted from the table successfully..................");
					supplier spl = new supplier();
					spl.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Supplier ID does not exist..................");
					}
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				}
				supplier spl = new supplier();
				spl.setVisible(true);
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnDelete.setBounds(778, 898, 199, 49);
		contentPane.add(btnDelete);
	}
}
