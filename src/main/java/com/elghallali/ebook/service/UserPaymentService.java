package com.elghallali.ebook.service;

import com.elghallali.ebook.model.UserPayment;

public interface UserPaymentService {

    UserPayment findById(Long id);

    void removeById(Long id);
}
