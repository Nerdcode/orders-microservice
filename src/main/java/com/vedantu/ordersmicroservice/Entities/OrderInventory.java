package com.vedantu.ordersmicroservice.Entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class OrderInventory extends Inventory {

    private int quantity;

    private double price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OrderInventory that = (OrderInventory) o;
        return quantity == that.quantity &&
                Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, price);
    }

    @Override
    public String toString() {
        return "OrderInventory{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
