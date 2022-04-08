
import designer.*;

import java.util.*;
import product.*;
import customer.*;

public class main_page {

	static int choice;
	static int ch;
	static int ins;
	static int count = 0;
	static Scanner input;
	// static String a;

	product_insert insert_product = new product_insert();
	product_display display_product = new product_display();
	product_update update_product = new product_update();
	product_delete delete_product = new product_delete();
	// next is customer
	designer_delete delete_designer = new designer_delete();
	designer_display display_designer = new designer_display();
	designer_insert insert_designer = new designer_insert();
	designer_update update_designer = new designer_update();
	// next is customer
	customer_display display_customer = new customer_display();
	customer_insert insert_customer = new customer_insert();
	customer_update update_customer = new customer_update();
	customer_delete delete_customer = new customer_delete();
	
	
	public static void main_menu() {

		input = new Scanner(System.in);
		System.out.println("\t\t==FASHION STUDIO==");
		System.out.println("Select one:-");
		System.out.println("1) product Record");
		System.out.println("2) designer Record");
		System.out.println("3) customer Record");
		int ch = input.nextInt();
		switch (ch) {
		case 1:
			product();
break;
		case 2:
			designer();
			break;
		case 3:
	
		customer();
		break;
		
		}
	}

	public static void product() {
		input = new Scanner(System.in);
		System.out.println("Select one:-");
		System.out.println("1) Insert product Record");
		System.out.println("2) display product Record");
		System.out.println("3) update product Record");
		System.out.println("4) delete product Record");
		System.out.println("5) Main menu ");
		ch = input.nextInt();
		switch (ch) {
		case 1:
			product_insert.product_insert();
			product();
		case 2: {
			product_display.product_display();
			char y = 'y';
			while (y != 'y') {
				System.out.println("Do you want to return to the previous menu(y for 'Yes' and n for 'No'");
				y = input.next().charAt(0);
				if (y == 'y') {
					count = 1;
				}
			}
			if (count == 1) {
				product();
			}

		}product();
		case 3:
			product_update.product_update();
			product();
		case 4:
			product_delete.prroduct_delete();
			product();
			break;
		case 5:
			main_menu();
			break;
		}
	}

	public static void customer() {
		input = new Scanner(System.in);
		char y = 'y';
		System.out.println("Select one:-");
		System.out.println("1) Insert customer Record");
		System.out.println("2) display customer Record");
		System.out.println("3) update customer Record");
		System.out.println("4) delete customer Record");
		System.out.println("5) Main menu");
		ch = input.nextInt();
		switch (ch) {
		case 1:
			customer_insert.customer_insert();
			customer();
			// }break;
		case 2: {
			customer_display.customer_display();
			while (y != 'y') {
				System.out.println("Do you want to return to main menu(y for 'Yes' and n for 'No'");
				y = input.next().charAt(0);
				if (y == 'y') {
					count = 1;
				}
			}
			if (count == 1) {
				customer();
			}
		}customer();
		case 3: {
			customer_update.customer_update();
			customer();
		}
		case 4: {
			customer_delete.customer_delete();
			customer();
		}
		case 5:
			main_menu();

		}
	}

	public static void designer() {
		input = new Scanner(System.in);
		System.out.println("Select one:-");
		System.out.println("1) Insert designer Record");
		System.out.println("2) display designer Record");
		System.out.println("3) update designer Record");
		System.out.println("4) delete designer Record");
		System.out.println("5) Main menu");
		ch = input.nextInt();
		switch (ch) {
		case 1:
			designer_insert.designer_insert();
			designer();
		case 2: {
			designer_display.designer_display();
			char y = 'y';
			while (y != 'y') {
				System.out.println("Do you want to return to the previous menu(y for 'Yes' and n for 'No'");
				y = input.next().charAt(0);
				if (y == 'y') {
					count = 1;
				}
			}
			if (count == 1) {
				designer();
			}

		}
		case 3:
			designer_update.designer_update();
			designer();
		case 4:
			designer_delete.designer_delete();
			designer();
		case 5:
			main_menu();

		}
	}

	

	public static void main(String[] args) {
		main_menu();
	}

}
