package com.mehran.KTBooks.repository;

import com.mehran.KTBooks.entity.Author;
import com.mehran.KTBooks.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{


}
