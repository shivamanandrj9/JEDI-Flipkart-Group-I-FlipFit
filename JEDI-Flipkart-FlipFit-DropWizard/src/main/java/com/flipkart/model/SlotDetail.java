package com.flipkart.model;

public class SlotDetail {
    private String gymId;       // Gym ID where the slot is being added
    private String date;        // Date in DD/MM/YYYY format
    private String startTime;   // Start time in 24-hour format (0000-2359)
    private String endTime;     // End time in 24-hour format (0000-2359)
    private int capacity;       // Capacity or number of vacancies

    // Constructors
    public SlotDetail() {}

    public SlotDetail(String gymId, String date, String startTime, String endTime, int capacity) {
        this.gymId = gymId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
    }

    // Getters and setters
    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
