package com.jumpplus.shoppingapp.controller;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.jumpplus.shoppingapp.data.DataCollections;
import com.jumpplus.shoppingapp.models.Customer;
import com.jumpplus.shoppingapp.utility.PrinterUtility;

public class Login {
  public static void login() {
    Scanner loginScanner = new Scanner(System.in);
    String emailTest = "", passwordTest = "";
    List<Customer> customers = DataCollections.getCustomers();
    boolean passThrough =false;
    int counter = 0;
    int attempts = 3;

    try {
      PrinterUtility.loginHeading();
      while (counter < attempts) {

        System.out.println("Email: ");
        emailTest = loginScanner.nextLine().trim();
        System.out.println("\n");

        System.out.println("Password: ");
        passwordTest = loginScanner.nextLine().trim();

        for (int i = 0; i < customers.size(); i++) {
          if (customers.get(i).getEmail().equals(emailTest) 
            && customers.get(i).getPassword().equals(passwordTest)) {
              UUID customerID = customers.get(i).getCustomerID();
              Shopping.shopping(customerID);
              System.out.println("\n");
              counter = attempts;
              passThrough = true;
              break;
          }
        }

        if(!passThrough){
          counter++;

          System.out.println("\n");
          PrinterUtility.incorrectLogin(attempts-counter);
          System.out.println("\n");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    PrinterUtility.returnToMain();
    System.out.println("\n");
  }
}
