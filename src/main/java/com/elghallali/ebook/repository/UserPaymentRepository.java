package com.elghallali.ebook.repository;

import com.elghallali.ebook.model.UserPayment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {

}
