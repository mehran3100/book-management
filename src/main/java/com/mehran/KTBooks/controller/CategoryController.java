package com.mehran.KTBooks.controller;

import com.mehran.KTBooks.models.entity.Category;
import com.mehran.KTBooks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    //todo: set all to services (for simplyfi the code)
    @Autowired
    private CategoryService service;

    @GetMapping
    public List<Category> getAllBooks() {
        return service.fetchcategoryList();
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Category category) {
        service.savecategory(category);
        return ResponseEntity.ok("category added: " + category.getId());
    }

    /*@PutMapping("/category/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book bookDetails, @PathVariable Long id) {
        Book updatedBook = service.updateBook(bookDetails, id);
        return ResponseEntity.ok(updatedBook);
    }*/

//todo: set all to id (for simplyfi the code)
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id) {
        service.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
    
}
