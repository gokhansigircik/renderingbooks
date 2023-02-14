package com.gokhan.renderingbooks.services;
import java.util.List;
import java.util.Optional;

import com.gokhan.renderingbooks.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokhan.renderingbooks.models.Book;
import com.gokhan.renderingbooks.repositories.BookRepository;

@Service
public class BookService {
    // // adding the book repository as a dependency
    // private final BookRepository bookRepository;
    
    // public BookService(BookRepository bookRepository) {
    //     this.bookRepository = bookRepository;
    // }

    @Autowired
    BookRepository bookRepository;
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}


