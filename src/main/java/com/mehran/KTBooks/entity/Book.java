package com.mehran.KTBooks.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

//todo: fix to work with lombok!!!
@Entity
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

    public Book(Long id, String title, Author author, String isbn, String publisher, LocalDate publicationDate, int pages, Double price, String language, String description, Category category, Genre genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.pages = pages;
        this.price = price;
        this.language = language;
        this.description = description;
        this.category = category;
        this.genre = genre;
    }

    public Book() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +
                ", pages=" + pages +
                ", price=" + price +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", genre=" + genre +
                '}';
    }

}
