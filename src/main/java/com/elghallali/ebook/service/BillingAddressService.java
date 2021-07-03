package com.elghallali.ebook.service;

import com.elghallali.ebook.model.BillingAddress;
import com.elghallali.ebook.model.UserBilling;

public interface BillingAddressService {

    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);

}