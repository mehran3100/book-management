package com.mehran.KTBooks.service;

import com.mehran.KTBooks.entity.Author;
import com.mehran.KTBooks.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    final AuthorRepository AuthorRepository;

    public AuthorServiceImpl(AuthorRepository AuthorRepository) {
        this.AuthorRepository = AuthorRepository;
    }

    @Override
    public void saveAuthor(Author Author) {
        AuthorRepository.save(Author);
    }

    @Override
    public Author findById(Long AuthorId) {
        return AuthorRepository.findById(AuthorId).
                orElseThrow(() -> new EntityNotFoundException("Author not found with id " + AuthorId));
    }

    @Override
    public List<Author> fetchAuthorList() {
        return AuthorRepository.findAll();
    }

//    public Author updateAuthor(Author AuthorDetails, Long AuthorId) {
//        return AuthorRepository.findById(AuthorId)
//                .map(existingAuthor -> {
//                    existingAuthor.setTitle(AuthorDetails.getTitle());
//                    existingAuthor.setAuthor(AuthorDetails.getAuthor());
//                    return AuthorRepository.save(existingAuthor);
//                })
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
//    }

    @Override
    public void deleteAuthorById(Long AuthorId) {
        if (AuthorRepository.existsById(AuthorId)) {
            AuthorRepository.deleteById(AuthorId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }
    }
}
