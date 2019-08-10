package com.vedantu.ordersmicroservice.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Document
public class OrderInventory extends Inventory {

    private int quantity;

    private double price;

    @Field("is_delivered")
    private boolean isDelivered; // true - orderhistory, false - current order

}
