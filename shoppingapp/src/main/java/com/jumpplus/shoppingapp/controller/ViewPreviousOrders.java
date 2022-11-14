package com.jumpplus.shoppingapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jumpplus.shoppingapp.data.DataCollections;
import com.jumpplus.shoppingapp.models.Invoice;
import com.jumpplus.shoppingapp.utility.PrinterUtility;

public class ViewPreviousOrders {
  public static void viewPreviousOrders(UUID customerID) {
    List<Invoice> invoices = new ArrayList<>();
    invoices = DataCollections.getInvoices();

    for (int i = 0; i < invoices.size(); i++) {
      if (invoices.get(i).getCustomerID().equals(customerID)){
        PrinterUtility.invoice(invoices.get(i));
      }
    }
    
    PrinterUtility.endOfList(customerID);
  }
}
