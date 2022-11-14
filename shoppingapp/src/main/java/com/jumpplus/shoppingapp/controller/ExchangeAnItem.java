package com.jumpplus.shoppingapp.controller;

import java.util.List;
import java.util.Scanner;

import com.jumpplus.shoppingapp.models.Invoice;
import com.jumpplus.shoppingapp.models.Item;
import com.jumpplus.shoppingapp.utility.GeneralUtility;
import com.jumpplus.shoppingapp.utility.PrinterUtility;

public class ExchangeAnItem {
  
  public static void exchangeAnItem(Invoice invoice) {
    Scanner exchangeAnItemScanner = new Scanner(System.in);
    List<Item> items = invoice.getItems();
    boolean itemSwitch = true;
    String returnedItem = "", exchangedItem = "";
    int total, testReturn = 0, exchangeNumber = 0, hats = 0, jackets = 0, jeans = 0, lShirts = 0, dShirts = 0, shoes = 0;
    int hatsDiff, jacketsDiff, jeansDiff, lShirtsDiff, dShirtsDiff, shoesDiff;
    // int hatCost = 15, jacketCost = 35, jeanCost = 25, lShirtCost = 20, dShirtCost = 20, shoeCost = 55;
    int startTotal = (items.get(0).getItemPrice() * items.get(0).getQuantity()) 
      + (items.get(1).getItemPrice() * items.get(1).getQuantity())
      + (items.get(2).getItemPrice() * items.get(2).getQuantity())
      + (items.get(3).getItemPrice() * items.get(3).getQuantity())
      + (items.get(4).getItemPrice() * items.get(4).getQuantity())
      + (items.get(5).getItemPrice() * items.get(5).getQuantity());

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
      PrinterUtility.returnAnItem(hatsDiff, jacketsDiff, jeansDiff, lShirtsDiff, dShirtsDiff, shoesDiff, total, "exchange");

      System.out.println("Which item would you like to return?");
      returnedItem = exchangeAnItemScanner.nextLine().trim();
      System.out.println("\n");
      if (!returnedItem.equals("9") && !returnedItem.equals("0")) {
        System.out.println("Which item would you like to exchange it for?");
        exchangedItem = exchangeAnItemScanner.nextLine().trim();
      }

      switch(returnedItem) {
        case "1":
          testReturn = GeneralUtility.getQuantity("hats", "return");
          exchangeNumber = 0;
          if (ReturnAnItem.checkQuantity(items.get(0).getQuantity(), (testReturn + hats))) {
            if (exchangedItem.equals("1")) {
              exchangeNumber = GeneralUtility.getQuantity("hats", "");
              hats += (testReturn - exchangeNumber);
            } else if (exchangedItem.equals("2")) {
              exchangeNumber = GeneralUtility.getQuantity("jackets", "");
              hats += testReturn;
              jackets -= exchangeNumber;
            } else if (exchangedItem.equals("3")) {
              exchangeNumber = GeneralUtility.getQuantity("jeans", "");
              hats += testReturn;
              jeans -= exchangeNumber;
            } else if (exchangedItem.equals("4")) {
              exchangeNumber = GeneralUtility.getQuantity("light shirts", "");
              hats += testReturn;
              lShirts -= exchangeNumber;
            } else if (exchangedItem.equals("5")) {
              exchangeNumber = GeneralUtility.getQuantity("dark shirts", "");
              hats += testReturn;
              dShirts -= exchangeNumber;
            } else if (exchangedItem.equals("6")) {
              exchangeNumber = GeneralUtility.getQuantity("shoes", "");
              hats += testReturn;
              shoes -= exchangeNumber;
            } else {
              System.out.println("Invalid exchange item selection. Only select from the available options.");
            }
          } else ReturnAnItem.incorrectQuantity("hats");
          break;

        case "2":
          testReturn = GeneralUtility.getQuantity("jackets", "return");
          exchangeNumber = 0;
          if (ReturnAnItem.checkQuantity(items.get(0).getQuantity(), (testReturn + jackets))) {
            if (exchangedItem.equals("1")) {
              exchangeNumber = GeneralUtility.getQuantity("hats", "");
              jackets += testReturn;
              hats -= exchangeNumber;
            } else if (exchangedItem.equals("2")) {
              exchangeNumber = GeneralUtility.getQuantity("jackets", "");
              jackets += (testReturn - exchangeNumber);
            } else if (exchangedItem.equals("3")) {
              exchangeNumber = GeneralUtility.getQuantity("jeans", "");
              jackets += testReturn;
              jeans -= exchangeNumber;
            } else if (exchangedItem.equals("4")) {
              exchangeNumber = GeneralUtility.getQuantity("light shirts", "");
              jackets += testReturn;
              lShirts -= exchangeNumber;
            } else if (exchangedItem.equals("5")) {
              exchangeNumber = GeneralUtility.getQuantity("dark shirts", "");
              jackets += testReturn;
              dShirts -= exchangeNumber;
            } else if (exchangedItem.equals("6")) {
              exchangeNumber = GeneralUtility.getQuantity("shoes", "");
              jackets += testReturn;
              shoes -= exchangeNumber;
            } else {
              System.out.println("Invalid exchange item selection. Only select from the available options.");
            }
          } else ReturnAnItem.incorrectQuantity("jackets");
          break;

        case "3":
          testReturn = GeneralUtility.getQuantity("jeans", "return");
          exchangeNumber = 0;
          if (ReturnAnItem.checkQuantity(items.get(0).getQuantity(), (testReturn + jeans))) {
            if (exchangedItem.equals("1")) {
              exchangeNumber = GeneralUtility.getQuantity("hats", "");
              jeans += testReturn;
              hats -= exchangeNumber;
            } else if (exchangedItem.equals("2")) {
              exchangeNumber = GeneralUtility.getQuantity("jackets", "");
              jeans += testReturn;
              jackets -= exchangeNumber;
            } else if (exchangedItem.equals("3")) {
              exchangeNumber = GeneralUtility.getQuantity("jeans", "");
              jeans += (testReturn - exchangeNumber);
            } else if (exchangedItem.equals("4")) {
              exchangeNumber = GeneralUtility.getQuantity("light shirts", "");
              jeans += testReturn;
              lShirts -= exchangeNumber;
            } else if (exchangedItem.equals("5")) {
              exchangeNumber = GeneralUtility.getQuantity("dark shirts", "");
              jeans += testReturn;
              dShirts -= exchangeNumber;
            } else if (exchangedItem.equals("6")) {
              exchangeNumber = GeneralUtility.getQuantity("shoes", "");
              jeans += testReturn;
              shoes -= exchangeNumber;
            } else {
              System.out.println("Invalid exchange item selection. Only select from the available options.");
            }
          } else ReturnAnItem.incorrectQuantity("jeans");
          break;

        case "4":
          testReturn = GeneralUtility.getQuantity("light shirts", "return");
          exchangeNumber = 0;
          if (ReturnAnItem.checkQuantity(items.get(0).getQuantity(), (testReturn + lShirts))) {
            if (exchangedItem.equals("1")) {
              exchangeNumber = GeneralUtility.getQuantity("hats", "");
              lShirts += testReturn;
              hats -= exchangeNumber;
            } else if (exchangedItem.equals("2")) {
              exchangeNumber = GeneralUtility.getQuantity("jackets", "");
              lShirts += testReturn;
              jackets -= exchangeNumber;
            } else if (exchangedItem.equals("3")) {
              exchangeNumber = GeneralUtility.getQuantity("jeans", "");
              lShirts += testReturn;
              jeans -= exchangeNumber;
            } else if (exchangedItem.equals("4")) {
              exchangeNumber = GeneralUtility.getQuantity("light shirts", "");
              lShirts += (testReturn - exchangeNumber);
            } else if (exchangedItem.equals("5")) {
              exchangeNumber = GeneralUtility.getQuantity("dark shirts", "");
              lShirts += testReturn;
              dShirts -= exchangeNumber;
            } else if (exchangedItem.equals("6")) {
              exchangeNumber = GeneralUtility.getQuantity("shoes", "");
              lShirts += testReturn;
              shoes -= exchangeNumber;
            } else {
              System.out.println("Invalid exchange item selection. Only select from the available options.");
            }
          } else ReturnAnItem.incorrectQuantity("light shirts");
          break;

        case "5":
          testReturn = GeneralUtility.getQuantity("dark shirts", "return");
          exchangeNumber = 0;
          if (ReturnAnItem.checkQuantity(items.get(0).getQuantity(), (testReturn + dShirts))) {
            if (exchangedItem.equals("1")) {
              exchangeNumber = GeneralUtility.getQuantity("hats", "");
              dShirts += testReturn;
              hats -= exchangeNumber;
            } else if (exchangedItem.equals("2")) {
              exchangeNumber = GeneralUtility.getQuantity("jackets", "");
              dShirts += testReturn;
              jackets -= exchangeNumber;
            } else if (exchangedItem.equals("3")) {
              exchangeNumber = GeneralUtility.getQuantity("jeans", "");
              dShirts += testReturn;
              jeans -= exchangeNumber;
            } else if (exchangedItem.equals("4")) {
              exchangeNumber = GeneralUtility.getQuantity("light shirts", "");
              dShirts += testReturn;
              lShirts -= exchangeNumber;
            } else if (exchangedItem.equals("5")) {
              exchangeNumber = GeneralUtility.getQuantity("dark shirts", "");
              dShirts += (testReturn - exchangeNumber);
            } else if (exchangedItem.equals("6")) {
              exchangeNumber = GeneralUtility.getQuantity("shoes", "");
              dShirts += testReturn;
              shoes -= exchangeNumber;
            } else {
              System.out.println("Invalid exchange item selection. Only select from the available options.");
            }
          } else ReturnAnItem.incorrectQuantity("dark shirts");
          break;

        case "6":
          testReturn = GeneralUtility.getQuantity("shoes", "return");
          exchangeNumber = 0;
          if (ReturnAnItem.checkQuantity(items.get(0).getQuantity(), (testReturn + shoes))) {
            if (exchangedItem.equals("1")) {
              exchangeNumber = GeneralUtility.getQuantity("hats", "");
              shoes += testReturn;
              hats -= exchangeNumber;
            } else if (exchangedItem.equals("2")) {
              exchangeNumber = GeneralUtility.getQuantity("jackets", "");
              shoes += testReturn;
              jackets -= exchangeNumber;
            } else if (exchangedItem.equals("3")) {
              exchangeNumber = GeneralUtility.getQuantity("jeans", "");
              shoes += testReturn;
              jeans -= exchangeNumber;
            } else if (exchangedItem.equals("4")) {
              exchangeNumber = GeneralUtility.getQuantity("light shirts", "");
              shoes += testReturn;
              lShirts -= exchangeNumber;
            } else if (exchangedItem.equals("5")) {
              exchangeNumber = GeneralUtility.getQuantity("dark shirts", "");
              shoes += testReturn;
              dShirts -= exchangeNumber;
            } else if (exchangedItem.equals("6")) {
              exchangeNumber = GeneralUtility.getQuantity("shoes", "");
              shoes += (testReturn - exchangeNumber);
            } else {
              System.out.println("Invalid exchange item selection. Only select from the available options.");
            }
          } else ReturnAnItem.incorrectQuantity("shoes");
          break;

        case "9":
          items.get(0).setQuantity(hatsDiff);
          items.get(1).setQuantity(jacketsDiff);
          items.get(2).setQuantity(jeansDiff);
          items.get(3).setQuantity(lShirtsDiff);
          items.get(4).setQuantity(dShirtsDiff);
          items.get(5).setQuantity(shoesDiff);
          int newTotal = (items.get(0).getItemPrice() * items.get(0).getQuantity()) 
            + (items.get(1).getItemPrice() * items.get(1).getQuantity())
            + (items.get(2).getItemPrice() * items.get(2).getQuantity())
            + (items.get(3).getItemPrice() * items.get(3).getQuantity())
            + (items.get(4).getItemPrice() * items.get(4).getQuantity())
            + (items.get(5).getItemPrice() * items.get(5).getQuantity());
          PrinterUtility.orderSubmitted();
          if ((startTotal - newTotal) >= 0) {
            System.out.println("You will have a refund of " + (startTotal - newTotal) + ".");
          } else System.out.println("Your bill has increased by " + (newTotal - startTotal) + ".");
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
}
