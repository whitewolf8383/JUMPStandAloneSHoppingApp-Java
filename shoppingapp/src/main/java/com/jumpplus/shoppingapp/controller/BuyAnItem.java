package com.jumpplus.shoppingapp.controller;

import java.util.Scanner;
import java.util.UUID;

import com.jumpplus.shoppingapp.utility.GeneralUtility;
import com.jumpplus.shoppingapp.utility.PrinterUtility;

public class BuyAnItem {
  
  public static void buyAnItem(UUID customerID) {
    Scanner buyAnItemScanner = new Scanner(System.in);

    int hatQty = 0;
    int jacketQty = 0;
    int jeansQty = 0;
    int lShirtQty = 0;
    int dShirtQty = 0;
    int shoesQty = 0;
    String selection = "";
    boolean purchase = true;

    do {
      System.out.println("\n");
      PrinterUtility.shoppingCart(hatQty, jacketQty, jeansQty, lShirtQty, dShirtQty, shoesQty);
      System.out.println("Please select the item to change quantity for purchase.");
      selection = buyAnItemScanner.nextLine().trim();
      System.out.println("\n");
      switch(selection) {
				case "1":
					hatQty = GeneralUtility.getQuantity("hats", "na");
					break;
				case "2":
					jacketQty = GeneralUtility.getQuantity("jackets", "na");
					break;
        case "3":
					jeansQty = GeneralUtility.getQuantity("jeans", "na");
					break;
        case "4":
					lShirtQty = GeneralUtility.getQuantity("light shirts", "na");
					break;
        case "5":
					dShirtQty = GeneralUtility.getQuantity("dark shirts", "na");
					break;
        case "6":
					shoesQty = GeneralUtility.getQuantity("shoes", "na");
					break;
        case "9":
					GeneralUtility.submitOrder(customerID, hatQty, jacketQty, jeansQty, lShirtQty, dShirtQty, shoesQty);
          purchase = false;
          break;
        case "0": 
          purchase = false;
          PrinterUtility.noOrderSubmitted();
          break;
				default:
					System.out.println("Invalid Input. Please select from the options only.");
			}
    } while(purchase);
  }
}
