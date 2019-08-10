package com.vedantu.ordersmicroservice.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Document
public class Address {

    @Id
    private String id;
    private String phone;
    private String addLine1; //Flat/ House / Floor / Building
    private String addLine2; // street address
    private String landmark;
    private String city;
    private String state;
    private String country;
    private String pincode;

    private String addressType;
}
