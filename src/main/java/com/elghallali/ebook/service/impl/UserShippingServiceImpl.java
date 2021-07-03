package com.elghallali.ebook.service.impl;

import com.elghallali.ebook.model.UserShipping;
import com.elghallali.ebook.repository.UserShippingRepository;
import com.elghallali.ebook.service.UserShippingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShippingServiceImpl implements UserShippingService {

    @Autowired
    private UserShippingRepository userShippingRepository;

    public UserShipping findById(Long id) {
        return userShippingRepository.findById(id).orElse(null);
    }

    public void removeById(Long id) {
        userShippingRepository.deleteById(id);
    }

}
