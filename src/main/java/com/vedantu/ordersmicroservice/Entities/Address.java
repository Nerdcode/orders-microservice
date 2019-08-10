package com.vedantu.ordersmicroservice.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Document
public class Address {

    @Id
    @Field("address_id")
    private String addressId;

    private String name; //name associated with address
    private String phone;

    @Field("address_line1")
    private String addLine1; //Flat/ House / Floor / Building

    @Field("address_line1")
    private String addLine2; // street address

    private String landmark;
    private String city;
    private String state;
    private String country;

    @Field("pin_code")
    private String pincode;

    @Field("address_type")
    private String addressType;

}
