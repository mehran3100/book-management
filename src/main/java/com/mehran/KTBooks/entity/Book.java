package com.mehran.KTBooks.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier, auto-incremented by the database

    @Column(nullable = false)
    private String title; // Title of the book

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author; // Author of the book

    @Column(nullable = false, unique = true)
    private String isbn; // ISBN number (unique identifier for books)

    private String publisher; // Publisher of the book

    private LocalDate publicationDate; // Date of publication

    private int pages; // Number of pages

    private Double price; // Price of the book

    private String language; // Language of the book

    @Column(length = 2000)
    private String description; // Brief description or summary of the book

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
