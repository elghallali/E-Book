package com.elghallali.ebook.service;

import com.elghallali.ebook.model.BillingAddress;
import com.elghallali.ebook.model.Order;
import com.elghallali.ebook.model.Payment;
import com.elghallali.ebook.model.ShippingAddress;
import com.elghallali.ebook.model.ShoppingCart;
import com.elghallali.ebook.model.User;

public interface OrderService {

    Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
            Payment payment, String shippingMethod, User user);

    Order findOne(Long id);

}
