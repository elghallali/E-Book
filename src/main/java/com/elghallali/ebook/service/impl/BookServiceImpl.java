package com.elghallali.ebook.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.elghallali.ebook.model.Book;
import com.elghallali.ebook.repository.BookRepository;
import com.elghallali.ebook.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        List<Book> bookList = (List<Book>) bookRepository.findAll();
        List<Book> activeBookList = new ArrayList<>();

        for (Book book : bookList) {
            if (book.isActive()) {
                activeBookList.add(book);
            }
        }

        return activeBookList;
    }

    public Book findOne(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findByCategory(String category) {
        List<Book> bookList = bookRepository.findByCategory(category);

        List<Book> activeBookList = new ArrayList<>();

        for (Book book : bookList) {
            if (book.isActive()) {
                activeBookList.add(book);
            }
        }

        return activeBookList;
    }

    public List<Book> blurrySearch(String title) {
        List<Book> bookList = bookRepository.findByTitleContaining(title);
        List<Book> activeBookList = new ArrayList<>();

        for (Book book : bookList) {
            if (book.isActive()) {
                activeBookList.add(book);
            }
        }

        return activeBookList;
    }

    @Override
    public Book save(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public void removeOne(Long id) {
        bookRepository.deleteById(id);
    }

    /*
     * /
     * 
     * @Override public Page<Book> findAll(Pageable pageable) { return
     * bookRepository.findAll(pageable);
     * 
     * } /
     */
    @Override
    public Long countBooks() {
        return bookRepository.count();
    }

}
