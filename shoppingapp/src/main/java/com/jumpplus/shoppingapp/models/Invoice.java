package com.jumpplus.shoppingapp.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;


public class Invoice implements Serializable {

  private static final long serialVersionUID = 171048141367869761L;
  
  UUID invoiceID;
  UUID customerID;
  LocalDate invoiceDate;
  LocalTime invoiceTime;
  List<Item> items;

  public Invoice(UUID customerID, List<Item> items) {
    this.invoiceID = createInvoiceID();
    this.customerID = customerID;
    this.invoiceDate = createInvoiceDate();
    this.invoiceTime = createInvoiceTime();
    this.items = items;
  }

  private UUID createInvoiceID() {
    return UUID.randomUUID();
  }

  private LocalDate createInvoiceDate() {
    LocalDate myDate = LocalDate.now();
    return myDate;
  }

  private LocalTime createInvoiceTime() {
    LocalTime myTime = LocalTime.now();
    return myTime;
  }

  public UUID getInvoiceID() {
    return this.invoiceID;
  }

  public void setInvoiceID(UUID invoiceID) {
    this.invoiceID = invoiceID;
  }

  public UUID getCustomerID() {
    return this.customerID;
  }

  public void setCustomerID(UUID customerID) {
    this.customerID = customerID;
  }

  public LocalDate getInvoiceDate() {
    return this.invoiceDate;
  }

  public void setInvoiceDate(LocalDate invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public LocalTime getInvoiceTime() {
    return this.invoiceTime;
  }

  public void setInvoiceTime(LocalTime invoiceTime) {
    this.invoiceTime = invoiceTime;
  }

  public List<Item> getItems() {
    return this.items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  @Override
  public String toString() {
    return "{" +
      " invoiceID='" + getInvoiceID() + "'" +
      ", customerID='" + getCustomerID() + "'" +
      ", invoiceDate='" + getInvoiceDate() + "'" +
      ", items='" + getItems() + "'" +
      "}";
  }

}
