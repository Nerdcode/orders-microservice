package com.vedantu.ordersmicroservice.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@EqualsAndHashCode

@Document
public class Order {

    @Id
    @Field("order_id")
    private String order_id;

    private List<OrderInventory> items;

    @Field("order_date")
    private LocalDateTime orderDate;



    @Field("shipping_address")
    private Address shippingAddress;

    //TODO
    //private OrderValue ordervalue;
    // seperate class can be created with parameters like
    // delivery charge, promotion applied an etc
    // but instead summing up all items prices (simplified)

    //TODO
    //Can be extended to store other key parameters
    //like payment method and delivery method, delivery partner, etc

}
