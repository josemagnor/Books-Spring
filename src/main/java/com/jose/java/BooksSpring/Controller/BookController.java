package com.jose.java.BooksSpring.Controller;

import com.jose.java.BooksSpring.Domain.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jose.java.BooksSpring.Repository.BookRepository;

@RestController
public class BookController {
    private final BookRepository bookRepository;
    
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    
    @GetMapping("/books")
    public List<Book> all(){
        return bookRepository.findAll();
    }

    @SuppressWarnings("null")
    @GetMapping("/books/{id}")
    public Optional<Book> one(@PathVariable Long id){
        Optional<Book> book = bookRepository.findById(id);

        return book;
    }
    
}
