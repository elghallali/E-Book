package com.elghallali.ebook.service;

import com.elghallali.ebook.model.Payment;
import com.elghallali.ebook.model.UserPayment;

public interface PaymentService {

    Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
