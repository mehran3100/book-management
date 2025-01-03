package com.mehran.KTBooks.repository;

import com.mehran.KTBooks.entity.Author;
import com.mehran.KTBooks.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{


}
