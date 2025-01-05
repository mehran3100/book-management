package com.mehran.KTBooks.service;

import com.mehran.KTBooks.models.entity.Category;
import com.mehran.KTBooks.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    final
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void savecategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("category not found with id " + id));
    }

    @Override
    public List<Category> fetchcategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategoryById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found");
        }
    }

//    public category updatecategory(category categoryDetails, Long categoryId) {
//        return categoryRepository.findById(categoryId)
//                .map(existingcategory -> {
//                    existingcategory.setTitle(categoryDetails.getTitle());
//                    existingcategory.setcategory(categoryDetails.getcategory());
//                    return categoryRepository.save(existingcategory);
//                })
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found"));
//    }

}
