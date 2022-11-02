package me.philopaegmon.eratosthenes_service.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.mapper.BookMapper;
import me.philopaegmon.eratosthenes_service.model.BookDto;
import me.philopaegmon.eratosthenes_service.model.SaveBookDto;
import me.philopaegmon.eratosthenes_service.model.UpdateBookDto;
import me.philopaegmon.eratosthenes_service.persistence.BookRepository;

@ApplicationScoped
public class BookService {
    @Inject
    BookRepository bookRepository;
    @Inject
    BookMapper bookMapper;

    public Uni<BookDto> saveBook(SaveBookDto saveBookDto) {
        return Uni.createFrom().item(saveBookDto)
            .map(bookMapper::fromSaveBookDto)
            .flatMap(bookRepository::save)
            .map(bookMapper::toBookDto);
    }

    public Uni<BookDto> getBookById(Long id) {
        return bookRepository.findById(id)
            .map(bookMapper::toBookDto);
    }

    public Uni<BookDto> updateBook(Long id, UpdateBookDto updateBookDto) {
        return bookRepository.findById(id)
            .map(entity -> bookMapper.fromUpdateBookDto(updateBookDto, entity))
            .flatMap(bookRepository::save)
            .map(bookMapper::toBookDto);
    }
}
