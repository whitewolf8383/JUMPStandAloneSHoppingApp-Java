package com.jumpplus.shoppingapp.utility;

import java.util.List;
import java.util.UUID;

import com.jumpplus.shoppingapp.models.Invoice;
import com.jumpplus.shoppingapp.models.Item;

public class PrinterUtility {
  
  public static void welcomeHeading() {
		System.out.println(ColorsUtility.BLUE + "+---------------------------+");
		System.out.println("|  Welcome to Jump E-Comm   |");
		System.out.println("+---------------------------+" + ColorsUtility.RESET);
	}

	public static void detailsHeading() {
		System.out.println(ColorsUtility.BLUE + "+-------------------------------+");
		System.out.println("| Enter Details For New Account |");
		System.out.println("+-------------------------------+" + ColorsUtility.RESET);
	}

	public static void loginHeading() {
		System.out.println(ColorsUtility.BLUE + "+---------------------+");
		System.out.println("| Enter Login Details |");
		System.out.println("+---------------------+" + ColorsUtility.RESET);
	}

	public static void customerHeading() {
		System.out.println(ColorsUtility.BLUE + "+---------------------+");
		System.out.println("| WELCOME Customer!!! |");
		System.out.println("+---------------------+" + ColorsUtility.RESET);
	}

	public static void signoutHeading() {
		System.out.println(ColorsUtility.BLUE + "+-----------------------+");
		System.out.println("| Signed Out, Thank You |");
		System.out.println("+-----------------------+" + ColorsUtility.RESET);
	}

	public static void accountCreatedHeading() {
		System.out.println(ColorsUtility.GREEN + "+--------------------------+");
		System.out.println("| Account has been created |");
		System.out.println("+--------------------------+" + ColorsUtility.RESET);
	}

	public static void mainMenu() {
		System.out.println("1. REGISTER");
		System.out.println("2. LOGIN");
		System.out.println("3. EXIT");
    System.out.println("\n");
	}

	public static void customerMenu() {
		System.out.println("1. BUY AN ITEM");
		System.out.println("2. REPLACE AN ITEM");
    System.out.println("3. VIEW PREVIOUS ORDERS");
		System.out.println("4. LOGOUT");
    System.out.println("\n");
	}

