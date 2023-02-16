package com.gokhan.renderingbooks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    return "/books/new.jsp";
  }

  // Note: We'll be altering this a bit after we introduce data binding.
@PostMapping("/books")
public String create(
    @RequestParam("title") String title,
    @RequestParam("description") String description,
    @RequestParam("language") String language,
    @RequestParam("pages") Integer pages) 
{
    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
    @GetMapping("/books/new")
    public String newBook(){
      List<Book> books = bookService.newBook();
      model.addAttribute("books", books);
      return "new.jsp";
}
    @PostMapping("/books/new") 
    public String
    Book book = new Book(title, description, language, pages);
    bookService.createBook(book);
    return "redirect:/books";
}


}
