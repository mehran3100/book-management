package com.mehran.KTBooks.controllers;

import com.mehran.KTBooks.models.entity.Category;
import com.mehran.KTBooks.services.CategoryService;
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
    public List<Category> getAllCategories() {
        return service.fetchcategoryList();
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        service.savecategory(category);
        return ResponseEntity.ok("category added: " + category.getId());
    }

    /*@PutMapping("/category/{id}")
    public ResponseEntity<Book> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        Category updatedCategory = service.updateBook(category, id);
        return ResponseEntity.ok(updatedCategory);
    }*/

//todo: set all to id (for simplyfi the code)
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable("id") Long id) {
        service.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
    
}
