package it.stopcode.api_bibilioteca.controller;

import it.stopcode.api_bibilioteca.model.Book;
import it.stopcode.api_bibilioteca.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById (@PathVariable String id) {
        Book book = this.bookService.getBookById(id);

        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(book);
        }
    }

    @PostMapping
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        Book addedBook = this.bookService.addNewBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook (@PathVariable String id, @RequestBody Book book) {
        Book updatedBook = this.bookService.updateBook(id, book);
        if(updatedBook == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedBook);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        boolean deleted = bookService.deleteBook(id);
        if(deleted) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
