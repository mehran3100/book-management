package com.mehran.KTBooks.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String nationality;

    private String biography;

    private ContactDTO contact;

    private List<String> awards;

    private List<String> genres;

    private Integer publishedBooksCount;


}
