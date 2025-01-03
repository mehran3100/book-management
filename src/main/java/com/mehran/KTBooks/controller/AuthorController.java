package com.mehran.KTBooks.controller;

import com.mehran.KTBooks.entity.Author;
import com.mehran.KTBooks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    //todo: set all to services (for simplyfi the code)
    @Autowired
    private AuthorService service;

    @GetMapping
    public List<Author> getAllBooks() {
        return service.fetchAuthorList();
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Author author) {
        service.saveAuthor(author);
        return ResponseEntity.ok("Author added: " + author.getId());
    }

    /*@PutMapping("/author/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book bookDetails, @PathVariable Long id) {
        Book updatedBook = service.updateBook(bookDetails, id);
        return ResponseEntity.ok(updatedBook);
    }*/

//todo: set all to id (for simplyfi the code)
    @DeleteMapping("/author/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id) {
        service.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }
    
}
