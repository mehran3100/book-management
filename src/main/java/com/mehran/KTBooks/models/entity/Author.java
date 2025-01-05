package com.mehran.KTBooks.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

}
