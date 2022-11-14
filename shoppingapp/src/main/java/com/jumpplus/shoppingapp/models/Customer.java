package com.jumpplus.shoppingapp.models;

import java.io.Serializable;
import java.util.UUID;

public class Customer implements Serializable {

  private static final long serialVersionUID = -977293727194714630L;

  UUID customerID;
  String name;
  String email;
  String password;

  public Customer(String name, String email, String password) {
    this.customerID = createCustomerID();
    this.name = name;
    this.email = email;
    this.password = password;
  }

  private UUID createCustomerID() {
    return UUID.randomUUID();
  }

  public UUID getCustomerID() {
    return this.customerID;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "{" +
      " customerID='" + getCustomerID() + "'" +
      " name='" + getName() + "'" +
      ", email='" + getEmail() + "'" +
      "}";
  }
  
}
