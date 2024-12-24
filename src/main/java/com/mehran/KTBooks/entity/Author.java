package com.mehran.KTBooks.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key

    @Column(nullable = false)
    private String firstName; // Author's first name, required

    @Column(nullable = false)
    private String lastName; // Author's last name, required

    private LocalDate dateOfBirth; // Date of birth

    private String nationality; // Nationality or country of origin

    @Column(length = 1000)
    private String biography; // Brief description of the author's life and works

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    private Contact contact; // Contact information as a separate entity

    @ElementCollection
    @CollectionTable(name = "author_awards", joinColumns = @JoinColumn(name = "author_id"))
    @Column(name = "award")
    private List<String> awards; // List of awards received

    @ElementCollection
    @CollectionTable(name = "author_genres", joinColumns = @JoinColumn(name = "author_id"))
    @Column(name = "genre")
    private List<String> genres; // List of genres the author specializes in

    private Integer publishedBooksCount; // Total number of books published

    // Default constructor
    public Author() {
    }

    // Constructor with required fields
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Integer getPublishedBooksCount() {
        return publishedBooksCount;
    }

    public void setPublishedBooksCount(Integer publishedBooksCount) {
        this.publishedBooksCount = publishedBooksCount;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                ", biography='" + biography + '\'' +
                ", awards=" + awards +
                ", genres=" + genres +
                ", publishedBooksCount=" + publishedBooksCount +
                ", contact=" + contact +
                '}';
    }
}
