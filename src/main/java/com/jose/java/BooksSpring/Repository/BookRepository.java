package com.jose.java.BooksSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.java.BooksSpring.Domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
