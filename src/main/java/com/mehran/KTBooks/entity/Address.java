package com.mehran.KTBooks.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street; // Street address

    private String city; // City of residence

    private String state; // State or province

    private String postalCode; // Postal or ZIP code

    private String country; // Country of residence

}
