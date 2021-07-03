package com.elghallali.ebook.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.elghallali.ebook.model.CartItem;
import com.elghallali.ebook.model.Order;
import com.elghallali.ebook.model.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    List<CartItem> findByOrder(Order order);
}
