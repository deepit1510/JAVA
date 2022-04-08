package main_file;

import java.util.Scanner;
import main_file.main_menu;
import Login.check;
import Login.new_user;

public class front_file {
	public static void main_menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("1) Existing User");
		System.out.println("2) New USer");
		System.out.println("3) Guest Login");
		int ch = input.nextInt();
		if (ch == 1) {
			check check = new check();
			Login.check.check();
		} else if (ch == 2) {
			new_user usr = new new_user();
			usr.new_usr();
		} else if (ch == 3) {
			main_menu mfile = new main_menu();
			mfile.guest();
		}

	}
	public static void main(String[] args){
		main_menu();
	}
}
