package com.vedantu.ordersmicroservice.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Document
public class StockInventory extends Inventory {

    @Field("in_stock_quantity")
    private int inStockQuantity;

    @Field("sold_quantity")
    private int soldQuantity;

    private double mrp;
    private double discount; //in percentage

}
