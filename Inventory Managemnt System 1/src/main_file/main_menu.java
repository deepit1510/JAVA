package main_file;
import java.util.*;
import main_file.front_file;
import Reorder.*;
import Item.*;
import supplier.*;

public class main_menu {
	static Scanner input;
	static int choice;
	static int ch;
	static int ins;
	static String op = "Null";
	static char esc = 27;
	static String clear = esc + "[2J";
	

	item_insert iinsert = new item_insert();
	item_update iupdate = new item_update();
	item_delete idelete = new item_delete();
	item_display idisplay = new item_display();

	supplier_insert sinsert = new supplier_insert();
	supplier_update supdate = new supplier_update();
	supplier_delete sdelete = new supplier_delete();
	supplier_display sdisplay = new supplier_display();
	
	SendEmail rreorder = new SendEmail();
	static reorder_display reorder_display = new reorder_display();
	static delete_reorder reorder_delete = new delete_reorder();
	
	
	public static void item() {
		System.out.println("!!--------Item--------!!");
		System.out.println("Select the choice");
		System.out.println("1. Insert Item");
		System.out.println("2. Dispaly Item");
		System.out.println("3. Update Item");
		System.out.println("4. Delete Item");
		System.out.println("5. Main Menu");
		System.out.println("Enter the choice:");
		ch = input.nextInt();
		if (ch == 1) {
			System.out.println("Choose the option:");
			System.out.println("1. New Supplier");
			System.out.println("2. Existing supplier");
			System.out.println("Enter the choice:");
			ins = input.nextInt();
			if (ins == 1) {
				supplier_insert.supplier_insert();
				System.out.print(clear);
				item_insert.item_insert();
				System.out.print(clear);
				item();
			} else if (ins == 2)
				item_insert.item_insert();
			System.out.print(clear);
			item();

		} else if (ch == 2) {
			item_display.item_display();
			System.out.println("Press any aplhabet to return to the menu");
			op = input.next();
			System.out.print(clear);
			while(op != "Null"){
				item();
			}
		} else if (ch == 3) {
			item_update.item_update();
			System.out.print(clear);
			item();
		} else if (ch == 4) {
			item_delete.item_delete();
			System.out.print(clear);
			item();
		} else {
			System.out.print(clear);
			main_page();
		}
	}

	public static void supplier() {
		System.out.println("!!--------Supplier--------!!");
		System.out.println("Select the choice");
		System.out.println("1. Insert Supplier");
		System.out.println("2. Display Supplier");
		System.out.println("3. Update Supplier");
		System.out.println("4. Delete Supplier");
		System.out.println("5. Main Menu");
		System.out.println("Enter the choice:");
		ins = input.nextInt();
		if (ins == 1) {
			supplier_insert.supplier_insert();
			System.out.print(clear);
			supplier();
		} else if (ins == 2) {
			supplier_display.supplier_display();
			
			System.out.println("Press any aplhabet to return to the menu");
			op = input.next();
			System.out.print(clear);
			while(op != "Null"){
				supplier();
			}
		} else if (ins == 3) {
			supplier_update.supplier_update();
			System.out.print(clear);
			supplier();
		} else if (ins == 4) {
			supplier_delete.supplier_delete();
			System.out.print(clear);
			supplier();
		} else {
			System.out.print(clear);
			main_page();
		}
	}

	public static void reorder() {
		System.out.println("!!--------Reorder--------!!");
		System.out.println("Select the choice");
		System.out.println("1. Reorder Item");
		System.out.println("2. Display Reordered Item");
		System.out.println("3. Delete Reorder Item");
		System.out.println("4. Main Menu");
		System.out.println("Enter the choice:");
		ins = input.nextInt();
		if (ins == 1) {
			SendEmail.reorder();
			reorder();
		} else if (ins == 2) {
			Reorder.reorder_display.reorder_display();
			
			System.out.println("Press any aplhabet to return to the menu");
			op = input.next();
			System.out.print(clear);
			while(op != "Null"){
				reorder();
			}
		} else if (ins == 3) {
			delete_reorder.reorder_delete();
			System.out.print(clear);
			reorder();
		} else {
			System.out.print(clear);
			main_page();
		}
	}
	
	public static void guest() {
		Scanner input = new Scanner(System.in);
		System.out.println("!!--------Guest--------!!");
		System.out.println("Select the choice");
		System.out.println("1. Display Items");
		System.out.println("2. Display Supplier");
		System.out.println("3. Display Reordered Item");
		System.out.println("4. Login");
		System.out.println("Enter the choice:");
		ins = input.nextInt();
		if (ins == 1) {
			item_display.item_display();
			System.out.println("Press any aplhabet to return to the menu");
			op = input.next();
			System.out.print(clear);
			while(op != "Null"){
				guest();
			}
		} else if (ins == 2) {
supplier_display.supplier_display();
			
			System.out.println("Press any aplhabet to return to the menu");
			op = input.next();
			System.out.print(clear);
			while(op != "Null"){
				guest();
			}
		} else if (ins == 3) {
Reorder.reorder_display.reorder_display();
			
			System.out.println("Press any aplhabet to return to the menu");
			op = input.next();
			System.out.print(clear);
			while(op != "Null"){
				guest();
			}
		} 
		else if (ins == 4) {
		front_file ffile = new front_file();
		ffile.main_menu();
	}
	}
	
	
	
	public static void main_page() {
		input = new Scanner(System.in);
		System.out.println("!!--------Main Menu--------!!");
		System.out.println("Choose the option:");
		System.out.println("1.Item Record");
		System.out.println("2.Supplier Record");
		System.out.println("3.Reorder stock");
		System.out.println("4. Login");
		System.out.println("Enter the choice:");
		choice = input.nextInt();
		switch (choice) {
		case 1: {
			System.out.print(clear);
			item();
		}
		break;
		case 2: {
			System.out.print(clear);
			supplier();
		}
		 break;
		case 3: {
			System.out.print(clear);
			reorder();
		}
		 break;
		
		case 4: {
			front_file ffile = new front_file();
			ffile.main_menu();
		}break;
	}
	
	}
	
	public static void main(String[] args) {
		main_page();
	}
	
}