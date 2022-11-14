package com.jumpplus.shoppingapp;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jumpplus.shoppingapp.controller.CreateNewAccount;
import com.jumpplus.shoppingapp.controller.Login;
import com.jumpplus.shoppingapp.utility.PrinterUtility;

@SpringBootApplication
public class ShoppingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		String selection;

		PrinterUtility.welcomeHeading();
		do {
			PrinterUtility.mainMenu();
			System.out.println("Enter Choice (1, 2, 3) :");
			selection = scanner.nextLine().trim();
			switch(selection) {
				case "1":
					CreateNewAccount.createAccount();
					break;
				case "2":
					Login.login();
					break;
				case "3": break;
				default:
					System.out.println("Invalid Input. Please enter 1, 2, or 3 only.");
			}
		} while(!selection.equals("3"));
		scanner.close();
		PrinterUtility.exitHeading();
	}

}
