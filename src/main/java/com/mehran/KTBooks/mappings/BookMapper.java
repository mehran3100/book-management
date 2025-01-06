package com.mehran.KTBooks.mappings;

import com.mehran.KTBooks.models.dto.BookDTO;
import com.mehran.KTBooks.models.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // This will allow Spring to automatically inject the Mapper
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId") // Map Author's ID to authorId in BookDTO
    @Mapping(source = "category.id", target = "categoryId") // Map Category's ID to categoryId in BookDTO
    @Mapping(source = "genre", target = "genre") // Map the Genre enum to a string in BookDTO
    BookDTO toDTO(Book book);

    @Mapping(source = "authorId", target = "author.id") // Map authorId in BookDTO to Author's ID
    @Mapping(source = "categoryId", target = "category.id") // Map categoryId in BookDTO to Category's ID
    @Mapping(source = "genre", target = "genre") // Map Genre string back to the Genre enum
    Book toEntity(BookDTO bookDTO);
}
