package com.flipkart.bean;

/**
 *
 * Represents a payment in the FlipFit system.
 * Each payment is associated with a card and contains details such as payments ID and card details.
 * @author shubham dash
 */
public class Payment {
    private int paymentsId;
    private String cardNumber;
    private String expiryDate;
    private String name;
    private String cvv;

    /**
     * Retrieves the ID of the payment.
     * @return ID of the payment
     */
    public int getPaymentsId() {
        return paymentsId;
    }

    /**
     * Sets paymentID for a particular payment
     * @param paymentsId ID of the booking
     */
    public void setPaymentsId(int paymentsId) {
        this.paymentsId = paymentsId;
    }

    /**
     * Retrieves the cardNumber of the card used to pay.
     * @return card number of the card.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the cardNumber of the card used to pay.
     * @param cardNumber card number of the card.
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Retrieves the expiry date of the card used to pay.
     * @return expiry date of the card.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiry date of the card used to pay.
     * @param expiryDate expiry date of the card.
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Retrieves the name associated with the card used to pay.
     * @return name associated with the card.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name associated with the card used to pay.
     * @param name name associated with the card.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the cvv of card used to pay.
     * @return cvv of the card.
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Sets the cvv of the card used to pay.
     * @param cvv name associated with the card.
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
