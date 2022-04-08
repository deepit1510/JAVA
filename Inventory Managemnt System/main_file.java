import inventory.*;
import java.util.*;
import java.sql.*;
public class main_file {
	static int choice;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		delete delete = new delete();
		display display = new display();
		insert insert = new insert();
		update update = new update();
		System.out.println("Choose one option:");
		System.out.println("1. Display Record");
		System.out.println("2. Insert Record");
		System.out.println("3. Update Record");
		System.out.println("4. Delete Record");
		System.out.println("5. Exit");
		System.out.println("Enter the choice:");
		choice = input.nextInt();
		switch(choice){
		case 1:
			display.display_item();
			break;
		case 2:
			insert.insert_item();
			break;
		case 3:
			update.update_item();
			break;
		case 4:
			delete.delete_item();
			break;
		
		}
		
		
	}
}
