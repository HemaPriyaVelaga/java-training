package com.training.restbasics;

import com.training.restbasics.entity.Book;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

// Springboot automatically creates an object of this service and keeps it in spring container
@Service
public class BookService {
    Map<Integer, Book> books = new LinkedHashMap<>();
    public BookService()
    {
        Book b1 ;
        b1 = new Book(1, "Let us C", Arrays.asList("xyz"), 300.0, 250);
        books.put(b1.getId(), b1);
        b1 = new Book(2, "Machine Learning", Arrays.asList("Hema", "Priya"), 500.0, 200);
        books.put(b1.getId(), b1);
        b1 = new Book(3, "Java For dummies", Arrays.asList("Jane Doe", "John Doe"), 800.0, 500);
        books.put(b1.getId(), b1);

    }

    public Book getBookById(Integer id)
    {
        return books.get(id);
    }

    public Iterable<Book> getAllBooks()
    {
        return books.values();
    }
}
