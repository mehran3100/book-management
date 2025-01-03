package com.mehran.KTBooks.service;

import com.mehran.KTBooks.entity.Author;
import com.mehran.KTBooks.entity.Book;

import java.util.List;

public interface AuthorService {


    void saveAuthor(Author author);

    Author findById(Long authorId);

    List<Author> fetchAuthorList();

//    Author updateAuthor(Author Author, Long authorId);

    void deleteAuthorById(Long authorId);

}
