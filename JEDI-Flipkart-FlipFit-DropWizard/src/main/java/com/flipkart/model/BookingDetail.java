package com.flipkart.model;

public class BookingDetail {


    private String slotId;    // ID of the selected slot
    private PaymentDetail payment;   // Payment details

    // Constructors
    public BookingDetail() {
    }

    public BookingDetail(String slotId, PaymentDetail payment) {


        this.slotId = slotId;
        this.payment = payment;
    }






    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public PaymentDetail getPayment() {
        return payment;
    }

    public void setPayment(PaymentDetail payment) {
        this.payment = payment;
    }
}
