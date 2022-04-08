package Invoice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class sales extends JFrame {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/new_system";
	static final String USER = "root";
	static final String PASS = "";
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	
	static String item_name ;
	static int qty;
	static float price;
	static float total_price;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sales frame = new sales();
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
	@SuppressWarnings("serial")
	public sales() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 0, 0);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(5, 153, 979, -139);
		verticalBox.setBackground(Color.BLUE);
		contentPane.add(verticalBox);
		
		textField = new JTextField();
		textField.setForeground(Color.YELLOW);
		textField.setBackground(Color.BLACK);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent e) {
				//textField_1.setText("item_name");
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				java.sql.Connection conn = null;
				java.sql.Statement stmt = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Connecting to databASe...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					System.out.println("Creating statement...");
					stmt = conn.createStatement();
				int item_id = Integer.parseInt(textField.getText());
				String sql = "Select * from sales_price where item_id="+item_id;
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					String item_name = rs.getString("item_name");
					String item_price = rs.getString("sales_price");
					textField_1.setText(item_name);
					textField_2.setText(item_price);
					
					
				}
				
				}catch (SQLException se) {
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
				}// end try
				}
				else {
					JOptionPane.showMessageDialog(null,"Item ID not found..................");
				}
			}
		});
		
		
		
		
		textField.setBounds(108, 182, 128, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setForeground(Color.LIGHT_GRAY);
		lblItemName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblItemName.setBounds(347, 123, 95, 25);
		contentPane.add(lblItemName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 182, 128, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(Color.LIGHT_GRAY);
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblQuantity.setBounds(591, 123, 77, 25);
		contentPane.add(lblQuantity);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int qty = Integer.parseInt(spinner.getValue().toString());
				Double price = Double.parseDouble(textField_2.getText());
				Double t_price = qty *price;
				String total = Double.toString(t_price);
				textField_3.setText(total);
			}
		});
		spinner.setBounds(612, 179, 43, 37);
		contentPane.add(spinner);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.LIGHT_GRAY);
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblPrice.setBounds(802, 127, 56, 16);
		contentPane.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(770, 184, 116, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total Price");
		lblTotal.setForeground(Color.LIGHT_GRAY);
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblTotal.setBounds(997, 123, 96, 25);
		contentPane.add(lblTotal);
		
		textField_3 = new JTextField();
		textField_3.setBounds(987, 182, 128, 34);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setForeground(Color.LIGHT_GRAY);
		lblItemId.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblItemId.setBounds(118, 117, 106, 52);
		contentPane.add(lblItemId);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Item ID", "Item Name", "Quantity", "Per Unit Cost", "Total Price"},
			},
			new String[] {
				"Item ID", "Item Name", "Quantity", "Per unit Price", "Total Price"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(71, 379, 1336, 578);
		contentPane.add(table);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel();
				model = (DefaultTableModel)table.getModel();
				model.addRow(new Object[]{
						textField.getText(),
						textField_1.getText(),
						spinner.getValue().toString(),
						textField_2.getText(),
						textField_3.getText().toString(),
				});
				int t_total =0;
				for(int i=0;i<table.getRowCount();i++) {
					t_total = t_total + Integer.parseInt(table.getValueAt(i,4).toString());
				}
				textField_4.setText(Integer.toString(t_total));
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				spinner.requestFocus();
				
				
				
			}
		});
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		btnAdd.setBounds(997, 275, 118, 37);
		contentPane.add(btnAdd);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
		layeredPane.setBackground(Color.RED);
		layeredPane.setBounds(75, 61, 1134, 289);
		contentPane.add(layeredPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(Color.BLUE));
		layeredPane_1.setBounds(1499, 61, 318, 481);
		contentPane.add(layeredPane_1);
		
		JLabel lblTotal_1 = new JLabel("Total Price");
		lblTotal_1.setBounds(104, 66, 96, 25);
		layeredPane_1.add(lblTotal_1);
		lblTotal_1.setForeground(Color.LIGHT_GRAY);
		lblTotal_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 108, 138, 40);
		layeredPane_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(92, 216, 138, 36);
		layeredPane_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(92, 315, 138, 37);
		layeredPane_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblPay = new JLabel("Paid Price");
		lblPay.setBounds(104, 178, 91, 25);
		layeredPane_1.add(lblPay);
		lblPay.setForeground(Color.LIGHT_GRAY);
		lblPay.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(119, 277, 72, 25);
		layeredPane_1.add(lblBalance);
		lblBalance.setForeground(Color.LIGHT_GRAY);
		lblBalance.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		
		JButton btnPrintBill = new JButton("Print Bill");
		btnPrintBill.setBounds(43, 411, 115, 33);
		layeredPane_1.add(btnPrintBill);
		btnPrintBill.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		btnReset.setBounds(195, 411, 97, 32);
		layeredPane_1.add(btnReset);
	}
}
