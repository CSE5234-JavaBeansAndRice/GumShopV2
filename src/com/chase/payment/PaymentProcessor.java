package com.chase.payment;

import java.util.Date;

public class PaymentProcessor {
    final String PING_MESSAGE = "Chase Bank Server is alive.";
    Date tsObj = new Date();

    public String ping() {
        return this.PING_MESSAGE + " | " + this.tsObj.getTime();
    }

    public String processPayment(CreditCardPayment ccPayment) {
        return "442365841885568";

    }

}
