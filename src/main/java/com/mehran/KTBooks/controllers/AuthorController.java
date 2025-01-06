package com.mehran.KTBooks.controllers;

import com.mehran.KTBooks.models.entity.Author;
import com.mehran.KTBooks.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    //todo: set all to services (for simplyfi the code)
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return service.fetchAuthorList();
    }

    @PostMapping
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
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
    public ResponseEntity<Void> deleteAuthorById(@PathVariable("id") Long id) {
        service.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }
    
}
