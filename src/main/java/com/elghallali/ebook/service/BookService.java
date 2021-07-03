package com.elghallali.ebook.service;

import java.util.List;

import com.elghallali.ebook.model.Book;

public interface BookService {

	List<Book> findAll();

	Book findOne(Long id);

	List<Book> findByCategory(String category);

	List<Book> blurrySearch(String title);

	Book save(Book book);

	void removeOne(Long id);

	// Page<Book> findAll(Pageable pageable);

	Long countBooks();

}
