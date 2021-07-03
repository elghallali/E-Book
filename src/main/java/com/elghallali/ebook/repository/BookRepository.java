package com.elghallali.ebook.repository;

import java.util.List;

import com.elghallali.ebook.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByCategory(String category);

    List<Book> findByTitleContaining(String title);

    // Page<Book> findAll(Pageable pageable);

}