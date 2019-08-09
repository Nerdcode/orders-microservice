package com.vedantu.ordersmicroservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document
public class Order {

    @Id
    private String id;

    private List<OrderInventory> items;

    private LocalDateTime orderDate;

    private boolean isDelivered; // true - orderhistory, false - current order
    private LocalDateTime deliveredDate;

    private Address shippingAddress;

    //TODO
    //private OrderValue ordervalue;
    // seperate class can be created with parameters like
    // delivery charge, promotion applied an etc
    // but instead summing up all items prices (simplified)

    //TODO
    //Can be extended to store other key parameters
    //like payment method and delivery method, delivery partner, etc


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrderInventory> getItems() {
        return items;
    }

    public void setItems(List<OrderInventory> items) {
        this.items = items;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public LocalDateTime getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDateTime deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return isDelivered == order.isDelivered &&
                Objects.equals(id, order.id) &&
                Objects.equals(items, order.items) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(deliveredDate, order.deliveredDate) &&
                Objects.equals(shippingAddress, order.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items, orderDate, isDelivered, deliveredDate, shippingAddress);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", items=" + items +
                ", orderDate=" + orderDate +
                ", isDelivered=" + isDelivered +
                ", deliveredDate=" + deliveredDate +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
