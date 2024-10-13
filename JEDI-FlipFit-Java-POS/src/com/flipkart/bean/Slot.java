package com.flipkart.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Slot {


    private String slotID;
    private String GymId;
    private String starttime;
    private String endtime;
    private String date;
    private int capacity;

    public Slot(String gymId, String slotID, String date, String starttime, String endtime, int capacity) {
        GymId = gymId;
        this.slotID = slotID;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
        this.capacity = capacity;
    }



    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public String getGymId() {
        return GymId;
    }

    public void setGymId(String gymId) {
        GymId = gymId;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }




}
