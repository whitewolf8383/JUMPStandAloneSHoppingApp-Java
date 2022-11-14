package com.jumpplus.shoppingapp.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.jumpplus.shoppingapp.data.DataCollections;
import com.jumpplus.shoppingapp.models.Invoice;
import com.jumpplus.shoppingapp.utility.PrinterUtility;

public class ReplaceAnItem {

  public static void replaceAnItem(UUID customerID) {
    Scanner replaceScanner = new Scanner(System.in);
    List<Invoice> invoices = DataCollections.getInvoices();
    int invoiceIndex = 0;
    LocalDate currentDate = LocalDate.now();
    boolean invoicePresent = false;
    String input;

    PrinterUtility.replaceHeader();

    System.out.println('\n');
    System.out.println("Please enter the invoice number you'd like to modify.");
    input = replaceScanner.nextLine().trim();
    System.out.println('\n');

    for (int i = 0; i < invoices.size(); i++) {
      if (invoices.get(i).getInvoiceID().toString().equals(input)) {
        invoiceIndex = i;
        invoicePresent = true;
      }
    }

    if(invoicePresent) {
      System.out.println("Please verify this is the correct order.");
      PrinterUtility.invoice(invoices.get(invoiceIndex));
      Long duration = Duration.between(currentDate.atStartOfDay(), invoices.get(invoiceIndex).getInvoiceDate().atStartOfDay()).toDays();
      System.out.println("Duration: " + duration);
      if(duration <= 15) {
        do {
          System.out.println("\n");
          PrinterUtility.replaceOptions();
          System.out.println("What would you like to do?");
          input = replaceScanner.nextLine().trim();
          switch(input) {
            case "1":
              ReturnAnItem.returnAnItem(invoices.get(invoiceIndex));
              break;
            case "2":
              ExchangeAnItem.exchangeAnItem(invoices.get(invoiceIndex));
              break;
            case "3":
              ReturnAnItem.returnAllItems(invoices.get(invoiceIndex));
            case "4": break;
            default:
              System.out.println("Invalid Input. Please select from the options only.");
          }
        } while (!input.equals("4"));
      } else {
        System.out.println("Sorry, that invoice isbeyond the 15 day return limit.");
      }
      
    } else {
      System.out.println("Sorry, that invoice doesn't exist");
      System.out.println("Please verify the InvoiceID and try again.");
    }
  }
  
}
