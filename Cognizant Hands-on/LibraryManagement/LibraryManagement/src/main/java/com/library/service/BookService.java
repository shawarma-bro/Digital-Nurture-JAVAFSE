package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;
    private String appName;

    public BookService() {
    }

    public BookService(String appName) {
        this.appName = appName;
        System.out.println("BookService created for application: " + appName);
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println("BookService: adding book -> " + title);
        bookRepository.saveBook(title);
    }

    public void removeBook(int id) {
        System.out.println("BookService: removing book with id -> " + id);
        bookRepository.deleteBook(id);
    }

    public void listBooks() {
        System.out.println("BookService: listing all books");
        bookRepository.findAllBooks();
    }
}
