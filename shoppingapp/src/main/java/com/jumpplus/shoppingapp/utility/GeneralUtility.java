package com.jumpplus.shoppingapp.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.jumpplus.shoppingapp.data.DataCollections;
import com.jumpplus.shoppingapp.exceptions.InvalidInputException;
import com.jumpplus.shoppingapp.models.Invoice;
import com.jumpplus.shoppingapp.models.Item;

public class GeneralUtility {
  
  public static int getQuantity(String item, String phase) {
    Scanner quantityScanner = new Scanner(System.in);
    String stringTest = "";
    int quantity = 0;
    boolean quantityCheck = true;

    try {
      while(quantityCheck) {
        if (phase.equals("return")) {
          System.out.println("How many " + item + " do you want to return?");
        } else {
          System.out.println("How many " + item + " would you like?");
        }
        stringTest = quantityScanner.nextLine().trim();
        
        if(stringTest.isBlank()) throw new InvalidInputException("Quantity cannot be blank.");
        else if(InputUtility.checkForLetters(stringTest)) throw new InvalidInputException("Quantity cannot contain letters");
        else if(InputUtility.checkForSpecialCharaters(stringTest)) throw new InvalidInputException("Quantity cannot contain special characters");
        else {
          quantity = Integer.parseInt(stringTest);
          quantityCheck = false;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return quantity;
  }

  public static void submitOrder(UUID customerID, int hatQty, int jacketQty, int jeansQty, int lShirtQty, int dShirtQty, int shoesQty) {
    List<Item> items = new ArrayList<>();

    // Create Items
    Item hatItem = new Item("Hat", "Ha1", 15, hatQty);
    Item jacketItem = new Item("Jacket", "Ja1", 35, jacketQty);
    Item jeansItem = new Item("Jeans", "Je1", 25, jeansQty);
    Item lShirtItem = new Item("Shirt-Light", "St1", 20, lShirtQty);
    Item dShirtItem = new Item("Shirt-Dark", "St2", 20, dShirtQty);
    Item shoesItem = new Item("Shoes", "Sh1", 55, shoesQty);
    
    // Store in Array List
    items.add(hatItem);
    items.add(jacketItem);
    items.add(jeansItem);
    items.add(lShirtItem);
    items.add(dShirtItem);
    items.add(shoesItem);
    
    // Create Invoice
    Invoice invoice = new Invoice(customerID, items);

    // Store Invoice
    DataCollections.addInvoice(invoice);

    PrinterUtility.orderSubmitted();
  }
  
}
