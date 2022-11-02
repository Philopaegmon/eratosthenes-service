package me.philopaegmon.eratosthenes_service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import me.philopaegmon.eratosthenes_service.model.Book;
import me.philopaegmon.eratosthenes_service.model.BookDto;
import me.philopaegmon.eratosthenes_service.model.SaveBookDto;
import me.philopaegmon.eratosthenes_service.model.UpdateBookDto;

@Mapper(
    componentModel = "cdi",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface BookMapper {
    @Mapping(target="id", ignore = true)
    Book fromSaveBookDto(SaveBookDto saveBookDto);
    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Book fromUpdateBookDto(UpdateBookDto updateBookDto, @MappingTarget Book book);
    BookDto toBookDto(Book book);
}
