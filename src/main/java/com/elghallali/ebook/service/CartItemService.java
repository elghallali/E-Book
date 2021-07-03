package com.elghallali.ebook.service;

import java.util.List;

import com.elghallali.ebook.model.Book;
import com.elghallali.ebook.model.CartItem;
import com.elghallali.ebook.model.Order;
import com.elghallali.ebook.model.ShoppingCart;
import com.elghallali.ebook.model.User;

public interface CartItemService {

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    CartItem updateCartItem(CartItem cartItem);

    CartItem addBookToCartItem(Book book, User user, int qty);

    CartItem findById(Long id);

    void removeCartItem(CartItem cartItem);

    CartItem save(CartItem cartItem);

    List<CartItem> findByOrder(Order order);

}
