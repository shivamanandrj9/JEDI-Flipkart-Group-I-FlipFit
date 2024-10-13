package com.flipkart.bean;

public class Gym {

    private String gymId;
    private String gymName;
    private String address;
    private String city;
    private String gymOwnerID;
    private boolean isListed;

    public Gym(String gymId, String gymName, String address, String city, String gymOwnerID,boolean isListed) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.address = address;
        this.city = city;
        this.gymOwnerID = gymOwnerID;
        this.isListed = isListed;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
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

    public String getGymOwnerID() {
        return gymOwnerID;
    }

    public void setGymOwnerID(String gymOwnerID) {
        this.gymOwnerID = gymOwnerID;
    }

    public boolean getIsListed() {
        return isListed;
    }

    public void setIsListed(boolean isListed) {
        this.isListed = isListed;
    }

}
