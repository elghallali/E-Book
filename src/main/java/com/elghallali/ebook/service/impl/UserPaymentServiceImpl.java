package com.elghallali.ebook.service.impl;

import com.elghallali.ebook.model.UserPayment;
import com.elghallali.ebook.repository.UserPaymentRepository;
import com.elghallali.ebook.service.UserPaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    private UserPaymentRepository userPaymentRepository;

    public UserPayment findById(Long id) {
        return userPaymentRepository.findById(id).orElse(null);
    }

    public void removeById(Long id) {
        userPaymentRepository.deleteById(id);
    }
}
