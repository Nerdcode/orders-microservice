package com.vedantu.ordersmicroservice.Entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class StockInventory extends Inventory {

    private int inStock;
    private int soldQuantity;
    private double mrp;
    private double discount; //in percentage

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StockInventory that = (StockInventory) o;
        return inStock == that.inStock &&
                soldQuantity == that.soldQuantity &&
                Double.compare(that.mrp, mrp) == 0 &&
                Double.compare(that.discount, discount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inStock, soldQuantity, mrp, discount);
    }

    @Override
    public String toString() {
        return "StockInventory{" +
                "inStock=" + inStock +
                ", soldQuantity=" + soldQuantity +
                ", mrp=" + mrp +
                ", discount=" + discount +
                '}';
    }
}
