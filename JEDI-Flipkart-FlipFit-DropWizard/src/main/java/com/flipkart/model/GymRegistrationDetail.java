package com.flipkart.model;


public class GymRegistrationDetail {


    private String name;


    private String address;


    private String city;




    // Constructors
    public GymRegistrationDetail() {}

    public GymRegistrationDetail(String name, String address, String city, String gymOwnerId) {
        this.name = name;
        this.address = address;
        this.city = city;

    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
