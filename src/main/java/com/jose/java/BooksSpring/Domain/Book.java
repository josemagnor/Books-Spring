package com.jose.java.BooksSpring.Domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    private @Id @GeneratedValue Long id;
    private String title;
    private String author;

    Book () {}
    
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    @Override 
    public boolean equals(Object object){
        if (this == object)
            return true;

        if (!(object instanceof Book))
            return false;

    Book book = (Book) object;
    return Objects.equals(this.id, book.id) && Objects.equals(this.title, book.title)
        && Objects.equals(this.author, book.author);
    }
    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.title, this.author);
    }
  
    @Override
    public String toString() {
      return "Book{" + "id=" + this.id + ", title='" + this.title + '\'' + ", author='" + this.author + '\'' + '}';
    }
}