  public static void productList() {
    System.out.println(ColorsUtility.BLUE + "+-------------------------------------+");
		System.out.println("| Items           Item Code     Price |");
    System.out.println("| 1. Hat          Ha1           $15   |");
    System.out.println("| 2. Jacket       Ja1           $35   |");
    System.out.println("| 3. Jeans        Je1           $25   |");
    System.out.println("| 4. Shirt-Light  St1           $20   |");
    System.out.println("| 5. Shirt-Dark   St2           $20   |");
    System.out.println("| 6. Shoes        Sh1           $55   |");
		System.out.println("+-------------------------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
  }

  public static void invoice(Invoice invoice) {
    List<Item> items = invoice.getItems();
    int total = 0;
    for (int i = 0; i < items.size(); i++) {
      total += items.get(i).getItemPrice() * items.get(i).getQuantity();
    }

    System.out.println(ColorsUtility.BLUE + "+-----------------------------------------------------+");
		System.out.println("| Customer: " + invoice.getCustomerID());
    System.out.println("| Date: " + invoice.getInvoiceDate());
    System.out.println("| Time: " + invoice.getInvoiceTime());
    System.out.println("| Invoice no: " + invoice.getInvoiceID());
    System.out.println("| Item         Item Code  Price      Qty     Total");
    System.out.println("| Hat          Ha1        $15         " + items.get(0).getQuantity() + "      " + items.get(0).getItemPrice() * items.get(0).getQuantity());
    System.out.println("| Jacket       Ja1        $35         " + items.get(1).getQuantity() + "      " + items.get(1).getItemPrice() * items.get(1).getQuantity());
    System.out.println("| Jeans        Je1        $25         " + items.get(2).getQuantity() + "      " + items.get(2).getItemPrice() * items.get(2).getQuantity());
    System.out.println("| Shirt-Light  St1        $20         " + items.get(3).getQuantity() + "      " + items.get(3).getItemPrice() * items.get(3).getQuantity());
    System.out.println("| Shirt-Dark   St2        $20         " + items.get(4).getQuantity() + "      " + items.get(4).getItemPrice() * items.get(4).getQuantity());
    System.out.println("| Shoes        Sh1        $55         " + items.get(5).getQuantity() + "      " + items.get(5).getItemPrice() * items.get(5).getQuantity());
    System.out.println("|");
    System.out.println("| Invoice Total = " + total);
		System.out.println("+-----------------------------------------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
  }

  public static void shoppingCart(int hatQty, int jacketQty, int jeansQty, int lShirtQty, int dShirtQty, int shoesQty) {
    int total = (hatQty * 15) + (jacketQty * 35) + (jeansQty * 25) + (lShirtQty * 20) + (dShirtQty * 20) + (shoesQty * 55);
    System.out.println(ColorsUtility.GREEN + "+--------------------------------------------------+");
		System.out.println("| Items           Item Code     Price   Qty");
    System.out.println("| 1. Hat          Ha1           $15     " + hatQty);
    System.out.println("| 2. Jacket       Ja1           $35     " + jacketQty);
    System.out.println("| 3. Jeans        Je1           $25     " + jeansQty);
    System.out.println("| 4. Shirt-Light  St1           $20     " + lShirtQty);
    System.out.println("| 5. Shirt-Dark   St2           $20     " + dShirtQty);
    System.out.println("| 6. Shoes        Sh1           $55     " + shoesQty);
    System.out.println("|");
    System.out.println("| Invoice Total = " + total);
    System.out.println("|");
    System.out.println("| 9. Submit Order");
    System.out.println("| 0. Cancel");
		System.out.println("+--------------------------------------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
  }

  public static void endOfList(UUID customerID) {
    System.out.println(ColorsUtility.BLUE + "+----------------------------------------------------------------------------------------------+");
		System.out.println("| All invoices for customer with ID of " + customerID + " have been displayed.");
		System.out.println("+----------------------------------------------------------------------------------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
  }

  public static void orderSubmitted() {
    System.out.println(ColorsUtility.BLUE + "+-----------------------------------------------------+");
		System.out.println("| Thank You. Order has been submitted to Jump E-Comm! |");
		System.out.println("+-----------------------------------------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
  }

  public static void noOrderSubmitted() {
    System.out.println(ColorsUtility.BLUE + "+----------------------------------+");
		System.out.println("| Now exiting shopping cart order. |");
    System.out.println("|   No order has been submitted.   |");
		System.out.println("+----------------------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
  }

  public static void noChangeToInvoice() {
    System.out.println("+---------------------+");
    System.out.println("| No Change to Invoice.");
    System.out.println("|  Returning to menu.");
    System.out.println("+---------------------+");
  }

  public static void replaceHeader() {
    System.out.println(ColorsUtility.BLUE + "+--------------------------+");
		System.out.println("| Replace and Return Items |");
		System.out.println("+--------------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
  }

  public static void replaceOptions() {
    System.out.println("1. RETURN AN ITEM");
    System.out.println("2. EXCHANGE AN ITEM");
    System.out.println("3. RETURN ALL ITEMS");
    System.out.println("4. MAIN MENU");
    System.out.println("\n");
  }

  public static void replaceItems() {
    System.out.println("1. HAT");
    System.out.println("2. JACKET");
    System.out.println("3. JEANS");
    System.out.println("4. SHIRT-LIGHT");
    System.out.println("5. SHIRT-DARK");
    System.out.println("6. SHOES");
    System.out.println("\n");
  }

	public static void exitHeading() {
		System.out.println(ColorsUtility.BLUE + "+-------------------------------------------------------+");
		System.out.println("| Now Exiting, Thank You for shopping with Jump E-Comm! |");
		System.out.println("+-------------------------------------------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
	}

  public static void incorrectLogin(int count) {
    System.out.println(ColorsUtility.RED + "+---------------------------------+");
		System.out.println("| Incorrect Email and/or Password |");
    System.out.println("|  You now have " + count + " attempts left   |");
		System.out.println("+---------------------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
  }

  public static void returnToMain() {
    System.out.println(ColorsUtility.BLUE + "+-----------------------+");
		System.out.println("| Returning to Main Menu |");
		System.out.println("+-----------------------+" + ColorsUtility.RESET);
    System.out.println("\n");
  }

  public static void returnAnItem(int hatsDiff, int jacketsDiff, int jeansDiff, int lShirtsDiff, int dShirtsDiff, int shoesDiff, int total, String returnType) {
    System.out.println("\n");
    System.out.println("| Items             Qty");
    System.out.println("| 1. Hat            " + hatsDiff);
    System.out.println("| 2. Jacket         " + jacketsDiff);
    System.out.println("| 3. Jeans          " + jeansDiff);
    System.out.println("| 4. Shirt-Light    " + lShirtsDiff);
    System.out.println("| 5. Shirt-Dark     " + dShirtsDiff);
    System.out.println("| 6. Shoes          " + shoesDiff);
    System.out.println("|");
    System.out.println("| Total to be return: " + total);
    System.out.println("|");
    if (returnType.equals("exchange")){
      System.out.println("| 9. Exchange Items");
    } else {
      System.out.println("| 9. Return Items");
    }
    System.out.println("| 0. Cancel");
    System.out.println("\n");
  }

}
