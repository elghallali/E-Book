package com.elghallali.ebook.service;

import com.elghallali.ebook.model.UserShipping;

public interface UserShippingService {

    UserShipping findById(Long id);

    void removeById(Long id);
}
