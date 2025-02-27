package com.mehran.KTBooks.controllers;

import com.mehran.KTBooks.models.entity.Author;
import com.mehran.KTBooks.models.entity.Book;
import com.mehran.KTBooks.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.fetchBookList();
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return ResponseEntity.ok("Book added: " + book.getTitle());
    }

    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable Author author) {
        return bookService.findBooksByAuthor(author);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book bookDetails, @PathVariable Long id) {
        Book updatedBook = bookService.updateBook(bookDetails, id);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long bookId) {
        bookService.deleteBookById(bookId);
        return ResponseEntity.noContent().build();
    }

}
