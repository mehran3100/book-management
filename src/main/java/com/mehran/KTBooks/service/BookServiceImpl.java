package com.mehran.KTBooks.service;

import com.mehran.KTBooks.entity.Author;
import com.mehran.KTBooks.entity.Book;
import com.mehran.KTBooks.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    final
    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long BookId) {
        return bookRepository.findById(BookId).
                orElseThrow(() -> new EntityNotFoundException("Book not found with id " + BookId));
    }

    @Override
    public List<Book> findBooksByAuthor(Author author) {
        List<Book> books = bookRepository.findByAuthor(author);
        if (books.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }

        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> fetchBookList() {
        return bookRepository.findAll();
    }

    public Book updateBook(Book bookDetails, Long BookId) {
        return bookRepository.findById(BookId)
                .map(existingBook -> {
                    existingBook.setTitle(bookDetails.getTitle());
                    existingBook.setAuthor(bookDetails.getAuthor());
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    @Override
    public void deleteBookById(Long BookId) {
        if (bookRepository.existsById(BookId)) {
            bookRepository.deleteById(BookId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
    }
}
