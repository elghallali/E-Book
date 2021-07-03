package com.elghallali.ebook.repository;

import com.elghallali.ebook.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
