package com.mehran.KTBooks.models.dto;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;
    private String title;
    private Long authorId;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private int pages;
    private Double price;
    private String language;
    private String description;
    private Long categoryId;
    private String genre;
}
