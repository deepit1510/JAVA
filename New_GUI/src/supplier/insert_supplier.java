package supplier;

import frames.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class insert_supplier extends JFrame {
	static String sup_name;
	static String gst_no;
	static String sup_email;
	static String sup_adr;
	static String phon;
	static double phn;
	// static boolean isBlank();

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert_supplier frame = new insert_supplier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * private void makeFrameFullSize(JFrame aFrame) { Dimension screenSize =
	 * Toolkit.getDefaultToolkit().getScreenSize();
	 * aFrame.setSize(screenSize.width, screenSize.height); }
	 */

	/**
	 * Create the frame.
	 */
	public insert_supplier() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInsertSupplierRecord = new JLabel("Insert Supplier Record");
		lblInsertSupplierRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertSupplierRecord.setForeground(Color.WHITE);
		lblInsertSupplierRecord.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblInsertSupplierRecord.setBounds(12, 31, 1878, 39);
		contentPane.add(lblInsertSupplierRecord);

		JLabel lblNewLabel = new JLabel("Supplier Name");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(86, 213, 132, 22);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(309, 203, 207, 47);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblSupplierEmail = new JLabel("Supplier E-mail");
		lblSupplierEmail.setForeground(Color.LIGHT_GRAY);
		lblSupplierEmail.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblSupplierEmail.setBounds(86, 315, 143, 22);
		contentPane.add(lblSupplierEmail);

		textField_1 = new JTextField();
		textField_1.setBounds(309, 305, 207, 47);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("GST No.");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(86, 442, 89, 22);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Supplier Address");
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(86, 545, 142, 22);
		contentPane.add(lblNewLabel_2);

		JLabel lblSupplierPhoneNumber = new JLabel("Supplier Phone Number");
		lblSupplierPhoneNumber.setForeground(Color.LIGHT_GRAY);
		lblSupplierPhoneNumber.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblSupplierPhoneNumber.setBounds(86, 636, 186, 22);
		contentPane.add(lblSupplierPhoneNumber);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(309, 384, 207, 84);
		contentPane.add(scrollPane);

		textField_2 = new JTextField();
		scrollPane.setViewportView(textField_2);
		textField_2.setColumns(10);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
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
						stmt.executeUpdate(sql);
						System.out.println("Record is inserted in the table successfully..................");
						JOptionPane.showMessageDialog(null, "Record inserted");
						insert_supplier insert = new insert_supplier();
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
			}
		});
		btnInsert.setBounds(1297, 315, 186, 55);
		contentPane.add(btnInsert);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnReset.setBounds(1291, 407, 192, 55);
		contentPane.add(btnReset);

		JButton btnM = new JButton("Main Menu");
		btnM.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_2 frame2 = new frame_2();
				frame2.setVisible(true);
			}
		});
		btnM.setBounds(1288, 603, 195, 55);
		contentPane.add(btnM);

		JButton btnNewButt = new JButton("Previous Menu");
		btnNewButt.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnNewButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_3_2 frame3 = new frame_3_2();
				frame3.setVisible(true);
			}
		});
		btnNewButt.setBounds(1291, 500, 192, 61);
		contentPane.add(btnNewButt);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(309, 625, 207, 48);
		contentPane.add(textField_4);

		JLabel label = new JLabel("*");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label.setForeground(Color.RED);
		label.setBounds(208, 203, 23, 27);
		contentPane.add(label);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_1.setBounds(208, 305, 23, 27);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_2.setBounds(158, 437, 23, 27);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_3.setBounds(219, 540, 23, 27);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		label_4.setBounds(263, 635, 23, 27);
		contentPane.add(label_4);

		textField_3 = new JTextField();
		textField_3.setBounds(309, 513, 205, 82);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
