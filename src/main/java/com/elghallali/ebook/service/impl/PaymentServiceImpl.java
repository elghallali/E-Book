package com.elghallali.ebook.service.impl;

import com.elghallali.ebook.model.Payment;
import com.elghallali.ebook.model.UserPayment;
import com.elghallali.ebook.service.PaymentService;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
        payment.setType(userPayment.getType());
        payment.setHolderName(userPayment.getHolderName());
        payment.setCardNumber(userPayment.getCardNumber());
        payment.setExpiryMonth(userPayment.getExpiryMonth());
        payment.setExpiryYear(userPayment.getExpiryYear());
        payment.setCvc(userPayment.getCvc());

        return payment;
    }

}