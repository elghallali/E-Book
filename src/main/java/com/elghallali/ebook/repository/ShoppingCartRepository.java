package com.elghallali.ebook.repository;

import com.elghallali.ebook.model.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}