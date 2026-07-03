package com.library.controller;

import com.library.model.Book;
import com.library.repository.BookJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookJpaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        Optional<Book> book = bookJpaRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookJpaRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        Optional<Book> existing = bookJpaRepository.findById(id);
        if (existing.isPresent()) {
            Book book = existing.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return bookJpaRepository.save(book);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookJpaRepository.deleteById(id);
        return "Book deleted with id: " + id;
    }
}
