package com.training.restbasics.controllers;

import com.training.restbasics.BookService;
import com.training.restbasics.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/books")
@RestController
// Before using this file, create request.http U file in VS Code
// Type in the necessary details and come back
public class BookController {
    // Autowired is an instruction to Spring Boot to check if there is any object called service
    // Next, SPring boot asks if there is any datatype with that name service , but here it says no!
    // As the object of Book service is not found
    // TO rectify the error, go to that BookService class and add @Service
    // Now, the name "bookService" will be matched object BookService by SpringBoot

    // Simply put, Spring Container automatically injects a suitable object of either with
    // a matching name or object if found Else, it throws error and the application quits
    @Autowired
    BookService bookService;
   public BookController()
    {
        log.info("BookController is instantiated. ");
        // The log wont be displayed as we havent yet created its object by default
        // That is because sprinboot doesnt know about it until you add
        // @RestController
    }


    // Writing GET handler for /api/books
    @GetMapping
    public  Iterable<Book> handleGetBooks()
    {
        return bookService.getAllBooks();
    }
    // Right now it fails if we request for xml format in requests.http U
    // But runs when rquested for JSON format


    // http://localhost:8080/api/books/2
    @GetMapping("/{id}")
    public Book handleGetBookById(@PathVariable Integer id)
    {
        return  bookService.getBookById(id);
    }
}
