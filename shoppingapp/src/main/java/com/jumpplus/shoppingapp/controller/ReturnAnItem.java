package com.jumpplus.shoppingapp.controller;

import java.util.List;
import java.util.Scanner;

import com.jumpplus.shoppingapp.models.Invoice;
import com.jumpplus.shoppingapp.models.Item;
import com.jumpplus.shoppingapp.utility.GeneralUtility;
import com.jumpplus.shoppingapp.utility.PrinterUtility;

public class ReturnAnItem {
  
  public static void returnAnItem(Invoice invoice) {
    Scanner returnAnItemScanner = new Scanner(System.in);
    List<Item> items = invoice.getItems();
    boolean itemSwitch = true;
    String input = "";
    int total, testReturn = 0 , hats = 0, jackets = 0, jeans = 0, lShirts = 0, dShirts = 0, shoes = 0;
    int hatsDiff, jacketsDiff, jeansDiff, lShirtsDiff, dShirtsDiff, shoesDiff;
    do {
      total = (items.get(0).getItemPrice() * hats) 
      + (items.get(1).getItemPrice() * jackets)
      + (items.get(2).getItemPrice() * jeans)
      + (items.get(3).getItemPrice() * lShirts)
      + (items.get(4).getItemPrice() * dShirts)
      + (items.get(5).getItemPrice() * shoes);

      hatsDiff = (items.get(0).getQuantity() - hats);
      jacketsDiff = (items.get(1).getQuantity() - jackets);
      jeansDiff = (items.get(2).getQuantity() - jeans);
      lShirtsDiff = (items.get(3).getQuantity() - lShirts);
      dShirtsDiff = (items.get(4).getQuantity() - dShirts);
      shoesDiff = (items.get(5).getQuantity() - shoes);
      
      System.out.println("\n");
      System.out.println("Which item would you like to return?");
      PrinterUtility.returnAnItem(hatsDiff, jacketsDiff, jeansDiff, lShirtsDiff, dShirtsDiff, shoesDiff, total, "");

      input = returnAnItemScanner.nextLine().trim();
      switch(input) {
        case "1":
          testReturn = GeneralUtility.getQuantity("hats", "return");
          if (checkQuantity(items.get(0).getQuantity(), (testReturn + hats))) hats = testReturn;
          else incorrectQuantity("hats");
          break;
        case "2":
          testReturn = GeneralUtility.getQuantity("jackets", "return");
          if (checkQuantity(items.get(1).getQuantity(), (testReturn + jackets))) jackets = testReturn;
          else incorrectQuantity("jackets");
          break;
        case "3":
          testReturn = GeneralUtility.getQuantity("jeans", "return");
          if (checkQuantity(items.get(2).getQuantity(), (testReturn + jeans))) jeans = testReturn;
          else incorrectQuantity("jeans");
          break;
        case "4":
          testReturn = GeneralUtility.getQuantity("light shirts", "return");
          if (checkQuantity(items.get(3).getQuantity(), (testReturn + lShirts))) lShirts = testReturn;
          else incorrectQuantity("light shirts");
          break;
        case "5":
          testReturn = GeneralUtility.getQuantity("dark shirts", "return");
          if (checkQuantity(items.get(4).getQuantity(), (testReturn + dShirts))) dShirts = testReturn;
          else incorrectQuantity("dark shirts");
          break;
        case "6":
          testReturn = GeneralUtility.getQuantity("shoes", "return");
          if (checkQuantity(items.get(5).getQuantity(), (testReturn + shoes))) shoes = testReturn;
          else incorrectQuantity("shoes");
          break;
        case "9":
          items.get(0).setQuantity(items.get(0).getQuantity() - hats);
          items.get(1).setQuantity(items.get(1).getQuantity() - jackets);
          items.get(2).setQuantity(items.get(2).getQuantity() - jeans);
          items.get(3).setQuantity(items.get(3).getQuantity() - lShirts);
          items.get(4).setQuantity(items.get(4).getQuantity() - dShirts);
          items.get(5).setQuantity(items.get(5).getQuantity() - shoes);
          PrinterUtility.orderSubmitted();
          itemSwitch = false;
          break;
        case "0":
          PrinterUtility.noChangeToInvoice();
          itemSwitch = false;
          break;
        default:
          System.out.println("Invalid Input. Please select from the options only.");
      }

    } while (itemSwitch);
  }

  public static boolean checkQuantity(int available, int returned) {
    return (available >= returned) ? true : false;
  }

  public static void incorrectQuantity(String item) {
    System.out.println("The quantity entered for " + item + " is not available.");
    System.out.println("Please verify the quantity available and amount to return.");
  }

  public static void returnAllItems(Invoice invoice) {
    Scanner returnAllScanner = new Scanner(System.in);
    List<Item> items = invoice.getItems();
    String input = "";
    int total = (items.get(0).getItemPrice() * items.get(0).getQuantity()) 
      + (items.get(1).getItemPrice() * items.get(1).getQuantity())
      + (items.get(2).getItemPrice() * items.get(2).getQuantity())
      + (items.get(3).getItemPrice() * items.get(3).getQuantity())
      + (items.get(4).getItemPrice() * items.get(4).getQuantity())
      + (items.get(5).getItemPrice() * items.get(5).getQuantity());

    System.out.println("Are you sure you wish to return all item? (Y or N)");
    System.out.println("Items to be returned: ");
    System.out.println("| Items          Qty");
    System.out.println("| Hat            " + items.get(0).getQuantity());
    System.out.println("| Jacket         " + items.get(1).getQuantity());
    System.out.println("| Jeans          " + items.get(2).getQuantity());
    System.out.println("| Shirt-Light    " + items.get(3).getQuantity());
    System.out.println("| Shirt-Dark     " + items.get(4).getQuantity());
    System.out.println("| Shoes          " + items.get(5).getQuantity());
    System.out.println("| Total to be return: " + total);

    input = returnAllScanner.nextLine().trim().toLowerCase();
    switch(input) {
      case "y":
				items.get(0).setQuantity(0);
        items.get(1).setQuantity(0);
        items.get(2).setQuantity(0);
        items.get(3).setQuantity(0);
        items.get(4).setQuantity(0);
        items.get(5).setQuantity(0);
        System.out.println("All items have been return for a refund of " + total + ".");
				break;
			case "n":
        PrinterUtility.noChangeToInvoice();
				break;
			default:
				System.out.println("Invalid Input. Please enter 'Y' or 'N' only.");
    }
  }
}
