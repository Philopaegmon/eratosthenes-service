package me.philopaegmon.eratosthenes_service.mapper;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import me.philopaegmon.eratosthenes_service.model.Author;
import me.philopaegmon.eratosthenes_service.model.Book;
import me.philopaegmon.eratosthenes_service.model.dto.author.AuthorDto;
import me.philopaegmon.eratosthenes_service.model.dto.author.CreateAuthorDto;
import me.philopaegmon.eratosthenes_service.model.dto.author.UpdateAuthorDto;

@Mapper(
    componentModel = "cdi",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface AuthorMapper {
    
    AuthorDto toAuthorDto(Author author);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Author fromCreateAuthorDto(CreateAuthorDto createAuthorDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Author fromUpdateAuthorDto(UpdateAuthorDto updateAuthorDto, @MappingTarget Author author);

    AuthorDto.BookDto toBookDto(Book book);

    default Set<AuthorDto.BookDto> toBookDtoSet(Set<Book> bookSet) {
        return Optional.ofNullable(bookSet)
            .map(Set::stream)
            .map(stream -> 
                stream.map(this::toBookDto)
                    .collect(Collectors.toSet())
            )
            .orElse(Collections.<AuthorDto.BookDto>emptySet());
    }
}
