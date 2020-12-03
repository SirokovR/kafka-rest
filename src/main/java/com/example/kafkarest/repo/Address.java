package com.example.kafkarest.repo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Address{
    private String country;
    private String city;
    private String street;
    private Long homeNumber;
    private Long flatNumber;

    public Address(String country, String city, String street, Long homeNumber, Long flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.flatNumber = flatNumber;
    }
}
