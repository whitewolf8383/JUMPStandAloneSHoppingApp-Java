package com.jumpplus.shoppingapp.controller;

import java.util.Scanner;

import com.jumpplus.shoppingapp.data.DataCollections;
import com.jumpplus.shoppingapp.exceptions.InvalidInputException;
import com.jumpplus.shoppingapp.models.Customer;
import com.jumpplus.shoppingapp.utility.InputUtility;
import com.jumpplus.shoppingapp.utility.PrinterUtility;

public class CreateNewAccount {

  public static void createAccount() {

    Scanner input = new Scanner(System.in);
    String stringTest = "", name = "", email = "", password = "", passwordConfirm = "";
		
    System.out.println("\n");
    PrinterUtility.detailsHeading();

    try {
      // Get and test customer name
      boolean nameCheck = true;
			while(nameCheck) {
				System.out.println("Customer Full Name: ");
				stringTest = input.nextLine().trim();
				
				if(stringTest.isBlank()) throw new InvalidInputException("Name cannot be blank.");
				else if(InputUtility.checkForNumbers(stringTest)) throw new InvalidInputException("Name cannot contain numbers");
				else if(InputUtility.checkForSpecialCharaters(stringTest)) throw new InvalidInputException("Name cannot contain special characters");
				else {
					name = stringTest;
					nameCheck = false;
				}
      }

      // Get and test customer email
      System.out.println("\n");
      boolean emailCheck = true;
			while(emailCheck) {
				System.out.println("Customer Email: ");
				stringTest = input.nextLine().trim();
				
				if(stringTest.isBlank()) throw new InvalidInputException("Name cannot be blank.");
        else if(!stringTest.contains("@") || !stringTest.contains(".com")) throw new InvalidInputException("Input must be a valid email format.");
				else {
					email = stringTest;
					emailCheck = false;
				}
      }

      // Get and test Password
      System.out.println("\n");
			boolean passwordCheck = true;
			while(passwordCheck) {
				System.out.println("Create Password: ");
				stringTest = input.nextLine();
        System.out.println("\n");
				
				if(stringTest.isBlank()) throw new InvalidInputException("Password cannot be blank.");
				else if(InputUtility.checkPasswordStringLength(stringTest)) throw new InvalidInputException("Password must be 8 characters or longer.");
				else if(!InputUtility.checkForSpecialCharaters(stringTest)) throw new InvalidInputException("Password must contain at least one special character.");
				else if(!InputUtility.checkForNumbers(stringTest)) throw new InvalidInputException("Password must contain at least one number.");
				
        System.out.println("Confirm Password: ");
				passwordConfirm = input.nextLine();
        
        if (stringTest.equals(passwordConfirm)) {
          password = stringTest;
				  passwordCheck = false;
        } else {
          throw new InvalidInputException("Passwords must match.");
        }
			}

      Customer customer = new Customer(name, email, password);
      DataCollections.addCustomer(customer);

      PrinterUtility.accountCreatedHeading();
      System.out.println('\n');
      
    } catch (Exception e) {
      System.out.println('\n');
      e.printStackTrace();
      System.out.println('\n');
    }
  }
}
