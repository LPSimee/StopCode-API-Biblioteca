package it.stopcode.api_bibilioteca.controller;

import it.stopcode.api_bibilioteca.model.Book;
import it.stopcode.api_bibilioteca.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }
}
