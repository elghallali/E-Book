package com.elghallali.ebook.repository;

import javax.transaction.Transactional;

import com.elghallali.ebook.model.BookToCartItem;
import com.elghallali.ebook.model.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface BookToCartItemRepository extends JpaRepository<BookToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
