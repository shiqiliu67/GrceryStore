package com.junfan.grocerystore;

public class Card {
    private String firstName;
    private String lastName;
    private String cardNumber;
    private int cvv;
    private String expiration;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public String getExpiration() {
        return expiration;
    }
}
