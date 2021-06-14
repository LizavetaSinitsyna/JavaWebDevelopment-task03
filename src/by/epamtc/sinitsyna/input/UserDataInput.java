package by.epamtc.sinitsyna.input;

import java.util.Scanner;

public class UserDataInput {
	private Scanner scanner = new Scanner(System.in);

	public int requestInt(String message) {
		int number;

		System.out.println(message);

		while (!scanner.hasNextInt()) {
			scanner.nextLine();
			System.out.println(message);
		}

		number = scanner.nextInt();
		scanner.nextLine();

		return number;
	}

	public String requestString(String message) {

		System.out.println(message);

		return scanner.nextLine();
	}
}
