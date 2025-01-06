package com.mehran.KTBooks.services;

import com.mehran.KTBooks.models.entity.Author;

import java.util.List;

public interface AuthorService {


    void saveAuthor(Author author);

    Author findById(Long authorId);

    List<Author> fetchAuthorList();

//    Author updateAuthor(Author Author, Long authorId);

    void deleteAuthorById(Long authorId);

}
