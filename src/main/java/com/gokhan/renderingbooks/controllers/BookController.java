package com.gokhan.renderingbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gokhan.renderingbooks.models.Book;
import com.gokhan.renderingbooks.services.BookService;

@Controller
public class BookController {
  @Autowired
  BookService bookService;
  
  @RequestMapping("/books/{id}")
  public String show(@PathVariable("id") Long id, Model model){
    Book book = bookService.findBook(id);
    model.addAttribute("book", book);
    return "show.jsp";
  }

  @RequestMapping("/books")
  public String allbooks(Model model){
    List<Book> books = bookService.allBooks();
    model.addAttribute("books", books);
    return "books.jsp";
  }
}
