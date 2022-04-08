import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class main_file {
static int choice;
	static int ch;
	static int ins;
		Scanner input = new Scanner(System.in);

	Product_insert customer_insert = new Product_insert();
	Product_select customer_select = new Product_select();
	Product_update customer_update= new Product_update();
	Product_delete customr_delete = new Product_delete();
	
	Price_insert pp_insert = new Price_insert();
	Price_select pp_select = new Price_select();
	Price_update pp_update = new Price_update();
	Price_delete pp_delete = new Price_delete();
	
	Bill_insert bb_insert =new Bill_insert();
	Bill_select bb_select =new Bill_select();
	Bill_update bb_update =new Bill_update();
	Bill_delete bb_delete =new Bill_delete();
	static void Product_tab() {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose an option for customer:");
		System.out.println("1. Insert Record");
		System.out.println("2. Display Record");
		System.out.println("3. Update Record");
		System.out.println("4. Delete Record");
		System.out.println("5. Exit");
		System.out.println("Enter the choice:");
		ch = input.nextInt();
		if (ch == 1) {
			/*System.out.println("choose the option");
			System.out.println("1.New Customer");
			System.out.println("2.New Price");
			System.out.println("3.New Bill");
			System.out.println("Enter the choice");*/
		Product_insert.customer_insert();
		Product_tab();
		}
		else if (ch == 2) {
			
			Product_select.customer_select();
			Product_tab();
			
		}
		else if (ch == 3) {
		
			Product_update.customer_update();
			Product_tab();
			}
else if (ch == 4) {
	
	Product_delete.customer_delete();
	Product_tab();
}
else 
{
	System.exit(0);
}
}



	static void Price_tab() {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose an option for Price:");
		System.out.println("1. Insert Record");
		System.out.println("2. Display Record");
		System.out.println("3. Update Record");
		System.out.println("4. Delete Record");
		System.out.println("5. Exit");
		System.out.println("Enter the choice:");
		ch = input.nextInt();
		if (ch == 1) {
			
			/*System.out.println("choose the option");
			System.out.println("1.New Customer");
			System.out.println("2.New Price");
			System.out.println("3.New Bill");
			System.out.println("Enter the choice");*/
		Price_insert.pp_insert();
		Price_tab();
		}
		else if (ch == 2) {
			
			Price_select.pp_select();
			Price_tab();
		}
		else if (ch == 3) {
		
			Price_update.pp_update();
			Price_tab();
			}
else if (ch == 4) {
	
	Price_delete.pp_delete();
	Price_tab();}
else 
{
	System.exit(0);
}
}

	
	
	

	
	
	static void Bill_tab() {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose an option for Bill:");
		System.out.println("1. Insert Record");
		System.out.println("2. Display Record");
		System.out.println("3. Update Record");
		System.out.println("4. Delete Record");
		System.out.println("5. Exit");
		System.out.println("Enter the choice:");
		ch = input.nextInt();
		if (ch == 1) {
			/*System.out.println("choose the option");
			System.out.println("1.New Customer");
			System.out.println("2.New Price");
			System.out.println("3.New Bill");
			System.out.println("Enter the choice");*/
			Bill_insert.bb_insert();
			Bill_tab();
		}
		else if (ch == 2) {
			
			Bill_select.bb_select();
			Bill_tab();
		}
		else if (ch == 3) {
		
			Bill_update.bb_update();
			Bill_tab();
		}
		else if (ch == 4) {
	
			Bill_delete.bb_delete();
			Bill_tab();
		}
	else 
{
	System.exit(0);
}
}
public static void menu() {
	Scanner a = new Scanner(System.in);
		System.out.println("Choose one option:");
		System.out.println("1.Customer Record");
		System.out.println("2. Price Record");
		System.out.println("3. Bill Record");
		System.out.println("Enter the choice:");
		int choice = a.nextInt();
		
		switch (choice) 
		{
		case 1: 
			Product_tab();
			break;
		case 2:
			Price_tab();
			break;
		case 3:
			Bill_tab();
			break;
default:
	System.out.println("YOU enter wrong option");
		}
	}

	public static void main(String args[]) {
		menu();
	}
}
