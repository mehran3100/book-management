package com.mehran.KTBooks.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;

    private String street;

    private String city;

    private String state;

    private String postalCode;

    private String country;

}
