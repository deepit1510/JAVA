import java.util.Scanner;
import customer.*;
import cancellation.*;
import reservation.*;
import train.*;
import employe.*;
import employee.employe_delete;
import employee.employe_display;
import employee.employe_insert;
import employee.employe_update;

public class main_menu {
public static void main_menu() {
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the choice:-");
	System.out.println("1) Customer");
	System.out.println("2) Reservation");
	System.out.println("3) Train");
	System.out.println("4) Cancelation");
	System.out.println("5) employe");
	int a = input.nextInt();
	switch(a) {
	case 1: {
		System.out.println("Enter the choice:-");
		System.out.println("1) Insert Customer");
		System.out.println("2) Update Customer");
		System.out.println("3) Display Customer");
		System.out.println("4) Delete Customer");
		System.out.println("5) Main Menu");
		int b = input.nextInt();
		if (b==1) {
			customer_insert insert = new customer_insert();
			insert.customer_insert();
		}
		else if (b==2) {
			customer_update update = new customer_update();
			update.customer_update();
		}
		else if (b==3) {
			customer_display display = new customer_display();
			display.customer_display();
		}
		else if (b==4) {
			customer_delete delete = new customer_delete();
			delete.customer_delete();
		}
		else if (b==5) {
			main_menu();
		}
	}
	case 2: {
		System.out.println("Enter the choice:-");
		System.out.println("1) Insert reservation");
		System.out.println("2) Update reservation");
		System.out.println("3) Display reservation");
		System.out.println("4) Delete reservation");
		System.out.println("5) Main Menu");
		int b = input.nextInt();
		if (b==1) {
			reservation_insert insert = new reservation_insert();
			insert.reservation_insert();
		}
		else if (b==2) {
			reservation_update update = new reservation_update();
			update.reservation_update();
		}
		else if (b==3) {
			reservation_display display = new reservation_display();
			display.reservation_display();
		}
		else if (b==4) {
			reservation_delete delete = new reservation_delete();
			delete.reservation_delete();
		}
		else if (b==5) {
			main_menu();
		}
	}
	case 3: {
		System.out.println("Enter the choice:-");
		System.out.println("1) Insert train");
		System.out.println("2) Update train");
		System.out.println("3) Display train");
		System.out.println("4) Delete train");
		System.out.println("5) Main Menu");
		int b = input.nextInt();
		if (b==1) {
			train_insert insert = new train_insert();
			insert.train_insert();
		}
		else if (b==2) {
			train_update update = new train_update();
			update.train_update();
		}
		else if (b==3) {
			train_display display = new train_display();
			display.train_display();
		}
		else if (b==4) {
			train_delete delete = new train_delete();
			delete.train_delete();
		}
		else if (b==5) {
			main_menu();
		}
	}
	case 4: {
		System.out.println("Enter the choice:-");
		System.out.println("1) Insert cancellation");
		System.out.println("2) Update cancellation");
		System.out.println("3) Display cancellation");
		System.out.println("4) Delete cancellation");
		System.out.println("5) Main Menu");
		int b = input.nextInt();
		if (b==1) {
			cancellation_insert insert = new cancellation_insert();
			insert.cancellation_insert();
		}
		else if (b==2) {
			cancellation_update update = new cancellation_update();
			update.cancellation_update();
		}
		else if (b==3) {
			cancellation_display display = new cancellation_display();
			display.cancellation_display();
		}
		else if (b==4) {
			cancellation_delete delete = new cancellation_delete();
			delete.cancellation_delete();
		}
		else if (b==5) {
			main_menu();
		}
	}
	case 5: {
		System.out.println("Enter the choice:-");
		System.out.println("1) Insert employe");
		System.out.println("2) Update employe");
		System.out.println("3) Display employe");
		System.out.println("4) Delete employe");
		System.out.println("5) Main Menu");
		int b = input.nextInt();
		if (b==1) {
			employe_insert insert = new employe_insert();
			insert.employee_insert();
		}
		else if (b==2) {
			employe_update update = new employe_update();
			update.employe_update();
		}
		else if (b==3) {
			employe_display display = new employe_display();
			display.employe_display();
		}
		else if (b==4) {
			employe_delete delete = new employe_delete();
			delete.employe_delete();
		}
		else if (b==5) {
			main_menu();
		}
	}
		
	}
		
	
}
}
