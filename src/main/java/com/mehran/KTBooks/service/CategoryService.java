package com.mehran.KTBooks.service;

import com.mehran.KTBooks.entity.Category;

import java.util.List;

public interface CategoryService {


    void savecategory(Category category);

    Category findById(Long id);

    List<Category> fetchcategoryList();

//    category updatecategory(category category, Long categoryId);

    void deleteCategoryById(Long id);

}