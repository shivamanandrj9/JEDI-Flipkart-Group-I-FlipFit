package com.flipkart.bean;

/**
 * Represents a Slot for a gym with details like start time, end time, date, and capacity.
 */
public class Slot {


    private String slotID;
    private String GymId;
    private String starttime;
    private String endtime;
    private String date;
    private int capacity;

    /**
     * Constructs a new Slot with the specified details.
     *
     * @param gymId     The unique ID of the gym.
     * @param slotID    The unique ID of the slot.
     * @param date      The date of the slot (yyyy-MM-dd).
     * @param starttime The start time of the slot.
     * @param endtime   The end time of the slot.
     * @param capacity  The capacity of the slot.
     */
    public Slot(String gymId, String slotID, String date, String starttime, String endtime, int capacity) {
        GymId = gymId;
        this.slotID = slotID;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
        this.capacity = capacity;
    }


    /**
     * @return The unique ID of the slot.
     */
    public String getSlotID() {
        return slotID;
    }

    /**
     * Sets the unique ID of the slot.
     *
     * @param slotID The slot ID to be set.
     */
    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    /**
     * @return The unique ID of the gym associated with the slot.
     */
    public String getGymId() {
        return GymId;
    }

    /**
     * Sets the unique ID of the gym associated with the slot.
     *
     * @param gymId The gym ID to be set.
     */
    public void setGymId(String gymId) {
        GymId = gymId;
    }

    /**
     * @return The end time of the slot.
     */
    public String getEndtime() {
        return endtime;
    }

    /**
     * @return The date of the slot in yyyy-MM-dd format.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the slot.
     *
     * @param date The date to be set (yyyy-MM-dd).
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Sets the end time of the slot.
     *
     * @param endtime The end time to be set.
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    /**
     * @return The start time of the slot.
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * Sets the start time of the slot.
     *
     * @param starttime The start time to be set.
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    /**
     * @return The capacity of the slot.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the capacity of the slot.
     *
     * @param capacity The capacity to be set.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
