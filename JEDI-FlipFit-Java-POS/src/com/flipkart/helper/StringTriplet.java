package com.flipkart.helper;

public class StringTriplet {
    private String date;
    private String starttime;
    private String endtime;

    public StringTriplet(String date, String second, String endtime) {
        this.date = date;
        this.starttime = second;
        this.endtime = endtime;
    }

    public String getDate() {
        return date;
    }

    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    @Override
    public String toString() {
        return "(" + date + ", " + starttime + ", " + endtime + ")";
    }
}
