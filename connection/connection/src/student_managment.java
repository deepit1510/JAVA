import connection.*;

import second.*;
import java.util.*;

public class student_managment {
	static int choic;
	static int ch;
	static int ins;
	static Scanner input;

	student_insert insert_student = new student_insert();
	student_display display_student = new student_display();
	student_update update_student = new student_update();
	student_delete delete_student = new student_delete();
	teacher_delete delete_teacher = new teacher_delete();
	teacher_display display_teacher = new teacher_display();
	teacher_insert insert_teacher = new teacher_insert();
	teacher_update update_teacher = new teacher_update();

	public static void student() {
		
		input = new Scanner(System.in);
		System.out.println("Choose one option:");
		System.out.println("1. insert Record");
		System.out.println("2. display Record");
		System.out.println("3. Update Record");
		System.out.println("4. Delete Record");
		System.out.println("5. Exit");
		System.out.println("Enter the choice:");
		ch = input.nextInt();
		if (ch == 1) {
			System.out.println("choose the option");
			System.out.println("1.New student");
			System.out.println("Enter the choice");
			ins = input.nextInt();
			if (ins == 1) {
				teacher_insert.insert_teacher();
				student_insert.insert_student();
				student();
			} else if (ins == 2) {
				student_insert.insert_student();
				student();
			}

		} else if (ch == 2) {
			student_display.display_student();
			student();
		} else if (ch == 3) {
			student_update.update_student();
			student();
		} else if (ch == 4) {
			student_delete.delete_student();
			student();
		}
	}

	// break;
	public static void teacher() {
		
		input = new Scanner(System.in);
		System.out.println("Choose one option:");
		System.out.println("1. Display Record");
		System.out.println("2. Insert Record");
		System.out.println("3. Update Record");
		System.out.println("4. Delete Record");
		System.out.println("5. main menu");
		System.out.println("Enter the choice:");
		ch = input.nextInt();
		if (ch == 1) {
			teacher_display.display_teacher();
			teacher();
		} else if (ch == 2) {
			teacher_insert.insert_teacher();
			teacher();
		} else if (ch == 3) {
			teacher_update.update_teacher();
			teacher();
		} else if (ch == 4) {
			teacher_delete.delete_teacher();
			teacher();
		} else {
			menu_file();

		}
	}

	public static void menu_file() {
		
		input = new Scanner(System.in);
		System.out.println("Choose one option:");
		System.out.println("1. Student Record");
		System.out.println("2. Teacher Record");
		System.out.println("Enter the choice:");
		ch = input.nextInt();
		switch (ch) {
		case 1:
			student();
			break;
		case 2:
			teacher();
			break;

		}
	}

	public static void main(String[] args) {
		menu_file();
	}
}
