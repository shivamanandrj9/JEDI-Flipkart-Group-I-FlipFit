package com.flipkart.model;

public class PaymentDetail {
    private String cardNumber;   // Card number
    private String expiryDate;    // Expiry date (MM/YYYY)
    private String name;          // Name on the card
    private String cvv;           // CVV number

    // Constructors
    public PaymentDetail() {
    }

    public PaymentDetail(String cardNumber, String expiryDate, String name, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.name = name;
        this.cvv = cvv;
    }

    // Getters and Setters
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
