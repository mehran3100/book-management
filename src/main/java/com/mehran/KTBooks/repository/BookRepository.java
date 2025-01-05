package com.mehran.KTBooks.repository;

import com.mehran.KTBooks.models.entity.Author;
import com.mehran.KTBooks.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

    List<Book> findByAuthor(Author author);

}
