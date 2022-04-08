import inventory.*;
import java.util.Scanner;

public class main_page {
	static int choice;
	static int ch;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		item_details_delete item_delete = new item_details_delete();
		item_details_display item_display = new item_details_display();
		item_details_update item_update = new item_details_update();
		item_details_insert item_insert = new item_details_insert();
		
		purchase_details_delete purchase_delete = new purchase_details_delete();
		purchase_details_display purchase_display = new purchase_details_display();
		purchase_details_update purchase_update = new purchase_details_update();
		purchase_details_insert purchase_insert = new purchase_details_insert();
		
		sales_details_delete sales_delete = new sales_details_delete();
		sales_details_display sales_display = new sales_details_display();
		sales_details_update sales_update = new sales_details_update();
		sales_details_insert sales_insert = new sales_details_insert();
		
		System.out.println("Choose one option:");
		System.out.println("1. Item Record");
		System.out.println("2. Purchase Record");
		System.out.println("3. Sales Record");
		System.out.println("4. Exit");
		System.out.println("Enter the choice:");
		choice = input.nextInt();
		switch(choice){
		case 1:{
			System.out.println("Choose one option:");
			System.out.println("1. Display Record");
			System.out.println("2. Insert Record");
			System.out.println("3. Update Record");
			System.out.println("4. Delete Record");
			ch = input.nextInt();
			if(ch==1){
				item_display.display_item();
				break;
			}
			else if(ch==2){
				item_insert.insert_item();
				break;
			}
			else if(ch==3){
				item_update.update_item();
				break;
			}
			else if(ch==4){
				item_delete.delete_item();
				break;
			}
			else {
				System.out.println("Wrong input");
			}
			
		}
			break;
		case 2:
		{
			System.out.println("Choose one option:");
			System.out.println("1. Display Record");
			System.out.println("2. Insert Record");
			System.out.println("3. Update Record");
			System.out.println("4. Delete Record");
			ch = input.nextInt();
			if(ch==1){
				purchase_display.display_purchase();
				break;
			}
			else if(ch==2){
				purchase_insert.insert_purchase();
				break;
			}
			else if(ch==3){
				purchase_update.update_purchase();
				break;
			}
			else if(ch==4){
				purchase_delete.delete_purchase();
				break;
			}
			else {
				System.out.println("Wrong input");
			}
			
		}
			break;
		case 3:
		{
			System.out.println("Choose one option:");
			System.out.println("1. Display Record");
			System.out.println("2. Insert Record");
			System.out.println("3. Update Record");
			System.out.println("4. Delete Record");
			ch = input.nextInt();
			if(ch==1){
				sales_display.display_sales();
				break;
			}
			else if(ch==2){
				sales_insert.insert_sales();
				break;
			}
			else if(ch==3){
				sales_update.update_sales();
				break;
			}
			else if(ch==4){
				sales_delete.delete_sales();
				break;
			}
			else {
				System.out.println("Wrong input");
			}
			
		}
			break;
		
		}
		
	}
}
