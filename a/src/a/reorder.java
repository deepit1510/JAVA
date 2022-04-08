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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class reorder extends JFrame {
	static String sup_email;
	static int id;
	static String sid;
	static int sup_id;
	static String tdate;
	static String item_name;
	static double eoq;

	private JPanel contentPane;
	private JTextField textField;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/new_system";
	static final String USER = "root";
	static final String PASS = "";
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reorder frame = new reorder();
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
	public reorder() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblInsertreorderRecord = new JLabel("Reorder");
		lblInsertreorderRecord.setForeground(Color.WHITE);
		lblInsertreorderRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertreorderRecord.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblInsertreorderRecord.setBounds(12, 36, 1878, 58);
		contentPane.add(lblInsertreorderRecord);

		JLabel lblNewLabel = new JLabel("reorder ID");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(99, 179, 132, 22);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(357, 168, 235, 49);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnInsert = new JButton("Reorder Item");
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				tdate = formatter.format(date);
				System.out.println(tdate);
				try {

					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Connecting to database...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					System.out.println("Creating statement...");
					stmt = conn.createStatement();
					Statement stmt1 = conn.createStatement();
					String sql;
					sql = "SELECT item_id, item_name, sup_id, eoq  FROM item where crt_stk <= re_order_lvl";
					ResultSet rs = stmt.executeQuery(sql);

					while (rs.next()) {
						JOptionPane.showMessageDialog(null, "Reordering Item.....");
						id = rs.getInt("item_id");
						sup_id = rs.getInt("sup_id");
						item_name = rs.getString("item_name");
						eoq = rs.getDouble("eoq");
						String sql1;
						sql1 = "SELECT sup_email from supplier where sup_id=" + sup_id;
						ResultSet rs1 = stmt.executeQuery(sql1);
						while (rs1.next()) {
							sup_email = rs1.getString("sup_email");
						}
						sende(sup_email, id, item_name, eoq);
						// rs1.close();
						// stmt = conn.createStatement();
						String sql2;
						sql2 = "Insert into re_order(sup_id, item_id, odr_date) values(" + sup_id + "," + id + ",'"
								+ tdate + "')";
						stmt.executeUpdate(sql2);
						rs1.close();
						// stmt.close();
					}
					// rs1.close();
					rs.close();
					stmt.close();
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				} finally {
					// finally block used to close resources
					try {
						if (stmt != null)
							stmt.close();
					} catch (SQLException se) {
						se.printStackTrace();
					} // end finally
				} // end try
				System.out.println("Goodbye.");
				JOptionPane.showMessageDialog(null, "Items Reordered");
			}
		});
		btnInsert.setBounds(99, 787, 199, 49);
		contentPane.add(btnInsert);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reorder update = new reorder();
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

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Order ID ", "Supplier ID", "Item ID", "Order Date"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String sid = table.getValueAt(table.getSelectedRow(), 0).toString();
				
				textField.setText(sid);
				
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
					sql = "SELECT * FROM re_order";
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

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				Statement stmt = null;
				sid = textField.getText();
				if (!sid.matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "reorder id cannot be null or in char");
				} else {
					id = Integer.parseInt(textField.getText());
				}
				try {

					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					stmt = conn.createStatement();
					System.out.println("Connection is created successfully:");

					String sql;

					sql = "delete from re_order where  odr_id=" + id;
					int rowCount = stmt.executeUpdate(sql);
					if(rowCount>0) {
					System.out.println("Connection is Deleted successfully:");
					JOptionPane.showMessageDialog(null, "Record deleted from the table successfully..................");
					reorder spl = new reorder();
					spl.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Record ID does not exist in the table successfully..................");
					}
				} catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e1) {
					// Handle errors for Class.forName
					e1.printStackTrace();
				}
				reorder spl = new reorder();
				spl.setVisible(true);
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnDelete.setBounds(778, 898, 199, 49);
		contentPane.add(btnDelete);
	}
	public static void sende(String sup_email, int item_id, String item_name, Double eoq) {
		String host = "smtp.gmail.com";
		final String user = "deepitaggarwal@gmail.com";
		final String password = "deepit1234";// change accordingly

		String to = sup_email;// change accordingly
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.port", 587);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Placing an order");
			message.setText("We are here by placing an order for the quantity equivalent to " + eoq + "for item id:-"
					+ item_id + "and item name:-" + item_name);

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}

