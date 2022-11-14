package com.jumpplus.shoppingapp.controller;

import java.util.Scanner;
import java.util.UUID;

import com.jumpplus.shoppingapp.utility.PrinterUtility;

public class Shopping {

  public static void shopping(UUID customerID) {
    Scanner shoppingScanner = new Scanner(System.in);
    String selection = "";

    PrinterUtility.customerHeading();
    System.out.println("\n");

    do {
      System.out.println("Please make your selection:");
      PrinterUtility.customerMenu();
			System.out.println("Enter Choice (1, 2, 3, 4)");
			selection = shoppingScanner.nextLine().trim();
			switch(selection) {
				case "1":
					BuyAnItem.buyAnItem(customerID);
					break;
				case "2":
					ReplaceAnItem.replaceAnItem(customerID);
					break;
        case "3":
          ViewPreviousOrders.viewPreviousOrders(customerID);
				case "4": break;
				default:
					System.out.println("Invalid Input. Please select from the options only.");
			}
    } while(!selection.equals("4"));
    
  }
}
