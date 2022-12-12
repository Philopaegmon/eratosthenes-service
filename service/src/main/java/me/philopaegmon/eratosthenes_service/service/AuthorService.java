package me.philopaegmon.eratosthenes_service.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes.integration.dto.author.AuthorDto;
import me.philopaegmon.eratosthenes.integration.dto.author.CreateAuthorDto;
import me.philopaegmon.eratosthenes.integration.dto.author.UpdateAuthorDto;
import me.philopaegmon.eratosthenes_service.mapper.AuthorMapper;
import me.philopaegmon.eratosthenes_service.persistence.AuthorRepository;

@ApplicationScoped
public class AuthorService {
    
    @Inject
    AuthorRepository authorRepository;
    @Inject
    AuthorMapper authorMapper;

    public Uni<AuthorDto> getAuthorById(Long id) {
        return authorRepository.findAuthorById(id)
            .map(authorMapper::toAuthorDto);
    }

    public Uni<AuthorDto> createAuthor(CreateAuthorDto createAuthorDto) {
        return Uni.createFrom()
            .item(authorMapper.fromCreateAuthorDto(createAuthorDto))
            .flatMap(authorRepository::saveAuthor)
            .map(authorMapper::toAuthorDto);
    }

    public Uni<AuthorDto> updateAuthor(Long id, UpdateAuthorDto updateAuthorDto) {
        return authorRepository.findAuthorById(id)
            .map(author -> authorMapper.fromUpdateAuthorDto(updateAuthorDto, author))
            .flatMap(authorRepository::saveAuthor)
            .map(authorMapper::toAuthorDto);
    }

    public Uni<Void> deleteAuthor(Long id) {
        return authorRepository.deleteById(id)
            .replaceWithVoid();
    }
}
