package me.philopaegmon.eratosthenes_service.mapper;

import java.util.Set;

import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import me.philopaegmon.eratosthenes_service.model.Author;
import me.philopaegmon.eratosthenes_service.model.Book;
import me.philopaegmon.eratosthenes_service.model.Language;
import me.philopaegmon.eratosthenes_service.model.LiteraryGenre;
import me.philopaegmon.eratosthenes_service.model.dto.book.BookDto;
import me.philopaegmon.eratosthenes_service.model.dto.book.SaveBookDto;
import me.philopaegmon.eratosthenes_service.model.dto.book.UpdateBookDto;

@Mapper(
    componentModel = "cdi",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public abstract class BookMapper {

    @Mapping(target="id", ignore = true)
    @Mapping(target = "name", source = "saveBookDto.name")
    public abstract Book fromSaveBookDto(SaveBookDto saveBookDto, Set<Author> authors, Set<LiteraryGenre> genres, Language language);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "updateBookDto.name")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Book fromUpdateBookDto(
        UpdateBookDto updateBookDto,
        Set<Author> authors, Set<LiteraryGenre> genres, Language language,
        @MappingTarget Book book
    );
    
    public abstract BookDto toBookDto(Book book);

    protected abstract BookDto.AuthorDto toAuthorDto(Author author);
}
