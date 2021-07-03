package com.elghallali.ebook.service.impl;

import java.util.Calendar;
import java.util.List;

import com.elghallali.ebook.model.BillingAddress;
import com.elghallali.ebook.model.Book;
import com.elghallali.ebook.model.CartItem;
import com.elghallali.ebook.model.Order;
import com.elghallali.ebook.model.Payment;
import com.elghallali.ebook.model.ShippingAddress;
import com.elghallali.ebook.model.ShoppingCart;
import com.elghallali.ebook.model.User;
import com.elghallali.ebook.repository.OrderRepository;
import com.elghallali.ebook.service.CartItemService;
import com.elghallali.ebook.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemService cartItemService;

    public synchronized Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress,
            BillingAddress billingAddress, Payment payment, String shippingMethod, User user) {
        Order order = new Order();
        order.setBillingAddress(billingAddress);
        order.setOrderStatus("created");
        order.setPayment(payment);
        order.setShippingAddress(shippingAddress);
        order.setShippingMethod(shippingMethod);

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        for (CartItem cartItem : cartItemList) {
            Book book = cartItem.getBook();
            cartItem.setOrder(order);
            book.setInStockNumber(book.getInStockNumber() - cartItem.getQty());
        }

        order.setCartItemList(cartItemList);
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setOrderTotal(shoppingCart.getGrandTotal());
        shippingAddress.setOrder(order);
        billingAddress.setOrder(order);
        payment.setOrder(order);
        order.setUser(user);
        order = orderRepository.save(order);

        return order;
    }

    public Order findOne(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

}
