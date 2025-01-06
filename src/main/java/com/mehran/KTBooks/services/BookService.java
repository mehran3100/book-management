package com.mehran.KTBooks.services;

import com.mehran.KTBooks.models.entity.Author;
import com.mehran.KTBooks.models.entity.Book;

import java.util.List;

public interface BookService {


    void saveBook(Book Book);

    Book findById(Long BookId);

    List<Book> fetchBookList();

    List<Book> findBooksByAuthor(Author author);

    Book updateBook(Book Book, Long BookId);


    void deleteBookById(Long BookId);

}
