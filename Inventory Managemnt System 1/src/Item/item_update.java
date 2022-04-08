package Item;

import java.sql.*;
import java.util.Scanner;

public class item_update {
	static int iid;
	static int sup_id;
	static String name;
	static String des;
	static long crt_stk;
	static long anual_cons;
	static double order_cost;
	static double prdct_unt;
	static double prdct_price;
	static double stk_mant;
	static double eoq;
	static long re_order;
	static long safty_stk;
	static long lt_size;
	static long no_odr;
	static int ld_tme;
	static Scanner input;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/inventory_control_management";
	static final String USER = "root";
	static final String PASS = "";

	public static void item_update() {
		Connection conn = null;
		Statement stmt = null;
		char y = 'y';
		char b = 'y';
		char a = 'y';
		input = new Scanner(System.in);
		while (y == 'y') {
			System.out.println("Enter the item id:");
			String id1 = input.next();
			if (!id1.matches("[0-9]+")) {
				b = 'n';
			} else {
				iid = Integer.parseInt(id1);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the item id:");
				id1 = input.next();
				if (!id1.matches("[0-9]+")) {
					b = 'n';
				} else {
					b = 'y';
					iid = Integer.parseInt(id1);
				}
			}
			System.out.println("Enter the supplier id:");
			String id = input.next();
			if (!id.matches("[0-9]+")) {
				b = 'n';
			} else {
				sup_id = Integer.parseInt(id);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the supplier id:");
				id = input.next();
				if (!id.matches("[0-9]+")) {
					b = 'n';
				} else {
					b = 'y';
					sup_id = Integer.parseInt(id);
				}
			}
			System.out.println("Enter the item name:");
			name = input.next();
			if (!name.matches("[A-Za-z]+")) {
				b = 'n';
			}
			while (b == 'n') {
				System.out.println("Re-Enter the item name:");
				name = input.next();
				if (!name.matches("[A-Za-z]+")) {
					b = 'n';
				} else {
					b = 'y';
				}
			}
			System.out.println("Enter the item description:");
			des = input.next();
			if (!des.matches("[A-Za-z]+")) {
				b = 'n';
			}
			while (b == 'n') {
				System.out.println("Re-Enter the item des:");
				des = input.next();
				if (!des.matches("[A-Za-z]+")) {
					b = 'n';
				} else {
					b = 'y';
				}
			}
			System.out.println("Enter the number of units purchased");
			String cstk = input.next();
			if (!cstk.matches("[0-9]+")) {
				b = 'n';
			} else {
				crt_stk = Integer.parseInt(cstk);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the number of units purchased:");
				cstk = input.next();
				if (!cstk.matches("[0-9]+")) {
					b = 'n';
				} else {
					b = 'y';
					crt_stk = Integer.parseInt(cstk);
				}
			}
			System.out.println("Enter the per unit price");
			String pp = input.next();
			if (!pp.matches("[0-9,.]+")) {
				b = 'n';
			} else {
				prdct_unt = Double.parseDouble(pp);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the per unit price:");
				cstk = input.next();
				if (!cstk.matches("[0-9,.]+")) {
					b = 'n';
				} else {
					b = 'y';
					prdct_unt = Double.parseDouble(pp);
				}
			}
			prdct_price = prdct_unt * crt_stk;
			System.out.println("Enter the anual consuption:");
			String ac = input.next();
			if (!ac.matches("[0-9]+")) {
				b = 'n';
			} else {
				anual_cons = Long.parseLong(ac);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the per unit price:");
				ac = input.next();
				if (!ac.matches("[0-9]+")) {
					b = 'n';
				} else {
					b = 'y';
					anual_cons = Long.parseLong(ac);
				}
			}

			System.out.println("Enter the ordering cost:");
			String oc = input.next();
			if (!oc.matches("[0-9,.]+")) {
				b = 'n';
			} else {
				order_cost = Double.parseDouble(oc);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the ordering cost:");
				oc = input.next();
				if (!oc.matches("[0-9,.]+")) {
					b = 'n';
				} else {
					b = 'y';
					order_cost = Double.parseDouble(oc);
				}
			}
			System.out.println("Enter the storage and maintainence cost:");
			String sm = input.next();
			if (!sm.matches("[0-9,.]+")) {
				b = 'n';
			} else {
				stk_mant = Double.parseDouble(sm);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the storage and maintainence cost:");
				sm = input.next();
				if (!sm.matches("[0-9,.]+")) {
					b = 'n';
				} else {
					b = 'y';
					stk_mant = Double.parseDouble(sm);
				}
			}
			System.out.println("Enter the lot size:");
			//lt_size = input.nextLong();
			String ls = input.next();
			if (!ls.matches("[0-9]+")) {
				b = 'n';
			} else {
				lt_size = Long.parseLong(ls);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the lot size:");
				ls = input.next();
				if (!ls.matches("[0-9]+")) {
					b = 'n';
				} else {
					b = 'y';
					lt_size = Long.parseLong(ls);
				}
			}

			System.out.println("Enter the lead time:");
			// ld_tme = input.nextInt();
			String lt = input.next();
			if (!lt.matches("[0-9]+")) {
				b = 'n';
			} else {
				ld_tme = Integer.parseInt(lt);
			}
			while (b == 'n') {
				System.out.println("Re-Enter the lead time:");
				lt = input.next();
				if (!lt.matches("[0-9]+")) {
					b = 'n';
				} else {
					b = 'y';
					ld_tme = Integer.parseInt(lt);
				}
			}
			safty_stk = (ld_tme / 2) * (anual_cons / 300);
			crt_stk = crt_stk - safty_stk;
			eoq = Math.floor(Math.sqrt((2 * anual_cons * order_cost) + safty_stk));
			
			re_order = (lt_size * (anual_cons / 365) + safty_stk);
			no_odr = (int) Math.floor(re_order / lt_size);

			try {

				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				stmt = conn.createStatement();
				System.out.println("Connection is created successfully:");

				String sql;
				sql = "update item set sup_id=" + sup_id + ",item_name='" + name + "',item_des='" + des + "',crt_stk="
						+ crt_stk + ",annual_cons=" + anual_cons + ",order_cost=" + order_cost + ",prdct_unt="
						+ prdct_unt + ",prdct_price=" + prdct_price + ",load_time=" + ld_tme + ",stck_mant=" + stk_mant
						+ ",eoq=" + eoq + ",re_order_lvl=" + re_order + ",safty_stk=" + safty_stk + ",lt_siz=" + lt_size
						+ ",no_odr=" + no_odr + " WHERE item_id = " + iid;
				
				/*sql = "insert into item(sup_id,item_name,item_des,crt_stk,anual_cons,order_cost,prdct_unt,prdct_price,load_time,"
						+ "stck_mant,eoq,re_order_lvl,safty_stk,lt_siz,no_odr) values(" + sup_id + ",'" + name + "','"
						+ des + "'," + crt_stk + "," + anual_cons + "," + order_cost + "," + prdct_unt + ","
						+ prdct_price + "," + ld_tme + "," + stk_mant + "," + eoq + "," + re_order + "," + safty_stk
						+ "," + lt_size + "," + no_odr + ")";*/
				stmt.executeUpdate(sql);

				System.out.println("Connection is Updated successfully:");

			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
			// System.out.println("Goodbye!");
			System.out.println("Do you want to update more record(y for 'Yes' and n for 'No'");
			y = input.next().charAt(0);
		}
	}
}