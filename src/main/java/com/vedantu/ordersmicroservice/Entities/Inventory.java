package com.vedantu.ordersmicroservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Inventory {

    @Id
    private String id;

    private String itemName;

    //TODO
    //Can be extended to store other parameters
    //like type(fashion, electronics, grocery), models, colors, sizes n etc


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(id, inventory.id) &&
                Objects.equals(itemName, inventory.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
