package com.jumpplus.shoppingapp.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jumpplus.shoppingapp.models.Customer;
import com.jumpplus.shoppingapp.models.Invoice;

public class DataCollections {
  static List<Customer> customers = new ArrayList<Customer>();
  static List<Invoice> invoices = new ArrayList<Invoice>();

  // Methods for customers
  public static void addCustomer(Customer customer) {
    customers.add(customer);
  }

  public static List<Customer> getCustomers() {
    return customers;
  }

  public static void deleteCustomer(UUID customerID) {
    int index = -1;
    for (int i = 0; i < customers.size(); i++) {
      Customer customer = customers.get(i);
      if (customer.getCustomerID().equals(customerID)) index = i;
    }
    customers.remove(index);
  }

  // Methods for invoices
  public static void addInvoice(Invoice invoice) {
    invoices.add(invoice);
  }

  public static List<Invoice> getInvoices() {
    return invoices;
  }

  public static void deleteInvoice(UUID invoiceID) {
    int index = -1;
    for (int i = 0; i < invoices.size(); i++) {
      Invoice invoice = invoices.get(i);
      if (invoice.getInvoiceID().equals(invoiceID)) index = i;
    }
    invoices.remove(index);
  }
}
