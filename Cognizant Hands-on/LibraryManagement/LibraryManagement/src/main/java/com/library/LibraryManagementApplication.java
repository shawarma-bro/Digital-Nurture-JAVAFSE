package com.library;

import com.library.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {

        System.out.println("--- Testing Spring XML Context (Ex 1-8) ---");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.addBook("Clean Code");
        bookService.listBooks();
        bookService.removeBook(1);

        System.out.println();
        System.out.println("--- Starting Spring Boot Application (Ex 9) ---");
        SpringApplication.run(LibraryManagementApplication.class, args);
    }
}
