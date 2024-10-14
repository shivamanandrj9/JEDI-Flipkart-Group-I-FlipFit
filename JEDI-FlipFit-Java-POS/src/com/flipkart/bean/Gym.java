package com.flipkart.bean;

/**
 * Represents a gym center in the FlipFit system.
 */
public class Gym {

    private String gymId;
    private String gymName;
    private String address;
    private String city;
    private String gymOwnerID;
    private boolean isListed;

    /**
     * Parameterized constructor to initialize gym center details.
     * @param gymId ID of the gym center
     * @param gymOwnerID ID of the owner of the gym center
     * @param gymName Name of the gym center
     * @param address address of the gym centre
     * @param city City where the gym center is located
     * @param isListed Approval status of the gym center
     */
    public Gym(String gymId, String gymName, String address, String city, String gymOwnerID,boolean isListed) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.address = address;
        this.city = city;
        this.gymOwnerID = gymOwnerID;
        this.isListed = isListed;
    }

    /**
     * Retrieves the ID of the gym center.
     * @return ID of the gym center
     */
    public String getGymId() {
        return gymId;
    }

    /**
     * Sets the ID of the gym center.
     * @param gymId ID to set
     */
    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    /**
     * Retrieves the name of the gym center.
     * @return Name of the gym center
     */
    public String getGymName() {
        return gymName;
    }

    /**
     * Sets the name of the gym center.
     * @param gymName Name to set
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Retrieves the address of the gym center.
     * @return address of the gym center
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the gym center.
     * @param address Name to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the city where the gym center is located.
     * @return City of the gym center
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city where the gym center is located.
     * @param city City to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retrieves the ID of the owner of the gym center.
     * @return Owner ID of the gym center
     */
    public String getGymOwnerID() {
        return gymOwnerID;
    }

    /**
     * Sets the ID of the owner of the gym center.
     * @param gymOwnerID Owner ID to set
     */
    public void setGymOwnerID(String gymOwnerID) {
        this.gymOwnerID = gymOwnerID;
    }

    /**
     * Checks if the gym center is approved.
     * @return True if the gym center is approved, false otherwise
     */
    public boolean getIsListed() {
        return isListed;
    }

    /**
     * Sets the approval status of the gym center.
     * @param isListed Approval status to set
     */
    public void setIsListed(boolean isListed) {
        this.isListed = isListed;
    }

}
