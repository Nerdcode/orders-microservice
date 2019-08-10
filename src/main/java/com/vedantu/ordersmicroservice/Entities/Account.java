package com.vedantu.ordersmicroservice.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Document
public class Account {

    @Id
    @Field("account_id")
    private String accountId;

    private String username;

    @Field("account_email")
    private String accountEmail;

    @Field("account_phone")
    private String accountPhone;
    private String country;

    private List<Address> addresses;
    //private List<OrderInventory> cart;  // TODO

    @Field("current_order")
    private List<Order> currentOrders;

    @Field("order_history")
    private List<Order> OrderHistory;

}
