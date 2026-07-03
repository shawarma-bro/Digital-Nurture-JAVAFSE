package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public void saveBook(String title) {
        System.out.println("Book saved to database: " + title);
    }

    public void deleteBook(int id) {
        System.out.println("Book deleted with id: " + id);
    }

    public void findAllBooks() {
        System.out.println("Fetching all books from database...");
    }
}
