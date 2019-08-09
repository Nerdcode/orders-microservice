package com.vedantu.ordersmicroservice.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddLine1() {
        return addLine1;
    }

    public void setAddLine1(String addLine1) {
        this.addLine1 = addLine1;
    }

    public String getAddLine2() {
        return addLine2;
    }

    public void setAddLine2(String addLine2) {
        this.addLine2 = addLine2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(phone, address.phone) &&
                Objects.equals(addLine1, address.addLine1) &&
                Objects.equals(addLine2, address.addLine2) &&
                Objects.equals(landmark, address.landmark) &&
                Objects.equals(city, address.city) &&
                Objects.equals(state, address.state) &&
                Objects.equals(country, address.country) &&
                Objects.equals(pincode, address.pincode) &&
                Objects.equals(addressType, address.addressType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, addLine1, addLine2, landmark, city, state, country, pincode, addressType);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", addLine1='" + addLine1 + '\'' +
                ", addLine2='" + addLine2 + '\'' +
                ", landmark='" + landmark + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode='" + pincode + '\'' +
                ", addressType='" + addressType + '\'' +
                '}';
    }
}
