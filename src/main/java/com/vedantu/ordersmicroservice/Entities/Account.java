package com.vedantu.ordersmicroservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;


@Document
public class Account {

    @Id
    private String id;

    private String username;

    private String accountEmail;
    private String accountPhone;
    private String country;

    private List<Address> addresses;
    //private List<OrderInventory> cart;  // TODO
    private Order currentOrders;
    private List<Order> OrderHistory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Order getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(Order currentOrders) {
        this.currentOrders = currentOrders;
    }

    public List<Order> getOrderHistory() {
        return OrderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        OrderHistory = orderHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(username, account.username) &&
                Objects.equals(accountEmail, account.accountEmail) &&
                Objects.equals(accountPhone, account.accountPhone) &&
                Objects.equals(country, account.country) &&
                Objects.equals(addresses, account.addresses) &&
                Objects.equals(currentOrders, account.currentOrders) &&
                Objects.equals(OrderHistory, account.OrderHistory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, accountEmail, accountPhone, country, addresses, currentOrders, OrderHistory);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", accountEmail='" + accountEmail + '\'' +
                ", accountPhone='" + accountPhone + '\'' +
                ", country='" + country + '\'' +
                ", addresses=" + addresses +
                ", currentOrders=" + currentOrders +
                ", OrderHistory=" + OrderHistory +
                '}';
    }
}
