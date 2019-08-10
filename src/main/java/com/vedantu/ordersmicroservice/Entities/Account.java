package com.vedantu.ordersmicroservice.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode

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

}
