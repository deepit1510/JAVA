package Item;

import java.sql.*;

public class item_display {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	public static void item_display() {
	//public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT item_id, sup_id, item_name, item_des, crt_stk, anual_cons, order_cost, prdct_unt,"
					+ "prdct_price, load_time, stck_mant, eoq ,re_order_lvl, safty_stk ,lt_siz,no_odr  FROM item";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("item_id");
				int sup_id = rs.getInt("sup_id");
				String name = rs.getString("item_name");
				String item_des = rs.getString("item_des");
				Long crt_stk = rs.getLong("crt_stk");
				Long anual_cons = rs.getLong("anual_cons");
				// Long order_cost = rs.getLong("order_cost");
				Long prdct_unt = rs.getLong("prdct_unt");
				Double order_cst = rs.getDouble("order_cost");
				Double prdct_price = rs.getDouble("prdct_price");
				Long load_time = rs.getLong("load_time");
				Double stck_mant = rs.getDouble("stck_mant");
				Double eoq = rs.getDouble("eoq");
				Long re_order = rs.getLong("re_order_lvl");
				Long safty_stk = rs.getLong("safty_stk");
				Long lt_size = rs.getLong("lt_siz");
				Long no_odr = rs.getLong("no_odr");

				System.out.print("Item ID: " + id);
				System.out.print(" Supplier ID: " + sup_id);
				System.out.print(" Item Name: " + name);
				System.out.print(" Item description: " + item_des);
				System.out.print("Curent Stock:" + crt_stk);
				System.out.print(" Anual consumption: " + anual_cons);
				System.out.print(" No. of units: " + prdct_unt);
				System.out.print(" Product price: " + prdct_price);
				System.out.println("Load time:" + load_time);
				System.out.println("Cost of the order" + order_cst);
				System.out.print(" Storage and Maintanence cost: " + stck_mant);
				System.out.print(" Economic order quantity: " + eoq);
				System.out.println(" Re-order level: " + re_order);
				System.out.println(" Safety stock:" + safty_stk);
				System.out.println(" Lot size:" + lt_size);
				System.out.println(" Number of orders:" + no_odr);

			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
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
	} // End method main
} // end class ClientBase