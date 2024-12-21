package com.mehran.KTBooks.service;

import com.mehran.KTBooks.entity.Book;

import java.util.List;

public interface BookService {


    Book saveBook(Book Book);

    Book findById(Long BookId);

    List<Book> fetchBookList();

    List<Book> findBooksByAuthor(String author);

    Book updateBook(Book Book, Long BookId);


    void deleteBookById(Long BookId);

}
