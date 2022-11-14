package me.philopaegmon.eratosthenes_service.service;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.mapper.BookMapper;
import me.philopaegmon.eratosthenes_service.model.BookDto;
import me.philopaegmon.eratosthenes_service.model.SaveBookDto;
import me.philopaegmon.eratosthenes_service.model.UpdateBookDto;
import me.philopaegmon.eratosthenes_service.persistence.AuthorRepository;
import me.philopaegmon.eratosthenes_service.persistence.BookRepository;
import me.philopaegmon.eratosthenes_service.persistence.LanguageRepository;
import me.philopaegmon.eratosthenes_service.persistence.LiteraryGenreRepository;

@ApplicationScoped
public class BookService {
    @Inject
    BookRepository bookRepository;
    @Inject
    AuthorRepository authorRepository;
    @Inject
    LiteraryGenreRepository literaryGenrerRepository;
    @Inject
    LanguageRepository languageRepository;
    
    @Inject
    BookMapper bookMapper;

    public Uni<BookDto> getBookById(Long id) {
        return bookRepository.findById(id)
            .map(bookMapper::toBookDto);
    }

    public Uni<BookDto> saveBook(SaveBookDto saveBookDto) {
        return Uni.createFrom().item(saveBookDto)
            .flatMap(dto -> 
                Uni.combine().all()
                    .unis(
                        authorRepository.findAuthorsByIds(saveBookDto.getAuthorIds()),
                        literaryGenrerRepository.findLiteraryGenresByIds(saveBookDto.getAuthorIds()),
                        languageRepository.findLanguageById(saveBookDto.getLanguageId())
                    )
                    .asTuple()
                    .map(tuple -> 
                        bookMapper.fromSaveBookDto(
                            saveBookDto,
                            Set.copyOf(tuple.getItem1()), Set.copyOf(tuple.getItem2()), tuple.getItem3()
                        )
                    )
            )
            .flatMap(bookRepository::saveBook)
            .map(bookMapper::toBookDto);
    }

    public Uni<BookDto> updateBook(Long id, UpdateBookDto updateBookDto) {
        return bookRepository.findById(id)
            .flatMap(entity -> 
                    Uni.combine().all()
                    .unis(
                        authorRepository.findAuthorsByIds(updateBookDto.getAuthorIds()),
                        literaryGenrerRepository.findLiteraryGenresByIds(updateBookDto.getAuthorIds()),
                        languageRepository.findLanguageById(updateBookDto.getLanguageId())
                    )
                    .asTuple()
                    .map(tuple -> 
                        bookMapper.fromUpdateBookDto(
                            updateBookDto,
                            Set.copyOf(tuple.getItem1()), Set.copyOf(tuple.getItem2()), tuple.getItem3(),
                            entity
                        )
                    )
            )
            .flatMap(bookRepository::saveBook)
            .map(bookMapper::toBookDto);
    }

    public Uni<Void> deleteById(Long id) {
        return bookRepository.deleteById(id).replaceWithVoid();
    }
}
