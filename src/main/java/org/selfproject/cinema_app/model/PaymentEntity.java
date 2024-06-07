package org.selfproject.cinema_app.model;

import jakarta.persistence.*;

@Entity
@Table(name="Payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Float amount;
    private String paymentMethod;
    private Integer cardNumber;
    private Integer expiry;
    private Integer cvv;
    private String billingAddress;


    public PaymentEntity(Float amount, Long userId, String paymentMethod, Integer cardNumber, Integer expiry, Integer cvv, String billingAddress) {
        this.amount = amount;
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.cvv = cvv;
        this.billingAddress = billingAddress;

    }
    public PaymentEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {this.cardNumber = cardNumber;}

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", amount='" + amount + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiry='" + expiry + '\'' +
                ", cvv='" + cvv + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                '}';
    }
}


