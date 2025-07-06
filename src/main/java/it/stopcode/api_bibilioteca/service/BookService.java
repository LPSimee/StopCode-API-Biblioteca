package it.stopcode.api_bibilioteca.service;

import it.stopcode.api_bibilioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() { return new ArrayList<>(this.books); }

    public Book getBookById(String id) {
        return this.books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Book addNewBook(Book book) {
        // book.setId(UUID.randomUUID().toString());
        this.books.add(book);
        return book;
    }

    public Book updateBook(String id, Book book) {
        for(int i = 0; i < books.size(); i++) {
            if(this.books.get(i).getId().equals(id)) {
                this.books.set(i, book);
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(String id) {
        return this.books.removeIf(book -> book.getId().equals(id));
    }
}
