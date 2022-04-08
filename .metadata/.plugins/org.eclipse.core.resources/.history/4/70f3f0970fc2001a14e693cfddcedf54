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

public class sales extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		textField.setBounds(108, 153, 128, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblItemName.setBounds(370, 115, 95, 25);
		contentPane.add(lblItemName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(356, 153, 128, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblQuantity.setBounds(592, 115, 77, 25);
		contentPane.add(lblQuantity);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(615, 152, 43, 37);
		contentPane.add(spinner);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblPrice.setBounds(804, 115, 56, 16);
		contentPane.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(770, 153, 116, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total Price");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblTotal.setBounds(999, 111, 96, 25);
		contentPane.add(lblTotal);
		
		textField_3 = new JTextField();
		textField_3.setBounds(987, 153, 128, 34);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTotal_1 = new JLabel("Total Price");
		lblTotal_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblTotal_1.setBounds(1608, 80, 96, 25);
		contentPane.add(lblTotal_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(1588, 118, 138, 40);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPay = new JLabel("Paid Price");
		lblPay.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblPay.setBounds(1608, 191, 91, 25);
		contentPane.add(lblPay);
		
		textField_5 = new JTextField();
		textField_5.setBounds(1588, 240, 138, 36);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblBalance.setBounds(1620, 307, 72, 25);
		contentPane.add(lblBalance);
		
		textField_6 = new JTextField();
		textField_6.setBounds(1588, 355, 138, 37);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnPrintBill = new JButton("Print Bill");
		btnPrintBill.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		btnPrintBill.setBounds(1600, 440, 115, 33);
		contentPane.add(btnPrintBill);
		
		JLabel lblItemId = new JLabel("Item ID");
		lblItemId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblItemId.setBounds(130, 106, 86, 34);
		contentPane.add(lblItemId);
	}
}
