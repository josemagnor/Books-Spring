package com.jose.java.BooksSpring.Controller;

import com.jose.java.BooksSpring.Domain.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/books")
    public Book create(@RequestBody Book newBook){
        bookRepository.save(newBook);
        return newBook;
    }

    @SuppressWarnings("null")
    @PutMapping("/books/{id}")
    public Book update(@RequestBody Book newBook, @PathVariable Long id){
        return bookRepository.findById(id)
        .map(book -> {
          book.setTitle(newBook.getTitle());
          book.setAuthor(newBook.getAuthor());
          return bookRepository.save(book);
        })
        .orElseGet(() -> {
          newBook.setId(id);
          return bookRepository.save(newBook);
        });
    }


    @SuppressWarnings("null")
    @GetMapping("/books/{id}")
    public Optional<Book> one(@PathVariable Long id){
        Optional<Book> book = bookRepository.findById(id);

        return book;
    }
    @SuppressWarnings("null")
    @DeleteMapping("books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
      }
}
