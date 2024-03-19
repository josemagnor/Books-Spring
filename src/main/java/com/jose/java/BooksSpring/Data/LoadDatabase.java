package com.jose.java.BooksSpring.Data;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jose.java.BooksSpring.Domain.Book;
import com.jose.java.BooksSpring.Repository.BookRepository;


@Configuration
public class LoadDatabase{
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository){
        return args -> {
            log.info("Preloading " + bookRepository.save(new Book("Harry Potter", "JKRowlings")));
        };
    }
}