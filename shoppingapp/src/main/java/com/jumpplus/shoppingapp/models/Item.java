package com.jumpplus.shoppingapp.models;

import java.io.Serializable;

public class Item implements Serializable {

  private static final long serialVersionUID = 658923796762857015L;

  String itemName;
  String itemCode;
  int itemPrice;
  int quantity;
  
  public Item(String itemName, String itemCode, int itemPrice, int quantity) {
    this.itemName = itemName;
    this.itemCode = itemCode;
    this.itemPrice = itemPrice;
    this.quantity = quantity;
  }

  public String getItemName() {
    return this.itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemCode() {
    return this.itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  public int getItemPrice() {
    return this.itemPrice;
  }

  public void setItemPrice(int itemPrice) {
    this.itemPrice = itemPrice;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "{" +
      " itemName='" + getItemName() + "'" +
      ", itemCode='" + getItemCode() + "'" +
      ", itemPrice='" + getItemPrice() + "'" +
      ", quantity='" + getQuantity() + "'" +
      "}";
  }

}
