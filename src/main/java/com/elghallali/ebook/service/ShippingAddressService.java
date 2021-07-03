package com.elghallali.ebook.service;

import com.elghallali.ebook.model.ShippingAddress;
import com.elghallali.ebook.model.UserShipping;

public interface ShippingAddressService {
    ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);

}
