package project;

public class Delay {

	public static void delay() {
		Introduction.introduction();
		try {
			
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Login.login();
	}
}
